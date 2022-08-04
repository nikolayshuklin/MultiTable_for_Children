package com.example.multiplication_table_for_children;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    @SuppressLint("NonConstantResourceId")
    public void change (View view){
        Fragment fragment;
        fragment = new FragmentTop();
        switch(view.getId()){
            case R.id.imageButtonBoys:
                fragment = new Table();
                break;
            case R.id.ButtonTable:
                fragment = new FragmentTop();
                break;
            case R.id.imageButton1:
                fragment = new TestFragment().newInstance(1, 1, 0);
                break;
            case R.id.imageButton2:
                fragment = new TestFragment().newInstance(2, 1, 0);
                break;
            case R.id.imageButton3:
                fragment = new TestFragment().newInstance(3, 1, 0);
                break;
            case R.id.imageButton4:
                fragment = new TestFragment().newInstance(4, 1, 0);
                break;
            case R.id.imageButton5:
                fragment = new TestFragment().newInstance(5, 1, 0);
                break;
            case R.id.imageButton6:
                fragment = new TestFragment().newInstance(6, 1, 0);
                break;
            case R.id.imageButton7:
                fragment = new TestFragment().newInstance(7, 1, 0);
                break;
            case R.id.imageButton8:
                fragment = new TestFragment().newInstance(8, 1, 0);
                break;
            case R.id.imageButton9:
                fragment = new TestFragment().newInstance(9, 1, 0);
                break;
            case R.id.imageButton10:
                fragment = new TestFragment().newInstance(10, 1, 0);
                break;
            case R.id.examen:
                fragment = new ExamenFragment().newInstance(11, 1, 0,1);
                break;
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.fragmentContainer, fragment);
        ft.commit();


    }


}