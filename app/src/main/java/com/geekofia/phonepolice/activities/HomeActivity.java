package com.geekofia.phonepolice.activities;

import android.os.Bundle;

import androidx.recyclerview.widget.GridLayoutManager;

import com.geekofia.phonepolice.adapters.SafetyFeatureCardAdapter;
import com.geekofia.phonepolice.R;
import com.geekofia.phonepolice.databinding.ActivityHomeBinding;
import com.geekofia.phonepolice.models.SafetyFeatureCardItem;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.geekofia.phonepolice.databinding.ActivityHomeBinding binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setToolbarTitle("Home");

        binding.recyclerView.setLayoutManager(new GridLayoutManager(this, 2)); // 2 columns

        List<SafetyFeatureCardItem> safetyFeatureCardItemList = new ArrayList<>();
        // Add card items to the list
        safetyFeatureCardItemList.add(new SafetyFeatureCardItem("Intruder Alert", R.drawable.ic_intruder, null));
        safetyFeatureCardItemList.add(new SafetyFeatureCardItem("Anti Touch Detection", R.drawable.ic_anti_touch, null));
        safetyFeatureCardItemList.add(new SafetyFeatureCardItem("Wrong Password Alert", R.drawable.ic_wrong_password, null));
        safetyFeatureCardItemList.add(new SafetyFeatureCardItem("Charging Removal Alert", R.drawable.ic_charging_removal, null));
        safetyFeatureCardItemList.add(new SafetyFeatureCardItem("Full Battery Alert", R.drawable.ic_full_battery, FullChargeActivity.class));
        safetyFeatureCardItemList.add(new SafetyFeatureCardItem("Pocket Alarm", R.drawable.ic_pocket_alarm, null));

        SafetyFeatureCardAdapter safetyFeatureCardAdapter = new SafetyFeatureCardAdapter(this, safetyFeatureCardItemList);
        binding.recyclerView.setAdapter(safetyFeatureCardAdapter);
    }
}