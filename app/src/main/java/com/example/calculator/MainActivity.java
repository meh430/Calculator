//use a string array of size two to hold the values
//keep adding digits to the first index if the value in the operator string is null
//if it is not null, that means the user has clicked on a operation so the calculator is taking the second value
//perform the calculation when the equal sign is pressed and carry out appropriate calculation depending on the value in strOperator

package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String[] strValues = {"", ""};
    private String strOperator = "";
    private boolean blnOperator = false;
    private TextView output;
    private TextView operator;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        output = (TextView) findViewById(R.id.textView_output);
        operator = (TextView) findViewById(R.id.textView_op);
    }

    public void onDecimalClick(View view) {
        //if operator has been clicked
        if (blnOperator) {
            if (strValues[1].contains(".")) {
                toast = Toast.makeText(this, R.string.decimal_exists, Toast.LENGTH_SHORT);
                toast.show();
            } else {
                strValues[1] += ".";
                if (output != null) {
                    output.setText(strValues[1]);
                }
            }
        } else {//if operator has not been clicked
            if (strValues[0].contains(".")) {
                toast = Toast.makeText(this, R.string.decimal_exists, Toast.LENGTH_SHORT);
                toast.show();
            } else {
                strValues[0] += ".";
                if (output != null) {
                    output.setText(strValues[0]);
                }
            }
        }
    }

    public void onEqualClick(View view) {
        double dblAnswer = 0;
        if (blnOperator) {
            if (strOperator.equals("+")) {
                dblAnswer = Double.parseDouble(strValues[0]) + Double.parseDouble(strValues[1]);
            } else if (strOperator.equals("-")) {
                dblAnswer = Double.parseDouble(strValues[0]) - Double.parseDouble(strValues[1]);
            } else if (strOperator.equals("*")) {
                dblAnswer = Double.parseDouble(strValues[0]) * Double.parseDouble(strValues[1]);
            } else if (strOperator.equals("/")) {
                dblAnswer = Double.parseDouble(strValues[0]) / Double.parseDouble(strValues[1]);
            } else if (strOperator.equals("%")) {
                dblAnswer = Double.parseDouble(strValues[0]) % Double.parseDouble(strValues[1]);
            }

            if (output != null && operator != null) {
                String strAnswer = Double.toString(dblAnswer);
                output.setText(strAnswer);
                operator.setText("");
                blnOperator = false;
                strOperator = "";
                strValues[0] = strAnswer;
                strValues[1] = "";
            }

        } else {
            toast = Toast.makeText(this, R.string.no_operator, Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void onSevenClick(View view) {
        //if operator has been clicked
        if (blnOperator) {
            strValues[1] += "7";
            if (output != null) {
                output.setText(strValues[1]);
            }
        } else {
            strValues[0] += "7";
            if (output != null) {
                output.setText(strValues[0]);
            }
        }
    }

    public void onThreeClick(View view) {
        //if operator has been clicked
        if (blnOperator) {
            strValues[1] += "3";
            if (output != null) {
                output.setText(strValues[1]);
            }
        } else {
            strValues[0] += "3";
            if (output != null) {
                output.setText(strValues[0]);
            }
        }
    }

    public void onPlusClick(View view) {
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
        //if operator has been clicked
        if (blnOperator) {
            strValues[1] += "2";
            if (output != null) {
                output.setText(strValues[1]);
            }
        } else {
            strValues[0] += "2";
            if (output != null) {
                output.setText(strValues[0]);
            }
        }
    }

    public void onSixClick(View view) {
        //if operator has been clicked
        if (blnOperator) {
            strValues[1] += "6";
            if (output != null) {
                output.setText(strValues[1]);
            }
        } else {
            strValues[0] += "6";
            if (output != null) {
                output.setText(strValues[0]);
            }
        }
    }

    public void onMinusClick(View view) {
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
        //if operator has been clicked
        if (blnOperator) {
            strValues[1] += "5";
            if (output != null) {
                output.setText(strValues[1]);
            }
        } else {
            strValues[0] += "5";
            if (output != null) {
                output.setText(strValues[0]);
            }
        }
    }

    public void onEightClick(View view) {
        //if operator has been clicked
        if (blnOperator) {
            strValues[1] += "8";
            if (output != null) {
                output.setText(strValues[1]);
            }
        } else {
            strValues[0] += "8";
            if (output != null) {
                output.setText(strValues[0]);
            }
        }
    }

    public void onNineClick(View view) {
        //if operator has been clicked
        if (blnOperator) {
            strValues[1] += "9";
            if (output != null) {
                output.setText(strValues[1]);
            }
        } else {
            strValues[0] += "9";
            if (output != null) {
                output.setText(strValues[0]);
            }
        }
    }

    public void onZeroClick(View view) {
        //if operator has been clicked
        if (blnOperator) {
            strValues[1] += "0";
            if (output != null) {
                output.setText(strValues[1]);
            }
        } else {
            strValues[0] += "0";
            if (output != null) {
                output.setText(strValues[0]);
            }
        }
    }

    public void onClearClick(View view) {
        strValues[0] = "";
        strValues[1] = "";
        if (output != null && operator != null) {
            output.setText("0");
            operator.setText("");
            blnOperator = false;
            strOperator = "";
        }
    }

    public void onSlashClick(View view) {
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
        //if operator has been clicked
        if (blnOperator) {
            strValues[1] += "4";
            if (output != null) {
                output.setText(strValues[1]);
            }
        } else {
            strValues[0] += "4";
            if (output != null) {
                output.setText(strValues[0]);
            }
        }
    }

    public void onMultiplyClick(View view) {
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
        //if operator has been clicked
        if (blnOperator) {
            strValues[1] += "1";
            if (output != null) {
                output.setText(strValues[1]);
            }
        } else {
            strValues[0] += "1";
            if (output != null) {
                output.setText(strValues[0]);
            }
        }
    }
}
