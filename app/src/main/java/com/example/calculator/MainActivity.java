//use a string array of size two to hold the values
//keep adding digits to the first index if the value in the operator string is null
//if it is not null, that means the user has clicked on a operation so the calculator is taking the second value
//perform the calculation when the equal sign is pressed and carry out appropriate calculation depending on the value in strOperator

package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private StringBuilder value1 = new StringBuilder("");
    private StringBuilder value2 = new StringBuilder("");
    //private String[] strValues = {"", ""};
    private String strOperator = "";
    private boolean blnOperator = false;
    private TextView output;
    private TextView operator;
    private Toast toast;
    private int orientatation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        orientatation = this.getResources().getConfiguration().orientation;

        output = (TextView) findViewById(R.id.textView_output);
        operator = (TextView) findViewById(R.id.textView_op);

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
        if (orientatation == Configuration.ORIENTATION_PORTRAIT) {
            output.setTextSize(85);
        } else {
            output.setTextSize(40);
        }

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
        if (orientatation == Configuration.ORIENTATION_PORTRAIT) {
            output.setTextSize(85);
        } else {
            output.setTextSize(40);
        }

        double dblAnswer = 0;
        if (blnOperator) {
            if (strOperator.equals("+")) {
                //dblAnswer = Double.parseDouble(strValues[0]) + Double.parseDouble(strValues[1]);
                dblAnswer = Double.parseDouble(value1.toString()) + Double.parseDouble(value2.toString());
            } else if (strOperator.equals("-")) {
                //dblAnswer = Double.parseDouble(strValues[0]) - Double.parseDouble(strValues[1]);
                dblAnswer = Double.parseDouble(value1.toString()) - Double.parseDouble(value2.toString());
            } else if (strOperator.equals("*")) {
                //dblAnswer = Double.parseDouble(strValues[0]) * Double.parseDouble(strValues[1]);
                dblAnswer = Double.parseDouble(value1.toString()) * Double.parseDouble(value2.toString());
            } else if (strOperator.equals("/")) {
                //dblAnswer = Double.parseDouble(strValues[0]) / Double.parseDouble(strValues[1]);
                dblAnswer = Double.parseDouble(value1.toString()) / Double.parseDouble(value2.toString());
            } else if (strOperator.equals("%")) {
                //dblAnswer = Double.parseDouble(strValues[0]) % Double.parseDouble(strValues[1]);
                dblAnswer = Double.parseDouble(value1.toString()) % Double.parseDouble(value2.toString());
            }

            if (output != null && operator != null) {
                String strAnswer = Double.toString(dblAnswer);
                output.setText(strAnswer);
                operator.setText("");
                blnOperator = false;
                strOperator = "";
                //strValues[0] = strAnswer;
                // strValues[1] = "";
                value1 = new StringBuilder(strAnswer);
                value2 = new StringBuilder("");
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

    public void onSevenClick(View view) {
        if (orientatation == Configuration.ORIENTATION_PORTRAIT) {
            output.setTextSize(85);
        } else {
            output.setTextSize(40);
        }
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
        if (orientatation == Configuration.ORIENTATION_PORTRAIT) {
            output.setTextSize(85);
        } else {
            output.setTextSize(40);
        }
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
        if (orientatation == Configuration.ORIENTATION_PORTRAIT) {
            output.setTextSize(85);
        } else {
            output.setTextSize(40);
        }
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

    public void onTwoClick(View view) {
        if (orientatation == Configuration.ORIENTATION_PORTRAIT) {
            output.setTextSize(85);
        } else {
            output.setTextSize(40);
        }
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
        if (orientatation == Configuration.ORIENTATION_PORTRAIT) {
            output.setTextSize(85);
        } else {
            output.setTextSize(40);
        }
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
        if (orientatation == Configuration.ORIENTATION_PORTRAIT) {
            output.setTextSize(85);
        } else {
            output.setTextSize(40);
        }
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

    public void onFiveClick(View view) {
        if (orientatation == Configuration.ORIENTATION_PORTRAIT) {
            output.setTextSize(85);
        } else {
            output.setTextSize(40);
        }
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
        if (orientatation == Configuration.ORIENTATION_PORTRAIT) {
            output.setTextSize(85);
        } else {
            output.setTextSize(40);
        }
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
        if (orientatation == Configuration.ORIENTATION_PORTRAIT) {
            output.setTextSize(85);
        } else {
            output.setTextSize(40);
        }
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
        if (orientatation == Configuration.ORIENTATION_PORTRAIT) {
            output.setTextSize(85);
        } else {
            output.setTextSize(40);
        }
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
        if (orientatation == Configuration.ORIENTATION_PORTRAIT) {
            output.setTextSize(85);
        } else {
            output.setTextSize(40);
        }
        //strValues[0] = "";
        //strValues[1] = "";
        value1 = new StringBuilder("");
        value2 = new StringBuilder("");
        if (output != null && operator != null) {
            output.setText("0");
            operator.setText("");
            blnOperator = false;
            strOperator = "";
        }
    }

    public void onSlashClick(View view) {
        if (orientatation == Configuration.ORIENTATION_PORTRAIT) {
            output.setTextSize(85);
        } else {
            output.setTextSize(40);
        }
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

    public void onModulusClick(View view) {
        if (orientatation == Configuration.ORIENTATION_PORTRAIT) {
            output.setTextSize(85);
        } else {
            output.setTextSize(40);
        }
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

    public void onFourClick(View view) {
        if (orientatation == Configuration.ORIENTATION_PORTRAIT) {
            output.setTextSize(85);
        } else {
            output.setTextSize(40);
        }
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
        if (orientatation == Configuration.ORIENTATION_PORTRAIT) {
            output.setTextSize(85);
        } else {
            output.setTextSize(40);
        }
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

    public void onOneClick(View view) {
        if (orientatation == Configuration.ORIENTATION_PORTRAIT) {
            output.setTextSize(85);
        } else {
            output.setTextSize(40);
        }
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
        if (orientatation == Configuration.ORIENTATION_PORTRAIT) {
            output.setTextSize(85);
        } else {
            output.setTextSize(40);
        }
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
}
