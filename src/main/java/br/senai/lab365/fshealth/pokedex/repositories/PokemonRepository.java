package br.senai.lab365.fshealth.pokedex.repositories;

import br.senai.lab365.fshealth.pokedex.models.Pokemon;
import br.senai.lab365.fshealth.pokedex.enums.TipoEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {

    // Consulta personalizada para encontrar Pokémon por nome
    List<Pokemon> findByNome(String nome);

    // Consulta personalizada para encontrar Pokémon por tipo
    List<Pokemon> findByTipo(TipoEnum tipo);

    // Consulta personalizada para encontrar Pokémon por categoria
    List<Pokemon> findByCategoria(String categoria);
}
