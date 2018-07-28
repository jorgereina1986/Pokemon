package com.jorgereina.pokemon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.jorgereina.pokemon.model.PokemonResponse;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    @Inject
    PokemonApi pokemonApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Timber.d("onCreate lunched");
        ((App)getApplication()).getNetworkComponent().inject(this);

        Call<PokemonResponse> call = pokemonApi.getPokemon();
        call.enqueue(new Callback<PokemonResponse>() {
            @Override
            public void onResponse(Call<PokemonResponse> call, Response<PokemonResponse> response) {

                Timber.d("onResponse lunched");
                Log.d("lagarto", response.body().getPokemonEntriesEntries().get(0).getPokemonSpecies().getName());

            }

            @Override
            public void onFailure(Call<PokemonResponse> call, Throwable t) {
                Timber.d("Call failed");

            }
        });

//        Call<ResponseBody> call = pokemonApi.getPokemon();
//        call.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                try {
//                    Log.d("lagarto", response.body().string());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//
//            }
//        });
    }
}
