/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fxml.conciliacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;

/**
 *
 * @author joao.santos
 */
public class DadosDBServiceRec implements DadosServiceRec {

    final String Inserir = "INSERT INTO recebimento_txt(data,numero_documento,conta_debito,conta_credito,cnpj,valor,historico) VALUES(?,?,?,?,?,?,?)";
    final String Atualizar = "UPDATE recebimento_txt SET data = ?, numero_documento = ?, conta_debito = ?, conta_credito = ?, cnpj = ?, valor = ?, historico = ? WHERE id = ?";
    final String Buscar = "SELECT id,data,numero_documento,conta_debito, conta_credito,cnpj,valor,historico FROM recebimento_txt WHERE data = ? ";
    final String Buscar_Todos = "SELECT id,data,numero_documento,conta_debito, conta_credito,cnpj,valor,historico FROM recebimento_txt";
    final String Apagar = "DELETE FROM recebimento_txt WHERE id = ? ";

    
    private DadosRec extraiDadosRec(ResultSet rs) throws SQLException, ParseException {
        DadosRec dados = new DadosRec();
        dados.setId_rec(rs.getInt(1));
        dados.setData_rec(rs.getString(2));
        dados.setNumero_documento_rec(rs.getString(3));
        dados.setConta_debito_rec(rs.getString(4));
        dados.setConta_credito_rec(rs.getString(5));
        dados.setCnpj_rec(rs.getString(6));
        dados.setValor_rec(rs.getString(7));
        dados.setHistorico_rec(rs.getString(8));        
        return dados;
    }

    @Override
    public void salvarRec(DadosRec dados) {
        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement salvar = con.prepareStatement((Inserir));
            salvar.setString(1, dados.getData_rec());
            salvar.setString(2, dados.getNumero_documento_rec());
            salvar.setString(3, dados.getConta_debito_rec());
            salvar.setString(4, dados.getConta_credito_rec());
            salvar.setString(5, dados.getCnpj_rec());
            salvar.setString(6, dados.getValor_rec());
            salvar.setString(7, dados.getHistorico_rec());
            salvar.executeUpdate();
            salvar.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText("Erro");
            alerta.setContentText("Erro ao salvar a Conta." + e);
            alerta.setTitle("Erro ao salvar");
            alerta.show();            
        }
    }

    @Override
    public List<DadosRec> buscarTodasRec() {
        List<DadosRec> dados = new ArrayList<>();
        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = con.prepareStatement(Buscar_Todos);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                DadosRec dado = extraiDadosRec(rs);
                dados.add(dado);
            }
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText("Erro");
            alerta.setContentText("Erro ao buscar todos os itens." + e);
            alerta.setTitle("Erro ao buscar");
            alerta.show();            
        }
        return dados;
    }

    @Override
    public DadosRec buscarPorDataRec(String data) {
        DadosRec dado = null;
        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = con.prepareStatement(Buscar);
            stmt.setString(1, data);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            dado = extraiDadosRec(rs);
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText("Erro");
            alerta.setContentText("Erro ao buscar o item." + e);
            alerta.setTitle("Erro ao buscar");
            alerta.show();            
        }
        return dado;
    }

    @Override
    public void apagarRec(int id) {
        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = con.prepareStatement(Apagar);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText("Erro");
            alerta.setContentText("Erro ao apagar o item." + e);
            alerta.setTitle("Erro ao apagar");
            alerta.show();            
        }
    }

    

    @Override
    public void atualizarRec(DadosRec dados) {
        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = con.prepareStatement(Atualizar);
            stmt.setString(1, dados.getData_rec());
            stmt.setString(2, dados.getNumero_documento_rec());
            stmt.setString(3, dados.getConta_debito_rec());
            stmt.setString(4, dados.getConta_credito_rec());
            stmt.setString(5, dados.getCnpj_rec());
            stmt.setString(6, dados.getValor_rec());
            stmt.setString(7, dados.getHistorico_rec());
            stmt.setInt(8, dados.getId_rec());
            stmt.executeUpdate();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText("Erro");
            alerta.setContentText("Erro ao atualizar a tabela." + e);
            alerta.setTitle("Erro ao atualizar");
            alerta.show();            
        }
    }
}
