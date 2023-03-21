package com.example.pokdex;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity9 extends AppCompatActivity {

    private ImageView imageView;
    private ImageButton img1;
    private TextView txt1;
    private ProgressBar progressBar3;
    private TextView progressText3;

    private ProgressBar progressBar4;
    private TextView progressText4;

    private ProgressBar progressBar5;
    private TextView progressText5;

    private ProgressBar progressBar6;
    private TextView progressText6;


    private ProgressBar progressBar2;
    private TextView progressText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
        getSupportActionBar().hide();
        getWindow().setStatusBarColor(getResources().getColor(R.color.green2));

        progressBar2 = findViewById(R.id.progressBar2);
        progressText = findViewById(R.id.progressText2);

        progressBar3 = findViewById(R.id.progressBar);
        progressText3 = findViewById(R.id.progressText);

        progressBar4 = findViewById(R.id.progressBar3);
        progressText4 = findViewById(R.id.progressText3);

        progressBar5 = findViewById(R.id.progressBar4);
        progressText5 = findViewById(R.id.progressText4);

        progressBar6 = findViewById(R.id.progressBar5);
        progressText6 = findViewById(R.id.progressText5);


        imageView = findViewById(R.id.imageView2);
        img1 = findViewById(R.id.imageButton29);
        txt1 = findViewById(R.id.textView29);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity9.this, MainActivity.class);
                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View, String>(img1, "imageTransition8");
                pairs[1] = new Pair<View, String>(txt1, "textTransition8");
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity9.this, pairs);
                startActivity(intent, options.toBundle());
            }
        });
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.progress_bar_anim);
        animation.setInterpolator(new LinearInterpolator());

        ObjectAnimator progressBarAnimator = ObjectAnimator.ofInt(progressBar2, "progress", 0, 80);
        progressBarAnimator.setDuration(1000);
        progressBarAnimator.start();

        ObjectAnimator progressBarAnimator4 = ObjectAnimator.ofInt(progressBar4, "progress", 0, 40);
        progressBarAnimator4.setDuration(1000);
        progressBarAnimator4.start();

        ObjectAnimator progressBarAnimator5 = ObjectAnimator.ofInt(progressBar5, "progress", 0, 80);
        progressBarAnimator5.setDuration(1000);
        progressBarAnimator5.start();

        ObjectAnimator progressBarAnimator6 = ObjectAnimator.ofInt(progressBar6, "progress", 0, 55);
        progressBarAnimator6.setDuration(1000);
        progressBarAnimator6.start();
        //progressBar2.startAnimation(animation);
        progressText.startAnimation(animation);
        progressText3.startAnimation(animation);
        progressText4.startAnimation(animation);
        progressText5.startAnimation(animation);
        progressText6.startAnimation(animation);


        ObjectAnimator progressBarAnimator3 = ObjectAnimator.ofInt(progressBar3, "progress", 0, 70);
        progressBarAnimator3.setDuration(1000);
        progressBarAnimator3.start();
    }
}