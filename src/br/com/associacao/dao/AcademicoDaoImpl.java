/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.associacao.dao;

import br.com.associacao.model.Academico;
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
public class AcademicoDaoImpl implements Serializable {

    protected Connection conexao;
    protected PreparedStatement preparando;
    protected ResultSet resultSet;

    public void salvar(Academico academico) throws SQLException {
        String sql = "INSERT INTO academico (cdMatricula, nmAcademico, CPF, dsEmail, "
                + "dsEndereco, idSexo, idade) VALUES(?, ?, ?, ?, ?, ?, ?)";
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparando.setInt(1, academico.getCdMatricula());
            preparando.setString(2, academico.getNmAcademico());
            preparando.setInt(3, academico.getCpf());
            preparando.setString(4, academico.getDsEmail());
            preparando.setString(5, academico.getDsEndereco());
            preparando.setInt(6, academico.getIdSexo());
            preparando.setInt(7, academico.getIdade());
            preparando.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao salvar academico " + e.getMessage());
        }
    }

    public void alterar(Academico academico) throws SQLException {
        String sql = "UPDATE academico SET nmAcademico = ?, CPF = ?, dsEmail = ?,"
                + "dsEndereco = ?, idSexo = ?, idade= ?";
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando.setString(1, academico.getNmAcademico());
            preparando.setInt(2, academico.getCpf());
            preparando.setString(3, academico.getDsEmail());
            preparando.setString(4, academico.getDsEndereco());
            preparando.setInt(5, academico.getIdSexo());
            preparando.setInt(6, academico.getIdade());
            preparando.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro ao alterar Academico " + e.getMessage());
        }
    }

    public void excluir(Integer id) throws SQLException {
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement("DELETE FROM academico WHERE  cdMatricula = ?");
            preparando.setInt(1, id);
            preparando.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir " + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conexao, preparando);
        }
    }

    public Academico pesquisarPorId(Integer id) throws SQLException {
        String consulta = "SELECT * FROM academico WHERE cdMatricula = ?";
        Academico academico = null;
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(consulta);
            preparando.setInt(1, id);
            resultSet = preparando.executeQuery();
            academico.setNmAcademico(resultSet.getString("nmAcademico"));
            academico.setCpf(resultSet.getInt("CPF"));
            academico.setDsEmail(resultSet.getString("dsEmail"));
            academico.setDsEndereco(resultSet.getString("dsEndereco"));
            academico.setIdSexo(resultSet.getInt("idSexo"));
        } catch (SQLException e) {
            System.err.println("Erro ao pesquisar por id. Erro =  " + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conexao, preparando, resultSet);
        }
        return academico;
    }

}
