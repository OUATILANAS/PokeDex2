package com.example.pokdex;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageButton img1;
    private ImageButton img2;
    private ImageButton img3;
    private ImageButton img4;

    private TextView txt1;
    private TextView txt2;
    private TextView txt3;
    private TextView txt4;

    private ImageButton img5;
    private ImageButton img6;
    private ImageButton img7;
    private ImageButton img8;

    private TextView txt5;
    private TextView txt6;
    private TextView txt7;
    private TextView txt8;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img1 = findViewById(R.id.imageButton17);
        txt1 = findViewById(R.id.textView4);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View,String>(img1,"imageTransition");
                pairs[1] = new Pair<View,String>(txt1,"textTransition");
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
                startActivity(intent,options.toBundle());


            }
        });

        img2 = findViewById(R.id.imageButton16);
        txt2 = findViewById(R.id.textView5);

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this,MainActivity3.class);
                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View,String>(img2,"imageTransition2");
                pairs[1] = new Pair<View,String>(txt2,"textTransition2");
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
                startActivity(intent2,options.toBundle());


            }
        });

        img3 = findViewById(R.id.imageButton24);
        txt3 = findViewById(R.id.textView7);

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this,MainActivity4.class);
                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View,String>(img3,"imageTransition3");
                pairs[1] = new Pair<View,String>(txt3,"textTransition3");
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
                startActivity(intent2,options.toBundle());


            }
        });

        img4 = findViewById(R.id.imageButton14);
        txt4 = findViewById(R.id.textView8);

        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this,MainActivity5.class);
                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View,String>(img4,"imageTransition4");
                pairs[1] = new Pair<View,String>(txt4,"textTransition4");
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
                startActivity(intent2,options.toBundle());


            }
        });

        img5 = findViewById(R.id.imageButton22);
        txt5 = findViewById(R.id.textView9);

        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this,MainActivity6.class);
                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View,String>(img5,"imageTransition5");
                pairs[1] = new Pair<View,String>(txt5,"textTransition5");
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
                startActivity(intent2,options.toBundle());


            }
        });

        img6 = findViewById(R.id.imageButton23);
        txt6 = findViewById(R.id.textView10);

        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this,MainActivity7.class);
                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View,String>(img6,"imageTransition6");
                pairs[1] = new Pair<View,String>(txt6,"textTransition6");
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
                startActivity(intent2,options.toBundle());


            }
        });

        img7 = findViewById(R.id.imageButton28);
        txt7 = findViewById(R.id.textView11);

        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this,MainActivity8.class);
                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View,String>(img7,"imageTransition7");
                pairs[1] = new Pair<View,String>(txt7,"textTransition7");
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
                startActivity(intent2,options.toBundle());


            }
        });

        img8 = findViewById(R.id.imageButton29);
        txt8 = findViewById(R.id.textView12);

        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this,MainActivity9.class);
                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View,String>(img8,"imageTransition8");
                pairs[1] = new Pair<View,String>(txt8,"textTransition8");
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
                startActivity(intent2,options.toBundle());


            }
        });



    }
}