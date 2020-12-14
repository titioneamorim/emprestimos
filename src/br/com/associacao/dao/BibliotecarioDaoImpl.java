/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.associacao.dao;

import br.com.associacao.entidade.Bibliotecario;
import br.com.associacao.entidade.Usuario;
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
public class BibliotecarioDaoImpl implements Serializable {

    protected Connection conexao;
    protected PreparedStatement preparando;
    protected ResultSet resultSet;

    public void salvar(Bibliotecario bibliotecario) throws SQLException {
        String sql = "INSERT INTO bibliotecario (cdBibliotecario, Login, Senha, Nome, "
                + "Logradouro, Cidade, Estado, CEP) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparando.setInt(1, bibliotecario.getCdBibliotecario());
            preparando.setString(2, bibliotecario.getNome());
            preparando.setString(3, bibliotecario.getLogin());
            preparando.setString(4, bibliotecario.getSenha());
            preparando.setString(5, bibliotecario.getLogradouro());
            preparando.setString(6, bibliotecario.getCidade());
            preparando.setString(7, bibliotecario.getEstado());
            preparando.setString(8, bibliotecario.getCep());
            preparando.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao salvar bibliotecario " + e.getMessage());
        }
    }

    public void alterar(Bibliotecario bibliotecario)throws SQLException {
        String sql = "UPDATE bibliotecario SET Nome = ?, Login = ?, Senha = ?,"
                + "Logradouro = ?, Cidade = ?, Estado= ?, CEP = ?";
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando.setString(1, bibliotecario.getNome());
            preparando.setString(2, bibliotecario.getLogin());
            preparando.setString(3, bibliotecario.getSenha());
            preparando.setString(4, bibliotecario.getLogradouro());
            preparando.setString(5, bibliotecario.getCidade());
            preparando.setString(6, bibliotecario.getEstado());
            preparando.setString(7, bibliotecario.getCep());
            preparando.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro ao alterar bibliotecario " + e.getMessage());
        }
    }

    public void excluir(Integer id) throws SQLException {
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement("DELETE FROM bibliotecario WHERE  cdBibliotecario = ?");
            preparando.setInt(1, id);
            preparando.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir " + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conexao, preparando);
        }
    }

    public Bibliotecario pesquisarPorId(Integer id) throws SQLException {
        String consulta = "SELECT * FROM bibliotecario WHERE cdBibliotecario = ?";
        Bibliotecario bibliotecario = null;
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(consulta);
            preparando.setInt(1, id);
            resultSet = preparando.executeQuery();
            bibliotecario.setNome(resultSet.getString("Nome"));
            bibliotecario.setLogin(resultSet.getString("Login"));
            bibliotecario.setSenha(resultSet.getString("Senha"));
            bibliotecario.setLogradouro(resultSet.getString("Logradouro"));
            bibliotecario.setCidade(resultSet.getString("Cidade"));
            bibliotecario.setEstado(resultSet.getString("Estado"));
            bibliotecario.setCep(resultSet.getString("CEP"));
        } catch (SQLException e) {
            System.err.println("Erro ao pesquisar por id. Erro =  " + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conexao, preparando, resultSet);
        }
        return bibliotecario;
    }

}
