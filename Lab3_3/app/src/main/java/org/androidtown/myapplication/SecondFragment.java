package org.androidtown.myapplication;

//import android.app.Fragment;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by SurimYuk on 2018-04-21.
 */

public class SecondFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //connect second fragment to activity_main's FrameLayout
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_second, container, false);

        return rootView;
    }
}