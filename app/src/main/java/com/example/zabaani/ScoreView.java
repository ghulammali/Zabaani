package com.example.zabaani;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class ScoreView extends AppCompatActivity {

    private ImageView sm1,sm2,sm3;
    private TextView Viewscore;
    private Button again;
    private Button Quit;

    private int currentScore;
    private int level;
    private  int highScore_stars;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_view);

        // receive the score from calling activity
        Bundle bundle = getIntent().getExtras();
        currentScore = bundle.getInt("score");
        level = bundle.getInt("level");
        highScore_stars = bundle.getInt("stars");
        sm1 = findViewById(R.id.s1);
        sm2 = findViewById(R.id.s2);
        sm3 = findViewById(R.id.s3);


        // claculate stars
        int CurrentStars = CalculateStars(currentScore);
        if (CurrentStars >= 1 ){
            sm1.setImageResource(R.drawable.sg);
        }
        if (CurrentStars >= 2 ){
            sm2.setImageResource(R.drawable.sg);
        }
        if (CurrentStars == 3 ){
            sm3.setImageResource(R.drawable.sg);
        }
        // check if it is more than previous the high score in this level
        if (CurrentStars > highScore_stars){
            writeToFile(Integer.toString(currentScore), this, Integer.toString(level));
        }
        // if yes then add it to file
        // else nothing

        // save score to file


        // configure button and display score
        Quit = findViewById(R.id.Quit);
        Quit.setText("Quit");
        again = findViewById(R.id.again);
        again.setText("Play Again");
        Viewscore = findViewById(R.id.score);
        Viewscore.setText(String.valueOf(currentScore));

        // listener for continue
        again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                level();
            }
        });
        // listener for quiT
        Quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callMain();
            }
        });


    }

    private void level(){
        Intent i = new Intent(this, LevelActivity.class);
        startActivity(i);
    }
    private void callMain(){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
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
    private int CalculateStars(int score){
        int stars = 0;
        if (score <= 0){
            stars = 0;
        }
        else if (score <= 2){
            stars = 1;
        }
        else if (score <= 4){
            stars = 2;
        }
        else if (score >= 5){
            stars = 3;
        }
        return stars;
    }
}

