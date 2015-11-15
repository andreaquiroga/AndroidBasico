package com.example.dell.colgado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private String word;
    private ArrayList<TextView> wordContainer;
    private int error = 0;

    public TextView createLetter()
    {
        LinearLayout layout=(LinearLayout)findViewById(R.id.linearWord);
        TextView txtView = new TextView(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.RIGHT;

        txtView.setLayoutParams(layoutParams);
        txtView.setText(" _ ");
        txtView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        layout.addView(txtView);
        return txtView;
    }

    public String getWord()
    {
        ArrayList<String> words = new ArrayList<>();
        words.add("CASA");
        words.add("LAMPARA");
        words.add("COCINA");
        words.add("REFRIGERADOR");
        words.add("CORTINAS");
        words.add("PERRO");
        words.add("CAMA");
        words.add("SILLON");
        Random R = new Random();
        return words.get(R.nextInt(7));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        word = getWord();
        wordContainer = new ArrayList<TextView>();
        for(int i=0;i<word.length();i++)
        {
            wordContainer.add(createLetter());
        }
        error = 0;
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

    public void GetLetterValue(View view)
    {
        Button button = (Button)view;
        String letter = (String)button.getText();
        boolean find = false;
        for (int i = 0; i <word.length();i++)
        {
            if(word.charAt(i) == letter.charAt(0))
            {
                wordContainer.get(i).setText(" "+letter+" ");
                find = true;
            }
        }
        if(!find) {
            ImageView iv = (ImageView) findViewById(R.id.imageView);
            error++;
            switch (error) {
                case 1:
                    iv.setImageResource(R.drawable.p2);
                    break;
                case 2:
                    iv.setImageResource(R.drawable.p);
                    break;
                case 3:
                    iv.setImageResource(R.drawable.p4);
                    break;
                case 4:
                    iv.setImageResource(R.drawable.p5);
                    break;
                case 5:
                    iv.setImageResource(R.drawable.p6);
                    break;
                case 6:
                    iv.setImageResource(R.drawable.p7);
                    wordContainer.get(0).setText("--------Perdiste!--------");
                    break;
            }
        }
    }
}
