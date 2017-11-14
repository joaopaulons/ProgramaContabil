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
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
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
public class InformacoesImportacaoController implements Initializable {

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
    private TextField txtBanco;
    @FXML
    private ChoiceBox<String> choiceBoxRecPag;
    @FXML
    private TextArea txtareaConf;
    @FXML
    private TextArea txtareaNumero;
    @FXML
    private TextArea txtareaValorPago;
    @FXML
    private TextArea txtareaDataPagto;
    @FXML
    private TextArea txtareaControle;
    @FXML
    private TextField txtOutrosBrancos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        choiceBoxRecPag.setItems(FXCollections.observableArrayList(
                "Recebimento", "Pagamento")
        );
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
                Cell a2 = sheet.getCell(1, i);
                Cell a3 = sheet.getCell(2, i);
                Cell a4 = sheet.getCell(3, i);
                Cell a5 = sheet.getCell(4, i);
                Cell a6 = sheet.getCell(5, i);

                String as1 = a1.getContents();
                String as2 = a2.getContents();
                String as3 = a3.getContents();
                String as4 = a4.getContents();
                String as5 = a5.getContents();
                String as6 = a6.getContents();

                try (FileWriter fw = new FileWriter(file, true); PrintWriter gravarArq = new PrintWriter(fw)) {
                    switch (choiceBoxRecPag.getValue()) {
                        // <editor-fold defaultstate="collapsed" desc="Recebimento">
                        case "Recebimento":
                            String formato_cpf;
                            String conta;
                            DecimalFormat format = new DecimalFormat("0000000000000.00");
                            NumberFormat nf = NumberFormat.getInstance();
                            nf.setMinimumIntegerDigits(5);
                            float numero_valor = 0;
                            if (as1.length() <= 14) {
                                formato_cpf = "   ";
                            } else {
                                formato_cpf = "";
                            }
                            if (as1.equals("Inscricao") || (as2.equals("SeuNumero") || (as3.equals("ValorPago") || (as4.equals("DtPgtoBx") || as5.equals("Controle"))))) {
                                a = a - 1;
                            } else {
                                if (a4.getContents().length() == 8) {
                                    String formatar = "2017";
                                    as4 = as4.substring(0, 6) + formatar;
                                }
                                if (as2.length() > 10) {
                                    as2 = as2.substring(0, 10);
                                }
                                if (as6.equals("caixa")) {
                                   conta = txtOutrosBrancos.getText();
                                }else{
                                    conta = txtBanco.getText();
                                }
                                switch (as2.length()) {
                                    case 1:
                                        numero_valor = Float.parseFloat(as3.replace(",", "."));
                                        String espacos1 = "                                               ";
                                        gravarArq.println("LC1" + nf.format(a).replace(".", "") + "   " + "1" + as4.replace("/", "").replace("\n", "") + as2 + espacos1 + conta + "              " + "00000" + "79999" + as1.replace("-", "").replace(".", "").replace("/", "") + formato_cpf + "00000" + format.format(numero_valor).replace(",", ".") + "-RECEBIDO DUPL. " + as2 + "                                                                                                                                                                                                                                                                                                  ");
                                        break;
                                    case 2:
                                        numero_valor = Float.parseFloat(as3.replace(",", "."));
                                        String espacos2 = "                                              ";
                                        gravarArq.println("LC1" + nf.format(a).replace(".", "") + "   " + "1" + as4.replace("/", "").replace("\n", "") + as2 + espacos2 + conta + "              " + "00000" + "79999" + as1.replace("-", "").replace(".", "").replace("/", "") + formato_cpf + "00000" + format.format(numero_valor).replace(",", ".") + "-RECEBIDO DUPL. " + as2 + "                                                                                                                                                                                                                                                                                                  ");
                                        break;
                                    case 3:
                                        numero_valor = Float.parseFloat(as3.replace(",", "."));
                                        String espacos3 = "                                             ";
                                        gravarArq.println("LC1" + nf.format(a).replace(".", "") + "   " + "1" + as4.replace("/", "").replace("\n", "") + as2 + espacos3 + conta + "              " + "00000" + "79999" + as1.replace("-", "").replace(".", "").replace("/", "") + formato_cpf + "00000" + format.format(numero_valor).replace(",", ".") + "-RECEBIDO DUPL. " + as2 + "                                                                                                                                                                                                                                                                                                  ");
                                        break;
                                    case 4:
                                        numero_valor = Float.parseFloat(as3.replace(",", "."));
                                        String espacos4 = "                                            ";
                                        gravarArq.println("LC1" + nf.format(a).replace(".", "") + "   " + "1" + as4.replace("/", "").replace("\n", "") + as2 + espacos4 + conta + "              " + "00000" + "79999" + as1.replace("-", "").replace(".", "").replace("/", "") + formato_cpf + "00000" + format.format(numero_valor).replace(",", ".") + "-RECEBIDO DUPL. " + as2 + "                                                                                                                                                                                                                                                                                                  ");
                                        break;
                                    case 5:
                                        numero_valor = Float.parseFloat(as3.replace(",", "."));
                                        String espacos5 = "                                           ";
                                        gravarArq.println("LC1" + nf.format(a).replace(".", "") + "   " + "1" + as4.replace("/", "").replace("\n", "") + as2 + espacos5 + conta + "              " + "00000" + "79999" + as1.replace("-", "").replace(".", "").replace("/", "") + formato_cpf + "00000" + format.format(numero_valor).replace(",", ".") + "-RECEBIDO DUPL. " + as2 + "                                                                                                                                                                                                                                                                                                  ");
                                        break;
                                    case 6:
                                        numero_valor = Float.parseFloat(as3.replace(",", "."));
                                        String espacos6 = "                                          ";
                                        gravarArq.println("LC1" + nf.format(a).replace(".", "") + "   " + "1" + as4.replace("/", "").replace("\n", "") + as2 + espacos6 + conta + "              " + "00000" + "79999" + as1.replace("-", "").replace(".", "").replace("/", "") + formato_cpf + "00000" + format.format(numero_valor).replace(",", ".") + "-RECEBIDO DUPL. " + as2 + "                                                                                                                                                                                                                                                                                                  ");
                                        break;
                                    case 7:
                                        numero_valor = Float.parseFloat(as3.replace(",", "."));
                                        String espacos7 = "                                         ";
                                        gravarArq.println("LC1" + nf.format(a).replace(".", "") + "   " + "1" + as4.replace("/", "").replace("\n", "") + as2 + espacos7 + conta + "              " + "00000" + "79999" + as1.replace("-", "").replace(".", "").replace("/", "") + formato_cpf + "00000" + format.format(numero_valor).replace(",", ".") + "-RECEBIDO DUPL. " + as2 + "                                                                                                                                                                                                                                                                                                  ");
                                        break;
                                    case 8:
                                        numero_valor = Float.parseFloat(as3.replace(",", "."));
                                        String espacos8 = "                                        ";
                                        gravarArq.println("LC1" + nf.format(a).replace(".", "") + "   " + "1" + as4.replace("/", "").replace("\n", "") + as2 + espacos8 + conta + "              " + "00000" + "79999" + as1.replace("-", "").replace(".", "").replace("/", "") + formato_cpf + "00000" + format.format(numero_valor).replace(",", ".") + "-RECEBIDO DUPL. " + as2 + "                                                                                                                                                                                                                                                                                                  ");
                                        break;
                                    case 9:
                                        numero_valor = Float.parseFloat(as3.replace(",", "."));
                                        String espacos9 = "                                       ";
                                        gravarArq.println("LC1" + nf.format(a).replace(".", "") + "   " + "1" + as4.replace("/", "").replace("\n", "") + as2 + espacos9 + conta + "              " + "00000" + "79999" + as1.replace("-", "").replace(".", "").replace("/", "") + formato_cpf + "00000" + format.format(numero_valor).replace(",", ".") + "-RECEBIDO DUPL. " + as2 + "                                                                                                                                                                                                                                                                                                  ");
                                        break;
                                    case 10:
                                        numero_valor = Float.parseFloat(as3.replace(",", "."));
                                        String espacos10 = "                                      ";
                                        gravarArq.println("LC1" + nf.format(a).replace(".", "") + "   " + "1" + as4.replace("/", "").replace("\n", "") + as2 + espacos10 + conta + "              " + "00000" + "79999" + as1.replace("-", "").replace(".", "").replace("/", "") + formato_cpf + "00000" + format.format(numero_valor).replace(",", ".") + "-RECEBIDO DUPL. " + as2 + "                                                                                                                                                                                                                                                                                                  ");
                                        break;
                                }
                            }
                            break;
                        //</editor-fold>

                        case "Pagamento":
                            if (a4.getContents().length() == 8) {
                                String formatar = "2017";
                                as4 = as4.substring(0, 6) + formatar;

                            }
                            String formato_cpf_pagamento;
                            DecimalFormat format_pagamento = new DecimalFormat("0000000000000.00");
                            NumberFormat nf_pagamento = NumberFormat.getInstance();
                            nf_pagamento.setMinimumIntegerDigits(5);
                            float numero_valor_pagamento = 0;
                            if (as1.length() <= 14) {
                                formato_cpf_pagamento = "   ";
                            } else {
                                formato_cpf_pagamento = "";
                            }
                            if (as1.equals("Inscricao") || (as2.equals("SeuNumero") || (as3.equals("ValorPago") || (as4.equals("DtPgtoBx") || as5.equals("Controle"))))) {
                                a = a - 1;
                            } else {
                                if (as2.length() > 10) {
                                    as2 = as2.substring(0, 10);
                                }
                                if (as6.equals("caixa")) {
                                   conta = txtOutrosBrancos.getText();
                                }else{
                                    conta = txtBanco.getText();
                                }
                                switch (as2.length()) {
                                    case 1:
                                        numero_valor_pagamento = Float.parseFloat(as3.replace(",", "."));
                                        String espacos1 = "                                               ";
                                        gravarArq.println("LC1" + nf_pagamento.format(a).replace(".", "") + "   " + "1" + as4.replace("/", "").replace("\n", "") + as2 + espacos1 + "29999" + as1.replace("-", "").replace(".", "").replace("/", "") + formato_cpf_pagamento + "00000" + conta + "              " + "00000" + format_pagamento.format(numero_valor_pagamento).replace(",", ".") + "- PAGTO DUPL. N " + as2 + "                                                                                                                                                                                                                                                                                                  ");
                                        break;
                                    case 2:
                                        numero_valor_pagamento = Float.parseFloat(as3.replace(",", "."));
                                        String espacos2 = "                                              ";
                                        gravarArq.println("LC1" + nf_pagamento.format(a).replace(".", "") + "   " + "1" + as4.replace("/", "").replace("\n", "") + as2 + espacos2 + "29999" + as1.replace("-", "").replace(".", "").replace("/", "") + formato_cpf_pagamento + "00000" + conta + "              " + "00000" + format_pagamento.format(numero_valor_pagamento).replace(",", ".") + "- PAGTO DUPL. N " + as2 + "                                                                                                                                                                                                                                                                                                  ");
                                        break;
                                    case 3:
                                        numero_valor_pagamento = Float.parseFloat(as3.replace(",", "."));
                                        String espacos3 = "                                             ";
                                        gravarArq.println("LC1" + nf_pagamento.format(a).replace(".", "") + "   " + "1" + as4.replace("/", "").replace("\n", "") + as2 + espacos3 + "29999" + as1.replace("-", "").replace(".", "").replace("/", "") + formato_cpf_pagamento + "00000" + conta + "              " + "00000" + format_pagamento.format(numero_valor_pagamento).replace(",", ".") + "- PAGTO DUPL. N " + as2 + "                                                                                                                                                                                                                                                                                                  ");
                                        break;
                                    case 4:
                                        numero_valor_pagamento = Float.parseFloat(as3.replace(",", "."));
                                        String espacos4 = "                                            ";
                                        gravarArq.println("LC1" + nf_pagamento.format(a).replace(".", "") + "   " + "1" + as4.replace("/", "").replace("\n", "") + as2 + espacos4 + "29999" + as1.replace("-", "").replace(".", "").replace("/", "") + formato_cpf_pagamento + "00000" + conta + "              " + "00000" + format_pagamento.format(numero_valor_pagamento).replace(",", ".") + "- PAGTO DUPL. N " + as2 + "                                                                                                                                                                                                                                                                                                  ");
                                        break;
                                    case 5:
                                        numero_valor_pagamento = Float.parseFloat(as3.replace(",", "."));
                                        String espacos5 = "                                           ";
                                        gravarArq.println("LC1" + nf_pagamento.format(a).replace(".", "") + "   " + "1" + as4.replace("/", "").replace("\n", "") + as2 + espacos5 + "29999" + as1.replace("-", "").replace(".", "").replace("/", "") + formato_cpf_pagamento + "00000" + conta + "              " + "00000" + format_pagamento.format(numero_valor_pagamento).replace(",", ".") + "- PAGTO DUPL. N " + as2 + "                                                                                                                                                                                                                                                                                                  ");
                                        break;
                                    case 6:
                                        numero_valor_pagamento = Float.parseFloat(as3.replace(",", "."));
                                        String espacos6 = "                                          ";
                                        gravarArq.println("LC1" + nf_pagamento.format(a).replace(".", "") + "   " + "1" + as4.replace("/", "").replace("\n", "") + as2 + espacos6 + "29999" + as1.replace("-", "").replace(".", "").replace("/", "") + formato_cpf_pagamento + "00000" + conta + "              " + "00000" + format_pagamento.format(numero_valor_pagamento).replace(",", ".") + "- PAGTO DUPL. N " + as2 + "                                                                                                                                                                                                                                                                                                  ");
                                        break;
                                    case 7:
                                        numero_valor_pagamento = Float.parseFloat(as3.replace(",", "."));
                                        String espacos7 = "                                         ";
                                        gravarArq.println("LC1" + nf_pagamento.format(a).replace(".", "") + "   " + "1" + as4.replace("/", "").replace("\n", "") + as2 + espacos7 + "29999" + as1.replace("-", "").replace(".", "").replace("/", "") + formato_cpf_pagamento + "00000" + conta + "              " + "00000" + format_pagamento.format(numero_valor_pagamento).replace(",", ".") + "- PAGTO DUPL. N " + as2 + "                                                                                                                                                                                                                                                                                                  ");
                                        break;
                                    case 8:
                                        numero_valor_pagamento = Float.parseFloat(as3.replace(",", "."));
                                        String espacos8 = "                                        ";
                                        gravarArq.println("LC1" + nf_pagamento.format(a).replace(".", "") + "   " + "1" + as4.replace("/", "").replace("\n", "") + as2 + espacos8 + "29999" + as1.replace("-", "").replace(".", "").replace("/", "") + formato_cpf_pagamento + "00000" + conta + "              " + "00000" + format_pagamento.format(numero_valor_pagamento).replace(",", ".") + "- PAGTO DUPL. N " + as2 + "                                                                                                                                                                                                                                                                                                  ");
                                        break;
                                    case 9:
                                        numero_valor_pagamento = Float.parseFloat(as3.replace(",", "."));
                                        String espacos9 = "                                       ";
                                        gravarArq.println("LC1" + nf_pagamento.format(a).replace(".", "") + "   " + "1" + as4.replace("/", "").replace("\n", "") + as2 + espacos9 + "29999" + as1.replace("-", "").replace(".", "").replace("/", "") + formato_cpf_pagamento + "00000" + conta + "              " + "00000" + format_pagamento.format(numero_valor_pagamento).replace(",", ".") + "- PAGTO DUPL. N " + as2 + "                                                                                                                                                                                                                                                                                                  ");
                                        break;
                                    case 10:
                                        numero_valor_pagamento = Float.parseFloat(as3.replace(",", "."));
                                        String espacos10 = "                                      ";
                                        gravarArq.println("LC1" + nf_pagamento.format(a).replace(".", "") + "   " + "1" + as4.replace("/", "").replace("\n", "") + as2 + espacos10 + "29999" + as1.replace("-", "").replace(".", "").replace("/", "") + formato_cpf_pagamento + "00000" + conta + "              " + "00000" + format_pagamento.format(numero_valor_pagamento).replace(",", ".") + "- PAGTO DUPL. N " + as2 + "                                                                                                                                                                                                                                                                                                  ");
                                        break;

                                }

                            }

                            break;
                        default:

                            break;

                    }

                }

            }
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Importar dados");
            alerta.setContentText("Dados importados com sucesso!");
            alerta.show();
        }
    }

    @FXML
    private void buttonVerificar(ActionEvent event) throws FileNotFoundException, BiffException {
        try {
            Testelerexcel();
        } catch (SQLException | IOException | SAXException | ParserConfigurationException ex) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Erro ao executar");
            alerta.setContentText("Ocorreu um erro ao executar a tarefa! Erro: " + ex);
            alerta.show();
            
        }
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

    public void arquivoSave() throws IOException {
        Stage stage = programacontabil.primaryStage;
        FileChooser chooser = new FileChooser();
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text file (*.txt)", "*.txt"));
        file = chooser.showSaveDialog(stage);

    }

    public void Testelerexcel() throws SQLException, FileNotFoundException, IOException, SAXException, ParserConfigurationException, BiffException {
        array_caminho.clear();
        txtareaConf.clear();
        txtareaNumero.clear();
        txtareaValorPago.clear();
        txtareaDataPagto.clear();
        txtareaControle.clear();
        txtBanco.clear();
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
                Cell a5 = sheet.getCell(4, i);

                String as1 = a1.getContents();
                String as2 = a2.getContents();
                String as3 = a3.getContents();
                String as4 = a4.getContents();
                String as5 = a5.getContents();

                txtareaConf.setEditable(true);
                txtareaNumero.setEditable(true);
                txtareaValorPago.setEditable(true);
                txtareaDataPagto.setEditable(true);
                txtareaControle.setEditable(true);

                txtareaConf.appendText(as1 + "\n");
                txtareaNumero.appendText(as2 + "\n");
                txtareaValorPago.appendText(as3 + "\n");
                txtareaDataPagto.appendText(as4 + "\n");
                txtareaControle.appendText(as5 + "\n");

            }
        }
    }
}
