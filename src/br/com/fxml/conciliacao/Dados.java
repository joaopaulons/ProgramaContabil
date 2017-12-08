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
public class Dados {
    private int id;
    private String data;
    private String numero_documento;
    private String conta_debito;
    private String conta_credito;
    private String cnpj;
    private String valor;
    private String historico;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getNumero_documento() {
        return numero_documento;
    }

    public void setNumero_documento(String numero_documento) {
        this.numero_documento = numero_documento;
    }

    public String getConta_debito() {
        return conta_debito;
    }

    public void setConta_debito(String conta_debito) {
        this.conta_debito = conta_debito;
    }

    public String getConta_credito() {
        return conta_credito;
    }

    public void setConta_credito(String conta_credito) {
        this.conta_credito = conta_credito;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }
    
    
}
