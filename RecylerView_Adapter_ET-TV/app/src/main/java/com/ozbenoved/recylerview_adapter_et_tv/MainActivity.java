package com.ozbenoved.recylerview_adapter_et_tv;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager manager;
    ArrayList list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<Dugma>();
        if (list.isEmpty()) list.add(new Dugma(Dugma.EDIT));


        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        mAdapter = new MyAdapter(list, this);
        recyclerView.setAdapter(mAdapter);


    }
}
