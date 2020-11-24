package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.RadioButton;
import android.os.Bundle;

//Thread that will do heavy math in the background
    class workerThread extends Thread {
        int toFactorial;
        workerThread(int toFactorial) {
            this.toFactorial = toFactorial;
        }
//Heavy math function
        public void run() {
            long bigNum = 1;
            long i = 0;
            while(this.toFactorial >= 1) {
                bigNum *= this.toFactorial;
                this.toFactorial--;
                while (i < bigNum) {
                    i++;
                }
                i = 0;
            }
        }
    }

    public class MainActivity extends AppCompatActivity {

        private int check = 0;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            //Calls start Calculating to allow the GUI to have time to set up before entering a long loop
            startCalculating();
        }

        public void startCalculating(){
            //Heavy math to be done by the program itself
            heavyMath(11);
            //Worker thread does heavy math in the background
            workerThread p = new workerThread(11);
            p.start();
        }

        //Lab 1 GUI code
        public void count(View view) {
            RadioButton bit0 = (RadioButton) findViewById(R.id.radioButton);
            RadioButton bit1 = (RadioButton) findViewById(R.id.radioButton2);
            RadioButton bit2 = (RadioButton) findViewById(R.id.radioButton3);
            check++;
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
            RadioButton bit0 = (RadioButton) findViewById(R.id.radioButton);
            RadioButton bit1 = (RadioButton) findViewById(R.id.radioButton2);
            RadioButton bit2 = (RadioButton) findViewById(R.id.radioButton3);
            bit0.setChecked(false);
            bit1.setChecked(false);
            bit2.setChecked(false);
            check=0;
        }

        //Identical function to the heavy math in the threads
        public void heavyMath(int toFactorial) {
            long bigNum = 1;
            long i = 0;
            while(toFactorial >= 1) {
                bigNum *= toFactorial;
                toFactorial--;
                while(i < bigNum){
                    i++;
                }
                i = 0;
            }

        }

        //Button that allows for switching between task 1 and 2
        public void taskTwo(View view) {
            Intent intent = new Intent(this, TaskTwo.class);
            startActivity(intent);
        }

}