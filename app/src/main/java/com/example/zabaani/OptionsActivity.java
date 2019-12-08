package com.example.zabaani;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class OptionsActivity extends AppCompatActivity {

    private Locale locale;
    //public int lang;
    private TextView ChangeNameButton;
    private TextView MusicButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        ChangeNameButton = (TextView) findViewById(R.id.ChangeNameButton);

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        String keyvalue = sp.getString("Music", "On");

        MusicButton = (TextView) findViewById(R.id.MusicButton);
        if (keyvalue.equalsIgnoreCase("On")) {
            MusicButton.setText(R.string.options_musicChangeOn);
        } else {
            MusicButton.setText(R.string.options_musicChangeOff);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) { //Back key pressed
            //Things to Do
            Intent intent = new Intent(OptionsActivity.this, MainActivity.class);
            startActivity(intent);
            finishAffinity();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    public void onClickChangeNameOption(View view){
        LayoutInflater layoutInflater = LayoutInflater.from(OptionsActivity.this);
        View promptview = layoutInflater.inflate(R.layout.input_dialogue_changename, null);

        AlertDialog.Builder alertDialogueBuilder = new AlertDialog.Builder(OptionsActivity.this);
        alertDialogueBuilder.setView(promptview);

        final EditText EnterNameInput = (EditText) promptview.findViewById(R.id.EnterNameInput);

        alertDialogueBuilder.setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                        SharedPreferences.Editor editor = sp.edit();
                        //String keyvalue = sp.getString("User_name", "Human");
                        //Log.w("check", keyvalue);
                        String username = EnterNameInput.getText().toString();
                        editor.putString("User_name", username);
                        editor.apply();
                        Toast.makeText(getApplicationContext(), "Name Changed Successfully", Toast.LENGTH_SHORT).show();
                        //String keyvalue2 = sp.getString("User_name", "Human");
                        //Log.w("check", keyvalue2);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        Toast.makeText(getApplicationContext(), "No Changes Made", Toast.LENGTH_SHORT).show();
                        //Log.w("check", keyvalue);
                    }
                });

        AlertDialog alert = alertDialogueBuilder.create();
        alert.show();

        //Toast.makeText(getApplicationContext(), "Feature Coming Soon!", Toast.LENGTH_SHORT).show();
    }

    public void onClickMusicOption(View view){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sp.edit();

        String keyvalue = sp.getString("Music", "On");
        Integer musicPlayerCount = sp.getInt("Music_player", 0);

        if (keyvalue.equalsIgnoreCase("On") && musicPlayerCount.equals(1)) {
            editor.putString("Music", "Off");
            editor.putInt("Music_player", 0);
            editor.apply();
            MusicButton.setText(R.string.options_musicChangeOff);
            AudioPlay.stopAudio();
        } else if (keyvalue.equalsIgnoreCase("Off") && musicPlayerCount.equals(0)) {
            editor.putString("Music", "On");
            editor.putInt("Music_player", 1);
            editor.apply();
            MusicButton.setText(R.string.options_musicChangeOn);
            AudioPlay.playAudio(getApplicationContext(), R.raw.overworld_terraria);
        }
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
        //Log.w("lang", String.valueOf(lang));
        if (keyValue.equalsIgnoreCase("ur")) {
            //this.lang--;
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
            //this.lang++;
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
