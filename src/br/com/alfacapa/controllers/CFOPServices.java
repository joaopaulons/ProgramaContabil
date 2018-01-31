/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alfacapa.controllers;



import java.util.List;

/**
 *
 * @author joao.santos
 */
public interface CFOPServices {
    public void salvar(CFOPDados dados);
    
    public List<CFOPDados> buscarTodas();
    
    public CFOPDados buscaPorId(int id);
    
    public void apagar(int id);
    
    public void atualizar(CFOPDados dados);
    
    public static CFOPServices getNewInstance(){
        return new CFOPDBService();
    }
}
