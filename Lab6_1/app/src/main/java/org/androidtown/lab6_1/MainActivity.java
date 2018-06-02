package org.androidtown.lab6_1;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    EditText txtData;
    Button writeBtn;
    Button clearBtn;
    Button readBtn;
    Button finishBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtData = (EditText)findViewById(R.id.txtData);
        writeBtn = (Button)findViewById(R.id.writeBtn);
        clearBtn = (Button)findViewById(R.id.clearBtn);
        readBtn = (Button)findViewById(R.id.readBtn);
        finishBtn = (Button)findViewById(R.id.finishBtn);

        //check permission for accessing to storage
        checkPermission();

        //button for writing text to external file
        writeBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                try{
                    File sdCard = Environment.getExternalStorageDirectory();
                    File directory = new File(sdCard.getAbsolutePath()+"/MyFiles");

                    directory.mkdirs();
                    String fileName = "textfile.txt";
                    File file = new File(directory, fileName);
                    FileOutputStream fOut = new FileOutputStream(file);
                    OutputStreamWriter osw = new OutputStreamWriter(fOut);
                    osw.write(txtData.getText().toString());
                    osw.flush();
                    osw.close();
                    fOut.close();

                    Toast.makeText(getApplicationContext(), "Done writing SD '" + fileName + "'", Toast.LENGTH_SHORT).show();
                } catch(Exception e){
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Error in writing", Toast.LENGTH_SHORT).show();
                }

            }
        });

        //button for clear edit text area
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtData.setText("");
                Toast.makeText(getApplicationContext(), "clear screen", Toast.LENGTH_SHORT).show();
            }
        });

        //button for reading text from external file
        readBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                try{
                    File sdCard = Environment.getExternalStorageDirectory();
                    File directory = new File(sdCard.getAbsolutePath()+"/MyFiles");

                    directory.mkdirs();
                    String fileName = "textfile.txt";
                    File file = new File(directory, fileName);
                    FileInputStream fIn = new FileInputStream(file);
                    InputStreamReader isr = new InputStreamReader(fIn);
                    if(fIn != null){
                        BufferedReader reader = new BufferedReader(isr);
                        String str = "";
                        StringBuffer buf = new StringBuffer();

                        while((str = reader.readLine()) != null){
                            buf.append(str + "\n");
                        }
                        isr.close();
                        fIn.close();
                        txtData.setText(buf.toString());
                    }
                    Toast.makeText(getApplicationContext(), "Done reading SD '" + fileName + "'", Toast.LENGTH_SHORT).show();
                } catch(Exception e){
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Error in reading", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //button for finishing application
        finishBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
                Toast.makeText(getApplicationContext(), "finish app", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //check permission for accessing to mobile device external storage
    void checkPermission(){
        int permissioninfo= ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if(permissioninfo == PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);

        }
    }
}