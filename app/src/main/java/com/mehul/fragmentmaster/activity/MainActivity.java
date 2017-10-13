package com.mehul.fragmentmaster.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.mehul.fragmentmaster.R;
import com.mehul.fragmentmaster.fragment.LoginFragment;
import com.mehul.fragmentmaster.fragment.MainFragment;
import com.mehul.fragmentmaster.fragment.SecondFragment;
import com.mehul.fragmentmaster.fragment.SignUpFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        FragmentManager.OnBackStackChangedListener,MainFragment.MainFragmentEvent {

    private static final String TAG = "MainActivity";

    MainFragment mMainFragment;
    SecondFragment mSecondFragment;

    ActionBarDrawerToggle toggle;
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().addOnBackStackChangedListener(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        /*DrawerLayout */drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        /*ActionBarDrawerToggle */toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this, "setToolbarNavigationClickListener", Toast.LENGTH_LONG).show();
                onBackPressed();
            }
        });

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //loadMainFragment();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

            loadSecondFragment();

        } else if (id == R.id.nav_slideshow) {
        } else {
            if (id == R.id.nav_manage) {

            } else if (id == R.id.nav_share) {

            } else if (id == R.id.nav_send) {

            }
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        toggle.syncState();
        //navigationView.getMenu().getItem(0).setChecked(true);
        //onNavigationItemSelected(navigationView.getMenu().getItem(0));
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        toggle.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void loadMainFragment() {

        mMainFragment = (MainFragment) getSupportFragmentManager().findFragmentByTag(MainFragment.TAG);

        if (mMainFragment == null) {

            mMainFragment = new MainFragment();

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frameContainer, mMainFragment, MainFragment.TAG)
                    .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .commit();
        }

        //getSupportActionBar().setTitle("Micky");

        invalidateOptionsMenu();
    }

    @Override
    public void onMainFragmentEventResult() {

    }

    public void loadSecondFragment() {

        mSecondFragment = (SecondFragment) getSupportFragmentManager().findFragmentByTag(SecondFragment.TAG);

        if (mSecondFragment == null) {

            mSecondFragment = new SecondFragment();

            onLoadFragment(mSecondFragment,SecondFragment.TAG);

            /*getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frameContainer, mSecondFragment, SecondFragment.TAG)
                    .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .addToBackStack(MainFragment.TAG)
                    .commit();*/
        }

        getSupportActionBar().setTitle("Micky");

        invalidateOptionsMenu();
    }




    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
                getSupportFragmentManager().popBackStackImmediate();

                if (getSupportFragmentManager().getBackStackEntryCount() == 0){
                    getSupportActionBar().setTitle("Pinaka");
                }

                /*Fragment fragment = getSupportFragmentManager().findFragmentByTag(MainFragment.TAG);

                if (fragment != null && fragment instanceof MainFragment) {

                    getSupportActionBar().setTitle("Mehuls");

                }*/
            } else {
                super.onBackPressed();
            }
            //super.onBackPressed();
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onBackStackChanged() {

        toggle.setDrawerIndicatorEnabled(getSupportFragmentManager().getBackStackEntryCount() == 0);
        getSupportActionBar().setDisplayHomeAsUpEnabled(getSupportFragmentManager().getBackStackEntryCount() > 0);
        toggle.syncState();

    }

    public void onLoadFragment(Fragment fragmentContext,String tag){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameContainer, fragmentContext, tag)
                .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .addToBackStack(MainFragment.TAG)
                .commit();

    }

    /*private void loadPreferredDistributorFragment() {
        preferredDistributorFragment = new PreferredDistributorFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.container, preferredDistributorFragment, PreferredDistributorFragment.class.getSimpleName())
                .addToBackStack(SettingFragment.TAG)
                .commit();

        getSupportActionBar().setTitle(R.string.fragment_screen_action_bar_title_preferred_distributor);

        invalidateOptionsMenu();
    }*/
}
