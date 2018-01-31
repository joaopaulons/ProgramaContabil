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
public class UsimedPagamentoDBService implements UsimedPagamentoServices {

    final String inserir = "INSERT INTO financeiro_pagamento(num_doc, conta_bordero,data_pagamento,cedente,total_pago,descricao,descontos,acrescimos,total,banco_origem) VALUES(?,?,?,?,?,?,?,?,?,?)";
    final String atualizar = "UPDATE financeiro_pagamento SET num_doc = ?, conta_bordero = ?, data_pagamento = ?, cedente = ?, total_pago = ?, descricao = ?, descontos = ?, acrescimos = ?, total = ?, banco_origem = ? WHERE id = ? ";
    final String buscar = "SELECT id,num_doc, conta_bordero,data_pagamento,cedente,total_pago,descricao,descontos,acrescimos,total,banco_origem FROM financeiro_pagamento WHERE id = ?";
    final String buscar_todos = "SELECT id,num_doc, conta_bordero,data_pagamento,cedente,total_pago,descricao,descontos,acrescimos,total,banco_origem FROM financeiro_pagamento";
    final String apagar = "DELETE FROM financeiro_pagamento WHERE id = ?";

    @Override
    public void salvar(UsimedPagamentoDADOS dados) {
        Connection con = ConnectionFactory.getConnection();
        try {
            PreparedStatement stmt = con.prepareStatement(inserir);
            stmt.setString(1, dados.getNum_doc());
            stmt.setString(2, dados.getConta_bordero());
            stmt.setString(3, dados.getData_pagamento());
            stmt.setString(4, dados.getCedente());
            stmt.setString(5, dados.getTotal_pago());
            stmt.setString(6, dados.getDescricao());
            stmt.setString(7, dados.getDescontos());
            stmt.setString(8, dados.getAcrescimos());
            stmt.setString(9, dados.getTotal());
            stmt.setString(10, dados.getBanco_origem());
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
    public List<UsimedPagamentoDADOS> buscarTodas() {
        List<UsimedPagamentoDADOS> dados = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();
        try {
            PreparedStatement stmt = con.prepareStatement(buscar_todos);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                UsimedPagamentoDADOS dado = extraiConta(rs);
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
    public UsimedPagamentoDADOS buscaPorId(int id) {
        UsimedPagamentoDADOS dados = null;
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
    public void atualizar(UsimedPagamentoDADOS dados) {
        Connection con = ConnectionFactory.getConnection();
        try {
            PreparedStatement stmt = con.prepareStatement(atualizar);
            stmt.setString(1, dados.getNum_doc());
            stmt.setString(2, dados.getConta_bordero());
            stmt.setString(3, dados.getData_pagamento());
            stmt.setString(4, dados.getCedente());
            stmt.setString(5, dados.getTotal_pago());
            stmt.setString(6, dados.getDescricao());
            stmt.setString(7, dados.getDescontos());
            stmt.setString(8, dados.getAcrescimos());
            stmt.setString(9, dados.getTotal());
            stmt.setString(10, dados.getBanco_origem());
            stmt.setInt(11, dados.getId());
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

    private UsimedPagamentoDADOS extraiConta(ResultSet resultadoBusca) throws SQLException {
        UsimedPagamentoDADOS dados = new UsimedPagamentoDADOS();
        dados.setId(resultadoBusca.getInt(1));
        dados.setNum_doc(resultadoBusca.getString(2));
        dados.setConta_bordero(resultadoBusca.getString(3));
        dados.setData_pagamento(resultadoBusca.getString(4));
        dados.setCedente(resultadoBusca.getString(5));
        dados.setTotal_pago(resultadoBusca.getString(6));
        dados.setDescricao(resultadoBusca.getString(7));
        dados.setDescontos(resultadoBusca.getString(8));
        dados.setAcrescimos(resultadoBusca.getString(9));
        dados.setTotal(resultadoBusca.getString(10));
        dados.setBanco_origem(resultadoBusca.getString(11));
        return dados;
    }
}
