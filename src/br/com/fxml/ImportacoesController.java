/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fxml;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author joao.santos
 */
public class ImportacoesController implements Initializable {

    @FXML
    private Pane painelImportacoes;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    public Node getNode(String node){
        Node no = null;
        try {
            no = FXMLLoader.load(getClass().getResource(node));
        } catch (IOException e) {
        }
        return no;
        
    }
    
    @FXML
    private void menuButtonInfoPecas(ActionEvent event) {
        painelImportacoes.getChildren().clear();
        painelImportacoes.getClass();
        painelImportacoes.getChildren().add(getNode("informacoesImportacao.fxml"));
    }

    @FXML
    private void menuButtonFerrariFolle(ActionEvent event) {
        painelImportacoes.getChildren().clear();
        painelImportacoes.getClass();
        painelImportacoes.getChildren().add(getNode("importacaoFerrariFolle.fxml"));
    }

    @FXML
    private void buttonAlpha7(ActionEvent event) {
        painelImportacoes.getChildren().clear();
        painelImportacoes.getClass();
        painelImportacoes.getChildren().add(getNode("ImportacaoAlpha7.fxml"));
    }


}
