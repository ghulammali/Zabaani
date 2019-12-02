package com.example.zabaani;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentPage extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view;
        //Bundle bundle = getArguments();
        //int pageNumber = bundle.getInt("viewpager");

        //Log.i("page number", Integer.toString(pageNumber));
        //return super.onCreateView(inflater, container, savedInstanceState);

        view = inflater.inflate(R.layout.page_fragment_layout, container, false);
        TextView textView = (TextView) view.findViewById(R.id.textid);
        textView.setText(getResources().getString(R.string.BlankHelp_01));
        return view;
    }
}


