package com.example.deposit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CounterActivity extends AppCompatActivity {

//    private Button btn3, btn4 ;
//    private TextView countResult ;

    private TextView calResult ;

    private Button calCancel, negative, mod, divider,
                   num7, num8, num9, multiplier,
                   num4, num5, num6, minus,
                   num1, num2, num3, add,
                   num0, dot, equal,
                   confirm, cancel ;

    private String num0_text, num1_text, num2_text, num3_text,
                   num4_text, num5_text, num6_text, num7_text,
                   num8_text, num9_text ;

    private String calCancel_text, negative_text, mod_text, divider_text,
                   multiplier_text, minus_text, add_text, dot_text, equal_text ;


    private boolean isNum ;

    private String result = "" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        initialize();
        processController() ;


    }

    public void initialize(){
//        btn3 = (Button)findViewById(R.id.btn3) ;
//        btn4 = (Button)findViewById(R.id.btn4) ;
//        countResult = (TextView)findViewById(R.id.countResult) ;

        calResult = (TextView)findViewById(R.id.calResult) ;

        calCancel = (Button)findViewById(R.id.calCancel) ;
        negative  = (Button)findViewById(R.id.negative) ;
        calCancel_text = calCancel.getText().toString() ;
        negative_text = negative.getText().toString() ;

        mod  = (Button)findViewById(R.id.mod) ;
        divider  = (Button)findViewById(R.id.divider) ;
        mod_text = mod.getText().toString() ;
        divider_text = divider.getText().toString() ;

        num7  = (Button)findViewById(R.id.num7) ;
        num8  = (Button)findViewById(R.id.num8) ;
        num9  = (Button)findViewById(R.id.num9) ;
        multiplier  = (Button)findViewById(R.id.multiplier) ;
        num7_text = num7.getText().toString() ;
        num8_text = num8.getText().toString() ;
        num9_text = num9.getText().toString() ;
        multiplier_text = multiplier.getText().toString() ;

        num4  = (Button)findViewById(R.id.num4) ;
        num5  = (Button)findViewById(R.id.num5) ;
        num6  = (Button)findViewById(R.id.num6) ;
        minus  = (Button)findViewById(R.id.minus) ;
        num4_text = num4.getText().toString() ;
        num5_text = num5.getText().toString() ;
        num6_text = num6.getText().toString() ;
        minus_text = minus.getText().toString() ;

        num1  = (Button)findViewById(R.id.num1) ;
        num2  = (Button)findViewById(R.id.num2) ;
        num3  = (Button)findViewById(R.id.num3) ;
        add  = (Button)findViewById(R.id.add) ;
        num1_text = num1.getText().toString() ;
        num2_text = num2.getText().toString() ;
        num3_text = num3.getText().toString() ;
        add_text = add.getText().toString() ;

        num0  = (Button)findViewById(R.id.num0) ;
        dot  = (Button)findViewById(R.id.dot) ;
        equal  = (Button)findViewById(R.id.equal) ;
        num0_text = num0.getText().toString() ;
        dot_text = dot.getText().toString() ;
        equal_text = equal.getText().toString() ;

        confirm  = (Button)findViewById(R.id.confirm) ;

    }

    public void processController(){
//        btn3.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                countResult.setText("3");
//            }
//        });
    }

//    public void cancel(View view){
//        String countResult = this.countResult.getText() == null ? "" : this.countResult.getText().toString() ;
//        Intent result = getIntent() ;
//        result.putExtra("countResult", countResult) ;
//        setResult(0, result);
//        finish() ;
//
//    }

    public void calOnclick(View view){

        switch(view.getId()){
            case R.id.calCancel:
                break ;
            case R.id.negative:
                break ;
            case R.id.mod:
                break ;
            case R.id.divider:
                break ;
            case R.id.num7:
                count(true,num7_text) ;
                break ;
            case R.id.num8:
                count(true,num8_text) ;
                break ;
            case R.id.num9:
                count(true,num9_text) ;
                break ;
            case R.id.multiplier:
                break ;
            case R.id.num4:
                count(true,num4_text) ;
                break ;
            case R.id.num5:
                count(true,num5_text) ;
                break ;
            case R.id.num6:
                count(true,num6_text) ;
                break ;
            case R.id.minus:
                break ;
            case R.id.num1:
                count(true,num1_text) ;
                break ;
            case R.id.num2:
                count(true,num2_text) ;
                break ;
            case R.id.num3:
                count(true,num3_text) ;
                break ;
            case R.id.add:
                count(false,"+") ;
                break ;
            case R.id.num0:
                count(true,num0_text) ;
                break ;
            case R.id.dot:
                break ;
            case R.id.equal:
                count(false,"=") ;
                break ;
        }


    }

    public void confirmOnClick(View view){
        String calResult = this.calResult.getText() == null ? "" : this.calResult.getText().toString() ;
        Intent result = getIntent() ;
        result.putExtra("calResult",calResult) ;
        setResult(0, result);
        finish() ;
    }

    public void count(boolean isNum,String content){
        if(isNum){
            calResult.setText(result += content) ;
        }else{
            int total = calResult(result, content, result, "=") ;
            if(content.equals("=") && total > -1){
                calResult.setText(String.valueOf(total)) ;
            }
        }
    }

    public int calResult(String x1, String sign1, String x2, String sign2){
        int num1 = Integer.parseInt(x1) ;
        int num2 = Integer.parseInt(x2) ;
        if( (x1 != null && ! x1.equals("")) && (x2 != null && ! x2.equals("")) &&
        (sign1 != null && ! sign1.equals("")) && (sign2 != null && ! sign2.equals(""))){
            switch(sign1){
                case "+":
                    return num1+num2 ;
                case "-":
                    return num1-num2 ;
                case "*":
                    return num1*num2 ;
                case "/":
                    return num1/num2 ;
            }
        }else{
            return -1 ;
        }
        return -1 ;
    }




}
