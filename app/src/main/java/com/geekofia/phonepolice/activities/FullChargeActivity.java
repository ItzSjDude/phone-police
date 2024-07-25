package com.geekofia.phonepolice.activities;

import android.os.Bundle;

import com.geekofia.phonepolice.R;
import com.geekofia.phonepolice.databinding.ActivityFullChargeBinding;

public class FullChargeActivity extends BaseActivity {
    ActivityFullChargeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = ActivityFullChargeBinding.inflate(getLayoutInflater());
        setContentView(this.binding.getRoot());

        // Set the toolbar title
        setToolbarTitle("Other Activity");
    }
}