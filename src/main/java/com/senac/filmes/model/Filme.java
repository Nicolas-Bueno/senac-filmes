package com.senac.filmes.model;

/**
 *
 * @author Nicolas
 */
public class Filme {
    
    private int id;
    private String nome;
    private String sinopse;
    private String genero;
    private int anoLancamento;

    public Filme() {
    }
    
    public Filme(int id, String nome, String sinopse, String genero, int anoLancamento) {
        this.id = id;
        this.nome = nome;
        this.sinopse = sinopse;
        this.genero = genero;
        this.anoLancamento = anoLancamento;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
    
    
    
}
