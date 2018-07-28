package com.jorgereina.pokemon.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PokemonResponse {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("pokemon_entries")
    @Expose
    private List<PokemonEntries> pokemonEntriesEntries = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PokemonEntries> getPokemonEntriesEntries() {
        return pokemonEntriesEntries;
    }

    public void setPokemonEntriesEntries(List<PokemonEntries> pokemonEntriesEntries) {
        this.pokemonEntriesEntries = pokemonEntriesEntries;
    }
}
