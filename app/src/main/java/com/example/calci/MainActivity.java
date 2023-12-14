package com.example.calci;



import androidx.appcompat.app.AppCompatActivity;

import android.adservices.common.AdSelectionSignals;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import java.text.NumberFormat;
import java.text.ParseException;

import kotlin.jvm.internal.TypeIntrinsics;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    MaterialButton btnC, btnBO, btnBC, btnAC, btnDot;
    MaterialButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;

    MaterialButton btnDivide, btnMultiply, btnMinus, btnPlus, btnEquals;
    TextView Result;
    TextView Solution;
    String input , output , newOutput;
    MaterialButton btn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Result = findViewById(R.id.Result);
        Solution = findViewById(R.id.Solution);







        assignId(btnC,R.id.btn_c);
        assignId(btnAC,R.id.btnAC);
        assignId(btnDot,R.id.btndot);
        assignId(btnBO,R.id.btn_BO);
        assignId(btnBC,R.id.btn_BC);
        assignId(btn0,R.id.btn0);
        assignId(btn1,R.id.btn1);
        assignId(btn2,R.id.btn2);
        assignId(btn3,R.id.btn3);
        assignId(btn4,R.id.btn4);
        assignId(btn5,R.id.btn5);
        assignId(btn6 , R.id.btn6);
        assignId(btn7,R.id.btn7);
        assignId(btn8 , R.id.btn8);
        assignId(btn9,R.id.btn9);
        assignId(btnPlus,R.id.btn_plus);
        assignId(btnMultiply,R.id.btn_multiply);
        assignId(btnDivide,R.id.btn_Divide);
        assignId(btnMinus,R.id.btn_minus);
        assignId(btnEquals,R.id.btn_equals);

        
}
public void assignId(MaterialButton btn , int  id){
        btn = findViewById(id);
        btn.setOnClickListener(this);

}


    @Override
    public void onClick(View view) {
        btn = (MaterialButton) view;
        String data = btn.getText().toString();
        switch (data){
            case "C":
                input = input.substring(0,input.length()-1);
                Solution.setText(input);
                break;
            case "AC":
                newOutput =null;
                input = null;
                output = null;
                Result.setText("0");
                Solution.setText("");
                break;

            case "*":
                solve();
              input+="*";
              break;
            case "=":
                Solution.setText(Result.getText());
                solve();
                break;
            default:
                if (input == null){
                    input = "";
                }
                if (data.equals("+") || data.equals("/") || data.equals("-")){
                    solve();
                }
                input+=data;
        }
Solution.setText(input);

    }
    public void solve(){
      if (input.split("\\+").length==2){
          String numbers[] = input.split("\\+");
          try {
              double d = Double.parseDouble(numbers[0]) + Double.parseDouble(numbers[1]);
              output = Double.toString(d);
              newOutput = cutDecimal(output);
              Result.setText(newOutput);
              input = d + "";
          }catch (Exception e){
              Result.setError(e.getMessage().toString());
          }
      }
        if (input.split("\\*").length==2){
            String numbers[] = input.split("\\*");
            try {
                double d = Double.parseDouble(numbers[0]) * Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                Result.setText(newOutput);
                input = d + "";
            }catch (Exception e){
                Result.setError(e.getMessage().toString());
            }
        }
        if (input.split("\\/").length==2){
            String numbers[] = input.split("\\/");
            try {
                double d = Double.parseDouble(numbers[0]) / Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                Result.setText(newOutput);
                input = d + "";
            }catch (Exception e){
                Result.setError(e.getMessage().toString());
            }
        }
        if (input.split("\\-").length==2){
            String numbers[] = input.split("\\-");
            try {
                if (Double.parseDouble(numbers[0]) < Double.parseDouble(numbers[1])){
                    double d = Double.parseDouble(numbers[1]) - Double.parseDouble(numbers[0]);
                    output = Double.toString(d);
                    newOutput = cutDecimal(output);
                    Result.setText("-" + newOutput);
                    input = d + "";
                }
                else {
                    double d = Double.parseDouble(numbers[0]) - Double.parseDouble(numbers[1]);
                    output = Double.toString(d);
                    newOutput = cutDecimal(output);
                    Result.setText(newOutput);
                    input = d + "";
                }
            }catch (Exception e){
                Result.setError(e.getMessage().toString());
            }
        }
    }
    public  String cutDecimal(String num) {
        String n[] = num.split("\\.");
        if (n.length > 1){
            if(n[1].equals("0")){
                num = n[0];
            }
        }
        return num;

    }

    }



