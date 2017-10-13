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

public class MainFragment extends Fragment implements View.OnClickListener {

    public static final String TAG = "MainFragment";

    TextView textView;

    MainFragmentEvent mMainFragmentEvent;

    public interface MainFragmentEvent{
        void onMainFragmentEventResult();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mMainFragmentEvent = (MainFragmentEvent) context;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        mMainFragmentEvent = (MainFragmentEvent) activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textView = view.findViewById(R.id.tv_main_fragment);
        textView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (mMainFragmentEvent != null)
            mMainFragmentEvent.onMainFragmentEventResult();
    }
}
