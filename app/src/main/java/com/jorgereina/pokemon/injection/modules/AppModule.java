package com.jorgereina.pokemon.injection.modules;

import com.jorgereina.pokemon.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Provides
    @Singleton
    App provideApp() {
        return app;
    }
}
