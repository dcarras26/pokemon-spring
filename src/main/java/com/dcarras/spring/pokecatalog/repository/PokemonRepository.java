package com.dcarras.spring.pokecatalog.repository;

import com.dcarras.spring.pokecatalog.entity.Pokemon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokemonRepository extends CrudRepository<Pokemon, Integer> {
}
