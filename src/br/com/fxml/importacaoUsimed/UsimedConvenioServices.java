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
public interface UsimedConvenioServices {
    public void salvar(UsimedConvenioDADOS dados);
    
    public List<UsimedConvenioDADOS> buscarTodas();
    
    public UsimedConvenioDADOS buscaPorId(int id);
    
    public void apagar(int id);
    
    public void atualizar(UsimedConvenioDADOS dados);
    
    public static UsimedConvenioServices getNewInstance(){
        return new UsimedConvenioDBService();
    }
}
