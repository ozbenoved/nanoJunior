package com.ozbenoved.myfragmentsapp;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

public class AccountsFragment extends Fragment implements View.OnClickListener {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager manager;
    RecyclerView.Adapter adapter;
    public static AccountsFragment newInstance(int index) {
        AccountsFragment fragment = new AccountsFragment();
        Bundle args = new Bundle();
        args.putInt("index", index);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_accounts, container, false);

        Account account1 = new Account("account1", "text");
        Account account2 = new Account("account2", "text");

        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(account1);
        accounts.add(account2);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.my_recycler_view);
        manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);

        adapter = new MyAdapter(accounts, this);
        recyclerView.setAdapter(adapter);

        Button buttonToEdit = (Button) rootView.findViewById(R.id.fragment_accounts_buttonToEdit);
        buttonToEdit.setOnClickListener(this);

        return rootView;
    }


    @Override
    public void onClick(View view) {
        FragmentTransaction fragmentTransaction = getActivity().getFragmentManager().beginTransaction();
        Fragment fragment= EditAccountFragment.newInstance(0);
        fragmentTransaction.replace(R.id.container, fragment, "2");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
