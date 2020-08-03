package org.androidtown.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button mBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtn = (Button)findViewById(R.id.btn);
        registerForContextMenu(mBtn);
    }

    public void onCreateContextMenu(ContextMenu menu,View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Button Menu"); //set menu title
        menu.add(0, 1, 1, "Red"); //set menu option content
        menu.add(0, 2, 2, "Green"); //set menu option content
        menu.add(0, 3, 3, "Blue"); //set menu option content
    }

    public boolean onContextItemSelected(MenuItem item){
        switch(item.getItemId()){
            case 1:
                mBtn.setTextColor(Color.RED); //if first option selected, change text color to red
                return true;
            case 2:
                mBtn.setTextColor(Color.GREEN); //if second option selected, change text color to green
                return true;
            case 3:
                mBtn.setTextColor(Color.BLUE); //if third option selected, change text color to blue
                return true;
        }
        return true;
    }

}
