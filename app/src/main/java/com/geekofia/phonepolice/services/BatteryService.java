package com.geekofia.phonepolice.services;

import static android.content.pm.ServiceInfo.FOREGROUND_SERVICE_TYPE_MEDIA_PLAYBACK;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import com.geekofia.phonepolice.R;
import com.geekofia.phonepolice.activities.HomeActivity;


public class BatteryService extends Service {
    private static final String CHANNEL_ID = "BATTERY_BACKGROUND_SERVICE";
    private MediaPlayer mediaPlayer;
    private final BroadcastReceiver batteryBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int level = intent.getIntExtra("level", -1);
            int scale = intent.getIntExtra("scale", -1);
            float batteryPct = level / (float) scale * 100;

            Log.d("ForegroundService", "Battery level: " + batteryPct);

            if (batteryPct >= 100) {
                if (mediaPlayer == null) {
                    mediaPlayer = MediaPlayer.create(BatteryService.this, R.raw.tone1);
                }
                if (!mediaPlayer.isPlaying()) {
                    mediaPlayer.start();
                }
            } else {
                if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                }
            }
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        // init media player
        mediaPlayer = MediaPlayer.create(this, R.raw.tone1);
        mediaPlayer.setLooping(true);
        mediaPlayer.setVolume(100.0f, 100.0f);

        // set up the notification
        createNotificationChannel();
        Notification notification = createNotification();

        // Register the BroadcastReceiver for battery changes
        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(batteryBroadcastReceiver, filter);

        // start foreground service
        int SERVICE_ID = 2;

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {
            startForeground(SERVICE_ID, notification);
        } else {
            startForeground(SERVICE_ID, notification, FOREGROUND_SERVICE_TYPE_MEDIA_PLAYBACK);
        }
    }

    @Override
    public int onStartCommand(Intent intent, int i, int i2) {
        return Service.START_STICKY;
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel serviceChannel = new NotificationChannel(
                    CHANNEL_ID,
                    "Battery Foreground Service Channel",
                    NotificationManager.IMPORTANCE_HIGH
            );
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(serviceChannel);
        }
    }

    private Notification createNotification() {
        Intent notificationIntent = new Intent(this, HomeActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_IMMUTABLE);

        return new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("Audio Playing")
                .setContentText("Your audio is playing in the background.")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(pendingIntent)
                .setOngoing(true)
                .build();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        unregisterReceiver(batteryBroadcastReceiver);
    }
}
