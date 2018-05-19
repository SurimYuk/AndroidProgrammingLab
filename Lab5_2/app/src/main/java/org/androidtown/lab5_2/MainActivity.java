package org.androidtown.lab5_2;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    TextView textView1;
    TextView textView2;
    int factoResult = 1;
    int input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.editText);
        button = (Button)findViewById(R.id.button);
        textView1 = (TextView)findViewById(R.id.textView1);
        textView2 = (TextView)findViewById(R.id.textView2);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                input = Integer.parseInt(editText.getText().toString());
                new FactoTask().execute();
            }
        });
    }

    private class FactoTask extends AsyncTask<Void, Integer, Void> {
        String progress = "";

        @Override
        protected void onPreExecute(){
            textView1.setText("n n-1 n-2 ...");
            textView2.setText("= ?");
        }

        @Override
        protected Void doInBackground(Void... params){
            for(int i = input; i >= 1; i--){
                try {
                    factoResult = factoResult * i;
                    Thread.sleep(500);
                    publishProgress(i);
                }catch(Exception e){}
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values){
            progress = progress + Integer.toString(values[0].intValue()) + " ";
            textView1.setText(progress);
        }

        @Override
        protected void onPostExecute(Void aVoid){
            textView2.setText(String.valueOf(factoResult));
        }
    }
}
