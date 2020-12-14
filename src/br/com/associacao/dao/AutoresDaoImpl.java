/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.associacao.dao;

import br.com.associacao.entidade.Autores;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author Titione
 */
public class AutoresDaoImpl implements Serializable {

    protected Connection conexao;
    protected PreparedStatement preparando;
    protected ResultSet resultSet;

    public void salvar(Autores autores) throws SQLException {
        String sql = "INSERT INTO autores (cdAutores, nmAutor, cdLivro) VALUES(?, ?, ?)";
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparando.setInt(1, autores.getCdAutores());
            preparando.setString(2, autores.getNmAutor());
            preparando.setInt(3, autores.getCdLivro());
            preparando.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao salvar autor " + e.getMessage());
        }
    }

    public void alterar(Autores autores) throws SQLException {
        String sql = "UPDATE autores SET nmAutor = ?, cdLivro = ?";
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando.setString(1, autores.getNmAutor());
            preparando.setInt(2, autores.getCdLivro());
            preparando.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro ao alterar autor " + e.getMessage());
        }
    }

    public void excluir(Integer id) throws SQLException {
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement("DELETE FROM autores WHERE  cdAutores = ?");
            preparando.setInt(1, id);
            preparando.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir " + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conexao, preparando);
        }
    }

    public Autores pesquisarPorId(Integer id) throws SQLException {
        String consulta = "SELECT * FROM autores WHERE cdAutores = ?";
        Autores autores = null;
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(consulta);
            preparando.setInt(1, id);
            resultSet = preparando.executeQuery();
            autores.setCdAutores(resultSet.getInt("cdAutor"));
            autores.setNmAutor(resultSet.getString("nmAutor"));
            autores.setCdLivro(resultSet.getInt("cdLivro"));
            } catch (SQLException e) {
            System.err.println("Erro ao pesquisar por id. Erro =  " + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conexao, preparando, resultSet);
        }
        return autores;
    }

}
