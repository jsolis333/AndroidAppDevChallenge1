package com.example.solis.randomactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by Solis on 4/24/2018.
 * for Second Screen
 */

public class NextActivity extends MainActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        playButtonB = findViewById(R.id.bt_BButton);
        viewA = findViewById(R.id.tv_randomNumberB);

         //this will get the value that was entered on MainActiviyt for the TextView in This activity
        String s = getIntent().getStringExtra("TextValueB");
        viewA.setText(s);

        //use this to switch between activities.
        final   Intent i = new Intent(getApplicationContext(), MainActivity.class);

        //this will be played once the button b is clicked.
        playButtonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //makes a new random number when the button is clicked.
                Random randomNumberGeneratorB = new Random();
                Toast.makeText(getApplicationContext(), "Activity button B is pressed", Toast.LENGTH_SHORT).show();

                //notifies the user the button is preseed.
                Integer numberA = randomNumberGeneratorB.nextInt(100-50) + 50;

                //this is putting the data to be set on the next activity
                i.putExtra("TextValueA", "Random Number is " +numberA);
                startActivity(i);

            }
        });
    }
}
