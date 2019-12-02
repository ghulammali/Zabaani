package com.example.zabaani;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Serializable;

public class LevelActivity extends AppCompatActivity {
    private Button LevelSelect_1;
    private Button LevelSelect_2;
    private Button LevelSelect_3;
    private int[] level_stars = {0,0,0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        String readStars = readFromFile(this, "1");
        if (readStars!=""){
            level_stars[0] = Integer.parseInt(readStars);
        }
        String rreadStars = readFromFile(this, "2");
        if (rreadStars!=""){
            level_stars[1] = Integer.parseInt(rreadStars);
        }
        String rrreadStars = readFromFile(this, "3");
        if (rrreadStars!=""){
            level_stars[2] = Integer.parseInt(rrreadStars);
        }
        LevelSelect_1 = findViewById(R.id.level_1);
        LevelSelect_1.setText("Level 1");
        LevelSelect_2 = findViewById(R.id.level_2);
        LevelSelect_2.setText("Level 2");
        LevelSelect_3 = findViewById(R.id.level_3);
        LevelSelect_3.setText("Level 3");

        LevelSelect_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLevel(1);
            }
        });
        LevelSelect_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLevel(2);
            }
        });
        LevelSelect_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLevel(3);
            }
        });
    }
    public void openLevel(int level){
        Intent i = new Intent(this, MCQ.class);
        Bundle bundle = new Bundle();
        bundle.putInt("stars", level_stars[level-1]);
        bundle.putInt("level", level);
        i.putExtras(bundle);

        startActivity(i);
    }
    private String readFromFile(Context context, String level) {

        String ret = "";

        try {
            InputStream inputStream = context.openFileInput("level"+level+".txt");

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }

        return ret;
    }
    private void writeToFile(String data, Context context, String level) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("level"+level+".txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

}
