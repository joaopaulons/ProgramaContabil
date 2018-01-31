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
public class DadosDBService implements DadosService {

    final String Inserir = "INSERT INTO pagamento_txt(data,numero_documento,conta_debito,conta_credito,cnpj,valor,historico) VALUES(?,?,?,?,?,?,?)";
    final String Atualizar = "UPDATE pagamento_txt SET data = ?, numero_documento = ?, conta_debito = ?, conta_credito = ?, cnpj = ?, valor = ?, historico = ? WHERE id = ?";
    final String Buscar = "SELECT id,data,numero_documento,conta_debito, conta_credito,cnpj,valor,historico FROM pagamento_txt WHERE data = ? ";
    final String Buscar_Todos = "SELECT id,data,numero_documento,conta_debito, conta_credito,cnpj,valor,historico FROM pagamento_txt";
    final String Apagar = "DELETE FROM pagamento_txt WHERE id = ? ";

    public void salvar(Dados dados) {
        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement salvar = con.prepareStatement((Inserir));
            salvar.setString(1, dados.getData());
            salvar.setString(2, dados.getNumero_documento());
            salvar.setString(3, dados.getConta_debito());
            salvar.setString(4, dados.getConta_credito());
            salvar.setString(5, dados.getCnpj());
            salvar.setString(6, dados.getValor());
            salvar.setString(7, dados.getHistorico());
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
    public List<Dados> buscarTodas() {
        List<Dados> dados = new ArrayList<>();
        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = con.prepareStatement(Buscar_Todos);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Dados dado = extraiDados(rs);
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

    public Dados buscarPorData(String data) {
        Dados dado = null;
        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = con.prepareStatement(Buscar);
            stmt.setString(1, data);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            dado = extraiDados(rs);
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
    public void apagar(int id) {
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
    public void atualizar(Dados dados) {
        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = con.prepareStatement(Atualizar);
            stmt.setString(1, dados.getData());
            stmt.setString(2, dados.getNumero_documento());
            stmt.setString(3, dados.getConta_debito());
            stmt.setString(4, dados.getConta_credito());
            stmt.setString(5, dados.getCnpj());
            stmt.setString(6, dados.getValor());
            stmt.setString(7, dados.getHistorico());
            stmt.setInt(8, dados.getId());
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
    private Dados extraiDados(ResultSet rs) throws SQLException, ParseException {
        Dados dados = new Dados();
        dados.setId(rs.getInt(1));
        dados.setData(rs.getString(2));
        dados.setNumero_documento(rs.getString(3));
        dados.setConta_debito(rs.getString(4));
        dados.setConta_credito(rs.getString(5));
        dados.setCnpj(rs.getString(6));
        dados.setValor(rs.getString(7));
        dados.setHistorico(rs.getString(8));
        return dados;
    }

    
}
