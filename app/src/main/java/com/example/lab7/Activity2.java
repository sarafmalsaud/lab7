package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    final int BikeP = 100;
    final int CarP = 300;
    final int JeepP = 800;
    int price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        ImageView img  = (ImageView) findViewById(R.id.imageView4);
        TextView result  = (TextView) findViewById(R.id.txtPrice);
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);

        int p = sp.getInt("ppl",0);
        int d = sp.getInt("day",0);

        if(p<=2){
            price = BikeP*d;
            img.setImageResource(R.drawable.bike);
            result.setText("Total price is: $"+price);
        }
        else if(p == 3 || p == 4){
            price = CarP*d;
            img.setImageResource(R.drawable.car2);
            result.setText("Total price is: $"+price);
        }
        else if(p>4){
            price = JeepP*d;
            img.setImageResource(R.drawable.jeep);
            result.setText("Total price is: $"+price);
        }

    }
}


