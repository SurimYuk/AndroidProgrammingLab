package org.androidtown.lab5_1;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageView imageView1;
    ImageView imageView2;
    EditText editText;
    Button button;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = (ImageView)findViewById(R.id.imageView1);
        imageView2 = (ImageView)findViewById(R.id.imageView2);
        editText = (EditText)findViewById(R.id.editText);
        button = (Button)findViewById(R.id.button);
        //start action by pressing button
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Thread allows two images to work separately
                AndroidThread thread1 = new AndroidThread(0);
                thread1.start();
                AndroidThread thread2 = new AndroidThread(1);
                thread2.start();
            }
        });
    }

    class AndroidThread extends Thread{
        int androidIndex;
        int stateIndex;

        //to manage multiple images as a single array list
        ArrayList<Integer> images = new ArrayList<Integer>();

        public AndroidThread(int index){
            androidIndex = index;
            //add images into an array list
            images.add(R.drawable.greenandroid);
            images.add(R.drawable.blueandroid);
            images.add(R.drawable.purpleandroid);
        }

        //run thread
        public void run(){
            stateIndex = 0;
            for(int i = 0; i < 9; i++){
                final String msg = "android #" + androidIndex + "state: " + stateIndex;

                //post() method of handler make run run() method within a runnable object
                handler.post(new Runnable(){
                   public void run(){
                       editText.append(msg + "\n");

                       if(androidIndex == 0){
                           imageView1.setImageResource(images.get(stateIndex)); //change image
                       } else if(androidIndex == 1){
                           imageView2.setImageResource(images.get(stateIndex)); //change image
                       }
                   }
                });

                try{
                    int sleepTime = getRandomTime(500, 3000); //decide sleep time through getRandomTime method
                    Thread.sleep(sleepTime); //pause during sleepTime
                } catch(InterruptedException e){
                    e.printStackTrace();
                }

                //for changing image
                stateIndex++;//index for order of images in the array list
                if(stateIndex >= images.size()){
                    stateIndex = 0;
                }
            }
        }

        //calculate random time
        public int getRandomTime(int min, int max){
            return min+(int)(Math.random() * (max-min));
        }
    }
}
