package com.dcarras.spring.pokecatalog.service;

import com.dcarras.spring.pokecatalog.entity.Pokemon;
import com.dcarras.spring.pokecatalog.repository.PokemonRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PokemonService {
    private final PokemonRepository pokemonRepository;

    public PokemonService(PokemonRepository pokemonRepository){
        this.pokemonRepository = pokemonRepository;
    }

    public List<Pokemon> getAllPokemon(){
        return (List<Pokemon>) pokemonRepository.findAll();
    }

    public Optional<Pokemon> getPokemonById(int pokemonId){
        return pokemonRepository.findById(pokemonId);
    }

    public List<Pokemon> getAllPokemonByPrimaryType(String primary) {
        List<Pokemon> allPokemon = (List<Pokemon>) pokemonRepository.findAll();
        List<Pokemon> typePokemon = new ArrayList<Pokemon>();
        allPokemon.forEach(
                (pokemon) -> {
                    if (pokemon.getPrimary().equals(primary)) {
                        typePokemon.add(pokemon);
                    }
                });
        return typePokemon;
    }

    public List<Pokemon> getAllPokemonByPrimaryAndSecondaryTypes(String primary, String secondary) {
        List<Pokemon> allPokemon = (List<Pokemon>) pokemonRepository.findAll();
        List<Pokemon> typePokemon = new ArrayList<Pokemon>();
        allPokemon.forEach(
                (pokemon) -> {
                    if (pokemon.getPrimary().equals(primary) && pokemon.getSecondary().equals(secondary)) {
                        typePokemon.add(pokemon);
                    }
                });
        return typePokemon;
    }

    public List<Pokemon> getAllPokemonByType(String type) {
        List<Pokemon> allPokemon = (List<Pokemon>) pokemonRepository.findAll();
        List<Pokemon> typePokemon = new ArrayList<Pokemon>();
        allPokemon.forEach(
                (pokemon) -> {
                    if (pokemon.getPrimary().equals(type) || pokemon.getSecondary().equals(type)) {
                        typePokemon.add(pokemon);
                    }
                });
        return typePokemon;
    }

    public Pokemon createPokemon(Pokemon pokemon){
        return pokemonRepository.save(pokemon);
    }
}


