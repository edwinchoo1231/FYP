package com.example.edwin.realtimefb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void onLogOut(android.view.View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
