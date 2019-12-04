package com.example.zabaani;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class BlankTutorialActivity extends AppCompatActivity {

    //ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blank_tutorial);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setOffscreenPageLimit(1);
        SwipeAdapter swipeAdapter = new SwipeAdapter(getSupportFragmentManager());
        viewPager.setAdapter(swipeAdapter);
        viewPager.setCurrentItem(0);

        ImageView imgNext = (ImageView) findViewById(R.id.imageView3);
        imgNext.bringToFront();


        imgNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.w("wow", "left arrow clicked");
                if (viewPager.getCurrentItem() != 0) {
                    viewPager.setCurrentItem(viewPager.getCurrentItem() - 1, true);
                }
            }
        });

        ImageView imgPrev = (ImageView) findViewById(R.id.imageView4);
        imgPrev.bringToFront();

        imgPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.w("wow", "right arrow clicked");
                if (viewPager.getCurrentItem() < 4) {
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
                }
            }
        });
    }
}
