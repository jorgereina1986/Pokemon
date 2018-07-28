package com.jorgereina.pokemon;

import com.jorgereina.pokemon.model.PokemonResponse;

import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PokemonApi {

    @GET("pokedex/national/")
    Call<PokemonResponse> getPokemon();
//    Call<ResponseBody> getPokemon();
}
