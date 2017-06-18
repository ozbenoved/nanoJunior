package com.ozbenoved.myfragmentsapp;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Fragment fragment = SplashFragment.newInstance(0);

        getFragmentManager().beginTransaction().add(R.id.container, fragment).commit();   // add the first fragment

    }
}
