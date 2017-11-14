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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author joao.santos
 */
public class TelaMainController implements Initializable {

    @FXML
    private AnchorPane painelImportacoes;
    @FXML
    private Pane telaPrincipal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void menuButtonFerrariFolle(ActionEvent event) {
        telaPrincipal.getChildren().clear();
        telaPrincipal.getClass();
        telaPrincipal.getChildren().add(getNode("importacaoFerrariFolle.fxml"));
    }

    @FXML
    private void menuButtonInfoPecas(ActionEvent event) {
        telaPrincipal.getChildren().clear();
        telaPrincipal.getClass();
        telaPrincipal.getChildren().add(getNode("informacoesImportacao.fxml"));
    }

    @FXML
    private void menuButtonAlpha7(ActionEvent event) {
        telaPrincipal.getChildren().clear();
        telaPrincipal.getClass();
        telaPrincipal.getChildren().add(getNode("ImportacaoAlpha7.fxml"));
    }

    @FXML
    private void menuButtonFolleCosta(ActionEvent event) {
        telaPrincipal.getChildren().clear();
        telaPrincipal.getClass();
        telaPrincipal.getChildren().add(getNode("importacaoFolleCosta.fxml"));
    }

    @FXML
    private void menuButtonEcoCapivari(ActionEvent event) {
        telaPrincipal.getChildren().clear();
        telaPrincipal.getClass();
        telaPrincipal.getChildren().add(getNode("importacaoEconomicaCapivari.fxml"));
    }

    public Node getNode(String node) {
        Node no = null;
        try {
            no = FXMLLoader.load(getClass().getResource(node));
        } catch (IOException e) {
        }
        return no;

    }
    
   
    @FXML
    private void menuButtonDotta(ActionEvent event) {
        telaPrincipal.getChildren().clear();
        telaPrincipal.getClass();
        telaPrincipal.getChildren().add(getNode("ImportacaoDotta.fxml"));
    }

    @FXML
    private void menuButtonExtratoCapivari(ActionEvent event) {
        telaPrincipal.getChildren().clear();
        telaPrincipal.getClass();
        telaPrincipal.getChildren().add(getNode("ExtratoDrogaEcoCapivari.fxml"));
    }

    @FXML
    private void buttonItens(ActionEvent event) throws IOException {
        telaPrincipal.getChildren().clear();
        telaPrincipal.getClass();
        telaPrincipal.getChildren().add(getNode("ItensJava.fxml"));
    }

    @FXML
    private void menuButtonCapa(ActionEvent event) {
       
    }
}
