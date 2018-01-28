package com.example.android.worldtourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.worldtourguide.usa.GrandCanyonUSAActivity;
import com.example.android.worldtourguide.usa.RushMoreUSAActivity;
import com.example.android.worldtourguide.usa.StatueofLibertyUSAActivity;
import com.example.android.worldtourguide.usa.YosemiteUSAActivity;

import java.util.ArrayList;

public class USAActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countrylist);

        // Create an ArrayList of TourismCountry objects
        ArrayList<TourismCountry> tourisminCountry = new ArrayList<>();
        tourisminCountry.add(new TourismCountry(getString(R.string.title_statue), getString(R.string.sub_title_statue), R.drawable.statue));
        tourisminCountry.add(new TourismCountry(getString(R.string.title_canyon), getString(R.string.sub_title_canyon), R.drawable.grand_canyon));
        tourisminCountry.add(new TourismCountry(getString(R.string.title_yosemite), getString(R.string.sub_title_yosemite), R.drawable.yosemite));
        tourisminCountry.add(new TourismCountry(getString(R.string.title_rushmore), getString(R.string.sub_title_rushmore), R.drawable.rushmore));

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
                        Intent liberty = new Intent(USAActivity.this, StatueofLibertyUSAActivity.class);
                        listView.getContext().startActivity(liberty);
                        break;
                    case 1:
                        Intent grand = new Intent(USAActivity.this, GrandCanyonUSAActivity.class);
                        listView.getContext().startActivity(grand);
                        break;
                    case 2:
                        Intent yosemite = new Intent(USAActivity.this, YosemiteUSAActivity.class);
                        listView.getContext().startActivity(yosemite);
                        break;
                    case 3:
                        Intent rushmore = new Intent(USAActivity.this, RushMoreUSAActivity.class);
                        listView.getContext().startActivity(rushmore);
                        break;
                }

            }

        });

    }
}
