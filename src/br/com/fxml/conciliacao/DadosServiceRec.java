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
public interface DadosServiceRec {
    
    public void salvarRec(DadosRec dados);
    
    public List<DadosRec> buscarTodasRec();
    
    public DadosRec buscarPorDataRec(String data);
    
    public void apagarRec(int id);
    
    public void atualizarRec(DadosRec dados);
    
    
    public static DadosServiceRec getNewInstanceRec(){
        return new DadosDBServiceRec();
    }
}
