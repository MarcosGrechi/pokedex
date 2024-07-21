package br.senai.lab365.fshealth.pokedex.models;

import br.senai.lab365.fshealth.pokedex.enums.TipoEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pokemon")
public class Pokemon {
    @Id
    private Integer numero;

    @Column(nullable = false, unique = true)
    private String nome;

    private String descricao;

    @Column(nullable = false)
    private String imagemUrl;

    @Enumerated(EnumType.STRING)
    private TipoEnum tipo;

    private String categoria;

    @Column(nullable = false)
    private String habitat;

    private Double altura;
    private Double peso;
    private boolean capturado;

    // Construtores
    public Pokemon() {
        // Construtor padrão
    }

    public Pokemon(Integer numero, String nome, String descricao, String imagemUrl, TipoEnum tipo, String categoria, String habitat, Double altura, Double peso, boolean capturado) {
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

    // Métodos toString, equals, hashCode
    @Override
    public String toString() {
        return "Pokemon{" +
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pokemon pokemon = (Pokemon) o;

        return numero != null ? numero.equals(pokemon.numero) : pokemon.numero == null;
    }

    @Override
    public int hashCode() {
        return numero != null ? numero.hashCode() : 0;
    }
}
