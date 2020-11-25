package com.example.lab4;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class TaskTwo extends AppCompatActivity {

    //Setting up the activity wide variables for use
    BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(30);
    Random random = new Random();
    Thread producer;
    Thread consumer;
    Timer timer = new Timer();
    TimerTask task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_two);

        producer = new Thread(){
            @Override
            public void run() {
                super.run();
                while(true) {
                    calculate();
                    try {
                        queue.put(random.nextInt() % 10);
                    }catch (InterruptedException e){}
                }
            }
        };
        producer.start();

        consumer = new Thread(){
            @Override
            public void run() {
                super.run();
                while(true) {
                    calculate();
                    try {
                        queue.take();
                    }catch (InterruptedException e){}
                }
            }
        };
        consumer.start();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                checkQueue();
            }
        }, 0,200);
    }

    public void calculate() {
        int length = 2000;
        int guess = 0;
        while(Math.sqrt(guess) < length)
            guess++;
        final Context context = this;
    }

    //Raises the priority of the producer
    public void higher(View view){
        int prio = producer.getPriority();
        if (prio < Thread.MAX_PRIORITY) {
            prio++;
            producer.setPriority(prio);
        }
    }

    //reduces the priority of the producer
    public void lower(View view){
        int prio = producer.getPriority();
        if (prio > Thread.MIN_PRIORITY) {
            prio--;
            producer.setPriority(prio);
        }
    }

    //Function that will check the size of the Queue and update the LED light
    public void checkQueue(){
        int length = queue.size();
        for(int i = 1; i <= 30; i++) {
            int id = getResources().getIdentifier("counterLED" + i, "id", getPackageName());
            RadioButton button = findViewById(id);
            button.setChecked(i <= length);
        }
    }

    //Button that allows the user to switch back to task 1
    public void taskOne(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}