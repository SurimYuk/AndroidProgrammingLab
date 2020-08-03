package org.androidtown.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NewActivity extends AppCompatActivity {

    TextView nameText;
    TextView genderText;
    TextView receptionText;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        nameText = (TextView)findViewById(R.id.name);
        genderText = (TextView)findViewById(R.id.gender);
        receptionText = (TextView)findViewById(R.id.reception);
        btn = (Button)findViewById(R.id.back);

        //get intent from MainActivity
        Intent intent = getIntent();
        //get bundle from the intent
        Bundle bundle = intent.getExtras();

        //get user's name from bundle
        String name = bundle.getString("name");
        nameText.setText(name);

        //get user's gender from bundle
        int gender = bundle.getInt("gender");
        if(gender == 1) genderText.setText("남"); //1 matches with man
        else if(gender == 2) genderText.setText("여"); //2 matches with woman

        //get user's selection for reception method from bundle
        int reception = bundle.getInt("reception");
        if(reception == 1) receptionText.setText("SMS"); //1 matches with SMS
        else if(reception == 2) receptionText.setText("e-mail"); //2 matches with e-mail
        else if(reception == 3) receptionText.setText("SMS & e-mail"); //3 matches with both SMS and e-mail

        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                //if user push the return button,
                //intent for MainActivity shows on the screen
                //and current page disappear
                Intent newIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(newIntent);
                finish();
            }
        });
    }
}
