package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

//import android.content.Intent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//each button click will launch a different activity for the calculation screen, probably a textview for result with editNums to enter values
//somehow get data from those activities back to main
//make intents with string keys and values, nothing is sent to the activity from here, only retrieved
//the other activity will have to call setResult

public class SelectActivity extends AppCompatActivity {

    public static final String EXTRA_LAYOUT = "com.example.calculator.extra.LAYOUT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

    }


    public void areaTriangle(View view) {
        Intent areaTri = new Intent(this, AreaVolSolve.class);
        areaTri.putExtra(EXTRA_LAYOUT, "areaTriangle");
        startActivity(areaTri);
    }

    public void areaRectangle(View view) {
        Intent areaRect = new Intent(this, AreaVolSolve.class);
        areaRect.putExtra(EXTRA_LAYOUT, "areaRectangle");
        startActivity(areaRect);
    }

    public void areaCircle(View view) {
        Intent areaCircle = new Intent(this, AreaVolSolve.class);
        areaCircle.putExtra(EXTRA_LAYOUT, "areaCircle");
        startActivity(areaCircle);
    }

    public void volumeRectangle(View view) {
        Intent volumeRect = new Intent(this, AreaVolSolve.class);
        volumeRect.putExtra(EXTRA_LAYOUT, "volumeRectangle");
        startActivity(volumeRect);
    }

    public void volumePyramid3(View view) {
        Intent volumePyr3 = new Intent(this, AreaVolSolve.class);
        volumePyr3.putExtra(EXTRA_LAYOUT, "volumePyramid3");
        startActivity(volumePyr3);
    }

    public void volumePyramid4(View view) {
        Intent volumePyr4 = new Intent(this, AreaVolSolve.class);
        volumePyr4.putExtra(EXTRA_LAYOUT, "volumePyramid4");
        startActivity(volumePyr4);
    }

    public void volumeCone(View view) {
        Intent volCone = new Intent(this, AreaVolSolve.class);
        volCone.putExtra(EXTRA_LAYOUT, "volumeCone");
        startActivity(volCone);
    }

    public void volumeCylinder(View view) {
        Intent volCylinder = new Intent(this, AreaVolSolve.class);
        volCylinder.putExtra(EXTRA_LAYOUT, "volumeCylinder");
        startActivity(volCylinder);
    }

    public void volumeSphere(View view) {
        Intent volSphere = new Intent(this, AreaVolSolve.class);
        volSphere.putExtra(EXTRA_LAYOUT, "volumeSphere");
        startActivity(volSphere);
    }


}
