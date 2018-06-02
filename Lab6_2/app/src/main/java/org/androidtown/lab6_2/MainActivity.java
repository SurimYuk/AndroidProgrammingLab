package org.androidtown.lab6_2;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText sn;
    EditText name;
    Button readBtn;
    Button saveBtn;
    Button initBtn;
    SharedPreferences sharedpreferences;
    SharedPreferences.Editor toEdit;
    String studentNum, studentName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sn = (EditText)findViewById(R.id.sn);
        name = (EditText)findViewById(R.id.name);
        readBtn = (Button)findViewById(R.id.readBtn);
        saveBtn = (Button)findViewById(R.id.saveBtn);
        initBtn = (Button)findViewById(R.id.initBtn);

        //button for saving information
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                studentName = name.getText().toString();
                studentNum = sn.getText().toString();
                sharedPreferences();
            }
        });

        //button for reading information from saved one
        readBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readSharedPreferences();
            }
        });

        initBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sn.setText("");
                name.setText("");
            }
        });
    }

    //save data by using shared preferences
    public void sharedPreferences(){
        sharedpreferences = getSharedPreferences("input information", MODE_PRIVATE);
        toEdit = sharedpreferences.edit();
        toEdit.putString("studentNumber", studentNum);
        toEdit.putString("studentName", studentName);
        toEdit.commit();
    }

    //read data from shared preference
    public void readSharedPreferences(){
        sharedpreferences = getSharedPreferences("input information", MODE_PRIVATE);
        if(sharedpreferences != null && sharedpreferences.contains("studentNumber") && sharedpreferences.contains("studentName")){
            String num = sharedpreferences.getString("studentNumber", "noname");
            String stuName = sharedpreferences.getString("studentName", "noname");
            sn.setText(num);
            name.setText(stuName);
        }
    }
}
