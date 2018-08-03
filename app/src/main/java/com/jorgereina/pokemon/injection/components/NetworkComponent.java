package com.jorgereina.pokemon.injection.components;

import com.jorgereina.pokemon.ui.MainActivity;
import com.jorgereina.pokemon.injection.modules.AppModule;
import com.jorgereina.pokemon.injection.modules.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface NetworkComponent {
    void inject(MainActivity mainActivity);
}
