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
public class UsimedConvenioDADOS {
    private int id;
    private String emissao;
    private String num_documento;
    private String nome_pagador;
    private String valor;
    private String insc_pagador;
    private String valor_pago;
    private String valor_dif_cobrado;
    private String data_credito;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmissao() {
        return emissao;
    }

    public void setEmissao(String emissao) {
        this.emissao = emissao;
    }

    public String getNum_documento() {
        return num_documento;
    }

    public void setNum_documento(String num_documento) {
        this.num_documento = num_documento;
    }

    public String getNome_pagador() {
        return nome_pagador;
    }

    public void setNome_pagador(String nome_pagador) {
        this.nome_pagador = nome_pagador;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getInsc_pagador() {
        return insc_pagador;
    }

    public void setInsc_pagador(String insc_pagador) {
        this.insc_pagador = insc_pagador;
    }

    public String getValor_pago() {
        return valor_pago;
    }

    public void setValor_pago(String valor_pago) {
        this.valor_pago = valor_pago;
    }

    public String getValor_dif_cobrado() {
        return valor_dif_cobrado;
    }

    public void setValor_dif_cobrado(String valor_dif_cobrado) {
        this.valor_dif_cobrado = valor_dif_cobrado;
    }

    public String getData_credito() {
        return data_credito;
    }

    public void setData_credito(String data_credito) {
        this.data_credito = data_credito;
    }
    
    
}
