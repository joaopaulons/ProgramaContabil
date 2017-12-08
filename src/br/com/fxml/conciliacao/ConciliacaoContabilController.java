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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.binding.BooleanBinding;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
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
    public static int a = 0;
    //</editor-fold>

    @FXML
    private ChoiceBox<String> RecPag;
    @FXML
    private Label txtRecPag;
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
    
    private DadosService service;
    @FXML
    private Button atualizarBD;

    /**
     * Initializes the controller class.
     */
    @Override

    public void initialize(URL url, ResourceBundle rb) {
        service = DadosService.getNewInstance();
        ConfiguraBindings();
        configuraColunas();
        atualizaDadosTabela();
        RecPag.setItems(FXCollections.observableArrayList(
                "Recebimento", "Recebimento/Juros", "Recebimento/Descontos", "Pagamento", "Pagamento/Juros", "Pagamento/Descontos")
        );
      
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

    public void arrayOpenTxt() throws SAXException, IOException, ParserConfigurationException, ParserConfigurationException {
        Stage stage = programacontabil.primaryStage;
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Abrir arquivos");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Arquivo texto", "*.txt"));
        diretorio = fileChooser.showOpenDialog(stage);

    }

    public void arquivoSave() throws IOException {
        Stage stage = programacontabil.primaryStage;
        File caminhofolle = new File("C:\\Users\\joao.santos\\Desktop");
        FileChooser chooser = new FileChooser();
        chooser.setInitialDirectory(caminhofolle);
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text file (*.txt)", "*.txt"));
        file = chooser.showSaveDialog(stage);

    }

    @FXML
    private void buttonImportarExcel(ActionEvent event) throws SAXException, IOException, ParserConfigurationException, BiffException, SQLException, InterruptedException {
        
        // <editor-fold defaultstate="collapsed" desc="VARIÁVEIS">        
        //        <!----- DECLARAÇÃO DE VÁRIAVEIS -----!>
        float teste = 0;
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

        // <editor-fold defaultstate="collapsed" desc="TRUNCANDO O BANCO DE DADOS">
        try {
            PreparedStatement stmt_truncar = con.prepareStatement("TRUNCATE TABLE calcular");
            stmt_truncar.execute();
            stmt_truncar = con.prepareStatement("TRUNCATE TABLE novosvalores");
            stmt_truncar.execute();
            stmt_truncar.close();
            stmt_truncar.close();

        } catch (SQLException error) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Erro ao limpar o banco de dados.");
            alerta.setContentText("Erro ao limpar os dados do banco de dados: " + error);
            alerta.setHeaderText("Erro com o banco de dados.");
            alerta.setResizable(false);
            alerta.show();
        }
        //</editor-fold>

        // <editor-fold defaultstate="collapsed" desc="ABRIR E LER XLS">
        arrayOpen();
        for (Object caminho_ob : array_caminho) {
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
                //Fim ler todas as linhas do excel
                //</editor-fold>

                // <editor-fold defaultstate="collapsed" desc="PROCESSAMENTO DOS DADOS">
                if (as5.equals("0")) {

                    // <editor-fold defaultstate="collapsed" desc="OUTROS VALORES">
                    try {
                        con = ConnectionFactory.getConnection();
                        String sql = "INSERT INTO novosvalores(numero_nota,terceiro, valor_contabil) VALUES('" + as1 + "','" + as3 + "','" + as4.replace(".", "").replace(",", ".") + "')";
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
                        String sql = "INSERT INTO calcular(numero_nota,terceiro, valor_contabil) VALUES('" + as1 + "','" + as3 + "','" + as4.replace(".", "").replace(",", ".") + "')";
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
                        PreparedStatement stmt = con.prepareStatement("SELECT numero_nota FROM calcular");
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
                        PreparedStatement stmt = con.prepareStatement("SELECT terceiro FROM calcular");
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
                        PreparedStatement stmt = con.prepareStatement("SELECT SUM(valor_contabil)  as soma from calcular group by numero_nota, terceiro;");
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
                            String sql = "INSERT INTO novosvalores(numero_nota,terceiro, valor_contabil) VALUES('" + numero_nota + "','" + terceiro + "','" + valor + "')";
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
    }

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

    @FXML
    private void buttonCalcular(ActionEvent event) {
    }

    @FXML
    private void buttonGerarConciliados(ActionEvent event) {
    }

    @FXML
    private void buttonGerarNaoConciliados(ActionEvent event) {
    }

    public void LerTxt() throws FileNotFoundException, SAXException, IOException, ParserConfigurationException, BiffException, SQLException {
        String Rec_Pag = RecPag.getValue();
        arrayOpenTxt();
        try {
            FileReader arq = new FileReader(diretorio);
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine();
            while (linha != null) {

                // <editor-fold defaultstate="collapsed" desc="TRUNCANDO TABELAS">
                switch (Rec_Pag) {

                    case "Recebimento":
                        String data = linha.substring(12, 20);
                        String numero_documento = linha.substring(20, 31).replace(" ", "");
                        String conta_debito = linha.substring(68, 73);
                        String conta_credito = linha.substring(92, 97);
                        String cnpj = linha.substring(97, 111);
                        String valor = linha.substring(116, 132);
                        String historico = linha.substring(133, 239).replace("  ", "");
                        if (historico.contains("'")) {
                            historico = historico.replace("'", "-");
                        }
                        try {
                            Connection con = ConnectionFactory.getConnection();
                            PreparedStatement stmt = con.prepareStatement("Insert into recebimento(data,numero_documento,conta_debito,conta_credito,cnpj,valor,historico) VALUES('"
                                    + data + "','" + numero_documento + "','" + conta_debito + "','" + conta_credito + "','" + cnpj + "','" + valor + "','" + historico + "')");
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
                            String numero_documento_pg = linha.substring(20, 31).replace(" ", "");
                            String conta_debito_pg = linha.substring(68, 73);
                            String conta_credito_pg = linha.substring(92, 97);
                            String cnpj_pg = linha.substring(73, 87);
                            String valor_pg = linha.substring(116, 132);
                            String historico_pg = linha.substring(133, 239).replace("  ", "");
                            if (historico_pg.contains("'")) {
                                historico_pg = historico_pg.replace("'", "-");
                            }
                            Connection con = ConnectionFactory.getConnection();
                            PreparedStatement stmt = con.prepareStatement("Insert into pagamento(data,numero_documento,conta_debito,conta_credito,cnpj,valor,historico) VALUES('"
                                    + data_pg + "','" + numero_documento_pg + "','" + conta_debito_pg + "','" + conta_credito_pg + "','" + cnpj_pg + "','" + valor_pg + "','" + historico_pg + "')");
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

    public void LerTxtJur() throws SAXException, IOException, ParserConfigurationException {
        String Rec_Pag = RecPag.getValue();
        arrayOpenTxt();
        try {
            FileReader arq = new FileReader(diretorio);
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine();
            while (linha != null) {

                // <editor-fold defaultstate="collapsed" desc="TRUNCANDO TABELAS">
                switch (Rec_Pag) {
                    case "Recebimento/Juros":
                        try {

                            String data = linha.substring(12, 20);
                            String numero_documento = linha.substring(20, 31).replace(" ", "");
                            String conta_debito = linha.substring(68, 74);
                            String conta_credito = linha.substring(92, 97);
                            String cnpj = linha.substring(97, 111);
                            String valor = linha.substring(116, 132);
                            String historico = linha.substring(133, 239).replace("  ", "");
                            if (historico.contains("'")) {
                                historico = historico.replace("'", "-");
                            }
                            Connection con = ConnectionFactory.getConnection();
                            PreparedStatement stmt = con.prepareStatement("Insert into recebimento(data,numero_documento,conta_debito,conta_credito,cnpj,valor,historico) VALUES('"
                                    + data + "','" + numero_documento + "','" + conta_debito + "','" + conta_credito + "','" + cnpj + "','" + valor + "','" + historico + "')");
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
                            String numero_documento_pg = linha.substring(20, 31).replace(" ", "");
                            String conta_debito_pg = linha.substring(68, 74);
                            String conta_credito_pg = linha.substring(92, 97);
                            String cnpj_pg = linha.substring(97, 111);
                            String valor_pg = linha.substring(116, 132);
                            String historico_pg = linha.substring(133, 239).replace("  ", "");
                            if (historico_pg.contains("'")) {
                                historico_pg = historico_pg.replace("'", "-");
                            }
                            Connection con = ConnectionFactory.getConnection();
                            PreparedStatement stmt = con.prepareStatement("Insert into pagamento(data,numero_documento,conta_debito,conta_credito,cnpj,valor,historico) VALUES('"
                                    + data_pg + "','" + numero_documento_pg + "','" + conta_debito_pg + "','" + conta_credito_pg + "','" + cnpj_pg + "','" + valor_pg + "','" + historico_pg + "')");
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

    public void LerTxtDesc() throws SAXException, IOException, ParserConfigurationException {
        String Rec_Pag = RecPag.getValue();
        arrayOpenTxt();
        try {
            FileReader arq = new FileReader(diretorio);
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine();
            while (linha != null) {
                String data = linha.substring(12, 20);
                String numero_documento = linha.substring(20, 31).replace(" ", "");
                String conta_debito = linha.substring(92, 97);
                String conta_credito = linha.substring(68, 73);
                String cnpj = linha.substring(97, 112);
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
                            PreparedStatement stmt = con.prepareStatement("Insert into recebimento(data,numero_documento,conta_debito,conta_credito,cnpj,valor,historico) VALUES('"
                                    + data + "','" + numero_documento + "','" + conta_debito + "','" + conta_credito + "','" + cnpj + "','" + valor + "','" + historico + "')");
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
                            String numero_documento_pg = linha.substring(20, 31).replace(" ", "");
                            String conta_debito_pg = linha.substring(92, 97);
                            String conta_credito_pg = linha.substring(68, 73);
                            String cnpj_pg = linha.substring(97, 112);
                            String valor_pg = linha.substring(116, 132);
                            String historico_pg = linha.substring(133, 239).replace("  ", "");
                            if (historico_pg.contains("'")) {
                                historico_pg = historico_pg.replace("'", "-");
                            }
                            Connection con = ConnectionFactory.getConnection();
                            PreparedStatement stmt = con.prepareStatement("Insert into pagamento(data,numero_documento,conta_debito,conta_credito,cnpj,valor,historico) VALUES('"
                                    + data_pg + "','" + numero_documento_pg + "','" + conta_debito_pg + "','" + conta_credito_pg + "','" + cnpj_pg + "','" + valor_pg + "','" + historico_pg + "')");
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

    @FXML
    private void buttonInserir(ActionEvent event) {
        Dados c = new Dados();
        pegaValores(c);
        service.salvar(c);
        atualizaDadosTabela();
    }

    @FXML
    private void buttonAtualizar(ActionEvent event) {
        Dados c = TableViewPag.getSelectionModel().getSelectedItem();
        pegaValores(c);
        service.atualizar(c);
        atualizaDadosTabela();
        buttonLimpar(event);

    }

    @FXML
    private void buttonDeletar(ActionEvent event) {
        Dados c = TableViewPag.getSelectionModel().getSelectedItem();
        service.apagar(c.getId());
        atualizaDadosTabela();
    }

    @FXML
    private void buttonBuscar(ActionEvent event) {
        Dados c = null;  
        Dados buscarPorData = service.buscarPorData(c.getData());
        atualizaDadosTabela();
    }

    @FXML
    private void buttonBuscarTodos(ActionEvent event) {
    }

    @FXML
    private void buttonLimpar(ActionEvent event) {
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

    @FXML
    private void buttonTablePagamento(ActionEvent event) {
        
        TableViewPag.setVisible(true);
        buttonBar.setVisible(true);
        txtFields1.setVisible(true);
        txtFields2.setVisible(true);
        atualizarBD.setVisible(true);
        
    }

    @FXML
    private void buttonTableRecebimento(ActionEvent event) {
    }

    @FXML
    private void buttonAtualizarBD(ActionEvent event) {
        service = DadosService.getNewInstance();
        ConfiguraBindings();
        configuraColunas();
        atualizaDadosTabela();
    }

    public class Formula {

        private String numero_nota;
        private String data_escrituracao;
        private String terceiro;
        private String valor_contabil;
    }
   
    private void configuraColunas() {
        tablePgId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tablePagData.setCellValueFactory(new PropertyValueFactory<>("data"));
        tablePagNumDoc.setCellValueFactory(new PropertyValueFactory<>("numero_documento"));
        tablePgContaDebito.setCellValueFactory(new PropertyValueFactory<>("conta_debito"));
        tablePgContaCredito.setCellValueFactory(new PropertyValueFactory<>("conta_credito"));
        tablePgCnpj.setCellValueFactory(new PropertyValueFactory<>("cnpj"));
        tablePagValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
        tablePagHistorico.setCellValueFactory(new PropertyValueFactory<>("historico"));
    }

    private void atualizaDadosTabela() {
        TableViewPag.getItems().setAll(service.buscarTodas());

    }

    private void pegaValores(Dados c) {
        
        c.setData(txtData.getText());
        c.setNumero_documento(txtNumDoc.getText());
        c.setConta_debito(txtContaDebito.getText());
        c.setConta_credito(txtContaCredito.getText());
        c.setCnpj(txtCnpj.getText());
        c.setValor(txtValor.getText());
        c.setHistorico(txtHistorico.getText());
    }

    private void ConfiguraBindings() {
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

}
