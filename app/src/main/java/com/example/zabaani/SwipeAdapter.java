package com.example.zabaani;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class SwipeAdapter extends FragmentStatePagerAdapter {

    public SwipeAdapter(FragmentManager fm) {super (fm);}

    @Override
    public Fragment getItem(int position) {
        Fragment pageFragment = new FragmentPage();
        switch (position){
            case 0:
                pageFragment = new FragmentPage();
                break;
            case 1:
                pageFragment = new BlancksFragmentPage02();
                break;
            case 2:
                pageFragment = new BlancksFragmentPage03();
                break;
            case 3:
                pageFragment = new BlancksFragmentPage04();
                break;
        }
        Bundle bundle = new Bundle();
        pageFragment.setArguments(bundle);
        return pageFragment;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
