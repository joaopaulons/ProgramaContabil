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
import javafx.scene.control.Label;
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
public class ExtratoDrogaEcoCapivariController implements Initializable {

    public static ArrayList array_caminho = new ArrayList<>();
    public static File file;
    public static int linhas;
    public static BufferedReader reader;
    public static File diretorio;
    public static int a = 0;
    @FXML
    private TextArea txtAreaData;
    @FXML
    private TextArea txtAreaDocumento;
    @FXML
    private TextArea txtAreaHistorico;
    @FXML
    private TextArea txtAreaValor;
    @FXML
    private Label labelTxt1;
    @FXML
    private Label labelTxt2;
    @FXML
    private Label labelTxt3;
    @FXML
    private Label labelTxt4;
    @FXML
    private TextField txtContaDebito;
    @FXML
    private TextField txtContaCredito;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void buttonVerificar(ActionEvent event) throws IOException, BiffException, SAXException, ParserConfigurationException {
        txtAreaData.clear();
        txtAreaDocumento.clear();
        txtAreaHistorico.clear();
        txtAreaValor.clear();

        arrayOpen();
        for (Object caminho_ob : array_caminho) {
            diretorio = new File((String) caminho_ob);
            Workbook workbook = Workbook.getWorkbook(diretorio);
            Sheet sheet = workbook.getSheet(0);
            linhas = sheet.getRows();
            System.out.println("Iniciando a leitura da planilha XLS:");
            for (int i = 1; i < linhas; i++) {
                Cell a1 = sheet.getCell(0, i);
                Cell a2 = sheet.getCell(1, i);
                Cell a3 = sheet.getCell(2, i);
                Cell a4 = sheet.getCell(3, i);

                Cell titulo1 = sheet.getCell(0, 0);
                Cell titulo2 = sheet.getCell(1, 0);
                Cell titulo3 = sheet.getCell(2, 0);
                Cell titulo4 = sheet.getCell(3, 0);

                String t1 = titulo1.getContents();
                String t2 = titulo2.getContents();
                String t3 = titulo3.getContents();
                String t4 = titulo4.getContents();

                String as1 = a1.getContents();
                String as2 = a2.getContents();
                String as3 = a3.getContents();
                String as4 = a4.getContents();

                labelTxt1.setText(t1);
                labelTxt2.setText(t2);
                labelTxt3.setText(t3);
                labelTxt4.setText(t4);

                if (as1.equals("") || as2.equals("") || as3.equals("") || as4.equals("")) {

                } else {
                    switch (as3) {
                        case "CRÉD.TED-STR":
                            as3 = as3.replace("CRÉD.TED-STR", "DEPOSITO");
                            break;
                        case "CREDITO COMPRA MAESTRO-CIELO":
                            as3 = as3.replace("CREDITO COMPRA MAESTRO-CIELO", "DEPOSITO");
                            break;
                        case "CREDITO COMPRA VISA ELECTRON-CIELO":
                            as3 = as3.replace("CREDITO COMPRA VISA ELECTRON-CIELO", "DEPOSITO");
                            break;
                        case "CREDITO COMPRA VISA-CIELO":
                            as3 = as3.replace("CREDITO COMPRA VISA-CIELO", "DEPOSITO");
                            break;
                        case "CREDITO COMPRA MASTERCARD-CIELO":
                            as3 = as3.replace("CREDITO COMPRA MASTERCARD-CIELO", "DEPOSITO");
                            break;
                        case "RECEBIMENTO FORNECEDOR MAPA ADM DE CONVENIOS E CARTOES":
                            as3 = as3.replace("RECEBIMENTO FORNECEDOR MAPA ADM DE CONVENIOS E CARTOES", "DEPOSITO");
                            break;
                        case "RECEBIMENTO FORNECEDOR FUNCIONAL CARD LTDA":
                            as3 = as3.replace("RECEBIMENTO FORNECEDOR FUNCIONAL CARD LTDA", "DEPOSITO");
                            break;
                        case "RECEBIMENTO FORNECEDOR BCO BRADESCO CARTOES S/A PAGFOR":
                            as3 = as3.replace("RECEBIMENTO FORNECEDOR BCO BRADESCO CARTOES S/A PAGFOR", "DEPOSITO");
                            break;
                        case "RECEBIMENTO FORNECEDOR SOROCRED MEIOS DE PAGAMENTOS LTD":
                            as3 = as3.replace("RECEBIMENTO FORNECEDOR SOROCRED MEIOS DE PAGAMENTOS LTD", "DEPOSITO");
                            break;
                        case "REDE MASTER CREDITO REDECARD S A":
                            as3 = as3.replace("REDE MASTER CREDITO REDECARD S A", "DEPOSITO");
                            break;
                        case "REDE HIPER CRED REDECARD S A":
                            as3 = as3.replace("REDE HIPER CRED REDECARD S A", "DEPOSITO");
                            break;
                        case "REDE VISA CREDITO REDECARD S A":
                            as3 = as3.replace("REDE VISA CREDITO REDECARD S A", "DEPOSITO");
                            break;
                        case "REDE VISA DEBITO REDECARD S/A":
                            as3 = as3.replace("REDE VISA DEBITO REDECARD S/A", "DEPOSITO");
                            break;
                        case "TED-TRANSF ELET DISPON REMET.GOLDEN FARMA SIST CO":
                            as3 = as3.replace("TED-TRANSF ELET DISPON REMET.GOLDEN FARMA SIST CO", "DEPOSITO");
                            break;
                        case "RECEBIMENTO FORNECEDOR FAMILLY CARD ADMINISTRADORA DE C":
                            as3 = as3.replace("RECEBIMENTO FORNECEDOR FAMILLY CARD ADMINISTRADORA DE C", "DEPOSITO");
                            break;
                        case "RECEBIMENTO FORNECEDOR VIDALINK DO BRASIL SA":
                            as3 = as3.replace("RECEBIMENTO FORNECEDOR VIDALINK DO BRASIL SA", "DEPOSITO");
                            break;
                        case "RECEBIMENTO FORNECEDOR FUNCIONAL CARD":
                            as3 = as3.replace("RECEBIMENTO FORNECEDOR FUNCIONAL CARD", "DEPOSITO");
                            break;
                        case "TED-TRANSF ELET DISPON REMET.BANCO SANTANDER S.A.":
                            as3 = as3.replace("TED-TRANSF ELET DISPON REMET.BANCO SANTANDER S.A.", "DEPOSITO");
                            break;
                        case "RECEBIMENTO FORNECEDOR MAPA ADM DE CONVENIOS E CARTOE":
                            as3 = as3.replace("RECEBIMENTO FORNECEDOR MAPA ADM DE CONVENIOS E CARTOE", "DEPOSITO");
                            break;
                        case "TED-TRANSF ELET DISPON REMET.UNIMED DE CAPIVARI":
                            as3 = as3.replace("TED-TRANSF ELET DISPON REMET.UNIMED DE CAPIVARI", "DEPOSITO");
                            break;
                        case "TRANSF CC PARA CC PJ MICROSAL INDUSTRIA E COMERCIO LT":
                            as3 = as3.replace("TRANSF CC PARA CC PJ MICROSAL INDUSTRIA E COMERCIO LT", "DEPOSITO");
                            break;
                        case "TED-TRANSF ELET DISPON REMET.VIDALINK DO BRASIL S":
                            as3 = as3.replace("TED-TRANSF ELET DISPON REMET.VIDALINK DO BRASIL S", "DEPOSITO");
                            break;
                        case "DOC CREDITO AUTOMATICO* CLAUDIA GOMES RODRIGUES":
                            as3 = as3.replace("DOC CREDITO AUTOMATICO* CLAUDIA GOMES RODRIGUES", "DEPOSITO");
                            break;
                        case "RECEBIMENTO FORNECEDOR FAMILLY CARD ADMINISTRADORA DE":
                            as3 = as3.replace("RECEBIMENTO FORNECEDOR FAMILLY CARD ADMINISTRADORA DE", "DEPOSITO");
                            break;
                        default:
                            break;
                    }

                    txtAreaData.appendText(as1 + "\n");
                    txtAreaDocumento.appendText(as2 + "\n");
                    txtAreaHistorico.appendText(as3 + "\n");
                    txtAreaValor.appendText(as4.replace("C", "").replace("*", "").replace("D", "") + "\n");

                }

            }
        }
    }

    @FXML
    private void buttonImportar(ActionEvent event) throws IOException, BiffException {
        a = 0;
        arquivoSave();
        for (Object caminho_ob : array_caminho) {
            diretorio = new File((String) caminho_ob);
            Workbook workbook = Workbook.getWorkbook(diretorio);
            Sheet sheet = workbook.getSheet(0);
            linhas = sheet.getRows();
            System.out.println("Iniciando a leitura da planilha XLS:");
            for (int i = 1; i < linhas; i++) {
                a++;
                String deposito = "- DEPOSITO";
                Cell titulo1 = sheet.getCell(0, 0);
                Cell titulo2 = sheet.getCell(1, 0);
                Cell titulo3 = sheet.getCell(2, 0);
                Cell titulo4 = sheet.getCell(3, 0);

                String t1 = titulo1.getContents();
                String t2 = titulo2.getContents();
                String t3 = titulo3.getContents();
                String t4 = titulo4.getContents();

                Cell a1 = sheet.getCell(0, i);
                Cell a2 = sheet.getCell(1, i);
                Cell a3 = sheet.getCell(2, i);
                Cell a4 = sheet.getCell(3, i);

                String as1 = a1.getContents();
                String as2 = a2.getContents();
                String as3 = a3.getContents();
                String as4 = a4.getContents();

                labelTxt1.setText(t1);
                labelTxt2.setText(t2);
                labelTxt3.setText(t3);
                labelTxt4.setText(t4);
                if (t2.equals("DOCUMENTO")) {
                    if (as1.equals("") || as2.equals("") || as3.equals("") || as4.equals("")) {
                        a = a - 1;
                    } else {
                        switch (as3) {
                            case "CRÉD.TED-STR":
                                as3 = as3.replace("CRÉD.TED-STR", "DEPOSITO");
                                break;
                            case "CREDITO COMPRA MAESTRO-CIELO":
                                as3 = as3.replace("CREDITO COMPRA MAESTRO-CIELO", "DEPOSITO");
                                break;
                            case "CREDITO COMPRA VISA ELECTRON-CIELO":
                                as3 = as3.replace("CREDITO COMPRA VISA ELECTRON-CIELO", "DEPOSITO");
                                break;
                            case "CREDITO COMPRA VISA-CIELO":
                                as3 = as3.replace("CREDITO COMPRA VISA-CIELO", "DEPOSITO");
                                break;
                            case "CREDITO COMPRA MASTERCARD-CIELO":
                                as3 = as3.replace("CREDITO COMPRA MASTERCARD-CIELO", "DEPOSITO");
                                break;
                            case "RECEBIMENTO FORNECEDOR MAPA ADM DE CONVENIOS E CARTOES":
                                as3 = as3.replace("RECEBIMENTO FORNECEDOR MAPA ADM DE CONVENIOS E CARTOES", "DEPOSITO");
                                break;
                            case "RECEBIMENTO FORNECEDOR FUNCIONAL CARD LTDA":
                                as3 = as3.replace("RECEBIMENTO FORNECEDOR FUNCIONAL CARD LTDA", "DEPOSITO");
                                break;
                            case "RECEBIMENTO FORNECEDOR BCO BRADESCO CARTOES S/A PAGFOR":
                                as3 = as3.replace("RECEBIMENTO FORNECEDOR BCO BRADESCO CARTOES S/A PAGFOR", "DEPOSITO");
                                break;
                            case "RECEBIMENTO FORNECEDOR SOROCRED MEIOS DE PAGAMENTOS LTD":
                                as3 = as3.replace("RECEBIMENTO FORNECEDOR SOROCRED MEIOS DE PAGAMENTOS LTD", "DEPOSITO");
                                break;
                            case "REDE MASTER CREDITO REDECARD S A":
                                as3 = as3.replace("REDE MASTER CREDITO REDECARD S A", "DEPOSITO");
                                break;
                            case "REDE HIPER CRED REDECARD S A":
                                as3 = as3.replace("REDE HIPER CRED REDECARD S A", "DEPOSITO");
                                break;
                            case "REDE VISA CREDITO REDECARD S A":
                                as3 = as3.replace("REDE VISA CREDITO REDECARD S A", "DEPOSITO");
                                break;
                            case "REDE VISA DEBITO REDECARD S/A":
                                as3 = as3.replace("REDE VISA DEBITO REDECARD S/A", "DEPOSITO");
                                break;
                            case "TED-TRANSF ELET DISPON REMET.GOLDEN FARMA SIST CO":
                                as3 = as3.replace("TED-TRANSF ELET DISPON REMET.GOLDEN FARMA SIST CO", "DEPOSITO");
                                break;
                            case "RECEBIMENTO FORNECEDOR FAMILLY CARD ADMINISTRADORA DE C":
                                as3 = as3.replace("RECEBIMENTO FORNECEDOR FAMILLY CARD ADMINISTRADORA DE C", "DEPOSITO");
                                break;
                            case "RECEBIMENTO FORNECEDOR VIDALINK DO BRASIL SA":
                                as3 = as3.replace("RECEBIMENTO FORNECEDOR VIDALINK DO BRASIL SA", "DEPOSITO");
                                break;
                            case "RECEBIMENTO FORNECEDOR FUNCIONAL CARD":
                                as3 = as3.replace("RECEBIMENTO FORNECEDOR FUNCIONAL CARD", "DEPOSITO");
                                break;
                            case "TED-TRANSF ELET DISPON REMET.BANCO SANTANDER S.A.":
                                as3 = as3.replace("TED-TRANSF ELET DISPON REMET.BANCO SANTANDER S.A.", "DEPOSITO");
                                break;
                            case "RECEBIMENTO FORNECEDOR MAPA ADM DE CONVENIOS E CARTOE":
                                as3 = as3.replace("RECEBIMENTO FORNECEDOR MAPA ADM DE CONVENIOS E CARTOE", "DEPOSITO");
                                break;
                            case "TED-TRANSF ELET DISPON REMET.UNIMED DE CAPIVARI":
                                as3 = as3.replace("TED-TRANSF ELET DISPON REMET.UNIMED DE CAPIVARI", "DEPOSITO");
                                break;
                            case "TRANSF CC PARA CC PJ MICROSAL INDUSTRIA E COMERCIO LT":
                                as3 = as3.replace("TRANSF CC PARA CC PJ MICROSAL INDUSTRIA E COMERCIO LT", "DEPOSITO");
                                break;
                            case "TED-TRANSF ELET DISPON REMET.VIDALINK DO BRASIL S":
                                as3 = as3.replace("TED-TRANSF ELET DISPON REMET.VIDALINK DO BRASIL S", "DEPOSITO");
                                break;
                            case "DOC CREDITO AUTOMATICO* CLAUDIA GOMES RODRIGUES":
                                as3 = as3.replace("DOC CREDITO AUTOMATICO* CLAUDIA GOMES RODRIGUES", "DEPOSITO");
                                break;
                            case "RECEBIMENTO FORNECEDOR FAMILLY CARD ADMINISTRADORA DE":
                                as3 = as3.replace("RECEBIMENTO FORNECEDOR FAMILLY CARD ADMINISTRADORA DE", "DEPOSITO");
                                break;
                            case "CR COMPRAS CRE OUTRAS BANDEIRAS-CIELO":
                                as3 = as3.replace("CR COMPRAS CRE OUTRAS BANDEIRAS-CIELO", "DEPOSITO");
                                break;
                            case "CR COMPRAS DEB OUTRAS BANDEIRAS-CIELO":
                                as3 = as3.replace("CR COMPRAS DEB OUTRAS BANDEIRAS-CIELO", "DEPOSITO");
                                break;
                            case "CRÉD.LIQUIDAÇÃO COBRANÇA":
                                as3 = as3.replace("CRÉD.LIQUIDAÇÃO COBRANÇA", "DEPOSITO");
                            default:
                                break;
                        }
                        try (FileWriter fw = new FileWriter(file, true); PrintWriter gravarArq = new PrintWriter(fw)) {
                            as4 = as4.replace("C", "").replace("D", "").replace("*", "");

                            DecimalFormat formatvalor = new DecimalFormat("0000000000000.00");
                            DecimalFormat formatnf = new DecimalFormat("00000");
                            NumberFormat nf = NumberFormat.getInstance();
                            nf.setMinimumIntegerDigits(5);
                            float formatar_valor = Float.parseFloat(as4.replace(".", "").replace(",", "."));
                            String espaco = "                                      ";
                            String format_as2 = as2;
                            if (format_as2.length() > 10) {
                                format_as2 = format_as2.substring(0, 10);
                            } else {
                                switch (format_as2.length()) {
                                    case 1:
                                        espaco = "                                               ";
                                        break;
                                    case 2:
                                        espaco = "                                              ";
                                        break;
                                    case 3:
                                        espaco = "                                             ";
                                        break;
                                    case 4:
                                        espaco = "                                            ";
                                        break;
                                    case 5:
                                        espaco = "                                           ";
                                        break;
                                    case 6:
                                        espaco = "                                          ";
                                        break;
                                    case 7:
                                        espaco = "                                         ";
                                        break;
                                    case 8:
                                        espaco = "                                        ";
                                        break;
                                    case 9:
                                        espaco = "                                       ";
                                        break;
                                    case 10:
                                        espaco = "                                      ";
                                        break;
                                    default:

                                        break;
                                }
                            }

                            gravarArq.println("LC1" + nf.format(a).replace(".", "") + "   " + "1" + as1.replace("/", "") + as2 + espaco + txtContaDebito.getText() + "              " + "00000" + txtContaCredito.getText() + "              " + "00000" + formatvalor.format(formatar_valor).replace(",", ".") + "-" + " " + as3 + "                                                                                                                                                                                                                                                                                                                  ");
                        }
                    }
                } else if (t2.equals("Lançamento")) {
                    if (as1.equals("") || as2.equals("") || as3.equals("") || as4.equals("")) {
                        a = a - 1;
                    } else {
                        switch (as2) {
                            case "CRÉD.TED-STR":
                                as2 = as2.replace("CRÉD.TED-STR", "DEPOSITO");
                                break;
                            case "CREDITO COMPRA MAESTRO-CIELO":
                                as2 = as2.replace("CREDITO COMPRA MAESTRO-CIELO", "DEPOSITO");
                                break;
                            case "CREDITO COMPRA VISA ELECTRON-CIELO":
                                as2 = as2.replace("CREDITO COMPRA VISA ELECTRON-CIELO", "DEPOSITO");
                                break;
                            case "CREDITO COMPRA VISA-CIELO":
                                as2 = as2.replace("CREDITO COMPRA VISA-CIELO", "DEPOSITO");
                                break;
                            case "CREDITO COMPRA MASTERCARD-CIELO":
                                as2 = as2.replace("CREDITO COMPRA MASTERCARD-CIELO", "DEPOSITO");
                                break;
                            case "RECEBIMENTO FORNECEDOR MAPA ADM DE CONVENIOS E CARTOES":
                                as2 = as2.replace("RECEBIMENTO FORNECEDOR MAPA ADM DE CONVENIOS E CARTOES", "DEPOSITO");
                                break;
                            case "RECEBIMENTO FORNECEDOR FUNCIONAL CARD LTDA":
                                as2 = as2.replace("RECEBIMENTO FORNECEDOR FUNCIONAL CARD LTDA", "DEPOSITO");
                                break;
                            case "RECEBIMENTO FORNECEDOR BCO BRADESCO CARTOES S/A PAGFOR":
                                as2 = as2.replace("RECEBIMENTO FORNECEDOR BCO BRADESCO CARTOES S/A PAGFOR", "DEPOSITO");
                                break;
                            case "RECEBIMENTO FORNECEDOR SOROCRED MEIOS DE PAGAMENTOS LTD":
                                as2 = as2.replace("RECEBIMENTO FORNECEDOR SOROCRED MEIOS DE PAGAMENTOS LTD", "DEPOSITO");
                                break;
                            case "REDE MASTER CREDITO REDECARD S A":
                                as2 = as2.replace("REDE MASTER CREDITO REDECARD S A", "DEPOSITO");
                                break;
                            case "REDE HIPER CRED REDECARD S A":
                                as2 = as2.replace("REDE HIPER CRED REDECARD S A", "DEPOSITO");
                                break;
                            case "REDE VISA CREDITO REDECARD S A":
                                as2 = as2.replace("REDE VISA CREDITO REDECARD S A", "DEPOSITO");
                                break;
                            case "REDE VISA DEBITO REDECARD S/A":
                                as2 = as2.replace("REDE VISA DEBITO REDECARD S/A", "DEPOSITO");
                                break;
                            case "TED-TRANSF ELET DISPON REMET.GOLDEN FARMA SIST CO":
                                as2 = as2.replace("TED-TRANSF ELET DISPON REMET.GOLDEN FARMA SIST CO", "DEPOSITO");
                                break;
                            case "RECEBIMENTO FORNECEDOR FAMILLY CARD ADMINISTRADORA DE C":
                                as2 = as2.replace("RECEBIMENTO FORNECEDOR FAMILLY CARD ADMINISTRADORA DE C", "DEPOSITO");
                                break;
                            case "RECEBIMENTO FORNECEDOR VIDALINK DO BRASIL SA":
                                as2 = as2.replace("RECEBIMENTO FORNECEDOR VIDALINK DO BRASIL SA", "DEPOSITO");
                                break;
                            case "RECEBIMENTO FORNECEDOR FUNCIONAL CARD":
                                as2 = as2.replace("RECEBIMENTO FORNECEDOR FUNCIONAL CARD", "DEPOSITO");
                                break;
                            case "RECEBIMENTO FORNECEDOR BANCO TOPAZIO S/A":
                                as2 = as2.replace("RECEBIMENTO FORNECEDOR BANCO TOPAZIO S/A", "DEPOSITO");
                                break;
                            case "TED-TRANSF ELET DISPON REMET.BANCO SANTANDER S.A.":
                                as2 = as2.replace("TED-TRANSF ELET DISPON REMET.BANCO SANTANDER S.A.", "DEPOSITO");
                                break;
                            case "RECEBIMENTO FORNECEDOR MAPA ADM DE CONVENIOS E CARTOE":
                                as2 = as2.replace("RECEBIMENTO FORNECEDOR MAPA ADM DE CONVENIOS E CARTOE", "DEPOSITO");
                                break;
                            case "TED-TRANSF ELET DISPON REMET.UNIMED DE CAPIVARI":
                                as2 = as2.replace("TED-TRANSF ELET DISPON REMET.UNIMED DE CAPIVARI", "DEPOSITO");
                                break;
                            case "TRANSF CC PARA CC PJ MICROSAL INDUSTRIA E COMERCIO LT":
                                as2 = as2.replace("TRANSF CC PARA CC PJ MICROSAL INDUSTRIA E COMERCIO LT", "DEPOSITO");
                                break;
                            case "TED-TRANSF ELET DISPON REMET.VIDALINK DO BRASIL S":
                                as2 = as2.replace("TED-TRANSF ELET DISPON REMET.VIDALINK DO BRASIL S", "DEPOSITO");
                                break;
                            case "DOC CREDITO AUTOMATICO* CLAUDIA GOMES RODRIGUES":
                                as2 = as2.replace("DOC CREDITO AUTOMATICO* CLAUDIA GOMES RODRIGUES", "DEPOSITO");
                                break;
                            case "RECEBIMENTO FORNECEDOR FAMILLY CARD ADMINISTRADORA DE":
                                as2 = as2.replace("RECEBIMENTO FORNECEDOR FAMILLY CARD ADMINISTRADORA DE", "DEPOSITO");
                                break;

                            default:
                                break;
                        }
                        try (FileWriter fw = new FileWriter(file, true); PrintWriter gravarArq = new PrintWriter(fw)) {
                            as4 = as4.replace("C", "").replace("D", "").replace("*", "");
                            DecimalFormat formatvalor = new DecimalFormat("0000000000000.00");
                            DecimalFormat formatnf = new DecimalFormat("00000");
                            NumberFormat nf = NumberFormat.getInstance();
                            nf.setMinimumIntegerDigits(5);
                            float formatar_valor = Float.parseFloat(as4.replace(".", "").replace(",", "."));
                            String espaco = "                                      ";
                            String format_as3 = as3;
                            if (format_as3.length() > 10) {
                                format_as3 = format_as3.substring(0, 10);
                            } else {
                                switch (format_as3.length()) {
                                    case 1:
                                        espaco = "                                               ";
                                        break;
                                    case 2:
                                        espaco = "                                              ";
                                        break;
                                    case 3:
                                        espaco = "                                             ";
                                        break;
                                    case 4:
                                        espaco = "                                            ";
                                        break;
                                    case 5:
                                        espaco = "                                           ";
                                        break;
                                    case 6:
                                        espaco = "                                          ";
                                        break;
                                    case 7:
                                        espaco = "                                         ";
                                        break;
                                    case 8:
                                        espaco = "                                        ";
                                        break;
                                    case 9:
                                        espaco = "                                       ";
                                        break;
                                    case 10:
                                        espaco = "                                      ";
                                        break;
                                    default:

                                        break;
                                }
                            }

                            gravarArq.println("LC1" + nf.format(a).replace(".", "") + "   " + "1" + as1.replace("/", "") + format_as3 + espaco + txtContaDebito.getText() + "              " + "00000" + txtContaCredito.getText() + "              " + "00000" + formatvalor.format(formatar_valor).replace(",", ".") + "-" + " " + as2 + "                                                                                                                                                                                                                                                                                                                  ");
                        }
                    }
                } else if (t2.equals("ID. DOC")) {
                    if (as1.equals("") || as2.equals("") || as3.equals("") || as4.equals("") || as4.contains("-")) {
                        a = a - 1;
                    } else {
                        try (FileWriter fw = new FileWriter(file, true); PrintWriter gravarArq = new PrintWriter(fw)) {
                            as4 = as4.replace("C", "").replace("D", "").replace("*", "");
                            DecimalFormat formatvalor = new DecimalFormat("0000000000000.00");
                            DecimalFormat formatnf = new DecimalFormat("00000");
                            NumberFormat nf = NumberFormat.getInstance();
                            nf.setMinimumIntegerDigits(5);
                            float formatar_valor = Float.parseFloat(as4.replace(".", "").replace(",", "."));
                            String espaco = "                                      ";
                            String format_as2 = as2;
                            if (format_as2.length() > 10) {
                                format_as2 = format_as2.substring(0, 10);
                            } else {
                                switch (format_as2.length()) {
                                    case 1:
                                        espaco = "                                               ";
                                        break;
                                    case 2:
                                        espaco = "                                              ";
                                        break;
                                    case 3:
                                        espaco = "                                             ";
                                        break;
                                    case 4:
                                        espaco = "                                            ";
                                        break;
                                    case 5:
                                        espaco = "                                           ";
                                        break;
                                    case 6:
                                        espaco = "                                          ";
                                        break;
                                    case 7:
                                        espaco = "                                         ";
                                        break;
                                    case 8:
                                        espaco = "                                        ";
                                        break;
                                    case 9:
                                        espaco = "                                       ";
                                        break;
                                    case 10:
                                        espaco = "                                      ";
                                        break;
                                    default:

                                        break;
                                }
                            }

                            gravarArq.println("LC1" + nf.format(a).replace(".", "") + "   " + "1" + as1.replace("/", "") + format_as2 + espaco + txtContaDebito.getText() + "              " + "00000" + txtContaCredito.getText() + "              " + "00000" + formatvalor.format(formatar_valor).replace(",", ".") + "-" + " " + as3 + "                                                                                                                                                                                                                                                                                                                  ");
                        }
                    }
                }
            }
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
        File caminhofolle = new File("Z:\\Importação CTB\\CTB - Folle");
        FileChooser chooser = new FileChooser();
        chooser.setInitialDirectory(caminhofolle);
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text file (*.txt)", "*.txt"));
        file = chooser.showSaveDialog(stage);

    }
}
