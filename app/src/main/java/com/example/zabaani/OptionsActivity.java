package com.example.zabaani;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        //this.lang = 0;

        ChangeNameButton = (TextView) findViewById(R.id.ChangeNameButton);
        //SharedPreferences sp = getSharedPreferences(LOCALE_PREF_KEY, MODE_PRIVATE);
        //String localeString = sp.getString(LOCALE_KEY, ENGLISH_LOCALE);
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
                        Toast.makeText(getApplicationContext(), "No changes made", Toast.LENGTH_SHORT).show();
                        //Log.w("check", keyvalue);
                    }
                });

        AlertDialog alert = alertDialogueBuilder.create();
        alert.show();

        //Toast.makeText(getApplicationContext(), "Feature Coming Soon!", Toast.LENGTH_SHORT).show();
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
