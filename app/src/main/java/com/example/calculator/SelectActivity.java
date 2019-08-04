package com.example.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;

import androidx.appcompat.app.AppCompatActivity;

//import android.content.Intent;

//each button click will launch a different activity for the calculation screen, probably a textview for result with editNums to enter values
//somehow get data from those activities back to main
//make intents with string keys and values, nothing is sent to the activity from here, only retrieved
//the other activity will have to call setResult

public class SelectActivity extends AppCompatActivity {
    private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.4F);
    public static final String EXTRA_LAYOUT = "com.example.calculator.extra.LAYOUT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

    }


    public void areaTriangle(View view) {
        view.startAnimation(buttonClick);

        Intent areaTri = new Intent(this, AreaVolSolve.class);
        areaTri.putExtra(EXTRA_LAYOUT, "areaTriangle");
        startActivity(areaTri);
    }

    public void areaRectangle(View view) {
        view.startAnimation(buttonClick);

        Intent areaRect = new Intent(this, AreaVolSolve.class);
        areaRect.putExtra(EXTRA_LAYOUT, "areaRectangle");
        startActivity(areaRect);
    }

    public void areaCircle(View view) {
        view.startAnimation(buttonClick);

        Intent areaCircle = new Intent(this, AreaVolSolve.class);
        areaCircle.putExtra(EXTRA_LAYOUT, "areaCircle");
        startActivity(areaCircle);
    }

    public void volumeRectangle(View view) {
        view.startAnimation(buttonClick);

        Intent volumeRect = new Intent(this, AreaVolSolve.class);
        volumeRect.putExtra(EXTRA_LAYOUT, "volumeRectangle");
        startActivity(volumeRect);
    }

    public void volumePyramid(View view) {
        view.startAnimation(buttonClick);

        Intent volumePyr3 = new Intent(this, AreaVolSolve.class);
        volumePyr3.putExtra(EXTRA_LAYOUT, "volumePyramid");
        startActivity(volumePyr3);
    }

    public void volumeCone(View view) {
        view.startAnimation(buttonClick);

        Intent volCone = new Intent(this, AreaVolSolve.class);
        volCone.putExtra(EXTRA_LAYOUT, "volumeCone");
        startActivity(volCone);
    }

    public void volumeCylinder(View view) {
        view.startAnimation(buttonClick);

        Intent volCylinder = new Intent(this, AreaVolSolve.class);
        volCylinder.putExtra(EXTRA_LAYOUT, "volumeCylinder");
        startActivity(volCylinder);
    }

    public void volumeSphere(View view) {
        view.startAnimation(buttonClick);

        Intent volSphere = new Intent(this, AreaVolSolve.class);
        volSphere.putExtra(EXTRA_LAYOUT, "volumeSphere");
        startActivity(volSphere);
    }


}
