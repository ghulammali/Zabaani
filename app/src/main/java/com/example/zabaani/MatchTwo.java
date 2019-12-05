package com.example.zabaani;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MatchTwo extends AppCompatActivity {

    private TextView classification_1;
    private TextView classification_2;
    private TextView classification_3;
    private TextView classification_4;

    private TextView emptyBox_1;
    private TextView emptyBox_2;
    private TextView emptyBox_3;
    private TextView emptyBox_4;

    private Button item_1;
    private Button item_2;
    private Button item_3;
    private Button item_4;

    private TextView prompt;

    private int counter = 0;

    private Button next;

    private int level;
    private int highScore_stars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_two);

        Bundle bundle = getIntent().getExtras();
        level = bundle.getInt("level");
        highScore_stars = bundle.getInt("stars");

        emptyBox_1 = findViewById(R.id.emptyBox_1);
        emptyBox_2 = findViewById(R.id.emptyBox_2);
        emptyBox_3 = findViewById(R.id.emptyBox_3);
        emptyBox_4 = findViewById(R.id.emptyBox_4);

        item_1 = findViewById(R.id.item_1);
        item_2 = findViewById(R.id.item_2);
        item_3 = findViewById(R.id.item_3);
        item_4 = findViewById(R.id.item_4);

        item_1.setOnTouchListener(onTouchListener);
        item_2.setOnTouchListener(onTouchListener);
        item_3.setOnTouchListener(onTouchListener);
        item_4.setOnTouchListener(onTouchListener);

        emptyBox_1.setOnDragListener(dragListener_1);
        emptyBox_2.setOnDragListener(dragListener_2);
        emptyBox_3.setOnDragListener(dragListener_3);
        emptyBox_4.setOnDragListener(dragListener_4);

        prompt = findViewById(R.id.prompt);

        next = findViewById(R.id.Next);


    }

    View.OnTouchListener onTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {


            ClipData data = ClipData.newPlainText("", "");
            View.DragShadowBuilder dragShadowBuilder = new View.DragShadowBuilder(view);
            view.startDrag(data, dragShadowBuilder, view, 0);
            return false;
        }
    };
    View.OnDragListener dragListener_1 = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
//
            if (counter>=4){
                next.setVisibility(View.VISIBLE);
                next.setOnClickListener(nextListener);
            }

            int dragEvent = event.getAction();
            final View view = (View) event.getLocalState();

            switch (dragEvent){
                case DragEvent.ACTION_DROP:
                    if (view.getId() == R.id.item_1){
                        view.animate()
                            .x(emptyBox_1.getX())
                            .y(emptyBox_1.getY())
                            .setDuration(700)
                            .start();
                    }
                    else if (view.getId() == R.id.item_2){
                        view.animate()
                                .x(emptyBox_1.getX())
                                .y(emptyBox_1.getY())
                                .setDuration(700)
                                .start();
                    }
                    else if (view.getId() == R.id.item_3){
                        view.animate()
                                .x(emptyBox_1.getX())
                                .y(emptyBox_1.getY())
                                .setDuration(700)
                                .start();
                    }
                    else if (view.getId() == R.id.item_4){
                        view.animate()
                                .x(emptyBox_1.getX())
                                .y(emptyBox_1.getY())
                                .setDuration(700)
                                .start();
                    }
                    counter++;
                    break;
            }

            return true;
        }
    };
    View.OnDragListener dragListener_2 = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();
            final View view = (View) event.getLocalState();

            switch (dragEvent){
                case DragEvent.ACTION_DROP:
                    if (view.getId() == R.id.item_1){
                        view.animate()
                                .x(emptyBox_2.getX())
                                .y(emptyBox_2.getY())
                                .setDuration(700)
                                .start();
                    }
                    else if (view.getId() == R.id.item_2){
                        view.animate()
                                .x(emptyBox_2.getX())
                                .y(emptyBox_2.getY())
                                .setDuration(700)
                                .start();
                    }
                    else if (view.getId() == R.id.item_3){
                        view.animate()
                                .x(emptyBox_2.getX())
                                .y(emptyBox_2.getY())
                                .setDuration(700)
                                .start();
                    }
                    else if (view.getId() == R.id.item_4){
                        view.animate()
                                .x(emptyBox_2.getX())
                                .y(emptyBox_2.getY())
                                .setDuration(700)
                                .start();
                    }
                    counter++;
                    break;

            }

            return true;
        }
    };
    View.OnDragListener dragListener_3 = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();
            final View view = (View) event.getLocalState();

            switch (dragEvent){
                case DragEvent.ACTION_DROP:
                    if (view.getId() == R.id.item_1){
                        view.animate()
                                .x(emptyBox_3.getX())
                                .y(emptyBox_3.getY())
                                .setDuration(700)
                                .start();
                    }
                    else if (view.getId() == R.id.item_2){
                        view.animate()
                                .x(emptyBox_3.getX())
                                .y(emptyBox_3.getY())
                                .setDuration(700)
                                .start();
                    }
                    else if (view.getId() == R.id.item_3){
                        view.animate()
                                .x(emptyBox_3.getX())
                                .y(emptyBox_3.getY())
                                .setDuration(700)
                                .start();
                    }
                    else if (view.getId() == R.id.item_4){
                        view.animate()
                                .x(emptyBox_3.getX())
                                .y(emptyBox_3.getY())
                                .setDuration(700)
                                .start();
                    }
                    counter++;
                    break;
            }
            return true;
        }
    };
    View.OnDragListener dragListener_4 = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();
            final View view = (View) event.getLocalState();

            switch (dragEvent){
                case DragEvent.ACTION_DROP:
                    if (view.getId() == R.id.item_1){
                        view.animate()
                                .x(emptyBox_4.getX())
                                .y(emptyBox_4.getY())
                                .setDuration(700)
                                .start();
                    }
                    else if (view.getId() == R.id.item_2){
                        view.animate()
                                .x(emptyBox_4.getX())
                                .y(emptyBox_4.getY())
                                .setDuration(700)
                                .start();
                    }
                    else if (view.getId() == R.id.item_3){
                        view.animate()
                                .x(emptyBox_4.getX())
                                .y(emptyBox_4.getY())
                                .setDuration(700)
                                .start();
                    }
                    else if (view.getId() == R.id.item_4){
                        view.animate()
                                .x(emptyBox_4.getX())
                                .y(emptyBox_4.getY())
                                .setDuration(700)
                                .start();
                    }
                    counter++;
                    break;
            }
            return true;
        }
    };
    View.OnClickListener nextListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            callMCQ();


        }
    };
    private void callMCQ(){
        Intent i = new Intent(this, MCQ.class);
        Bundle bundle = new Bundle();
        bundle.putInt("stars", highScore_stars);
        bundle.putInt("level", level);
        i.putExtras(bundle);

        startActivity(i);
    }
}
