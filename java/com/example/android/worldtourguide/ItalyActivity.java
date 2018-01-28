package com.example.android.worldtourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.worldtourguide.italy.AmalfiItalyActivity;
import com.example.android.worldtourguide.italy.ColosseumItalyActivity;
import com.example.android.worldtourguide.italy.PiazzaItalyActivity;
import com.example.android.worldtourguide.italy.PisaItalyActivity;

import java.util.ArrayList;

public class ItalyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countrylist);

        // Create an ArrayList of TourismCountry objects
        ArrayList<TourismCountry> tourisminCountry = new ArrayList<>();
        tourisminCountry.add(new TourismCountry(getString(R.string.title_colosseum), getString(R.string.sub_title_colosseum), R.drawable.colosseum));
        tourisminCountry.add(new TourismCountry(getString(R.string.title_leaning), getString(R.string.sub_title_leaning), R.drawable.pisa));
        tourisminCountry.add(new TourismCountry(getString(R.string.title_amalfi), getString(R.string.sub_title_amalfi), R.drawable.amalfi));
        tourisminCountry.add(new TourismCountry(getString(R.string.title_piazza), getString(R.string.sub_title_piazza), R.drawable.piazza));

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
                        Intent colosseum = new Intent(ItalyActivity.this, ColosseumItalyActivity.class);
                        listView.getContext().startActivity(colosseum);
                        break;
                    case 1:
                        Intent pisa = new Intent(ItalyActivity.this, PisaItalyActivity.class);
                        listView.getContext().startActivity(pisa);
                        break;
                    case 2:
                        Intent amalfi = new Intent(ItalyActivity.this, AmalfiItalyActivity.class);
                        listView.getContext().startActivity(amalfi);
                        break;
                    case 3:
                        Intent piazza = new Intent(ItalyActivity.this, PiazzaItalyActivity.class);
                        listView.getContext().startActivity(piazza);
                        break;
                }

            }

        });

    }
}