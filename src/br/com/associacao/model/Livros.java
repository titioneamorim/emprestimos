/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.associacao.model;

import java.sql.Date;

/**
 *
 * @author Titione
 */
public class Livros {
    
    int cdLivro;
    String titulo;
    String resumo;
    Date dtPublicacao;
    String edicao;
    String nmEditora;
    String cidade;
    String estado;

    public Livros() {
    }

    public Livros(int cdLivro, String titulo, String resumo, Date dtPublicacao, String edicao, String nmEditora, String cidade, String estado) {
        this.cdLivro = cdLivro;
        this.titulo = titulo;
        this.resumo = resumo;
        this.dtPublicacao = dtPublicacao;
        this.edicao = edicao;
        this.nmEditora = nmEditora;
        this.cidade = cidade;
        this.estado = estado;
    }

    public int getCdLivro() {
        return cdLivro;
    }

    public void setCdLivro(int cdLivro) {
        this.cdLivro = cdLivro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public Date getDtPublicacao() {
        return dtPublicacao;
    }

    public void setDtPublicacao(Date dtPublicacao) {
        this.dtPublicacao = dtPublicacao;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public String getNmEditora() {
        return nmEditora;
    }

    public void setNmEditora(String nmEditora) {
        this.nmEditora = nmEditora;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
       
    
}
