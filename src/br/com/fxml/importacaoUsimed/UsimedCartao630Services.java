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
public interface UsimedCartao630Services {
    public void salvar(UsimedCartao630DADOS dados);

    public List<UsimedCartao630DADOS> buscarTodas();

    public UsimedCartao630DADOS buscaPorId(int id);

    public void apagar(int id);

    public void atualizar(UsimedCartao630DADOS dados);

    public static UsimedCartao630Services getNewInstance() {
        return new UsimedCartao630DBService();
    }
}
