package com.example.pokdex.Interface;

import com.example.pokdex.models.Pokemon;

import java.util.ArrayList;

public interface ApiDataCallback {
    void onApiDataReceived(ArrayList<Pokemon> listPokemon);
    void onApiDataError(String errorMessage);
}
