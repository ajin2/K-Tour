package com.example.hanaj.k_tour;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.hanaj.k_tour.R;

import java.util.ArrayList;

public class Main_View extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);
    }
}