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
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
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
    @FXML
    private ChoiceBox<String> choiceBanco;
    @FXML
    private Label lblData;
    @FXML
    private Label lblDescricao;
    @FXML
    private Label lblDocumento;
    @FXML
    private Label lblValor;
    @FXML
    private Label lblMensagem;
    @FXML
    private Label lblNomeArquivo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        choiceBanco.setItems(FXCollections.observableArrayList(
                "Santander", "TriBanco", "Bradesco")
        );
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
        if (choiceBanco.getValue() == null) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setContentText("Por favor escolha um banco para importar o arquivo.");
            alerta.setTitle("Opção não selecionada.");
            alerta.setHeaderText("Selecione uma opção.");
            alerta.show();
        } else {
            switch (choiceBanco.getValue()) {
                case "Santander":
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
                        for (int i = 3; i < linhas; i++) {
                            Cell a1 = sheet.getCell(0, i);
                            Cell a2 = sheet.getCell(1, i);
                            Cell a3 = sheet.getCell(2, i);
                            Cell a4 = sheet.getCell(3, i);

                            String as1 = a1.getContents();
                            String as2 = a2.getContents();
                            String as3 = a3.getContents();
                            String as4 = a4.getContents();

                            Cell t1 = sheet.getCell(0, 0);
                            Cell t2 = sheet.getCell(1, 0);
                            Cell t3 = sheet.getCell(2, 0);
                            Cell t4 = sheet.getCell(3, 0);

                            String ts1 = t1.getContents();
                            String ts2 = t2.getContents();
                            String ts3 = t3.getContents();
                            String ts4 = t4.getContents();

                            lblData.setText(ts1);
                            lblDescricao.setText(ts2);
                            lblDocumento.setText(ts3);
                            lblValor.setText(ts4);

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
                    Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                    alerta.setTitle("Importar dados");
                    alerta.setContentText("Dados importados com sucesso!");
                    alerta.show();
                    lblMensagem.setText(diretorio.getName());
                    lblNomeArquivo.setVisible(true);
                    lblMensagem.setVisible(true);
                    break;
                case "TriBanco":
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
                            Cell a2 = sheet.getCell(1, i);
                            Cell a3 = sheet.getCell(2, i);
                            Cell a4 = sheet.getCell(3, i);

                            String as1 = a1.getContents();
                            String as2 = a2.getContents();
                            String as3 = a3.getContents();
                            String as4 = a4.getContents();

                            Cell t1 = sheet.getCell(0, 0);
                            Cell t2 = sheet.getCell(1, 0);
                            Cell t3 = sheet.getCell(2, 0);
                            Cell t4 = sheet.getCell(3, 0);

                            String ts1 = t1.getContents();
                            String ts2 = t2.getContents();
                            String ts3 = t3.getContents();
                            String ts4 = t4.getContents();

                            lblData.setText(ts1);
                            lblDescricao.setText(ts2);
                            lblDocumento.setText(ts3);
                            lblValor.setText(ts4);

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
                    Alert alertaa = new Alert(Alert.AlertType.INFORMATION);
                    alertaa.setTitle("Importar dados");
                    alertaa.setContentText("Dados importados com sucesso!");
                    alertaa.show();
                    lblMensagem.setText(diretorio.getName());
                    lblNomeArquivo.setVisible(true);
                    lblMensagem.setVisible(true);
                    break;
                case "Bradesco":
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
                        for (int i = 10; i < linhas; i++) {
                            Cell a1 = sheet.getCell(0, i);
                            Cell a2 = sheet.getCell(1, i);
                            Cell a3 = sheet.getCell(2, i);
                            Cell a4 = sheet.getCell(3, i);

                            String as1 = a1.getContents();
                            String as2 = a2.getContents();
                            String as3 = a3.getContents();
                            String as4 = a4.getContents();

                            Cell t1 = sheet.getCell(0, 10);
                            Cell t2 = sheet.getCell(1, 10);
                            Cell t3 = sheet.getCell(2, 10);
                            Cell t4 = sheet.getCell(3, 10);

                            String ts1 = t1.getContents();
                            String ts2 = t2.getContents();
                            String ts3 = t3.getContents();
                            String ts4 = t4.getContents();

                            lblData.setText(ts1);
                            lblDescricao.setText(ts2);
                            lblDocumento.setText(ts3);
                            lblValor.setText(ts4);

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
                    Alert alertab = new Alert(Alert.AlertType.INFORMATION);
                    alertab.setTitle("Importar dados");
                    alertab.setContentText("Dados importados com sucesso!");
                    alertab.show();
                    lblMensagem.setText(diretorio.getName());
                    lblNomeArquivo.setVisible(true);
                    lblMensagem.setVisible(true);
                    break;
                default:
                    break;
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
        try {            
            if (choiceBanco.getValue() == null || txtContaDebito.getText().equals("") || txtContaCredito.getText().equals("")) {
                if(choiceBanco.getValue() == null){
                    choiceBanco.setStyle("-fx-border-color:red");
                }
                if(txtContaDebito.getText().equals("")){
                    txtContaDebito.setStyle("-fx-border-color:red");
                }
                if(txtContaCredito.getText().equals("")){
                     txtContaCredito.setStyle("-fx-border-color:red");
                } 
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setContentText("Por favor corrija  os campos destacados em vermelho.");
                alerta.setTitle("Dados inválidos.");
                alerta.setHeaderText("Corrija os campos corretamente.");
                alerta.show();
            } else {
                choiceBanco.setStyle("-fx-border-color:transparent");
                txtContaCredito.setStyle("-fx-border-color:transparent");
                txtContaDebito.setStyle("-fx-border-color:transparent");
                switch (choiceBanco.getValue()) {
                    case "Santander":
                        String as2_santander = null;
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
                                Cell a2 = sheet.getCell(1, i);
                                Cell a3 = sheet.getCell(2, i);
                                Cell a4 = sheet.getCell(3, i);

                                String as1 = a1.getContents();
                                String as2 = a2.getContents();
                                String as3 = a3.getContents();
                                String as4 = a4.getContents();

                                try (FileWriter fw = new FileWriter(file, true); PrintWriter gravarArq = new PrintWriter(fw)) {
                                    if (as1.equals("Data") || as2.equals("Histórico") || as3.equals("Docto.") || as4.equals("Valor R$") || as2.equals("SALDO ANTERIOR") || as4.contains("-") || as4.equals("0") || as4.equals("") || as4.equals(" ")) {
                                        a = a - 1;

                                    } else {
                                        if (a1.getContents().length() == 8) {
                                            as1 = as1.substring(0, 6) + "2017";
                                        }
                                        DecimalFormat formatvalor = new DecimalFormat("0000000000000.00");
                                        NumberFormat nf = NumberFormat.getInstance();
                                        nf.setMinimumIntegerDigits(5);
                                        String espaco = "";
                                        float teste = Float.parseFloat(as4.replace(".", "").replace(",", ".").replace("Valor R$", ""));
                                        switch (as2) {
                                            case "CTAO CRED.MASTERCARD- REDECARD":
                                                as2 = as2.replace("CTAO CRED.MASTERCARD- REDECARD", "DEPOSITO");
                                                break;
                                            case "CARTAO CRED. VISA - REDECARD":
                                                as2 = as2.replace("CARTAO CRED. VISA - REDECARD", "DEPOSITO");
                                                break;
                                            case "CARTAO HIPERCARD CRED REDECARD":
                                                as2 = as2.replace("CARTAO HIPERCARD CRED REDECARD", "DEPOSITO");
                                                break;
                                            case "CARTAO DEB.MASTERCARD-REDECARD":
                                                as2 = as2.replace("CARTAO DEB.MASTERCARD-REDECARD", "DEPOSITO");
                                                break;
                                            case "CARTAO DEB.VISA - REDECARD":
                                                as2 = as2.replace("CARTAO DEB.VISA - REDECARD", "DEPOSITO");
                                                break;
                                            case "TED C RECEBIDA - BANCO SANTANDER S.A.":
                                                as2 = as2.replace("TED C RECEBIDA - BANCO SANTANDER S.A.", "DEPOSITO");
                                                break;
                                            case "TED C RECEBIDA - SOROCRED":
                                                as2 = as2.replace("TED C RECEBIDA - SOROCRED", "DEPOSITO");
                                                break;
                                            case "CARTAO CREDITO CABAL - REDECAR":
                                                as2 = as2.replace("CARTAO CREDITO CABAL - REDECAR", "DEPOSITO");
                                                break;
                                            case "ELO DEB REDE":
                                                as2 = as2.replace("ELO DEB REDE", "DEPOSITO");
                                                break;
                                            case "CARTAO SUPER COMPRAS":
                                                as2 = as2.replace("CARTAO SUPER COMPRAS", "DEPOSITO");
                                                break;
                                            case "ESTORNO RECEBIMENTO LOJA SC":
                                                as2 = as2.replace("ESTORNO RECEBIMENTO LOJA SC", "DEPOSITO");
                                                break;
                                            case "CARTAO CREDSYSTEM CRED REDECAR":
                                                as2 = as2.replace("CARTAO CREDSYSTEM CRED REDECAR", "DEPOSITO");
                                                break;
                                            case "CARTAO CRED.VISA - CIELO":
                                                as2 = as2.replace("CARTAO CRED.VISA - CIELO", "DEPOSITO");
                                                break;
                                            case "CARTAO DEBITO CABAL - REDECARD":
                                                as2 = as2.replace("CARTAO DEBITO CABAL - REDECARD", "DEPOSITO");
                                                break;
                                            case "CARTAO CRED.MASTERCARD - CIELO":
                                                as2 = as2.replace("CARTAO CRED.MASTERCARD - CIELO", "DEPOSITO");
                                                break;
                                            case "TRANSF.AUTOMATICA SALDO  - COBRANCA":
                                                as2 = as2.replace("TRANSF.AUTOMATICA SALDO  - COBRANCA", "DEPOSITO");
                                                break;
                                            case "CARTAO DEB.VISA - CIELO":
                                                as2 = as2.replace("CARTAO DEB.VISA - CIELO", "DEPOSITO");
                                                break;
                                            case "CARTAO DEB.MASTERCARD - CIELO ":
                                                as2 = as2.replace("CARTAO DEB.MASTERCARD - CIELO ", "DEPOSITO");
                                                break;
                                            case "CARTAO DEB.MASTERCARD - CIELO":
                                                as2 = as2.replace("CARTAO DEB.MASTERCARD - CIELO ", "DEPOSITO");
                                                break;
                                            case "TED C RECEBIDA - GETNET ADQUIRENCIA E":
                                                as2 = as2.replace("TED C RECEBIDA - GETNET ADQUIRENCIA E", "DEPOSITO");
                                                break;
                                            case "DINERS CRED REDECARD":
                                                as2 = as2.replace("DINERS CRED REDECARD", "DEPOSITO");
                                                break;
                                            default:
                                                break;
                                        }
                                        if (as2.contains(("CARTAO")) || as2.contains("DEPOSITO")) {
                                            as2_santander = "DEPOSITO";
                                            as2 = "DEPOSITO";
                                            espaco = "                                        ";
                                        } else {
                                            as2_santander = as2;
                                        }
                                        if (as2.length() > 10) {
                                            as2 = as2.substring(0, 10);
                                            espaco = "                                      ";
                                        }

                                        gravarArq.println("LC1" + nf.format(a).replace(".", "").replace("-", "0") + "   " + "1" + as1.replace("Data", "").replace("/", "").replace("\n", "") + as2 + espaco + txtContaDebito.getText() + "              " + "00000" + txtContaCredito.getText() + "              " + "00000" + formatvalor.format(teste).replace(",", ".") + "-" + " " + as2_santander + "  " + "                                                                                                                                                                                                                                                                                                                  ");
                                    }
                                }
                            }
                        }
                        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                        alerta.setTitle("Importar dados");
                        alerta.setContentText("Dados importados com sucesso!");
                        alerta.show();
                        break;
                    case "TriBanco":
                        String as2_tribanco = null;
                        a = 0;
                        arquivoSave();
                        for (Object caminho_ob : array_caminho) {
                            diretorio = new File((String) caminho_ob);
                            Workbook workbook = Workbook.getWorkbook(diretorio);
                            Sheet sheet = workbook.getSheet(0);
                            linhas = sheet.getRows();
                            for (int i = 11; i < linhas; i++) {
                                a++;
                                Cell a1 = sheet.getCell(0, i);
                                Cell a2 = sheet.getCell(1, i);
                                Cell a3 = sheet.getCell(2, i);
                                Cell a4 = sheet.getCell(3, i);

                                String as1 = a1.getContents();
                                String as2 = a2.getContents();
                                String as3 = a3.getContents();
                                String as4 = a4.getContents();

                                try (FileWriter fw = new FileWriter(file, true); PrintWriter gravarArq = new PrintWriter(fw)) {
                                    if (as1.equals("Data") || as2.equals("Histórico") || as3.equals("Docto.") || as4.equals("Valor R$") || as2.equals("SALDO ANTERIOR") || as2.equals("SALDO C/C") || as4.contains("-") || as4.equals("0") || as4.equals("") || as4.equals(" ")) {
                                        a = a - 1;

                                    } else {
                                        if (a1.getContents().length() == 8) {
                                            as1 = as1.substring(0, 6) + "2017";
                                        }                                        
                                        DecimalFormat formatvalor = new DecimalFormat("0000000000000.00");
                                        NumberFormat nf = NumberFormat.getInstance();
                                        nf.setMinimumIntegerDigits(5);
                                        String espaco = "";
                                        float teste = Float.parseFloat(as4.replace(".", "").replace(",", ".").replace("Valor R$", ""));
                                        switch (as2) {
                                            case "CTAO CRED.MASTERCARD- REDECARD":
                                                as2 = as2.replace("CTAO CRED.MASTERCARD- REDECARD", "DEPOSITO");
                                                break;
                                            case "CARTAO CRED. VISA - REDECARD":
                                                as2 = as2.replace("CARTAO CRED. VISA - REDECARD", "DEPOSITO");
                                                break;
                                            case "CARTAO HIPERCARD CRED REDECARD":
                                                as2 = as2.replace("CARTAO HIPERCARD CRED REDECARD", "DEPOSITO");
                                                break;
                                            case "CARTAO DEB.MASTERCARD-REDECARD":
                                                as2 = as2.replace("CARTAO DEB.MASTERCARD-REDECARD", "DEPOSITO");
                                                break;
                                            case "CARTAO DEB.VISA - REDECARD":
                                                as2 = as2.replace("CARTAO DEB.VISA - REDECARD", "DEPOSITO");
                                                break;
                                            case "TED C RECEBIDA - BANCO SANTANDER S.A.":
                                                as2 = as2.replace("TED C RECEBIDA - BANCO SANTANDER S.A.", "DEPOSITO");
                                                break;
                                            case "TED C RECEBIDA - SOROCRED":
                                                as2 = as2.replace("TED C RECEBIDA - SOROCRED", "DEPOSITO");
                                                break;
                                            case "CARTAO CREDITO CABAL - REDECAR":
                                                as2 = as2.replace("CARTAO CREDITO CABAL - REDECAR", "DEPOSITO");
                                                break;
                                            case "ELO DEB REDE":
                                                as2 = as2.replace("ELO DEB REDE", "DEPOSITO");
                                                break;
                                            case "CARTAO SUPER COMPRAS":
                                                as2 = as2.replace("CARTAO SUPER COMPRAS", "DEPOSITO");
                                                break;
                                            case "ESTORNO RECEBIMENTO LOJA SC":
                                                as2 = as2.replace("ESTORNO RECEBIMENTO LOJA SC", "DEPOSITO");
                                                break;
                                            case "CARTAO CREDSYSTEM CRED REDECAR":
                                                as2 = as2.replace("CARTAO CREDSYSTEM CRED REDECAR", "DEPOSITO");
                                                break;
                                            case "CARTAO CRED.VISA - CIELO":
                                                as2 = as2.replace("CARTAO CRED.VISA - CIELO", "DEPOSITO");
                                                break;
                                            case "CARTAO DEBITO CABAL - REDECARD":
                                                as2 = as2.replace("CARTAO DEBITO CABAL - REDECARD", "DEPOSITO");
                                                break;
                                            case "CARTAO CRED.MASTERCARD - CIELO":
                                                as2 = as2.replace("CARTAO CRED.MASTERCARD - CIELO", "DEPOSITO");
                                                break;
                                            case "TRANSF.AUTOMATICA SALDO  - COBRANCA":
                                                as2 = as2.replace("TRANSF.AUTOMATICA SALDO  - COBRANCA", "DEPOSITO");
                                                break;
                                            case "CARTAO DEB.VISA - CIELO":
                                                as2 = as2.replace("CARTAO DEB.VISA - CIELO", "DEPOSITO");
                                                break;
                                            case "CARTAO DEB.MASTERCARD - CIELO ":
                                                as2 = as2.replace("CARTAO DEB.MASTERCARD - CIELO ", "DEPOSITO");
                                                break;
                                            case "CARTAO DEB.MASTERCARD - CIELO":
                                                as2 = as2.replace("CARTAO DEB.MASTERCARD - CIELO ", "DEPOSITO");
                                                break;
                                            case "TED C RECEBIDA - GETNET ADQUIRENCIA E":
                                                as2 = as2.replace("TED C RECEBIDA - GETNET ADQUIRENCIA E", "DEPOSITO");
                                                break;
                                            case "DINERS CRED REDECARD":
                                                as2 = as2.replace("DINERS CRED REDECARD", "DEPOSITO");
                                                break;
                                            default:
                                                break;
                                        }
                                        if (as2.contains(("CARTAO")) || as2.contains("DEPOSITO")) {
                                            as2_tribanco = "DEPOSITO";
                                            as2 = "DEPOSITO";
                                            espaco = "                                        ";
                                        } else {
                                            as2_tribanco = as2;
                                        }
                                        if (as2.length() > 10) {
                                            as2 = as2.substring(0, 10);
                                            espaco = "                                      ";
                                        }

                                        gravarArq.println("LC1" + nf.format(a).replace(".", "").replace("-", "0") + "   " + "1" + as1.replace("Data", "").replace("/", "").replace("\n", "") + as2 + espaco + txtContaDebito.getText() + "              " + "00000" + txtContaCredito.getText() + "              " + "00000" + formatvalor.format(teste).replace(",", ".") + "-" + " " + as2_tribanco + "  " + "                                                                                                                                                                                                                                                                                                                  ");
                                    }
                                }
                            }
                        }
                        Alert alertaTribanco = new Alert(Alert.AlertType.INFORMATION);
                        alertaTribanco.setTitle("Importar dados");
                        alertaTribanco.setContentText("Dados importados com sucesso!");
                        alertaTribanco.show();
                        break;
                    case "Bradesco":
                        String as2_desc = null;
                        a = 0;
                        arquivoSave();
                        for (Object caminho_ob : array_caminho) {
                            diretorio = new File((String) caminho_ob);
                            Workbook workbook = Workbook.getWorkbook(diretorio);
                            Sheet sheet = workbook.getSheet(0);
                            linhas = sheet.getRows();
                            for (int i = 11; i < linhas; i++) {
                                a++;
                                Cell a1 = sheet.getCell(0, i);
                                Cell a2 = sheet.getCell(1, i);
                                Cell a3 = sheet.getCell(2, i);
                                Cell a4 = sheet.getCell(3, i);

                                String as1 = a1.getContents();
                                String as2 = a2.getContents();
                                String as3 = a3.getContents();
                                String as4 = a4.getContents();

                                try (FileWriter fw = new FileWriter(file, true); PrintWriter gravarArq = new PrintWriter(fw)) {
                                    if (as1.equals("Data") || as2.equals("Histórico") || as3.equals("Docto.") || as4.equals("Valor R$") || as2.equals("SALDO ANTERIOR") || as4.contains("-") || as4.equals("0") || as4.equals("") || as4.equals(" ") || as1.equals("Total") || as2.equals("")) {
                                        a = a - 1;
                                    } else {
                                        if (a1.getContents().length() == 8) {
                                            as1 = as1.substring(0, 6) + "2017";
                                        }
                                        DecimalFormat formatvalor = new DecimalFormat("0000000000000.00");
                                        NumberFormat nf = NumberFormat.getInstance();
                                        nf.setMinimumIntegerDigits(5);
                                        String espaco = "";
                                        float teste = Float.parseFloat(as4.replace(".", "").replace(",", ".").replace("Valor R$", ""));
                                        switch (as2) {
                                            case "CTAO CRED.MASTERCARD- REDECARD":
                                                as2 = as2.replace("CTAO CRED.MASTERCARD- REDECARD", "DEPOSITO");
                                                break;
                                            case "CARTAO CRED. VISA - REDECARD":
                                                as2 = as2.replace("CARTAO CRED. VISA - REDECARD", "DEPOSITO");
                                                break;
                                            case "CARTAO HIPERCARD CRED REDECARD":
                                                as2 = as2.replace("CARTAO HIPERCARD CRED REDECARD", "DEPOSITO");
                                                break;
                                            case "CARTAO DEB.MASTERCARD-REDECARD":
                                                as2 = as2.replace("CARTAO DEB.MASTERCARD-REDECARD", "DEPOSITO");
                                                break;
                                            case "CARTAO DEB.VISA - REDECARD":
                                                as2 = as2.replace("CARTAO DEB.VISA - REDECARD", "DEPOSITO");
                                                break;
                                            case "TED C RECEBIDA - BANCO SANTANDER S.A.":
                                                as2 = as2.replace("TED C RECEBIDA - BANCO SANTANDER S.A.", "DEPOSITO");
                                                break;
                                            case "TED C RECEBIDA - SOROCRED":
                                                as2 = as2.replace("TED C RECEBIDA - SOROCRED", "DEPOSITO");
                                                break;
                                            case "CARTAO CREDITO CABAL - REDECAR":
                                                as2 = as2.replace("CARTAO CREDITO CABAL - REDECAR", "DEPOSITO");
                                                break;
                                            case "ELO DEB REDE":
                                                as2 = as2.replace("ELO DEB REDE", "DEPOSITO");
                                                break;
                                            case "CARTAO SUPER COMPRAS":
                                                as2 = as2.replace("CARTAO SUPER COMPRAS", "DEPOSITO");
                                                break;
                                            case "ESTORNO RECEBIMENTO LOJA SC":
                                                as2 = as2.replace("ESTORNO RECEBIMENTO LOJA SC", "DEPOSITO");
                                                break;
                                            case "CARTAO CREDSYSTEM CRED REDECAR":
                                                as2 = as2.replace("CARTAO CREDSYSTEM CRED REDECAR", "DEPOSITO");
                                                break;
                                            case "CARTAO CRED.VISA - CIELO":
                                                as2 = as2.replace("CARTAO CRED.VISA - CIELO", "DEPOSITO");
                                                break;
                                            case "CARTAO DEBITO CABAL - REDECARD":
                                                as2 = as2.replace("CARTAO DEBITO CABAL - REDECARD", "DEPOSITO");
                                                break;
                                            case "CARTAO CRED.MASTERCARD - CIELO":
                                                as2 = as2.replace("CARTAO CRED.MASTERCARD - CIELO", "DEPOSITO");
                                                break;
                                            case "TRANSF.AUTOMATICA SALDO  - COBRANCA":
                                                as2 = as2.replace("TRANSF.AUTOMATICA SALDO  - COBRANCA", "DEPOSITO");
                                                break;
                                            case "CARTAO DEB.VISA - CIELO":
                                                as2 = as2.replace("CARTAO DEB.VISA - CIELO", "DEPOSITO");
                                                break;
                                            case "CARTAO DEB.MASTERCARD - CIELO ":
                                                as2 = as2.replace("CARTAO DEB.MASTERCARD - CIELO ", "DEPOSITO");
                                                break;
                                            case "CARTAO DEB.MASTERCARD - CIELO":
                                                as2 = as2.replace("CARTAO DEB.MASTERCARD - CIELO ", "DEPOSITO");
                                                break;
                                            case "TED C RECEBIDA - GETNET ADQUIRENCIA E":
                                                as2 = as2.replace("TED C RECEBIDA - GETNET ADQUIRENCIA E", "DEPOSITO");
                                                break;
                                            case "DINERS CRED REDECARD":
                                                as2 = as2.replace("DINERS CRED REDECARD", "DEPOSITO");
                                                break;
                                            case "DEPOSITO EM DINHEIRO NO ATM":
                                                as2 = as2.replace("DEPOSITO EM DINHEIRO NO ATM", "DEPOSITO");
                                                break;
                                            case "CIELO CARTAO DE CREDITO BAND CREDSYSTEM":
                                                as2 = as2.replace("CIELO CARTAO DE CREDITO BAND CREDSYSTEM", "DEPOSITO");
                                                break;
                                            case "COMPRA CARTAO MAESTRO 06/11 BRAZEROS GRILL":
                                                as2 = as2.replace("COMPRA CARTAO MAESTRO 06/11 BRAZEROS GRILL", "DEPOSITO");
                                                break;
                                            case "COMPRA CARTAO MAESTRO":
                                                as2 = as2.replace("COMPRA CARTAO MAESTRO", "DEPOSITO");
                                                break;
                                            default:
                                                break;
                                        }
                                        if (as2.contains(("CARTAO")) || as2.contains("DEPOSITO")) {
                                            as2_desc = "DEPOSITO";
                                            as2 = "DEPOSITO";
                                            espaco = "                                        ";
                                        } else {
                                            as2_desc = as2;
                                        }
                                        if (as2.length() > 10) {
                                            as2 = as2.substring(0, 10);
                                            espaco = "                                      ";
                                        }

                                        gravarArq.println("LC1" + nf.format(a).replace(".", "").replace("-", "0") + "   " + "1" + as1.replace("Data", "").replace("/", "").replace("\n", "") + as2 + espaco + txtContaDebito.getText() + "              " + "00000" + txtContaCredito.getText() + "              " + "00000" + formatvalor.format(teste).replace(",", ".") + "-" + " " + as2_desc + "  " + "                                                                                                                                                                                                                                                                                                                  ");
                                    }
                                }
                            }
                        }
                        Alert alertaBradesco = new Alert(Alert.AlertType.INFORMATION);
                        alertaBradesco.setTitle("Importar dados");
                        alertaBradesco.setContentText("Dados importados com sucesso!");
                        alertaBradesco.show();
                        break;
                    default:
                        break;
                }
            }
        } catch (BiffException erro) {
            Alert alertaBradesco = new Alert(Alert.AlertType.INFORMATION);
            alertaBradesco.setTitle("Erro ao ler a planilha");
            alertaBradesco.setContentText("Informe este erro ao T.I:\n" + erro);
            alertaBradesco.show();
        }
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
