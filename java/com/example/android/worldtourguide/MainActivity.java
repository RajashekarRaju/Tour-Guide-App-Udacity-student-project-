package com.example.android.worldtourguide;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private List<Country> countryList;
    View view;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        countryList = new ArrayList<>();
        CountryAdapter adapter = new CountryAdapter(this, countryList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        prepareCountry();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_share) {

            // Handle the share action
            final String appPackageName = getPackageName();
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.check_out_app) + appPackageName);
            sendIntent.setType(getString(R.string.tex_plain));
            startActivity(sendIntent);

        } else if (id == R.id.nav_about) {

            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle(R.string.description);
            alert.setMessage(R.string.dialogue);
            final TextView input = new TextView(this);
            alert.setView(input);

            alert.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                @SuppressLint("SetTextI18n")
                public void onClick(DialogInterface dialog, int whichButton) {
                    input.setText(R.string.ok);
                }
            });
            alert.show();

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void prepareCountry() {
        int[] places = new int[]{
                R.drawable.taj_mahal,
                R.drawable.colosseum,
                R.drawable.wall,
                R.drawable.grand_canyon,
                R.drawable.barcelona,
                R.drawable.eiffel};

        Country place = new Country(getString(R.string.card_text_india), 40, places[0]);
        countryList.add(place);

        place = new Country(getString(R.string.card_text_italy), 8, places[1]);
        countryList.add(place);

        place = new Country(getString(R.string.card_text_china), 15, places[2]);
        countryList.add(place);

        place = new Country(getString(R.string.card_text_usa), 6, places[3]);
        countryList.add(place);

        place = new Country(getString(R.string.card_text_spain), 1, places[4]);
        countryList.add(place);

        place = new Country(getString(R.string.card_text_france), 2, places[5]);
        countryList.add(place);
    }

}