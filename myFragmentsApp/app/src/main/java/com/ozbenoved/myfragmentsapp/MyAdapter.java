package com.ozbenoved.myfragmentsapp;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Account> mDataset;
    Fragment thisFragment;

    MyAdapter(List<Account> myDataset, Fragment fragment) {
        mDataset = myDataset;
        thisFragment = fragment;

    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView text1;
        TextView text2;

        ViewHolder(View view) {
            super(view);
            text1 = (TextView) view.findViewById(R.id.text1);
            text2 = (TextView) view.findViewById(R.id.text2);
        }
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {

        String text1 = mDataset.get(position).getText1();
        String text2 = mDataset.get(position).getText2();

        mDataset.get(position).setText1(text1);
        mDataset.get(position).setText2(text2);

        Toast.makeText(thisFragment.getContext(), mDataset.get(position).getText1(), Toast.LENGTH_SHORT).show();

        ((ViewHolder)holder).text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = thisFragment.getFragmentManager().beginTransaction();

                Fragment fragment= EditAccountFragment.newInstance(mDataset.get(position).getAccountId());
                fragmentTransaction.replace(R.id.container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }


    @Override
    public int getItemCount() {

        return mDataset.size();
    }
}