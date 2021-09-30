package com.example.hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

class ValSet{

    private double v1 = 0.0;
    private double v2 = 0.0;
    private boolean check = true;

    public ValSet(double v1, double v2){
        this.v1 = v1;
        this.v2 = v2;
    }

    public ValSet(boolean check){
        this.check = check;
    }

    public double getV1(){
        return v1;
    }

    public double getV2() {
        return v2;
    }

    public boolean getCheck() {
        return check;
    }
}

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //button을 java로 불러옴
        Button button_plus = findViewById(R.id.button_plus);  // 더하기 button
        Button button_minus = findViewById(R.id.button_minus); // 빼기 button
        Button button_multiply = findViewById(R.id.button_multiply); // 곱하기 button
        Button button_division = findViewById(R.id.button_division);    // 나누기 button

        //textView_result를 java로 불러옴
        TextView textView_result = findViewById(R.id.textView_result); //결과값 출력할 textView

        //더하기 버튼이 눌렸을 경우
        button_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ValSet result = input_v1_v2();
                if(input_v1_v2().getCheck() == true){
                    textView_result.setText("결과값 : " + (result.getV1() + result.getV2()));
                }
                else if (input_v1_v2().getCheck() == false){
                    textView_result.setText("잘못 입력하셨습니다.");
                }
            }
        });

        button_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ValSet result = input_v1_v2();
                if(input_v1_v2().getCheck() == true){
                    textView_result.setText("결과값 : " + (result.getV1() - result.getV2()));
                }
                else if (input_v1_v2().getCheck() == false){
                    textView_result.setText("잘못 입력하셨습니다.");
                }
            }
        });

        button_multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ValSet result = input_v1_v2();
                if(input_v1_v2().getCheck() == true){
                    textView_result.setText("결과값 : " + (result.getV1() * result.getV2()));
                }
                else if (input_v1_v2().getCheck() == false){
                    textView_result.setText("잘못 입력하셨습니다.");
                }
            }
        });

        button_division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ValSet result = input_v1_v2();
                if(input_v1_v2().getCheck() == true){
                    textView_result.setText("결과값 : " + (result.getV1() / result.getV2()));
                }
                else if (input_v1_v2().getCheck() == false){
                    textView_result.setText("잘못 입력하셨습니다.");
                }
            }
        });

    }

    private ValSet input_v1_v2() {
        double val1 = 0.0, val2 = 0.0;

        try {
            /* val1, val2 java로 불러옴 */
            EditText val1_e = findViewById(R.id.val1);
            EditText val2_e = findViewById(R.id.val2);

            // val1, val2를 double로 변환
            val1 = Double.parseDouble(val1_e.getText().toString());
            val2 = Double.parseDouble(val2_e.getText().toString());

            return new ValSet(val1, val2);
        } catch (Throwable e) {
            //textView_result.setText("정수를 입력해 주세요");
            e.printStackTrace();
            return new ValSet(false);
        }
    }
}