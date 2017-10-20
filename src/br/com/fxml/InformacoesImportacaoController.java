/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fxml;

import static br.com.fxml.ImportacaoFerrariFolleController.a;
import static br.com.fxml.ImportacaoFerrariFolleController.array_caminho;
import static br.com.fxml.ImportacaoFerrariFolleController.dados;
import static br.com.fxml.ImportacaoFerrariFolleController.diretorio;
import static br.com.fxml.ImportacaoFerrariFolleController.file;
import static br.com.fxml.ImportacaoFerrariFolleController.linha;
import static br.com.fxml.ImportacaoFerrariFolleController.reader;
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
import java.text.NumberFormat;
import java.util.List;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
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
import org.xml.sax.SAXException;

/**
 * FXML Controller class
 *
 * @author joao.santos
 */
public class InformacoesImportacaoController implements Initializable {

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
    private void buttonImportar(ActionEvent event) throws IOException, SQLException {
        arquivoSave();
        for (Object caminho_ob : array_caminho) {
            diretorio = new File((String) caminho_ob);
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

                try (FileWriter fw = new FileWriter(file, true); PrintWriter gravarArq = new PrintWriter(fw)) {
                    String escolha = choiceBoxRecPag.getValue();

                    switch (choiceBoxRecPag.getValue()) {
                        case "Recebimento":
                            NumberFormat nf = NumberFormat.getInstance();
                            nf.setMinimumIntegerDigits(5);
                            if (dados[2].length() > 10) {
                                dados[2] = dados[2].substring(0, 10);
                            } else {
                                if (dados[1].equals("Inscricao") || (dados[2].equals("SeuNumero") || (dados[3].equals("ValorPago") || (dados[4].equals("DtPgtoBx") || dados[5].equals("Controle"))))) {
                                    a = 0;
                                } else {
                                    if (dados[1].contains("*")){
                                                System.out.println("funcionou");
                                            }
                                    switch(dados[2].length()){
                                        case 1:
                                            String espacos1 = "                                               ";
                                            System.out.println("LC1" + nf.format(a).replace(".", "") + "   " + "1" + dados[4].replace("/", "").replace("\n", "") + dados[2] + "     " + espacos1 + "29999" + dados[1].replace("-", "").replace(".", "").replace("/", "") + "00000");
                                            break;
                                        case 2:
                                            String espacos2 = "                                              ";
                                            System.out.println("LC1" + nf.format(a).replace(".", "") + "   " + "1" + dados[4].replace("/", "").replace("\n", "") + dados[2] + "     " + espacos2 + "29999" + dados[1].replace("-", "").replace(".", "").replace("/", "") + "00000");
                                            break;
                                        case 3:
                                            String espacos3 = "                                             ";
                                            System.out.println("LC1" + nf.format(a).replace(".", "") + "   " + "1" + dados[4].replace("/", "").replace("\n", "") + dados[2] + "     " + espacos3 + "29999" + dados[1].replace("-", "").replace(".", "").replace("/", "") + "00000");
                                            break;
                                        case 4:
                                            String espacos4 = "                                            ";
                                            System.out.println("LC1" + nf.format(a).replace(".", "") + "   " + "1" + dados[4].replace("/", "").replace("\n", "") + dados[2] + "     " + espacos4 + "29999" + dados[1].replace("-", "").replace(".", "").replace("/", "") + "00000");
                                            break;
                                        case 5:
                                            String espacos5 = "                                           ";
                                            System.out.println("LC1" + nf.format(a).replace(".", "") + "   " + "1" + dados[4].replace("/", "").replace("\n", "") + dados[2] + "     " + espacos5 + "29999" + dados[1].replace("-", "").replace(".", "").replace("/", "") + "00000");
                                            break;
                                        case 6:
                                            String espacos6 = "                                          ";
                                            System.out.println("LC1" + nf.format(a).replace(".", "") + "   " + "1" + dados[4].replace("/", "").replace("\n", "") + dados[2] + "     " + espacos6 + "29999" + dados[1].replace("-", "").replace(".", "").replace("/", "") + "00000");
                                            break;
                                        case 7:
                                            String espacos7 = "                                         ";
                                            System.out.println("LC1" + nf.format(a).replace(".", "") + "   " + "1" + dados[4].replace("/", "").replace("\n", "") + dados[2] + "     " + espacos7 + "29999" + dados[1].replace("-", "").replace(".", "").replace("/", "") + "00000");
                                            break;
                                        case 8:
                                            String espacos8 = "                                        ";
                                            System.out.println("LC1" + nf.format(a).replace(".", "") + "   " + "1" + dados[4].replace("/", "").replace("\n", "") + dados[2] + "     " + espacos8 + "29999" + dados[1].replace("-", "").replace(".", "").replace("/", "") + "00000");
                                            break;
                                        case 9:
                                            String espacos9 = "                                       ";
                                            System.out.println("LC1" + nf.format(a).replace(".", "") + "   " + "1" + dados[4].replace("/", "").replace("\n", "") + dados[2] + "     " + espacos9 + "29999" + dados[1].replace("-", "").replace(".", "").replace("/", "") + "00000");
                                            break;
                                        case 10:
                                            String espacos10 = "                                      ";
                                            
                                            System.out.println("LC1" + nf.format(a).replace(".", "") + "   " + "1" + dados[4].replace("/", "").replace("\n", "") + dados[2] + "     " + espacos10 + "29999" + dados[1].replace("-", "").replace(".", "").replace("/", "") + "00000");
                                            break;
                                                    
                                                 
                                                   
                                    }
                                    // <editor-fold defaultstate="collapsed" desc="VARIÁVEL Espaço">
                                           
                                    
                                }
                            }
                            break;

                        case "Pagamento":
                            gravarArq.println(dados[1].replace("Inscricao", "").replace("-", "").replace(".", "").replace("/", "") + "");
                            break;
                        default:

                            break;

                    }

                }
                linha = reader.readLine();

            }
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Importar dados");
            alerta.setContentText("Dados importados com sucesso!");
            alerta.show();

        }
    }

    @FXML
    private void buttonVerificar(ActionEvent event
    ) {
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

    public void arquivoSave() throws IOException {
        Stage stage = programacontabil.primaryStage;
        FileChooser chooser = new FileChooser();
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text file (*.txt)", "*.txt"));
        file = chooser.showSaveDialog(stage);

    }

    public void Testelerexcel() throws SQLException, FileNotFoundException, IOException, SAXException, ParserConfigurationException {
        array_caminho.clear();
        txtareaConf.clear();
        txtareaNumero.clear();
        txtareaValorPago.clear();
        txtareaDataPagto.clear();
        txtareaControle.clear();
        txtBanco.clear();
        arrayOpen();
        for (Object caminho_ob : array_caminho) {
            diretorio = new File((String) caminho_ob);

            Connection con = ConnectionFactory.getConnection();
            Statement stm = con.createStatement();
            reader = new BufferedReader(new FileReader(diretorio));

            linha = reader.readLine();
            while (linha != null) {

                StringTokenizer st = new StringTokenizer(linha, "\t");
                dados[1] = st.nextToken();
                dados[2] = st.nextToken();
                dados[3] = st.nextToken();
                dados[4] = st.nextToken();
                dados[5] = st.nextToken();

                txtareaConf.setEditable(true);
                txtareaNumero.setEditable(true);
                txtareaValorPago.setEditable(true);
                txtareaDataPagto.setEditable(true);
                txtareaControle.setEditable(true);

                if (dados[1].equals("Inscricao") || (dados[2].equals("SeuNumero") || (dados[3].equals("ValorPago") || (dados[4].equals("DtPgtoBx") || dados[5].equals("Controle"))))) {

                } else {
                    txtareaConf.appendText(dados[1] + "\n");
                    txtareaNumero.appendText(dados[2] + "\n");
                    txtareaValorPago.appendText(dados[3] + "\n");
                    txtareaDataPagto.appendText(dados[4] + "\n");
                    txtareaControle.appendText(dados[5] + "\n");

                }
                linha = reader.readLine();

            }
        }
    }
}
