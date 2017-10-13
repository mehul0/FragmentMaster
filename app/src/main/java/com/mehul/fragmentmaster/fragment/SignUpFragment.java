package com.mehul.fragmentmaster.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mehul.fragmentmaster.R;

/**
 * Created by Micky on 10/4/2017.
 */

public class SignUpFragment extends Fragment
        implements View.OnClickListener {

    public static final String TAG = "SignUpFragment";

    private TextView tvBack;

    SignUpFragmentEvent mSignUpFragmentEvent;

    public interface SignUpFragmentEvent{
        void onLoginBack();
        void onSignUpSuccess();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        mSignUpFragmentEvent = (SignUpFragmentEvent) context;

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        mSignUpFragmentEvent = (SignUpFragmentEvent) activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sign_up, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvBack = view.findViewById(R.id.back);
        tvBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (mSignUpFragmentEvent != null)
            mSignUpFragmentEvent.onLoginBack();
    }
}
