package com.example.zabaani;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    MediaPlayer ring;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        if (sp.contains("localPref")) {
            String lang = sp.getString("localPref", "");

            if (lang.equals("en_US")) {
                Locale locale = new Locale("en_US");
                Resources resources = getApplicationContext().getResources();
                Configuration configuration = resources.getConfiguration();
                //configuration.setToDefaults(locale);
                configuration.setLocale(locale);
                getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());
                recreate();
            } else {
                Locale locale = new Locale("ur");
                Resources resources = getApplicationContext().getResources();
                Configuration configuration = resources.getConfiguration();
                //configuration.setToDefaults(locale);
                configuration.setLocale(locale);
                getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());
                recreate();
            }
        }


        ring = MediaPlayer.create(getApplicationContext(), R.raw.overworld_terraria);
        ring.start();
        ring.setLooping(true);
    }
    public void levels (View v){
        Intent intent = new Intent(this,LevelActivity.class);
        startActivity(intent);
    }
    public void onClickHelp(View v){
        Intent intent = new Intent(MainActivity.this, HelpActivity.class);
        startActivity(intent);
    }

    public void onClickOption(View v){
        Intent intent = new Intent(MainActivity.this, OptionsActivity.class);
        startActivity(intent);
    }


    public void onClickExit(View v){
        ring.stop();
        finishAffinity();
        System.exit(0);
    }
}
