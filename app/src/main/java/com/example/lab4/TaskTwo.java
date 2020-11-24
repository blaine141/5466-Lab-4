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

    //Producer Thread
    class producer extends Thread {

        private final BlockingQueue<Integer> Q;
        Random random = new Random();

        producer(BlockingQueue q) {Q = q;}

        public void run() {
            //heavy math section
            while(true){
                int i = 0;
                while(i < 100000){
                    i++;
                }
                i = 0;
                //Check to make sure the queue is not full
                while(Q.size() >= 50) {
                    try {
                        //wait command to allow other threads to perform functions while the producer is idle
                        wait(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //Generate and insert random number into the queue
                int randomInt = random.nextInt(10);
                try {
                    Q.put(randomInt);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //Consumer thread
    class consumer extends Thread {
        private final BlockingQueue<Integer> Q;
        Random random = new Random();

        consumer(BlockingQueue q) {
            Q = q;
        }

        public void run() {
                while (true) {
                    //Heavy Math
                    int i = 0;
                    while (i < 100000) {
                        i++;
                    }
                    i = 0;
                    //Take an item off of the queue
                    try {
                        Q.take();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        //Setting up the activity wide variables for use
    BlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>();
    producer p = new producer(queue);
    consumer c = new consumer(queue);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_two);
        p.start();
        c.start();
        //Main loop for updating the GUI
        while(true){
            try {
                wait(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //Checks the size of the queue and updates LEDs accordingly;
            checkQueue();
        }
    }

    //Raises the priority of the producer
    public void higher(View view){
        int prio = p.getPriority();
        if (prio < Thread.MAX_PRIORITY) {
            prio++;
            p.setPriority(prio);
        }
        return;
    }

    //reduces the priority of the producer
    public void lower(View view){
        int prio = p.getPriority();
        if (prio > Thread.MIN_PRIORITY) {
            prio--;
            p.setPriority(prio);
        }
        return;
    }

    //Function that will check the size of the Queue and update the LED light
    public void checkQueue(){
        int length = queue.size();
        //Add Radio Buttons and Make them respond to the length of the queue
        return;
    }

    //Button that allows the user to switch back to task 1
    public void taskOne(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}