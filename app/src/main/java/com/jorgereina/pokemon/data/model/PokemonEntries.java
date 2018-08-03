package com.jorgereina.pokemon.data.model;

import com.google.gson.annotations.SerializedName;

import javax.inject.Inject;

public class PokemonEntries {

    @SerializedName("pokemon_species")
    private PokemonSpecies pokemonSpecies;

    @Inject
    public PokemonEntries(PokemonSpecies pokemonSpecies) {
        this.pokemonSpecies = pokemonSpecies;
    }

    public PokemonSpecies getPokemonSpecies() {
        return pokemonSpecies;
    }

    public void setPokemonSpecies(PokemonSpecies pokemonSpecies) {
        this.pokemonSpecies = pokemonSpecies;
    }
}
