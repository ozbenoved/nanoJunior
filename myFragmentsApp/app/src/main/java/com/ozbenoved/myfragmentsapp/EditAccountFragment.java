package com.ozbenoved.myfragmentsapp;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by oz ben oved on 6/4/2017.
 */

public class EditAccountFragment extends Fragment implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_edit_account, container, false);

        Button button = (Button) rootView.findViewById(R.id.fragment_edit_account_buttonToAddContext);
        button.setOnClickListener(this);

        return rootView;
    }


    @Override
    public void onClick(View view) {
        FragmentTransaction fragmentTransaction = getActivity().getFragmentManager().beginTransaction();
        Fragment fragment= new AddContextFragment();

        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
