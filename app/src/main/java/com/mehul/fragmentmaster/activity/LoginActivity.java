package com.mehul.fragmentmaster.activity;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.mehul.fragmentmaster.R;
import com.mehul.fragmentmaster.fragment.LoginFragment;
import com.mehul.fragmentmaster.fragment.SignUpFragment;

public class LoginActivity extends AppCompatActivity
        implements LoginFragment.LoginFragmentEvent,
        SignUpFragment.SignUpFragmentEvent {

    private CoordinatorLayout coordinatorLayout;

    LoginFragment mLoginFragment;
    SignUpFragment mSignUpFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        coordinatorLayout = findViewById(R.id.coordinator_layout);

        loadLoginFragment();

    }


    /**
     * Login Fragment
     **/

    public void loadLoginFragment() {

        mLoginFragment = (LoginFragment) getSupportFragmentManager().findFragmentByTag(LoginFragment.TAG);

        if (mLoginFragment == null) {

            mLoginFragment = new LoginFragment();

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frameContainer, mLoginFragment, LoginFragment.TAG)
                    .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .commit();

        }
    }

    @Override
    public void onLoginClick() {
        //Toast.makeText(this, "Login", Toast.LENGTH_SHORT).show();
        onLoginSuccess();
    }

    @Override
    public void onSignUpClick() {
        loadSignUpFragment();
    }

    @Override
    public void onLoginSuccess() {
        loadMainActivity();
    }

    public void loadMainActivity(){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

    }


    /**
     * Sign-Up Fragment
     **/

    public void loadSignUpFragment() {

        mSignUpFragment = (SignUpFragment) getSupportFragmentManager().findFragmentByTag(SignUpFragment.TAG);

        if (mSignUpFragment == null) {

            mSignUpFragment = new SignUpFragment();

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frameContainer, mSignUpFragment, SignUpFragment.TAG)
                    .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .commit();
        }
    }

    @Override
    public void onLoginBack() {
        loadLoginFragment();
    }

    @Override
    public void onSignUpSuccess() {

    }
}
