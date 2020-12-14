/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.associacao.dao;

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
public class LivrosDaoImpl implements Serializable {

    protected Connection conexao;
    protected PreparedStatement preparando;
    protected ResultSet resultSet;

    public void salvar(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuarios (cdUsuario, Nome, Login, Senha, "
                + "Logradouro, Cidade, Estado, CEP) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparando.setInt(1, usuario.getCdusuario());
            preparando.setString(2, usuario.getNome());
            preparando.setString(3, usuario.getLogin());
            preparando.setString(4, usuario.getSenha());
            preparando.setString(5, usuario.getLogradouro());
            preparando.setString(6, usuario.getCidade());
            preparando.setString(7, usuario.getEstado());
            preparando.setString(8, usuario.getCep());
            preparando.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao salvar Usuario " + e.getMessage());
        }
    }

    public void alterar(Usuario usuario) throws SQLException {
        String sql = "UPDATE Usuarios SET Nome = ?, Login = ?, Senha = ?,"
                + "Logradouro = ?, Cidade = ?, Estado= ?, CEP = ?";
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando.setString(1, usuario.getNome());
            preparando.setString(2, usuario.getLogin());
            preparando.setString(3, usuario.getSenha());
            preparando.setString(4, usuario.getLogradouro());
            preparando.setString(5, usuario.getCidade());
            preparando.setString(6, usuario.getEstado());
            preparando.setString(7, usuario.getCep());
            preparando.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro ao alterar Usuario " + e.getMessage());
        }
    }

    public void excluir(Integer id) throws SQLException {
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement("DELETE FROM Usuarios WHERE  cdUsuario = ?");
            preparando.setInt(1, id);
            preparando.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir " + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conexao, preparando);
        }
    }

    public Usuario pesquisarPorId(Integer id) throws SQLException {
        String consulta = "SELECT * FROM Usuarios WHERE cdUsuario = ?";
        Usuario usuario = null;
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(consulta);
            preparando.setInt(1, id);
            resultSet = preparando.executeQuery();
            usuario.setNome(resultSet.getString("Nome"));
            usuario.setLogin(resultSet.getString("Nogin"));
            usuario.setSenha(resultSet.getString("Senha"));
            usuario.setLogradouro(resultSet.getString("Logradouro"));
            usuario.setCidade(resultSet.getString("Cidade"));
            usuario.setEstado(resultSet.getString("Estado"));
            usuario.setCep(resultSet.getString("CEP"));
        } catch (SQLException e) {
            System.err.println("Erro ao pesquisar por id. Erro =  " + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conexao, preparando, resultSet);
        }
        return usuario;
    }

}
