/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fxml;

import br.com.importacoes.ConnectionFactory;
import br.com.programacontabil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 * FXML Controller class
 *
 * @author joao.santos
 */
public class ImportacaoFerrariFolleController implements Initializable {

    public static ArrayList array_caminho = new ArrayList<>();
    public static File file;
    public static String dados[] = new String[6];
    public static String choiceboxrec;
    public static String valorbanco;
    public static String linha;
    public static BufferedReader reader;
    public static File diretorio;
    public static int a = 0;
       
    @FXML
    private TextArea txtareaData;
    @FXML
    private TextArea txtareaDescricao;
    @FXML
    private TextArea txtareaDocumento;
    @FXML
    private TextArea txtareaValor;
    @FXML
    private TextField txtContaDebito;
    @FXML
    private TextField txtContaCredito;
    @FXML
    private Pane painelPrincipal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void arrayOpen() throws SAXException, IOException, ParserConfigurationException, ParserConfigurationException {
        Stage stage = programacontabil.primaryStage;
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Abrir arquivos");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Arquivo Texto", "*.txt"));
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

    public void Testelerexcel() throws SQLException, FileNotFoundException, IOException, SAXException, ParserConfigurationException {
        array_caminho.clear();        
        txtareaData.clear();
        txtareaDescricao.clear();
        txtareaDocumento.clear();
        txtareaValor.clear();
        txtContaCredito.clear();
        txtContaDebito.clear();
        arrayOpen();       
        for (Object caminho_ob : array_caminho) {
            diretorio = new File((String) caminho_ob);            
            reader = new BufferedReader(new FileReader(diretorio));

            linha = reader.readLine();
            while (linha != null) {

                StringTokenizer st = new StringTokenizer(linha, "\t");
                dados[1] = st.nextToken();
                dados[2] = st.nextToken();
                dados[3] = st.nextToken();
                dados[4] = st.nextToken();
                dados[5] = st.nextToken();

                if ((dados[2].equals("SALDO ANTERIOR")) || (dados[2].equals("SALDO C/C")) || (dados[4].equals("-")) || (dados[4].contains("("))) {

                } else {

                    txtareaData.setEditable(true);
                    txtareaDescricao.setEditable(true);
                    txtareaDocumento.setEditable(true);
                    txtareaValor.setEditable(true);

                    txtareaData.appendText(dados[1].replace("Data", "") + "\n");
                    txtareaDescricao.appendText(dados[2] + "\n");
                    txtareaDocumento.appendText(dados[3] + "\n");
                    txtareaValor.appendText(dados[4] + "\n");

                }                
                linha = reader.readLine();

            }
        }
    }
    @FXML
    private void buttonVerificar(ActionEvent event) {
        try {
            Testelerexcel();
        } catch (SQLException | IOException | SAXException | ParserConfigurationException ex) {
            Logger.getLogger(ImportacaoFerrariFolleController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void arquivoSave() throws IOException {
        Stage stage = programacontabil.primaryStage;
        FileChooser chooser = new FileChooser();
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text file (*.txt)", "*.txt"));
        file = chooser.showSaveDialog(stage);

    }

    @FXML
    private void buttonImportar(ActionEvent event) throws IOException, SQLException {
        arquivoSave();
        for (Object caminho_ob : array_caminho) {

            diretorio = new File((String) caminho_ob);

            Connection con = ConnectionFactory.getConnection();
            Statement stm = con.createStatement();
            reader = new BufferedReader(new FileReader(diretorio));

            linha = reader.readLine();
            while (linha != null) {
                a++;

                StringTokenizer st = new StringTokenizer(linha, "\t");
                dados[1] = st.nextToken();
                dados[2] = st.nextToken();
                dados[3] = st.nextToken();
                dados[4] = st.nextToken();
                dados[5] = st.nextToken();

                if ((dados[2].equals("SALDO ANTERIOR")) || (dados[2].equals("SALDO C/C")) || (dados[4].equals("-")) || (dados[4].contains("("))) {

                } else {
                    try (FileWriter fw = new FileWriter(file, true); PrintWriter gravarArq = new PrintWriter(fw)) {

                        DecimalFormat formatvalor = new DecimalFormat("0000000000000.00");
                        NumberFormat nf = NumberFormat.getInstance();
                        nf.setMinimumIntegerDigits(5);
                        float teste = Float.parseFloat(dados[4].replace(".", "").replace(",", ".").replace("Valor(R$)", ""));
                        gravarArq.println("LC1" + nf.format(a).replace(".", "") + "   " + "1" + dados[1].replace("Data", "").replace("/", "").replace("\n", "") + dados[2].substring(0, 10) + "                                      " + txtContaDebito.getText() + "              " + "00000" + txtContaCredito.getText() + "              " + "00000" + formatvalor.format(teste).replace(",", ".") + "- DEPOSITO" + "            " + dados[2] + "                                                                                                                                                                                                                                                                                                                  ");

                    }

                }
                linha = reader.readLine();

            }
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Importar dados");
            alerta.setContentText("Dados importados com sucesso!");
            alerta.show();
            /*for(int a = 0; a <= i; a++){
            NumberFormat nf = NumberFormat.getInstance();
            nf.setMinimumIntegerDigits(5);
            
        }*/
        }
    }
    public Node getNode(String node){
        Node no = null;
        try {
            no = FXMLLoader.load(getClass().getResource(node));
        } catch (IOException e) {
        }
        return no;
        
    }

    
    

}
