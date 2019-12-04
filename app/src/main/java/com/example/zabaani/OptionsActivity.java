package com.example.zabaani;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.Locale;

public class OptionsActivity extends AppCompatActivity {

    private Locale locale;
    public int lang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        this.lang = 0;

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
        //Resources resources = getApplicationContext().getResources();

        String LOCALE_KEY = getResources().getString(R.string.Locale_key);
        String URDU_LOCALE = getResources().getString(R.string.Urdu_Locale);
        String ENGLISH_LOCALE = getResources().getString(R.string.English_Locale);

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = sp.edit();

        String keyValue = sp.getString(LOCALE_KEY, "en_US");
        Log.w("key Value", keyValue);
        Log.w("lang", String.valueOf(lang));
        if (keyValue.equalsIgnoreCase("ur")) {
            this.lang--;
            locale = new Locale("en_US");
            //Locale.setDefault(locale);

            //editor.clear();
            editor.putString(LOCALE_KEY, "en_US");
            editor.apply();

            Configuration config = new Configuration();

            config.setLocale(locale);

            getResources().updateConfiguration(
                    config, getResources().getDisplayMetrics()
            );
            super.recreate();
            Log.w("localPref", "recreated");
            Log.w("localPref", "Changed to English");
        } else if (keyValue.equalsIgnoreCase("en_US")) {
            this.lang++;
            locale = new Locale("ur");
            //Locale.setDefault(locale);

            //editor.clear();
            editor.putString(LOCALE_KEY, "ur");
            editor.apply();

            Configuration config = new Configuration();

            config.setLocale(locale);

            getResources().updateConfiguration(
                    config, getResources().getDisplayMetrics()
            );
            super.recreate();
            Log.w("localPref", "recreated");
            Log.w("localPref", "Changed to Urdu");
        }
        Toast.makeText(getApplicationContext(), "Tap once more to confirm action", Toast.LENGTH_SHORT).show();
    }

    public void onClickResetScoreOption(View view){
        Toast.makeText(getApplicationContext(), "Feature Coming Soon!", Toast.LENGTH_SHORT).show();
    }
}
