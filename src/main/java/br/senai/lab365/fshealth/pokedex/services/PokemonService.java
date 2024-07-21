package br.senai.lab365.fshealth.pokedex.services;

import static br.senai.lab365.fshealth.pokedex.mappers.PokemonMapper.map;
import static br.senai.lab365.fshealth.pokedex.mappers.PokemonMapper.mapToSummary;

import br.senai.lab365.fshealth.pokedex.dtos.PokemonCapturadoRequest;
import br.senai.lab365.fshealth.pokedex.dtos.PokemonResponse;
import br.senai.lab365.fshealth.pokedex.dtos.PokemonSummary;
import br.senai.lab365.fshealth.pokedex.dtos.PokemonVistoRequest;
import br.senai.lab365.fshealth.pokedex.models.Pokemon;
import br.senai.lab365.fshealth.pokedex.repositories.PokemonRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class PokemonService {

    private static final Logger LOGGER = LogManager.getLogger(PokemonService.class);
    private final PokemonRepository repository;

    public PokemonService(PokemonRepository pokemonRepository) {
        this.repository = pokemonRepository;
    }

    public void cadastraVisto(PokemonVistoRequest pokemonVistoRequest) {
        if (repository.existsById(pokemonVistoRequest.getNumero())) {
            throw new DuplicateKeyException(
                    String.format("Já existe um Pokémon com esse número: %d", pokemonVistoRequest.getNumero()));
        }
        repository.save(map(pokemonVistoRequest));
    }

    public void cadastraCapturado(PokemonCapturadoRequest pokemonCapturadoRequest) {
        Pokemon pokemon = repository.findById(pokemonCapturadoRequest.getNumero()).orElse(null);
        if (pokemon != null) {
            if (pokemon.isCapturado()) {
                throw new DuplicateKeyException(
                        String.format("Já existe um Pokémon capturado com esse número: %d", pokemonCapturadoRequest.getNumero()));
            } else {
                // Atualizar o Pokémon visto para capturado
                pokemon.setNome(pokemonCapturadoRequest.getNome());
                pokemon.setDescricao(pokemonCapturadoRequest.getDescricao());
                pokemon.setImagemUrl(pokemonCapturadoRequest.getImagemUrl());
                pokemon.setTipo(pokemonCapturadoRequest.getTipo());
                pokemon.setCategoria(pokemonCapturadoRequest.getCategoria());
                pokemon.setHabitat(pokemonCapturadoRequest.getHabitat());
                pokemon.setAltura(pokemonCapturadoRequest.getAltura());
                pokemon.setPeso(pokemonCapturadoRequest.getPeso());
                pokemon.setCapturado(true);
            }
        } else {
            // Cadastrar um novo Pokémon capturado
            pokemon = map(pokemonCapturadoRequest);
            pokemon.setCapturado(true);
        }
        repository.save(pokemon);
    }

    public void atualizaCapturado(PokemonCapturadoRequest pokemonCapturadoRequest) {
        Pokemon pokemon = repository.findById(pokemonCapturadoRequest.getNumero()).orElseThrow(
                () -> new EntityNotFoundException(
                        String.format("Pokémon com número %d não encontrado", pokemonCapturadoRequest.getNumero())
                )
        );

        // Atualizando as informações do Pokémon
        pokemon.setNome(pokemonCapturadoRequest.getNome());
        pokemon.setDescricao(pokemonCapturadoRequest.getDescricao());
        pokemon.setImagemUrl(pokemonCapturadoRequest.getImagemUrl());
        pokemon.setTipo(pokemonCapturadoRequest.getTipo());
        pokemon.setCategoria(pokemonCapturadoRequest.getCategoria());
        pokemon.setHabitat(pokemonCapturadoRequest.getHabitat());
        pokemon.setAltura(pokemonCapturadoRequest.getAltura());
        pokemon.setPeso(pokemonCapturadoRequest.getPeso());
        pokemon.setCapturado(true); // Garantindo que o Pokémon está marcado como capturado

        repository.save(pokemon);

        LOGGER.info(
                "Pokémon atualizado! Nome: {}, número: {}",
                pokemonCapturadoRequest.getNome(),
                pokemonCapturadoRequest.getNumero());
    }

    public void atualizaVisto(PokemonVistoRequest pokemonVistoRequest) {
        Pokemon pokemon =
                repository
                        .findById(pokemonVistoRequest.getNumero())
                        .orElseThrow(() -> new EntityNotFoundException(
                                String.format("Pokémon com número %d não encontrado", pokemonVistoRequest.getNumero())));

        pokemon.setNome(pokemonVistoRequest.getNome());
        pokemon.setImagemUrl(pokemonVistoRequest.getImagemUrl());
        pokemon.setHabitat(pokemonVistoRequest.getHabitat());

        repository.save(pokemon);
    }

    public void exclui(Integer numero) {
        if (repository.existsById(numero)) {
            repository.deleteById(numero);
        } else {
            throw new EntityNotFoundException(
                    String.format("Pokémon com número %d não encontrado", numero));
        }
    }

    public PokemonResponse busca(Integer numero) {
        Pokemon pokemon = repository.findById(numero).orElseThrow(() -> new EntityNotFoundException(
                String.format("Pokémon com número %d não encontrado", numero)));

        return map(pokemon);
    }

    public List<PokemonSummary> lista() {
        return mapToSummary(repository.findAll());
    }
}
