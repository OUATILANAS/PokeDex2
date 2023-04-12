package com.example.pokdex;


import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.pokdex.models.Pokemon;

import java.util.ArrayList;
import java.util.Random;
public class ListPokemonAdapter extends RecyclerView.Adapter<ListPokemonAdapter.ViewHolder> {
    private static final String PREF_COLOR_KEY = "color_key";

    private static final String TAG = "sss";
    private ArrayList<Pokemon> dataset;
    private Context context;
    private ImageView img1;
    private SharedPreferences prefs;



    public ListPokemonAdapter(Context context) {
        this.context = context;
        dataset = new ArrayList<>();
        prefs = context.getSharedPreferences("pokemon_prefs", Context.MODE_PRIVATE);

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon, parent, false);
        return new ViewHolder(view);
    }
    private void setCornerRadii(GradientDrawable drawable,  float topLeftRadius, float topRightRadius,float bottomLeftRadius, float bottomRightRadius) {
        float[] radii = {topRightRadius, topRightRadius, topLeftRadius, topLeftRadius, bottomRightRadius, bottomRightRadius, bottomLeftRadius, bottomLeftRadius};
        drawable.setCornerRadii(radii);
    }
    public int getRandomColor2() {
        Random rnd = new Random();
        int col1 = rnd.nextInt(256);
        int col2 = rnd.nextInt(256);
        int col3 = rnd.nextInt(256);
        return Color.rgb( col1, col2, col3);
    }
    public int getRandomColor3() {
        SharedPreferences preferences = context.getSharedPreferences("my_preferences", Context.MODE_PRIVATE);
        int defaultColor = Color.WHITE;
        int savedColor = preferences.getInt(PREF_COLOR_KEY, defaultColor);

        Random rnd = new Random();
        int col1 = rnd.nextInt(256);
        int col2 = rnd.nextInt(256);
        int col3 = rnd.nextInt(256);
        int randomColor = Color.rgb( col1, col2, col3);

        if (randomColor == savedColor) {
            // Generate a new color if the randomly generated color is the same as the saved color
            randomColor = Color.rgb(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        }

        // Save the random color to SharedPreferences
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(PREF_COLOR_KEY, randomColor);
        editor.apply();

        return randomColor;
    }

    private int getRandomColor(int position) {
        int color = prefs.getInt("color_" + position, Color.WHITE);
        if (color == Color.WHITE) {
            Random rnd = new Random();
            boolean isDark = false;
            while (!isDark) {
                int col1 = rnd.nextInt(256);
                int col2 = rnd.nextInt(256);
                int col3 = rnd.nextInt(256);
                color = Color.rgb(col1, col2, col3);
                isDark = isColorDark(color);
            }
            prefs.edit().putInt("color_" + position, color).apply();
        }
        return color;
    }

    private boolean isColorDark(int color) {
        double darkness = 1 - (0.299 * Color.red(color) + 0.587 * Color.green(color) + 0.114 * Color.blue(color)) / 255;
        return darkness >= 0.5; // Adjust this threshold as needed
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Pokemon p = dataset.get(position);
        holder.txtTest1.setText(p.getName());

        GradientDrawable drawable = new GradientDrawable();
        int randomColor = getRandomColor(position);
        drawable.setShape(GradientDrawable.RECTANGLE);
        setCornerRadii(drawable, 150f, 150f, 150f, 150f);
        drawable.setColor(randomColor);
        holder.ImageTest1.setId(position+1);

        holder.ImageTest1.setBackgroundDrawable(drawable);

        holder.ImageTest1.setTransitionName("A"+String.valueOf(position+1));




        Glide.with(context)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/" + p.getNumber() + ".png")
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.ImageTest1);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void DicListePokemon(ArrayList<Pokemon> listePokemon) {
        dataset.addAll(listePokemon);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {

        private ImageView ImageTest1;
        private TextView txtTest1;

        public ViewHolder(View itemView) {
            super(itemView);

            ImageTest1 = itemView.findViewById(R.id.Imagetest1);
            txtTest1 = itemView.findViewById(R.id.txttest1);
        }
    }
}
