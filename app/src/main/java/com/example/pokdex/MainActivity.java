package com.example.pokdex;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.pokdex.models.Pokemon;
import com.example.pokdex.models.PokemonRequest;
import com.example.pokdex.pokeapi.PokeapiService;

import java.util.ArrayList;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity  {
    private static final String TAG = "POKDEX";
    private ImageView img;
    private TextView txt;

    private Retrofit retrofit;
    private RecyclerView recyclerView;
    private ListPokemonAdapter listPokemonAdapter;
    private int offset=0;
    private boolean Limit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        listPokemonAdapter = new ListPokemonAdapter(this);
        recyclerView.setAdapter(listPokemonAdapter);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(MainActivity.this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                // Show progress dialog or loading indicator


// Make API request and retrieve data
// Once data is retrieved, dismiss progress dialog and start second activity

                Intent intent2 = new Intent(MainActivity.this,MainActivity2.class);
                intent2.putExtra("index",String.valueOf(position+1));

                img= findViewById(position+1);
                img.setTransitionName("A"+String.valueOf(position+1));

                GradientDrawable drawable2 = (GradientDrawable) img.getBackground();
                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View,String>(img,"A"+String.valueOf(position+1));
                intent2.putExtra("color",String.valueOf(drawable2.getColor().getDefaultColor()));
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);

                startActivity(intent2,options.toBundle());
            }

            @Override
            public void onItemLongClick(View view, int position) {
            }
        }));
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (dy > 0) {
                    int visibleItemCount = layoutManager.getChildCount();
                    int totalItemCount = layoutManager.getItemCount();
                    int pastVisibleItems = layoutManager.findFirstVisibleItemPosition();

                    if (Limit) {
                        if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {
                            Limit = false;
                            offset += 20;
                            getData(offset);
                        }
                    }
                }
            }
        });

        retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Limit = true;
        offset=0;
        getData(offset);

    }

    private void getData(int offset){
        ProgressBar progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

        PokeapiService service = retrofit.create(PokeapiService.class);
        Call<PokemonRequest> pokemonRequestCall = service.getPokemonList(20,offset);
        pokemonRequestCall.enqueue(new Callback<PokemonRequest>() {
            @Override
            public void onResponse(Call<PokemonRequest> call, Response<PokemonRequest> response) {
                Limit = true;
                ProgressBar progressBar = findViewById(R.id.progressBar);
                progressBar.setVisibility(View.GONE);
                if (response.isSuccessful())
                {
                    PokemonRequest pokemonRequest = response.body();
                    ArrayList<Pokemon> listPokemon = pokemonRequest.getResults();
                    listPokemonAdapter.DicListePokemon(listPokemon);


                    for (int i = 0 ; i<listPokemon.size();i++)
                    {
                        //img= findViewById(i+1);
                        //img.setTransitionName("A"+String.valueOf(i+1));
                    }
                }
                else{
                    Log.e(TAG," onResponse: " +response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<PokemonRequest> call, Throwable t) {
                Limit = true;
                Log.e(TAG," onFailure : " + t.getMessage());

            }
        });
    }
}