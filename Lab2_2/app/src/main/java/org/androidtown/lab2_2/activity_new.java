package org.androidtown.lab2_2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class activity_new extends AppCompatActivity {

    TextView textView;
    Button goBtn;
    Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        textView = (TextView)findViewById(R.id.url);
        goBtn = (Button)findViewById(R.id.go);
        backBtn = (Button)findViewById(R.id.back);

        //receive passed intent and passed extra argument(url)
        final Intent passedIntent = getIntent();
        final String passedUrl = passedIntent.getStringExtra("url");
        textView.setText(passedUrl); //set textView with the received url

        //action for pressing 'GO' button
        goBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                if((!textView.getText().equals(""))&&textView.getText()!=null){ //if TextView is not empty
                    //open the page that corresponds to the user input url
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+textView.getText()));
                    startActivity(intent);
                }
                else{ //if TextView is empty
                    //provide a simple feedback with a Toast
                    Toast.makeText(getApplicationContext(), "주소를 다시 입력해주세요.", Toast.LENGTH_LONG).show();
                }
            }
        });

        //action for pressing 'BACK' button
        backBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                //if BACK button pressed, launch the previous(Main) activity
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                //provide a simple feedback with a Toast
                Toast.makeText(getApplicationContext(), "뒤로가기 버튼을 눌렀습니다.", Toast.LENGTH_LONG).show();
            }
        });
    }

}
