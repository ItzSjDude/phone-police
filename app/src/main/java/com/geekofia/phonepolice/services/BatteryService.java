package com.geekofia.phonepolice.services;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

import com.geekofia.phonepolice.R;

public class BatteryService extends Service {
    private static final String NOTIFY_CHANNEL_ID = "BATTERY_BACKGROUND_SERVICE";
    private BroadcastReceiver receiver;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
//        this.dbHelper = new DbHelper(this);
//        setRingtone();
//        startForeground();
    }

//    @Override
//    public int onStartCommand(Intent intent, int i, int i2) {
//        createChargerBroadcast();
//        return Service.START_STICKY;
//    }
//
//    public void setRingtone() {
//        int tone = this.dbHelper.getTone();
//        switch (tone) {
//            case 1:
//                Constants.mp = MediaPlayer.create(this, (int) R.raw.tone1);
//                Constants.mp.setLooping(true);
//                Constants.mp.setVolume(100.0f, 100.0f);
//        }
//    }
}
