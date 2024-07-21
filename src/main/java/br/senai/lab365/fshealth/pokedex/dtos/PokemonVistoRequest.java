package br.senai.lab365.fshealth.pokedex.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PokemonVistoRequest {

    @NotNull(message = "Número é obrigatório.")
    private Integer numero; // Usar Integer em vez de int para permitir valores nulos

    @NotBlank(message = "Nome é obrigatório.")
    private String nome;

    @NotBlank(message = "URL da imagem é obrigatória.")
    private String imagemUrl;

    @NotBlank(message = "Habitat é obrigatório.")
    private String habitat;

    // Getters e Setters

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    @Override
    public String toString() {
        return "PokemonVistoRequest{" +
                "numero=" + numero +
                ", nome='" + nome + '\'' +
                ", imagemUrl='" + imagemUrl + '\'' +
                ", habitat='" + habitat + '\'' +
                '}';
    }
}
