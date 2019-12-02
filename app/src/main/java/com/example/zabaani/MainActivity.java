package com.example.zabaani;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    MediaPlayer ring;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
