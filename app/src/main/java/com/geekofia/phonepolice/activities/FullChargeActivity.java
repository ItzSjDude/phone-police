package com.geekofia.phonepolice.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.geekofia.phonepolice.databinding.ActivityFullChargeBinding;

public class FullChargeActivity extends AppCompatActivity {
    private ActivityFullChargeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFullChargeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbarFullCharge;
        toolbar.setTitle("Battery Full Alert");
        setSupportActionBar(toolbar);
    }
}