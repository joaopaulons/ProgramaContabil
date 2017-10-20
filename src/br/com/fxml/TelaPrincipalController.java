/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fxml;

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
public class TelaPrincipalController implements Initializable {

    @FXML
    private Pane telaPrincipal;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public Node getNode(String node){
        Node no = null;
        try {
            no = FXMLLoader.load(getClass().getResource(node));
        } catch (Exception e) {
        }
        return no;
        
    }
   
    @FXML
    private void paneImportacoes(ActionEvent event) {
        telaPrincipal.getChildren().clear();        
        telaPrincipal.getClass();
        telaPrincipal.getChildren().add(getNode("importacoes.fxml"));
    }
    
}
