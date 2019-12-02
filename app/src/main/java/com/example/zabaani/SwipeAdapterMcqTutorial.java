package com.example.zabaani;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class SwipeAdapterMcqTutorial extends FragmentStatePagerAdapter {

    public SwipeAdapterMcqTutorial(FragmentManager fm) { super(fm); }

    @Override
    public Fragment getItem(int position) {
        Fragment pageFragment = new McqFragmentPage01();
        switch (position){
            case 0:
                pageFragment = new McqFragmentPage01();
                break;
            case 1:
                pageFragment = new McqFragmentPage02();
                break;
            case 2:
                pageFragment = new McqFragmentPage03();
                break;
            case 3:
                pageFragment = new McqFragmentPage04();
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
