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
public class UsimedConvenioDBService implements UsimedConvenioServices {

    final String inserir = "INSERT INTO financeiro_convenio(emissao, num_documento, nome_pagador, valor, insc_pagador, valor_pago, valor_dif_cobrado, data_credito) VALUES(?,?,?,?,?,?,?,?)";
    final String atualizar = "UPDATE financeiro_convenio SET emissao = ?, num_documento = ?, nome_pagador = ?, valor = ?, insc_pagador = ?, valor_pago = ?, valor_dif_cobrado = ?, data_credito = ? WHERE id = ?";
    final String buscar_todos = "SELECT id,emissao, num_documento, nome_pagador, valor, insc_pagador, valor_pago, valor_dif_cobrado, data_credito FROM financeiro_convenio";
    final String apagar = "DELETE FROM financeiro_pagamento WHERE id = ?";

    @Override
    public void salvar(UsimedConvenioDADOS dados) {
        Connection con = ConnectionFactory.getConnection();
        try {
            PreparedStatement stmt = con.prepareStatement(inserir);
            stmt.setString(1, dados.getEmissao());
            stmt.setString(2, dados.getNum_documento());
            stmt.setString(3, dados.getNome_pagador());
            stmt.setString(4, dados.getValor());
            stmt.setString(5, dados.getInsc_pagador());
            stmt.setString(6, dados.getValor_pago());
            stmt.setString(7, dados.getValor_dif_cobrado());
            stmt.setString(8, dados.getData_credito());
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
    public List<UsimedConvenioDADOS> buscarTodas() {
        List<UsimedConvenioDADOS> dados = new ArrayList<>();

        Connection con = ConnectionFactory.getConnection();
        try {
            PreparedStatement stmt = con.prepareStatement(buscar_todos);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                UsimedConvenioDADOS dado = extraiConta(rs);
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
    public UsimedConvenioDADOS buscaPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public void atualizar(UsimedConvenioDADOS dados) {
        Connection con = ConnectionFactory.getConnection();
        try {
            PreparedStatement stmt = con.prepareStatement(atualizar);
            stmt.setString(1, dados.getEmissao());
            stmt.setString(2, dados.getNum_documento());
            stmt.setString(3, dados.getNome_pagador());
            stmt.setString(4, dados.getValor());
            stmt.setString(5, dados.getInsc_pagador());
            stmt.setString(6, dados.getValor_pago());
            stmt.setString(7, dados.getValor_dif_cobrado());
            stmt.setString(8, dados.getData_credito());
            stmt.setInt(9, dados.getId());
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

    private UsimedConvenioDADOS extraiConta(ResultSet resultadoBusca) throws SQLException {
        UsimedConvenioDADOS dados = new UsimedConvenioDADOS();
        dados.setId(resultadoBusca.getInt(1));
        dados.setEmissao(resultadoBusca.getString(2));
        dados.setNum_documento(resultadoBusca.getString(3));
        dados.setNome_pagador(resultadoBusca.getString(4));
        dados.setValor(resultadoBusca.getString(5));
        dados.setInsc_pagador(resultadoBusca.getString(6));
        dados.setValor_pago(resultadoBusca.getString(7));
        dados.setValor_dif_cobrado(resultadoBusca.getString(8));
        dados.setData_credito(resultadoBusca.getString(9));
        return dados;
    }
}
