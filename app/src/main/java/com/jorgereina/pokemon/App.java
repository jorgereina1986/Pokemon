package com.jorgereina.pokemon;

import android.app.Application;

import com.jorgereina.pokemon.injection.components.DaggerNetworkComponent;
import com.jorgereina.pokemon.injection.components.NetworkComponent;
import com.jorgereina.pokemon.injection.modules.AppModule;
import com.jorgereina.pokemon.injection.modules.NetworkModule;

import timber.log.Timber;


public class App extends Application {

    NetworkComponent networkComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new Timber.DebugTree());
        networkComponent = DaggerNetworkComponent
                .builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule())
                .build();

    }

    public NetworkComponent getNetworkComponent() {
        return networkComponent;
    }
}
