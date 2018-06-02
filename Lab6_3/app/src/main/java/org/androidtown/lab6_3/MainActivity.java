package org.androidtown.lab6_3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText studentName;
    EditText studentNumber;
    Button addBtn;
    Button deleteBtn;
    ListView listView;

    SQLiteDatabase db;
    MySQLiteOpenHelper helper;

    String[] studentInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //help create database
        helper = new MySQLiteOpenHelper(MainActivity.this, "student.db", null, 1);

        studentName = (EditText)findViewById(R.id.studentName);
        studentNumber = (EditText)findViewById(R.id.studentNumber);
        addBtn = (Button)findViewById(R.id.addBtn);
        deleteBtn = (Button)findViewById(R.id.deleteBtn);
        listView = (ListView)findViewById(R.id.listView);

        //button for inserting student information
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //insert information after checking validation
                if(studentName.getText().toString().equals("")||studentNumber.getText().toString().equals("")){
                    Toast.makeText(getApplication(), "모든 항목을 입력해주세요.", Toast.LENGTH_LONG).show();
                }
                else{
                    insert(studentName.getText().toString(), studentNumber.getText().toString());
                    studentName.setText("");
                    studentNumber.setText("");

                }
            }
        });

        //button for deleting student information
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //delete information after checking validation
                if(studentName.getText().toString().equals("")){
                    Toast.makeText(getApplication(), "이름을 입력해주세요.", Toast.LENGTH_LONG).show();
                }
                else{
                    delete(studentName.getText().toString());
                    studentName.setText("");
                    studentNumber.setText("");
                }
            }
        });
    }

    //get name, number and insert name, number to database
    public void insert(String name, String number){
        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("name", name);
        values.put("number", number);
        db.insert("student", null, values);

        invalidate();
    }

    //get name and delete information from database based on name
    public void delete(String name){
        db = helper.getWritableDatabase();
        db.delete("student", "name=?", new String[]{name});

        invalidate();
    }

    //read data from database and insert read data to studentInfo array
    public void select(){
        db = helper.getReadableDatabase();
        Cursor c = db.query("student", null, null, null, null, null, null);

        studentInfo = new String[c.getCount()];

        int count = 0;
        while(c.moveToNext()){
            studentInfo[count] = c.getString(c.getColumnIndex("name")) + " " + c.getString(c.getColumnIndex("number"));
            count++;
        }
        c.close();
    }

    //attach data to adapter and connect listView with adapter
    private void invalidate(){
        select();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, studentInfo);
        listView.setAdapter(adapter);
    }

    //class for helping create database table
    public class MySQLiteOpenHelper extends SQLiteOpenHelper{

        public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db){
            String sql = "create table student (name text, number text)";
            db.execSQL(sql);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
            String sql ="drop table if exists student";
            db.execSQL(sql);
            onCreate(db);
        }
    }
}



