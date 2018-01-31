/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fxml.depara.controllers;

import br.com.programacontabil;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * FXML Controller class
 *
 * @author joao.santos
 */
public class CapaJavaController implements Initializable {

    public static ArrayList array_caminho = new ArrayList<>();
    public static String salvarArquivo;
    public static List cfop_inexistente = new ArrayList<>();
    public static PrintWriter gravarArq;
    public static File file;

    @FXML
    private TextArea txtAreaExemplo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void buttonLerXML(ActionEvent event) throws SAXException, IOException, ParserConfigurationException {
        try {
            codNFE();
        } catch (SQLException ex) {
            Logger.getLogger(CapaJavaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void buttonGerarTxt(ActionEvent event) throws SAXException, IOException, ParserConfigurationException {
        
    }

    private void codNFE() throws SAXException, IOException, ParserConfigurationException, SQLException {
        arrayOpen();
        try {
            for (Object caminho_ob : array_caminho) {
                File diretorio = new File((String) caminho_ob);
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document doc = builder.parse(diretorio);

                // <editor-fold defaultstate="collapsed" desc="CÓDIGO NFE">
                NodeList se = doc.getElementsByTagName("infProt");
                int sea = se.getLength();
                for (int i = 0; i < sea; i++) {
                    Node noide = se.item(i);
                    if (noide.getNodeType() == Node.ELEMENT_NODE) {
                        Element listaide = (Element) noide;
                        NodeList listafilhoide = listaide.getChildNodes();
                        int tamanholistaide = listafilhoide.getLength();
                        for (int j = 0; j < tamanholistaide; j++) {
                            Node idei = listafilhoide.item(j);
                            if (idei.getNodeType() == Node.ELEMENT_NODE) {
                                Element elementofilho = (Element) idei;
                                switch (elementofilho.getTagName()) {
                                    case "chNFe":
                                        String nfe = elementofilho.getTextContent();
                                        try {
                                            Connection con = ConnectionFactory.getConnection();
                                            PreparedStatement stmt = con.prepareStatement("INSERT INTO codnfe(codNFE) VALUES(?)");
                                            stmt.setString(1, nfe);
                                            stmt.execute();
                                            stmt.close();
                                            con.close();
                                        } catch (SQLException erro) {
                                            Alert alerta = new Alert(Alert.AlertType.ERROR);
                                            alerta.setTitle("Erro codigoNFE");
                                            alerta.setHeaderText(null);
                                            alerta.setContentText("Erro ao inserir as notas no banco de dados!");
                                            alerta.showAndWait();
                                        }
                                        System.out.println(nfe);
                                        break;
                                }

                            }
                        }
                    }
                }
//</editor-fold>

            }
        } catch (IOException erro) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Erro codigoNFE");
            alerta.setHeaderText(null);
            alerta.setContentText("Erro ao ler os códigos NFE!");
            alerta.showAndWait();
        }
    }

    public void mensagemCFOP() {
        if (cfop_inexistente.size() != 0) {
            for (int f = 0; f < cfop_inexistente.size(); f++) {
                Object b = cfop_inexistente.get(f);
                for (int c = f + 1; c < cfop_inexistente.size(); c++) {
                    Object d = cfop_inexistente.get(c);
                    if (b.equals(d)) {
                        cfop_inexistente.remove(c);
                        c--;
                    }
                }
            }
            Alert alertaa = new Alert(Alert.AlertType.INFORMATION);
            alertaa.setTitle("CFOP não encontrado!");
            alertaa.setContentText("Por favor informe os seguintes CFOP's ao T.I: " + cfop_inexistente.toString());
            alertaa.showAndWait();
            cfop_inexistente.removeAll(cfop_inexistente);
        }
    }

    public void arrayOpen() throws SAXException, IOException, ParserConfigurationException, ParserConfigurationException {
        Stage stage = programacontabil.primaryStage;
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Abrir arquivos");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML", "*.xml"));
        List<File> list
                = fileChooser.showOpenMultipleDialog(stage);
        if (list != null) {
            for (File file : list) {
                String caminho = file.getAbsolutePath();
                array_caminho.add(caminho);
                array_caminho.toString();
            }
        }

    }

    public void arquivoSave() throws IOException {
        Stage stage = programacontabil.primaryStage;
        File caminhofolle = new File("C:\\");
        FileChooser chooser = new FileChooser();
        chooser.setInitialDirectory(caminhofolle);
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text file (*.txt)", "*.txt"));
        file = chooser.showSaveDialog(stage);

    }
}
