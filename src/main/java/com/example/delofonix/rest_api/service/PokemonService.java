package com.example.delofonix.rest_api.service;

import com.example.delofonix.rest_api.dao.PokemonDao;
import com.example.delofonix.rest_api.model.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonService {

    private final PokemonDao pokemonDao;

    @Autowired
    public PokemonService(@Qualifier("PokemonDao") PokemonDao pokemonDao) {
        this.pokemonDao = pokemonDao;
    }

    public void addPokemon(Pokemon pokemon){
        pokemonDao.insertPokemon(pokemon);
    }

    public List<Pokemon> getAllPokemon(){
        return pokemonDao.sellectAllPokemon();
    }
}
