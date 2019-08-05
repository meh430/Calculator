//dynamically change label
//change visibility and text view and edit text hints
package com.example.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AreaVolSolve extends AppCompatActivity {
    public static boolean blnSentBack = false;
    public static final String EXTRA_BACK = "send";
    private TextView mainText;
    private EditText param1Edit, param2Edit, param3Edit;
    private String layout = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_vol_solve);

        TextView param1, param2, param3;

        mainText = findViewById(R.id.main_textview);
        param1 = findViewById(R.id.param1_textview);
        param2 = findViewById(R.id.param2_textview);
        param3 = findViewById(R.id.param3_textview);

        param1Edit = findViewById(R.id.param1_edit);
        param2Edit = findViewById(R.id.param2_edit);
        param3Edit = findViewById(R.id.param3_edit);

        Intent selection = getIntent();
        layout = selection.getStringExtra(SelectActivity.EXTRA_LAYOUT);

        assert layout != null;
        switch (layout) {
            case "areaTriangle":
                this.setTitle("Area of Triangle");
                param1.setVisibility(View.VISIBLE);
                param1.setText(R.string.param_base);

                param2.setVisibility(View.VISIBLE);
                param2.setText(R.string.param_height);

                param1Edit.setVisibility(View.VISIBLE);
                param2Edit.setVisibility(View.VISIBLE);
                break;
            case "areaRectangle":
                this.setTitle("Area of Rectangle");
                param1.setVisibility(View.VISIBLE);
                param1.setText(R.string.param_length);

                param2.setVisibility(View.VISIBLE);
                param2.setText(R.string.param_width);

                param1Edit.setVisibility(View.VISIBLE);
                param2Edit.setVisibility(View.VISIBLE);
                break;
            case "areaCircle":
                this.setTitle("Area of Circle");
                param1.setVisibility(View.VISIBLE);
                param1.setText(R.string.param_radius);

                param1Edit.setVisibility(View.VISIBLE);
                break;
            case "volumeRectangle":
                this.setTitle("Volume of Rectangle");
                param1.setVisibility(View.VISIBLE);
                param1.setText(R.string.param_length);

                param2.setVisibility(View.VISIBLE);
                param2.setText(R.string.param_width);

                param3.setVisibility(View.VISIBLE);
                param3.setText(R.string.param_height);

                param1Edit.setVisibility(View.VISIBLE);
                param2Edit.setVisibility(View.VISIBLE);
                param3Edit.setVisibility(View.VISIBLE);
                break;
            case "volumePyramid":
                this.setTitle("Volume of Pyramid");
                param1.setVisibility(View.VISIBLE);
                param1.setText(R.string.area_of_base);

                param2.setVisibility(View.VISIBLE);
                param2.setText(R.string.param_height);

                param1Edit.setVisibility(View.VISIBLE);
                param2Edit.setVisibility(View.VISIBLE);
                break;
            case "volumeCone":
                this.setTitle("Volume of Cone");
                param1.setVisibility(View.VISIBLE);
                param1.setText(R.string.param_radius);

                param2.setVisibility((View.VISIBLE));
                param2.setText(R.string.param_height);

                param1Edit.setVisibility(View.VISIBLE);
                param2Edit.setVisibility(View.VISIBLE);
                break;
            case "volumeCylinder":
                this.setTitle("Volume of Cylinder");
                param1.setVisibility(View.VISIBLE);
                param1.setText(R.string.param_radius);

                param2.setVisibility(View.VISIBLE);
                param2.setText(R.string.param_height);

                param1Edit.setVisibility(View.VISIBLE);
                param2Edit.setVisibility(View.VISIBLE);
                break;
            case "volumeSphere":
                this.setTitle("Volume of Sphere");
                param1.setVisibility(View.VISIBLE);
                param1.setText(R.string.param_radius);

                param1Edit.setVisibility(View.VISIBLE);
                break;
        }
    }//close onCreate

    public void onSolve(View view) {
        String strAnswer;
        double dblAreaBase, dblRadius, dblHeight, dblLength, dblWidth, dblBase;

        if (layout.equalsIgnoreCase("areaTriangle")) {
            if (notEmpty(2)) {
                dblBase = Double.parseDouble(param1Edit.getText().toString());
                dblHeight = Double.parseDouble(param2Edit.getText().toString());

                strAnswer = Double.toString(Math.round((1.0 / 2.0 * (dblBase * dblHeight)) * 100.0) / 100.0);

                mainText.setText(strAnswer);
            }
        } else if (layout.equalsIgnoreCase("areaRectangle")) {
            if (notEmpty(2)) {
                dblLength = Double.parseDouble(param1Edit.getText().toString());
                dblWidth = Double.parseDouble(param2Edit.getText().toString());

                strAnswer = Double.toString(Math.round((dblLength * dblWidth) * 100.0) / 100.0);

                mainText.setText(strAnswer);
            }
        } else if (layout.equalsIgnoreCase("areaCircle")) {
            if (notEmpty(1)) {
                dblRadius = Double.parseDouble(param1Edit.getText().toString());

                strAnswer = Double.toString(Math.round((Math.PI * Math.pow(dblRadius, 2)) * 100.0) / 100.0);

                mainText.setText(strAnswer);
            }
        } else if (layout.equalsIgnoreCase("volumeRectangle")) {
            if (notEmpty(3)) {
                dblLength = Double.parseDouble(param1Edit.getText().toString());
                dblWidth = Double.parseDouble(param2Edit.getText().toString());
                dblHeight = Double.parseDouble(param3Edit.getText().toString());

                strAnswer = Double.toString(Math.round((dblLength * dblWidth * dblHeight) * 100.0) / 100.0);

                mainText.setText(strAnswer);
            }
        } else if (layout.equalsIgnoreCase("volumePyramid")) {
            if (notEmpty(2)) {
                dblAreaBase = Double.parseDouble(param1Edit.getText().toString());
                dblHeight = Double.parseDouble(param2Edit.getText().toString());

                strAnswer = Double.toString(Math.round((1.0 / 3.0 * (dblAreaBase * dblHeight)) * 100.0) / 100.0);

                mainText.setText(strAnswer);
            }
        } else if (layout.equalsIgnoreCase("volumeCone")) {
            if (notEmpty(2)) {
                dblRadius = Double.parseDouble(param1Edit.getText().toString());
                dblHeight = Double.parseDouble(param2Edit.getText().toString());

                strAnswer = Double.toString(Math.round((Math.PI * Math.pow(dblRadius, 2) * (dblHeight / 3.0)) * 100.0) / 100.0);

                mainText.setText(strAnswer);
            }
        } else if (layout.equalsIgnoreCase("volumeCylinder")) {
            if (notEmpty(2)) {
                dblRadius = Double.parseDouble(param1Edit.getText().toString());
                dblHeight = Double.parseDouble(param2Edit.getText().toString());

                strAnswer = Double.toString(Math.round((Math.PI * Math.pow(dblRadius, 2) * dblHeight) * 100.0) / 100.0);

                mainText.setText(strAnswer);
            }
        } else if (layout.equalsIgnoreCase("volumeSphere")) {
            if (notEmpty(1)) {
                dblRadius = Double.parseDouble(param1Edit.getText().toString());

                strAnswer = Double.toString(Math.round((4.0 / 3.0 * Math.PI * Math.pow(dblRadius, 3)) * 100.0) / 100.0);

                mainText.setText(strAnswer);
            }
        }
    }

    public void onBack(View view) {
        Intent sendBack = new Intent(this, MainActivity.class);
        if (mainText != null) {
            blnSentBack = true;
            sendBack.putExtra(EXTRA_BACK, mainText.getText().toString());
            startActivity(sendBack);
        } else {
            Toast toast = Toast.makeText(this, "Nothing to Send", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    //returns true if the main texview has content
    public boolean notEmpty(int numOfParam) {
        Toast empty = Toast.makeText(this, "Please Enter all Values", Toast.LENGTH_SHORT);
        if (numOfParam == 1) {
            if (param1Edit.getText().toString().equalsIgnoreCase("")) {
                empty.show();
                return false;
            } else {
                return true;
            }
        } else if (numOfParam == 2) {
            if (param1Edit.getText().toString().equalsIgnoreCase("") || param2Edit.getText().toString().equalsIgnoreCase("")) {
                empty.show();
                return false;
            } else {
                return true;
            }
        } else if (numOfParam == 3) {
            if (param1Edit.getText().toString().equalsIgnoreCase("") ||
                    param2Edit.getText().toString().equalsIgnoreCase("") ||
                    param3Edit.getText().toString().equalsIgnoreCase("")) {
                empty.show();
                return false;
            } else {
                return true;
            }
        }
        return true;
    }
}
