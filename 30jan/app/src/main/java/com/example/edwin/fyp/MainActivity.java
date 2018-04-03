package com.example.edwin.fyp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;

import com.q42.android.scrollingimageview.ScrollingImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // scrolling for image 'van'
        ScrollingImageView scrollingBackground = findViewById(R.id.scrolling_background);
        scrollingBackground.start();

        //to stop use below code
        //scrollingBackground.stop();
    }

    public void onSignIn(View view) {
        Intent intent = new Intent(this, LoginActivitySample.class);
        startActivity(intent);
    }

    public void onSignUp(View view) {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

}
