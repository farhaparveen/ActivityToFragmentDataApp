package com.example.activitytofragmentdataapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Fragment1 extends Fragment {

    TextView textView;

    public static Fragment1 newInstance(String str) {

        Bundle bundle = new Bundle();
        bundle.putString("key",str);
        Fragment1 fragment1 = new Fragment1();
        fragment1.setArguments(bundle);
        return fragment1;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fragment1, container, false);
        textView = view.findViewById(R.id.fragTxt1);


            String s = getArguments().getString("key");

            textView.setText(s);

            //setRetainInstance(true);

        return view;
    }

    void receiveDataFromActivityToFragment(String str)
    {
        textView.setText(str);
    }

}
