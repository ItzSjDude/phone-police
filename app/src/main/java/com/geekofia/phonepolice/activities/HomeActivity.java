package com.geekofia.phonepolice.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.geekofia.phonepolice.adapters.CardAdapter;
import com.geekofia.phonepolice.R;
import com.geekofia.phonepolice.databinding.ActivityHomeBinding;
import com.geekofia.phonepolice.models.CardItem;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private ActivityHomeBinding binding;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private RecyclerView recyclerView;
    private CardAdapter cardAdapter;
    private List<CardItem> cardItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(binding.toolbar);

        drawerLayout = binding.drawerLayout;
        navigationView = binding.navigationView;
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        binding.recyclerView.setLayoutManager(new GridLayoutManager(this, 2)); // 2 columns

        cardItemList = new ArrayList<>();
        // Add card items to the list
        cardItemList.add(new CardItem("Intruder Alert", R.drawable.ic_intruder, R.drawable.bg_intruder_card));
        cardItemList.add(new CardItem("Anti Touch Detection", R.drawable.ic_anti_touch, R.drawable.bg_anti_touch_card));
        cardItemList.add(new CardItem("Wrong Password Alert", R.drawable.ic_wrong_password, R.drawable.bg_wrong_pass));
        cardItemList.add(new CardItem("Charging Removal Alert", R.drawable.ic_charging_removal, R.drawable.bg_charger_removal_card));
        cardItemList.add(new CardItem("Full Battery Alert", R.drawable.ic_full_battery, R.drawable.bg_battery_full_card));
        cardItemList.add(new CardItem("Pocket Alarm", R.drawable.ic_pocket_alarm, R.drawable.bg_pocket_alarm));

        cardAdapter = new CardAdapter(this, cardItemList);
        binding.recyclerView.setAdapter(cardAdapter);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int itemId = item.getItemId();

        if (itemId == R.id.nav_home) {// Handle home action
        } else if (itemId == R.id.nav_account) {// Handle profile action
        } else if (itemId == R.id.nav_logout) {// Handle settings action
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}