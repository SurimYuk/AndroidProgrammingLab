package org.androidtown.lab4_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout linearLayout;
    Button openBtn;
    Button closeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = (LinearLayout)findViewById(R.id.linear2);
        openBtn = (Button)findViewById(R.id.openPage);
        closeBtn = (Button)findViewById(R.id.closePage);

        /*
        If open button is clicked, make sliding area visible.
        And do left slide animation.
        */
        openBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                linearLayout.setVisibility(View.VISIBLE);
                Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.left_slide);
                linearLayout.startAnimation(anim);
        }

        });

        /*
        If close button is clicked, make sliding area visible.
        And do right slide animation.
        After the animation, make sliding are invisible.
        */
        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                linearLayout.setVisibility(View.VISIBLE);
                Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_slide);
                linearLayout.startAnimation(anim);
                linearLayout.setVisibility(View.INVISIBLE);
            }

        });
    }
}
