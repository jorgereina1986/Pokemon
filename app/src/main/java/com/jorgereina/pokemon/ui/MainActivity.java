package com.jorgereina.pokemon.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jorgereina.pokemon.App;
import com.jorgereina.pokemon.PokemonApi;
import com.jorgereina.pokemon.R;
import com.jorgereina.pokemon.data.model.DataRepository;
import com.jorgereina.pokemon.databinding.ActivityMainBinding;
import com.jorgereina.pokemon.data.model.PokemonResponse;
import com.jorgereina.pokemon.data.model.PokemonSpecies;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    @Inject
    PokemonApi pokemonApi;
    @Inject
    PokemonAdapter adapter;
    @Inject
    DataRepository dataRepository;


    private ActivityMainBinding binding;
    private List<PokemonSpecies> pokemonSpeciesList = new ArrayList<>();
    private RecyclerView.LayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        ((App)getApplication()).getNetworkComponent().inject(this);

        linearLayoutManager = new LinearLayoutManager(this);
        binding.pokemonListRv.setLayoutManager(linearLayoutManager);
        binding.pokemonListRv.setAdapter(adapter);


        Call<PokemonResponse> call = pokemonApi.getPokemon();
        call.enqueue(new Callback<PokemonResponse>() {
            @Override
            public void onResponse(Call<PokemonResponse> call, Response<PokemonResponse> response) {
                Timber.d(response.body().getPokemonEntriesEntries().get(0).getPokemonSpecies().getName());

                dataRepository.setPokemonEntriesList(response.body().getPokemonEntriesEntries());

                Timber.d(dataRepository.getData(0).getPokemonSpecies().getName());

            }

            @Override
            public void onFailure(Call<PokemonResponse> call, Throwable t) {
                Timber.e(t);
            }
        });
    }
}
