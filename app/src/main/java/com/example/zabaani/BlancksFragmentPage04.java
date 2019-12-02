package com.example.zabaani;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BlancksFragmentPage04 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view;
        view = inflater.inflate(R.layout.page_fragment_layout, container, false);
        TextView textView = (TextView) view.findViewById(R.id.textid);
        textView.setText(getResources().getString(R.string.BlankHelp_04));
        return view;
    }
}
