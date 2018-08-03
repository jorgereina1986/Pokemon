package com.jorgereina.pokemon.injection.modules;

import com.jorgereina.pokemon.App;
import com.jorgereina.pokemon.PokemonApi;
import com.jorgereina.pokemon.R;
import com.jorgereina.pokemon.data.model.DataRepository;
import com.jorgereina.pokemon.data.model.PokemonEntries;
import com.jorgereina.pokemon.data.model.PokemonSpecies;
import com.jorgereina.pokemon.ui.PokemonAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    DataRepository providesDataRepo(PokemonSpecies pokemonSpecies) {
        return new DataRepository(providePokemonEntries(pokemonSpecies));
    }

    @Provides
    @Singleton
    PokemonSpecies providesPokemonSpecies() {
        return new PokemonSpecies();
    }

    @Provides
    @Singleton
    List<PokemonEntries> providePokemonEntries(PokemonSpecies pokemonSpecies) {
        List<PokemonEntries> pokemonEntries = new ArrayList<>();
        return pokemonEntries;
    }

    @Provides
    @Singleton
    PokemonAdapter providePokemonAdapter() {
        return new PokemonAdapter();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(App app) {
        return new Retrofit.Builder()
                .baseUrl(app.getResources().getString(R.string.base_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    PokemonApi providePokemonApi(Retrofit retrofit) {
        return retrofit.create(PokemonApi.class);
    }
}
