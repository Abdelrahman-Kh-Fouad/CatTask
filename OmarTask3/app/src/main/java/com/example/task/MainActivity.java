package com.example.task;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    TextView answer1 ;
    RadioGroup answer2 ;
    ArrayList<CheckBox>answer3;
    RadioGroup answer4 ;


    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        answer1 = (TextView)findViewById(R.id.answer1text);
        answer2 = (RadioGroup)findViewById(R.id.answer2radiogroup);
        answer3.add((CheckBox) findViewById(R.id.answer3check0));
        answer3.add((CheckBox) findViewById(R.id.answer3check1));
        answer3.add((CheckBox) findViewById(R.id.answer3check2));
        answer3.add((CheckBox) findViewById(R.id.answer3check3));

        answer4 = (RadioGroup)findViewById(R.id.answer4radiogroup);
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext() , result() , Toast.LENGTH_LONG);

            }
        });

    }

    int getnumber(){
        int res =0 ;
        for (int i =0 ;i < 4 ;i++){
            if(answer3.get(i).isChecked())
                res += setbit(res ,i  );
        }

        return res ;
    }
    int result(){
        int result = 0 ;
        if(answer1.getText()=="4")
            result ++ ;

        if(answer2.getCheckedRadioButtonId()==R.id.answer2radio0)
            result++;
        if(getnumber() ==  7 )
            result++;

        if(answer4.getCheckedRadioButtonId()==R.id.answer4radio0);
            result++;
        return result;
    }
    
    void init(){

    }





    int setbit(int num ,int ind ){
        return (1<< ind ) & num ;
    }
}