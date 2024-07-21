package br.senai.lab365.fshealth.pokedex.dtos;

public class PokemonSummary {

    private Integer numero; // Usar Integer para permitir valores nulos, se necessário
    private String nome;
    private Boolean capturado; // Usar Boolean para permitir valores nulos, se necessário

    // Construtor padrão
    public PokemonSummary() {}

    // Construtor com todos os parâmetros
    public PokemonSummary(Integer numero, String nome, Boolean capturado) {
        this.numero = numero;
        this.nome = nome;
        this.capturado = capturado;
    }

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

    public Boolean getCapturado() {
        return capturado;
    }

    public void setCapturado(Boolean capturado) {
        this.capturado = capturado;
    }

    @Override
    public String toString() {
        return "PokemonSummary{" +
                "numero=" + numero +
                ", nome='" + nome + '\'' +
                ", capturado=" + capturado +
                '}';
    }
}
