/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com;

import java.io.IOException;
import java.util.Locale;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author joao.santos
 */
public class programacontabil extends Application {

    public static Stage primaryStage;

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void setPrimaryStage(Stage primaryStage) {
        programacontabil.primaryStage = primaryStage;
    }

    @Override
    public void start(Stage primaryStage) throws IOException {        
        Locale.setDefault(Locale.forLanguageTag("pt-BR"));
        Parent root = FXMLLoader.load(getClass().getResource("fxml/TelaMain.fxml"));
        Scene scene = new Scene(root);        
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("fxml/imagens/icon.png")));  
        primaryStage.setResizable(false);
        primaryStage.setTitle("Programa Contabil");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
