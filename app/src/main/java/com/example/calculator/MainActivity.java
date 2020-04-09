package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.faendir.rhino_android.RhinoAndroidHelper;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ast.Scope;
public class MainActivity extends AppCompatActivity {
    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnClear,btnBrackets,btnPercentage,btnDivide,btnMultiply,btnMinus,btnPlus,btnDecimal,btnEqual;
    TextView tvInput,tvOutput;
    String process;
    boolean checkBracket=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn0=findViewById(R.id.btn0);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);
        btnClear=findViewById(R.id.btnClear);
        btnBrackets=findViewById(R.id.btnBrackets);
        btnPercentage=findViewById(R.id.btnPercentage);
        btnDivide=findViewById(R.id.btnDivide);
        btnMultiply=findViewById(R.id.btnMultiply);
        btnMinus=findViewById(R.id.btnMinus);
        btnPlus=findViewById(R.id.btnPlus);
        btnDecimal=findViewById(R.id.btnDecimal);
        btnEqual=findViewById(R.id.btnEqual);


        tvInput=findViewById(R.id.tvInput);
        tvOutput=findViewById(R.id.tvOutput);
        btnClear.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View v){
                tvInput.setText("");
                tvOutput.setText("");
            }

        });

        btn0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                process=tvInput.getText().toString();
                tvInput.setText(process + "0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                process=tvInput.getText().toString();
                tvInput.setText(process + "1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                process=tvInput.getText().toString();
                tvInput.setText(process + "2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                process=tvInput.getText().toString();
                tvInput.setText(process + "3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                process=tvInput.getText().toString();
                tvInput.setText(process + "4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                process=tvInput.getText().toString();
                tvInput.setText(process + "5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                process=tvInput.getText().toString();
                tvInput.setText(process + "6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                process=tvInput.getText().toString();
                tvInput.setText(process + "7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                process=tvInput.getText().toString();
                tvInput.setText(process + "8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                process=tvInput.getText().toString();
                tvInput.setText(process + "9");
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                process=tvInput.getText().toString();
                tvInput.setText(process + "+");
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                process=tvInput.getText().toString();
                tvInput.setText(process + "-");
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                process=tvInput.getText().toString();
                tvInput.setText(process + "×");
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                process=tvInput.getText().toString();
                tvInput.setText(process + "÷");
            }
        });

        btnDecimal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                process=tvInput.getText().toString();
                tvInput.setText(process + ".");
            }
        });

        btnPercentage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                process=tvInput.getText().toString();
                tvInput.setText(process + "%");
            }
        });

        btnBrackets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkBracket){
                    process = tvInput.getText().toString();
                    tvInput.setText(process + ")");
                    checkBracket = false;
                }else{
                    process = tvInput.getText().toString();
                    tvInput.setText(process + "(");
                    checkBracket = true;
                }

            }
        });
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString();

                process = process.replaceAll("×","*");
                process = process.replaceAll("%","/100");
                process = process.replaceAll("÷","/");

                Context rhino = Context.enter();

                rhino.setOptimizationLevel(-1);

                String finalResult = "";

                try {
                    Scriptable scriptable = rhino.initStandardObjects();
                    finalResult = rhino.evaluateString(scriptable,process,"javascript",1,null).toString();
                }catch (Exception e){
                    finalResult="0";
                }

                tvOutput.setText(finalResult);
            }
        });
    }
}
