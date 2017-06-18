package com.ozbenoved.myfragmentsapp;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by oz ben oved on 6/4/2017.
 */

public class EditAccountFragment extends Fragment implements View.OnClickListener {

    public static EditAccountFragment newInstance(int index) {
        EditAccountFragment fragment = new EditAccountFragment();
        Bundle args = new Bundle();
        args.putInt("index", index);
        fragment.setArguments(args);
        return fragment;
    }

    TextView edit;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_edit_account, container, false);

        Button button = (Button) rootView.findViewById(R.id.fragment_edit_account_buttonToAddContext);
        button.setOnClickListener(this);

        Button button2 = (Button) rootView.findViewById(R.id.fragment_edit_account_saveButton);
        button2.setOnClickListener(this);
        edit = (TextView) rootView.findViewById(R.id.edit);

        Button button3 = (Button) rootView.findViewById(R.id.fragment_edit_out);
        button3.setOnClickListener(this);

        edit = (TextView) rootView.findViewById(R.id.edit);

        Bundle bundle = getArguments();
        if (bundle != null) {
            edit.setText(getArguments().getInt("index") + "");
        }

        return rootView;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.fragment_edit_account_buttonToAddContext) {
            FragmentTransaction fragmentTransaction = getActivity().getFragmentManager().beginTransaction();
            Fragment fragment = AddContextFragment.newInstance(0);
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        } else if (view.getId() == R.id.fragment_edit_account_saveButton)  {
            getFragmentManager().popBackStack();
        } else {
            getFragmentManager().popBackStack();
            FragmentTransaction fragmentTransaction = getActivity().getFragmentManager().beginTransaction();
            Fragment fragment = Out.newInstance(0);
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();
        }
    }
}
