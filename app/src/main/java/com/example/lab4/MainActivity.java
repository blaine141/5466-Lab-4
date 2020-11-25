package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.RadioButton;
import android.os.Bundle;
import android.widget.Toast;


    public class MainActivity extends AppCompatActivity {

        private int check = 0;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }

        Handler handler = new Handler(Looper.getMainLooper());
        public void calculate() {
            int length = 20000;
            int guess = 0;
            while(Math.sqrt(guess) < length)
                guess++;
            final Context context = this;
            handler.post(new Runnable(){
                @Override
                public void run() {
                    Toast.makeText(context, "Heavy computation complete!", Toast.LENGTH_SHORT).show();
                }
            });
        }

        //Lab 1 GUI code
        public void count(View view) {
            RadioButton bit0 = (RadioButton) findViewById(R.id.radioButton);
            RadioButton bit1 = (RadioButton) findViewById(R.id.radioButton2);
            RadioButton bit2 = (RadioButton) findViewById(R.id.radioButton3);
            check = (check % 8) + 1;
            switch(check) {
                case 1:
                    bit0.setChecked(true);
                    bit1.setChecked(false);
                    bit2.setChecked(false);
                    break;
                case 2:
                    bit0.setChecked(false);
                    bit1.setChecked(true);
                    bit2.setChecked(false);
                    break;
                case 3:
                    bit0.setChecked(true);
                    bit1.setChecked(true);
                    bit2.setChecked(false);
                    break;
                case 4:
                    bit0.setChecked(false);
                    bit1.setChecked(false);
                    bit2.setChecked(true);
                    break;
                case 5:
                    bit0.setChecked(true);
                    bit1.setChecked(false);
                    bit2.setChecked(true);
                    break;
                case 6:
                    bit0.setChecked(false);
                    bit1.setChecked(true);
                    bit2.setChecked(true);
                    break;
                case 7:
                    bit0.setChecked(true);
                    bit1.setChecked(true);
                    bit2.setChecked(true);
                    break;
                case 8:
                    bit0.setChecked(false);
                    bit1.setChecked(false);
                    bit2.setChecked(false);
                    check=0;
            }
        }

        public void reset(View view) {
            check = 0;
            count(view);
        }


        //Identical function to the heavy math in the threads
        public void withoutThread(View view) {
            calculate();
        }

        public void withThread(View view) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    super.run();
                    calculate();
                }
            };
            t.start();
        }

        //Button that allows for switching between task 1 and 2
        public void taskTwo(View view) {
            Intent intent = new Intent(this, TaskTwo.class);
            startActivity(intent);
        }

}