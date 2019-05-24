package com.example.activitytofragmentdataapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText editText;
    Button button;
    Fragment1 fragment1;
    FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.activityEditText1);
        button = findViewById(R.id.activityBtn1);
        manager = getSupportFragmentManager();
        Log.d("tag","in create method");


            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(fragment1==null) {
                     //use this two line of code to get fragment1 object attached with bundle data
                        String editTextString = editText.getText().toString();
                        fragment1=Fragment1.newInstance(editTextString);
                        //we can use four other lines of code to get the same fragment object with bundle object attached
                            //ORR
                           //fragment1 = new Fragment1();
                          //  Bundle bundle = new Bundle();
                           // bundle.putString("key", editTextString);
                          //  fragment1.setArguments(bundle);

                              FragmentTransaction transaction = manager.beginTransaction();
                            transaction.add(R.id.frag_Container, fragment1);
                            transaction.commit();
                            Toast.makeText(MainActivity.this,"when fragment is null",Toast.LENGTH_SHORT).show();

                        }
                        else
                        {
                            String editTextString = editText.getText().toString();
                            fragment1.receiveDataFromActivityToFragment(editTextString);
                            Toast.makeText(MainActivity.this,"when fragment is there",Toast.LENGTH_SHORT).show();

                        }

                }

            });
        }


}


