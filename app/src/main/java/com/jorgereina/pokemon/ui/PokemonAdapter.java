package com.jorgereina.pokemon.ui;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.jorgereina.pokemon.R;
import com.jorgereina.pokemon.data.model.PokemonEntries;
import com.jorgereina.pokemon.databinding.PokemonRowBinding;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder> {

    private List<PokemonEntries> pokemonEntriesList;

    @Inject
    public PokemonAdapter() {
        pokemonEntriesList = new ArrayList<>();

    }

//    @Inject
//    public PokemonAdapter() {
//    }

    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        PokemonRowBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.pokemon_row, parent, false);
        return new PokemonViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
        PokemonEntries pokemonEntries = pokemonEntriesList.get(position);
//        holder.binding.setPokemon(pokemonEntries.getPokemonSpecies().getName());
    }

    @Override
    public int getItemCount() {
        return pokemonEntriesList.size();
    }

    public class PokemonViewHolder extends RecyclerView.ViewHolder {
        private PokemonRowBinding binding;

        public PokemonViewHolder(PokemonRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
//
//        public void bind(PokemonSpecies pokemonSpecies) {
//            binding.executePendingBindings();
//        }
    }
}
