package com.dcarras.spring.pokecatalog.controller;

import com.dcarras.spring.pokecatalog.entity.Pokemon;
import com.dcarras.spring.pokecatalog.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/pokemon")
public class PokemonController {


    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService){
        this.pokemonService = pokemonService;
    }

    @GetMapping("/")
    public List<Pokemon> getAllPokemon(){
        return pokemonService.getAllPokemon();
    }

    @PostMapping("/")
    public Pokemon createPokemon(@RequestBody Pokemon pokemon){
        return pokemonService.createPokemon(pokemon);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Pokemon>> getPokemonById(@PathVariable int id) {
        Optional<Pokemon> pokemon = pokemonService.getPokemonById(id);
        return ResponseEntity.ok(pokemon);
    }

    @GetMapping("/type/{primary}")
    public List<Pokemon> getPokemonByPrimaryType(@PathVariable String primary){
        return pokemonService.getAllPokemonByPrimaryType(primary);
    }

    @GetMapping("/type/{primary}/{secondary}")
    public List<Pokemon> getPokemonByPrimaryAndSecondaryType(@PathVariable String primary, @PathVariable String secondary){
        return pokemonService.getAllPokemonByPrimaryAndSecondaryTypes(primary,secondary);
    }

    @GetMapping("/types/{type}")
    public List<Pokemon> getPokemonByType(@PathVariable String type){
        return pokemonService.getAllPokemonByType(type);
    }

}
