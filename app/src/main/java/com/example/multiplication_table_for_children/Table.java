package com.example.multiplication_table_for_children;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Table extends Fragment {
@Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
    return inflater.inflate(R.layout.fragment_table, container, false);
}
}