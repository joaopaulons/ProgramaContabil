/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fxml.controllers;

import static br.com.fxml.controllers.ImportacaoAlpha7Controller.linhas;
import br.com.programacontabil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
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
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
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
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Arquivo Excel", "*.xls"));
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

    public void Testelerexcel() throws SQLException, FileNotFoundException, IOException, SAXException, ParserConfigurationException, BiffException {
        array_caminho.clear();
        txtareaData.clear();
        txtareaDescricao.clear();
        txtareaDocumento.clear();
        txtareaValor.clear();
        txtContaCredito.clear();
        txtContaDebito.clear();
        a = 0;
        arrayOpen();
        for (Object caminho_ob : array_caminho) {
            diretorio = new File((String) caminho_ob);
            Workbook workbook = Workbook.getWorkbook(diretorio);
            Sheet sheet = workbook.getSheet(0);
            linhas = sheet.getRows();
            System.out.println("Iniciando a leitura da planilha XLS:");
            for (int i = 0; i < linhas; i++) {
                Cell a1 = sheet.getCell(0, i);
                Cell a2 = sheet.getCell(2, i);
                Cell a3 = sheet.getCell(3, i);
                Cell a4 = sheet.getCell(4, i);

                String as1 = a1.getContents();
                String as2 = a2.getContents();
                String as3 = a3.getContents();
                String as4 = a4.getContents();

                txtareaData.setEditable(true);
                txtareaDescricao.setEditable(true);
                txtareaDocumento.setEditable(true);
                txtareaValor.setEditable(true);
                if (as1.equals("Data") || as2.equals("Histórico") || as3.equals("Docto.") || as4.equals("Valor R$") || as2.equals("SALDO ANTERIOR") || as4.startsWith("-")) {
                    a = a - 1;

                } else {
                    txtareaData.appendText(as1 + "\n");
                    txtareaDescricao.appendText(as2 + "\n");
                    txtareaDocumento.appendText(as3 + "\n");
                    txtareaValor.appendText(as4 + "\n");
                }

            }
        }
    }

    @FXML
    private void buttonVerificar(ActionEvent event) throws FileNotFoundException, BiffException {
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
    private void buttonImportar(ActionEvent event) throws IOException, SQLException, BiffException {
        a = 0;
        arquivoSave();
        for (Object caminho_ob : array_caminho) {

            diretorio = new File((String) caminho_ob);

            Workbook workbook = Workbook.getWorkbook(diretorio);
            Sheet sheet = workbook.getSheet(0);
            linhas = sheet.getRows();
            for (int i = 0; i < linhas; i++) {
                a++;
                Cell a1 = sheet.getCell(0, i);
                Cell a2 = sheet.getCell(2, i);
                Cell a3 = sheet.getCell(3, i);
                Cell a4 = sheet.getCell(4, i);
                Cell a5 = sheet.getCell(5, i);

                String as1 = a1.getContents();
                String as2 = a2.getContents();
                String as3 = a3.getContents();
                String as4 = a4.getContents();
                String as5 = a5.getContents();

                try (FileWriter fw = new FileWriter(file, true); PrintWriter gravarArq = new PrintWriter(fw)) {
                    if (as1.equals("Data") || as2.equals("Histórico") || as3.equals("Docto.") || as4.equals("Valor R$") || as2.equals("SALDO ANTERIOR") || as4.startsWith("-")) {
                        a = a - 1;

                    } else {
                        if (a1.getContents().length() == 8) {
                            
                            as1 = as1.substring(0, 6) + "2017";
                            
                        }
                        DecimalFormat formatvalor = new DecimalFormat("0000000000000.00");
                        NumberFormat nf = NumberFormat.getInstance();
                        nf.setMinimumIntegerDigits(5);
                        float teste = Float.parseFloat(as4.replace(".", "").replace(",", ".").replace("Valor R$", ""));
                        gravarArq.println("LC1" + nf.format(a).replace(".", "").replace("-", "0") + "   " + "1" + as1.replace("Data", "").replace("/", "").replace("\n", "") + as2.substring(0, 10) + "                                      " + txtContaDebito.getText() + "              " + "00000" + txtContaCredito.getText() + "              " + "00000" + formatvalor.format(teste).replace(",", ".") + "- DEPOSITO" + "            " + as2 + "  " + as3 + "                                                                                                                                                                                                                                                                                                                  ");
                    }
                }

            }
            

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

    public Node getNode(String node) {
        Node no = null;
        try {
            no = FXMLLoader.load(getClass().getResource(node));
        } catch (IOException e) {
        }
        return no;

    }

}
