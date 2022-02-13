package com.dcarras.spring.pokecatalog.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pokemon")
@Getter @Setter
public class Pokemon {
    @Id
    @Column(name = "pokemon_id")
    private int pokemonId;

    @Column(name = "pokemon_name")
    private String pokemonName;

    @Column(name = "primary_type")
    private String primary;

    @Column(name = "secondary_type")
    private String secondary;
}
