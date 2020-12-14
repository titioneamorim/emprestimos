/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.associacao.entidade;

/**
 *
 * @author Titione
 */
public class Autores {
    
    int cdAutores;
    String nmAutor;
    int cdLivro;

    public Autores() {
    }

    public Autores(int cdAutores, String nmAutor, int cdLivro) {
        this.cdAutores = cdAutores;
        this.nmAutor = nmAutor;
        this.cdLivro = cdLivro;
    }

    public int getCdAutores() {
        return cdAutores;
    }

    public void setCdAutores(int cdAutores) {
        this.cdAutores = cdAutores;
    }

    public String getNmAutor() {
        return nmAutor;
    }

    public void setNmAutor(String nmAutor) {
        this.nmAutor = nmAutor;
    }

    public int getCdLivro() {
        return cdLivro;
    }

    public void setCdLivro(int cdLivro) {
        this.cdLivro = cdLivro;
    }
    
    
    
}
