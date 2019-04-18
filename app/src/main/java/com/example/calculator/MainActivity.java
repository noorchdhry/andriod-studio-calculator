package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;



public class MainActivity extends AppCompatActivity {

    double operand1, operand2, calculated;
    String operator;
    TextView result;
    boolean decimalClick, operand1Click, errorMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button zero = findViewById(R.id.btn0);
        Button one = findViewById(R.id.btn1);
        Button two = findViewById(R.id.btn2);
        Button three = findViewById(R.id.btn3);
        Button four = findViewById(R.id.btn4);
        Button five = findViewById(R.id.btn5);
        Button six = findViewById(R.id.btn6);
        Button seven = findViewById(R.id.btn7);
        Button eight = findViewById(R.id.btn8);
        Button nine = findViewById(R.id.btn9);
        Button add = findViewById(R.id.btnAdd);
        Button subtract = findViewById(R.id.btnSubtract);
        Button divide = findViewById(R.id.btnDivide);
        Button multiply = findViewById(R.id.btnMultiply);
        Button decimal = findViewById(R.id.btnDecimal);
        Button equals = findViewById(R.id.btnEquals);
        result = findViewById(R.id.tvResult);
        result.setText("");

        zero.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                clearError();
                result.append("0");

            }
        });
        one.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                clearError();
                result.append("1");
            }
        });
        two.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                result.append("2");
            }
        });
        three.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                clearError();
                result.append("3");
            }
        });
        four.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                clearError();
                result.append("4");
            }
        });
        five.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                clearError();
                result.append("5");
            }
        });
        six.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                clearError();
                result.append("6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                clearError();
                operand1Click = true;
                result.append("7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                clearError();
                result.append("8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                clearError();
                result.append("9");
            }
        });
        decimal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (decimalClick == false && result.getText().toString() != "") {
                    result.append(".");
                    decimalClick = true;
                }
            }
        });

        //Methods for the various operators
        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(operand1Click == false){
                    operandError();
                } else {
                    operand1 = Double.parseDouble(result.getText().toString());
                    operator = "+";
                    result.setText("");
                    decimalClick = false;
                }
            }
        });

        subtract.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(operand1Click == false){
                    operandError();
                }else {
                    operand1 = Double.parseDouble(result.getText().toString());
                    operator = "-";
                    result.setText("");
                    decimalClick = false;
                }
            }
        });

        multiply.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(operand1Click == false){
                    operandError();
                }else {
                    operand1 = Double.parseDouble(result.getText().toString());
                    operator = "*";
                    result.setText("");
                    decimalClick = false;
                }
            }
        });

        divide.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(operand1Click == false){
                    operandError();
                } else {
                    operand1 = Double.parseDouble(result.getText().toString());
                    operator = "/";
                    result.setText("");
                    decimalClick = false;
                }
            }
        });

        equals.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(operator == "+"){
                    operand2 = Double.parseDouble(result.getText().toString());
                    calculated = operand1 + operand2;
                    result.setText(Double.toString(calculated));
                } else if(operator == "-"){
                    operand2 = Double.parseDouble(result.getText().toString());
                    calculated = operand1 - operand2;
                    result.setText(Double.toString(calculated));
                }else if(operator == "*"){
                    operand2 = Double.parseDouble(result.getText().toString());
                    calculated = operand1 * operand2;
                    result.setText(Double.toString(calculated));
                }else if(operator == "/"){
                    operand2 = Double.parseDouble(result.getText().toString());
                    if(operand2 == 0) {
                        result.setText("Error");
                        errorMessage = true;
                    } else {
                        calculated = operand1 / operand2;
                        result.setText(Double.toString(calculated));
                    }
                }
            }
        });




    }

    public void clearError(){
        operand1Click = true;
        if (errorMessage == true) {
            result.setText("");
            errorMessage = false;
        }
    }

    public void operandError() {
            result.setText(" Error!");
            errorMessage = true;
    }
}

