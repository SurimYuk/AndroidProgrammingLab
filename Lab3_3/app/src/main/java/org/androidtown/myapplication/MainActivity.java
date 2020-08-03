package org.androidtown.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    FirstFragment firstFragment;
    SecondFragment secondFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();

        Button tab1 = (Button)findViewById(R.id.tab1);
        tab1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //if tab1 button pressed, replace activity_main's FrameLayout with first fragment
                getSupportFragmentManager().beginTransaction().replace(R.id.container, firstFragment).commit();
            }
        });

        Button tab2 = (Button)findViewById(R.id.tab2);
        tab2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //if tab2 button pressed, replace activity_main's FrameLayout with second fragment
                getSupportFragmentManager().beginTransaction().replace(R.id.container, secondFragment).commit();
            }
        });
    }
}
