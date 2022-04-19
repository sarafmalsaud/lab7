package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText people = (EditText) findViewById(R.id.personNum);
        final EditText days = (EditText) findViewById(R.id.daysNum);
        final EditText valid = (EditText) findViewById(R.id.licenseNum);
        final Button bttnV = (Button) findViewById(R.id.bttnView);
        final SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        bttnV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int val = Integer.parseInt(valid.getText().toString());
                if(val<1){
                    Toast.makeText(MainActivity.this,"Your driving license will expire soon. "+
                            "Please renew it first then visit us back",Toast.LENGTH_LONG).show();
                    return;
                }
                int pplNum = Integer.parseInt(people.getText().toString());
                int daysNum = Integer.parseInt(days.getText().toString());
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt("ppl",pplNum);
                editor.putInt("day",daysNum);
                editor.commit();
                startActivity(new Intent(MainActivity.this,Activity2.class));
            }
        });
    }
}