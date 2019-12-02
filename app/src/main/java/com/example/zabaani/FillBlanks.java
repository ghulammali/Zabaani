package com.example.zabaani;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FillBlanks extends AppCompatActivity {

    private com.example.zabaani.FillBlanksLibrary mQuestionLibrary = new FillBlanksLibrary();
    private TextView mQuestionsLeft;
    private TextView mQuestionview;
    private TextView mQuestionsLeftTextBox;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button mButtonChoice4;
    private Button Quit;

    private int level;
    private int QuestionsLeft = 2;
    private String mAnswer;
    public static int mScore;
    private int mQuestionNumber;
    private int highScore_stars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_blanks);

        // receive level number from main activity
        Bundle bundle = getIntent().getExtras();
        level = bundle.getInt("level");
        mScore = bundle.getInt("score");
        highScore_stars = bundle.getInt("stars");


        // configure number of questions according to the level
        if (level == 1){
            mQuestionNumber = 0;
        }
        else if (level == 2){
            mQuestionNumber = 2;
        }
        else if (level == 3){
            mQuestionNumber = 4;
        }


        mQuestionsLeftTextBox = findViewById(R.id.questions_left_textbox);
        mQuestionsLeft = (TextView)findViewById(R.id.questions_left) ;
        mQuestionview = (TextView)findViewById(R.id.question_text);
        mButtonChoice1 = (Button) findViewById(R.id.Choice_1);
        mButtonChoice2 = (Button) findViewById(R.id.Choice_2);
        mButtonChoice3 = (Button) findViewById(R.id.Choice_3);
        mButtonChoice4 = (Button) findViewById(R.id.Choice_4);
        Quit = findViewById(R.id.Quit);

        updateQuestion();
        // start of listener for choice 1
        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mButtonChoice1.getText() == mAnswer){
                    mScore = mScore +1;
                    updateQuestion();
                }
                else {
                    updateQuestion();
                }
            }
        });
        // end of listener for choice 1
        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mButtonChoice2.getText() == mAnswer){
                    mScore = mScore +1;
                    updateQuestion();
                }
                else {
                    updateQuestion();
                }
            }
        });
        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mButtonChoice3.getText() == mAnswer){
                    mScore = mScore +1;
                    updateQuestion();
                }
                else {
                    updateQuestion();
                }
            }
        });
        mButtonChoice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mButtonChoice4.getText() == mAnswer){
                    mScore = mScore +1;
                    updateQuestion();
                }
                else {
                    updateQuestion();
                }
            }
        });
        // end of listener for button 4

        // listener for quit. make it call the main maenu screen
        Quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                 only enter quit activity name, leave the rest unchanged
//                 also add it to android manifests file
                callMain();
            }
        });
    }

    private void updateQuestion(){
        // if all questions have been answered, move on to next activity (view score)
        if (QuestionsLeft == 0){
            Intent i = new Intent(this, ScoreView.class);
            Bundle bundle = new Bundle();
            bundle.putInt("stars", highScore_stars);
            bundle.putInt("level", level);
            bundle.putInt("score", mScore);
            i.putExtras(bundle);
            startActivity(i);
        }
        // otherwise update the question
        else {
            mQuestionview.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
            mButtonChoice1.setText(mQuestionLibrary.getChoice1(mQuestionNumber));
            mButtonChoice2.setText(mQuestionLibrary.getChoice2(mQuestionNumber));
            mButtonChoice3.setText(mQuestionLibrary.getChoice3(mQuestionNumber));
            mButtonChoice4.setText(mQuestionLibrary.getChoice4(mQuestionNumber));

            mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
            mQuestionNumber++; // for the actual question from the question library

            if (QuestionsLeft > 1) {
                QuestionsLeft--;
                mQuestionsLeft.setText(String.valueOf(QuestionsLeft));
            } else if (QuestionsLeft == 1) {
                QuestionsLeft--;
                mQuestionsLeft.setText("Last Question!");
                mQuestionsLeftTextBox.setText("");

            }
        }

    }
    // go back to main activity
    private void callMain(){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
