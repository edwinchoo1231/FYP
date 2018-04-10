package com.example.edwin.realtimefb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realtime);
    }

    public void onRealtimeActivity(android.view.View view) {
        Intent intent = new Intent(this, RealtimeActivity.class);
        startActivity(intent);
    }


}
