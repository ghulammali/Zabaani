package com.example.zabaani;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class OptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
    }

    public void onClickChangeNameOption(View view){
        Toast.makeText(getApplicationContext(), "Feature Coming Soon!", Toast.LENGTH_SHORT).show();
    }

    public void onClickMusicOption(View view){
        Toast.makeText(getApplicationContext(), "Feature Coming Soon!", Toast.LENGTH_SHORT).show();
    }

    public void onClickMenuTextOption(View view){
        Toast.makeText(getApplicationContext(), "Feature Coming Soon!", Toast.LENGTH_SHORT).show();
    }

    public void onClickResetScoreOption(View view){
        Toast.makeText(getApplicationContext(), "Feature Coming Soon!", Toast.LENGTH_SHORT).show();
    }
}
