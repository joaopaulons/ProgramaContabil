/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alfacapa.controllers;

/**
 *
 * @author joao.santos
 */
public class CFOPDados {
    private int id;
    private String cfop_saida;
    private String cfop_entrada;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCfop_saida() {
        return cfop_saida;
    }

    public void setCfop_saida(String cfop_saida) {
        this.cfop_saida = cfop_saida;
    }

    public String getCfop_entrada() {
        return cfop_entrada;
    }

    public void setCfop_entrada(String cfop_entrada) {
        this.cfop_entrada = cfop_entrada;
    }        
}
