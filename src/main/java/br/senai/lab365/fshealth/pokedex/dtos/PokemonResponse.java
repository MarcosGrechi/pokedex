package br.senai.lab365.fshealth.pokedex.dtos;

import br.senai.lab365.fshealth.pokedex.enums.TipoEnum;

public class PokemonResponse {

    private Integer numero;
    private String nome;
    private String descricao;
    private String imagemUrl;
    private TipoEnum tipo;
    private String categoria;
    private String habitat;
    private Double altura;
    private Double peso;
    private boolean capturado;

    // Construtor padrão
    public PokemonResponse() {}

    // Construtor com todos os parâmetros
    public PokemonResponse(Integer numero, String nome, String descricao, String imagemUrl, TipoEnum tipo, String categoria, String habitat, Double altura, Double peso, boolean capturado) {
        this.numero = numero;
        this.nome = nome;
        this.descricao = descricao;
        this.imagemUrl = imagemUrl;
        this.tipo = tipo;
        this.categoria = categoria;
        this.habitat = habitat;
        this.altura = altura;
        this.peso = peso;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }

    public TipoEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoEnum tipo) {
        this.tipo = tipo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public boolean isCapturado() {
        return capturado;
    }

    public void setCapturado(boolean capturado) {
        this.capturado = capturado;
    }

    @Override
    public String toString() {
        return "PokemonResponse{" +
                "numero=" + numero +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", imagemUrl='" + imagemUrl + '\'' +
                ", tipo=" + tipo +
                ", categoria='" + categoria + '\'' +
                ", habitat='" + habitat + '\'' +
                ", altura=" + altura +
                ", peso=" + peso +
                ", capturado=" + capturado +
                '}';
    }
}
