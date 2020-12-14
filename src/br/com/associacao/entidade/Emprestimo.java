/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.associacao.entidade;

import java.sql.Date;

/**
 *
 * @author Titione
 */
public class Emprestimo {
    
    int cdEmprestimo;
    int cdUsuario;
    int cdBibliotecario;
    int cdLivro;
    Date dtDevolucao;
    Date dtRetirada;

    public Emprestimo() {
    }

    public Emprestimo(int cdEmprestimo, int cdUsuario, int cdBibliotecario, int cdLivro, Date dtDevolucao, Date dtRetirada) {
        this.cdEmprestimo = cdEmprestimo;
        this.cdUsuario = cdUsuario;
        this.cdBibliotecario = cdBibliotecario;
        this.cdLivro = cdLivro;
        this.dtDevolucao = dtDevolucao;
        this.dtRetirada = dtRetirada;
    }

    public int getCdEmprestimo() {
        return cdEmprestimo;
    }

    public void setCdEmprestimo(int cdEmprestimo) {
        this.cdEmprestimo = cdEmprestimo;
    }

    public int getCdUsuario() {
        return cdUsuario;
    }

    public void setCdUsuario(int cdUsuario) {
        this.cdUsuario = cdUsuario;
    }

    public int getCdBibliotecario() {
        return cdBibliotecario;
    }

    public void setCdBibliotecario(int cdBibliotecario) {
        this.cdBibliotecario = cdBibliotecario;
    }

    public int getCdLivro() {
        return cdLivro;
    }

    public void setCdLivro(int cdLivro) {
        this.cdLivro = cdLivro;
    }

    public Date getDtDevolucao() {
        return dtDevolucao;
    }

    public void setDtDevolucao(Date dtDevolucao) {
        this.dtDevolucao = dtDevolucao;
    }

    public Date getDtRetirada() {
        return dtRetirada;
    }

    public void setDtRetirada(Date dtRetirada) {
        this.dtRetirada = dtRetirada;
    }
    
    
    
}
