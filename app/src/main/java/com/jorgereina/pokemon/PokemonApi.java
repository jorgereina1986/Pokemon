package com.jorgereina.pokemon;

import com.jorgereina.pokemon.data.model.PokemonResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokemonApi {

    @GET("pokedex/national/")
    Call<PokemonResponse> getPokemon();

    @GET("pokemon-shape/{id}")
    Call<PokemonResponse> getPokemonImage(@Path("id") int id);
}
