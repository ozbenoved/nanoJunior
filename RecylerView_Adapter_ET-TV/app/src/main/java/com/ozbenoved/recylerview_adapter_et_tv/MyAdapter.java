package com.ozbenoved.recylerview_adapter_et_tv;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Dugma> mDataset;
    Context context;

    MyAdapter(List<Dugma> myDataset, Context context) {
        mDataset = myDataset;
        this.context = context;

    }

    static class ViewHolderEdit extends RecyclerView.ViewHolder {
        EditText text1;
        EditText text2;
        ImageButton lancher;
        int type;

        ViewHolderEdit(View view) {
            super(view);
            text1 = (EditText) view.findViewById(R.id.text1_et);
            text2 = (EditText) view.findViewById(R.id.text2_et);
            lancher = (ImageButton) view.findViewById(R.id.button);
        }
    }

    static class ViewHolderNotEdit extends RecyclerView.ViewHolder {
        TextView text1;
        TextView text2;

        ViewHolderNotEdit(View view) {
            super(view);
            text1 = (TextView) view.findViewById(R.id.text1_tv);
            text2 = (TextView) view.findViewById(R.id.text2_tv);
        }
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == Dugma.EDIT) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_line_edit, parent, false);
            return new ViewHolderEdit(view);
        }
        if (viewType == Dugma.NOT_EDIT) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_line_view, parent, false);
            return new ViewHolderNotEdit(view);
        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        if (mDataset.get(position).getType() == Dugma.EDIT) return Dugma.EDIT;
        else return Dugma.NOT_EDIT;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {

        if (mDataset.get(position).getType() == Dugma.EDIT) {
            ((ViewHolderEdit) holder).lancher.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mDataset.add(position, new Dugma(Dugma.NOT_EDIT));


                    String text1 = mDataset.get(position).getText1();
                    String text2 = mDataset.get(position).getText2();

                    mDataset.get(position+1).setText1(text1);
                    mDataset.get(position+1).setText2(text2);
                    Toast.makeText(context, mDataset.get(position).getText1(), Toast.LENGTH_SHORT).show();

                    notifyDataSetChanged();
                }
            });
        }
    }


    @Override
    public int getItemCount() {

        return mDataset.size();
    }
}