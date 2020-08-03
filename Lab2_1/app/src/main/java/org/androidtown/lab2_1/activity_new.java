package org.androidtown.lab2_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class activity_new extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        Intent passedIntent = getIntent();
        if (passedIntent != null) {
            //receive passed extra arguments(name and age)
            String loginName = passedIntent.getStringExtra("loginName");
            String loginAge = passedIntent.getStringExtra("loginAge");

            //provide a simple feedback about student name and age with a Toast
            Toast.makeText(getApplicationContext(), "Student info : " + loginName + ", " + loginAge, Toast.LENGTH_LONG).show();
        }

        Button button0 = (Button) findViewById(R.id.btnClose);

        //if button0 pressed, activity is closed
        button0.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}
