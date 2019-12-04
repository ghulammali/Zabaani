package com.example.zabaani;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class SwipeAdapterMatchTwo extends FragmentStatePagerAdapter {

    public SwipeAdapterMatchTwo(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment pageFragment = new MatchTwoFragmentPage01();
        switch (position) {
            case 0:
                pageFragment = new MatchTwoFragmentPage01();
                break;
            case 1:
                pageFragment = new MatchTwoFragmentPage02();
                break;
            case 2:
                pageFragment = new MatchTwoFragmentPage03();
                break;
            case 3:
                pageFragment = new MatchTwoFragmentPage04();
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
