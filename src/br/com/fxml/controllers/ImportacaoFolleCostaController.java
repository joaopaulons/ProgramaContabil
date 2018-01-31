/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fxml.controllers;

import br.com.programacontabil;
import java.io.BufferedReader;
import java.io.File;
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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
public class ImportacaoFolleCostaController implements Initializable {

    public static ArrayList array_caminho = new ArrayList<>();
    public static File file;
    public static int linhas;
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
    private TextField txtContaCredito;
    @FXML
    private TextField txtContaDebito;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void buttonVerificar(ActionEvent event) throws SAXException, IOException, ParserConfigurationException, BiffException {
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
                Cell a2 = sheet.getCell(1, i);
                Cell a3 = sheet.getCell(2, i);
                Cell a4 = sheet.getCell(3, i);
                String as1 = a1.getContents();
                String as2 = a2.getContents();
                String as3 = a3.getContents();
                String as4 = a4.getContents();

                txtareaData.appendText(as1 + "\n");
                txtareaDescricao.appendText(as2 + "\n");
                txtareaDocumento.appendText(as3 + "\n");
                txtareaValor.appendText(as4 + "\n");
            }
            workbook.close();
        }
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
            System.out.println("Iniciando a leitura da planilha XLS:");
            for (int i = 0; i < linhas; i++) {
                a++;
                Cell a1 = sheet.getCell(0, i);
                Cell a2 = sheet.getCell(1, i);
                Cell a3 = sheet.getCell(2, i);
                Cell a4 = sheet.getCell(3, i);

                String as1 = a1.getContents();
                String as2 = a2.getContents();
                String as3 = a3.getContents();
                String as4 = a4.getContents();
                System.out.println(as1 + "   " + as2 + "    " + as3 + "    " + as4);

                try (FileWriter fw = new FileWriter(file, true); PrintWriter gravarArq = new PrintWriter(fw)) {

                    DecimalFormat formatvalor = new DecimalFormat("0000000000000.00");
                    NumberFormat nf = NumberFormat.getInstance();
                    nf.setMinimumIntegerDigits(5);
                    if (as2.equals("SALDO ANTERIOR") || as4.contains("-") || as4.equals("0") || as4.contains("(")) {
                        a = a - 1;
                    } else {
                        if (a1.getContents().length() == 8) {
                            as1 = as1.substring(0, 6) + "2017";
                        }
                        if (as2.length() > 10) {
                            float teste = Float.parseFloat(as4.replace(".", "").replace(",", ".").replace("Valor(R$)", ""));
                            as2 = as2.substring(0, 10);
                            gravarArq.println("LC1" + nf.format(a).replace(".", "") + "   " + "1" + as1.replace("Data", "").replace("/", "").replace("\n", "") + as2 + "                                      " + txtContaDebito.getText() + "              " + "00000" + txtContaCredito.getText() + "              " + "00000" + formatvalor.format(teste).replace(",", ".") + "- DEPOSITO" + "   " + as2 + "   " + as3 + "                                                                                                                                                                                                                                                                                                                  ");
                        } else {
                            switch (as2.length()) {
                                case 1:
                                    float teste = Float.parseFloat(as4.replace(".", "").replace(",", ".").replace("Valor(R$)", ""));
                                    String espacos1 = "                                               ";
                                    gravarArq.println("LC1" + nf.format(a).replace(".", "") + "   " + "1" + as1.replace("Data", "").replace("/", "").replace("\n", "") + as2 + espacos1 + txtContaDebito.getText() + "              " + "00000" + txtContaCredito.getText() + "              " + "00000" + formatvalor.format(teste).replace(",", ".") + "- DEPOSITO" + "   " + as2 + "   " + as3 + "                                                                                                                                                                                                                                                                                                                  ");
                                    break;
                                case 2:
                                    teste = Float.parseFloat(as4.replace(".", "").replace(",", ".").replace("Valor(R$)", ""));
                                    String espacos2 = "                                              ";
                                    gravarArq.println("LC1" + nf.format(a).replace(".", "") + "   " + "1" + as1.replace("Data", "").replace("/", "").replace("\n", "") + as2 + espacos2 + txtContaDebito.getText() + "              " + "00000" + txtContaCredito.getText() + "              " + "00000" + formatvalor.format(teste).replace(",", ".") + "- DEPOSITO" + "   " + as2 + "   " + as3 + "                                                                                                                                                                                                                                                                                                                  ");
                                    break;
                                case 3:
                                    teste = Float.parseFloat(as4.replace(".", "").replace(",", ".").replace("Valor(R$)", ""));
                                    String espacos3 = "                                             ";
                                    gravarArq.println("LC1" + nf.format(a).replace(".", "") + "   " + "1" + as1.replace("Data", "").replace("/", "").replace("\n", "") + as2 + espacos3 + txtContaDebito.getText() + "              " + "00000" + txtContaCredito.getText() + "              " + "00000" + formatvalor.format(teste).replace(",", ".") + "- DEPOSITO" + "   " + as2 + "   " + as3 + "                                                                                                                                                                                                                                                                                                                  ");
                                    break;
                                case 4:
                                    teste = Float.parseFloat(as4.replace(".", "").replace(",", ".").replace("Valor(R$)", ""));
                                    String espacos4 = "                                            ";
                                    gravarArq.println("LC1" + nf.format(a).replace(".", "") + "   " + "1" + as1.replace("Data", "").replace("/", "").replace("\n", "") + as2 + espacos4 + txtContaDebito.getText() + "              " + "00000" + txtContaCredito.getText() + "              " + "00000" + formatvalor.format(teste).replace(",", ".") + "- DEPOSITO" + "   " + as2 + "   " + as3 + "                                                                                                                                                                                                                                                                                                                  ");
                                    break;
                                case 5:
                                    teste = Float.parseFloat(as4.replace(".", "").replace(",", ".").replace("Valor(R$)", ""));
                                    String espacos5 = "                                           ";
                                    gravarArq.println("LC1" + nf.format(a).replace(".", "") + "   " + "1" + as1.replace("Data", "").replace("/", "").replace("\n", "") + as2 + espacos5 + txtContaDebito.getText() + "              " + "00000" + txtContaCredito.getText() + "              " + "00000" + formatvalor.format(teste).replace(",", ".") + "- DEPOSITO" + "   " + as2 + "   " + as3 + "                                                                                                                                                                                                                                                                                                                  ");
                                    break;
                                case 6:
                                    teste = Float.parseFloat(as4.replace(".", "").replace(",", ".").replace("Valor(R$)", ""));
                                    String espacos6 = "                                          ";
                                    gravarArq.println("LC1" + nf.format(a).replace(".", "") + "   " + "1" + as1.replace("Data", "").replace("/", "").replace("\n", "") + as2 + espacos6 + txtContaDebito.getText() + "              " + "00000" + txtContaCredito.getText() + "              " + "00000" + formatvalor.format(teste).replace(",", ".") + "- DEPOSITO" + "   " + as2 + "   " + as3 + "                                                                                                                                                                                                                                                                                                                  ");
                                    break;
                                case 7:
                                    teste = Float.parseFloat(as4.replace(".", "").replace(",", ".").replace("Valor(R$)", ""));
                                    String espacos7 = "                                         ";
                                    gravarArq.println("LC1" + nf.format(a).replace(".", "") + "   " + "1" + as1.replace("Data", "").replace("/", "").replace("\n", "") + as2 + espacos7 + txtContaDebito.getText() + "              " + "00000" + txtContaCredito.getText() + "              " + "00000" + formatvalor.format(teste).replace(",", ".") + "- DEPOSITO" + "   " + as2 + "   " + as3 + "                                                                                                                                                                                                                                                                                                                  ");
                                    break;
                                case 8:
                                    teste = Float.parseFloat(as4.replace(".", "").replace(",", ".").replace("Valor(R$)", ""));
                                    String espacos8 = "                                        ";
                                    gravarArq.println("LC1" + nf.format(a).replace(".", "") + "   " + "1" + as1.replace("Data", "").replace("/", "").replace("\n", "") + as2 + espacos8 + txtContaDebito.getText() + "              " + "00000" + txtContaCredito.getText() + "              " + "00000" + formatvalor.format(teste).replace(",", ".") + "- DEPOSITO" + "   " + as2 + "   " + as3 + "                                                                                                                                                                                                                                                                                                                  ");
                                    break;
                                case 9:
                                    teste = Float.parseFloat(as4.replace(".", "").replace(",", ".").replace("Valor(R$)", ""));
                                    String espacos9 = "                                       ";
                                    gravarArq.println("LC1" + nf.format(a).replace(".", "") + "   " + "1" + as1.replace("Data", "").replace("/", "").replace("\n", "") + as2 + espacos9 + txtContaDebito.getText() + "              " + "00000" + txtContaCredito.getText() + "              " + "00000" + formatvalor.format(teste).replace(",", ".") + "- DEPOSITO" + "   " + as2 + "   " + as3 + "                                                                                                                                                                                                                                                                                                                  ");
                                    break;
                                case 10:
                                    teste = Float.parseFloat(as4.replace(".", "").replace(",", ".").replace("Valor(R$)", ""));
                                    String espacos10 = "                                      ";
                                    gravarArq.println("LC1" + nf.format(a).replace(".", "") + "   " + "1" + as1.replace("Data", "").replace("/", "").replace("\n", "") + as2 + espacos10 + txtContaDebito.getText() + "              " + "00000" + txtContaCredito.getText() + "              " + "00000" + formatvalor.format(teste).replace(",", ".") + "- DEPOSITO" + "   " + as2 + "   " + as3 + "                                                                                                                                                                                                                                                                                                                  ");
                                    break;
                            }
                        }
                    }
                }
            }
        }
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Importar dados");
        alerta.setContentText("Dados importados com sucesso!");
        alerta.show();
    }

    public void arrayOpen() throws SAXException, IOException, ParserConfigurationException, ParserConfigurationException {
        Stage stage = programacontabil.primaryStage;
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Abrir arquivos");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Arquivo excel", "*.xls"));
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
        File caminhofolle = new File("Z:\\Importação CTB\\CTB - Folle");
        FileChooser chooser = new FileChooser();
        chooser.setInitialDirectory(caminhofolle);
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text file (*.txt)", "*.txt"));
        file = chooser.showSaveDialog(stage);

    }
}
