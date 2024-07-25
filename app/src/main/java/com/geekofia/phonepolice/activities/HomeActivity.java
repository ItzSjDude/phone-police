package com.geekofia.phonepolice.activities;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.geekofia.phonepolice.CardAdapter;
import com.geekofia.phonepolice.R;
import com.geekofia.phonepolice.models.CardItem;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    private RecyclerView recyclerView;
    private CardAdapter cardAdapter;
    private List<CardItem> cardItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.drawer_layout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2)); // 2 columns

        cardItemList = new ArrayList<>();
        // Add card items to the list
        cardItemList.add(new CardItem("Intruder Alert", R.drawable.ic_intruder));
        cardItemList.add(new CardItem("Anti Touch Detection", R.drawable.ic_anti_touch));
        cardItemList.add(new CardItem("Wrong Password Alert", R.drawable.ic_wrong_password));
        cardItemList.add(new CardItem("Charging Removal Alert", R.drawable.ic_charging_removal));
        cardItemList.add(new CardItem("Full Battery Alert", R.drawable.ic_full_battery));
        cardItemList.add(new CardItem("Pocket Alarm", R.drawable.ic_pocket_alarm));
        cardItemList.add(new CardItem("Pocket Alarm", R.drawable.ic_pocket_alarm));
        cardItemList.add(new CardItem("Pocket Alarm", R.drawable.ic_pocket_alarm));
        cardItemList.add(new CardItem("Pocket Alarm", R.drawable.ic_pocket_alarm));

        cardAdapter = new CardAdapter(this, cardItemList);
        recyclerView.setAdapter(cardAdapter);
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
}