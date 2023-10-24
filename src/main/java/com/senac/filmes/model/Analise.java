package com.senac.filmes.model;

/**
 *
 * @author Nicolas
 */
public class Analise {
    private int id;
    private Filme filme;
    private String textoAnalise;
    private double nota;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public String getTextoAnalise() {
        return textoAnalise;
    }

    public void setTextoAnalise(String textoAnalise) {
        this.textoAnalise = textoAnalise;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    
    
}
