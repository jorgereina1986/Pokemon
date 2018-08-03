package com.jorgereina.pokemon.data.model;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class DataRepository {

    public List<PokemonEntries> pokemonEntriesList = new ArrayList<>();

    @Inject
    public DataRepository(List<PokemonEntries> pokemonEntriesList) {
        this.pokemonEntriesList = pokemonEntriesList;
    }

    public List<PokemonEntries> getPokemonEntriesList() {
        return pokemonEntriesList;
    }

    public void setPokemonEntriesList(List<PokemonEntries> pokemonEntriesList) {
        this.pokemonEntriesList = pokemonEntriesList;
    }

    public PokemonEntries getData (int position) {
        return pokemonEntriesList.get(position);
    }
}
