package com.example.calculatingfibonaccinumbers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView outputResult;
    private FibonacciNumbers fibNumbers;
    private boolean calcaleCycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        outputResult = (TextView)findViewById(R.id.textView2);
        outputResult.setMaxLines(Integer.MAX_VALUE);
        outputResult.setMovementMethod(new ScrollingMovementMethod());

        fibNumbers = new FibonacciNumbers();
        calcaleCycle = true;
    }

    public void ChangeVariantCalcule(View v) {
        if (v.getId() == R.id.radioButtonCycle) calcaleCycle = true; else calcaleCycle = false;
        outputResult.setText("");
        outputResult.scrollTo(0,0);
    }

    public void Calculate(View v) {
        EditText numLength = (EditText)findViewById(R.id.editTextNumberDecimal);
        String tempStr = numLength.getText().toString();

        //Если кол. чисел больше нуля
        if (tempStr.length() > 0) {

            int sizeValue = Integer.parseInt(tempStr);

            //Если число больше нуля
            if (sizeValue > 0)
            {
                //Задать размер просчетов
                fibNumbers.setLengthCalcule(sizeValue);

                //Просчитать в зависимости от выбранного варианта
                if (calcaleCycle) fibNumbers.CalculeCycle(); else fibNumbers.CalculeRecurse();

                ArrayList<Long> tempArr = new ArrayList<Long>();
                tempArr = fibNumbers.getFinalValues();

                outputResult.setText("");
                for (int i = 0; i < tempArr.size(); i++) outputResult.append(String.valueOf(tempArr.get(i)) + '\n');
            }else
            {
                Toast.makeText(MainActivity.this, "Значение должно быть больше нуля", Toast.LENGTH_SHORT).show();
            }
        } else
        {
            Toast.makeText(MainActivity.this, "Введите колличество чисел", Toast.LENGTH_SHORT).show();
        }
    }
}