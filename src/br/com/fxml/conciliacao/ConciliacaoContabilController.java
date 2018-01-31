/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fxml.conciliacao;

import br.com.programacontabil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import java.util.TimeZone;
import javafx.beans.binding.BooleanBinding;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
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
import jxl.format.Colour;
import jxl.read.biff.BiffException;
import jxl.write.Alignment;
import jxl.write.Border;
import jxl.write.BorderLineStyle;
import jxl.write.Label;
import jxl.write.NumberFormats;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.xml.sax.SAXException;

/**
 * FXML Controller class
 *
 * @author joao.santos
 */
public class ConciliacaoContabilController implements Initializable {

    // <editor-fold defaultstate="collapsed" desc="VARIAVEIS">
    public static ArrayList array_caminho = new ArrayList<>();
    public static File file;
    public static int linhas;
    public static String dados[] = new String[5];
    public static String choiceboxrec;
    public static String valorbanco;
    public static String linha;
    public static BufferedReader reader;
    public static File diretorio;

    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt;
    ResultSet rs;
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="VARIÁVEIS FXML">
    @FXML
    private ChoiceBox<String> RecPag;
    @FXML
    private javafx.scene.control.Label txtRecPag;
    @FXML
    private TableView<Dados> TableViewPag;
    @FXML
    private TableColumn<Dados, String> tablePagValor;
    @FXML
    private TableColumn<Dados, String> tablePgId;
    @FXML
    private TableColumn<Dados, String> tablePagData;
    @FXML
    private TableColumn<Dados, String> tablePagNumDoc;
    @FXML
    private TableColumn<Dados, String> tablePgContaDebito;
    @FXML
    private TableColumn<Dados, String> tablePgContaCredito;
    @FXML
    private TableColumn<Dados, String> tablePgCnpj;
    @FXML
    private TableColumn<Dados, String> tablePagHistorico;
    @FXML
    private TextField txtId;
    @FXML
    private TextField txtData;
    @FXML
    private TextField txtNumDoc;
    @FXML
    private TextField txtContaDebito;
    @FXML
    private TextField txtCnpj;
    @FXML
    private TextField txtValor;
    @FXML
    private TextField txtHistorico;
    @FXML
    private TextField txtContaCredito;
    @FXML
    private Button buttonInserirId;
    @FXML
    private Button buttonAtualizarId;
    @FXML
    private Button buttonBuscarId;
    @FXML
    private Button buttonBuscarTodosId;
    @FXML
    private Button buttonDeletarId;
    @FXML
    private Button buttonLimparId;
    @FXML
    private ButtonBar buttonBar;
    @FXML
    private HBox txtFields1;
    @FXML
    private HBox txtFields2;
    @FXML
    private Button atualizarBD;
    @FXML
    private TableView<DadosRec> TableViewRec;
    @FXML
    private TableColumn<DadosRec, String> tableRecId;
    @FXML
    private TableColumn<DadosRec, String> tableRecData;
    @FXML
    private TableColumn<DadosRec, String> tableRecNumDoc;
    @FXML
    private TableColumn<DadosRec, String> tableRecContaDebito;
    @FXML
    private TableColumn<DadosRec, String> tableRecContaCredito;
    @FXML
    private TableColumn<DadosRec, String> tableRecCnpj;
    @FXML
    private TableColumn<DadosRec, String> tableRecValor;
    @FXML
    private TableColumn<DadosRec, String> tableRecHistorico;
    @FXML
    private ButtonBar buttonBarRec;
    @FXML
    private Button buttonInserirIdRec;
    @FXML
    private Button buttonAtualizarIdRec;
    @FXML
    private Button buttonBuscarIdRec;
    @FXML
    private Button buttonBuscarTodosIdRec;
    @FXML
    private Button buttonLimparIdRec;
    @FXML
    private Button buttonDeletarIdRec;
    @FXML
    private HBox txtFields1Rec;
    @FXML
    private TextField txtIdRec;
    @FXML
    private TextField txtDataRec;
    @FXML
    private TextField txtNumDocRec;
    @FXML
    private TextField txtContaDebitoRec;
    @FXML
    private HBox txtFields2Rec;
    @FXML
    private TextField txtContaCreditoRec;
    @FXML
    private TextField txtCnpjRec;
    @FXML
    private TextField txtValorRec;
    @FXML
    private TextField txtHistoricoRec;
    @FXML
    private Button buttonClose;
    private DadosService service;
    private DadosServiceRec service_rec;
    @FXML
    private TextField txtDataInicial;
    @FXML
    private TextField txtDataFinal;
    @FXML
    private HBox HBoxCalcular;
    @FXML
    private HBox HBoxOpRelatorio;
    @FXML
    private TextField txtDataFinalCalcular;

    //</editor-fold>
    /**
     * Initializes the controller class.
     */
    @Override

    public void initialize(URL url, ResourceBundle rb) {
        service_rec = DadosServiceRec.getNewInstanceRec();
        service = DadosService.getNewInstance();
        ConfiguraBindings(); 
        configuraColunas();
        atualizaDadosTabela();
        RecPag.setItems(FXCollections.observableArrayList(
                "Recebimento", "Recebimento/Juros", "Recebimento/Descontos", "Pagamento", "Pagamento/Juros", "Pagamento/Descontos")
        );
    }

    // <editor-fold defaultstate="collapsed" desc="LER ARQUIVOS E SALVAR">
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

    // <editor-fold defaultstate="collapsed" desc="ABRIR ARQUIVOS TXT">
    public void arrayOpenTxt() throws SAXException, IOException, ParserConfigurationException, ParserConfigurationException {
        Stage stage = programacontabil.primaryStage;
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Abrir arquivos");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Arquivo texto", "*.txt"));
        diretorio = fileChooser.showOpenDialog(stage);

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
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="CÓDIGOS INTERFACE">    
    // <editor-fold defaultstate="collapsed" desc="BUTTON IMPORTAR EXCEL">
    @FXML
    private void buttonImportarExcel(ActionEvent event) throws SAXException, IOException, ParserConfigurationException, BiffException, SQLException, InterruptedException {

        // <editor-fold defaultstate="collapsed" desc="VARIÁVEIS">        
        //        <!----- DECLARAÇÃO DE VÁRIAVEIS -----!>
        float teste = 0;
        Calendar saoPauloDate = Calendar.getInstance(TimeZone.getTimeZone("America/Sao_Paulo"));
        List<String> novo_numero = new ArrayList<>();
        List<String> novo_terceiro = new ArrayList<>();
        List<String> novo_valor = new ArrayList<>();
        float valor = 0;
        String terceiro = null;
        String numero_nota = null;
        float as4_atualizado = 0;
        float f = 0;
        Connection con = ConnectionFactory.getConnection();
        //        <!----- FIM -----!>
        //</editor-fold>

        // <editor-fold defaultstate="collapsed" desc="ABRIR E LER XLS">
        arrayOpen();
        for (Object caminho_ob : array_caminho) {
            String dia = String.valueOf(saoPauloDate.get(Calendar.DAY_OF_MONTH));
            String mes = String.valueOf(saoPauloDate.get(Calendar.MONTH) + 1);
            String ano = String.valueOf(saoPauloDate.get(Calendar.YEAR));
            String hora = String.valueOf(saoPauloDate.get(Calendar.HOUR_OF_DAY));
            String minuto = String.valueOf(saoPauloDate.get(Calendar.MINUTE));
            String horario = null;
            String data = null;
            if (dia.length() < 10) {
                dia = "0" + dia;
            }
            if (mes.length() < 10) {
                mes = "0" + mes;
            }
            data = dia + mes + ano;
            horario = hora + ":" + minuto;
            diretorio = new File((String) caminho_ob);
            Workbook workbook = Workbook.getWorkbook(diretorio);
            Sheet sheet = workbook.getSheet(0);
            linhas = sheet.getRows();
            System.out.println("Iniciando a leitura da planilha XLS:");
            for (int i = 4; i < linhas; i++) {
                //Ler todas as linhas do excel
                Cell a1 = sheet.getCell(0, i);
                Cell a2 = sheet.getCell(1, i);
                Cell a3 = sheet.getCell(5, i);
                Cell a4 = sheet.getCell(9, i);
                Cell a5 = sheet.getCell(8, i);
                String as1 = a1.getContents();
                String as2 = a2.getContents();
                String as3 = a3.getContents();
                String as4 = a4.getContents();
                String as5 = a5.getContents();
                if (as2.length() == 8) {
                    String dia1 = as2.substring(0, 2);
                    String mes2 = as2.substring(3, 5);
                    String ano3 = as2.substring(6, 8);
                    as2 = dia1 + mes2 + "20" + ano3;
                } else {

                }

                stmt = con.prepareStatement("INSERT INTO remover_duplicados_dados_prosoft(data,numero_nota,terceiro, valor_contabil, data_lancamento, horario_lancamento) VALUES('" + as2 + "','" + as1 + "','" + as3.replace(".", "").replace("-", "").replace("/", "") + "','" + as4.replace(".", "").replace(",", ".") + "','" + data + "','" + horario + "')");
                stmt.execute();
                //Fim ler todas as linhas do excel
                //</editor-fold>

                // <editor-fold defaultstate="collapsed" desc="PROCESSAMENTO DOS DADOS">
                if (as5.equals("0")) {

                    // <editor-fold defaultstate="collapsed" desc="OUTROS VALORES">
                    try {
                        con = ConnectionFactory.getConnection();
                        String sql = "INSERT INTO prosoft_excel(data,numero_nota,terceiro, valor_contabil, data_lancamento, horario_lancamento) VALUES('" + as2 + "','" + as1 + "','" + as3.replace(".", "").replace("-", "").replace("/", "") + "','" + as4.replace(".", "").replace(",", ".") + "','" + data + "','" + horario + "')";
                        try (PreparedStatement stmt = con.prepareStatement(sql)) {
                            stmt.execute();
                        }
                    } catch (SQLException error) {
                        Alert alerta = new Alert(Alert.AlertType.ERROR);
                        alerta.setTitle("Erro ao se conectar ao banco de dados.");
                        alerta.setContentText("Erro ao inserir os dados no banco de dados: " + error);
                        alerta.setHeaderText("Erro com o banco de dados. (desdobro 0)");
                        alerta.setResizable(false);
                        alerta.show();
                    }
                    //</editor-fold>

                } else {

                    // <editor-fold defaultstate="collapsed" desc="SETANDO DADOS NO BANCO VARIAVEL">
                    try {                       
                        con = ConnectionFactory.getConnection();
                        String sql = "INSERT INTO variavel_calculo_novosvalores(numero_nota, terceiro, valor_contabil, data_lancamento, horario_lancamento) VALUES('" + as1 + "','" + as3 + "','" + as4.replace(".", "").replace(",", ".") + "','" + data + "','" + horario + "')";
                        as4_atualizado = Float.parseFloat(as4.replace(".", "").replace(",", "."));
                        try (PreparedStatement stmt = con.prepareStatement(sql)) {
                            stmt.execute();
                        }
                    } catch (SQLException error) {
                        Alert alerta = new Alert(Alert.AlertType.ERROR);
                        alerta.setTitle("Erro ao se conectar ao banco de dados.");
                        alerta.setContentText("Erro ao inserir dados no banco de dados: " + error);
                        alerta.setHeaderText("Erro com o banco de dados. (Primeiros Valores)");
                        alerta.setResizable(false);
                        alerta.show();
                    }
                    //</editor-fold>

                    // <editor-fold defaultstate="collapsed" desc="PEGANDO NÚMERO DAS NOTAS">
                    try {
                        PreparedStatement stmt = con.prepareStatement("SELECT numero_nota FROM variavel_calculo_novosvalores");
                        ResultSet rs = stmt.executeQuery();
                        while (rs.next()) {
                            novo_numero.add(rs.getString("numero_nota"));
                            for (int a = 0; a < novo_numero.size(); a++) {
                                String b = novo_numero.get(a);
                                for (int c = a + 1; c < novo_numero.size(); c++) {
                                    String d = novo_numero.get(c);
                                    if (b.equals(d)) {
                                        novo_numero.remove(c);
                                        c--;
                                        numero_nota = novo_numero.get(c);
                                    }
                                }
                            }
                            stmt.execute();
                        }
                    } catch (SQLException error) {
                        Alert alerta = new Alert(Alert.AlertType.ERROR);
                        alerta.setTitle("Erro nos terceiros.");
                        alerta.setContentText("Erro ao tentar remover terceiros duplicados do banco de dados: " + error);
                        alerta.setHeaderText("Erro com o banco de dados.");
                        alerta.setResizable(false);
                        alerta.show();
                    }
                    //</editor-fold>

                    // <editor-fold defaultstate="collapsed" desc="PEGANDO OS TERCEIROS">
                    try {
                        PreparedStatement stmt = con.prepareStatement("SELECT terceiro FROM variavel_calculo_novosvalores");
                        ResultSet rs = stmt.executeQuery();
                        while (rs.next()) {
                            novo_terceiro.add(rs.getString("terceiro"));
                            for (int a = 0; a < novo_terceiro.size(); a++) {
                                String b = novo_terceiro.get(a);
                                for (int c = a + 1; c < novo_terceiro.size(); c++) {
                                    String d = novo_terceiro.get(c);
                                    if (b.equals(d)) {
                                        novo_terceiro.remove(c);
                                        c--;
                                        terceiro = novo_terceiro.get(c);

                                    }
                                }
                            }
                        }
                    } catch (SQLException error) {
                        Alert alerta = new Alert(Alert.AlertType.ERROR);
                        alerta.setTitle("Erro nos terceiros.");
                        alerta.setContentText("Erro ao tentar remover terceiros duplicados do banco de dados: " + error);
                        alerta.setHeaderText("Erro com o banco de dados.");
                        alerta.setResizable(false);
                        alerta.show();
                    }
                    //</editor-fold>

                    // <editor-fold defaultstate="collapsed" desc="SOMANDO OS VALORES CONTÁBEIS">
                    try {
                        PreparedStatement stmt = con.prepareStatement("SELECT SUM(valor_contabil)  as soma from variavel_calculo_novosvalores group by numero_nota, terceiro;");
                        ResultSet rs = stmt.executeQuery();
                        while (rs.next()) {
                            novo_valor.add(rs.getString("soma"));
                            for (int a = 0; a < novo_valor.size(); a++) {
                                String b = novo_valor.get(a);
                                for (int c = a + 1; c < novo_valor.size(); c++) {
                                    String d = novo_valor.get(c);
                                    if (b.equals(d)) {
                                        novo_valor.remove(c);
                                        c--;
                                        f = Float.parseFloat(novo_valor.get(c));
                                    }
                                }
                            }
                        }

                    } catch (SQLException error) {
                        Alert alerta = new Alert(Alert.AlertType.ERROR);
                        alerta.setTitle("Erro no valor contabil.");
                        alerta.setContentText("Erro ao tentar somar os valores do valor contabil no banco de dados: " + error);
                        alerta.setResizable(false);
                        alerta.setHeaderText("Erro no banco de dados.");
                        alerta.show();
                    }
                    //</editor-fold>

                    // <editor-fold defaultstate="collapsed" desc="ELIMINAR VALORES REPETIDOS CONTABEIS">
                    int indice = novo_valor.size();
                    int resultado = indice % 2;                    
                    if (resultado == 0) {
                        indice = indice - 1;

                        valor = Float.parseFloat(novo_valor.get(indice));
                        try {
                            con = ConnectionFactory.getConnection();
                            String sql = "INSERT INTO prosoft_excel(data, numero_nota,terceiro, valor_contabil, data_lancamento, horario_lancamento) VALUES('" + as2 + "','" + numero_nota + "','" + terceiro.replace(".", "").replace("-", "").replace("/", "") + "','" + valor + "','" + data + "','" + horario + "')";
                            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                                stmt.execute();
                            }
                        } catch (SQLException error) {
                            Alert alerta = new Alert(Alert.AlertType.ERROR);
                            alerta.setTitle("Erro ao se conectar ao banco de dados.");
                            alerta.setContentText("Erro ao inserir os novos dados no banco de dados: " + error);
                            alerta.setHeaderText("Erro com o banco de dados.");
                            alerta.setResizable(false);
                            alerta.show();

                        }
                    }
                    con.close();
                    //</editor-fold>                    
                }

            }
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setContentText("Dados importados com sucesso.");
            alerta.setTitle("Importar");
            alerta.setHeaderText("Informação.");
            alerta.show();
        }
        //</editor-fold>

        array_caminho.removeAll(array_caminho);
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="BUTTON IMPORTAR TXT">
    @FXML
    private void buttonImportarTxt(ActionEvent event) throws SAXException, IOException, FileNotFoundException, ParserConfigurationException, BiffException, SQLException {

        if (RecPag.getValue() == null) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setContentText("Por favor insira uma opção para prosseguir.");
            alerta.setTitle("Erro");
            alerta.setHeaderText("Opção não selecionada.");
            alerta.show();
        } else {
            switch (RecPag.getValue()) {
                case "Recebimento":
                    LerTxt();
                    break;
                case "Recebimento/Juros":
                    LerTxtJur();
                    break;
                case "Recebimento/Descontos":
                    LerTxtDesc();
                    break;
                case "Pagamento":
                    LerTxt();
                    break;
                case "Pagamento/Juros":
                    LerTxtJur();
                    break;
                case "Pagamento/Descontos":
                    LerTxtDesc();
                    break;
                default:

                    break;
            }
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="BUTTON CALCULAR">
    @FXML
    private void buttonCalcular(ActionEvent event) throws IOException, Exception {

        // <editor-fold defaultstate="collapsed" desc="DECLARAÇÃO DE VARIÁVEIS">
        //Declaração das váriaveis para pegar os valores do banco de dados
        String nota = null;
        String cnpj = null;
        String data = null;
        float valor = 0;
        PreparedStatement stmt_novosvalores;
        ResultSet rs_novosvalores;
        List<String> data_novos = new ArrayList<>();
        List<String> nota_novos = new ArrayList<>();
        List<String> cnpj_novos = new ArrayList<>();
        List<Float> valor_novos = new ArrayList<>();
        List<Float> pegarValor = new ArrayList<>();
        Calendar saoPauloDate = Calendar.getInstance(TimeZone.getTimeZone("America/Sao_Paulo"));
        String dia = String.valueOf(saoPauloDate.get(Calendar.DAY_OF_MONTH));
        String mes = String.valueOf(saoPauloDate.get(Calendar.MONTH) + 1);
        String ano = String.valueOf(saoPauloDate.get(Calendar.YEAR));
        String hora = String.valueOf(saoPauloDate.get(Calendar.HOUR_OF_DAY));
        String minuto = String.valueOf(saoPauloDate.get(Calendar.MINUTE));
        String horario = null;
        String data_lancamento = null;
        if (dia.length() < 10) {
            dia = "0" + dia;
        }
        if (mes.length() < 10) {
            mes = "0" + mes;
        }
        data_lancamento = dia + mes + ano;
        horario = hora + ":" + minuto;
        //fim declaração de variaveis
        //</editor-fold>

        // <editor-fold defaultstate="collapsed" desc="PEGANDO VALORES DO BD 'prosoft_excel'">
        /* Pegando valores do banco de dados "prosoft_excel" para fazer a verificação de pagamento_txt, e consequentemente
        fazer o cálculo entre os dois.
         */
        try {
            stmt = con.prepareStatement("SELECT data, numero_nota, terceiro, valor_contabil FROM prosoft_excel WHERE data <= " + txtDataFinalCalcular.getText() + "");
            rs = stmt.executeQuery();
            while (rs.next()) {
                PreparedStatement stmtt = con.prepareStatement("SELECT data, numero_documento, cnpj, valor FROM pagamento_txt WHERE numero_documento = " + rs.getString("numero_nota") + " AND cnpj = " + rs.getString("terceiro") + " ");
                ResultSet rse = stmtt.executeQuery();
                while (rse.next()) {
                    nota_novos.add(rse.getString("numero_documento"));
                    cnpj_novos.add(rse.getString("cnpj"));
                    data_novos.add(rs.getString("data"));
                    for (int a = 0; a < nota_novos.size(); a++) {
                        String b = nota_novos.get(a);
                        for (int c = a + 1; c < nota_novos.size(); c++) {
                            String d = nota_novos.get(c);
                            if (b.equals(d)) {
                                cnpj_novos.remove(c);
                                data_novos.remove(c);
                                nota_novos.remove(c);
                                c--;
                            }
                        }
                    }
                    PreparedStatement stmte = con.prepareStatement("SELECT numero_documento, cnpj, SUM(valor) AS soma FROM pagamento_txt WHERE numero_documento = " + rse.getString("numero_documento") + " AND cnpj = " + rse.getString("cnpj") + " GROUP BY numero_documento, cnpj");
                    ResultSet rsf = stmte.executeQuery();
                    while (rsf.next()) {
                        valor_novos.add(Float.parseFloat(rsf.getString("soma")));
                        for (int a = 0; a < valor_novos.size(); a++) {
                            float b = valor_novos.get(a);
                            for (int c = a + 1; c < valor_novos.size(); c++) {
                                float d = valor_novos.get(c);
                                if (b == d) {
                                    valor_novos.remove(c);
                                    c--;
                                }
                            }
                        }
                    }
                    PreparedStatement stmtn = con.prepareStatement("SELECT numero_nota, terceiro, SUM(valor_contabil) AS soma FROM prosoft_excel WHERE numero_nota = " + rse.getString("numero_documento") + " AND terceiro = " + rse.getString("cnpj") + " GROUP BY numero_nota, terceiro");
                    ResultSet rsn = stmtn.executeQuery();
                    while (rsn.next()) {
                        pegarValor.add(Float.parseFloat(rsn.getString("soma")));
                        for (int a = 0; a < pegarValor.size(); a++) {
                            float b = pegarValor.get(a);
                            for (int c = a + 1; c < pegarValor.size(); c++) {
                                float d = pegarValor.get(c);
                                if (b == d) {
                                    pegarValor.remove(c);
                                    c--;
                                }
                            }
                        }
                    }
                }
            }
            stmt.close();
            rs.close();

            // <editor-fold defaultstate="collapsed" desc="VALOR FINAL">
            for (int s = 0; s < valor_novos.size(); s++) {
                valor = pegarValor.get(s) - valor_novos.get(s);
                cnpj = cnpj_novos.get(s);
                nota = nota_novos.get(s);
                data = data_novos.get(s);
                PreparedStatement stmtm = con.prepareStatement("INSERT INTO result_calculo(data, cnpj,numero_nota,valor, data_lancamento, horario_lancamento) VALUES('" + data + "','" + cnpj + "','" + nota + "','" + valor + "','" + data_lancamento + "','" + horario + "')");

                stmtm.execute();
                stmtm.close();
            }
            PreparedStatement stm = con.prepareStatement("INSERT INTO result_calculo(cnpj,numero_nota,valor) VALUES('" + "PULAR LINHA" + "','" + "PULAR LINHA" + "','" + "PULAR LINHA" + "')");
            stm.execute();
            stm.close();
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Finalizado");
            alerta.setResizable(true);
            alerta.setContentText("Calculo finalizado com sucesso!");
            alerta.showAndWait();
            //</editor-fold>
        } catch (SQLException erro) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Erro com o banco de dados calcular");
            alerta.setContentText("Por favor informe este erro ao departamento de T.I:\n\n " + erro);
            alerta.show();
        }

        //</editor-fold>        
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="BUTTON GERAR CONCILIADOS">
    @FXML
    private void buttonGerarConciliados(ActionEvent event) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("SELECT data, cnpj, numero_nota, valor FROM result_calculo WHERE valor = 0.0");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {

        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="BUTTON GERAR NÃO CONCILIADOS">
    @FXML
    private void buttonGerarNaoConciliados(ActionEvent event
    ) {
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="BUTTON INSERIR">
    @FXML
    private void buttonInserir(ActionEvent event
    ) {
        Dados c = new Dados();
        pegaValores(c);
        service.salvar(c);
        atualizaDadosTabela();
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="BUTTON ATUALIZAR">
    @FXML
    private void buttonAtualizar(ActionEvent event
    ) {
        Dados c = TableViewPag.getSelectionModel().getSelectedItem();
        pegaValores(c);
        service.atualizar(c);
        atualizaDadosTabela();
        buttonLimpar(event);
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="BUTTON DELETAR">
    @FXML
    private void buttonDeletar(ActionEvent event
    ) {
        Dados c = TableViewPag.getSelectionModel().getSelectedItem();
        service.apagar(c.getId());
        atualizaDadosTabela();

    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="BUTTON BUSCAR">
    @FXML
    private void buttonBuscar(ActionEvent event
    ) {
        Dados c = null;
        Dados buscarPorData = service.buscarPorData(c.getData());
        atualizaDadosTabela();
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="BUTTON BUSCARTODOS">
    @FXML
    private void buttonBuscarTodos(ActionEvent event
    ) {
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="BUTTON LIMPAR">
    @FXML
    private void buttonLimpar(ActionEvent event
    ) {
        TableViewPag.getSelectionModel().select(null);
        txtCnpj.setText("");
        txtContaCredito.setText("");
        txtContaDebito.setText("");
        txtData.setText("");
        txtHistorico.setText("");
        txtValor.setText("");
        txtId.setText("");
        txtNumDoc.setText("");
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="LER TXT PAG E REC">
    public void LerTxt() throws FileNotFoundException, SAXException, IOException, ParserConfigurationException, BiffException, SQLException {
        String Rec_Pag = RecPag.getValue();
        arrayOpenTxt();
        Calendar saoPauloDate = Calendar.getInstance(TimeZone.getTimeZone("America/Sao_Paulo"));
        String dia = String.valueOf(saoPauloDate.get(Calendar.DAY_OF_MONTH));
        String mes = String.valueOf(saoPauloDate.get(Calendar.MONTH) + 1);
        String ano = String.valueOf(saoPauloDate.get(Calendar.YEAR));
        String hora = String.valueOf(saoPauloDate.get(Calendar.HOUR_OF_DAY));
        String minuto = String.valueOf(saoPauloDate.get(Calendar.MINUTE));
        String horario = null;
        String data_lancamento = null;
        if (dia.length() < 10) {
            dia = "0" + dia;
        }
        if (mes.length() < 10) {
            mes = "0" + mes;
        }
        data_lancamento = dia + mes + ano;
        horario = hora + ":" + minuto;
        try {
            FileReader arq = new FileReader(diretorio);
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine();
            while (linha != null) {

                // <editor-fold defaultstate="collapsed" desc="INSERINDO DADOS NO BANCO">
                switch (Rec_Pag) {

                    case "Recebimento":
                        String data = linha.substring(12, 20);
                        String numero_documento = linha.substring(20, 31).replace(" ", "").replaceAll("[^0-9]", "");
                        String conta_debito = linha.substring(68, 73);
                        String conta_credito = linha.substring(92, 97);
                        String cnpj = linha.substring(97, 111).replace(".", "").replace("-", "").replace("/", "");
                        String valor = linha.substring(116, 132);
                        String historico = linha.substring(133, 239).replace("  ", "");
                        if (historico.contains("'")) {
                            historico = historico.replace("'", "-");
                        }
                        try {
                            Connection con = ConnectionFactory.getConnection();
                            PreparedStatement stmt = con.prepareStatement("Insert into recebimento_txt(data,numero_documento,conta_debito,conta_credito,cnpj,valor,historico, data_lancamento, horario_lancamento) VALUES('"
                                    + data + "','" + numero_documento + "','" + conta_debito + "','" + conta_credito + "','" + cnpj + "','" + valor + "','" + historico + "','" + data_lancamento + "','" + horario + "')");
                            stmt.execute();
                            con.close();
                        } catch (SQLException erro) {
                            System.err.println(erro);
                            Alert alerta = new Alert(Alert.AlertType.ERROR);
                            alerta.setTitle("Erro ao se conectar ao banco de dados.");
                            alerta.setContentText("Erro ao inserir os novos dados no banco de dados: " + erro);
                            alerta.setHeaderText("Erro com o banco de dados Recebimento.");
                            alerta.setResizable(false);
                            alerta.show();
                            break;
                        }
                        break;
                    case "Pagamento":
                        try {
                            String data_pg = linha.substring(12, 20);
                            String numero_documento_pg = linha.substring(20, 31).replace(" ", "").replaceAll("[^0-9]", "");
                            String conta_debito_pg = linha.substring(68, 73);
                            String conta_credito_pg = linha.substring(92, 97);
                            String cnpj_pg = linha.substring(73, 87).replace(".", "").replace("-", "").replace("/", "");
                            String valor_pg = linha.substring(116, 132);
                            String historico_pg = linha.substring(133, 239).replace("  ", "");
                            if (historico_pg.contains("'")) {
                                historico_pg = historico_pg.replace("'", "-");
                            }
                            Connection con = ConnectionFactory.getConnection();
                            PreparedStatement stmt = con.prepareStatement("Insert into pagamento_txt(data,numero_documento,conta_debito,conta_credito,cnpj,valor,historico, data_lancamento, horario_lancamento) VALUES('"
                                    + data_pg + "','" + numero_documento_pg + "','" + conta_debito_pg + "','" + conta_credito_pg + "','" + cnpj_pg + "','" + valor_pg + "','" + historico_pg + "','" + data_lancamento + "','" + horario + "')");
                            stmt.execute();
                            con.close();
                        } catch (SQLException erro) {
                            Alert alerta = new Alert(Alert.AlertType.ERROR);
                            alerta.setTitle("Erro ao se conectar ao banco de dados.");
                            alerta.setContentText("Erro ao inserir os novos dados no banco de dados: " + erro);
                            alerta.setHeaderText("Erro com o banco de dados Pagamento.");
                            alerta.setResizable(false);
                            alerta.show();
                            break;
                        }
                        break;
                }
                //</editor-fold>

                linha = lerArq.readLine();
            }
            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setContentText("Dados importados com sucesso.");
        alerta.setTitle("Importar");
        alerta.setHeaderText("Informação.");
        alerta.show();

    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="LER TXT JUROS REC E PAG">
    public void LerTxtJur() throws SAXException, IOException, ParserConfigurationException {
        String Rec_Pag = RecPag.getValue();
        arrayOpenTxt();
        Calendar saoPauloDate = Calendar.getInstance(TimeZone.getTimeZone("America/Sao_Paulo"));
        String dia = String.valueOf(saoPauloDate.get(Calendar.DAY_OF_MONTH));
        String mes = String.valueOf(saoPauloDate.get(Calendar.MONTH) + 1);
        String ano = String.valueOf(saoPauloDate.get(Calendar.YEAR));
        String hora = String.valueOf(saoPauloDate.get(Calendar.HOUR_OF_DAY));
        String minuto = String.valueOf(saoPauloDate.get(Calendar.MINUTE));
        String horario = null;
        horario = hora + ":" + minuto;
        String data_lancamento = null;
        if (dia.length() < 10) {
            dia = "0" + dia;
        }
        if (mes.length() < 10) {
            mes = "0" + mes;
        }
        data_lancamento = dia + mes + ano;
        try {
            FileReader arq = new FileReader(diretorio);
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine();
            while (linha != null) {

                // <editor-fold defaultstate="collapsed" desc="INSERINDO DADOS">
                switch (Rec_Pag) {
                    case "Recebimento/Juros":
                        try {
                            String data = linha.substring(12, 20);
                            String numero_documento = linha.substring(20, 31).replace(" ", "").replaceAll("[^0-9]", "");
                            String conta_debito = linha.substring(68, 74);
                            String conta_credito = linha.substring(92, 97);
                            String cnpj = linha.substring(97, 111).replace(".", "").replace("-", "").replace("/", "");
                            String valor = linha.substring(116, 132);
                            String historico = linha.substring(133, 239).replace("  ", "");
                            if (historico.contains("'")) {
                                historico = historico.replace("'", "-");
                            }
                            Connection con = ConnectionFactory.getConnection();
                            PreparedStatement stmt = con.prepareStatement("Insert into recebimento_txt(data,numero_documento,conta_debito,conta_credito,cnpj,valor,historico, data_lancamento, horario_lancamento) VALUES('"
                                    + data + "','" + numero_documento + "','" + conta_debito + "','" + conta_credito + "','" + cnpj + "','" + valor + "','" + historico + "','" + data_lancamento + "','" + horario + "')");
                            stmt.execute();
                        } catch (SQLException erro) {
                            Alert alerta = new Alert(Alert.AlertType.ERROR);
                            alerta.setTitle("Erro ao se conectar ao banco de dados.");
                            alerta.setContentText("Erro ao inserir os novos dados no banco de dados: " + erro);
                            alerta.setHeaderText("Erro com o banco de dados Recebimento.");
                            alerta.setResizable(false);
                            alerta.show();
                            break;
                        }
                        break;
                    case "Pagamento/Juros":
                        try {
                            String data_pg = linha.substring(13, 20);
                            String numero_documento_pg = linha.substring(20, 31).replace(" ", "").replaceAll("[^0-9]", "");
                            String conta_debito_pg = linha.substring(68, 74);
                            String conta_credito_pg = linha.substring(92, 97);
                            String cnpj_pg = linha.substring(97, 111).replace(".", "").replace("-", "").replace("/", "");
                            String valor_pg = linha.substring(116, 132);
                            String historico_pg = linha.substring(133, 239).replace("  ", "");
                            if (historico_pg.contains("'")) {
                                historico_pg = historico_pg.replace("'", "-");
                            }
                            Connection con = ConnectionFactory.getConnection();
                            PreparedStatement stmt = con.prepareStatement("Insert into pagamento_txt(data,numero_documento,conta_debito,conta_credito,cnpj,valor,historico, data_lancamento, horario_lancamento) VALUES('"
                                    + data_pg + "','" + numero_documento_pg + "','" + conta_debito_pg + "','" + conta_credito_pg + "','" + cnpj_pg + "','" + valor_pg + "','" + historico_pg + "','" + data_lancamento + "','" + horario + "')");
                            stmt.execute();
                            con.close();
                        } catch (SQLException erro) {
                            Alert alerta = new Alert(Alert.AlertType.ERROR);
                            alerta.setTitle("Erro ao se conectar ao banco de dados.");
                            alerta.setContentText("Erro ao inserir os novos dados no banco de dados: " + erro);
                            alerta.setHeaderText("Erro com o banco de dados Pagamento.");
                            alerta.setResizable(false);
                            alerta.show();
                            break;
                        }
                        break;
                }
                //</editor-fold>

                linha = lerArq.readLine();

            }
            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setContentText("Dados importados com sucesso.");
        alerta.setTitle("Importar");
        alerta.setHeaderText("Informação.");
        alerta.show();

    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="LER TXT DESC REC E PAG">
    public void LerTxtDesc() throws SAXException, IOException, ParserConfigurationException {
        String Rec_Pag = RecPag.getValue();
        arrayOpenTxt();
        Calendar saoPauloDate = Calendar.getInstance(TimeZone.getTimeZone("America/Sao_Paulo"));
        String dia = String.valueOf(saoPauloDate.get(Calendar.DAY_OF_MONTH));
        String mes = String.valueOf(saoPauloDate.get(Calendar.MONTH) + 1);
        String ano = String.valueOf(saoPauloDate.get(Calendar.YEAR));
        String hora = String.valueOf(saoPauloDate.get(Calendar.HOUR_OF_DAY));
        String minuto = String.valueOf(saoPauloDate.get(Calendar.MINUTE));
        String horario = null;
        horario = hora + ":" + minuto;
        String data_lancamento = null;
        if (dia.length() < 10) {
            dia = "0" + dia;
        }
        if (mes.length() < 10) {
            mes = "0" + mes;
        }
        data_lancamento = dia + mes + ano;
        try {
            FileReader arq = new FileReader(diretorio);
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine();
            while (linha != null) {
                String data = linha.substring(12, 20);
                String numero_documento = linha.substring(20, 31).replace(" ", "").replaceAll("[^0-9]", "");
                String conta_debito = linha.substring(92, 97);
                String conta_credito = linha.substring(68, 73);
                String cnpj = linha.substring(97, 112).replace(".", "").replace("-", "").replace("/", "");
                String valor = linha.substring(116, 132);
                String historico = linha.substring(133, 239).replace("  ", "");

                // <editor-fold defaultstate="collapsed" desc="SETANDO VALORES NO BANCO DE DADOS">
                switch (Rec_Pag) {
                    case "Recebimento/Descontos":
                        try {
                            if (historico.contains("'")) {
                                historico = historico.replace("'", "-");
                            }
                            Connection con = ConnectionFactory.getConnection();
                            PreparedStatement stmt = con.prepareStatement("Insert into recebimento_txt(data,numero_documento,conta_debito,conta_credito,cnpj,valor,historico, data_lancamento, horario_lancamento) VALUES('"
                                    + data + "','" + numero_documento + "','" + conta_debito + "','" + conta_credito + "','" + cnpj + "','" + valor + "','" + historico + "','" + data_lancamento + "','" + horario + "')");
                            stmt.execute();
                        } catch (SQLException erro) {
                            Alert alerta = new Alert(Alert.AlertType.ERROR);
                            alerta.setTitle("Erro ao se conectar ao banco de dados.");
                            alerta.setContentText("Erro ao inserir os novos dados no banco de dados: " + erro);
                            alerta.setHeaderText("Erro com o banco de dados Recebimento.");
                            alerta.setResizable(false);
                            alerta.show();
                            break;
                        }
                        break;
                    case "Pagamento/Descontos":
                        try {
                            String data_pg = linha.substring(12, 20);
                            String numero_documento_pg = linha.substring(20, 31).replace(" ", "").replaceAll("[^0-9]", "");
                            String conta_debito_pg = linha.substring(92, 97);
                            String conta_credito_pg = linha.substring(68, 73);
                            String cnpj_pg = linha.substring(97, 112).replace(".", "").replace("-", "").replace("/", "");
                            String valor_pg = linha.substring(116, 132);
                            String historico_pg = linha.substring(133, 239).replace("  ", "");
                            if (historico_pg.contains("'")) {
                                historico_pg = historico_pg.replace("'", "-");
                            }
                            Connection con = ConnectionFactory.getConnection();
                            PreparedStatement stmt = con.prepareStatement("Insert into pagamento_txt(data,numero_documento,conta_debito,conta_credito,cnpj,valor,historico, data_lancamento, horario_lancamento) VALUES('"
                                    + data_pg + "','" + numero_documento_pg + "','" + conta_debito_pg + "','" + conta_credito_pg + "','" + cnpj_pg + "','" + valor_pg + "','" + historico_pg + "','" + data_lancamento + "','" + horario + "')");
                            stmt.execute();
                        } catch (SQLException erro) {
                            Alert alerta = new Alert(Alert.AlertType.ERROR);
                            alerta.setTitle("Erro ao se conectar ao banco de dados.");
                            alerta.setContentText("Erro ao inserir os novos dados no banco de dados: " + erro);
                            alerta.setHeaderText("Erro com o banco de dados Pagamento.");
                            alerta.setResizable(false);
                            alerta.show();
                            break;
                        }
                        break;
                }
                //</editor-fold>

                linha = lerArq.readLine();

            }
            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setContentText("Dados importados com sucesso.");
        alerta.setTitle("Importar");
        alerta.setHeaderText("Informação.");
        alerta.show();
    }
    //</editor-fold>

    @FXML
    private void buttonGerarRelatorioCalculo(ActionEvent event) throws WriteException, IOException, SQLException {

        if (txtDataInicial.getText().equals("") || txtDataFinal.getText().equals("")) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Campos não preenchidos");
            alert.setContentText("Por favor preencha os campos data inicial ou data final corretamente para continuar!");
            alert.showAndWait();
        } else if (txtDataInicial.getText().equals("") && txtDataFinal.getText().equals("")) {

        } else {
            arquivoSaveXls();
            List<String> pegarValor = new ArrayList<>();
            int b = 0;
            WritableFont bold = new WritableFont(WritableFont.ARIAL,
                    10, WritableFont.BOLD);
            bold.setColour(Colour.WHITE);
            WritableCellFormat table = new WritableCellFormat();
            table.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.MEDIUM);
            WritableCellFormat arial10font = new WritableCellFormat(bold);
            arial10font.setBackground(Colour.BLUE);
            arial10font.setAlignment(Alignment.CENTRE);
            arial10font.setBorder(Border.ALL, BorderLineStyle.MEDIUM, Colour.BLACK);
            WritableWorkbook workbook = Workbook.createWorkbook(file);
            WritableSheet sheet = workbook.createSheet("Relatório ", 0);
            WritableCellFormat sheet_format = new WritableCellFormat(NumberFormats.FLOAT);
            sheet_format.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.MEDIUM);
            Label label_titulo_cnpj = new Label(0, 0, "CNPJ", arial10font);
            sheet.addCell(label_titulo_cnpj);
            Label label_titulo_nota = new Label(1, 0, "NUMERO NOTAS", arial10font);
            sheet.addCell(label_titulo_nota);
            Label label_titulo_valor = new Label(2, 0, "VALOR", arial10font);
            sheet.addCell(label_titulo_valor);
            Label label_titulo_valor_total = new Label(3, 0, "VALOR TOTAL ANTERIOR", arial10font);
            sheet.addCell(label_titulo_valor_total);
            PreparedStatement stmt = con.prepareStatement("SELECT data, cnpj, numero_nota, valor FROM result_calculo WHERE data BETWEEN ? AND ?");
            stmt.setString(1, txtDataInicial.getText());
            stmt.setString(2, txtDataFinal.getText());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                b = sheet.getRows();
                if (rs.getString("cnpj").equals("PULAR LINHA") && rs.getString("numero_nota").equals("PULAR LINHA") && rs.getString("valor").equals("PULAR LINHA")) {

                } else {
                    if (rs.getFloat("valor") == 0) {

                    } else {
                        Label label_cnpj = new Label(0, b, rs.getString("cnpj"), table);
                        sheet.addCell(label_cnpj);
                        Label label_nota = new Label(1, b, rs.getString("numero_nota"), table);
                        sheet.addCell(label_nota);
                        Label label_valor = new Label(3, b, rs.getString("valor"), sheet_format);
                        sheet.addCell(label_valor);

                        PreparedStatement stmtn = con.prepareStatement("SELECT numero_nota, terceiro, SUM(valor_contabil) AS soma FROM prosoft_excel WHERE numero_nota = " + rs.getString("numero_nota") + " AND terceiro = " + rs.getString("cnpj") + " GROUP BY numero_nota, terceiro");
                        ResultSet rsn = stmtn.executeQuery();
                        while (rsn.next()) {
                            pegarValor.add(rsn.getString("soma"));
                            for (int a = 0; a < pegarValor.size(); a++) {
                                String f = pegarValor.get(a);
                                for (int c = a + 1; c < pegarValor.size(); c++) {
                                    String d = pegarValor.get(c);
                                    if (f == d) {
                                        pegarValor.remove(c);
                                        c--;
                                    }
                                }
                            }
                        }
                        for (String valor_saida : pegarValor) {
                            Label label_valor_saida = new Label(2, b, valor_saida, sheet_format);
                            sheet.addCell(label_valor_saida);
                        }
                    }
                }
            }
            workbook.write();
            workbook.close();
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Arquivo texto");
            alert.setContentText("O Arquivo texto foi gerado com sucesso! ");
            alert.showAndWait();
            txtDataInicial.clear();
            txtDataFinal.clear();
        }
    }

    @FXML
    private void buttonOpCalcular(ActionEvent event) {
        HBoxCalcular.setVisible(true);
        HBoxOpRelatorio.setVisible(false);
        TableViewRec.setVisible(false);
        buttonBarRec.setVisible(false);
        txtFields1Rec.setVisible(false);
        txtFields2Rec.setVisible(false);
        TableViewPag.setVisible(false);
        buttonBar.setVisible(false);
        txtFields1.setVisible(false);
        txtFields2.setVisible(false);
        atualizarBD.setVisible(false);
        buttonClose.setVisible(false);
    }

    @FXML
    private void buttonOpRelatorio(ActionEvent event) {
        HBoxCalcular.setVisible(false);
        HBoxOpRelatorio.setVisible(true);
        TableViewRec.setVisible(false);
        buttonBarRec.setVisible(false);
        txtFields1Rec.setVisible(false);
        txtFields2Rec.setVisible(false);
        TableViewPag.setVisible(false);
        buttonBar.setVisible(false);
        txtFields1.setVisible(false);
        txtFields2.setVisible(false);
        atualizarBD.setVisible(false);
        buttonClose.setVisible(false);
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="CÓDIGO TABELA">
    // <editor-fold defaultstate="collapsed" desc="BUTTON PAGAMENTO">
    @FXML
    private void buttonTablePagamento(ActionEvent event
    ) {
        TableViewRec.setVisible(false);
        buttonBarRec.setVisible(false);
        txtFields1Rec.setVisible(false);
        txtFields2Rec.setVisible(false);
        HBoxCalcular.setVisible(false);
        HBoxOpRelatorio.setVisible(false);

        TableViewPag.setVisible(true);
        buttonBar.setVisible(true);
        txtFields1.setVisible(true);
        txtFields2.setVisible(true);
        atualizarBD.setVisible(true);
        buttonClose.setVisible(true);
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="BUTTON RECEBIMENTO">
    @FXML
    private void buttonTableRecebimento(ActionEvent event
    ) {
        TableViewPag.setVisible(false);
        buttonBar.setVisible(false);
        txtFields1.setVisible(false);
        txtFields2.setVisible(false);
        HBoxCalcular.setVisible(false);
        HBoxOpRelatorio.setVisible(false);

        TableViewRec.setVisible(true);
        buttonBarRec.setVisible(true);
        txtFields1Rec.setVisible(true);
        txtFields2Rec.setVisible(true);
        atualizarBD.setVisible(true);
        buttonClose.setVisible(true);
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="BUTTON ATUALIZAR BD">
    @FXML
    private void buttonAtualizarBD(ActionEvent event
    ) {
        service = DadosService.getNewInstance();
        ConfiguraBindings();
        configuraColunas();
        atualizaDadosTabela();
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="BUTTON INSERIR RECEBIMENTO">
    @FXML
    private void buttonInserirRec(ActionEvent event
    ) {
        DadosRec a = new DadosRec();
        pegaValoresRec(a);
        service_rec.salvarRec(a);
        atualizaDadosTabela();
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="BUTTON ATUALIZAR RECEBIMENTO">
    @FXML
    private void buttonAtualizarRec(ActionEvent event
    ) {
        DadosRec a = TableViewRec.getSelectionModel().getSelectedItem();
        pegaValoresRec(a);
        service_rec.atualizarRec(a);
        atualizaDadosTabela();
        buttonLimpar(event);
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="BUTTON BUSCAR RECEBIMENTO">
    @FXML
    private void buttonBuscarRec(ActionEvent event
    ) {

    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="BUTTON BUSCAR TODOS RECEBIMENTO">
    @FXML
    private void buttonBuscarTodosRec(ActionEvent event
    ) {
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="BUTTON LIMPAR RECEBIMENTO">
    @FXML
    private void buttonLimparRec(ActionEvent event
    ) {
        TableViewRec.getSelectionModel().select(null);
        txtCnpjRec.setText("");
        txtContaCreditoRec.setText("");
        txtContaDebitoRec.setText("");
        txtDataRec.setText("");
        txtHistoricoRec.setText("");
        txtValorRec.setText("");
        txtIdRec.setText("");
        txtNumDocRec.setText("");
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="BUTTON DELETAR RECEBIMENTO">
    @FXML
    private void buttonDeletarRec(ActionEvent event
    ) {
        DadosRec a = TableViewRec.getSelectionModel().getSelectedItem();
        service_rec.apagarRec(a.getId_rec());
        atualizaDadosTabela();
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="BUTTON CLOSE BD/BUTTONS">
    @FXML
    private void buttonCloseApp(ActionEvent event
    ) {
        TableViewPag.setVisible(false);
        buttonBar.setVisible(false);
        txtFields1.setVisible(false);
        txtFields2.setVisible(false);
        TableViewRec.setVisible(false);
        buttonBarRec.setVisible(false);
        txtFields1Rec.setVisible(false);
        txtFields2Rec.setVisible(false);
        atualizarBD.setVisible(false);
        buttonClose.setVisible(false);
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="CONFIGURAR COLUNAS">
    private void configuraColunas() {
        tablePgId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tablePagData.setCellValueFactory(new PropertyValueFactory<>("data"));
        tablePagNumDoc.setCellValueFactory(new PropertyValueFactory<>("numero_documento"));
        tablePgContaDebito.setCellValueFactory(new PropertyValueFactory<>("conta_debito"));
        tablePgContaCredito.setCellValueFactory(new PropertyValueFactory<>("conta_credito"));
        tablePgCnpj.setCellValueFactory(new PropertyValueFactory<>("cnpj"));
        tablePagValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
        tablePagHistorico.setCellValueFactory(new PropertyValueFactory<>("historico"));

        tableRecId.setCellValueFactory(new PropertyValueFactory<>("id_rec"));
        tableRecData.setCellValueFactory(new PropertyValueFactory<>("data_rec"));
        tableRecNumDoc.setCellValueFactory(new PropertyValueFactory<>("numero_documento_rec"));
        tableRecContaDebito.setCellValueFactory(new PropertyValueFactory<>("conta_debito_rec"));
        tableRecContaCredito.setCellValueFactory(new PropertyValueFactory<>("conta_credito_rec"));
        tableRecCnpj.setCellValueFactory(new PropertyValueFactory<>("cnpj_rec"));
        tableRecValor.setCellValueFactory(new PropertyValueFactory<>("valor_rec"));
        tableRecHistorico.setCellValueFactory(new PropertyValueFactory<>("historico_rec"));
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="ATUALIZAR DADOS DA TABELA">
    private void atualizaDadosTabela() {
        TableViewPag.getItems().setAll(service.buscarTodas());
        TableViewRec.getItems().setAll(service_rec.buscarTodasRec());
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="PEGAR VALORES RECEBIMENTO">
    private void pegaValoresRec(DadosRec a) {
        int verifica_data = 0, verifica_numdoc = 0, verifica_contadebito = 0, verifica_contacredito = 0, verifica_cnpj = 0;
        DecimalFormat df = new DecimalFormat("0000000000000.00");
        if (txtDataRec.getText().length() != 8) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Data incorreta");
            alerta.setContentText("Por favor insira uma data válida como o exemplo: 10122017");
            alerta.show();
        } else {
            verifica_data = 1;
        }
        if (txtNumDocRec.getText().length() > 10) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Numero documento muito grande");
            alerta.setContentText("Por favor insira um número de documento com até 10 digitos.");
            alerta.show();
        } else {
            verifica_numdoc = 1;
        }
        if (txtContaDebitoRec.getText().length() > 5) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Conta Débito inválida");
            alerta.setContentText("Por favor insira o número da conta débito com até 05 digitos.");
            alerta.show();
        } else {
            verifica_contadebito = 1;
        }
        if (txtContaCreditoRec.getText().length() > 5) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Conta Crédito inválida");
            alerta.setContentText("Por favor insira o número da conta crédito com até 05 digitos.");
            alerta.show();
        } else {
            verifica_contacredito = 1;
        }
        if (txtCnpjRec.getText().length() > 14) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("CNPJ inválido");
            alerta.setContentText("Por favor insira um número de CNPJ com até 14 digitos.");
            alerta.show();
        } else {
            verifica_cnpj = 1;
        }

        if (verifica_data == 1 && verifica_numdoc == 1 && verifica_contadebito == 1 && verifica_contacredito == 1 && verifica_cnpj == 1) {
            a.setData_rec(txtDataRec.getText());
            a.setNumero_documento_rec(txtNumDocRec.getText());
            a.setConta_debito_rec(txtContaDebitoRec.getText());
            a.setConta_credito_rec(txtContaCreditoRec.getText());
            a.setCnpj_rec(txtCnpjRec.getText());
            a.setValor_rec(df.format(Float.parseFloat(txtValorRec.getText())).replace(",", "."));
            a.setHistorico_rec(txtHistoricoRec.getText());
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="PEGA VALORES PAGAMENTO">
    private void pegaValores(Dados c) {
        int verifica_data = 0, verifica_numdoc = 0, verifica_contadebito = 0, verifica_contacredito = 0, verifica_cnpj = 0;
        DecimalFormat df = new DecimalFormat("0000000000000.00");
        if (txtData.getText().length() != 8) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Data incorreta");
            alerta.setContentText("Por favor insira uma data válida como o exemplo: 10122017");
            alerta.show();
        } else {
            verifica_data = 1;
        }
        if (txtNumDoc.getText().length() > 10) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Numero documento muito grande");
            alerta.setContentText("Por favor insira um número de documento com até 10 digitos.");
            alerta.show();
        } else {
            verifica_numdoc = 1;
        }
        if (txtContaDebito.getText().length() > 5) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Conta Débito inválida");
            alerta.setContentText("Por favor insira o número da conta débito com até 05 digitos.");
            alerta.show();
        } else {
            verifica_contadebito = 1;
        }
        if (txtContaCredito.getText().length() > 5) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Conta Crédito inválida");
            alerta.setContentText("Por favor insira o número da conta crédito com até 05 digitos.");
            alerta.show();
        } else {
            verifica_contacredito = 1;
        }
        if (txtCnpj.getText().length() > 14) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("CNPJ inválido");
            alerta.setContentText("Por favor insira um número de CNPJ com até 14 digitos.");
            alerta.show();
        } else {
            verifica_cnpj = 1;
        }

        if (verifica_data == 1 && verifica_numdoc == 1 && verifica_contadebito == 1 && verifica_contacredito == 1 && verifica_cnpj == 1) {
            c.setData(txtData.getText());
            c.setNumero_documento(txtNumDoc.getText());
            c.setConta_debito(txtContaDebito.getText());
            c.setConta_credito(txtContaCredito.getText());
            c.setCnpj(txtCnpj.getText());
            c.setValor(df.format(Float.parseFloat(txtValor.getText())).replace(",", "."));
            c.setHistorico(txtHistorico.getText());
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="CONFIGURAR AS BIND">
    private void ConfiguraBindings() {
        BooleanBinding camposPreenchidosRec = txtIdRec.textProperty().isEmpty().or(txtDataRec.textProperty().isEmpty().or(txtNumDocRec.textProperty().isEmpty().or(txtContaDebitoRec.textProperty().isEmpty().or(txtContaCreditoRec.textProperty().isEmpty().or(txtCnpjRec.textProperty().isEmpty().or(txtValorRec.textProperty().isEmpty().or(txtHistoricoRec.textProperty().isEmpty())))))));
        BooleanBinding algoSelecionadoRec = TableViewRec.getSelectionModel().selectedItemProperty().isNull();
        buttonDeletarIdRec.disableProperty().bind(algoSelecionadoRec);
        buttonAtualizarIdRec.disableProperty().bind(algoSelecionadoRec);
        TableViewRec.getSelectionModel().selectedItemProperty().addListener((b, o, n) -> {
            if (n != null) {
                txtDataRec.setText(n.getData_rec());
                txtNumDocRec.setText(n.getNumero_documento_rec());
                txtContaDebitoRec.setText(n.getConta_debito_rec());
                txtContaCreditoRec.setText(n.getConta_credito_rec());
                txtCnpjRec.setText(n.getCnpj_rec());
                txtValorRec.setText(n.getValor_rec());
                txtHistoricoRec.setText(n.getHistorico_rec());
            }
        });

        BooleanBinding camposPreenchidos = txtId.textProperty().isEmpty().or(txtData.textProperty().isEmpty().or(txtNumDoc.textProperty().isEmpty().or(txtContaDebito.textProperty().isEmpty().or(txtContaCredito.textProperty().isEmpty().or(txtCnpj.textProperty().isEmpty().or(txtValor.textProperty().isEmpty().or(txtHistorico.textProperty().isEmpty())))))));
        BooleanBinding algoSelecionado = TableViewPag.getSelectionModel().selectedItemProperty().isNull();
        buttonDeletarId.disableProperty().bind(algoSelecionado);
        buttonAtualizarId.disableProperty().bind(algoSelecionado);
        TableViewPag.getSelectionModel().selectedItemProperty().addListener((b, o, n) -> {
            if (n != null) {
                txtData.setText(n.getData());
                txtNumDoc.setText(n.getNumero_documento());
                txtContaDebito.setText(n.getConta_debito());
                txtContaCredito.setText(n.getConta_credito());
                txtCnpj.setText(n.getCnpj());
                txtValor.setText(n.getValor());
                txtHistorico.setText(n.getHistorico());
            }
        });

    }
    //</editor-fold>
    //</editor-fold>    

    public String Escolha(String result, String value) {
        return null;
    }

    private void gerarExcel(ActionEvent event) throws IOException, WriteException, SQLException {
        List<String> pegarValor = new ArrayList<>();
        ChoiceBox<String> escolha = new ChoiceBox();
        escolha.setItems(FXCollections.observableArrayList(
                "Calculos")
        );
        Alert alerta = new Alert(AlertType.CONFIRMATION);
        alerta.setTitle("Escolher relatório");
        alerta.setHeaderText("Por favor escolha um relatório: ");
        alerta.setGraphic(escolha);
        alerta.setContentText("Depois de escolher qual relatório gerar confirme apertando em ok.");
        alerta.showAndWait();
        int b = 0;
        if (escolha.getValue() == null && alerta.getResult().getText().equals("Cancelar")) {

        } else if (escolha.getValue() == null && alerta.getResult().getText().equals("OK")) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Escolha uma opção");
            alert.setContentText("Por favor selecione uma opção!");
            alert.showAndWait();
        } else {
            if (alerta.getResult().getText().equals("OK") && escolha.getValue().equals("Calculos")) {
                arquivoSaveXls();
                WritableFont bold = new WritableFont(WritableFont.ARIAL,
                        10, WritableFont.BOLD);
                bold.setColour(Colour.WHITE);
                WritableCellFormat table = new WritableCellFormat();
                table.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.MEDIUM);
                WritableCellFormat arial10font = new WritableCellFormat(bold);
                arial10font.setBackground(Colour.BLUE);
                arial10font.setAlignment(Alignment.CENTRE);
                arial10font.setBorder(Border.ALL, BorderLineStyle.MEDIUM, Colour.BLACK);
                WritableWorkbook workbook = Workbook.createWorkbook(file);
                WritableSheet sheet = workbook.createSheet("Relatório " + escolha.getValue(), 0);
                WritableCellFormat sheet_format = new WritableCellFormat(NumberFormats.FLOAT);
                sheet_format.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.MEDIUM);
                Label label_titulo_cnpj = new Label(0, 0, "CNPJ", arial10font);
                sheet.addCell(label_titulo_cnpj);
                Label label_titulo_nota = new Label(1, 0, "NUMERO NOTAS", arial10font);

                sheet.addCell(label_titulo_nota);
                Label label_titulo_valor = new Label(2, 0, "VALOR", arial10font);
                sheet.addCell(label_titulo_valor);
                Label label_titulo_valor_total = new Label(3, 0, "VALOR TOTAL ANTERIOR", arial10font);
                sheet.addCell(label_titulo_valor_total);
                PreparedStatement stmt = con.prepareStatement("SELECT data, cnpj, numero_nota, valor FROM result_calculo WHERE data BETWEEN ? AND ?");
                stmt.setString(1, txtDataInicial.getText());
                stmt.setString(2, txtDataFinal.getText());
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    b = sheet.getRows();
                    if (rs.getString("cnpj").equals("PULAR LINHA") && rs.getString("numero_nota").equals("PULAR LINHA") && rs.getString("valor").equals("PULAR LINHA")) {

                    } else {
                        if (rs.getFloat("valor") == 0) {

                        } else {
                            Label label_cnpj = new Label(0, b, rs.getString("cnpj"), table);
                            sheet.addCell(label_cnpj);
                            Label label_nota = new Label(1, b, rs.getString("numero_nota"), table);
                            sheet.addCell(label_nota);
                            Label label_valor = new Label(2, b, rs.getString("valor"), sheet_format);
                            sheet.addCell(label_valor);

                            PreparedStatement stmtn = con.prepareStatement("SELECT numero_nota, terceiro, SUM(valor_contabil) AS soma FROM prosoft_excel WHERE numero_nota = " + rs.getString("numero_nota") + " AND terceiro = " + rs.getString("cnpj") + " GROUP BY numero_nota, terceiro");
                            ResultSet rsn = stmtn.executeQuery();
                            while (rsn.next()) {
                                pegarValor.add(rsn.getString("soma"));
                                for (int a = 0; a < pegarValor.size(); a++) {
                                    String f = pegarValor.get(a);
                                    for (int c = a + 1; c < pegarValor.size(); c++) {
                                        String d = pegarValor.get(c);
                                        if (f == d) {
                                            pegarValor.remove(c);
                                            c--;
                                        }
                                    }
                                }
                            }
                            for (String valor_saida : pegarValor) {
                                Label label_valor_saida = new Label(3, b, valor_saida, sheet_format);
                                sheet.addCell(label_valor_saida);
                            }
                        }
                    }
                }
                workbook.write();
                workbook.close();
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Arquivo texto");
                alert.setContentText("O Arquivo texto foi gerado com sucesso! ");
                alert.showAndWait();
            } else {

            }
        }
    }
}
