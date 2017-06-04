package com.ozbenoved.myfragmentsapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class AccountsFragment extends Fragment implements View.OnClickListener {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_accounts, container, false);

        Button buttonToEdit = (Button) rootView.findViewById(R.id.fragment_accounts_buttonToEdit);
        buttonToEdit.setOnClickListener(this);

        return rootView;
    }


    @Override
    public void onClick(View view) {
        FragmentTransaction fragmentTransaction = getActivity().getFragmentManager().beginTransaction();
        Fragment fragment= new EditAccountFragment();

        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
