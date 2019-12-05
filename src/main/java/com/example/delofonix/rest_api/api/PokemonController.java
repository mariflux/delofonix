package com.example.delofonix.rest_api.api;

import com.example.delofonix.rest_api.model.Pokemon;
import com.example.delofonix.rest_api.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pokemon")

public class PokemonController {


    private final  PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService) {

        this.pokemonService = pokemonService;
    }

    @GetMapping("")
    public String index() {
        return "Welcome to pokemon RESTFull API!";
    }

    @PostMapping("/addPokemon")
    public void addPokemon(@RequestBody Pokemon pokemon){
        pokemonService.addPokemon(pokemon);
    }

    @GetMapping("/getAllPokemon")
    public List<Pokemon> getAllPokemon(){
        return pokemonService.getAllPokemon();
    }
}
