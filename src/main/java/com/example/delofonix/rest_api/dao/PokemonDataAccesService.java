package com.example.delofonix.rest_api.dao;

import com.example.delofonix.database.model.User;
import com.example.delofonix.database.service.UserService;
import com.example.delofonix.rest_api.model.Pokemon;
import com.example.delofonix.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
@Repository("PokemonDao")
public class PokemonDataAccesService implements PokemonDao {

    private static final Logger logger = LoggerFactory.getLogger(PokemonDataAccesService.class);

    private static final String SQL = "SELECT PokemonId, PokedexIndex, PokemonName, NickName, Sex, Weight, Height, PokemonType, CombatPower, HealthPoints FROM Pokemons";

    @Autowired
    JdbcTemplate usersJdbcTemplate;


    public Pokemon findByPokemoId(String pokemonId) {
        if (Utils.isNotEmptyValue(pokemonId)) {
            String sql = SQL + " WHERE PokemonId = '" + pokemonId.trim() + "'";
            return usersJdbcTemplate.queryForObject(sql, new PokemonDataAccesService.PokemonRecordMapper());
        } else {
            return null;
        }
    }
    @Override
    public void insertPokemon(UUID id, Pokemon pokemon) {
        if (logger.isErrorEnabled())
            logger.debug("Adding pokemon: " + pokemon.getPokemonId());
        if (pokemon != null && Utils.isNotEmptyValue(pokemon.getPokemonId())) {
            String sql = "INSERT INTO Pokemons (PokemonId, PokedexIndex, PokemonName, NickName, Sex, Weight, Height, PokemonType, CombatPower, HealthPoints) VALUES (" +
                    "'" + pokemon.getPokemonId().trim() + "', " +
                    (pokemon.getPokedexIndex() != 0 ? "'" + pokemon.getPokedexIndex() + "', " : "NULL, ") +
                    (Utils.isNotEmptyValue(pokemon.getPokemonName()) ? "'" + pokemon.getPokemonName().trim() + "', " : "NULL, ") +
                    (Utils.isNotEmptyValue(pokemon.getNickName()) ? "'" + pokemon.getNickName().trim() + "', " : "NULL, ") +
                    (Utils.isNotEmptyValue(pokemon.getSex()) ? "'" + pokemon.getSex().trim() + "', " : "NULL, ") +
                    (pokemon.getWeight() != 0 ? "'" + pokemon.getWeight() + "', " : "NULL, ") +
                    (pokemon.getHeight() != 0 ? "'" + pokemon.getHeight() + "', " : "NULL, ") +
                    (Utils.isNotEmptyValue(Utils.listToStringConverter(pokemon.getPokemonType())) ? "'" + Utils.listToStringConverter(pokemon.getPokemonType()) + "', " : "NULL, ") +
                    (pokemon.getCombatPower() != 0 ? "'" + pokemon.getCombatPower() + "', " : "NULL, ") +
                    (pokemon.getHealthPoints() != 0 ? "'" + pokemon.getHealthPoints() + "' " : "NULL ") +
                    ")";
            if (logger.isDebugEnabled())
                logger.debug("insertPokemon SQL: " + sql);
            usersJdbcTemplate.update(sql);

        }
    }

    @Override
    public List<Pokemon> sellectAllPokemon() {
        return usersJdbcTemplate.query(SQL, new PokemonDataAccesService.PokemonRecordMapper());
    }

    class PokemonRecordMapper implements RowMapper<Pokemon> {
        @Override
        public Pokemon mapRow(ResultSet resultSet, int i) throws SQLException {
            Pokemon pokemon = new Pokemon(
            Utils.isNotEmptyValue(resultSet.getString("PokemonId"))? resultSet.getString("PokemonId"):null,
                    Utils.isNotEmptyValue(resultSet.getString("PokemonName"))? resultSet.getString("PokemonName"):null
            );

            if(resultSet.getInt("PokedexIndex")!=0)
                pokemon.setPokedexIndex(resultSet.getInt("PokedexIndex"));
            if(Utils.isNotEmptyValue(resultSet.getString("NickName")))
                pokemon.setNickName(resultSet.getString("NickName"));
            if(Utils.isNotEmptyValue(resultSet.getString("Sex")))
                pokemon.setSex(resultSet.getString("Sex"));
            if(resultSet.getFloat("Weight")!=0)
                pokemon.setWeight(resultSet.getFloat("Weight"));
            if(resultSet.getFloat("Height")!=0)
                pokemon.setWeight(resultSet.getFloat("Height"));
            if(Utils.isNotEmptyValue(resultSet.getString("PokemonType")))
                pokemon.setPokemonType(Utils.stringToListConverter(resultSet.getString("PokemonType")));
            if(resultSet.getInt("CombatPower")!=0)
                pokemon.setCombatPower(resultSet.getInt("CombatPower"));
            if(resultSet.getInt("HealthPoints")!=0)
                pokemon.setCombatPower(resultSet.getInt("HealthPoints"));


            return pokemon;
        }
    }
}
