package com.example.individualassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToBMI(View view) {
            switchActivities1();
    }

    public void goToFitness(View view) {
        switchActivities2();
    }

    private void switchActivities1() {
        Intent switchActivityIntent = new Intent(this, BMI_Calculator.class);
        startActivity(switchActivityIntent);
    }

    private void switchActivities2() {
        Intent switchActivityIntent = new Intent(this, Fitness_Tips.class);
        startActivity(switchActivityIntent);
    }
}