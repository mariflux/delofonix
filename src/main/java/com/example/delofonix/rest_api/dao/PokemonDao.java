package com.example.delofonix.rest_api.dao;

import com.example.delofonix.rest_api.model.Pokemon;

import java.util.List;
import java.util.UUID;

public interface PokemonDao {

    void insertPokemon(UUID id, Pokemon pokemon);

    default void insertPokemon(Pokemon pokemon){
        UUID id = UUID.randomUUID();
        insertPokemon(id,pokemon);
    }
    List<Pokemon> sellectAllPokemon();

}
