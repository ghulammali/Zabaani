package com.example.zabaani;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
    }

    public void onClickBlankHelp(View view){
        Intent intent = new Intent(HelpActivity.this, BlankTutorialActivity.class);
        startActivity(intent);
    }

    public void onClickMcqHelp(View view){
        Intent intent = new Intent(HelpActivity.this, McqTutorialActivity.class);
        startActivity(intent);
    }

    public void onClickMtwoHelp(View view){
        Toast.makeText(getApplicationContext(), "Feature Coming Soon!", Toast.LENGTH_SHORT).show();
    }

    public void onClickShuffleHelp(View view){
        Toast.makeText(getApplicationContext(), "Feature Coming Soon!", Toast.LENGTH_SHORT).show();
    }

    public void onClickFlashHelp(View view){
        Toast.makeText(getApplicationContext(), "Feature Coming Soon!", Toast.LENGTH_SHORT).show();
    }

    public void onClickStoriesHelp(View view){
        Toast.makeText(getApplicationContext(), "Feature Coming Soon!", Toast.LENGTH_SHORT).show();
    }
}
