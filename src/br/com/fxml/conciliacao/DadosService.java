/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fxml.conciliacao;

import java.util.List;

/**
 *
 * @author joao.santos
 */
public interface DadosService {
    
    public void salvar(Dados dados);
    
    public List<Dados> buscarTodas();
    
    public Dados buscarPorData(String data);
    
    public void apagar(int id);
    
    public void atualizar(Dados dados);
    
    
    public static DadosService getNewInstance(){
        return new DadosDBService();
    }
   
    
}
