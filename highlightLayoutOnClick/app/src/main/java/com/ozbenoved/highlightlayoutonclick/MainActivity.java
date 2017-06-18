package com.ozbenoved.highlightlayoutonclick;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout linearLayout1;
    LinearLayout linearLayout2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout1 = (LinearLayout) findViewById(R.id.layout1);
        linearLayout2 = (LinearLayout) findViewById(R.id.layout2);
        linearLayout2.setOnClickListener(this);
        linearLayout1.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        ViewGroup viewGroup = (ViewGroup) view;

        if (!view.isActivated()) {
            view.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
            TextView textView1 = (TextView) viewGroup.getChildAt(1);
            textView1.setTextColor(getResources().getColor(R.color.colorAccent));
            view.setActivated(true);

        } else {
            view.setBackgroundColor(getResources().getColor(R.color.white));
            TextView textView1 = (TextView) viewGroup.getChildAt(1);
            textView1.setTextColor(getResources().getColor(R.color.black));
            view.setActivated(false);

        }
    }
}

