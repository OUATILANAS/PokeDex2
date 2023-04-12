package com.example.pokdex.pokeapi;

import com.example.pokdex.models.Pokemon;
import com.example.pokdex.models.PokemonRequest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PokeapiService {

    @GET("pokemon")
    Call<PokemonRequest> getPokemonList(@Query("limit") int limit, @Query("offset") int offset);
    @GET("{dexNumOrName}/")
    Call<Pokemon> getPokemon(@Path("dexNumOrName") String dexNumOrName);
}
