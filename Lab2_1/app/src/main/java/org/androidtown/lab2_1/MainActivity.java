package org.androidtown.lab2_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText Name;
    EditText Age;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText)findViewById(R.id.editText1);
        Age = (EditText)findViewById(R.id.editText2);
        button1 = (Button)findViewById(R.id.btnAdd);

        //action after pressing 'Add' button
        button1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                String name = Name.getText().toString(); //get data from first EditText area
                String age = Age.getText().toString(); //get data from second EditText area

                //Intent for launch new activity
                Intent intent  = new Intent(getApplicationContext(), activity_new.class);
                //passing an input name and age as an Extra argument
                intent.putExtra("loginName", name);
                intent.putExtra("loginAge", age);
                startActivity(intent);

            }
        });
    }

}
