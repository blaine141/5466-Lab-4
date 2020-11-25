package com.example.lab4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.LinkedList;

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
                    sleep(10);
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

public class TaskTwo extends AppCompatActivity {

    //Setting up the activity wide variables for use
    BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
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
        RadioButton b1 = (RadioButton) findViewById(R.id.b1);
        RadioButton b2 = (RadioButton) findViewById(R.id.b2);
        RadioButton b3 = (RadioButton) findViewById(R.id.b3);
        RadioButton b4 = (RadioButton) findViewById(R.id.b4);
        RadioButton b5 = (RadioButton) findViewById(R.id.b5);
        RadioButton b6 = (RadioButton) findViewById(R.id.b6);
        RadioButton b7 = (RadioButton) findViewById(R.id.b7);
        RadioButton b8 = (RadioButton) findViewById(R.id.b8);
        RadioButton b9 = (RadioButton) findViewById(R.id.b9);
        RadioButton b10 = (RadioButton) findViewById(R.id.b10);
        RadioButton b11 = (RadioButton) findViewById(R.id.b11);
        RadioButton b12 = (RadioButton) findViewById(R.id.b12);
        RadioButton b13 = (RadioButton) findViewById(R.id.b13);
        RadioButton b14 = (RadioButton) findViewById(R.id.b14);
        RadioButton b15 = (RadioButton) findViewById(R.id.b15);
        RadioButton b16 = (RadioButton) findViewById(R.id.b16);
        RadioButton b17 = (RadioButton) findViewById(R.id.b17);
        RadioButton b18 = (RadioButton) findViewById(R.id.b18);
        RadioButton b19 = (RadioButton) findViewById(R.id.b19);
        RadioButton b20 = (RadioButton) findViewById(R.id.b20);
        RadioButton b21 = (RadioButton) findViewById(R.id.b21);
        RadioButton b22 = (RadioButton) findViewById(R.id.b22);
        RadioButton b23 = (RadioButton) findViewById(R.id.b23);
        RadioButton b24 = (RadioButton) findViewById(R.id.b24);
        RadioButton b25 = (RadioButton) findViewById(R.id.b25);
        RadioButton b26 = (RadioButton) findViewById(R.id.b26);
        RadioButton b27 = (RadioButton) findViewById(R.id.b27);
        RadioButton b28 = (RadioButton) findViewById(R.id.b28);
        RadioButton b29 = (RadioButton) findViewById(R.id.b29);
        RadioButton b30 = (RadioButton) findViewById(R.id.b30);
        RadioButton b31 = (RadioButton) findViewById(R.id.b31);
        RadioButton b32 = (RadioButton) findViewById(R.id.b32);
        RadioButton b33 = (RadioButton) findViewById(R.id.b33);
        RadioButton b34 = (RadioButton) findViewById(R.id.b34);
        RadioButton b35 = (RadioButton) findViewById(R.id.b35);
        RadioButton b36 = (RadioButton) findViewById(R.id.b36);
        RadioButton b37 = (RadioButton) findViewById(R.id.b37);
        RadioButton b38 = (RadioButton) findViewById(R.id.b38);
        RadioButton b39 = (RadioButton) findViewById(R.id.b39);
        RadioButton b40 = (RadioButton) findViewById(R.id.b40);
        RadioButton b41 = (RadioButton) findViewById(R.id.b41);
        RadioButton b42 = (RadioButton) findViewById(R.id.b42);
        RadioButton b43 = (RadioButton) findViewById(R.id.b43);
        RadioButton b44 = (RadioButton) findViewById(R.id.b44);
        RadioButton b45 = (RadioButton) findViewById(R.id.b45);
        RadioButton b46 = (RadioButton) findViewById(R.id.b46);
        RadioButton b47 = (RadioButton) findViewById(R.id.b47);
        RadioButton b48 = (RadioButton) findViewById(R.id.b48);
        RadioButton b49 = (RadioButton) findViewById(R.id.b49);
        RadioButton b50 = (RadioButton) findViewById(R.id.b50);

        if(length>=1){
            b1.setChecked(true);
        }else{
            b1.setChecked(false);
        }
        if(length>=2){
            b2.setChecked(true);
        } else{
            b2.setChecked(false);
        }
        if(length>=3){
            b3.setChecked(true);
        }else{
            b3.setChecked(false);
        }
        if(length>=4){
            b4.setChecked(true);
        }else{
            b4.setChecked(false);
        }
        if(length>=5){
            b5.setChecked(true);
        }else{
            b5.setChecked(false);
        }
        if(length>=6){
            b6.setChecked(true);
        }else{
            b6.setChecked(false);
        }
        if(length>=7){
            b7.setChecked(true);
        }else{
            b7.setChecked(false);
        }
        if(length>=8){
            b8.setChecked(true);
        }else{
            b8.setChecked(false);
        }
        if(length>=9){
            b9.setChecked(true);
        }else{
            b9.setChecked(false);
        }
        if(length>=10){
            b10.setChecked(true);
        }else{
            b10.setChecked(false);
        }
        if(length>=11){
            b11.setChecked(true);
        }else{
            b11.setChecked(false);
        }
        if(length>=12){
            b12.setChecked(true);
        } else{
            b12.setChecked(false);
        }
        if(length>=13){
            b13.setChecked(true);
        }else{
            b13.setChecked(false);
        }
        if(length>=14){
            b14.setChecked(true);
        }else{
            b14.setChecked(false);
        }
        if(length>=15){
            b15.setChecked(true);
        }else{
            b15.setChecked(false);
        }
        if(length>=16){
            b16.setChecked(true);
        }else{
            b16.setChecked(false);
        }
        if(length>=17){
            b17.setChecked(true);
        }else{
            b17.setChecked(false);
        }
        if(length>=18){
            b18.setChecked(true);
        }else{
            b18.setChecked(false);
        }
        if(length>=19){
            b19.setChecked(true);
        }else{
            b19.setChecked(false);
        }
        if(length>=20){
            b20.setChecked(true);
        }else{
            b20.setChecked(false);
        }
        if(length>=21){
            b21.setChecked(true);
        }else{
            b21.setChecked(false);
        }
        if(length>=22){
            b22.setChecked(true);
        } else{
            b22.setChecked(false);
        }
        if(length>=23){
            b23.setChecked(true);
        }else{
            b23.setChecked(false);
        }
        if(length>=24){
            b24.setChecked(true);
        }else{
            b24.setChecked(false);
        }
        if(length>=25){
            b25.setChecked(true);
        }else{
            b25.setChecked(false);
        }
        if(length>=26){
            b26.setChecked(true);
        }else{
            b26.setChecked(false);
        }
        if(length>=27){
            b27.setChecked(true);
        }else{
            b27.setChecked(false);
        }
        if(length>=28){
            b28.setChecked(true);
        }else{
            b28.setChecked(false);
        }
        if(length>=29){
            b29.setChecked(true);
        }else{
            b29.setChecked(false);
        }
        if(length>=30){
            b30.setChecked(true);
        }else{
            b30.setChecked(false);
        }
        if(length>=31){
            b31.setChecked(true);
        }else{
            b31.setChecked(false);
        }
        if(length>=32){
            b32.setChecked(true);
        } else{
            b32.setChecked(false);
        }
        if(length>=33){
            b33.setChecked(true);
        }else{
            b33.setChecked(false);
        }
        if(length>=34){
            b34.setChecked(true);
        }else{
            b34.setChecked(false);
        }
        if(length>=35){
            b35.setChecked(true);
        }else{
            b35.setChecked(false);
        }
        if(length>=36){
            b36.setChecked(true);
        }else{
            b36.setChecked(false);
        }
        if(length>=37){
            b37.setChecked(true);
        }else{
            b37.setChecked(false);
        }
        if(length>=38){
            b38.setChecked(true);
        }else{
            b38.setChecked(false);
        }
        if(length>=39){
            b39.setChecked(true);
        }else{
            b39.setChecked(false);
        }
        if(length>=40){
            b40.setChecked(true);
        }else{
            b40.setChecked(false);
        }
        if(length>=41){
            b41.setChecked(true);
        }else{
            b41.setChecked(false);
        }
        if(length>=42){
            b42.setChecked(true);
        } else{
            b42.setChecked(false);
        }
        if(length>=43){
            b43.setChecked(true);
        }else{
            b43.setChecked(false);
        }
        if(length>=44){
            b44.setChecked(true);
        }else{
            b44.setChecked(false);
        }
        if(length>=45){
            b45.setChecked(true);
        }else{
            b45.setChecked(false);
        }
        if(length>=46){
            b46.setChecked(true);
        }else{
            b46.setChecked(false);
        }
        if(length>=47){
            b47.setChecked(true);
        }else{
            b47.setChecked(false);
        }
        if(length>=48){
            b48.setChecked(true);
        }else{
            b48.setChecked(false);
        }
        if(length>=49){
            b49.setChecked(true);
        }else{
            b49.setChecked(false);
        }
        if(length>=50){
            b50.setChecked(true);
        }else{
            b50.setChecked(false);
        }

        return;
    }

    //Button that allows the user to switch back to task 1
    public void taskOne(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}