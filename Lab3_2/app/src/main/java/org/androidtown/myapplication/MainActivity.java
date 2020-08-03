package org.androidtown.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText name;
    RadioGroup radGroup;
    RadioButton man;
    RadioButton woman;
    CheckBox sms;
    CheckBox email;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText)findViewById(R.id.name);
        radGroup = (RadioGroup)findViewById(R.id.radGroup);
        man = (RadioButton)findViewById(R.id.male);
        woman = (RadioButton)findViewById(R.id.female);
        sms = (CheckBox)findViewById(R.id.sms);
        email = (CheckBox)findViewById(R.id.email);
        btn = (Button)findViewById(R.id.register);

        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                String userName = name.getText().toString();

                int index = radGroup.getCheckedRadioButtonId();
                int gender=0;
                if(man.getId()==index) gender=1; //man
                if(woman.getId()==index) gender=2; //woman

                int reception=0; //no selection for reception selection
                if(sms.isChecked()){
                    if(email.isChecked())
                        reception=3; //both
                    else
                        reception=1; //sms only
                } else{
                    if(email.isChecked())
                        reception=2; //e-mail only
                }

                //communication with NewActivity through intent
                Intent intent = new Intent(getApplicationContext(), NewActivity.class);
                //send user's information through putting information in the bundle
                Bundle bundle = new Bundle();
                bundle.putString("name", userName);
                bundle.putInt("gender", gender);
                bundle.putInt("reception", reception);
                //put information in the bundle at once
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
    }
}
