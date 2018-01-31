/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fxml.importacaoUsimed;

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
public class UsimedCartaoBBDBServices implements UsimedCartaoBBServices {

    final String inserir = "INSERT INTO cartaobb(descricao,t,data,credito,debito,origem) VALUES(?,?,?,?,?,?)";
    final String atualizar = "UPDATE cartaobb SET descricao = ?,  t = ?, data = ?, credito = ?, debito = ?, origem = ? WHERE id = ?";
    final String buscar_todos = "SELECT id, descricao, t, data, credito, debito, origem FROM cartaobb";
    final String apagar = "DELETE FROM cartaobb WHERE id = ?";

    @Override
    public void salvar(UsimedCartaoBBDados dados) {
        Connection con = ConnectionFactory.getConnection();
        try {
            PreparedStatement stmt = con.prepareStatement(inserir);
            stmt.setString(1, dados.getDescricao());
            stmt.setString(2, dados.getT());
            stmt.setString(3, dados.getData());
            stmt.setString(4, dados.getCredito());
            stmt.setString(5, dados.getDebito());
            stmt.setString(6, dados.getOrigem());
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
    public List<UsimedCartaoBBDados> buscarTodas() {
        List<UsimedCartaoBBDados> dados = new ArrayList<>();
        try {

            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = con.prepareStatement(buscar_todos);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                UsimedCartaoBBDados dado = extraiConta(rs);
                dados.add(dado);
            }
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
    public UsimedCartaoBBDados buscaPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void apagar(int id) {
        Connection con = ConnectionFactory.getConnection();
        try {
            PreparedStatement stmt = con.prepareStatement(apagar);
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
    public void atualizar(UsimedCartaoBBDados dados) {
        Connection con = ConnectionFactory.getConnection();
        try {
            PreparedStatement stmt = con.prepareStatement(atualizar);
            stmt.setString(1, dados.getDescricao());
            stmt.setString(2, dados.getT());
            stmt.setString(3, dados.getData());
            stmt.setString(4, dados.getCredito());
            stmt.setString(5, dados.getDebito());
            stmt.setString(6, dados.getOrigem());
            stmt.setInt(7, dados.getId());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText("Erro");
            alerta.setContentText("Erro ao atualizar a tabela." + ex);
            alerta.setTitle("Erro ao atualizar");
            alerta.show();
        }
    }

    private UsimedCartaoBBDados extraiConta(ResultSet resultadoBusca) throws SQLException {
        UsimedCartaoBBDados dados = new UsimedCartaoBBDados();
        dados.setId(resultadoBusca.getInt(1));
        dados.setDescricao(resultadoBusca.getString(2));
        dados.setT(resultadoBusca.getString(3));
        dados.setData(resultadoBusca.getString(4));
        dados.setCredito(resultadoBusca.getString(5));
        dados.setDebito(resultadoBusca.getString(6));
        dados.setOrigem(resultadoBusca.getString(7));
        return dados;
    }
}
