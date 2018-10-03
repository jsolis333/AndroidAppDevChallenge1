package com.example.solis.randomactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button playButtonA;
    Button playButtonB;

    TextView viewA;
    TextView viewB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playButtonA = findViewById(R.id.bt_AButton);
        viewB = findViewById(R.id.tv_randomNumberA);

        String sA = getIntent().getStringExtra("TextValueA");
        viewB.setText(sA);

        //use this to switch between activities.
        final Intent iA = new Intent(getApplicationContext(),NextActivity.class);

        playButtonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //makes new random number when the button is clicked.
                Random randomNumberGeneratorA = new Random();

                //notifies the user when the button is pressed
                Toast.makeText(getApplicationContext(),"Activity A Button is pressed",Toast.LENGTH_SHORT).show();

                Integer numberB = randomNumberGeneratorA.nextInt(100 - 50) + 50;

                //When the random number is generated its inserted into the next Activity.
                iA.putExtra("TextValueB", "Random Number is " +numberB );
                startActivity(iA);


            }
        });



    }
}
