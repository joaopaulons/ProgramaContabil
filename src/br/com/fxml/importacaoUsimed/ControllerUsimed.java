/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fxml.importacaoUsimed;

import static br.com.alfacapa.controllers.alfaCapaControllers.file;
import static br.com.fxml.conciliacao.ConciliacaoContabilController.linhas;
import br.com.programacontabil;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.BooleanBinding;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
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
public class ControllerUsimed implements Initializable {

    public static ArrayList array_caminho = new ArrayList<>();
    public static File file;
    public static File diretorio;
    private UsimedPagamentoServices service;
    private UsimedConvenioServices serviceConvenio;
    private UsimedCartao183Services serviceCartao183;
    private UsimedCartao630Services serviceCartao630;
    private UsimedCartaoBBServices serviceCartaoBB;
    @FXML
    private TableColumn<UsimedPagamentoDADOS, String> colNumeroDocumento;
    @FXML
    private TableColumn<UsimedPagamentoDADOS, String> colContaBordero;
    @FXML
    private TableColumn<UsimedPagamentoDADOS, String> colDataPagamento;
    @FXML
    private TableColumn<UsimedPagamentoDADOS, String> colCedente;
    @FXML
    private TableColumn<UsimedPagamentoDADOS, String> colTotalPago;
    @FXML
    private TableColumn<UsimedPagamentoDADOS, String> colDescricao;
    @FXML
    private TableColumn<UsimedPagamentoDADOS, String> colDescontos;
    @FXML
    private TableColumn<UsimedPagamentoDADOS, String> colAcrescimos;
    @FXML
    private TableColumn<UsimedPagamentoDADOS, String> colTotal;
    @FXML
    private TableColumn<UsimedPagamentoDADOS, String> colBancoOrigem;
    @FXML
    private TableView<UsimedPagamentoDADOS> tablePagamento;
    @FXML
    private TextField txtNumeroDocumento;
    @FXML
    private TextField txtContaBordero;
    @FXML
    private TextField txtDataPagamento;
    @FXML
    private TextField txtCedente;
    @FXML
    private TextField txtTotalPago;
    @FXML
    private TextField txtDescricao;
    @FXML
    private TextField txtDescontos;
    @FXML
    private TextField txtAcrescimos;
    @FXML
    private TextField txtTotal;
    @FXML
    private TextField txtId;
    @FXML
    private TextField txtBancoOrigem;
    @FXML
    private Button btnAtualizar;
    @FXML
    private Button btnSalvar;
    @FXML
    private Button btnApagar;
    @FXML
    private Button btnBuscar;
    @FXML
    private Button btnLimpar;
    @FXML
    private Button btnFechar;
    @FXML
    private ChoiceBox<String> choiceBoxAbrirXLS;
    @FXML
    private ChoiceBox<String> choiceBoxImportacao;
    @FXML
    private Button btnAbrirXLS;
    @FXML
    private Button btnImportar;
    @FXML
    private Button btnEditarXLS;
    @FXML
    private HBox HBoxAbrirXLS;
    @FXML
    private HBox HBoxImportar;
    @FXML
    private TableView<UsimedConvenioDADOS> tableConvenio;
    @FXML
    private TextField txtEmissaoCONV;
    @FXML
    private TextField txtNumeroDocumentoCONV;
    @FXML
    private TextField txtNomePagadorCONV;
    @FXML
    private TextField txtValorCONV;
    @FXML
    private TextField txtInscricaoPagadorCONV;
    @FXML
    private TextField txtValorPagoCONV;
    @FXML
    private TextField txtDataCreditoCONV;
    @FXML
    private Button btnAtualizarCONV;
    @FXML
    private Button btnSalvarCONV;
    @FXML
    private Button btnApagarCONV;
    @FXML
    private Button btnBuscarCONV;
    @FXML
    private Button btnLimparCONV;
    @FXML
    private Button btnFecharCONV;
    @FXML
    private TextField txtValorDifCobradoCONV;
    @FXML
    private Group groupPagamento;
    @FXML
    private Group groupConvenio;
    @FXML
    private TableColumn<UsimedConvenioDADOS, String> colEmissaoCONV;
    @FXML
    private TableColumn<UsimedConvenioDADOS, String> colNumeroDocumentoCONV;
    @FXML
    private TableColumn<UsimedConvenioDADOS, String> colNomePagadorCONV;
    @FXML
    private TableColumn<UsimedConvenioDADOS, String> colValorCONV;
    @FXML
    private TableColumn<UsimedConvenioDADOS, String> colInscricaoPagadorCONV;
    @FXML
    private TableColumn<UsimedConvenioDADOS, String> colValorPagoCONV;
    @FXML
    private TableColumn<UsimedConvenioDADOS, String> colValorDifCobradaCONV;
    @FXML
    private TableColumn<UsimedConvenioDADOS, String> colDataCreditoCONV;
    @FXML
    private TableView<UsimedCartao183DADOS> tableCartao183;
    @FXML
    private TableColumn<UsimedCartao183DADOS, String> colDescricao183;
    @FXML
    private TableColumn<UsimedCartao183DADOS, String> colT183;
    @FXML
    private TableColumn<UsimedCartao183DADOS, String> colData183;
    @FXML
    private TableColumn<UsimedCartao183DADOS, String> colCredito183;
    @FXML
    private TableColumn<UsimedCartao183DADOS, String> colDebito183;
    @FXML
    private TableColumn<UsimedCartao183DADOS, String> colOrigem183;
    @FXML
    private Group groupCartao183;
    @FXML
    private TextField txtDescricao183;
    @FXML
    private TextField txtT183;
    @FXML
    private TextField txtData183;
    @FXML
    private TextField txtCredito183;
    @FXML
    private TextField txtDebito183;
    @FXML
    private TextField txtOrigem183;
    @FXML
    private Button btnAtualizar183;
    @FXML
    private Button btnSalvar183;
    @FXML
    private Button btnApagar183;
    @FXML
    private Button btnBuscar183;
    @FXML
    private Button btnLimpar183;
    @FXML
    private Button btnFechar183;
    @FXML
    private TableView<UsimedCartao630DADOS> tableCartao630;
    @FXML
    private TableColumn<UsimedCartao630DADOS, String> colDescricao630;
    @FXML
    private TableColumn<UsimedCartao630DADOS, String> colT630;
    @FXML
    private TableColumn<UsimedCartao630DADOS, String> colData630;
    @FXML
    private TableColumn<UsimedCartao630DADOS, String> colCredito630;
    @FXML
    private TableColumn<UsimedCartao630DADOS, String> colDebito630;
    @FXML
    private TableColumn<UsimedCartao630DADOS, String> colOrigem630;
    @FXML
    private Group groupCartao630;
    @FXML
    private TextField txtDescricao630;
    @FXML
    private TextField txtT630;
    @FXML
    private TextField txtData630;
    @FXML
    private TextField txtCredito630;
    @FXML
    private TextField txtDebito630;
    @FXML
    private TextField txtOrigem630;
    @FXML
    private Button btnAtualizar630;
    @FXML
    private Button btnSalvar630;
    @FXML
    private Button btnApagar630;
    @FXML
    private Button btnBuscar630;
    @FXML
    private Button btnLimpar630;
    @FXML
    private Button btnFechar630;
    @FXML
    private TableView<UsimedCartaoBBDados> tableCartaoBB;
    @FXML
    private TableColumn<UsimedCartaoBBDados, String> colDescricaoBB;
    @FXML
    private TableColumn<UsimedCartaoBBDados, String> colTBB;
    @FXML
    private TableColumn<UsimedCartaoBBDados, String> colDatabBB;
    @FXML
    private TableColumn<UsimedCartaoBBDados, String> colCreditoBB;
    @FXML
    private TableColumn<UsimedCartaoBBDados, String> colDebitoBB;
    @FXML
    private TableColumn<UsimedCartaoBBDados, String> colOrigemBB;
    @FXML
    private Group groupCartaoBB;
    @FXML
    private TextField txtDescricaoBB;
    @FXML
    private TextField txtTBB;
    @FXML
    private TextField txtDataBB;
    @FXML
    private TextField txtCreditoBB;
    @FXML
    private TextField txtDebitoBB;
    @FXML
    private TextField txtOrigemBB;
    @FXML
    private Button btnAtualizarBB;
    @FXML
    private Button btnSalvarBB;
    @FXML
    private Button btnApagarBB;
    @FXML
    private Button btnBuscarBB;
    @FXML
    private Button btnLimparBB;
    @FXML
    private Button btnFecharBB;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        choiceBoxAbrirXLS.setItems(FXCollections.observableArrayList(
                "Pagamento", "Convenio", "Cartão 183", "Cartão 630", "Cartão BB")
        );
        choiceBoxImportacao.setItems(FXCollections.observableArrayList(
                "Pagamento", "Pagamento/Descontos", "Pagamento/Juros", "Recebimento", "Recebimento/Descontos", "Recebimento/Juros")
        );
        serviceConvenio = UsimedConvenioServices.getNewInstance();
        service = UsimedPagamentoServices.getNewInstance();
        serviceCartao183 = UsimedCartao183Services.getNewInstance();
        serviceCartao630 = UsimedCartao630Services.getNewInstance();
        serviceCartaoBB = UsimedCartaoBBServices.getNewInstance();
        configuraColunas();
        configuraColunasConvenio();
        configuraColunasCartao183();
        configuraColunasCartao630();

        configuraBindings();
        configuraBindingsConvenio();
        ConfiguraBindingsCartao183();
        ConfiguraBindingsCartao630();

        atualizaDadosTabela();
        atualizaTableConvenio();
        atualizaTableCartao183();
        atualizaTableCartao630();

        atualizaTableCartaoBB();
        configuraColunasCartaoBB();
        ConfiguraBindingsCartaoBB();
    }

    @FXML
    private void buttonAbrirXLS(ActionEvent event) throws SAXException, IOException, ParserConfigurationException, BiffException, SQLException {
        if (choiceBoxAbrirXLS.getValue() == null) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Escolha uma opção");
            alerta.setContentText("Escolha uma das opções antes de prosseguir!");
            alerta.showAndWait();
        } else {
            switch (choiceBoxAbrirXLS.getValue()) {
                case "Pagamento":
                    Pagamento();
                    break;
                case "Convenio":
                    Convenio();
                    break;
                case "Cartão 183":
                    Cartao183();
                    break;
                case "Cartão 630":
                    Cartao630();
                    break;
                case "Cartão BB":
                    CartaoBB();
                    break;
                default:

                    break;
            }
        }
    }

    @FXML
    private void buttonImportar(ActionEvent event) {
        if (choiceBoxImportacao.getValue() == null) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Escolha uma opção");
            alerta.setContentText("Escolha uma das opções antes de prosseguir!");
            alerta.showAndWait();
        } else {
            switch (choiceBoxImportacao.getValue()) {
                case "Recebimento":
                    if (choiceBoxAbrirXLS.getValue().equals("Convenio")) {

                    } else if (choiceBoxAbrirXLS.getValue().equals("Cartão 630")) {

                    } else if (choiceBoxAbrirXLS.getValue().equals("Cartão 183")) {

                    } else if (choiceBoxAbrirXLS.getValue().equals("Cartão BB")) {

                    } else {

                    }
                    break;
                case "Recebimento/Juros":
                    if (choiceBoxAbrirXLS.getValue().equals("Convenio")) {

                    }
                    break;
                case "Recebimento/Descontos":
                    if (choiceBoxAbrirXLS.getValue().equals("Convenio")) {

                    }
                    break;
                case "Pagamento":
                    if (choiceBoxAbrirXLS.getValue().equals("Pagamento")) {
                        try {
                            arquivoSaveTxt();
                            ImportPagamento();
                        } catch (IOException ex) {
                            Logger.getLogger(ControllerUsimed.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
                case "Pagamento/Juros":

                    break;
                case "Pagamento/Descontos":

                    break;
                default:

                    break;
            }
        }
    }

    @FXML
    private void buttonEditarXLS(ActionEvent event) {
        if (choiceBoxAbrirXLS.getValue() == null) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Escolha uma opção");
            alerta.setContentText("Escolha uma das opções antes de prosseguir!");
            alerta.showAndWait();
        } else {
            switch (choiceBoxAbrirXLS.getValue()) {
                case "Pagamento":
                    groupPagamento.setVisible(true);
                    tablePagamento.setVisible(true);
                    btnAbrirXLS.setVisible(false);
                    btnEditarXLS.setVisible(false);
                    btnImportar.setVisible(false);
                    HBoxAbrirXLS.setVisible(false);
                    HBoxImportar.setVisible(false);
                    break;
                case "Convenio":
                    groupConvenio.setVisible(true);
                    tableConvenio.setVisible(true);
                    btnAbrirXLS.setVisible(false);
                    btnEditarXLS.setVisible(false);
                    btnImportar.setVisible(false);
                    HBoxAbrirXLS.setVisible(false);
                    HBoxImportar.setVisible(false);
                    break;
                case "Cartão 183":
                    groupCartao183.setVisible(true);
                    tableCartao183.setVisible(true);
                    btnAbrirXLS.setVisible(false);
                    btnEditarXLS.setVisible(false);
                    btnImportar.setVisible(false);
                    HBoxAbrirXLS.setVisible(false);
                    HBoxImportar.setVisible(false);
                    break;
                case "Cartão 630":
                    groupCartao630.setVisible(true);
                    tableCartao630.setVisible(true);
                    btnAbrirXLS.setVisible(false);
                    btnEditarXLS.setVisible(false);
                    btnImportar.setVisible(false);
                    HBoxAbrirXLS.setVisible(false);
                    HBoxImportar.setVisible(false);
                    break;
                case "Cartão BB":
                    groupCartaoBB.setVisible(true);
                    tableCartaoBB.setVisible(true);
                    btnAbrirXLS.setVisible(false);
                    btnEditarXLS.setVisible(false);
                    btnImportar.setVisible(false);
                    HBoxAbrirXLS.setVisible(false);
                    HBoxImportar.setVisible(false);
                    break;
                default:

                    break;
            }
        }
        serviceConvenio = UsimedConvenioServices.getNewInstance();
        service = UsimedPagamentoServices.getNewInstance();
        serviceCartao183 = UsimedCartao183Services.getNewInstance();
        serviceCartao630 = UsimedCartao630Services.getNewInstance();
        configuraColunas();
        configuraColunasConvenio();
        configuraColunasCartao183();
        configuraColunasCartao630();
        configuraBindings();
        configuraBindingsConvenio();
        ConfiguraBindingsCartao183();
        ConfiguraBindingsCartao630();
        atualizaDadosTabela();
        atualizaTableConvenio();
        atualizaTableCartao183();
        atualizaTableCartao630();
    }

    // <editor-fold defaultstate="collapsed" desc="ABRIR ARQUIVOS XLS">
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
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="SALVAR ARQUIVOS TXT">
    public void arquivoSaveXls() throws IOException {
        Stage stage = programacontabil.primaryStage;
        File caminhofolle = new File("C:\\Users\\joao.santos\\Desktop");
        FileChooser chooser = new FileChooser();
        chooser.setInitialDirectory(caminhofolle);
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Excel file (*.xls)", "*.xls"));
        file = chooser.showSaveDialog(stage);
    }

    public void arquivoSaveTxt() throws IOException {
        Stage stage = programacontabil.primaryStage;
        File caminhofolle = new File("C:\\Users\\joao.santos\\Desktop");
        FileChooser chooser = new FileChooser();
        chooser.setInitialDirectory(caminhofolle);
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text file (*.txt)", "*.txt"));
        file = chooser.showSaveDialog(stage);
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="PAGAMENTO">
    @FXML
    private void buttonAtualizar(ActionEvent event) {
        UsimedPagamentoDADOS c = tablePagamento.getSelectionModel().getSelectedItem();
        pegaValores(c);
        service.atualizar(c);
        atualizaDadosTabela();
    }

    @FXML
    private void buttonSalvar(ActionEvent event) {
        UsimedPagamentoDADOS c = new UsimedPagamentoDADOS();
        pegaValores(c);
        service.salvar(c);
        atualizaDadosTabela();
    }

    @FXML
    private void buttonApagar(ActionEvent event) {
        UsimedPagamentoDADOS c = tablePagamento.getSelectionModel().getSelectedItem();
        service.apagar(c.getId());
        atualizaDadosTabela();
    }

    @FXML
    private void buttonBuscar(ActionEvent event) {
        UsimedPagamentoDADOS c = new UsimedPagamentoDADOS();
        service.buscaPorId(c.getId());
        atualizaDadosTabela();
    }

    @FXML
    private void buttonLimpar(ActionEvent event) {
        limpar();
    }

    @FXML
    private void buttonFechar(ActionEvent event) {
        groupPagamento.setVisible(false);
        tablePagamento.setVisible(false);
        HBoxAbrirXLS.setVisible(true);
        HBoxImportar.setVisible(true);
        btnAbrirXLS.setVisible(true);
        btnEditarXLS.setVisible(true);
        btnImportar.setVisible(true);
    }

    private void pegaValores(UsimedPagamentoDADOS c) {
        c.setAcrescimos(txtAcrescimos.getText());
        c.setBanco_origem(txtBancoOrigem.getText());
        c.setCedente(txtCedente.getText());
        c.setConta_bordero(txtContaBordero.getText());
        c.setData_pagamento(txtDataPagamento.getText());
        c.setDescontos(txtDescontos.getText());
        c.setDescricao(txtDescricao.getText());
        c.setNum_doc(txtNumeroDocumento.getText());
        c.setTotal(txtTotal.getText());
        c.setTotal_pago(txtTotalPago.getText());
    }

    public void limpar() {
        tablePagamento.getSelectionModel().select(null);
        txtAcrescimos.setText("");
        txtBancoOrigem.setText("");
        txtCedente.setText("");
        txtContaBordero.setText("");
        txtDataPagamento.setText("");
        txtDescontos.setText("");
        txtDescricao.setText("");
        txtNumeroDocumento.setText("");
        txtTotal.setText("");
        txtTotalPago.setText("");
    }

    private void atualizaDadosTabela() {
        tablePagamento.getItems().setAll(service.buscarTodas());
        limpar();

    }

    private void configuraColunas() {

        colAcrescimos.setCellValueFactory(new PropertyValueFactory<>("acrescimos"));
        colBancoOrigem.setCellValueFactory(new PropertyValueFactory<>("banco_origem"));
        colCedente.setCellValueFactory(new PropertyValueFactory<>("cedente"));
        colContaBordero.setCellValueFactory(new PropertyValueFactory<>("conta_bordero"));
        colDataPagamento.setCellValueFactory(new PropertyValueFactory<>("data_pagamento"));
        colDescontos.setCellValueFactory(new PropertyValueFactory<>("descontos"));
        colDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        colNumeroDocumento.setCellValueFactory(new PropertyValueFactory<>("num_doc"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        colTotalPago.setCellValueFactory(new PropertyValueFactory<>("banco_origem"));

    }

    private void configuraBindings() {
        BooleanBinding camposPreenchidos = txtId.textProperty().isEmpty().or(txtAcrescimos.textProperty().isEmpty().or(txtBancoOrigem.textProperty().isEmpty().or(txtCedente.textProperty().isEmpty().or(txtContaBordero.textProperty().isEmpty()
                .or(txtDataPagamento.textProperty().isEmpty().or(txtDescontos.textProperty().isEmpty().or(txtDescricao.textProperty().isEmpty().or(txtNumeroDocumento.textProperty().isEmpty().or(txtTotal.textProperty().isEmpty().or(txtTotalPago.textProperty().isEmpty()))))))))));
        BooleanBinding algoSelecionado = tablePagamento.getSelectionModel().selectedItemProperty().isNull();
        btnApagar.disableProperty().bind(algoSelecionado);
        btnAtualizar.disableProperty().bind(algoSelecionado);
        btnLimpar.disableProperty().bind(algoSelecionado);
        tablePagamento.getSelectionModel().selectedItemProperty().addListener((b, o, n) -> {
            if (n != null) {

                txtAcrescimos.setText(n.getAcrescimos());
                txtBancoOrigem.setText(n.getBanco_origem());
                txtCedente.setText(n.getCedente());
                txtContaBordero.setText(n.getConta_bordero());
                txtDataPagamento.setText(n.getData_pagamento());
                txtDescontos.setText(n.getDescontos());
                txtDescricao.setText(n.getDescricao());
                txtNumeroDocumento.setText(n.getNum_doc());
                txtTotal.setText(n.getTotal());
                txtTotalPago.setText(n.getTotal_pago());
            }
        });
    }

    public void Pagamento() throws SAXException, IOException, ParserConfigurationException, BiffException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement("TRUNCATE TABLE financeiro_pagamento");
        stmt.execute();
        arrayOpen();
        for (Object caminho_ob : array_caminho) {
            diretorio = new File((String) caminho_ob);
            Workbook workbook = Workbook.getWorkbook(diretorio);
            Sheet sheet = workbook.getSheet(0);
            linhas = sheet.getRows();
            System.out.println("Iniciando a leitura da planilha XLS:");
            for (int i = 1; i < linhas; i++) {
                //Ler todas as linhas do excel
                Cell a1 = sheet.getCell(0, i);
                Cell a2 = sheet.getCell(2, i);
                Cell a3 = sheet.getCell(4, i);
                Cell a4 = sheet.getCell(5, i);
                Cell a5 = sheet.getCell(7, i);
                Cell a6 = sheet.getCell(9, i);
                Cell a7 = sheet.getCell(10, i);
                Cell a8 = sheet.getCell(11, i);
                Cell a9 = sheet.getCell(12, i);
                Cell a10 = sheet.getCell(15, i);
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

                con = ConnectionFactory.getConnection();
                stmt = con.prepareStatement("INSERT INTO financeiro_pagamento(num_doc,conta_bordero,data_pagamento,cedente,total_pago,descricao,descontos,acrescimos,total,banco_origem) VALUES(?,?,?,?,?,?,?,?,?,?)");
                stmt.setString(1, as1);
                stmt.setString(2, as2);
                stmt.setString(3, as3);
                stmt.setString(4, as4);
                stmt.setString(5, as5);
                stmt.setString(6, as6);
                stmt.setString(7, as7);
                stmt.setString(8, as8);
                stmt.setString(9, as9);
                stmt.setString(10, as10);
                stmt.execute();
                stmt.close();
                con.close();
            }
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setContentText("Dados importados com sucesso.");
            alerta.setTitle("Importar");
            alerta.setHeaderText("Informação.");
            alerta.show();
        }
        array_caminho.removeAll(array_caminho);
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="CONVENIO">    
    public void Convenio() throws SAXException, IOException, ParserConfigurationException, BiffException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement("TRUNCATE TABLE financeiro_convenio");
        stmt.execute();
        TextField lblSheet = new TextField();
        Alert alertaSheet = new Alert(Alert.AlertType.CONFIRMATION);
        alertaSheet.setContentText("Por favor digite o nome da aba que deseja pegar os dados.");
        alertaSheet.setTitle("Importar");
        alertaSheet.setHeaderText("Informação.");
        alertaSheet.setGraphic(lblSheet);
        alertaSheet.showAndWait();
        if (!lblSheet.getText().equals("") && alertaSheet.getResult().getText().equals("OK")) {
            arrayOpen();
            try {
                for (Object caminho_ob : array_caminho) {
                    diretorio = new File((String) caminho_ob);
                    Workbook workbook = Workbook.getWorkbook(diretorio);
                    Sheet sheet = workbook.getSheet(lblSheet.getText());
                    linhas = sheet.getRows();
                    System.out.println("Iniciando a leitura da planilha XLS:");
                    for (int i = 1; i < linhas; i++) {
                        //Ler todas as linhas do excel
                        Cell a1 = sheet.getCell(0, i);
                        Cell a2 = sheet.getCell(1, i);
                        Cell a3 = sheet.getCell(2, i);
                        Cell a4 = sheet.getCell(3, i);
                        Cell a5 = sheet.getCell(4, i);
                        Cell a6 = sheet.getCell(5, i);
                        Cell a7 = sheet.getCell(6, i);
                        Cell a8 = sheet.getCell(7, i);
                        String as1 = a1.getContents();
                        String as2 = a2.getContents();
                        String as3 = a3.getContents();
                        String as4 = a4.getContents();
                        String as5 = a5.getContents();
                        String as6 = a6.getContents();
                        String as7 = a7.getContents();
                        String as8 = a8.getContents();
                        if (as1.length() == 8) {
                            String dia = as1.substring(0, 2);
                            String mes = as1.substring(3, 5);
                            String ano = as1.substring(6, 8);
                            as1 = dia + mes + "20" + ano;
                            as1 = as1.replace("/", "");
                        }
                        if (as4.contains("$")) {
                            as4 = as4.replace("$", "");

                        }
                        if (as6.contains("$")) {
                            as6 = as6.replace("$", "");
                        }
                        if (as7.contains("$")) {
                            as7 = as7.replace("$", "");
                        }
                        if (as8.length() == 8) {
                            String dia = as1.substring(0, 2);
                            String mes = as1.substring(3, 5);
                            String ano = as1.substring(6, 8);
                            as8 = dia + mes + "20" + ano;
                            as8 = as8.replace("/", "");
                        }
                        as5 = as5.replace("/", "").replace(".", "").replace("-", "");

                        if (as3.equals("TOTAL GERAL")) {

                        } else {
                            con = ConnectionFactory.getConnection();
                            stmt = con.prepareStatement("INSERT INTO financeiro_convenio(emissao,num_documento,nome_pagador,valor,insc_pagador,valor_pago,valor_dif_cobrado,data_credito) VALUES(?,?,?,?,?,?,?,?)");
                            stmt.setString(1, as1);
                            stmt.setString(2, as2);
                            stmt.setString(3, as3);
                            stmt.setString(4, as4);
                            stmt.setString(5, as5);
                            stmt.setString(6, as6);
                            stmt.setString(7, as7);
                            stmt.setString(8, as8);
                            stmt.execute();
                            stmt.close();
                            con.close();
                        }
                    }
                    Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                    alerta.setContentText("Dados importados com sucesso.");
                    alerta.setTitle("Importar");
                    alerta.setHeaderText("Informação.");
                    alerta.show();
                }
            } catch (SQLException erro) {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setContentText("Erro ao importar os dados do convenio no banco de dados.");
                alerta.setTitle("Erro ao importar");
                alerta.setHeaderText("Erro.");
                alerta.show();
            }
            array_caminho.removeAll(array_caminho);
        } else {

        }
    }

    private void atualizaTableConvenio() {
        tableConvenio.getItems().setAll(serviceConvenio.buscarTodas());
        limpar();
    }

    private void pegaValoresConvenio(UsimedConvenioDADOS c) {
        c.setEmissao(txtEmissaoCONV.getText());
        c.setNum_documento(txtNumeroDocumentoCONV.getText());
        c.setNome_pagador(txtNomePagadorCONV.getText());
        c.setValor(txtValorCONV.getText());
        c.setInsc_pagador(txtInscricaoPagadorCONV.getText());
        c.setValor_pago(txtValorPagoCONV.getText());
        c.setValor_dif_cobrado(txtValorDifCobradoCONV.getText());
        c.setData_credito(txtDataCreditoCONV.getText());
    }

    private void configuraColunasConvenio() {
        colEmissaoCONV.setCellValueFactory(new PropertyValueFactory<>("emissao"));
        colNumeroDocumentoCONV.setCellValueFactory(new PropertyValueFactory<>("num_documento"));
        colNomePagadorCONV.setCellValueFactory(new PropertyValueFactory<>("nome_pagador"));
        colValorCONV.setCellValueFactory(new PropertyValueFactory<>("valor"));
        colInscricaoPagadorCONV.setCellValueFactory(new PropertyValueFactory<>("insc_pagador"));
        colValorPagoCONV.setCellValueFactory(new PropertyValueFactory<>("valor_pago"));
        colValorDifCobradaCONV.setCellValueFactory(new PropertyValueFactory<>("valor_dif_cobrado"));
        colDataCreditoCONV.setCellValueFactory(new PropertyValueFactory<>("data_credito"));
    }

    @FXML
    private void buttonAtualizarCONV(ActionEvent event) {
        UsimedConvenioDADOS c = tableConvenio.getSelectionModel().getSelectedItem();
        pegaValoresConvenio(c);
        serviceConvenio.atualizar(c);
        atualizaTableConvenio();
    }

    @FXML
    private void buttonSalvarCONV(ActionEvent event) {
        UsimedConvenioDADOS c = tableConvenio.getSelectionModel().getSelectedItem();
        pegaValoresConvenio(c);
        serviceConvenio.salvar(c);
        atualizaTableConvenio();
    }

    @FXML
    private void buttonApagarCONV(ActionEvent event) {
        UsimedConvenioDADOS c = tableConvenio.getSelectionModel().getSelectedItem();
        serviceConvenio.apagar(c.getId());
        atualizaTableConvenio();
    }

    @FXML
    private void buttonBuscarCONV(ActionEvent event) {
        UsimedConvenioDADOS c = tableConvenio.getSelectionModel().getSelectedItem();
        serviceConvenio.buscaPorId(c.getId());
        atualizaTableConvenio();
    }

    @FXML
    private void buttonLimparCONV(ActionEvent event) {
        tableConvenio.getSelectionModel().select(null);
        txtEmissaoCONV.setText("");
        txtNumeroDocumentoCONV.setText("");
        txtNomePagadorCONV.setText("");
        txtValorCONV.setText("");
        txtInscricaoPagadorCONV.setText("");
        txtValorPagoCONV.setText("");
        txtValorDifCobradoCONV.setText("");
        txtDataCreditoCONV.setText("");
    }

    @FXML
    private void buttonFecharCONV(ActionEvent event) {
        groupConvenio.setVisible(false);
        tableConvenio.setVisible(false);
        HBoxAbrirXLS.setVisible(true);
        HBoxImportar.setVisible(true);
        btnAbrirXLS.setVisible(true);
        btnEditarXLS.setVisible(true);
        btnImportar.setVisible(true);
    }

    public void configuraBindingsConvenio() {
        BooleanBinding camposPreenchidosConvenio = txtEmissaoCONV.textProperty().isEmpty().or(txtNumeroDocumentoCONV.textProperty().isEmpty().or(txtNomePagadorCONV.textProperty().isEmpty().or(txtValorCONV.textProperty().isEmpty().or(txtInscricaoPagadorCONV.textProperty().isEmpty().or(txtValorPagoCONV.textProperty().isEmpty().or(txtValorDifCobradoCONV.textProperty().isEmpty().or(txtDataCreditoCONV.textProperty().isEmpty())))))));
        BooleanBinding algoSelecionadoConvenio = tableConvenio.getSelectionModel().selectedItemProperty().isNull();
        btnApagarCONV.disableProperty().bind(algoSelecionadoConvenio);
        btnAtualizarCONV.disableProperty().bind(algoSelecionadoConvenio);
        btnLimparCONV.disableProperty().bind(algoSelecionadoConvenio);
        tableConvenio.getSelectionModel().selectedItemProperty().addListener((b, o, n) -> {
            if (n != null) {
                txtEmissaoCONV.setText(n.getEmissao());
                txtNumeroDocumentoCONV.setText(n.getNum_documento());
                txtNomePagadorCONV.setText(n.getNome_pagador());
                txtValorCONV.setText(n.getValor());
                txtInscricaoPagadorCONV.setText(n.getInsc_pagador());
                txtValorPagoCONV.setText(n.getValor_pago());
                txtValorDifCobradoCONV.setText(n.getValor_dif_cobrado());
                txtDataCreditoCONV.setText(n.getData_credito());
            }
        });
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="CARTÃO 183">
    @FXML
    private void buttonAtualizar183(ActionEvent event) {
        UsimedCartao183DADOS c = tableCartao183.getSelectionModel().getSelectedItem();
        pegaValoresCartao183(c);
        serviceCartao183.atualizar(c);
        atualizaTableCartao183();
    }

    @FXML
    private void buttonSalvar183(ActionEvent event) {
        UsimedCartao183DADOS c = tableCartao183.getSelectionModel().getSelectedItem();
        pegaValoresCartao183(c);
        serviceCartao183.salvar(c);
        atualizaTableCartao183();
    }

    @FXML
    private void buttonApagar183(ActionEvent event) {
        UsimedCartao183DADOS c = tableCartao183.getSelectionModel().getSelectedItem();
        serviceCartao183.apagar(c.getId());
        atualizaTableCartao183();

    }

    @FXML
    private void buttonBuscar183(ActionEvent event) {
        UsimedCartao183DADOS c = tableCartao183.getSelectionModel().getSelectedItem();
        pegaValoresCartao183(c);
        serviceCartao183.buscaPorId(c.getId());
        atualizaTableCartao183();
    }

    @FXML
    private void buttonLimpar183(ActionEvent event) {
        limpar();
    }

    @FXML
    private void buttonFechar183(ActionEvent event) {
        groupCartao183.setVisible(false);
        tableCartao183.setVisible(false);
        HBoxAbrirXLS.setVisible(true);
        HBoxImportar.setVisible(true);
        btnAbrirXLS.setVisible(true);
        btnEditarXLS.setVisible(true);
        btnImportar.setVisible(true);
    }

    public void Cartao183() throws IOException, BiffException, SAXException, ParserConfigurationException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement("TRUNCATE TABLE cartao183");
        stmt.execute();
        arrayOpen();
        for (Object caminho_ob : array_caminho) {
            diretorio = new File((String) caminho_ob);
            Workbook workbook = Workbook.getWorkbook(diretorio);
            Sheet sheet = workbook.getSheet(0);
            linhas = sheet.getRows();
            System.out.println("Iniciando a leitura da planilha XLS:");
            for (int i = 1; i < linhas; i++) {
                //Ler todas as linhas do excel
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
                if (as3.length() == 8) {
                    String dia = as3.substring(0, 2);
                    String mes = as3.substring(3, 5);
                    String ano = as3.substring(6, 8);

                    as3 = dia + mes + "20" + ano;
                }

                con = ConnectionFactory.getConnection();
                stmt = con.prepareStatement("INSERT INTO cartao183(descricao,t,data,credito,debito,origem) VALUES(?,?,?,?,?,?)");
                stmt.setString(1, as1);
                stmt.setString(2, as2);
                stmt.setString(3, as3);
                stmt.setString(4, as4);
                stmt.setString(5, as5);
                stmt.setString(6, as6);
                stmt.execute();
                stmt.close();
                con.close();
            }
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setContentText("Dados importados com sucesso.");
            alerta.setTitle("Importar");
            alerta.setHeaderText("Informação.");
            alerta.show();
        }
        array_caminho.removeAll(array_caminho);
    }

    private void atualizaTableCartao183() {
        tableCartao183.getItems().setAll(serviceCartao183.buscarTodas());
        limpar();
    }

    private void pegaValoresCartao183(UsimedCartao183DADOS c) {
        c.setDescricao(txtDescricao183.getText());
        c.setT(txtT183.getText());
        c.setData(txtData183.getText());
        c.setCredito(txtCredito183.getText());
        c.setDebito(txtDebito183.getText());
        c.setOrigem(txtOrigem183.getText());
    }

    public void configuraColunasCartao183() {
        colDescricao183.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        colT183.setCellValueFactory(new PropertyValueFactory<>("t"));
        colData183.setCellValueFactory(new PropertyValueFactory<>("data"));
        colCredito183.setCellValueFactory(new PropertyValueFactory<>("credito"));
        colDebito183.setCellValueFactory(new PropertyValueFactory<>("debito"));
        colOrigem183.setCellValueFactory(new PropertyValueFactory<>("origem"));
    }

    public void ConfiguraBindingsCartao183() {
        BooleanBinding camposPreenchidos = txtDescricao183.textProperty().isEmpty().or(txtT183.textProperty().isEmpty().or(txtData183.textProperty().isEmpty().or(txtCredito183.textProperty().isEmpty().or(txtDebito183.textProperty().isEmpty().or(txtOrigem183.textProperty().isEmpty())))));
        BooleanBinding algoSelecionadoCartao183 = tableCartao183.getSelectionModel().selectedItemProperty().isNull();
        btnApagar183.disableProperty().bind(algoSelecionadoCartao183);
        btnAtualizar183.disableProperty().bind(algoSelecionadoCartao183);
        btnLimpar183.disableProperty().bind(algoSelecionadoCartao183);
        tableCartao183.getSelectionModel().selectedItemProperty().addListener((b, o, n) -> {
            if (n != null) {
                txtDescricao183.setText(n.getDescricao());
                txtT183.setText(n.getT());
                txtData183.setText(n.getData());
                txtCredito183.setText(n.getCredito());
                txtDebito183.setText(n.getDebito());
                txtOrigem183.setText(n.getOrigem());
            }
        });
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="CARTÃO 630">
    @FXML
    private void buttonAtualizar630(ActionEvent event) {
        UsimedCartao630DADOS c = tableCartao630.getSelectionModel().getSelectedItem();
        pegaValoresCartao630(c);
        serviceCartao630.atualizar(c);
        atualizaTableCartao630();
    }

    @FXML
    private void buttonSalvar630(ActionEvent event) {
        UsimedCartao630DADOS c = tableCartao630.getSelectionModel().getSelectedItem();
        pegaValoresCartao630(c);
        serviceCartao630.salvar(c);
        atualizaTableCartao630();
    }

    @FXML
    private void buttonApagar630(ActionEvent event) {
        UsimedCartao630DADOS c = tableCartao630.getSelectionModel().getSelectedItem();
        serviceCartao630.apagar(c.getId());
        atualizaTableCartao630();

    }

    @FXML
    private void buttonBuscar630(ActionEvent event) {
        UsimedCartao630DADOS c = tableCartao630.getSelectionModel().getSelectedItem();
        pegaValoresCartao630(c);
        serviceCartao630.buscaPorId(c.getId());
        atualizaTableCartao630();
    }

    @FXML
    private void buttonLimpar630(ActionEvent event) {
        limpar();
    }

    @FXML
    private void buttonFechar630(ActionEvent event) {
        groupCartao630.setVisible(false);
        tableCartao630.setVisible(false);
        HBoxAbrirXLS.setVisible(true);
        HBoxImportar.setVisible(true);
        btnAbrirXLS.setVisible(true);
        btnEditarXLS.setVisible(true);
        btnImportar.setVisible(true);
    }

    public void Cartao630() throws IOException, BiffException, SAXException, ParserConfigurationException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement("TRUNCATE TABLE cartao630");
        stmt.execute();
        arrayOpen();
        for (Object caminho_ob : array_caminho) {
            diretorio = new File((String) caminho_ob);
            Workbook workbook = Workbook.getWorkbook(diretorio);
            Sheet sheet = workbook.getSheet(0);
            linhas = sheet.getRows();
            System.out.println("Iniciando a leitura da planilha XLS:");
            for (int i = 1; i < linhas; i++) {
                //Ler todas as linhas do excel
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
                if (as3.length() == 8) {
                    String dia = as3.substring(0, 2);
                    String mes = as3.substring(3, 5);
                    String ano = as3.substring(6, 8);

                    as3 = dia + mes + "20" + ano;
                }

                con = ConnectionFactory.getConnection();
                stmt = con.prepareStatement("INSERT INTO cartao630(descricao,t,data,credito,debito,origem) VALUES(?,?,?,?,?,?)");
                stmt.setString(1, as1);
                stmt.setString(2, as2);
                stmt.setString(3, as3);
                stmt.setString(4, as4);
                stmt.setString(5, as5);
                stmt.setString(6, as6);
                stmt.execute();
                stmt.close();
                con.close();
            }
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setContentText("Dados importados com sucesso.");
            alerta.setTitle("Importar");
            alerta.setHeaderText("Informação.");
            alerta.show();
        }
        array_caminho.removeAll(array_caminho);
    }

    private void atualizaTableCartao630() {
        tableCartao630.getItems().setAll(serviceCartao630.buscarTodas());
        limpar();
    }

    private void pegaValoresCartao630(UsimedCartao630DADOS c) {
        c.setDescricao(txtDescricao630.getText());
        c.setT(txtT630.getText());
        c.setData(txtData630.getText());
        c.setCredito(txtCredito630.getText());
        c.setDebito(txtDebito630.getText());
        c.setOrigem(txtOrigem630.getText());
    }

    public void configuraColunasCartao630() {
        colDescricao630.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        colT630.setCellValueFactory(new PropertyValueFactory<>("t"));
        colData630.setCellValueFactory(new PropertyValueFactory<>("data"));
        colCredito630.setCellValueFactory(new PropertyValueFactory<>("credito"));
        colDebito630.setCellValueFactory(new PropertyValueFactory<>("debito"));
        colOrigem630.setCellValueFactory(new PropertyValueFactory<>("origem"));
    }

    public void ConfiguraBindingsCartao630() {
        BooleanBinding camposPreenchidos = txtDescricao630.textProperty().isEmpty().or(txtT630.textProperty().isEmpty().or(txtData630.textProperty().isEmpty().or(txtCredito630.textProperty().isEmpty().or(txtDebito630.textProperty().isEmpty().or(txtOrigem630.textProperty().isEmpty())))));
        BooleanBinding algoSelecionadoCartao630 = tableCartao630.getSelectionModel().selectedItemProperty().isNull();
        btnApagar630.disableProperty().bind(algoSelecionadoCartao630);
        btnAtualizar630.disableProperty().bind(algoSelecionadoCartao630);
        btnLimpar630.disableProperty().bind(algoSelecionadoCartao630);
        tableCartao630.getSelectionModel().selectedItemProperty().addListener((b, o, n) -> {
            if (n != null) {
                txtDescricao630.setText(n.getDescricao());
                txtT630.setText(n.getT());
                txtData630.setText(n.getData());
                txtCredito630.setText(n.getCredito());
                txtDebito630.setText(n.getDebito());
                txtOrigem630.setText(n.getOrigem());
            }
        });
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="CARTÃO BB">
    @FXML
    private void buttonAtualizarBB(ActionEvent event) {
        UsimedCartaoBBDados c = tableCartaoBB.getSelectionModel().getSelectedItem();
        pegaValoresCartaoBB(c);
        serviceCartaoBB.atualizar(c);
        atualizaTableCartaoBB();
    }

    @FXML
    private void buttonSalvarBB(ActionEvent event) {
        UsimedCartaoBBDados c = tableCartaoBB.getSelectionModel().getSelectedItem();
        pegaValoresCartaoBB(c);
        serviceCartaoBB.salvar(c);
        atualizaTableCartaoBB();
    }

    @FXML
    private void buttonApagarBB(ActionEvent event) {
        UsimedCartaoBBDados c = tableCartaoBB.getSelectionModel().getSelectedItem();
        serviceCartaoBB.apagar(c.getId());
        atualizaTableCartaoBB();
    }

    @FXML
    private void buttonBuscarBB(ActionEvent event) {
        UsimedCartao630DADOS c = tableCartao630.getSelectionModel().getSelectedItem();
        pegaValoresCartao630(c);
        serviceCartao630.buscaPorId(c.getId());
        atualizaTableCartao630();
    }

    @FXML
    private void buttonLimparBB(ActionEvent event) {
        limpar();
    }

    @FXML
    private void buttonFecharBB(ActionEvent event) {
        groupCartaoBB.setVisible(false);
        tableCartaoBB.setVisible(false);
        HBoxAbrirXLS.setVisible(true);
        HBoxImportar.setVisible(true);
        btnAbrirXLS.setVisible(true);
        btnEditarXLS.setVisible(true);
        btnImportar.setVisible(true);
    }

    public void CartaoBB() throws IOException, BiffException, SAXException, ParserConfigurationException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement("TRUNCATE TABLE cartaoBB");
        stmt.execute();
        arrayOpen();
        for (Object caminho_ob : array_caminho) {
            diretorio = new File((String) caminho_ob);
            Workbook workbook = Workbook.getWorkbook(diretorio);
            Sheet sheet = workbook.getSheet(0);
            linhas = sheet.getRows();
            System.out.println("Iniciando a leitura da planilha XLS:");
            for (int i = 1; i < linhas; i++) {
                //Ler todas as linhas do excel
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
                if (as3.length() == 8) {
                    String dia = as3.substring(0, 2);
                    String mes = as3.substring(3, 5);
                    String ano = as3.substring(6, 8);

                    as3 = dia + mes + "20" + ano;
                }

                con = ConnectionFactory.getConnection();
                stmt = con.prepareStatement("INSERT INTO cartaoBB(descricao,t,data,credito,debito,origem) VALUES(?,?,?,?,?,?)");
                stmt.setString(1, as1);
                stmt.setString(2, as2);
                stmt.setString(3, as3);
                stmt.setString(4, as4);
                stmt.setString(5, as5);
                stmt.setString(6, as6);
                stmt.execute();
                stmt.close();
                con.close();
            }
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setContentText("Dados importados com sucesso.");
            alerta.setTitle("Importar");
            alerta.setHeaderText("Informação.");
            alerta.show();
        }
        array_caminho.removeAll(array_caminho);
    }

    private void atualizaTableCartaoBB() {
        tableCartaoBB.getItems().setAll(serviceCartaoBB.buscarTodas());
        limpar();
    }

    private void pegaValoresCartaoBB(UsimedCartaoBBDados c) {
        c.setDescricao(txtDescricaoBB.getText());
        c.setT(txtTBB.getText());
        c.setData(txtDataBB.getText());
        c.setCredito(txtCreditoBB.getText());
        c.setDebito(txtDebitoBB.getText());
        c.setOrigem(txtOrigemBB.getText());
    }

    public void configuraColunasCartaoBB() {
        colDescricaoBB.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        colTBB.setCellValueFactory(new PropertyValueFactory<>("t"));
        colDatabBB.setCellValueFactory(new PropertyValueFactory<>("data"));
        colCreditoBB.setCellValueFactory(new PropertyValueFactory<>("credito"));
        colDebitoBB.setCellValueFactory(new PropertyValueFactory<>("debito"));
        colOrigemBB.setCellValueFactory(new PropertyValueFactory<>("origem"));
    }

    public void ConfiguraBindingsCartaoBB() {
        BooleanBinding camposPreenchidos = txtDescricaoBB.textProperty().isEmpty().or(txtTBB.textProperty().isEmpty().or(txtDataBB.textProperty().isEmpty().or(txtCreditoBB.textProperty().isEmpty().or(txtDebitoBB.textProperty().isEmpty().or(txtOrigemBB.textProperty().isEmpty())))));
        BooleanBinding algoSelecionadoCartaoBB = tableCartaoBB.getSelectionModel().selectedItemProperty().isNull();
        btnApagarBB.disableProperty().bind(algoSelecionadoCartaoBB);
        btnAtualizarBB.disableProperty().bind(algoSelecionadoCartaoBB);
        btnLimparBB.disableProperty().bind(algoSelecionadoCartaoBB);
        tableCartaoBB.getSelectionModel().selectedItemProperty().addListener((b, o, n) -> {
            if (n != null) {
                txtDescricaoBB.setText(n.getDescricao());
                txtTBB.setText(n.getT());
                txtDataBB.setText(n.getData());
                txtCreditoBB.setText(n.getCredito());
                txtDebitoBB.setText(n.getDebito());
                txtOrigemBB.setText(n.getOrigem());
            }
        });
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="IMPORTAR">
    public void ImportPagamento() throws IOException {
        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt;
            ResultSet rs;

            stmt = con.prepareStatement("SELECT id, num_doc, cota_bordero, data_pagamento, cedente, total_pago, descricao, descontos, acrescimos, total, banco_origem FROM financeiro_pagamento");
            rs = stmt.executeQuery();
            while (rs.next()) {
                // <editor-fold defaultstate="collapsed" desc="FORMATAR ID">
                DecimalFormat format_id = new DecimalFormat("00000");
                int int_id = rs.getInt("id");
                String id = format_id.format(int_id);
                String data = null;
                //</editor-fold>

                // <editor-fold defaultstate="collapsed" desc="DATA">
                if (rs.getString("data_pagamento").length() == 8) {
                    String dia = rs.getString("data_pagamento").substring(0, 2);
                    String mes = rs.getString("data_pagamento").substring(3, 5);
                    String ano = rs.getString("data_pagamento").substring(6, 8);
                    data = dia + mes + "20" + ano;
                } else {
                    data = rs.getString("data_pagamento");
                }
                // </editor-fold>

                // <editor-fold defaultstate="collapsed" desc="NUMERO DOCUMENTO">
                String num_doc = null;
                String espaco = "";
                if (rs.getString("num_doc").length() < 10) {

                    // <editor-fold defaultstate="collapsed" desc="CONDIÇÕES">
                    switch (rs.getString("num_doc").length()) {
                        case 9:
                            espaco = "                                       ";
                            break;
                        case 8:
                            espaco = "                                        ";
                            break;
                        case 7:
                            espaco = "                                         ";
                            break;
                        case 6:
                            espaco = "                                          ";
                            break;
                        case 5:
                            espaco = "                                           ";
                            break;
                        case 4:
                            espaco = "                                            ";
                            break;
                        case 3:
                            espaco = "                                             ";
                            break;
                        case 2:
                            espaco = "                                              ";
                            break;
                        case 1:
                            espaco = "                                               ";
                            break;
                        default:
                            break;
                    }
                    //</editor-fold>

                } else {
                    if (rs.getString("num_doc").length() > 10) {
                        num_doc = rs.getString("num_doc").substring(0, 10);
                    } else {
                        num_doc = rs.getString("num_doc");
                    }
                    espaco = "                                      ";
                }
                //</editor-fold>
                
                try (FileWriter fw = new FileWriter(file, true); PrintWriter gravarArq = new PrintWriter(fw)) {
                    gravarArq.println("LC1" + id + "   " + "1" + data + num_doc + espaco);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerUsimed.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // </editor-fold>
}
