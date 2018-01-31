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
import javafx.scene.image.ImageView;
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
public class ImportacaoAlpha7Controller implements Initializable {

    public static ArrayList array_caminho = new ArrayList<>();
    public static File file;
    public static int linhas;
    public static String dados[] = new String[5];
    public static String choiceboxrec;
    public static String valorbanco;
    public static String linha;
    public static BufferedReader reader;
    public static File diretorio;
    public static int a = 0;

    @FXML
    private ImageView fundoImagem;
    @FXML
    private TextArea txtTerceiros;
    @FXML
    private TextArea txtNumeroNota;
    @FXML
    private TextArea txtValorNota;
    @FXML
    private TextArea txtDataEntrada;
    @FXML
    private TextArea txtJuros;
    @FXML
    private TextField txtContaCredito;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void buttonAbrirArquivo(ActionEvent event) throws SAXException, IOException, ParserConfigurationException, BiffException {
        txtTerceiros.clear();
        txtNumeroNota.clear();
        txtValorNota.clear();
        txtDataEntrada.clear();
        txtJuros.clear();
        txtContaCredito.clear();
        a = 0;
        arrayOpen();
        for (Object caminho_ob : array_caminho) {
            diretorio = new File((String) caminho_ob);
            Workbook workbook = Workbook.getWorkbook(diretorio);
            Sheet sheet = workbook.getSheet(0);
            linhas = sheet.getRows();
            System.out.println("Iniciando a leitura da planilha XLS:");
            for (int i = 0; i < linhas; i++) {
                Cell a1 = sheet.getCell(14, i);
                Cell a2 = sheet.getCell(16, i);
                Cell a3 = sheet.getCell(3, i);
                Cell a4 = sheet.getCell(18, i);
                Cell a5 = sheet.getCell(5, i);
                Cell a6 = sheet.getCell(15, i);
                String as1 = a1.getContents();
                String as2 = a2.getContents();
                String as3 = a3.getContents();
                String as4 = a4.getContents();
                String as5 = a5.getContents();
                String as6 = a6.getContents();

                if (as6.equals("SIM")) {

                    txtTerceiros.appendText(as1 + "\n");
                    txtNumeroNota.appendText(as2 + "\n");
                    txtValorNota.appendText(as3 + "\n");
                    txtDataEntrada.appendText(as4 + "\n");
                    txtJuros.appendText(as5 + "\n");
                } else {

                }

            }
            workbook.close();
        }

    }

    @FXML
    private void buttonGerarJuros(ActionEvent event) throws IOException, BiffException {
        if (txtContaCredito.getText().equals("")) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Campo incorreto");
            alerta.setContentText("Por favor insira uma conta crédito!");
            alerta.show();
            txtContaCredito.setStyle("-fx-background:red");
        } else {
            txtContaCredito.setStyle("-fx-background:transparent");
            a = 0;
            arquivoSave();
            for (Object caminho_ob : array_caminho) {
                diretorio = new File((String) caminho_ob);
                Workbook workbook = Workbook.getWorkbook(diretorio);
                Sheet sheet = workbook.getSheet(0);
                linhas = sheet.getRows();
                for (int i = 0; i < linhas; i++) {
                    a++;
                    Cell a1 = sheet.getCell(14, i);
                    Cell a2 = sheet.getCell(16, i);
                    Cell a3 = sheet.getCell(17, i);
                    Cell a4 = sheet.getCell(18, i);
                    Cell a5 = sheet.getCell(5, i);
                    Cell a6 = sheet.getCell(15, i);

                    String as1 = a1.getContents();
                    String as2 = a2.getContents();
                    String as3 = a3.getContents();
                    String as4 = a4.getContents();
                    String as5 = a5.getContents();
                    String as6 = a6.getContents();

                    try (FileWriter fw = new FileWriter(file, true); PrintWriter gravarArq = new PrintWriter(fw)) {
                        if (as6.equals("SIM")) {
                            if (a4.getContents().length() == 8) {
                                String formatar = "2017";
                                as4 = as4.substring(0, 6) + formatar;
                            }
                            if (as5.equals("0,00")) {
                                a = a - 1;

                            } else {
                                DecimalFormat formatvalor = new DecimalFormat("0000000000000.00");
                                DecimalFormat formatnf = new DecimalFormat("00000");
                                NumberFormat nf = NumberFormat.getInstance();
                                nf.setMinimumIntegerDigits(5);
                                float formatar_valor = Float.parseFloat(as3.replace(".", "").replace(",", ".").replace("$", "0"));

                                gravarArq.println("LC1" + nf.format(a).replace(".", "") + "   " + "1" + as4.replace("/", "") + "1" + formatnf.format(Float.parseFloat(as2)).replace(",", "") + "                                          " + "79999" + as1.replace("/", "").replace(".", "").replace("-", "") + "00000" + txtContaCredito.getText() + "              " + "00000" + formatvalor.format(formatar_valor).replace(",", ".") + "- RECEBIDO DUPL.      " + as2 + "                                                                                                                                                                                                                                                                                                                  ");
                            }
                        } else {
                            a = a - 1;
                        }

                    }
                }
            }
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Importação");
            alerta.setContentText("Dados importados com sucesso!");
            alerta.show();
        }
    }

    @FXML
    private void buttonImportar(ActionEvent event) throws IOException, BiffException {
        if (txtContaCredito.getText().equals("")) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Campo incorreto");
            alerta.setContentText("Por favor insira uma conta crédito!");
            alerta.show();
            txtContaCredito.setStyle("-fx-background:red");
        } else {
            txtContaCredito.setStyle("-fx-background:transparent");
            a = 0;
            arquivoSave();
            for (Object caminho_ob : array_caminho) {
                diretorio = new File((String) caminho_ob);
                Workbook workbook = Workbook.getWorkbook(diretorio);
                Sheet sheet = workbook.getSheet(0);
                linhas = sheet.getRows();
                for (int i = 0; i < linhas; i++) {
                    a++;
                    Cell a1 = sheet.getCell(14, i);
                    Cell a2 = sheet.getCell(16, i);
                    Cell a3 = sheet.getCell(3, i);
                    Cell a4 = sheet.getCell(18, i);
                    Cell a5 = sheet.getCell(5, i);
                    Cell a6 = sheet.getCell(15, i);

                    String as1 = a1.getContents();
                    String as2 = a2.getContents();
                    String as3 = a3.getContents();
                    String as4 = a4.getContents();
                    String as5 = a5.getContents();
                    String as6 = a6.getContents();

                    try (FileWriter fw = new FileWriter(file, true); PrintWriter gravarArq = new PrintWriter(fw)) {
                        if (as6.equals("SIM")) {
                            if (a4.getContents().length() == 8) {
                                String formatar = "2017";
                                as4 = as4.substring(0, 6) + formatar;
                            }
                            DecimalFormat formatvalor = new DecimalFormat("0000000000000.00");
                            DecimalFormat formatnf = new DecimalFormat("00000");
                            NumberFormat nf = NumberFormat.getInstance();
                            nf.setMinimumIntegerDigits(5);
                            float formatar_valor = Float.parseFloat(as3.replace(".", "").replace(",", ".").replace("$", ""));

                            gravarArq.println("LC1" + nf.format(a).replace(".", "") + "   " + "1" + as4.replace("/", "") + formatnf.format(Float.parseFloat(as2)).replace(",", "") + "                                           " + txtContaCredito.getText() + "              " + "00000" + "79999" + as1.replace("/", "").replace(".", "").replace("-", "") + "00000" + formatvalor.format(formatar_valor).replace(",", ".") + "- RECEBIDO DUPL.      " + as2 + "                                                                                                                                                                                                                                                                                                                  ");
                        } else {
                            a = a - 1;
                        }

                    }
                }
            }
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Importação");
            alerta.setContentText("Dados importados com sucesso!");
            alerta.show();
        }
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
        File caminhofolle = new File("Z:\\Importação CTB\\CTB - ALEATORIO");
        FileChooser chooser = new FileChooser();
        chooser.setInitialDirectory(caminhofolle);
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text file (*.txt)", "*.txt"));
        file = chooser.showSaveDialog(stage);

    }
}
