package com.geekofia.phonepolice.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;

import com.geekofia.phonepolice.R;
import com.geekofia.phonepolice.databinding.ActivityFullChargeBinding;

public class FullChargeActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {
    private ActivityFullChargeBinding binding;
    private static final String SWITCH_KEY = "full_battery_alert";
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFullChargeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbarFullCharge;
        toolbar.setTitle("Battery Full Alert");
        setSupportActionBar(toolbar);

        // Enable the Up button
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        // Load the preference fragment
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.preference_container, new ActivityFullChargeSettingsFragment())
                .commit();

        // Get the default shared preferences
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        // Register the preference change listener
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);

        // Check the current state of the switch preference
        updateToggleState(sharedPreferences.getBoolean(SWITCH_KEY, false));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle toolbar back button click
        if (item.getItemId() == android.R.id.home) {
            finish(); // Close this activity and return to previous
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, @Nullable String key) {
        if (SWITCH_KEY.equals(key)) {
            // Handle the change in the switch preference
            boolean isEnabled = sharedPreferences.getBoolean(SWITCH_KEY, false);
            updateToggleState(isEnabled);
        }
    }

    private void updateToggleState(boolean isEnabled) {
        // Perform actions based on the toggle state
        if (isEnabled) {
            // Logic when the switch is enabled
            Toast.makeText(this, "Feature enabled", Toast.LENGTH_SHORT).show();
        } else {
            // Logic when the switch is disabled
            Toast.makeText(this, "Feature disabled", Toast.LENGTH_SHORT).show();
        }
    }

    public static class ActivityFullChargeSettingsFragment extends PreferenceFragmentCompat {

        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.preferences_activity_full_charge, rootKey);
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Unregister the preference change listener to avoid memory leaks
        sharedPreferences.unregisterOnSharedPreferenceChangeListener(this);
    }
}