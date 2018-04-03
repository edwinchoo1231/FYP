package com.example.edwin.beeradviser;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private BeerExpert expert = new BeerExpert();

    public void onClickFindBeer (View view) {
        TextView brands = findViewById(R.id.textView);
        Spinner color = findViewById(R.id.spinner);
        String beerType = String.valueOf(color.getSelectedItem());
        brands.setText(beerType);

        List<String> brandsList = expert.getBrands(beerType);
        StringBuilder brandsFormatted = new StringBuilder();
        for (String brand:brandsList){
            brandsFormatted.append(brand).append("\n");
        }

        brands.setText(brandsFormatted);
    }

    public void onClickCheckout(View view) {
        //EditText messageView = findViewById(R.id.message);
        //String messageText = messageView.getText().toString();

        TextView brands = findViewById(R.id.textView);
        StringBuilder brandsFormatted = new StringBuilder();
        for (String brand:brandsList){
            brandsFormatted.append(brand).append("\n");
        }
        brands.setText(brandsFormatted);
        Intent intent = new Intent(this, CheckoutActivity.class);
        intent.putExtra(CheckoutActivity.EXTRA_MESSAGE,brands);
        startActivity(intent);
    }
}
