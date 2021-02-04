package com.example.omartask2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv ;
    EditText text;
    Button show , search;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv=(TextView)findViewById(R.id.displayTV);
        text=(EditText) findViewById(R.id.numberET);
        show=(Button) findViewById(R.id.showTheTextBTN);
        search=(Button) findViewById(R.id.searchTheWebBTN);
        intent = new Intent(Intent.ACTION_WEB_SEARCH);

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTheText();
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchTheWeb();
            }
        });
    }

    boolean isNumber(String number){
        for(int i =0 ; i < number.length();i++ )
            if(!Character.isDigit(number.charAt(i)))
                return false;
        return true ;
    }
    void showTheText() {
        String s = text.getText().toString();
        if(s.equals("")){
            tv.setText("please write a number");
        }
        else {
            tv.setText(s);
        }
    }
    void searchTheWeb (){
        String s = text.getText().toString();
        if(!isNumber(s)){
            tv.setText("please enter a valid number");
        }
        else{
            intent.putExtra(SearchManager.QUERY , s );
            startActivity(intent);
        }
    }



}