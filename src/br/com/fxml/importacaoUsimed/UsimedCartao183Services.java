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
public interface UsimedCartao183Services {

    public void salvar(UsimedCartao183DADOS dados);

    public List<UsimedCartao183DADOS> buscarTodas();

    public UsimedCartao183DADOS buscaPorId(int id);

    public void apagar(int id);

    public void atualizar(UsimedCartao183DADOS dados);

    public static UsimedCartao183Services getNewInstance() {
        return new UsimedCartao183DBService();
    }

}
