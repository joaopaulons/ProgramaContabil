/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alfacapa.controllers;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;

/**
 *
 * @author joao.santos
 */
public class CFOPDBService implements CFOPServices {

    final String inserir = "INSERT INTO cfop_entrada(cfopSAIDA, cfopENTRADA) VALUES(?,?)";
    final String atualizar = "UPDATE cfop_entrada SET cfopSAIDA = ?, cfopENTRADA = ? WHERE id = ?";
    final String buscar = "SELECT id, cfopSAIDA, cfopENTRADA FROM cfop_entrada WHERE id = ?";
    final String buscar_todos = "SELECT id, cfopSAIDA, cfopENTRADA FROM cfop_entrada";
    final String apagar = "DELETE FROM cfop_entrada WHERE id = ?";

    @Override
    public void salvar(CFOPDados dados) {
        Connection con = ConnectionFactory.getConnection();
        try {
            PreparedStatement stmt = con.prepareStatement(inserir);
            stmt.setString(1, dados.getCfop_saida());
            stmt.setString(2, dados.getCfop_entrada());
            stmt.executeUpdate();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText("Erro");
            alerta.setContentText("Erro ao salvar os dados." + ex);
            alerta.setTitle("Erro ao salvar");
            alerta.show();
        }
    }

    @Override
    public List<CFOPDados> buscarTodas() {
        List<CFOPDados> dados = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();
        try {
            PreparedStatement stmt = con.prepareStatement(buscar_todos);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                CFOPDados dado = extraiConta(rs);
                dados.add(dado);
            }
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText("Erro");
            alerta.setContentText("Erro ao buscar todos os itens." + ex);
            alerta.setTitle("Erro ao buscar");
            alerta.show();
        }
        return dados;
    }

    @Override
    public CFOPDados buscaPorId(int id) {
        CFOPDados dados = null;
        Connection con = ConnectionFactory.getConnection();
        try {
            PreparedStatement stmt = con.prepareStatement(buscar);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            dados = extraiConta(rs);
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText("Erro");
            alerta.setContentText("Erro ao buscar o item." + ex);
            alerta.setTitle("Erro ao buscar");
            alerta.show();
        }
        return dados;
    }

    @Override
    public void apagar(int id) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        try {
            stmt = con.prepareStatement(apagar);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText("Erro");
            alerta.setContentText("Erro ao apagar o item." + ex);
            alerta.setTitle("Erro ao apagar");
            alerta.show();
        }
    }

    @Override
    public void atualizar(CFOPDados dados) {
        Connection con = ConnectionFactory.getConnection();
        try {
            PreparedStatement stmt = con.prepareStatement(atualizar);
            stmt.setString(1, dados.getCfop_saida());
            stmt.setString(2, dados.getCfop_entrada());
            stmt.setInt(3, dados.getId());
            stmt.executeUpdate();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText("Erro");
            alerta.setContentText("Erro ao atualizar a tabela." + ex);
            alerta.setTitle("Erro ao atualizar");
            alerta.show();
        }
    }

    private CFOPDados extraiConta(ResultSet resultadoBusca) throws SQLException {
        CFOPDados dados = new CFOPDados();
        dados.setId(resultadoBusca.getInt(1));
        dados.setCfop_saida(resultadoBusca.getString(2));
        dados.setCfop_entrada(resultadoBusca.getString(3));
        return dados;
    }
}
