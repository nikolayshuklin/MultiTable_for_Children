package com.example.multiplication_table_for_children;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void change (View view){
        Fragment fragment = null;
        switch(view.getId()){
            case R.id.imageButton11:
                fragment = new Table();
                break;
            case R.id.ButtonTable:
                fragment = new FragmentTop();
                break;
        }

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.container, fragment);
        ft.commit();


        }
    }

}