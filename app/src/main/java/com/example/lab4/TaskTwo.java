package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.Random;
import java.lang.Math;

public class TaskTwo extends AppCompatActivity {

    class producer extends Thread {
        private final BlockingQueue<Integer> Q;
        Random random = new Random();
        producer(BlockingQueue q) {Q = q;}
        public void run() {
            while(true){
                //Insert Heavy Math
                int randomInt = random.nextInt(10);
                try {
                    Q.put(randomInt);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class consumer extends Thread {
        private final BlockingQueue<Integer> Q;
        Random random = new Random();
        consumer(BlockingQueue q) {Q = q;}
        public void run() {
            while(true){
                //Heavy Math
                try {
                    Q.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    BlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>();
    producer p = new producer(queue);
    consumer c = new consumer(queue);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_two);
        p.start();
        c.start();
        while(true){
            try {
                wait(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            checkQueue();
        }
    }

    public void higher(View view){
        int prio = p.getPriority();
        if (prio < Thread.MAX_PRIORITY) {
            prio++;
            p.setPriority(prio);
        }
        return;
    }

    public void lower(View view){
        int prio = p.getPriority();
        if (prio > Thread.MIN_PRIORITY) {
            prio--;
            p.setPriority(prio);
        }
    }

    public void checkQueue(){
        int length = queue.size();
        //Add Radio Buttons and Make them respond to the length of the queue
    }

    public void taskOne(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}