package br.senai.lab365.fshealth.pokedex.mappers;

import br.senai.lab365.fshealth.pokedex.dtos.PokemonCapturadoRequest;
import br.senai.lab365.fshealth.pokedex.dtos.PokemonResponse;
import br.senai.lab365.fshealth.pokedex.dtos.PokemonSummary;
import br.senai.lab365.fshealth.pokedex.dtos.PokemonVistoRequest;
import br.senai.lab365.fshealth.pokedex.models.Pokemon;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PokemonMapper {

    // Construtor privado para evitar instâncias
    private PokemonMapper() {}

    /**
     * Mapeia um PokemonVistoRequest para uma entidade Pokemon.
     * @param source O DTO de entrada.
     * @return A entidade Pokemon mapeada.
     */
    public static Pokemon map(PokemonVistoRequest source) {
        if (source == null) return null;

        Pokemon target = new Pokemon();
        target.setNumero(source.getNumero());
        target.setNome(source.getNome());
        target.setImagemUrl(source.getImagemUrl());
        target.setHabitat(source.getHabitat());

        return target;
    }

    /**
     * Mapeia um PokemonCapturadoRequest para uma entidade Pokemon.
     * @param source O DTO de entrada.
     * @return A entidade Pokemon mapeada.
     */
    public static Pokemon map(PokemonCapturadoRequest source) {
        if (source == null) return null;

        Pokemon target = new Pokemon();
        target.setNumero(source.getNumero());
        target.setNome(source.getNome());
        target.setDescricao(source.getDescricao());
        target.setImagemUrl(source.getImagemUrl());
        target.setTipo(source.getTipo());
        target.setCategoria(source.getCategoria());
        target.setHabitat(source.getHabitat());
        target.setAltura(source.getAltura());
        target.setPeso(source.getPeso());
        target.setCapturado(true);

        return target;
    }

    /**
     * Mapeia uma entidade Pokemon para um PokemonResponse.
     * @param source A entidade Pokemon.
     * @return O DTO PokemonResponse mapeado.
     */
    public static PokemonResponse map(Pokemon source) {
        if (source == null) return null;

        PokemonResponse target = new PokemonResponse();
        target.setNumero(source.getNumero());
        target.setNome(source.getNome());
        target.setDescricao(source.getDescricao());
        target.setImagemUrl(source.getImagemUrl());
        target.setTipo(source.getTipo());
        target.setCategoria(source.getCategoria());
        target.setHabitat(source.getHabitat());
        target.setAltura(source.getAltura());
        target.setPeso(source.getPeso());
        target.setCapturado(source.isCapturado());

        return target;
    }

    /**
     * Mapeia uma entidade Pokemon para um PokemonSummary.
     * @param source A entidade Pokemon.
     * @return O DTO PokemonSummary mapeado.
     */
    public static PokemonSummary mapToSummary(Pokemon source) {
        if (source == null) return null;

        PokemonSummary target = new PokemonSummary();
        target.setNumero(source.getNumero());
        target.setNome(source.getNome());
        target.setCapturado(source.isCapturado());

        return target;
    }

    /**
     * Mapeia uma lista de entidades Pokemon para uma lista de PokemonSummary.
     * @param source A lista de entidades Pokemon.
     * @return A lista de DTOs PokemonSummary mapeada.
     */
    public static List<PokemonSummary> mapToSummary(List<Pokemon> source) {
        if (source == null) return Collections.emptyList();

        return source.stream()
                .map(PokemonMapper::mapToSummary)
                .collect(Collectors.toList());
    }
}
