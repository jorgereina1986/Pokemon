package com.jorgereina.pokemon.injection.modules;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jorgereina.pokemon.App;
import com.jorgereina.pokemon.PokemonApi;
import com.jorgereina.pokemon.R;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

//    @Provides
//    @Singleton
//    Gson provideGson(){
//        GsonBuilder gsonBuilder = new GsonBuilder();
//        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
//        return new GsonBuilder().create();
//    }
//
//    @Provides
//    @Singleton
//    Retrofit provideRetrofit(App app, Gson gson) {
//        return new Retrofit.Builder()
//                .baseUrl(app.getResources().getString(R.string.base_url))
//                .addConverterFactory(GsonConverterFactory.create(gson))
//                .build();
//    }

    @Provides
    @Singleton
    GsonConverterFactory provideGsonConverterFactory() {
        return GsonConverterFactory.create(new GsonBuilder().create());
    }

    @Provides
    @Singleton
    PokemonApi providePokemonApi(App app, GsonConverterFactory gsonConverterFactory) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(app.getResources().getString(R.string.base_url))
                .addConverterFactory(gsonConverterFactory)
                .build();
        return retrofit.create(PokemonApi.class);
    }
}
