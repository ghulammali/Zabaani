package com.example.zabaani;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.Locale;

public class OptionsActivity extends AppCompatActivity {

    private static final String LOCALE_KEY = "localekey";
    private static final String URDU_LOCALE = "ur";
    private static final String ENGLISH_LOCALE = "en_US";
    private static final String LOCALE_PREF_KEY = "localePref";

    private Locale locale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        //SharedPreferences sp = getSharedPreferences(LOCALE_PREF_KEY, MODE_PRIVATE);
        //String localeString = sp.getString(LOCALE_KEY, ENGLISH_LOCALE);
    }

    public void onClickChangeNameOption(View view){
        Toast.makeText(getApplicationContext(), "Feature Coming Soon!", Toast.LENGTH_SHORT).show();
    }

    public void onClickMusicOption(View view){
        Toast.makeText(getApplicationContext(), "Feature Coming Soon!", Toast.LENGTH_SHORT).show();
    }

    public void onClickMenuTextOption(View view){
        Resources resources = getApplicationContext().getResources();
        SharedPreferences sp = getSharedPreferences("localPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        if (sp.getString(LOCALE_KEY, ENGLISH_LOCALE).equals(URDU_LOCALE)) {
            locale = new Locale(ENGLISH_LOCALE);
            editor.putString(LOCALE_KEY, ENGLISH_LOCALE);
        } else {
            locale = new Locale(URDU_LOCALE);
            editor.putString(LOCALE_KEY, URDU_LOCALE);
        }
        editor.apply();

        Configuration configuration = resources.getConfiguration();
        //configuration.setToDefaults(locale);
        configuration.setLocale(locale);
        getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());
        recreate();
        Toast.makeText(getApplicationContext(), "Button Tapped. Should change Text!", Toast.LENGTH_SHORT).show();
    }

    public void onClickResetScoreOption(View view){
        Toast.makeText(getApplicationContext(), "Feature Coming Soon!", Toast.LENGTH_SHORT).show();
    }
}
