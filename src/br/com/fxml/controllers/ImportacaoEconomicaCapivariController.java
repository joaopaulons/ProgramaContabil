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
import javafx.scene.control.SplitPane;
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
public class ImportacaoEconomicaCapivariController implements Initializable {

    public static ArrayList array_caminho = new ArrayList<>();
    public static File file;
    public static String dados[] = new String[15];
    public static String choiceboxrec;
    public static String valorbanco;
    public static String linha;
    public static BufferedReader reader;
    public static File diretorio;
    public static int a = 0;

    @FXML
    private TextArea txtAreaDataVenc;
    @FXML
    private TextArea txtAreaNome;
    @FXML
    private TextArea txtDataMov;
    @FXML
    private TextArea txtAreaCodigoLoja;
    @FXML
    private TextArea txtAreaNumDoc;
    @FXML
    private TextArea txtAreaValor;
    @FXML
    private TextArea txtAreaPagamento;
    @FXML
    private TextArea txtAreaJuros;
    @FXML
    private TextArea txtAreaMulta;
    @FXML
    private TextArea txtAreaDesconto;
    @FXML
    private TextArea txtAreaTarifa;
    @FXML
    private TextArea txtAreaCredito;
    @FXML
    private TextArea txtAreaOutros;
    @FXML
    private TextField txtContaCredito;
    @FXML
    private SplitPane splitPaneContas;
    @FXML
    private TextArea txtAreaTerceiro;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void buttonVerificar(ActionEvent event) throws SAXException, IOException, ParserConfigurationException, BiffException {
        array_caminho.clear();
        txtAreaCodigoLoja.clear();
        txtAreaCredito.clear();
        txtAreaDataVenc.clear();
        txtAreaDesconto.clear();
        txtAreaJuros.clear();
        txtAreaMulta.clear();
        txtAreaNome.clear();
        txtAreaNumDoc.clear();
        txtAreaOutros.clear();
        txtAreaPagamento.clear();
        txtAreaTarifa.clear();
        txtAreaValor.clear();
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
                a++;
                Cell a1 = sheet.getCell(0, i);
                Cell a2 = sheet.getCell(1, i);
                Cell a3 = sheet.getCell(2, i);
                Cell a4 = sheet.getCell(3, i);
                Cell a5 = sheet.getCell(4, i);
                Cell a6 = sheet.getCell(5, i);
                Cell a7 = sheet.getCell(6, i);
                Cell a8 = sheet.getCell(7, i);
                Cell a9 = sheet.getCell(8, i);
                Cell a10 = sheet.getCell(9, i);
                Cell a11 = sheet.getCell(10, i);
                Cell a12 = sheet.getCell(11, i);

                String as1 = a1.getContents();
                String as2 = a2.getContents();
                String as3 = a3.getContents();
                String as4 = a4.getContents();
                String as5 = a5.getContents();
                String as6 = a6.getContents();
                String as7 = a7.getContents();
                String as8 = a8.getContents();
                String as9 = a9.getContents();
                String as10 = a10.getContents();
                String as11 = a11.getContents();
                String as12 = a12.getContents();

                txtAreaDataVenc.appendText(as1 + "\n");
                txtAreaNome.appendText(as2 + "\n");
                txtAreaTerceiro.appendText(as3 + "\n");
                txtDataMov.appendText(as4 + "\n");
                txtAreaNumDoc.appendText(as5 + "\n");
                txtAreaValor.appendText(as6 + "\n");
                txtAreaPagamento.appendText(as7 + "\n");
                txtAreaJuros.appendText(as8 + "\n");
                txtAreaMulta.appendText(as9 + "\n");
                txtAreaDesconto.appendText(as10 + "\n");
                txtAreaTarifa.appendText(as11 + "\n");
                txtAreaCredito.appendText(as12 + "\n");

            }
        }

    }

    @FXML
    private void butonImportar(ActionEvent event) throws IOException, SQLException, BiffException {
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
                Cell a7 = sheet.getCell(6, i);
                Cell a8 = sheet.getCell(7, i);
                Cell a9 = sheet.getCell(8, i);
                Cell a10 = sheet.getCell(9, i);
                Cell a11 = sheet.getCell(10, i);
                Cell a12 = sheet.getCell(11, i);

                String as1 = a1.getContents();
                String as2 = a2.getContents();
                String as3 = a3.getContents();
                String as4 = a4.getContents();
                String as5 = a5.getContents();
                String as6 = a6.getContents();
                String as7 = a7.getContents();
                String as8 = a8.getContents();
                String as9 = a9.getContents();
                String as10 = a10.getContents();
                String as11 = a11.getContents();
                String as12 = a12.getContents();

                try (FileWriter fw = new FileWriter(file, true); PrintWriter gravarArq = new PrintWriter(fw)) {

                    DecimalFormat formatvalor = new DecimalFormat("0000000000000.00");
                    NumberFormat nf = NumberFormat.getInstance();
                    nf.setMinimumIntegerDigits(5);
                    float teste;
                    String espaco = null;
                    String dados_10 = null;
                    if (as2.length() < 10) {
                        dados_10 = as2;
                        switch (as2.length()) {
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
                    } else {
                        espaco = "                                      ";
                        if (as2.length() > 10) {
                            dados_10 = as2.substring(0, 10);
                        }
                    }
                    switch (as3.length()) {
                        case 14:
                            teste = Float.parseFloat(as6.replace(".", "").replace(",", "."));
                            gravarArq.println("LC1" + nf.format(a).replace(".", "") + "   " + "1" + as1.replace("Data", "").replace("/", "").replace("\n", "") + dados_10 + espaco + "29999" + as3 + "00000" + txtContaCredito.getText() + "              " + "00000" + formatvalor.format(teste).replace(",", ".") + "- PAGAMENTO DUPLICATA" + "   " + as2 + "                                                                                                                                                                                                                                                                                                                  ");
                            break;
                        case 5:
                            teste = Float.parseFloat(as6.replace(".", "").replace(",", "."));
                            gravarArq.println("LC1" + nf.format(a).replace(".", "") + "   " + "1" + as1.replace("Data", "").replace("/", "").replace("\n", "") + dados_10 + espaco + as3 + "              " + "00000" + txtContaCredito.getText() + "              " + "00000" + formatvalor.format(teste).replace(",", ".") + "- PAGAMENTO DUPLICATA" + "   " + as2 + "                                                                                                                                                                                                                                                                                                                  ");
                            break;
                        case 11:
                            teste = Float.parseFloat(as6.replace(".", "").replace(",", "."));
                            gravarArq.println("LC1" + nf.format(a).replace(".", "") + "   " + "1" + as1.replace("Data", "").replace("/", "").replace("\n", "") + dados_10 + espaco + "29999" +as3 + "   " + "00000" + txtContaCredito.getText() + "              " + "00000" + formatvalor.format(teste).replace(",", ".") + "- PAGAMENTO DUPLICATA" + "   " + as2 + "                                                                                                                                                                                                                                                                                                                  ");
                            break;

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
        File caminhofolle = new File("Z:\\Importação CTB\\CTB - ALEATORIO");
        FileChooser chooser = new FileChooser();
        chooser.setInitialDirectory(caminhofolle);
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text file (*.txt)", "*.txt"));
        file = chooser.showSaveDialog(stage);

    }
}
