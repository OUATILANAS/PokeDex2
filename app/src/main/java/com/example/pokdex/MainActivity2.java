package com.example.pokdex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.pokdex.models.Pokemon;
import com.example.pokdex.models.Stat;
import com.example.pokdex.models.Type;
import com.example.pokdex.pokeapi.PokeapiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity2 extends AppCompatActivity{

    private static final String TAG = "ss";
    private Retrofit retrofit;
    private String index;
    private int color;

    private TextView textView18;
    private TextView textView19;
    private TextView textView20;


    private ProgressBar progressBar;
    private ImageView imageView;
    private ImageButton img1;
    private TextView txt1;
    private ProgressBar progressBar3;
    private TextView progressText3;

    private ProgressBar progressBar4;
    private TextView progressText4;

    private ProgressBar progressBar5;
    private TextView progressText5;

    private ProgressBar progressBar1;
    private TextView progressText1;

    private ProgressBar progressBar6;
    private TextView progressText6;

    private ProgressBar progressBar2;
    private TextView progressText2;

    private ProgressBar progressBar00;


    private void setCornerRadii(GradientDrawable drawable, float bottomLeftRadius, float bottomRightRadius) {
        float[] radii = {0, 0, 0,0, bottomRightRadius, bottomRightRadius, bottomLeftRadius, bottomLeftRadius};
        drawable.setCornerRadii(radii);
    }

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        index = getIntent().getStringExtra("index");

        retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/pokemon/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //progressBar00 = findViewById(R.id.progressBar7);
       // progressBar00.setVisibility(View.GONE);



        setContentView(R.layout.activity_main2);
        getSupportActionBar().hide();





        progressBar = findViewById(R.id.pb);

        progressBar1 = findViewById(R.id.progressBar1);
        progressText1 = findViewById(R.id.progressText1);

        progressBar2 = findViewById(R.id.progressBar2);
        progressText2 = findViewById(R.id.progressText2);

        progressBar3=findViewById(R.id.progressBar3);
        progressText3=findViewById(R.id.progressText3);

        progressBar4=findViewById(R.id.progressBar4);
        progressText4=findViewById(R.id.progressText4);

        progressBar5=findViewById(R.id.progressBar5);
        progressText5=findViewById(R.id.progressText5);

        progressBar6=findViewById(R.id.progressBar6);
        progressText6=findViewById(R.id.progressText6);


        imageView = findViewById(R.id.imageView);
        img1 = findViewById(R.id.imageButton12);
        img1.setTransitionName("A"+String.valueOf(index));
        txt1= findViewById(R.id.textView3);

        //img1.setVisibility(View.GONE);

        getData();

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Intent intent = new Intent(MainActivity2.this,MainActivity.class);
                startActivity(intent);
                index = getIntent().getStringExtra("index");
                img1 = findViewById(R.id.imageButton12);
                //txt1= findViewById(R.id.textView3);
                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View,String>(img1,"A"+index);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity2.this, pairs);
                startActivity(intent,options.toBundle());*/
                GradientDrawable drawable = new GradientDrawable();
                img1 = findViewById(R.id.imageButton12);
                drawable.setShape(GradientDrawable.RECTANGLE);
                color = Integer.parseInt(getIntent().getStringExtra("color"));
                setCornerRadii(drawable, 150f, 150f,150f,150f);
                drawable.setColor(color);
                drawable.setAlpha(0); // set alpha to 0 for transparency
                img1.setBackgroundDrawable(drawable);
                onBackPressed();

            }
        });

        progressBar.setVisibility(View.INVISIBLE);

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void getData(){
        //progressBar00 = findViewById(R.id.progressBar7);
        //progressBar00.setVisibility(View.VISIBLE);
        PokeapiService service = retrofit.create(PokeapiService.class);
        Call<Pokemon> pokemonRequestCall = service.getPokemon(index);
        pokemonRequestCall.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                //img1.setVisibility(View.VISIBLE);
                //progressBar00 = findViewById(R.id.progressBar7);
                //progressBar00.setVisibility(View.GONE);
                textView18 = findViewById(R.id.textView18);
                textView19 = findViewById(R.id.textView19);
                img1 = findViewById(R.id.imageButton12);
                Pokemon pokemonRequest = response.body();


                txt1.setText(pokemonRequest.getName().substring(0, 1).toUpperCase() + pokemonRequest.getName().substring(1));
                Glide.with(MainActivity2.this)
                        .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/"+index+".png")
                        .into(img1);
                textView18.setText(pokemonRequest.getWeight() + " KG");
                textView19.setText(pokemonRequest.getHeight() + " FT");
                GradientDrawable drawable = new GradientDrawable();
                color = Integer.parseInt(getIntent().getStringExtra("color"));
                img1.setTransitionName("A"+index);
                drawable.setShape(GradientDrawable.RECTANGLE);

                setCornerRadii(drawable, 200f, 200f);

                drawable.setColor(color);

                img1.setBackgroundDrawable(drawable);
                getWindow().setStatusBarColor(color);
                ConstraintLayout toolbarLayout = findViewById(R.id.toolbar);

                toolbarLayout.setBackgroundColor(color); // replace RED with the color you want
                TextView textView = findViewById(R.id.text2);

                textView.setText("#"+index);

                for (Stat stat : pokemonRequest.getStats()) {
                    switch (stat.getStat().getName()) {
                        case "hp":
                            createLoadingAnimation(progressBar1, progressText1, stat.getBaseStat(), 100);
                            break;
                        case "attack":
                            createLoadingAnimation(progressBar2, progressText2, stat.getBaseStat(), 100);
                            break;
                        case "defense":
                            createLoadingAnimation(progressBar3, progressText3, stat.getBaseStat(), 100);
                            break;
                        case "special-attack":
                            createLoadingAnimation(progressBar4, progressText4, stat.getBaseStat(), 100);
                            break;
                        case "special-defense":
                            createLoadingAnimation(progressBar5, progressText5, stat.getBaseStat(), 100);
                            break;
                        case "speed":
                            createLoadingAnimation(progressBar6, progressText6, stat.getBaseStat(), 100);
                            break;
                    }
                }
                LinearLayout typeLayout = findViewById(R.id.typeLayout);
                List<Type> types = pokemonRequest.getTypes();
                for (int i = 0; i < types.size(); i++) {
                    // Create a new TextView
                    TextView typeTextView = new TextView(MainActivity2.this);
                    // Set its properties
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                    );
                    layoutParams.setMargins(0, 0, 30, 0); // Add 16dp margin to the right
                    typeTextView.setLayoutParams(layoutParams);
                    typeTextView.setWidth(250);
                    typeTextView.setHeight(100);
                    String typeName = types.get(i).getType().getName();
                    typeName = typeName.substring(0, 1).toUpperCase() + typeName.substring(1);
                    typeTextView.setText(typeName);
                    // Create a new GradientDrawable with the desired background color and corner radius
                    GradientDrawable bgDrawable = new GradientDrawable();
                    bgDrawable.setColor(Common.getColorByType(typeName));
                    setCornerRadii(bgDrawable, 50, 50, 50, 50); // Set the corner radius to 16dp
                    typeTextView.setBackground(bgDrawable); // Set the background of the TextView
                    typeTextView.setPadding(80, 25, 0, 25);
                    typeTextView.setTextColor(getResources().getColor(R.color.white));
                    typeTextView.setTextSize(12);
                    // Get the type name and set it as the text of the TextView

                    // Add the TextView to the layout
                    typeLayout.addView(typeTextView);
                }





            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                Log.e(TAG," not working: ");
            }
        });
    }
    private void setCornerRadii(GradientDrawable drawable, float topLeftRadius, float topRightRadius, float bottomLeftRadius, float bottomRightRadius) {
        float[] radii = {topLeftRadius, topLeftRadius, topRightRadius, topRightRadius, bottomLeftRadius, bottomLeftRadius, bottomRightRadius, bottomRightRadius};
        drawable.setCornerRadii(radii);
    }

    private void createLoadingAnimation(ProgressBar progressBar, TextView progressText, int baseStat, int effort) {
        int maxWidth = progressBar.getWidth() - progressBar.getPaddingLeft() - progressBar.getPaddingRight();
        int maxProgress = (int) ((baseStat * maxWidth) / (float) progressBar.getWidth());
        int progress = effort > maxProgress ? maxProgress : effort;
        ObjectAnimator progressAnimator = ObjectAnimator.ofInt(progressBar, "progress", 0, progress);
        progressAnimator.setDuration(1000);
        progressAnimator.start();
        progressAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int progress = (int) valueAnimator.getAnimatedValue()-3;
                int width = progressBar.getWidth();
                float position = (progress / (float) progressBar.getMax() * width);
                progressText.setX(progressBar.getX() + position - progressText.getWidth() / 2f);
            }
        });
        progressText.setText(baseStat + "/" + effort);
    }





}