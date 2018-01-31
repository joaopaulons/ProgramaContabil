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
public interface UsimedCartaoBBServices {
    public void salvar(UsimedCartaoBBDados dados);
    
    public List<UsimedCartaoBBDados> buscarTodas();
    
    public UsimedCartaoBBDados buscaPorId(int id);
    
    public void apagar(int id);
    
    public void atualizar(UsimedCartaoBBDados dados);
    
    public static UsimedCartaoBBServices getNewInstance(){
        return new UsimedCartaoBBDBServices();
    }
}
