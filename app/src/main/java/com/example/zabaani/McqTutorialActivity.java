package com.example.zabaani;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
//import android.util.Log;
//import android.view.View;
//import android.widget.ImageView;

//import com.google.android.material.tabs.TabLayout;

public class McqTutorialActivity extends AppCompatActivity {

    //ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mcq_tutorial);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setOffscreenPageLimit(1);
        SwipeAdapterMcqTutorial swipeAdapter = new SwipeAdapterMcqTutorial(getSupportFragmentManager());
        viewPager.setAdapter(swipeAdapter);
        viewPager.setCurrentItem(0);

        ImageView imgNext = (ImageView) findViewById(R.id.imageView5);
        imgNext.bringToFront();

        imgNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.w("wow", "left arrow clicked");
                if (viewPager.getCurrentItem() != 0) {
                    viewPager.setCurrentItem(viewPager.getCurrentItem() - 1, true);
                }
            }
        });

        ImageView imgPrev = (ImageView) findViewById(R.id.imageView6);
        imgPrev.bringToFront();

        imgPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.w("wow", "right arrow clicked");
                if (viewPager.getCurrentItem() < 4) {
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
                }
            }
        });
    }
}
