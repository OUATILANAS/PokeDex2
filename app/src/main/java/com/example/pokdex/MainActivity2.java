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

public class MainActivity2 extends AppCompatActivity {

    private ProgressBar progressBar;
    private ObjectAnimator progressAnimator;
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

    private RectangleProgressBar progress;

    private ProgressBar progressBar2;
    private TextView progressText;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().hide();
        getWindow().setStatusBarColor(getResources().getColor(R.color.blue1));
        init();
        //init2();
        progressBar = findViewById(R.id.pb);
        //progressBar.setProgress(50);
        //progressBar.setMax(100);
        progressBar2 = findViewById(R.id.progressBar2);
        progressText = findViewById(R.id.progressText2);

        progressBar3=findViewById(R.id.progressBar);
        progressText3=findViewById(R.id.progressText);

        progressBar4=findViewById(R.id.progressBar3);
        progressText4=findViewById(R.id.progressText3);

        progressBar5=findViewById(R.id.progressBar4);
        progressText5=findViewById(R.id.progressText4);

        progressBar6=findViewById(R.id.progressBar5);
        progressText6=findViewById(R.id.progressText5);




       /* int progress = 50; //set your desired progress value here
        progressAnimator2 = ObjectAnimator.ofInt(progressBar2,"progress",0,50);
        progressBar2.setProgress(progress);
        progressText.setText(progress + "%");
        //progressAnimator2.setDuration(1000);
        //progressAnimator2.start();
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.progress_bar_anim);
        progressBar2.startAnimation(animation);
        progressText.startAnimation(animation);*/

        int progress = 50; //set your desired progress value here
        progressBar2.setProgress(progress);

        int maxWidth = progressBar2.getWidth() - progressBar2.getPaddingLeft() - progressBar2.getPaddingRight();
        int maxProgress = (int) ((progressBar2.getMax() * maxWidth) / (float) progressBar2.getWidth());

        if (progress > maxProgress) {
            progress = maxProgress;
        }

        //progressText.setText(50 + "%");
        imageView = findViewById(R.id.imageView);
        img1 = findViewById(R.id.imageButton12);
        txt1= findViewById(R.id.textView3);
        // create and start the animation
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this,MainActivity.class);
                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View,String>(img1,"imageTransition");
                pairs[1] = new Pair<View,String>(txt1,"textTransition");
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity2.this, pairs);
                startActivity(intent,options.toBundle());
            }
        });
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.progress_bar_anim);
        animation.setInterpolator(new LinearInterpolator());
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
               progressText.clearAnimation();
               //progressText.setX(progressBar2.getX() + progressBar2.getWidth() - progressText.getWidth());
                //progressText.setX(500);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {}
        });
        ObjectAnimator progressBarAnimator = ObjectAnimator.ofInt(progressBar2, "progress", 0, 50);
        progressBarAnimator.setDuration(1000);
        progressBarAnimator.start();

        ObjectAnimator progressBarAnimator4 = ObjectAnimator.ofInt(progressBar4, "progress", 0, 40);
        progressBarAnimator4.setDuration(1000);
        progressBarAnimator4.start();

        ObjectAnimator progressBarAnimator5 = ObjectAnimator.ofInt(progressBar5, "progress", 0, 80);
        progressBarAnimator5.setDuration(1000);
        progressBarAnimator5.start();

        ObjectAnimator progressBarAnimator6 = ObjectAnimator.ofInt(progressBar6, "progress", 0, 20);
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


        progressAnimator.setDuration(1000);
        progressAnimator.start();
        progressBar.setVisibility(View.INVISIBLE);

    }

    private void init()
    {
        progressBar = findViewById(R.id.pb);
        progressAnimator = ObjectAnimator.ofInt(progressBar,"progress",0,50);
    }

}