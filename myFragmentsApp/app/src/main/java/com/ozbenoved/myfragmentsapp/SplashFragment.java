package com.ozbenoved.myfragmentsapp;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by oz ben oved on 6/4/2017.
 */

public class SplashFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_splash, container, false);

        new CountDownTimer(1000, 1000) {

            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {

                FragmentTransaction fragmentTransaction = getActivity().getFragmentManager().beginTransaction();
                Fragment fragment = new AccountsFragment();

                fragmentTransaction.replace(R.id.container, fragment);
                fragmentTransaction.commit();
            }
        }.start();
        return rootView;

    }
}

