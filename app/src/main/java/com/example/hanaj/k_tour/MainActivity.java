package com.example.hanaj.k_tour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hanaj.k_tour.common.Network.Sample.NetworkTestActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.launcher_layout);


        Button networkTestBtn = (Button)findViewById(R.id.network_test_btn);
        networkTestBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NetworkTestActivity.class);
                startActivity(intent);
            }
        });
    }


}
