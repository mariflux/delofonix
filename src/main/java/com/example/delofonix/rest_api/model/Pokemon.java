package com.example.delofonix.rest_api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Pokemon {

    private final String pokemonId;
    private int pokedexIndex;
    private String pokemonName;
    private String nickName;
    private String sex;
    private float weight;
    private float height;
    private List<String> pokemonType;
    private int combatPower;
    private int healthPoints;


    public Pokemon(@JsonProperty("id") String pokemonId,
                   @JsonProperty("name") String pokemonName) {
        this.pokemonId = pokemonId;
        this.pokemonName = pokemonName;
    }

    public Pokemon(@JsonProperty("id") String pokemonId,
                   @JsonProperty("pokedexIndex") int pokedexIndex,
                   @JsonProperty("name") String pokemonName,
                   @JsonProperty("nickName") String nickName,
                   @JsonProperty("sex") String sex,
                   @JsonProperty("weight") float weight,
                   @JsonProperty("height") float height,
                   @JsonProperty("pokemonType") List<String> pokemonType,
                   @JsonProperty("combatPower") int combatPower,
                   @JsonProperty("healthPoints") int healthPoints) {
        this.pokemonId = pokemonId;
        this.pokedexIndex = pokedexIndex;
        this.pokemonName = pokemonName;
        this.nickName = nickName;
        this.sex = sex;
        this.weight = weight;
        this.height = height;
        this.pokemonType = pokemonType;
        this.combatPower = combatPower;
        this.healthPoints = healthPoints;
    }


    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    public String getPokemonId() {
        return pokemonId;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public int getPokedexIndex() {
        return pokedexIndex;
    }

    public void setPokedexIndex(int pokedexIndex) {
        this.pokedexIndex = pokedexIndex;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public List<String> getPokemonType() {
        return pokemonType;
    }

    public void setPokemonType(List<String> pokemonType) {
        this.pokemonType = pokemonType;
    }

    public int getCombatPower() {
        return combatPower;
    }

    public void setCombatPower(int combatPower) {
        this.combatPower = combatPower;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }


}
