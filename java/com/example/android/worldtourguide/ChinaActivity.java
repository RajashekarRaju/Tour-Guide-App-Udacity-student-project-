package com.example.android.worldtourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.worldtourguide.china.ForbiddenChinaActivity;
import com.example.android.worldtourguide.china.PotalaPalaceChinaActivity;
import com.example.android.worldtourguide.china.TerracottaChinaAcivity;
import com.example.android.worldtourguide.china.WallChinaActivity;

import java.util.ArrayList;

public class ChinaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countrylist);

        // Create an ArrayList of TourismCountry objects
        ArrayList<TourismCountry> tourisminCountry = new ArrayList<>();
        tourisminCountry.add(new TourismCountry(getString(R.string.title_wall), getString(R.string.sub_title_wall), R.drawable.wall));
        tourisminCountry.add(new TourismCountry(getString(R.string.title_potala), getString(R.string.sub_title_potala), R.drawable.potala));
        tourisminCountry.add(new TourismCountry(getString(R.string.title_terracotta), getString(R.string.sub_title_terracotta), R.drawable.terracotta));
        tourisminCountry.add(new TourismCountry(getString(R.string.title_forbidden), getString(R.string.sub_title_forbidden), R.drawable.forbidden));

        // Create an {@link TourismCountryAdapter}, whose data source is a list of
        // {@link TourismCountry}s. The adapter knows how to create list item views for each item
        // in the list.
        TourismCountryAdapter tourismCountryAdapter = new TourismCountryAdapter(this, tourisminCountry);

        // Get a reference to the ListView, and attach the adapter to the listView.
        final ListView listView = findViewById(R.id.listview_places);
        listView.setAdapter(tourismCountryAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        Intent wall = new Intent(ChinaActivity.this, WallChinaActivity.class);
                        listView.getContext().startActivity(wall);
                        break;
                    case 1:
                        Intent potala = new Intent(ChinaActivity.this, PotalaPalaceChinaActivity.class);
                        listView.getContext().startActivity(potala);
                        break;
                    case 2:
                        Intent terracotta = new Intent(ChinaActivity.this, TerracottaChinaAcivity.class);
                        listView.getContext().startActivity(terracotta);
                        break;
                    case 3:
                        Intent forbidden = new Intent(ChinaActivity.this, ForbiddenChinaActivity.class);
                        listView.getContext().startActivity(forbidden);
                        break;
                }

            }

        });

    }
}