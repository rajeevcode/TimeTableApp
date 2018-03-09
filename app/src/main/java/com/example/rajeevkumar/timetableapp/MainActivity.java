package com.example.rajeevkumar.timetableapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import java.util.ArrayList;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    ListView timesTableListView;

    public void generateTimesTable(int timesTable) {

        //int timesTable = 10;

        ArrayList<String> timesTableContent = new ArrayList<String>();

        for (int i = 1; i <= 10; i++) {

            timesTableContent.add(Integer.toString(i * timesTable));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timesTableContent);

        timesTableListView.setAdapter(arrayAdapter);

    }
    public void fade(View view) {

        ImageView motu = (ImageView) findViewById(R.id.motu);

       // motu.animate().scaleXBy(0.2f).scaleYBy(0.2f).setDuration(2000);

        motu.animate().translationXBy(1000f).translationYBy(1000f).rotationBy(3600).setDuration(3600);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar timesTableSeekbar = (SeekBar) findViewById(R.id.timesTableSeekBar);

        timesTableListView =(ListView)findViewById(R.id.timeTableListView);

        timesTableSeekbar.setMax(20);
        timesTableSeekbar.setProgress(10);

        timesTableSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                int min = 1;
                int timesTable;

                if (progress < min) {

                    timesTable = min;
                    timesTableSeekbar.setProgress(min);

                } else {

                    timesTable = progress;
                }

                Log.i("Seekbar Value", Integer.toString(timesTable));
                generateTimesTable(timesTable);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}
