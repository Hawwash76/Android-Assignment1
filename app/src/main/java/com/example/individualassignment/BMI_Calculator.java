package com.example.individualassignment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.text.DecimalFormat;

public class BMI_Calculator extends AppCompatActivity {

    private EditText heightTxt;
    private EditText weightTxt;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi_calculator_xml);
        heightTxt=findViewById(R.id.heightTxt);
        weightTxt=findViewById(R.id.weightTxt);
        result=findViewById(R.id.bmiResult);
    }

    public void calculateBMI(View view) {

        Thread thread = new Thread(new MyTask());

        thread.start();


    }

    class MyTask implements Runnable{

        @Override
        public void run() {

            String str1=heightTxt.getText().toString();
            double height=Double.parseDouble(str1);
            String str2=weightTxt.getText().toString();
            double weight=Double.parseDouble(str2);

            double bmi=((weight)/(height*height))*10000;
            DecimalFormat twoDForm = new DecimalFormat("#.##");
            bmi=Double.parseDouble(twoDForm.format(bmi));
            if(bmi<18.5){
                result.setText("Underweight, Your BMI is: "+bmi);
            }
            else if(bmi>18.5 && bmi<24.9){
                result.setText("Normal Weight, Your BMI is: "+bmi);
            }
            else if(bmi>24.9 && bmi<29.9){
                result.setText("Overweight, Your BMI is: "+bmi);
            }
            else if(bmi>30) {
                result.setText("Obese, Your BMI is: " + bmi);
            }
        }
    }

    public void btnLoad(View view) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        Gson gson = new Gson();
        String str = prefs.getString("bmi", "");
        String bmiResult = gson.fromJson(str, String.class);
        result.setText(bmiResult);
    }

    public void btnSave(View view) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String str= (String) result.getText();
        String gsonString=gson.toJson(str);
        editor.putString("bmi", gsonString);
        editor.commit();
        Toast.makeText(this, "Data Saved:\n" + gsonString,
                Toast.LENGTH_SHORT).show();
    }
}