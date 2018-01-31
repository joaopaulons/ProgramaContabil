/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fxml.conciliacao;

/**
 *
 * @author joao.santos
 */
public class DadosRec {
    private int id_rec;
    private String data_rec;
    private String numero_documento_rec;
    private String conta_debito_rec;
    private String conta_credito_rec;
    private String cnpj_rec;
    private String valor_rec;
    private String historico_rec;

    public int getId_rec() {
        return id_rec;
    }

    public void setId_rec(int id_rec) {
        this.id_rec = id_rec;
    }
    
    public String getData_rec() {
        return data_rec;
    }

    public void setData_rec(String data_rec) {
        this.data_rec = data_rec;
    }

    public String getNumero_documento_rec() {
        return numero_documento_rec;
    }

    public void setNumero_documento_rec(String numero_documento_rec) {
        this.numero_documento_rec = numero_documento_rec;
    }

    public String getConta_debito_rec() {
        return conta_debito_rec;
    }

    public void setConta_debito_rec(String conta_debito_rec) {
        this.conta_debito_rec = conta_debito_rec;
    }

    public String getConta_credito_rec() {
        return conta_credito_rec;
    }

    public void setConta_credito_rec(String conta_credito_rec) {
        this.conta_credito_rec = conta_credito_rec;
    }

    public String getCnpj_rec() {
        return cnpj_rec;
    }

    public void setCnpj_rec(String cnpj_rec) {
        this.cnpj_rec = cnpj_rec;
    }

    public String getValor_rec() {
        return valor_rec;
    }

    public void setValor_rec(String valor_rec) {
        this.valor_rec = valor_rec;
    }

    public String getHistorico_rec() {
        return historico_rec;
    }

    public void setHistorico_rec(String historico_rec) {
        this.historico_rec = historico_rec;
    }
    
}
