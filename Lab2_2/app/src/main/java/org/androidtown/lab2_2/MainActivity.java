package org.androidtown.lab2_2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText Url;
    Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Url = (EditText)findViewById(R.id.editText);
        nextBtn = (Button)findViewById(R.id.btnNext);

        //action after pressing 'NEXT' button
        nextBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String myUrl = Url.getText().toString(); //store input url into 'myUrl'

                //Intent for launch new activity
                Intent intent = new Intent(getApplicationContext(), activity_new.class);
                //passing a input url as an Extra argument
                intent.putExtra("url", myUrl);
                startActivity(intent);
            }
        });
    }
}
