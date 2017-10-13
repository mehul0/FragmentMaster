package com.mehul.fragmentmaster.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.mehul.fragmentmaster.R;

/**
 * Created by Micky on 10/4/2017.
 */

public class LoginFragment extends Fragment implements View.OnClickListener {

    public static final String TAG = "LoginFragment";

    public TextView tvSignUp;
    public Button btnLogin;

    LoginFragmentEvent mLoginFragmentEvent;

    public interface LoginFragmentEvent {
        void onLoginClick();
        void onSignUpClick();
        void onLoginSuccess();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        mLoginFragmentEvent = (LoginFragmentEvent) context;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        mLoginFragmentEvent = (LoginFragmentEvent) activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_login, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvSignUp = view.findViewById(R.id.tv_login_fragment_new_user);
        tvSignUp.setOnClickListener(this);
        btnLogin = view.findViewById(R.id.btn_login_fragment_login);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == btnLogin.getId()){

            if (mLoginFragmentEvent != null)
                mLoginFragmentEvent.onLoginClick();

        }else if (view.getId() == tvSignUp.getId()){

            if (mLoginFragmentEvent != null)
                mLoginFragmentEvent.onSignUpClick();

        }

    }
}
