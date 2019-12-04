package com.example.zabaani;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Locale;
import java.util.prefs.Preferences;

public class MainActivity extends AppCompatActivity {

    //public static String appLang;
    MediaPlayer ring;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        String LOCALE_KEY = getResources().getString(R.string.Locale_key);
//        //String URDU_LOCALE = getResources().getString(R.string.Urdu_Locale);
//        String ENGLISH_LOCALE = getResources().getString(R.string.English_Locale);
//
//        SharedPreferences shp = PreferenceManager.getDefaultSharedPreferences(this);
//        appLang = shp.getString(LOCALE_KEY, ENGLISH_LOCALE);
//
//        Locale locale = new Locale(appLang);
//
//        Configuration config = new Configuration();
//
//        config.setLocale(locale);
//
//        getResources().updateConfiguration(
//                config, getResources().getDisplayMetrics()
//        );

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Log.w("localPref", "Before sp test");
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
        //String LOCALE_KEY = getResources().getString(R.string.Locale_key);
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sp.edit();

        editor.putString(getResources().getString(R.string.Locale_key), "en_US");
        editor.apply();

        ring.stop();
        finishAffinity();
        System.exit(0);
    }
}
