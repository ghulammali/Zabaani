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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = sp.edit();
        String keyvalue = sp.getString("Music", "On");
        Integer musicPlayerCount = sp.getInt("Music_player", 0);

        if (keyvalue.equalsIgnoreCase("On") && musicPlayerCount.equals(0)) {
            editor.putInt("Music_player", 1);
            editor.apply();
            AudioPlay.playAudio(getApplicationContext(), R.raw.overworld_terraria);
        }
    }
    public void levels (View v){
        Intent intent = new Intent(this,LevelActivity.class);
        startActivity(intent);
    }
    public void onClickHelp(View v){
        Intent intent = new Intent(MainActivity.this, HelpActivity.class);
        startActivity(intent);
    }
    // CHANGE THIS BACK
    public void onClickOption(View v){
        Intent intent = new Intent(MainActivity.this, OptionsActivity.class);
        startActivity(intent);
    }


    public void onClickExit(View v){
        //String LOCALE_KEY = getResources().getString(R.string.Locale_key);
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sp.edit();

        String keyvalue = sp.getString("Music", "On");
        Integer musicPlayerCount = sp.getInt("Music_player", 0);

        if (keyvalue.equalsIgnoreCase("On") && musicPlayerCount.equals(1)) {
            editor.putInt("Music_player", 0);
            AudioPlay.stopAudio();
            editor.apply();
        }
        editor.putString(getResources().getString(R.string.Locale_key), "en_US");
        editor.apply();

        finishAffinity();
        System.exit(0);
    }
}
