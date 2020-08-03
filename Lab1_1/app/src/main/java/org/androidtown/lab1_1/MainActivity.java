package org.androidtown.lab1_1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    ImageView imageView2;
    int imageIndex = 0; //to check which picture is to be displayed.
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView=(ImageView)findViewById(R.id.imageView4);
        imageView2=(ImageView)findViewById(R.id.imageView5);
    }

    /*If onButton1Clicked method called, call changeImage method*/
    public void onButton1Clicked(View v){
        changeImage();
    }

    /*By changing an imageIndex value,
     *decide which pictures to show and which ones to hide.*/
    private void changeImage(){
        if(imageIndex == 1){
            imageView.setVisibility(View.VISIBLE);
            imageView2.setVisibility(View.INVISIBLE);
            imageIndex = 0;
        }
        else if(imageIndex ==0){
            imageView.setVisibility(View.INVISIBLE);
            imageView2.setVisibility(View.VISIBLE);
            imageIndex = 1;
        }
    }
}
