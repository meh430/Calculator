//use a string array of size two to hold the values
//keep adding digits to the first index if the value in the operator string is null
//if it is not null, that means the user has clicked on a operation so the calculator is taking the second value
//perform the calculation when the equal sign is pressed and carry out appropriate calculation depending on the value in strOperator

//TODO: make another activity for simple area and volume calculations
//Go from the main activity to the activity with all the options
//Then, go to a different activity depending on what shape was chosen
//Will have to figure out how to send data back from the area/volume calculation activity to the main activity
//probably use a string key containing the class package name

package com.example.calculator;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

//put redundant things in methods please, like check for the orientation and check for text size
public class MainActivity extends AppCompatActivity {
    private StringBuilder value1 = new StringBuilder();
    private StringBuilder value2 = new StringBuilder();
    private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.4F);
    //private String[] strValues = {"", ""};
    private String strOperator = "";
    private boolean blnOperator = false;
    private TextView output;
    private TextView operator;
    private Toast toast;
    private int orientation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        orientation = this.getResources().getConfiguration().orientation;
        output = findViewById(R.id.tv_output);
        operator = findViewById(R.id.tv_operator);

        if (AreaVolSolve.blnSentBack) {
            Intent areaVol = getIntent();
            String strAreaVol = areaVol.getStringExtra(AreaVolSolve.EXTRA_BACK);
            output.setText(strAreaVol);
            value1 = new StringBuilder(strAreaVol);
            checkSize();
        }

        if (savedInstanceState != null) {
            boolean hasContent = savedInstanceState.getBoolean("resume");
            if (hasContent) {
                output.setText(savedInstanceState.getString("output_text"));
                operator.setText(savedInstanceState.getString("operator_text"));
                strOperator = savedInstanceState.getString("operator_content");
                value1 = new StringBuilder(savedInstanceState.getString("value_1"));
                value2 = new StringBuilder(savedInstanceState.getString("value_2"));
            }
        }
    }

    //save the activity instance state if device configuration is changed
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        if (output != null && operator != null) {
            outState.putBoolean("resume", true);
            outState.putString("output_text", output.getText().toString());
            outState.putString("operator_text", operator.getText().toString());
            outState.putString("operator_content", strOperator);
            outState.putString("value_1", value1.toString());
            outState.putString("value_2", value2.toString());
        }

    }

    public void onDecimalClick(View view) {
        view.startAnimation(buttonClick);

        checkOrientation();
        checkSize();

        //if operator has been clicked
        if (blnOperator) {
            //if (strValues[1].contains(".")) {
            if (value2.toString().contains(".")) {
                toast = Toast.makeText(this, R.string.decimal_exists, Toast.LENGTH_SHORT);
                toast.show();
            } else {
                //strValues[1] += ".";
                value2.append(".");
                if (output != null) {
                    //output.setText(strValues[1]);
                    output.setText(value2);
                }
            }
        } else {//if operator has not been clicked
            //if (strValues[0].contains(".")) {
            if (value1.toString().contains(".")) {
                toast = Toast.makeText(this, R.string.decimal_exists, Toast.LENGTH_SHORT);
                toast.show();
            } else {
                //strValues[0] += ".";
                value1.append(".");
                if (output != null) {
                    //output.setText(strValues[0]);
                    output.setText(value1);
                }
            }
        }
    }

    public void onEqualClick(View view) {
        view.startAnimation(buttonClick);

        checkOrientation();
        checkSize();

        if (checkTextView()) {
            boolean isZero = false;
            double dblAnswer = 0;
            if (blnOperator) {
                switch (strOperator) {
                    case "+":
                        //dblAnswer = Double.parseDouble(strValues[0]) + Double.parseDouble(strValues[1]);
                        dblAnswer = Double.parseDouble(value1.toString()) + Double.parseDouble(value2.toString());
                        break;
                    case "-":
                        //dblAnswer = Double.parseDouble(strValues[0]) - Double.parseDouble(strValues[1]);
                        dblAnswer = Double.parseDouble(value1.toString()) - Double.parseDouble(value2.toString());
                        break;
                    case "*":
                        //dblAnswer = Double.parseDouble(strValues[0]) * Double.parseDouble(strValues[1]);
                        dblAnswer = Double.parseDouble(value1.toString()) * Double.parseDouble(value2.toString());
                        break;
                    case "/":
                        if (Double.parseDouble(value2.toString()) == 0) {
                            isZero = true;
                        } else {
                            //dblAnswer = Double.parseDouble(strValues[0]) / Double.parseDouble(strValues[1]);
                            dblAnswer = Double.parseDouble(value1.toString()) / Double.parseDouble(value2.toString());
                        }
                        break;
                    case "%":
                        //dblAnswer = Double.parseDouble(strValues[0]) % Double.parseDouble(strValues[1]);
                        dblAnswer = Double.parseDouble(value1.toString()) % Double.parseDouble(value2.toString());
                        break;
                }

                if (output != null && operator != null) {
                    String strAnswer;
                    if (isZero) {
                        strAnswer = "To infinity and beyond!";
                    } else {
                        strAnswer = Double.toString(dblAnswer);
                    }

                    if (strAnswer.length() >= 7) {
                        output.setTextSize(40);
                    } else {
                        output.setTextSize(85);
                    }

                    output.setText(strAnswer);
                    operator.setText("");
                    blnOperator = false;
                    strOperator = "";
                    //strValues[0] = strAnswer;
                    // strValues[1] = "";
                    value1 = new StringBuilder(strAnswer);
                    value2 = new StringBuilder();
                }

            } else {
                output.setTextSize(40);
                String strEasterEgg;
                if (value1.toString().equals("1971")) {
                    strEasterEgg = "Turn off the lights!";
                    output.setText(strEasterEgg);
                } else if (value1.toString().equals("1974")) {
                    strEasterEgg = "I love you mom!";
                    output.setText(strEasterEgg);
                } else if (value1.toString().equals("2002")) {
                    strEasterEgg = "I'm the best!";
                    output.setText(strEasterEgg);
                } else if (value1.toString().equals("2006")) {
                    strEasterEgg = "Ha, loser!";
                    output.setText(strEasterEgg);
                } else {
                    toast = Toast.makeText(this, R.string.no_operator, Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        }
    }

    public void onSevenClick(View view) {
        view.startAnimation(buttonClick);

        checkOrientation();
        checkSize();

        //if operator has been clicked
        if (blnOperator) {
            //strValues[1] += "7";
            value2.append("7");
            if (output != null) {
                //output.setText(strValues[1]);
                output.setText(value2);
            }
        } else {
            //strValues[0] += "7";
            value1.append("7");
            if (output != null) {
                //output.setText(strValues[0]);
                output.setText(value1);
            }
        }
    }

    public void onThreeClick(View view) {
        view.startAnimation(buttonClick);

        checkOrientation();
        checkSize();

        //if operator has been clicked
        if (blnOperator) {
            //strValues[1] += "3";
            value2.append("3");
            if (output != null) {
                //output.setText(strValues[1]);
                output.setText(value2);
            }
        } else {
            //strValues[0] += "3";
            value1.append("3");
            if (output != null) {
                //output.setText(strValues[0]);
                output.setText(value1);
            }
        }
    }

    public void onPlusClick(View view) {
        view.startAnimation(buttonClick);

        checkOrientation();
        checkSize();

        if (checkTextView()) {
            if (blnOperator) {
                toast = Toast.makeText(this, R.string.operator_exists, Toast.LENGTH_SHORT);
                toast.show();
            } else {
                if (output != null && operator != null) {
                    blnOperator = true;
                    strOperator = "+";
                    output.setText("");
                    operator.setText("+");
                }
            }
        }
    }

    public void onTwoClick(View view) {
        view.startAnimation(buttonClick);

        checkOrientation();
        checkSize();

        //if operator has been clicked
        if (blnOperator) {
            //strValues[1] += "2";
            value2.append("2");
            if (output != null) {
                //output.setText(strValues[1]);
                output.setText(value2);
            }
        } else {
            //strValues[0] += "2";
            value1.append("2");
            if (output != null) {
                //output.setText(strValues[0]);
                output.setText(value1);
            }
        }
    }

    public void onSixClick(View view) {
        view.startAnimation(buttonClick);

        checkOrientation();
        checkSize();

        //if operator has been clicked
        if (blnOperator) {
            //strValues[1] += "6";
            value2.append("6");
            if (output != null) {
                //output.setText(strValues[1]);
                output.setText(value2);
            }
        } else {
            //strValues[0] += "6";
            value1.append("6");
            if (output != null) {
                //output.setText(strValues[0]);
                output.setText(value1);
            }
        }
    }

    public void onMinusClick(View view) {
        view.startAnimation(buttonClick);

        checkOrientation();
        checkSize();

        if (checkTextView()) {
            if (blnOperator) {
                toast = Toast.makeText(this, R.string.operator_exists, Toast.LENGTH_SHORT);
                toast.show();
            } else {
                if (output != null && operator != null) {
                    blnOperator = true;
                    strOperator = "-";
                    output.setText("");
                    operator.setText("-");
                }
            }
        }
    }

    public void onFiveClick(View view) {
        view.startAnimation(buttonClick);

        checkOrientation();
        checkSize();

        //if operator has been clicked
        if (blnOperator) {
            //strValues[1] += "5";
            value2.append("5");
            if (output != null) {
                //output.setText(strValues[1]);
                output.setText(value2);
            }
        } else {
            //strValues[0] += "5";
            value1.append("5");
            if (output != null) {
                //output.setText(strValues[0]);
                output.setText(value1);
            }
        }
    }

    public void onEightClick(View view) {
        view.startAnimation(buttonClick);

        checkOrientation();
        checkSize();

        //if operator has been clicked
        if (blnOperator) {
            //strValues[1] += "8";
            value2.append("8");
            if (output != null) {
                //output.setText(strValues[1]);
                output.setText(value2);
            }
        } else {
            //strValues[0] += "8";
            value1.append("8");
            if (output != null) {
                //output.setText(strValues[0]);
                output.setText(value1);
            }
        }
    }

    public void onNineClick(View view) {
        view.startAnimation(buttonClick);

        checkOrientation();
        checkSize();

        //if operator has been clicked
        if (blnOperator) {
            //strValues[1] += "9";
            value2.append("9");
            if (output != null) {
                //output.setText(strValues[1]);
                output.setText(value2);
            }
        } else {
            //strValues[0] += "9";
            value1.append("9");
            if (output != null) {
                //output.setText(strValues[0]);
                output.setText(value1);
            }
        }
    }

    public void onZeroClick(View view) {
        view.startAnimation(buttonClick);

        checkOrientation();
        checkSize();

        //if operator has been clicked
        if (blnOperator) {
            //strValues[1] += "0";
            value2.append("0");
            if (output != null) {
                //output.setText(strValues[1]);
                output.setText(value2);
            }
        } else {
            //strValues[0] += "0";
            value1.append("0");
            if (output != null) {
                //output.setText(strValues[0]);
                output.setText(value1);
            }
        }
    }

    public void onClearClick(View view) {
        view.startAnimation(buttonClick);

        checkOrientation();
        checkSize();

        //strValues[0] = "";
        //strValues[1] = "";
        value1 = new StringBuilder();
        value2 = new StringBuilder();
        if (output != null && operator != null) {
            output.setText("");
            operator.setText("");
            blnOperator = false;
            strOperator = "";
        }
    }

    public void onSlashClick(View view) {
        view.startAnimation(buttonClick);

        checkOrientation();
        checkSize();

        if (checkTextView()) {
            if (blnOperator) {
                toast = Toast.makeText(this, R.string.operator_exists, Toast.LENGTH_SHORT);
                toast.show();
            } else {
                if (output != null && operator != null) {
                    blnOperator = true;
                    strOperator = "/";
                    output.setText("");
                    operator.setText("/");
                }
            }
        }
    }

    public void onModulusClick(View view) {
        view.startAnimation(buttonClick);

        checkOrientation();
        checkSize();

        if (checkTextView()) {
            if (blnOperator) {
                toast = Toast.makeText(this, R.string.operator_exists, Toast.LENGTH_SHORT);
                toast.show();
            } else {
                if (output != null && operator != null) {
                    blnOperator = true;
                    strOperator = "%";
                    output.setText("");
                    operator.setText("%");
                }
            }
        }
    }

    public void onFourClick(View view) {
        view.startAnimation(buttonClick);

        checkOrientation();
        checkSize();

        //if operator has been clicked
        if (blnOperator) {
            //strValues[1] += "4";
            value2.append("4");
            if (output != null) {
                //output.setText(strValues[1]);
                output.setText(value2);
            }
        } else {
            //strValues[0] += "4";
            value1.append("4");
            if (output != null) {
                //output.setText(strValues[0]);
                output.setText(value1);
            }
        }
    }

    public void onMultiplyClick(View view) {
        view.startAnimation(buttonClick);


        checkOrientation();
        checkSize();

        if (checkTextView()) {
            if (blnOperator) {
                toast = Toast.makeText(this, R.string.operator_exists, Toast.LENGTH_SHORT);
                toast.show();
            } else {
                if (output != null && operator != null) {
                    blnOperator = true;
                    strOperator = "*";
                    output.setText("");
                    operator.setText("*");
                }
            }
        }
    }

    public void onOneClick(View view) {
        view.startAnimation(buttonClick);

        checkOrientation();
        checkSize();

        //if operator has been clicked
        if (blnOperator) {
            //strValues[1] += "1";
            value2.append("1");
            if (output != null) {
                //output.setText(strValues[1]);
                output.setText(value2);
            }
        } else {
            //strValues[0] += "1";
            value1.append("1");
            if (output != null) {
                //output.setText(strValues[0]);
                output.setText(value1);
            }
        }
    }

    public void onDeleteClick(View view) {
        view.startAnimation(buttonClick);

        checkOrientation();
        checkSize();

        if (blnOperator) {
            value2.setLength(Math.max(value2.length() - 1, 0));
            if (output != null) {
                output.setText(value2);
            }
        } else {
            value1.setLength(Math.max(value1.length() - 1, 0));
            if (output != null) {
                output.setText(value1);
            }
        }
    }

    public void onCalculationClick(View view) {
        view.startAnimation(buttonClick);

        Intent selectIntent = new Intent(this, SelectActivity.class);
        startActivity(selectIntent);
    }

    public void checkOrientation() {
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            output.setTextSize(85);
        } else {
            output.setTextSize(40);
        }
    }

    public void checkSize() {
        if (output != null) {
            if (orientation == Configuration.ORIENTATION_PORTRAIT) {
                if (output.getText().toString().length() >= 7) {
                    output.setTextSize(40);
                } else {
                    output.setTextSize(85);
                }
            }
        }
    }

    public boolean checkTextView() {
        toast = Toast.makeText(this, "Nothing was Entered", Toast.LENGTH_SHORT);
        if (blnOperator) {
            if (value2 == null || value2.toString().equalsIgnoreCase("")) {
                toast.show();
                return false;
            }
        } else {
            if (value1 == null || value1.toString().equalsIgnoreCase("")) {
                toast.show();
                return false;
            }
        }
        return true;
    }
}
