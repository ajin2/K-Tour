package com.example.hanaj.k_tour;

import android.content.Intent;
import android.os.Handler;
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

        // 핸들러를 사용한 일정 시간이 흐른 후 화면 전환 = java 의 timer 기능.
        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this, Main_View.class);
                // ~~.this가 현재 activity,
                // ~~.class가 이동할 activity
                startActivity(i);
                finish();
            }
        }, 3000); // 3000ms

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
