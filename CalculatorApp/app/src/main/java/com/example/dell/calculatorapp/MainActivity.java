package com.example.dell.calculatorapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.dell.calculatorapp.Utils.Parser;

public class MainActivity extends AppCompatActivity {

    private TextView txtView;
    private boolean isResult = false;
    private boolean isValidExpression = true;
    private char lastbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtView = (TextView) findViewById(R.id.txt_result);
        txtView.setText("0");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void on_click_equals(View view){
        Parser parser = new Parser((String)txtView.getText());
        double result = parser.parse();
        txtView.setText(String.valueOf(result));
        isResult = true;
    }

    public void on_click_operators(View view){
        String textToAdd = "";
        String actualText = (String) txtView.getText();
        switch (view.getId()){
            case R.id.btn_plus:
                textToAdd = "+";
                break;
            case R.id.btn_minus:
                textToAdd = "-";
                break;
            case R.id.btn_multiply:
                textToAdd = "*";
                break;
            case R.id.btn_div:
                textToAdd = "/";
                break;
        }
        if(actualText == "0")
            actualText = "";
        txtView.setText(actualText + textToAdd);
    }

    public void on_click_erase_functions(View view)
    {
        String actualText = (String) txtView.getText();

        switch (view.getId()){
            case R.id.btn_del:
                txtView.setText("0");
                break;
            case R.id.btn_erase:
                if(actualText != "0" && !isResult)
                    txtView.setText(actualText.substring(0,actualText.length()-1));
                break;
        }
    }

    public void on_click_numbers(View view){
        String textToAdd = "";
        String actualText = (String) txtView.getText();
        switch (view.getId()){
            case R.id.btn_0:
                textToAdd = "0";
                break;
            case R.id.btn_1:
                textToAdd = "1";
                break;
            case R.id.btn_2:
                textToAdd = "2";
                break;
            case R.id.btn_3:
                textToAdd = "3";
                break;
            case R.id.btn_4:
                textToAdd = "4";
                break;
            case R.id.btn_5:
                textToAdd = "5";
                break;
            case R.id.btn_6:
                textToAdd = "6";
                break;
            case R.id.btn_7:
                textToAdd = "7";
                break;
            case R.id.btn_8:
                textToAdd = "8";
                break;
            case R.id.btn_9:
                textToAdd = "9";
                break;
            case R.id.btn_p:
                textToAdd = ".";
                break;
        }
        if(actualText == "0" || isResult == true) {
            actualText = "";
            isResult = false;
        }
        txtView.setText(actualText + textToAdd);
    }
}
