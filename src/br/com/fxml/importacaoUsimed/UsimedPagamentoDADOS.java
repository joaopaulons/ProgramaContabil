/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fxml.importacaoUsimed;

/**
 *
 * @author joao.santos
 */
public class UsimedPagamentoDADOS {
    private int id;
    private String num_doc;
    private String conta_bordero;
    private String data_pagamento;
    private String cedente;
    private String total_pago;
    private String descricao;
    private String descontos;
    private String acrescimos;
    private String total;
    private String banco_origem;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNum_doc() {
        return num_doc;
    }

    public void setNum_doc(String num_doc) {
        this.num_doc = num_doc;
    }

    public String getConta_bordero() {
        return conta_bordero;
    }

    public void setConta_bordero(String conta_bordero) {
        this.conta_bordero = conta_bordero;
    }

    public String getData_pagamento() {
        return data_pagamento;
    }

    public void setData_pagamento(String data_pagamento) {
        this.data_pagamento = data_pagamento;
    }

    public String getCedente() {
        return cedente;
    }

    public void setCedente(String cedente) {
        this.cedente = cedente;
    }

    public String getTotal_pago() {
        return total_pago;
    }

    public void setTotal_pago(String total_pago) {
        this.total_pago = total_pago;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescontos() {
        return descontos;
    }

    public void setDescontos(String descontos) {
        this.descontos = descontos;
    }

    public String getAcrescimos() {
        return acrescimos;
    }

    public void setAcrescimos(String acrescimos) {
        this.acrescimos = acrescimos;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getBanco_origem() {
        return banco_origem;
    }

    public void setBanco_origem(String banco_origem) {
        this.banco_origem = banco_origem;
    }
}
