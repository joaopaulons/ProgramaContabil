/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fxml.importacaoUsimed;

import java.util.List;

/**
 *
 * @author joao.santos
 */
public interface UsimedPagamentoServices {
    
    public void salvar(UsimedPagamentoDADOS dados);
    
    public List<UsimedPagamentoDADOS> buscarTodas();
    
    public UsimedPagamentoDADOS buscaPorId(int id);
    
    public void apagar(int id);
    
    public void atualizar(UsimedPagamentoDADOS dados);
    
    public static UsimedPagamentoServices getNewInstance(){
        return new UsimedPagamentoDBService();
    }
}
