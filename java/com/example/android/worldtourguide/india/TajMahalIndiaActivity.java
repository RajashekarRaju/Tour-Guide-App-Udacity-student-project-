package com.example.android.worldtourguide.india;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.android.worldtourguide.AndroidImageAdapter;
import com.example.android.worldtourguide.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;


public class TajMahalIndiaActivity extends AppCompatActivity {

    @SuppressLint("StaticFieldLeak")
    private static ViewPager mPager;
    private static int currentPage = 0;
    private static final Integer[] Taj = {
            R.drawable.wall5,
            R.drawable.wall4,
            R.drawable.wall3,
            R.drawable.wall2,
            R.drawable.wall1};
    private ArrayList<Integer> TajArray = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tajmahal);
        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        // Enable the Up button
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);

            init();

            FloatingActionButton mapView = findViewById(R.id.map_view);
            mapView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String uri = String.format(Locale.ENGLISH, getString(R.string.geo_format), 27.174952, 78.042891);
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                    startActivity(intent);
                }

            });
        }
    }

    private void init() {
        TajArray.addAll(Arrays.asList(Taj));

        mPager = findViewById(R.id.pager);
        mPager.setAdapter(new AndroidImageAdapter(TajMahalIndiaActivity.this, TajArray));
        CircleIndicator indicator = findViewById(R.id.indicator);
        indicator.setViewPager(mPager);

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == Taj.length) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 2500, 2500);
    }
}
