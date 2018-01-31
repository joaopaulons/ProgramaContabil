/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alfacapa.controllers;

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
import javafx.beans.binding.BooleanBinding;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * FXML Controller class
 *
 * @author joao.santos
 */
public class alfaCapaControllers implements Initializable {

    public static ArrayList array_caminho = new ArrayList<>();
    public static PrintWriter gravarArq;
    public static File file;
    public static int flag = 0;
    public static int avancar = 0;

    @FXML
    private Button btnLerXML;
    @FXML
    private Button btnTratamento;
    @FXML
    private Button btnGerarTxt;
    @FXML
    private Group groupCFOP;
    @FXML
    private TableView<CFOPDados> tableCFOP;
    @FXML
    private TableColumn<CFOPDados, Integer> colID;
    @FXML
    private TableColumn<CFOPDados, String> colCFOPEntrada;
    @FXML
    private TableColumn<CFOPDados, String> colCFOPSaida;
    @FXML
    private ChoiceBox<String> choiceBoxBD;
    @FXML
    private Button btnSalvar;
    @FXML
    private Button btnApagar;
    @FXML
    private TextField txtFieldID;
    @FXML
    private TextField txtFieldCFOPEntrada;
    @FXML
    private TextField txtFiedlCFOPSaida;
    private CFOPServices serviceCFOP;
    @FXML
    private HBox HBoxChoiceBD;
    @FXML
    private Label lblData;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        choiceBoxBD.setItems(FXCollections.observableArrayList(
                "Inserir CFOP")
        );
        serviceCFOP = CFOPServices.getNewInstance();
        ConfiguraBindingsCFOP();
        configuraColunasCFOP();
        atualizaTableCFOP();
        HBoxChoiceBD.setVisible(true);
    }

    @FXML
    private void buttonGerarTxt(ActionEvent event) {
        if (avancar == 2) {
            try {
                Connection con = ConnectionFactory.getConnection();
                PreparedStatement stmt;
                stmt = con.prepareStatement("TRUNCATE TABLE saida_informacoes");
                stmt.execute();
                stmt.close();

                saidaInformacoesCFOPFinal();
                saidaInfoCNPJ();
                saidaInfodhEmi();
                inscricaoEstadual();
                UF();
                tipoFretee();
                numDoc();
                saidaIndPag();
                codMunicipio();
                horaEmissao();
                OutrasDespesas();
                transformarCFOP();
                avancar = 1;
                if (flag == 0) {
                    arquivoSave();
                    gerarTxt();
                    programaFinalizado();
                    avancar = 0;
                }
            } catch (SAXException | IOException | ParserConfigurationException | SQLException ex) {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Erro");
                alerta.setContentText("Por favor informe este erro ao T.I: " + ex);
                alerta.showAndWait();
            }
        } else {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Erro");
            alerta.setContentText("Execute os outros procedimentos primeiro antes de executar este.");
            alerta.showAndWait();

        }
    }

    @FXML
    private void buttonFazerTratamento(ActionEvent event) {
        if (avancar == 1) {
            try {
                tratamentoCFOP();
                tratamentovOutro();
                tratamentovDesc();
                tratamentovProd();
                tratamentoCST();
                tratamentoCFOPDesdobro();
                tratamentovFrete();
                tratamentovSeg();
                Isentas();
                calculoTotalNota();
                calculoOutras();
                calculoOutras40();
                avancar = 2;
                programaFinalizado();

            } catch (SAXException | IOException | ParserConfigurationException | SQLException ex) {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Erro");
                alerta.setContentText("Por favor informe este erro ao T.I: " + ex);
                alerta.showAndWait();
            }
        } else {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Erro");
            alerta.setContentText("Por favor primeiro selecione os XML's que desejar ler.\n Só depois então execute este procedimento. ");
            alerta.showAndWait();
        }
    }

    @FXML
    private void buttonLerXML(ActionEvent event) {
        try {
            arrayOpen();
            truncarTabelas();
            det();
            verProc();
            procEmi();
            indPres();
            indFinal();
            finNFe();
            tpAmb();
            cDV();
            tpEmis();
            tpImp();
            cMunFG();
            idDest();
            tpNF();
            dhSaiEnt();
            dhEmi();
            nNF();
            serie();
            mod();
            indPag();
            natOp();
            cNF();
            cUF();
            emit();
            fornecedor();
            tipoFrete();
            vProd();
            vFrete();
            vSeg();
            vDesc();
            vOutro();
            vNF();
            programaFinalizado();
            avancar = 1;
        } catch (SAXException | IOException | ParserConfigurationException | SQLException ex) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Erro");
            alerta.setContentText("Por favor informe este erro ao T.I: " + ex);
            alerta.showAndWait();
        }
        array_caminho.removeAll(array_caminho);
    }

    // <editor-fold defaultstate="collapsed" desc="SAIDA DOS CAMPOS">
    private void programaFinalizado() {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Finalizado");
        alerta.setContentText("Processo finalizado com sucesso!");
        alerta.showAndWait();
    }

    private void gerarTxt() throws SAXException, IOException, ParserConfigurationException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;

        stmt = con.prepareStatement("SELECT CNPJ, dhEmi, Desdo, vProd, Isentas_Tributadas, Outras, ValorTotalNota, CondicoesPagamento, "
                + "InscricaoEstadualFornecedor, UFInscEstadualFornecedor, TipoFrete, CFOPEntrada, CodigoMunFornecedor, NumeroDocumento, HoraEmissao, ChaveFiscalNota, ValorDescontos, OutrasDespesas FROM saida_informacoes");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            // <editor-fold defaultstate="collapsed" desc="VARIAVEIS">
            String dia = null;
            String mes = null;
            String ano = null;
            if (rs.getString("dhEmi") == null) {

            } else {
                dia = rs.getString("dhEmi").substring(8, 10);
                mes = rs.getString("dhEmi").substring(5, 7);
                ano = rs.getString("dhEmi").substring(2, 4);
            }
            String hora = null;
            String dhEmi = dia + mes + ano;
            int inscricaoestadual = rs.getString("InscricaoEstadualFornecedor").length();
            String espaco = null;
            String outrasDespesas = "00000000000.00";
            String isentas = rs.getString("Isentas_Tributadas");
            String saida_isentas = null;
            String Outras = "00000000000.00";
            //</editor-fold>

            // <editor-fold defaultstate="collapsed" desc="ISENTAS">
            if (isentas == null) {
                saida_isentas = "00000000000.00";
            } else {
                saida_isentas = isentas;
            }
            //</editor-fold>

            // <editor-fold defaultstate="collapsed" desc="OUTRAS DESPESAS">
            if (rs.getString("OutrasDespesas") == null) {

            } else {
                outrasDespesas = rs.getString("OutrasDespesas");
            }
            //</editor-fold>

            // <editor-fold defaultstate="collapsed" desc="NUMERO DOCUMENTO">
            DecimalFormat df = new DecimalFormat("0000000000");
            float num = rs.getFloat("NumeroDocumento");
            String numero_documento = df.format(num).replace(",", "").replace(".", "");
            //</editor-fold>

            // <editor-fold defaultstate="collapsed" desc="INSCRIÇÃO ESTADUAL">
            if (inscricaoestadual == 18) {
                espaco = "";
            } else {
                if (inscricaoestadual == 17) {
                    espaco = " ";
                } else {
                    if (inscricaoestadual == 16) {
                        espaco = "  ";
                    } else {
                        if (inscricaoestadual == 15) {
                            espaco = "   ";
                        } else {
                            if (inscricaoestadual == 14) {
                                espaco = "    ";
                            } else {
                                if (inscricaoestadual == 13) {
                                    espaco = "     ";
                                } else {
                                    if (inscricaoestadual == 12) {
                                        espaco = "      ";
                                    } else {
                                        if (inscricaoestadual == 11) {
                                            espaco = "       ";
                                        } else {
                                            if (inscricaoestadual == 10) {
                                                espaco = "        ";
                                            } else {
                                                if (inscricaoestadual == 9) {
                                                    espaco = "         ";
                                                } else {
                                                    if (inscricaoestadual == 8) {
                                                        espaco = "          ";
                                                    } else {
                                                        if (inscricaoestadual == 7) {
                                                            espaco = "           ";
                                                        } else {
                                                            if (inscricaoestadual == 6) {
                                                                espaco = "            ";
                                                            } else {
                                                                if (inscricaoestadual == 5) {
                                                                    espaco = "             ";
                                                                } else {
                                                                    if (inscricaoestadual == 4) {
                                                                        espaco = "              ";
                                                                    } else {
                                                                        if (inscricaoestadual == 3) {
                                                                            espaco = "               ";
                                                                        } else {
                                                                            if (inscricaoestadual == 2) {
                                                                                espaco = "                ";
                                                                            } else {
                                                                                if (inscricaoestadual == 1) {
                                                                                    espaco = "                 ";
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            //</editor-fold>

            // <editor-fold defaultstate="collapsed" desc="VALOR DESCONTOS">
            DecimalFormat dff = new DecimalFormat("00000000000.00");
            float valordesconto = rs.getFloat("ValorDescontos");
            String vdesc = dff.format(valordesconto).replace(",", ".");
            if (vdesc.equals("00000000000.00")) {
                vdesc = "00000000000000";
            }
            //</editor-fold>

            // <editor-fold defaultstate="collapsed" desc="HORA EMISSAO">
            if (rs.getString("dhEmi") == null) {

            } else {
                hora = rs.getString("dhEmi").substring(11, 19);
            }
            //</editor-fold>

            // <editor-fold defaultstate="collapsed" desc="OUTRAS">
            if (rs.getString("Outras") == null) {

            } else {
                Outras = rs.getString("Outras");
            }
            //</editor-fold>
            try (FileWriter fw = new FileWriter(file, true); PrintWriter gravarArq = new PrintWriter(fw)) {
                gravarArq.println("    " + rs.getString("CNPJ") + dhEmi + dhEmi + "            " + rs.getString("Desdo") + "        " + rs.getString("vProd") + "00000000000.00" + "00000000000.00" + saida_isentas + Outras + "00000000000.00" + "00.00" + "00000000000.00" + "00000000000.00" + "00000000000.00" + "00000000000.00" + "00000000000.00" + rs.getString("ValorTotalNota") + "1" + "     "
                        + "000000000.00000000000.00000000000.00000000000.00" + "                                                                                                                                                                                                                            " + rs.getString("InscricaoEstadualFornecedor") + espaco + rs.getString("UFInscEstadualFornecedor") + "1" + "                                                                                                        " + rs.getString("CFOPEntrada") + rs.getString("CodigoMunFornecedor") + "                                                                                                                                            " + "00000000000.0000000000000.00      0      00000000000.0000000000000.00" + outrasDespesas + "NF-E 01" + "    " + numero_documento
                        + "00000000000000000000        " + hora + "        00000000000000000000000000000000000000000000000000" + rs.getString("ChaveFiscalNota") + "                                                                         " + "0" + "                                   " + vdesc + "00                        " + "1                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                " + "000000000.000000.00000000000.00000000000.00    000.0000                    00000000000000.000000000000000.000000000000000.000000000000000.00");
                fw.close();
                gravarArq.close();
            }
        }
    }

    private void OutrasDespesas() throws SAXException, IOException, ParserConfigurationException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        ResultSet rs;
        stmt = con.prepareStatement("SELECT vOutro, chNFe FROM cfop_final");
        rs = stmt.executeQuery();
        while (rs.next()) {
            stmt = con.prepareStatement("UPDATE saida_informacoes SET OutrasDespesas = ?  WHERE ChaveFiscalNota = ?");
            stmt.setString(1, rs.getString("vOutro"));
            stmt.setString(2, rs.getString("chNFe"));
            stmt.execute();
            stmt.close();
        }
    }

    private void transformarCFOP() throws SAXException, IOException, ParserConfigurationException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        ResultSet rs;
        List<String> cfops = new ArrayList<>();
        String cfop_repetido = null;
        String verificar = null;
        int flag_cfop = 0;

        stmt = con.prepareStatement("SELECT CFOPEntrada FROM saida_informacoes");
        rs = stmt.executeQuery();
        while (rs.next()) {
            PreparedStatement consulta = con.prepareStatement("SELECT cfopENTRADA, cfopSAIDA FROM cfop_entrada");
            ResultSet rsConsulta = consulta.executeQuery();
            while (rsConsulta.next()) {
                stmt = con.prepareStatement("UPDATE saida_informacoes SET CFOPEntrada = ? WHERE CFOPEntrada = ?");
                stmt.setString(1, rsConsulta.getString("cfopENTRADA"));
                stmt.setString(2, rsConsulta.getString("cfopSAIDA"));
                stmt.executeUpdate();
                stmt.close();
            }
        }

        stmt = con.prepareStatement("SELECT CFOPEntrada FROM saida_informacoes");
        rs = stmt.executeQuery();
        while (rs.next()) {
            if (rs.getString("CFOPEntrada").substring(0, 1).equals("5") || rs.getString("CFOPEntrada").substring(0, 1).equals("6")) {
                cfop_repetido = rs.getString("CFOPEntrada");
                if (cfop_repetido.equals(verificar)) {

                } else {
                    if (cfops.contains(cfop_repetido)) {

                    } else {
                        cfops.add(cfop_repetido);
                    }
                }
                verificar = cfop_repetido;
                flag_cfop = 1;
            } else {

            }
        }
        if (flag_cfop == 1) {
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("CFOP inexistente");
            alerta.setContentText("Antes de prosseguir, por favor adicione o seguinte CFOP no banco de dados: \n" + cfops);
            alerta.showAndWait();
            flag = 1;
            avancar = 3;
        }

        cfops.removeAll(cfops);
    }

    private void horaEmissao() throws SAXException, IOException, ParserConfigurationException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        ResultSet rs;
        stmt = con.prepareStatement("SELECT dhEmi, chNFe FROM dhemi");
        rs = stmt.executeQuery();
        while (rs.next()) {
            stmt = con.prepareStatement("UPDATE saida_informacoes SET HoraEmissao = ?  WHERE ChaveFiscalNota = ?");
            stmt.setString(1, rs.getString("dhEmi"));
            stmt.setString(2, rs.getString("chNFe"));
            stmt.execute();
            stmt.close();
        }
    }

    private void codMunicipio() throws SAXException, IOException, ParserConfigurationException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        ResultSet rs;

        stmt = con.prepareStatement("SELECT cMun, chNFe FROM cmun");
        rs = stmt.executeQuery();
        while (rs.next()) {
            stmt = con.prepareStatement("UPDATE saida_informacoes SET CodigoMunFornecedor = ?  WHERE ChaveFiscalNota = ?");
            stmt.setString(1, rs.getString("cMun"));
            stmt.setString(2, rs.getString("chNFe"));
            stmt.execute();
            stmt.close();
        }
    }

    private void saidaIndPag() throws SAXException, IOException, ParserConfigurationException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        ResultSet rs;
        stmt = con.prepareStatement("SELECT indPag, chNFe FROM indpag");
        rs = stmt.executeQuery();
        while (rs.next()) {
            stmt = con.prepareStatement("UPDATE saida_informacoes SET CondicoesPagamento = ?  WHERE ChaveFiscalNota = ?");
            stmt.setString(1, rs.getString("indPag"));
            stmt.setString(2, rs.getString("chNFe"));
            stmt.execute();
            stmt.close();
        }
    }

    private void numDoc() throws SAXException, IOException, ParserConfigurationException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        ResultSet rs;
        stmt = con.prepareStatement("SELECT nNF, chNFe FROM nnf");
        rs = stmt.executeQuery();
        while (rs.next()) {
            stmt = con.prepareStatement("UPDATE saida_informacoes SET NumeroDocumento = ?  WHERE ChaveFiscalNota = ?");
            stmt.setString(1, rs.getString("nNF"));
            stmt.setString(2, rs.getString("chNFe"));
            stmt.execute();
            stmt.close();
        }
    }

    private void tipoFretee() throws SAXException, IOException, ParserConfigurationException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        ResultSet rs;
        stmt = con.prepareStatement("SELECT modFrete, chNFe FROM modfrete");
        rs = stmt.executeQuery();
        while (rs.next()) {
            stmt = con.prepareStatement("UPDATE saida_informacoes SET TipoFrete = ?  WHERE ChaveFiscalNota = ?");
            stmt.setString(1, rs.getString("modFrete"));
            stmt.setString(2, rs.getString("chNFe"));
            stmt.execute();
            stmt.close();
        }
    }

    private void UF() throws SAXException, IOException, ParserConfigurationException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        ResultSet rs;
        stmt = con.prepareStatement("SELECT UF, chNFe FROM uf");
        rs = stmt.executeQuery();
        while (rs.next()) {
            stmt = con.prepareStatement("UPDATE saida_informacoes SET UFInscEstadualFornecedor = ?  WHERE ChaveFiscalNota = ?");
            stmt.setString(1, rs.getString("UF"));
            stmt.setString(2, rs.getString("chNFe"));
            stmt.execute();
            stmt.close();
        }
    }

    private void inscricaoEstadual() throws SAXException, IOException, ParserConfigurationException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        ResultSet rs;
        stmt = con.prepareStatement("SELECT IE, chNFe FROM ie");
        rs = stmt.executeQuery();
        while (rs.next()) {
            stmt = con.prepareStatement("UPDATE saida_informacoes SET InscricaoEstadualFornecedor = ?  WHERE ChaveFiscalNota = ?");
            stmt.setString(1, rs.getString("IE"));
            stmt.setString(2, rs.getString("chNFe"));
            stmt.execute();
            stmt.close();
        }
    }

    private void saidaInformacoesCFOPFinal() throws SAXException, IOException, ParserConfigurationException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        ResultSet rs;
        //Setando no banco de dados a Chave da Nota
        stmt = con.prepareStatement("SELECT CFOP, chNFe, Desdo, total_nota, Outras, vProd, isentas, vDesc FROM cfop_final");
        rs = stmt.executeQuery();
        while (rs.next()) {
            stmt = con.prepareStatement("INSERT INTO saida_informacoes(CFOPEntrada,ChaveFiscalNota,Desdo,ValorTotalNota, Outras, vProd, Isentas_Tributadas, ValorDescontos) VALUES(?,?,?,?,?,?,?,?)");
            stmt.setString(1, rs.getString("CFOP"));
            stmt.setString(2, rs.getString("chNFe"));
            stmt.setString(3, rs.getString("Desdo"));
            stmt.setString(4, rs.getString("total_nota"));
            stmt.setString(5, rs.getString("Outras"));
            stmt.setString(6, rs.getString("vProd"));
            stmt.setString(7, rs.getString("isentas"));
            stmt.setString(8, rs.getString("vDesc"));
            stmt.execute();
            stmt.close();
        }
        //fim cnpj

    }

    private void saidaInfoCNPJ() throws SAXException, IOException, ParserConfigurationException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        ResultSet rs;
        //Setando no banco de dados o CNPJ
        stmt = con.prepareStatement("SELECT CNPJ, chNFe FROM cnpj");
        rs = stmt.executeQuery();
        while (rs.next()) {
            stmt = con.prepareStatement("UPDATE saida_informacoes SET CNPJ = ?  WHERE ChaveFiscalNota = ?");
            stmt.setString(1, rs.getString("CNPJ"));
            stmt.setString(2, rs.getString("chNFe"));
            stmt.execute();
            stmt.close();

        }
        //fim cnpj
    }

    private void saidaInfodhEmi() throws SAXException, IOException, ParserConfigurationException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        ResultSet rs;
        //Setando no banco de dados o CNPJ

        stmt = con.prepareStatement("SELECT dhEmi, chNFe FROM dhemi");
        rs = stmt.executeQuery();
        while (rs.next()) {
            stmt = con.prepareStatement("UPDATE saida_informacoes SET dhEmi = ?  WHERE ChaveFiscalNota = ?");
            stmt.setString(1, rs.getString("dhEmi"));
            stmt.setString(2, rs.getString("chNFe"));
            stmt.execute();
            stmt.close();
        }
        //fim cnpj
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="CALCULO DOS CAMPOS">
    private void calculoOutras() throws SAXException, IOException, ParserConfigurationException, SQLException {
        /*
        Aqui é feito o calculo da tag Outras do XML, primeiro eu pesquiso no banco "icms" todas as CST's 40 
        então pesquiso a chave delas e a CST no banco cfop_final, onde eu pego todos os valores depois para
        efetuar o calculo.
         */
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        float calculo = 0;
        float vprod = 0;
        ResultSet rs;
        DecimalFormat df = new DecimalFormat("00000000000.00");
        stmt = con.prepareStatement("SELECT CST, chNFe FROM icms");
        rs = stmt.executeQuery();
        while (rs.next()) {
            stmt = con.prepareStatement("SELECT CST, chNFe FROM icms WHERE CST != ?");
            stmt.setString(1, "40");
            rs = stmt.executeQuery();
            while (rs.next()) {
                stmt = con.prepareStatement("SELECT SUM(vProd) as vprod FROM cfop_final WHERE CST = ? AND chNFe = ?");
                stmt.setString(1, rs.getString("CST"));
                stmt.setString(2, rs.getString("chNFe"));
                ResultSet vprod_rs = stmt.executeQuery();
                while (vprod_rs.next()) {
                    stmt = con.prepareStatement("SELECT SUM(vFrete) as vfrete FROM cfop_final WHERE CST = ? AND chNFe = ?");
                    stmt.setString(1, rs.getString("CST"));
                    stmt.setString(2, rs.getString("chNFe"));
                    ResultSet vfrete_rs = stmt.executeQuery();
                    while (vfrete_rs.next()) {
                        stmt = con.prepareStatement("SELECT SUM(vSeg) as vseg FROM cfop_final WHERE CST = ? AND chNFe = ?");
                        stmt.setString(1, rs.getString("CST"));
                        stmt.setString(2, rs.getString("chNFe"));
                        ResultSet vseg_rs = stmt.executeQuery();
                        while (vseg_rs.next()) {
                            stmt = con.prepareStatement("SELECT SUM(vDesc) as vdesc FROM cfop_final WHERE CST = ? AND chNFe = ?");
                            stmt.setString(1, rs.getString("CST"));
                            stmt.setString(2, rs.getString("chNFe"));
                            ResultSet vdesc_rs = stmt.executeQuery();
                            while (vdesc_rs.next()) {
                                stmt = con.prepareStatement("SELECT SUM(vOutro) as voutro FROM cfop_final WHERE CST = ? AND chNFe = ?");
                                stmt.setString(1, rs.getString("CST"));
                                stmt.setString(2, rs.getString("chNFe"));
                                ResultSet voutro_rs = stmt.executeQuery();
                                while (voutro_rs.next()) {
                                    calculo = vprod_rs.getFloat("vprod") + vfrete_rs.getFloat("vfrete") + vseg_rs.getFloat("vseg") + voutro_rs.getFloat("voutro") - vdesc_rs.getFloat("vdesc");
                                    String formatado = df.format(calculo).replace(",", ".");
                                    stmt = con.prepareStatement("UPDATE cfop_final SET Outras = ?  WHERE CST = ? AND chNFe = ?");
                                    stmt.setString(1, formatado);
                                    stmt.setString(2, rs.getString("CST"));
                                    stmt.setString(3, rs.getString("chNFe"));
                                    stmt.executeUpdate();
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void calculoOutras40() throws SAXException, IOException, ParserConfigurationException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        float calculo = 0;
        DecimalFormat df = new DecimalFormat("00000000000.00");
        stmt = con.prepareStatement("SELECT total_nota, isentas, chNFe FROM cfop_final WHERE CST = 40");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            calculo = rs.getFloat("total_nota") - rs.getFloat("isentas");
            String formatado = df.format(calculo).replace(",", ".");
            stmt = con.prepareStatement("UPDATE cfop_final SET Outras = ?  WHERE CST = 40 AND chNFe = ?");
            stmt.setString(1, formatado);
            stmt.setString(2, rs.getString("chNFe"));
            stmt.executeUpdate();
        }
    }

    private void Isentas() throws SAXException, IOException, ParserConfigurationException, SQLException {
        /*
        Aqui é feito o calculo da tag Outras do XML, primeiro eu pesquiso no banco "icms" todas as CST's 40 
        então pesquiso a chave delas e a CST no banco cfop_final, onde eu pego todos os valores depois para
        efetuar o calculo.
         */
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        float calculo = 0;
        float vprod = 0;
        ResultSet rs;
        DecimalFormat df = new DecimalFormat("00000000000.00");
        stmt = con.prepareStatement("SELECT CST, chNFe FROM icms WHERE CST = ?");
        stmt.setString(1, "40");
        rs = stmt.executeQuery();
        while (rs.next()) {
            stmt = con.prepareStatement("SELECT SUM(vProd) as vprod FROM cfop_final WHERE CST = ? AND chNFe = ?");
            stmt.setString(1, "40");
            stmt.setString(2, rs.getString("chNFe"));
            ResultSet vprod_rs = stmt.executeQuery();
            while (vprod_rs.next()) {
                stmt = con.prepareStatement("SELECT SUM(vFrete) as vfrete FROM cfop_final WHERE CST = ? AND chNFe = ?");
                stmt.setString(1, "40");
                stmt.setString(2, rs.getString("chNFe"));
                ResultSet vfrete_rs = stmt.executeQuery();
                while (vfrete_rs.next()) {
                    stmt = con.prepareStatement("SELECT SUM(vSeg) as vseg FROM cfop_final WHERE CST = ? AND chNFe = ?");
                    stmt.setString(1, "40");
                    stmt.setString(2, rs.getString("chNFe"));
                    ResultSet vseg_rs = stmt.executeQuery();
                    while (vseg_rs.next()) {
                        stmt = con.prepareStatement("SELECT SUM(vDesc) as vdesc FROM cfop_final WHERE CST = ? AND chNFe = ?");
                        stmt.setString(1, "40");
                        stmt.setString(2, rs.getString("chNFe"));
                        ResultSet vdesc_rs = stmt.executeQuery();
                        while (vdesc_rs.next()) {
                            stmt = con.prepareStatement("SELECT SUM(vOutro) as voutro FROM cfop_final WHERE CST = ? AND chNFe = ?");
                            stmt.setString(1, "40");
                            stmt.setString(2, rs.getString("chNFe"));
                            ResultSet voutro_rs = stmt.executeQuery();
                            while (voutro_rs.next()) {
                                calculo = vprod_rs.getFloat("vprod") + vfrete_rs.getFloat("vfrete") + vseg_rs.getFloat("vseg") + voutro_rs.getFloat("voutro") - vdesc_rs.getFloat("vdesc");
                                String formatado = df.format(calculo).replace(",", ".");
                                stmt = con.prepareStatement("UPDATE cfop_final SET isentas = ?  WHERE CST = ? AND chNFe = ?");
                                stmt.setString(1, formatado);
                                stmt.setString(2, "40");
                                stmt.setString(3, rs.getString("chNFe"));
                                stmt.executeUpdate();
                            }
                        }
                    }
                }
            }
        }
    }

    private void calculoTotalNota() throws SQLException {
        /*
        Para fazer o calculo da nota eu pego dos os valores dos bancos com o final "_total" e no fim eu faço o calculo
        e dou um UPDATE no banco cfop_final
         */
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        float calculo = 0;
        DecimalFormat df = new DecimalFormat("00000000000.00");
        stmt = con.prepareStatement("SELECT vProd, chNFe FROM vprod_total");
        ResultSet vprod = stmt.executeQuery();
        while (vprod.next()) {
            PreparedStatement vfrete_stmt = con.prepareStatement("SELECT vFrete, chNFe FROM vfrete_total WHERE chNFe = ?");
            vfrete_stmt.setString(1, vprod.getString("chNFe"));
            ResultSet vfrete = vfrete_stmt.executeQuery();
            while (vfrete.next()) {
                PreparedStatement vseg_stmt = con.prepareStatement("SELECT vSeg, chNFe FROM vseg_total WHERE chNFe = ?");
                vseg_stmt.setString(1, vprod.getString("chNFe"));
                ResultSet vseg = vseg_stmt.executeQuery();
                while (vseg.next()) {
                    PreparedStatement voutro_stmt = con.prepareStatement("SELECT vOutro, chNFe FROM voutro_total WHERE chNFe = ?");
                    voutro_stmt.setString(1, vprod.getString("chNFe"));
                    ResultSet voutro = voutro_stmt.executeQuery();
                    while (voutro.next()) {
                        PreparedStatement vdesc_stmt = con.prepareStatement("SELECT vDesc, chNFe FROM vdesc_total WHERE chNFe = ?");
                        vdesc_stmt.setString(1, vprod.getString("chNFe"));
                        ResultSet vdesc = vdesc_stmt.executeQuery();
                        while (vdesc.next()) {
                            calculo = vprod.getFloat("vProd") + vfrete.getFloat("vFrete") + vseg.getFloat("vSeg") + voutro.getFloat("vOutro") - vdesc.getFloat("vDesc");
                            String total_calculo = df.format(calculo);
                            PreparedStatement up = con.prepareStatement("UPDATE cfop_final SET total_nota = ? WHERE chNFe = ?");
                            up.setString(1, total_calculo.replace(",", "."));
                            up.setString(2, vprod.getString("chNFe"));
                            up.executeUpdate();
                        }
                    }
                }
            }
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="TRATAMENTO DOS CAMPOS">
    private void tratamentoCST() throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        stmt = con.prepareStatement("SELECT CFOP,chNFe, cProd FROM cfop_final");
        ResultSet cst_rs = stmt.executeQuery();
        while (cst_rs.next()) {
            stmt = con.prepareStatement("SELECT CSOSN FROM csosn WHERE CFOP = ? AND chNFe = ? AND cProd = ?");
            stmt.setString(1, cst_rs.getString("CFOP"));
            stmt.setString(2, cst_rs.getString("chNFe"));
            stmt.setString(3, cst_rs.getString("cProd"));
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                if (rs.getString("CSOSN") == null) {

                } else {
                    stmt = con.prepareStatement("UPDATE cfop_final SET CST = ? WHERE CFOP = ? AND chNFe = ? AND cProd = ?");
                    stmt.setString(1, rs.getString("CST"));
                    stmt.setString(2, cst_rs.getString("CFOP"));
                    stmt.setString(3, cst_rs.getString("chNFe"));
                    stmt.setString(4, cst_rs.getString("cProd"));
                    stmt.executeUpdate();
                }
            }

            stmt = con.prepareStatement("SELECT CST FROM icms WHERE CFOP = ? AND chNFe = ? AND cProd = ?");
            stmt.setString(1, cst_rs.getString("CFOP"));
            stmt.setString(2, cst_rs.getString("chNFe"));
            stmt.setString(3, cst_rs.getString("cProd"));
            ResultSet pegar_rs = stmt.executeQuery();
            while (pegar_rs.next()) {
                if (pegar_rs.getString("CST") == null) {

                } else {
                    stmt = con.prepareStatement("UPDATE cfop_final SET CST = ? WHERE CFOP = ? AND chNFe = ? AND cProd = ?");
                    stmt.setString(1, pegar_rs.getString("CST"));
                    stmt.setString(2, cst_rs.getString("CFOP"));
                    stmt.setString(3, cst_rs.getString("chNFe"));
                    stmt.setString(4, cst_rs.getString("cProd"));
                    stmt.executeUpdate();
                }
            }
        }
    }

    private void tratamentovProd() {
        /*        
         */
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        DecimalFormat df = new DecimalFormat("00000000000.00");
        float vProd = 0;
        String cfop = null;
        String chNFe = null;
        try {
            stmt = con.prepareStatement("SELECT CFOP, chNFe FROM cfop_final");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                stmt = con.prepareStatement("SELECT SUM(vProd) as soma FROM vprod WHERE CFOP = ? AND chNFe = ?");
                stmt.setString(1, rs.getString("CFOP"));
                stmt.setString(2, rs.getString("chNFe"));
                ResultSet soma = stmt.executeQuery();
                while (soma.next()) {
                    if (soma.getString("soma") == null) {

                    } else {
                        vProd = soma.getFloat("soma");
                        String vprodformatado = df.format(vProd).replace(",", ".");
                        cfop = rs.getString("CFOP");
                        chNFe = rs.getString("chNFe");
                        stmt = con.prepareStatement("UPDATE cfop_final SET vProd = ? WHERE CFOP = ? AND chNFe = ?");
                        stmt.setString(1, vprodformatado);
                        stmt.setString(2, cfop);
                        stmt.setString(3, chNFe);
                        stmt.executeUpdate();
                        stmt.close();
                    }
                }
            }
        } catch (SQLException erro) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Erro tratamento vProd");
            alerta.setContentText("Erro fazer o tratamento da tabela vProd no banco de dados!" + erro);
            alerta.showAndWait();
        }
    }

    private void tratamentovSeg() throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        stmt = con.prepareStatement("SELECT vSeg, chNFe FROM vseg_total");
        ResultSet vseg = stmt.executeQuery();
        while (vseg.next()) {
            stmt = con.prepareStatement("UPDATE cfop_final SET vSeg = ? WHERE chNFe = ?");
            stmt.setString(1, vseg.getString("vSeg"));
            stmt.setString(2, vseg.getString("chNFe"));
            stmt.executeUpdate();
            stmt.close();
        }
    }

    private void tratamentovFrete() {
        /*
        
         */
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        DecimalFormat df = new DecimalFormat("00000000000.00");
        float vFrete = 0;
        String cfop = null;
        String chNFe = null;
        try {
            stmt = con.prepareStatement("SELECT CFOP, chNFe FROM cfop_final");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                stmt = con.prepareStatement("SELECT SUM(vFrete) as soma FROM vfrete_item WHERE CFOP = ? AND chNFe = ?");
                stmt.setString(1, rs.getString("CFOP"));
                stmt.setString(2, rs.getString("chNFe"));
                ResultSet soma = stmt.executeQuery();
                while (soma.next()) {
                    if (soma.getString("soma") == null) {

                    } else {

                        vFrete = soma.getFloat("soma");
                        String vfreteformatado = df.format(vFrete).replace(",", ".");
                        cfop = rs.getString("CFOP");
                        chNFe = rs.getString("chNFe");
                        stmt = con.prepareStatement("UPDATE cfop_final SET vFrete = ? WHERE CFOP = ? AND chNFe = ?");
                        stmt.setString(1, vfreteformatado);
                        stmt.setString(2, cfop);
                        stmt.setString(3, chNFe);
                        stmt.executeUpdate();
                        stmt.close();
                    }
                }
            }
        } catch (SQLException erro) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Erro tratamento vFrete");
            alerta.setContentText("Erro fazer o tratamento da tabela vFrete no banco de dados!" + erro);
            alerta.showAndWait();
        }
    }

    private void tratamentovDesc() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        DecimalFormat df = new DecimalFormat("00000000000.00");
        float vDesc = 0;
        String cfop = null;
        String chNFe = null;
        try {
            stmt = con.prepareStatement("SELECT CFOP, chNFe FROM cfop_final");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                stmt = con.prepareStatement("SELECT SUM(vDesc) as soma FROM vdesc WHERE CFOP = ? AND chNFe = ?");
                stmt.setString(1, rs.getString("CFOP"));
                stmt.setString(2, rs.getString("chNFe"));
                ResultSet soma = stmt.executeQuery();
                while (soma.next()) {
                    if (soma.getString("soma") == null) {

                    } else {
                        vDesc = soma.getFloat("soma");
                        String vDescFormatado = df.format(vDesc).replace(",", ".");
                        cfop = rs.getString("CFOP");
                        chNFe = rs.getString("chNFe");
                        stmt = con.prepareStatement("UPDATE cfop_final SET vDesc = ? WHERE CFOP = ? AND chNFe = ?");
                        stmt.setString(1, vDescFormatado);
                        stmt.setString(2, cfop);
                        stmt.setString(3, chNFe);
                        stmt.execute();
                        stmt.close();
                    }
                }
            }
        } catch (SQLException erro) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Erro tratamento vDesc");
            alerta.setContentText("Erro fazer o tratamento da tabela vDesc no banco de dados!" + erro);
            alerta.showAndWait();
        }

    }

    private void tratamentovOutro() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        DecimalFormat df = new DecimalFormat("00000000000.00");
        float soma_final = 0;
        String cfop = null;
        String chNFe = null;
        try {
            stmt = con.prepareStatement("SELECT CFOP, chNFe FROM cfop_final");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                stmt = con.prepareStatement("SELECT SUM(vOutro) as soma FROM voutro WHERE CFOP = ? AND chNFe = ?");
                stmt.setString(1, rs.getString("CFOP"));
                stmt.setString(2, rs.getString("chNFe"));
                ResultSet soma = stmt.executeQuery();
                while (soma.next()) {
                    if (soma.getString("soma") == null) {

                    } else {
                        soma_final = soma.getFloat("soma");
                        String soma_Final = df.format(soma_final).replace(",", ".");
                        cfop = rs.getString("CFOP");
                        chNFe = rs.getString("chNFe");
                        stmt = con.prepareStatement("UPDATE cfop_final SET vOutro = ? WHERE CFOP = ? AND chNFe = ?");
                        stmt.setString(1, soma_Final);
                        stmt.setString(2, cfop);
                        stmt.setString(3, chNFe);
                        stmt.execute();
                        stmt.close();
                    }
                }
            }
        } catch (SQLException erro) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Erro tratamento vOutro");
            alerta.setContentText("Erro fazer o tratamento da tabela vOutro no banco de dados!" + erro);
            alerta.showAndWait();
        }
    }

    private void tratamentoCFOPDesdobro() throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        int flag = 0;
        String cfop_atual = null;
        String cfop_antigo = null;
        String nota_atual = null;
        String nota_antiga = null;
        int desdo = 1;
        ResultSet rs;
        PreparedStatement desdo_stmt = con.prepareStatement("SELECT CFOP, chNFe FROM cfop_final");
        ResultSet desdo_rs = desdo_stmt.executeQuery();
        while (desdo_rs.next()) {
            cfop_atual = desdo_rs.getString("CFOP");
            nota_atual = desdo_rs.getString("chNFe");
            if (!cfop_atual.equals(cfop_antigo) && nota_atual.equals(nota_antiga)) {
                desdo = desdo + 1;
                flag = 1;
            } else if (cfop_atual.equals(cfop_antigo) && nota_atual.equals((nota_antiga))) {
                desdo = 1;
                flag = 1;
            } else {
                desdo = 1;
                flag = 1;
            }
            if (flag == 1) {
                stmt = con.prepareStatement("UPDATE cfop_final SET Desdo = ? WHERE CFOP = ? AND chNFe = ?");
                stmt.setInt(1, desdo);
                stmt.setString(2, cfop_atual);
                stmt.setString(3, nota_atual);
                stmt.execute();
                stmt.close();
                flag = 0;
            }
            cfop_antigo = cfop_atual;
            nota_antiga = nota_atual;
        }
    }

    private void tratamentoCFOP() throws SQLException {
        /*
        Essa instrução ira tirar os CFOP's repetidos das notas e ira adicionar o desdobramento também
         */
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        int flag = 0;
        String cfop_atual = null;
        String cfop_antigo = null;
        String nota_atual = null;
        String nota_antiga = null;
        int desdo = 1;
        ResultSet rs;
        //SELECIONANDO OS CFOP's PARA VERIFICAÇÃO

        try {
            stmt = con.prepareStatement("SELECT CFOP, chNFe, cProd FROM cfop");
            rs = stmt.executeQuery();
            while (rs.next()) {
                /*INSERINDO OS CFOP'S NA TABELA CFOP_FINAL, ONDE PRIMEIRO É FEITO UMA VERIFICAÇÃO PARA SABER SE JÁ EXISTE
                SE JÁ EXISTIR NÃO IRÁ ACONTECER NADA, PORÉM SE NÃO TIVER ELE IRÁ ADICIONA O CFOP E A CHAVE DA NOTA.                
                 */
                PreparedStatement pesquisa = con.prepareStatement("SELECT CFOP, chNFe, cProd FROM cfop_final WHERE CFOP = ? AND chNFe = ?");
                pesquisa.setString(1, rs.getString("CFOP"));
                pesquisa.setString(2, rs.getString("chNFe"));
                ResultSet rs_pesquisa = pesquisa.executeQuery();
                if (rs_pesquisa.next()) {

                } else {
                    stmt = con.prepareStatement("INSERT INTO cfop_final(CFOP, chNFe, Desdo, cProd) VALUES(?,?,?,?)");
                    stmt.setString(1, rs.getString("CFOP"));
                    stmt.setString(2, rs.getString("chNFe"));
                    stmt.setInt(3, desdo);
                    stmt.setString(4, rs.getString("cProd"));
                    stmt.execute();
                    stmt.close();
                }
            }
            stmt.close();
            rs.close();
        } catch (SQLException erro) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Erro com CFOP");
            alerta.setContentText("Erro fazer o tratamento dos CFOP's no banco de dados!" + erro);
            alerta.showAndWait();
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="PEGANDO A NOTA">    
    // <editor-fold defaultstate="collapsed" desc="VPROD">
    public void vProd() throws SAXException, IOException, ParserConfigurationException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        DecimalFormat df = new DecimalFormat("00000000000.00");
        float format_vprod = 0;
        String chnfe = null;
        //Pegando os arquivos para a leitura
        for (Object caminho_ob : array_caminho) {
            //lendo os arquivos XML's
            File diretorio = new File((String) caminho_ob);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(diretorio);
            NodeList se = doc.getElementsByTagName("infProt");
            int sea = se.getLength();
            for (int i = 0; i < sea; i++) {
                Node noide = se.item(i);
                if (noide.getNodeType() == Node.ELEMENT_NODE) {
                    Element listaide = (Element) noide;
                    NodeList listafilhoide = listaide.getChildNodes();
                    int tamanholistaide = listafilhoide.getLength();
                    for (int j = 0; j < tamanholistaide; j++) {
                        Node idei = listafilhoide.item(j);
                        if (idei.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementofilho = (Element) idei;
                            switch (elementofilho.getTagName()) {
                                case "chNFe":
                                    chnfe = elementofilho.getTextContent();
                                    break;
                            }
                        }
                    }
                }
            }
            NodeList listaDePessoas = doc.getElementsByTagName("total");
            int tamanhoLista = listaDePessoas.getLength();
            for (int i = 0; i < tamanhoLista; i++) {
                Node noPessoa = listaDePessoas.item(i);
                if (noPessoa.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementoPessoa = (Element) noPessoa;
                    NodeList listaDeFilhosDaPessoa = elementoPessoa.getChildNodes();
                    int tamanhoListaFilhos = listaDeFilhosDaPessoa.getLength();
                    for (int j = 0; j < tamanhoListaFilhos; j++) {
                        Node noFilho = listaDeFilhosDaPessoa.item(j);
                        if (noFilho.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementoFilho = (Element) noFilho;
                            NodeList dados = elementoFilho.getChildNodes();
                            int tamanhodados = dados.getLength();
                            for (int w = 0; w < tamanhodados; w++) {
                                Node noFilhos = dados.item(w);
                                if (noFilhos.getNodeType() == Node.ELEMENT_NODE) {
                                    Element elementodados = (Element) noFilhos;
                                    switch (elementodados.getTagName()) {
                                        case "vProd":
                                            format_vprod = Float.parseFloat(elementodados.getTextContent());
                                            String formatado = df.format(format_vprod);
                                            try {
                                                stmt = con.prepareStatement("INSERT INTO vprod_total(vProd,chNFe) VALUES(?,?)");
                                                stmt.setString(1, formatado.replace(",", "."));
                                                stmt.setString(2, chnfe);
                                                stmt.execute();
                                            } catch (SQLException erro) {
                                                Alert alerta = new Alert(Alert.AlertType.ERROR);
                                                alerta.setTitle("Erro com o total vProd");
                                                alerta.setContentText("Erro ao inserir os dados de vProd no banco de dados!" + erro);
                                                alerta.showAndWait();
                                            }
                                            break;
                                        default:

                                            break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="VFRETE">
    public void vFrete() throws SAXException, IOException, ParserConfigurationException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        DecimalFormat df = new DecimalFormat("00000000000.00");
        float format_vfrete = 0;
        String chnfe = null;
        //Pegando os arquivos para a leitura
        for (Object caminho_ob : array_caminho) {
            //lendo os arquivos XML's
            File diretorio = new File((String) caminho_ob);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(diretorio);
            NodeList se = doc.getElementsByTagName("infProt");
            int sea = se.getLength();
            for (int i = 0; i < sea; i++) {
                Node noide = se.item(i);
                if (noide.getNodeType() == Node.ELEMENT_NODE) {
                    Element listaide = (Element) noide;
                    NodeList listafilhoide = listaide.getChildNodes();
                    int tamanholistaide = listafilhoide.getLength();
                    for (int j = 0; j < tamanholistaide; j++) {
                        Node idei = listafilhoide.item(j);
                        if (idei.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementofilho = (Element) idei;
                            switch (elementofilho.getTagName()) {
                                case "chNFe":
                                    chnfe = elementofilho.getTextContent();
                                    break;
                            }
                        }
                    }
                }
            }
            NodeList listaDePessoas = doc.getElementsByTagName("total");
            int tamanhoLista = listaDePessoas.getLength();
            for (int i = 0; i < tamanhoLista; i++) {
                Node noPessoa = listaDePessoas.item(i);
                if (noPessoa.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementoPessoa = (Element) noPessoa;
                    NodeList listaDeFilhosDaPessoa = elementoPessoa.getChildNodes();
                    int tamanhoListaFilhos = listaDeFilhosDaPessoa.getLength();
                    for (int j = 0; j < tamanhoListaFilhos; j++) {
                        Node noFilho = listaDeFilhosDaPessoa.item(j);
                        if (noFilho.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementoFilho = (Element) noFilho;
                            NodeList dados = elementoFilho.getChildNodes();
                            int tamanhodados = dados.getLength();
                            for (int w = 0; w < tamanhodados; w++) {
                                Node noFilhos = dados.item(w);
                                if (noFilhos.getNodeType() == Node.ELEMENT_NODE) {
                                    Element elementodados = (Element) noFilhos;
                                    switch (elementodados.getTagName()) {
                                        case "vFrete":
                                            format_vfrete = Float.parseFloat(elementodados.getTextContent());
                                            String formatado = df.format(format_vfrete);
                                            try {
                                                stmt = con.prepareStatement("INSERT INTO vfrete_total(vFrete,chNFe) VALUES(?,?)");
                                                stmt.setString(1, formatado.replace(",", "."));
                                                stmt.setString(2, chnfe);
                                                stmt.execute();
                                            } catch (SQLException erro) {
                                                Alert alerta = new Alert(Alert.AlertType.ERROR);
                                                alerta.setTitle("Erro com total vFrete");
                                                alerta.setContentText("Erro ao inserir os dados de vFrete no banco de dados!" + erro);
                                                alerta.showAndWait();
                                            }
                                            break;
                                        default:

                                            break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="VSEG">
    public void vSeg() throws SAXException, IOException, ParserConfigurationException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        DecimalFormat df = new DecimalFormat("00000000000.00");
        float format_vseg = 0;
        String chnfe = null;
        //Pegando os arquivos para a leitura
        for (Object caminho_ob : array_caminho) {
            //lendo os arquivos XML's
            File diretorio = new File((String) caminho_ob);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(diretorio);
            NodeList se = doc.getElementsByTagName("infProt");
            int sea = se.getLength();
            for (int i = 0; i < sea; i++) {
                Node noide = se.item(i);
                if (noide.getNodeType() == Node.ELEMENT_NODE) {
                    Element listaide = (Element) noide;
                    NodeList listafilhoide = listaide.getChildNodes();
                    int tamanholistaide = listafilhoide.getLength();
                    for (int j = 0; j < tamanholistaide; j++) {
                        Node idei = listafilhoide.item(j);
                        if (idei.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementofilho = (Element) idei;
                            switch (elementofilho.getTagName()) {
                                case "chNFe":
                                    chnfe = elementofilho.getTextContent();
                                    break;
                            }
                        }
                    }
                }
            }
            NodeList listaDePessoas = doc.getElementsByTagName("total");
            int tamanhoLista = listaDePessoas.getLength();
            for (int i = 0; i < tamanhoLista; i++) {
                Node noPessoa = listaDePessoas.item(i);
                if (noPessoa.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementoPessoa = (Element) noPessoa;
                    NodeList listaDeFilhosDaPessoa = elementoPessoa.getChildNodes();
                    int tamanhoListaFilhos = listaDeFilhosDaPessoa.getLength();
                    for (int j = 0; j < tamanhoListaFilhos; j++) {
                        Node noFilho = listaDeFilhosDaPessoa.item(j);
                        if (noFilho.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementoFilho = (Element) noFilho;
                            NodeList dados = elementoFilho.getChildNodes();
                            int tamanhodados = dados.getLength();
                            for (int w = 0; w < tamanhodados; w++) {
                                Node noFilhos = dados.item(w);
                                if (noFilhos.getNodeType() == Node.ELEMENT_NODE) {
                                    Element elementodados = (Element) noFilhos;
                                    switch (elementodados.getTagName()) {
                                        case "vSeg":
                                            format_vseg = Float.parseFloat(elementodados.getTextContent());
                                            String formatado = df.format(format_vseg);
                                            try {
                                                stmt = con.prepareStatement("INSERT INTO vseg_total(vSeg,chNFe) VALUES(?,?)");
                                                stmt.setString(1, formatado.replace(",", "."));
                                                stmt.setString(2, chnfe);
                                                stmt.execute();
                                            } catch (SQLException erro) {
                                                Alert alerta = new Alert(Alert.AlertType.ERROR);
                                                alerta.setTitle("Erro com total vSeg");
                                                alerta.setContentText("Erro ao inserir os dados de vSeg no banco de dados!" + erro);
                                                alerta.showAndWait();
                                            }
                                            break;
                                        default:

                                            break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="VDESC">
    public void vDesc() throws SAXException, IOException, ParserConfigurationException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        DecimalFormat df = new DecimalFormat("00000000000.00");
        float format_vdesc = 0;
        String chnfe = null;
        //Pegando os arquivos para a leitura
        for (Object caminho_ob : array_caminho) {
            //lendo os arquivos XML's
            File diretorio = new File((String) caminho_ob);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(diretorio);
            NodeList se = doc.getElementsByTagName("infProt");
            int sea = se.getLength();
            for (int i = 0; i < sea; i++) {
                Node noide = se.item(i);
                if (noide.getNodeType() == Node.ELEMENT_NODE) {
                    Element listaide = (Element) noide;
                    NodeList listafilhoide = listaide.getChildNodes();
                    int tamanholistaide = listafilhoide.getLength();
                    for (int j = 0; j < tamanholistaide; j++) {
                        Node idei = listafilhoide.item(j);
                        if (idei.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementofilho = (Element) idei;
                            switch (elementofilho.getTagName()) {
                                case "chNFe":
                                    chnfe = elementofilho.getTextContent();
                                    break;
                            }
                        }
                    }
                }
            }
            NodeList listaDePessoas = doc.getElementsByTagName("total");
            int tamanhoLista = listaDePessoas.getLength();
            for (int i = 0; i < tamanhoLista; i++) {
                Node noPessoa = listaDePessoas.item(i);
                if (noPessoa.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementoPessoa = (Element) noPessoa;
                    NodeList listaDeFilhosDaPessoa = elementoPessoa.getChildNodes();
                    int tamanhoListaFilhos = listaDeFilhosDaPessoa.getLength();
                    for (int j = 0; j < tamanhoListaFilhos; j++) {
                        Node noFilho = listaDeFilhosDaPessoa.item(j);
                        if (noFilho.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementoFilho = (Element) noFilho;
                            NodeList dados = elementoFilho.getChildNodes();
                            int tamanhodados = dados.getLength();
                            for (int w = 0; w < tamanhodados; w++) {
                                Node noFilhos = dados.item(w);
                                if (noFilhos.getNodeType() == Node.ELEMENT_NODE) {
                                    Element elementodados = (Element) noFilhos;
                                    switch (elementodados.getTagName()) {
                                        case "vDesc":
                                            format_vdesc = Float.parseFloat(elementodados.getTextContent());
                                            String formatado = df.format(format_vdesc);
                                            try {
                                                stmt = con.prepareStatement("INSERT INTO vdesc_total(vDesc,chNFe) VALUES(?,?)");
                                                stmt.setString(1, formatado.replace(",", "."));
                                                stmt.setString(2, chnfe);
                                                stmt.execute();
                                            } catch (SQLException erro) {
                                                Alert alerta = new Alert(Alert.AlertType.ERROR);
                                                alerta.setTitle("Erro com total vDesc");
                                                alerta.setContentText("Erro ao inserir os dados de vDesc no banco de dados!" + erro);
                                                alerta.showAndWait();
                                            }
                                            break;
                                        default:

                                            break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="VOUTRO">
    public void vOutro() throws SAXException, IOException, ParserConfigurationException {
        Connection con = ConnectionFactory.getConnection();
        DecimalFormat df = new DecimalFormat("00000000000.00");
        float format_voutro = 0;
        PreparedStatement stmt;
        String chnfe = null;
        //Pegando os arquivos para a leitura
        for (Object caminho_ob : array_caminho) {
            //lendo os arquivos XML's
            File diretorio = new File((String) caminho_ob);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(diretorio);
            NodeList se = doc.getElementsByTagName("infProt");
            int sea = se.getLength();
            for (int i = 0; i < sea; i++) {
                Node noide = se.item(i);
                if (noide.getNodeType() == Node.ELEMENT_NODE) {
                    Element listaide = (Element) noide;
                    NodeList listafilhoide = listaide.getChildNodes();
                    int tamanholistaide = listafilhoide.getLength();
                    for (int j = 0; j < tamanholistaide; j++) {
                        Node idei = listafilhoide.item(j);
                        if (idei.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementofilho = (Element) idei;
                            switch (elementofilho.getTagName()) {
                                case "chNFe":
                                    chnfe = elementofilho.getTextContent();
                                    break;
                            }
                        }
                    }
                }
            }
            NodeList listaDePessoas = doc.getElementsByTagName("total");
            int tamanhoLista = listaDePessoas.getLength();
            for (int i = 0; i < tamanhoLista; i++) {
                Node noPessoa = listaDePessoas.item(i);
                if (noPessoa.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementoPessoa = (Element) noPessoa;
                    NodeList listaDeFilhosDaPessoa = elementoPessoa.getChildNodes();
                    int tamanhoListaFilhos = listaDeFilhosDaPessoa.getLength();
                    for (int j = 0; j < tamanhoListaFilhos; j++) {
                        Node noFilho = listaDeFilhosDaPessoa.item(j);
                        if (noFilho.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementoFilho = (Element) noFilho;
                            NodeList dados = elementoFilho.getChildNodes();
                            int tamanhodados = dados.getLength();
                            for (int w = 0; w < tamanhodados; w++) {
                                Node noFilhos = dados.item(w);
                                if (noFilhos.getNodeType() == Node.ELEMENT_NODE) {
                                    Element elementodados = (Element) noFilhos;
                                    switch (elementodados.getTagName()) {
                                        case "vOutro":
                                            format_voutro = Float.parseFloat(elementodados.getTextContent());
                                            String formatado = df.format(format_voutro);
                                            try {
                                                stmt = con.prepareStatement("INSERT INTO voutro_total(vOutro,chNFe) VALUES(?,?)");
                                                stmt.setString(1, formatado.replace(",", "."));
                                                stmt.setString(2, chnfe);
                                                stmt.execute();
                                            } catch (SQLException erro) {
                                                Alert alerta = new Alert(Alert.AlertType.ERROR);
                                                alerta.setTitle("Erro com total vOutro");
                                                alerta.setContentText("Erro ao inserir os dados de vOutro no banco de dados!" + erro);
                                                alerta.showAndWait();
                                            }
                                            break;
                                        default:

                                            break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="VNF">
    public void vNF() throws SAXException, IOException, ParserConfigurationException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        DecimalFormat df = new DecimalFormat("00000000000.00");
        float format_vnf = 0;
        String chnfe = null;
        //Pegando os arquivos para a leitura
        for (Object caminho_ob : array_caminho) {
            //lendo os arquivos XML's
            File diretorio = new File((String) caminho_ob);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(diretorio);
            NodeList se = doc.getElementsByTagName("infProt");
            int sea = se.getLength();
            for (int i = 0; i < sea; i++) {
                Node noide = se.item(i);
                if (noide.getNodeType() == Node.ELEMENT_NODE) {
                    Element listaide = (Element) noide;
                    NodeList listafilhoide = listaide.getChildNodes();
                    int tamanholistaide = listafilhoide.getLength();
                    for (int j = 0; j < tamanholistaide; j++) {
                        Node idei = listafilhoide.item(j);
                        if (idei.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementofilho = (Element) idei;
                            switch (elementofilho.getTagName()) {
                                case "chNFe":
                                    chnfe = elementofilho.getTextContent();
                                    break;
                            }
                        }
                    }
                }
            }
            NodeList listaDePessoas = doc.getElementsByTagName("total");
            int tamanhoLista = listaDePessoas.getLength();
            for (int i = 0; i < tamanhoLista; i++) {
                Node noPessoa = listaDePessoas.item(i);
                if (noPessoa.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementoPessoa = (Element) noPessoa;
                    NodeList listaDeFilhosDaPessoa = elementoPessoa.getChildNodes();
                    int tamanhoListaFilhos = listaDeFilhosDaPessoa.getLength();
                    for (int j = 0; j < tamanhoListaFilhos; j++) {
                        Node noFilho = listaDeFilhosDaPessoa.item(j);
                        if (noFilho.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementoFilho = (Element) noFilho;
                            NodeList dados = elementoFilho.getChildNodes();
                            int tamanhodados = dados.getLength();
                            for (int w = 0; w < tamanhodados; w++) {
                                Node noFilhos = dados.item(w);
                                if (noFilhos.getNodeType() == Node.ELEMENT_NODE) {
                                    Element elementodados = (Element) noFilhos;
                                    switch (elementodados.getTagName()) {
                                        case "vNF":
                                            format_vnf = Float.parseFloat(elementodados.getTextContent());
                                            String formatado = df.format(format_vnf);
                                            try {
                                                stmt = con.prepareStatement("INSERT INTO vnf_total(vNF,chNFe) VALUES(?,?)");
                                                stmt.setString(1, formatado.replace(",", "."));
                                                stmt.setString(2, chnfe);
                                                stmt.execute();
                                            } catch (SQLException erro) {
                                                Alert alerta = new Alert(Alert.AlertType.ERROR);
                                                alerta.setTitle("Erro com total vNF");
                                                alerta.setContentText("Erro ao inserir os dados de vNF no banco de dados!" + erro);
                                                alerta.showAndWait();
                                            }
                                            break;
                                        default:

                                            break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

    }
    //</editor-fold>   

    // <editor-fold defaultstate="collapsed" desc="DET">
    //esta instrução contem todos os valores da nota fiscal e depois é feito o calculo com eles
    public void det() throws ParserConfigurationException, SAXException, IOException {
        String chnfe = null;
        String cfop = null;
        String codigo_produto = null;
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        //Pegando os arquivos para a leitura
        for (Object caminho_ob : array_caminho) {
            //lendo os arquivos XML's
            File diretorio = new File((String) caminho_ob);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(diretorio);
            //pegando a chave da nota para identificar os dados futuramente
            NodeList se = doc.getElementsByTagName("infProt");
            int sea = se.getLength();
            for (int i = 0; i < sea; i++) {
                Node noide = se.item(i);
                if (noide.getNodeType() == Node.ELEMENT_NODE) {
                    Element listaide = (Element) noide;
                    NodeList listafilhoide = listaide.getChildNodes();
                    int tamanholistaide = listafilhoide.getLength();
                    for (int j = 0; j < tamanholistaide; j++) {
                        Node idei = listafilhoide.item(j);
                        if (idei.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementofilho = (Element) idei;
                            switch (elementofilho.getTagName()) {
                                case "chNFe":
                                    chnfe = elementofilho.getTextContent();
                                    break;
                            }
                        }
                    }
                }
            }

            NodeList listaDePessoas = doc.getElementsByTagName("det");
            int tamanhoLista = listaDePessoas.getLength();
            for (int i = 0; i < tamanhoLista; i++) {
                Node noPessoa = listaDePessoas.item(i);
                if (noPessoa.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementoPessoa = (Element) noPessoa;
                    NodeList listaDeFilhosDaPessoa = elementoPessoa.getChildNodes();
                    int tamanhoListaFilhos = listaDeFilhosDaPessoa.getLength();
                    for (int j = 0; j < tamanhoListaFilhos; j++) {
                        Node noFilho = listaDeFilhosDaPessoa.item(j);
                        if (noFilho.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementoFilho = (Element) noFilho;
                            NodeList dados = elementoFilho.getChildNodes();
                            int tamanhodados = dados.getLength();
                            for (int w = 0; w < tamanhodados; w++) {
                                Node noFilhos = dados.item(w);
                                if (noFilhos.getNodeType() == Node.ELEMENT_NODE) {
                                    Element elementodados = (Element) noFilhos;
                                    switch (elementodados.getTagName()) {

                                        // <editor-fold defaultstate="collapsed" desc="cProd">
                                        case "cProd":
                                            codigo_produto = elementodados.getTextContent();
                                            try {
                                                stmt = con.prepareStatement("INSERT INTO cprod(cProd,chNFe) VALUES(?,?)");
                                                stmt.setString(1, elementodados.getTextContent());
                                                stmt.setString(2, chnfe);
                                                stmt.execute();
                                            } catch (SQLException erro) {
                                                Alert alerta = new Alert(Alert.AlertType.ERROR);
                                                alerta.setTitle("Erro com cProd");
                                                alerta.setContentText("Erro ao inserir os dados de cProd no banco de dados!" + erro);
                                                alerta.showAndWait();
                                            }
                                            break;
                                        //</editor-fold>

                                        // <editor-fold defaultstate="collapsed" desc="cEAN">
                                        case "cEAN":
                                            try {
                                                stmt = con.prepareStatement("INSERT INTO cean(cEAN,chNFe) VALUES(?,?)");
                                                stmt.setString(1, elementodados.getTextContent());
                                                stmt.setString(2, chnfe);
                                                stmt.execute();

                                            } catch (SQLException erro) {
                                                Alert alerta = new Alert(Alert.AlertType.ERROR);
                                                alerta.setTitle("Erro com cEAN");
                                                alerta.setContentText("Erro ao inserir os dados de cEAN no banco de dados!" + erro);
                                                alerta.showAndWait();
                                            }

                                            break;
//</editor-fold>

                                        // <editor-fold defaultstate="collapsed" desc="xProd">
                                        case "xProd":
                                            try {
                                                stmt = con.prepareStatement("INSERT INTO xprod(xProd,chNFe) VALUES(?,?)");
                                                stmt.setString(1, elementodados.getTextContent());
                                                stmt.setString(2, chnfe);
                                                stmt.execute();

                                            } catch (SQLException erro) {
                                                Alert alerta = new Alert(Alert.AlertType.ERROR);
                                                alerta.setTitle("Erro com xProd");
                                                alerta.setContentText("Erro ao inserir os dados de xProd no banco de dados!" + erro);
                                                alerta.showAndWait();
                                            }

                                            break;
                                        //</editor-fold>

                                        // <editor-fold defaultstate="collapsed" desc="NCM">
                                        case "NCM":
                                            try {
                                                stmt = con.prepareStatement("INSERT INTO ncm(NCM,chNFe) VALUES(?,?)");
                                                stmt.setString(1, elementodados.getTextContent());
                                                stmt.setString(2, chnfe);
                                                stmt.execute();

                                            } catch (SQLException erro) {
                                                Alert alerta = new Alert(Alert.AlertType.ERROR);
                                                alerta.setTitle("Erro com NCM");
                                                alerta.setContentText("Erro ao inserir os dados de NCM no banco de dados!" + erro);
                                                alerta.showAndWait();
                                            }

                                            break;
                                        //</editor-fold>                                        

                                        // <editor-fold defaultstate="collapsed" desc="CFOP">
                                        case "CFOP":
                                            cfop = elementodados.getTextContent();
                                            try {
                                                stmt = con.prepareStatement("INSERT INTO cfop(CFOP,chNFe, cProd) VALUES(?,?,?)");
                                                stmt.setString(1, elementodados.getTextContent());
                                                stmt.setString(2, chnfe);
                                                stmt.setString(3, codigo_produto);
                                                stmt.execute();

                                            } catch (SQLException erro) {
                                                Alert alerta = new Alert(Alert.AlertType.ERROR);
                                                alerta.setTitle("Erro com CFOP");
                                                alerta.setContentText("Erro ao inserir os dados de CFOP no banco de dados!" + erro);
                                                alerta.showAndWait();
                                            }
                                            break;
//</editor-fold>

                                        // <editor-fold defaultstate="collapsed" desc="vDesc">
                                        case "vDesc":
                                            try {
                                                stmt = con.prepareStatement("INSERT INTO vdesc(vDesc,chNFe,CFOP) VALUES(?,?,?)");
                                                stmt.setString(1, elementodados.getTextContent());
                                                stmt.setString(2, chnfe);
                                                stmt.setString(3, cfop);
                                                stmt.execute();

                                            } catch (SQLException erro) {
                                                Alert alerta = new Alert(Alert.AlertType.ERROR);
                                                alerta.setTitle("Erro com vDesc");
                                                alerta.setContentText("Erro ao inserir os dados de vDesc no banco de dados!" + erro);
                                                alerta.showAndWait();
                                            }
                                            break;
                                        // </editor-fold>

                                        // <editor-fold defaultstate="collapsed" desc="vOutro">
                                        case "vOutro":
                                            try {
                                                stmt = con.prepareStatement("INSERT INTO voutro(vOutro,chNFe,CFOP) VALUES(?,?,?)");
                                                stmt.setString(1, elementodados.getTextContent());
                                                stmt.setString(2, chnfe);
                                                stmt.setString(3, cfop);
                                                stmt.execute();

                                            } catch (SQLException erro) {
                                                Alert alerta = new Alert(Alert.AlertType.ERROR);
                                                alerta.setTitle("Erro com vOutro");
                                                alerta.setContentText("Erro ao inserir os dados de vOutro no banco de dados!" + erro);
                                                alerta.showAndWait();
                                            }
                                            break;
                                        //</editor-fold>                                    

                                        // <editor-fold defaultstate="collapsed" desc="vProd">
                                        case "vProd":
                                            try {
                                                stmt = con.prepareStatement("INSERT INTO vprod(vProd,chNFe,CFOP) VALUES(?,?,?)");
                                                stmt.setString(1, elementodados.getTextContent());
                                                stmt.setString(2, chnfe);
                                                stmt.setString(3, cfop);
                                                stmt.execute();

                                            } catch (SQLException erro) {
                                                Alert alerta = new Alert(Alert.AlertType.ERROR);
                                                alerta.setTitle("Erro com vProd");
                                                alerta.setContentText("Erro ao inserir os dados de vProd no banco de dados!" + erro);
                                                alerta.showAndWait();
                                            }

                                            break;
                                        //</editor-fold>

                                        // <editor-fold defaultstate="collapsed" desc="vFrete">
                                        case "vFrete":
                                            try {
                                                stmt = con.prepareStatement("INSERT INTO vfrete_item(vFrete,chNFe, CFOP) VALUES(?,?,?)");
                                                stmt.setString(1, elementodados.getTextContent());
                                                stmt.setString(2, chnfe);
                                                stmt.setString(3, cfop);
                                                stmt.execute();

                                            } catch (SQLException erro) {
                                                Alert alerta = new Alert(Alert.AlertType.ERROR);
                                                alerta.setTitle("Erro com vFrete item");
                                                alerta.setContentText("Erro ao inserir os dados de vFrete no banco de dados!" + erro);
                                                alerta.showAndWait();
                                            }
                                            break;
                                        //</editor-fold>

                                        // <editor-fold defaultstate="collapsed" desc="vSeg">
                                        case "vSeg":
                                            try {
                                                stmt = con.prepareStatement("INSERT INTO vseg_item(vSeg,chNFe, CFOP) VALUES(?,?,?)");
                                                stmt.setString(1, elementodados.getTextContent());
                                                stmt.setString(2, chnfe);
                                                stmt.setString(3, cfop);
                                                stmt.execute();

                                            } catch (SQLException erro) {
                                                Alert alerta = new Alert(Alert.AlertType.ERROR);
                                                alerta.setTitle("Erro com vSeg item");
                                                alerta.setContentText("Erro ao inserir os dados de vSeg no banco de dados!" + erro);
                                                alerta.showAndWait();
                                            }

                                            break;
                                        //</editor-fold>

                                        // <editor-fold defaultstate="collapsed" desc="ORIG(ICMS)">
                                        case "ICMS":
                                            String cst = null,
                                             csosn = null,
                                             cst_antiga = null,
                                             csosn_antiga = null,
                                             cfop_antigo = null,
                                             produto_antigo = null,
                                             chave_nota = null;

                                            // <editor-fold defaultstate="collapsed" desc="CST"> //  
                                            try {
                                                NodeList icms = elementoFilho.getElementsByTagName("CST");
                                                int tamanhodadoss = icms.getLength();
                                                for (int o = 0; o < tamanhodadoss; o++) {
                                                    Node noFilhoss = icms.item(o);
                                                    if (noFilhoss.getNodeType() == Node.ELEMENT_NODE) {
                                                        Element elementodadoss = (Element) noFilhoss;
                                                        switch (elementodadoss.getTagName()) {
                                                            case "CST":
                                                                cst = elementodadoss.getTextContent();
                                                                if (cst.equals("00") || cst.equals("10") || cst.equals("20") || cst.equals("30") || cst.equals("40") || cst.equals("41")
                                                                        || cst.equals("50") || cst.equals("51") || cst.equals("60") || cst.equals("70") || cst.equals("90")) {
                                                                    if (!cst.equals(cst_antiga) && !cfop.equals(cfop_antigo) && !codigo_produto.equals(produto_antigo) && !chnfe.equals(chave_nota)) {
                                                                        try {
                                                                            stmt = con.prepareStatement("INSERT INTO icms(CST,chNFe,CFOP, cProd) VALUES(?,?,?,?)");
                                                                            stmt.setString(1, cst);
                                                                            stmt.setString(2, chnfe);
                                                                            stmt.setString(3, cfop);
                                                                            stmt.setString(4, codigo_produto);
                                                                            stmt.execute();
                                                                        } catch (SQLException erro) {
                                                                            Alert alerta = new Alert(Alert.AlertType.ERROR);
                                                                            alerta.setTitle("Erro com CST");
                                                                            alerta.setContentText("Erro ao inserir os dados de CST no banco de dados! CST00\n" + erro);
                                                                            alerta.showAndWait();
                                                                        }
                                                                    } else {

                                                                    }
                                                                } else {

                                                                }
                                                                cst_antiga = cst;
                                                                cfop_antigo = cfop;
                                                                produto_antigo = codigo_produto;
                                                                chave_nota = chnfe;

                                                                break;
                                                        }
                                                    }
                                                }
                                            } catch (DOMException erro) {
                                                Alert alerta = new Alert(Alert.AlertType.ERROR);
                                                alerta.setTitle("Erro ao ler o XML");
                                                alerta.setContentText("Erro ao ler a tag ICMS do XML! CST00\n" + erro);
                                                alerta.showAndWait();
                                            }//</editor-fold>                                          

                                            // <editor-fold defaultstate="collapsed" desc="CSOSN"> 
                                            NodeList csocsn = elementoFilho.getElementsByTagName("CSOSN");
                                            int csocsna = csocsn.getLength();
                                            for (int o = 0; o < csocsna; o++) {
                                                Node noFilhoss = csocsn.item(o);
                                                if (noFilhoss.getNodeType() == Node.ELEMENT_NODE) {
                                                    Element elementodadoss = (Element) noFilhoss;
                                                    switch (elementodadoss.getTagName()) {
                                                        case "CSOSN":
                                                            csosn = elementodadoss.getTextContent();
                                                            if (csosn.equals("101") || csosn.equals("102") || csosn.equals("103") || csosn.equals("3") || csosn.equals("201") || csosn.equals("202")
                                                                    || csosn.equals("203") || csosn.equals("500") || csosn.equals("900") || csosn.equals("300") || csosn.equals("400")) {
                                                                if (!csosn.equals(csosn_antiga) && !cfop.equals(cfop_antigo) && !codigo_produto.equals(produto_antigo) && !chnfe.equals(chave_nota)) {
                                                                    try {
                                                                        stmt = con.prepareStatement("INSERT INTO csosn(CSOSN,chNFe,CFOP, cProd) VALUES(?,?,?,?)");
                                                                        stmt.setString(1, csosn);
                                                                        stmt.setString(2, chnfe);
                                                                        stmt.setString(3, cfop);
                                                                        stmt.setString(4, codigo_produto);
                                                                        stmt.execute();
                                                                    } catch (SQLException erro) {
                                                                        Alert alerta = new Alert(Alert.AlertType.ERROR);
                                                                        alerta.setTitle("Erro com CSOSN");
                                                                        alerta.setContentText("Erro ao inserir os dados de CSOSN no banco de dados!\n" + erro);
                                                                        alerta.showAndWait();
                                                                    }
                                                                } else {

                                                                }
                                                            } else {

                                                            }
                                                            csosn_antiga = csosn;
                                                            cfop_antigo = cfop;
                                                            produto_antigo = codigo_produto;
                                                            chave_nota = chnfe;
                                                            break;
                                                    }
                                                }
                                            }
                                            break;
                                        //</editor-fold>

                                        //</editor-fold>
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    //Fim instrução det
    //</editor-fold>      

    // <editor-fold defaultstate="collapsed" desc="TIPOFRETE">
    public void tipoFrete() throws ParserConfigurationException, SAXException, IOException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        String chnfe = null;
        //Pegando os arquivos para a leitura
        for (Object caminho_ob : array_caminho) {
            //lendo os arquivos XML's
            File diretorio = new File((String) caminho_ob);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(diretorio);
            // <editor-fold defaultstate="collapsed" desc="CHAVE DA NOTA"> 
            //pegando a chave da nota para identificar os dados futuramente
            NodeList se = doc.getElementsByTagName("infProt");
            int sea = se.getLength();
            for (int i = 0; i < sea; i++) {
                Node noide = se.item(i);
                if (noide.getNodeType() == Node.ELEMENT_NODE) {
                    Element listaide = (Element) noide;
                    NodeList listafilhoide = listaide.getChildNodes();
                    int tamanholistaide = listafilhoide.getLength();
                    for (int j = 0; j < tamanholistaide; j++) {
                        Node idei = listafilhoide.item(j);
                        if (idei.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementofilho = (Element) idei;
                            switch (elementofilho.getTagName()) {
                                case "chNFe":
                                    chnfe = elementofilho.getTextContent();
                                    break;
                            }
                        }
                    }
                }
            }
            //</editor-fold>
            // <editor-fold defaultstate="collapsed" desc="TIPO DE FRETE">            
            NodeList mod_frete = doc.getElementsByTagName("modFrete");
            int mod_fretee = mod_frete.getLength();
            for (int o = 0; o < mod_fretee; o++) {
                Node noFilhoss = mod_frete.item(o);
                if (noFilhoss.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementodadoss = (Element) noFilhoss;
                    switch (elementodadoss.getTagName()) {
                        case "modFrete":
                            try {
                                stmt = con.prepareStatement("INSERT INTO modfrete(modFrete,chNFe) VALUES(?,?)");
                                stmt.setString(1, elementodadoss.getTextContent());
                                stmt.setString(2, chnfe);
                                stmt.execute();

                            } catch (SQLException erro) {
                                Alert alerta = new Alert(Alert.AlertType.ERROR);
                                alerta.setTitle("Erro com modFrete");
                                alerta.setContentText("Erro ao inserir os dados de modFrete no banco de dados!" + erro);
                                alerta.showAndWait();
                            }
                            break;
                        //</editor-fold>
                    }
                }
            }
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="FORNECEDOR">
    public void fornecedor() throws ParserConfigurationException, SAXException, IOException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        String chnfe = null;
        //Pegando os arquivos para a leitura
        for (Object caminho_ob : array_caminho) {
            //lendo os arquivos XML's
            File diretorio = new File((String) caminho_ob);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(diretorio);
            //pegando a chave da nota para identificar os dados futuramente
            // <editor-fold defaultstate="collapsed" desc="CHAVE DA NOTA"> 
            NodeList se = doc.getElementsByTagName("infProt");
            int sea = se.getLength();
            for (int i = 0; i < sea; i++) {
                Node noide = se.item(i);
                if (noide.getNodeType() == Node.ELEMENT_NODE) {
                    Element listaide = (Element) noide;
                    NodeList listafilhoide = listaide.getChildNodes();
                    int tamanholistaide = listafilhoide.getLength();
                    for (int j = 0; j < tamanholistaide; j++) {
                        Node idei = listafilhoide.item(j);
                        if (idei.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementofilho = (Element) idei;
                            switch (elementofilho.getTagName()) {
                                case "chNFe":
                                    chnfe = elementofilho.getTextContent();
                                    break;
                            }
                        }
                    }
                }
            }
            //</editor-fold>
            // <editor-fold defaultstate="collapsed" desc="UNIDADE FEDERAL FORNECEDOR">
            NodeList enderemit = doc.getElementsByTagName("enderEmit");
            int enderemite = enderemit.getLength();
            for (int i = 0; i < enderemite; i++) {
                Node noide = enderemit.item(i);
                if (noide.getNodeType() == Node.ELEMENT_NODE) {
                    Element listaide = (Element) noide;
                    NodeList listafilhoide = listaide.getChildNodes();
                    int tamanholistaide = listafilhoide.getLength();
                    for (int j = 0; j < tamanholistaide; j++) {
                        Node idei = listafilhoide.item(j);
                        if (idei.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementofilho = (Element) idei;
                            switch (elementofilho.getTagName()) {
                                case "UF":
                                    try {
                                        stmt = con.prepareStatement("INSERT INTO uf(UF,chNFe) VALUES(?,?)");
                                        stmt.setString(1, elementofilho.getTextContent());
                                        stmt.setString(2, chnfe);
                                        stmt.execute();

                                    } catch (SQLException erro) {
                                        Alert alerta = new Alert(Alert.AlertType.ERROR);
                                        alerta.setTitle("Erro com UF");
                                        alerta.setContentText("Erro ao inserir os dados de UF no banco de dados!" + erro);
                                        alerta.showAndWait();
                                    }
                                    break;
                                case "cMun":
                                    try {
                                        stmt = con.prepareStatement("INSERT INTO cmun  (cMun,chNFe) VALUES(?,?)");
                                        stmt.setString(1, elementofilho.getTextContent());
                                        stmt.setString(2, chnfe);
                                        stmt.execute();

                                    } catch (SQLException erro) {
                                        Alert alerta = new Alert(Alert.AlertType.ERROR);
                                        alerta.setTitle("Erro com cMun");
                                        alerta.setContentText("Erro ao inserir os dados de cMun no banco de dados!" + erro);
                                        alerta.showAndWait();
                                    }
                                    break;

                            }
                        }
                    }
                }

            }
//</editor-fold>
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="EMITENTES">
    //pegando os dados do emitente
    public void emit() throws SAXException, ParserConfigurationException, IOException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        String chnfe = null;
        //Pegando os arquivos para a leitura
        for (Object caminho_ob : array_caminho) {
            //lendo os arquivos XML's
            File diretorio = new File((String) caminho_ob);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(diretorio);
            // <editor-fold defaultstate="collapsed" desc="CHAVE DA NOTA"> 
            //pegando a chave da nota para identificar os dados futuramente
            NodeList se = doc.getElementsByTagName("infProt");
            int sea = se.getLength();
            for (int i = 0; i < sea; i++) {
                Node noide = se.item(i);
                if (noide.getNodeType() == Node.ELEMENT_NODE) {
                    Element listaide = (Element) noide;
                    NodeList listafilhoide = listaide.getChildNodes();
                    int tamanholistaide = listafilhoide.getLength();
                    for (int j = 0; j < tamanholistaide; j++) {
                        Node idei = listafilhoide.item(j);
                        if (idei.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementofilho = (Element) idei;
                            switch (elementofilho.getTagName()) {
                                case "chNFe":
                                    chnfe = elementofilho.getTextContent();
                                    break;
                            }
                        }
                    }
                }
            }
            //</editor-fold>
            // <editor-fold defaultstate="collapsed" desc="CNPJ">
            //pegando o CNPJ do emitente e setando no banco de dados
            NodeList emitente = doc.getElementsByTagName("emit");
            int contemit = emitente.getLength();
            for (int i = 0; i < contemit; i++) {
                Node noEmit = emitente.item(i);
                if (noEmit.getNodeType() == Node.ELEMENT_NODE) {
                    Element listaemit = (Element) noEmit;
                    NodeList listafilhoemit = listaemit.getChildNodes();
                    int tamanholistamit = listafilhoemit.getLength();
                    for (int j = 0; j < tamanholistamit; j++) {
                        Node noemit = listafilhoemit.item(j);
                        if (noemit.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementofilhos = (Element) noemit;
                            switch (elementofilhos.getTagName()) {
                                case "CNPJ":
                                    try {
                                        stmt = con.prepareStatement("INSERT INTO cnpj(CNPJ,chNFe) VALUES(?,?)");
                                        stmt.setString(1, elementofilhos.getTextContent());
                                        stmt.setString(2, chnfe);
                                        stmt.execute();

                                    } catch (SQLException erro) {
                                        Alert alerta = new Alert(Alert.AlertType.ERROR);
                                        alerta.setTitle("Erro com cUF");
                                        alerta.setContentText("Erro ao inserir os dados de cUF no banco de dados!" + erro);
                                        alerta.showAndWait();
                                    }
                                    break;
                                case "IE":
                                    try {
                                        stmt = con.prepareStatement("INSERT INTO ie(IE,chNFe) VALUES(?,?)");
                                        stmt.setString(1, elementofilhos.getTextContent());
                                        stmt.setString(2, chnfe);
                                        stmt.execute();

                                    } catch (SQLException erro) {
                                        Alert alerta = new Alert(Alert.AlertType.ERROR);
                                        alerta.setTitle("Erro com IE");
                                        alerta.setContentText("Erro ao inserir os dados de IE no banco de dados!" + erro);
                                        alerta.showAndWait();
                                    }
                                    break;
                            }
                        }
                    }
                }
            }
            //</editor-fold>
        }
    }
    //fim pegar dados emitente  
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="VERPROC">
    public void verProc() throws SAXException, ParserConfigurationException, IOException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        String chnfe = null;
        //Pegando os arquivos para a leitura
        for (Object caminho_ob : array_caminho) {
            //lendo os arquivos XML's
            File diretorio = new File((String) caminho_ob);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(diretorio);
            /*pegando o numero da nota fiscal e importando no banco de dados junto com os outros campos do xml 
            para identificação dos dados futuramente */
            NodeList se = doc.getElementsByTagName("infProt");
            int sea = se.getLength();
            for (int i = 0; i < sea; i++) {
                Node noide = se.item(i);
                if (noide.getNodeType() == Node.ELEMENT_NODE) {
                    Element listaide = (Element) noide;
                    NodeList listafilhoide = listaide.getChildNodes();
                    int tamanholistaide = listafilhoide.getLength();
                    for (int j = 0; j < tamanholistaide; j++) {
                        Node idei = listafilhoide.item(j);
                        if (idei.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementofilho = (Element) idei;
                            switch (elementofilho.getTagName()) {
                                case "chNFe":
                                    chnfe = elementofilho.getTextContent();
                                    break;
                            }
                        }
                    }
                }
            }
            //pegando as tags filhas do xml e importando no banco de dados, da tag ide
            NodeList listaDePessoas = doc.getElementsByTagName("ide");
            int tamanhoLista = listaDePessoas.getLength();
            for (int i = 0; i < tamanhoLista; i++) {
                Node noPessoa = listaDePessoas.item(i);
                if (noPessoa.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementoPessoa = (Element) noPessoa;
                    NodeList listaDeFilhosDaPessoa = elementoPessoa.getChildNodes();
                    int tamanhoListaFilhos = listaDeFilhosDaPessoa.getLength();
                    for (int j = 0; j < tamanhoListaFilhos; j++) {
                        Node noFilho = listaDeFilhosDaPessoa.item(j);
                        if (noFilho.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementoFilho = (Element) noFilho;
                            switch (elementoFilho.getTagName()) {
                                case "verProc":
                                    try {
                                        stmt = con.prepareStatement("INSERT INTO verproc (verProc,chNFe) VALUES(?,?)");
                                        stmt.setString(1, elementoFilho.getTextContent());
                                        stmt.setString(2, chnfe);
                                        stmt.execute();
                                    } catch (SQLException erro) {
                                        Alert alerta = new Alert(Alert.AlertType.ERROR);
                                        alerta.setTitle("Erro com verProc");
                                        alerta.setContentText("Erro ao inserir os dados de verProc no banco de dados!" + erro);
                                        alerta.showAndWait();
                                    }
                                    break;
                            }
                        }
                    }
                }
            }
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="PROCEMI">
    public void procEmi() throws SAXException, ParserConfigurationException, IOException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        String chnfe = null;
        //Pegando os arquivos para a leitura
        for (Object caminho_ob : array_caminho) {
            //lendo os arquivos XML's
            File diretorio = new File((String) caminho_ob);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(diretorio);
            /*pegando o numero da nota fiscal e importando no banco de dados junto com os outros campos do xml 
            para identificação dos dados futuramente */
            NodeList se = doc.getElementsByTagName("infProt");
            int sea = se.getLength();
            for (int i = 0; i < sea; i++) {
                Node noide = se.item(i);
                if (noide.getNodeType() == Node.ELEMENT_NODE) {
                    Element listaide = (Element) noide;
                    NodeList listafilhoide = listaide.getChildNodes();
                    int tamanholistaide = listafilhoide.getLength();
                    for (int j = 0; j < tamanholistaide; j++) {
                        Node idei = listafilhoide.item(j);
                        if (idei.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementofilho = (Element) idei;
                            switch (elementofilho.getTagName()) {
                                case "chNFe":
                                    chnfe = elementofilho.getTextContent();
                                    break;
                            }
                        }
                    }
                }
            }
            //pegando as tags filhas do xml e importando no banco de dados, da tag ide
            NodeList listaDePessoas = doc.getElementsByTagName("ide");
            int tamanhoLista = listaDePessoas.getLength();
            for (int i = 0; i < tamanhoLista; i++) {
                Node noPessoa = listaDePessoas.item(i);
                if (noPessoa.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementoPessoa = (Element) noPessoa;
                    NodeList listaDeFilhosDaPessoa = elementoPessoa.getChildNodes();
                    int tamanhoListaFilhos = listaDeFilhosDaPessoa.getLength();
                    for (int j = 0; j < tamanhoListaFilhos; j++) {
                        Node noFilho = listaDeFilhosDaPessoa.item(j);
                        if (noFilho.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementoFilho = (Element) noFilho;
                            switch (elementoFilho.getTagName()) {
                                case "procEmi":
                                    try {
                                        stmt = con.prepareStatement("INSERT INTO procemi (procEmi,chNFe) VALUES(?,?)");
                                        stmt.setString(1, elementoFilho.getTextContent());
                                        stmt.setString(2, chnfe);
                                        stmt.execute();
                                    } catch (SQLException erro) {
                                        Alert alerta = new Alert(Alert.AlertType.ERROR);
                                        alerta.setTitle("Erro com procEmi");
                                        alerta.setContentText("Erro ao inserir os dados de procEmi no banco de dados!" + erro);
                                        alerta.showAndWait();
                                    }
                                    break;
                            }
                        }
                    }
                }
            }
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="INDPRES">
    public void indPres() throws SAXException, ParserConfigurationException, IOException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        String chnfe = null;
        //Pegando os arquivos para a leitura
        for (Object caminho_ob : array_caminho) {
            //lendo os arquivos XML's
            File diretorio = new File((String) caminho_ob);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(diretorio);
            /*pegando o numero da nota fiscal e importando no banco de dados junto com os outros campos do xml 
            para identificação dos dados futuramente */
            NodeList se = doc.getElementsByTagName("infProt");
            int sea = se.getLength();
            for (int i = 0; i < sea; i++) {
                Node noide = se.item(i);
                if (noide.getNodeType() == Node.ELEMENT_NODE) {
                    Element listaide = (Element) noide;
                    NodeList listafilhoide = listaide.getChildNodes();
                    int tamanholistaide = listafilhoide.getLength();
                    for (int j = 0; j < tamanholistaide; j++) {
                        Node idei = listafilhoide.item(j);
                        if (idei.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementofilho = (Element) idei;
                            switch (elementofilho.getTagName()) {
                                case "chNFe":
                                    chnfe = elementofilho.getTextContent();
                                    break;
                            }
                        }
                    }
                }
            }
            //pegando as tags filhas do xml e importando no banco de dados, da tag ide
            NodeList listaDePessoas = doc.getElementsByTagName("ide");
            int tamanhoLista = listaDePessoas.getLength();
            for (int i = 0; i < tamanhoLista; i++) {
                Node noPessoa = listaDePessoas.item(i);
                if (noPessoa.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementoPessoa = (Element) noPessoa;
                    NodeList listaDeFilhosDaPessoa = elementoPessoa.getChildNodes();
                    int tamanhoListaFilhos = listaDeFilhosDaPessoa.getLength();
                    for (int j = 0; j < tamanhoListaFilhos; j++) {
                        Node noFilho = listaDeFilhosDaPessoa.item(j);
                        if (noFilho.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementoFilho = (Element) noFilho;
                            switch (elementoFilho.getTagName()) {
                                case "indPres":
                                    try {
                                        stmt = con.prepareStatement("INSERT INTO indpres (indPres,chNFe) VALUES(?,?)");
                                        stmt.setString(1, elementoFilho.getTextContent());
                                        stmt.setString(2, chnfe);
                                        stmt.execute();
                                    } catch (SQLException erro) {
                                        Alert alerta = new Alert(Alert.AlertType.ERROR);
                                        alerta.setTitle("Erro com indPres");
                                        alerta.setContentText("Erro ao inserir os dados de indPres no banco de dados!" + erro);
                                        alerta.showAndWait();
                                    }
                                    break;
                            }
                        }
                    }
                }
            }
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="INDFINAL">
    public void indFinal() throws SAXException, ParserConfigurationException, IOException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        String chnfe = null;
        //Pegando os arquivos para a leitura
        for (Object caminho_ob : array_caminho) {
            //lendo os arquivos XML's
            File diretorio = new File((String) caminho_ob);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(diretorio);
            /*pegando o numero da nota fiscal e importando no banco de dados junto com os outros campos do xml 
            para identificação dos dados futuramente */
            NodeList se = doc.getElementsByTagName("infProt");
            int sea = se.getLength();
            for (int i = 0; i < sea; i++) {
                Node noide = se.item(i);
                if (noide.getNodeType() == Node.ELEMENT_NODE) {
                    Element listaide = (Element) noide;
                    NodeList listafilhoide = listaide.getChildNodes();
                    int tamanholistaide = listafilhoide.getLength();
                    for (int j = 0; j < tamanholistaide; j++) {
                        Node idei = listafilhoide.item(j);
                        if (idei.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementofilho = (Element) idei;
                            switch (elementofilho.getTagName()) {
                                case "chNFe":
                                    chnfe = elementofilho.getTextContent();
                                    break;
                            }
                        }
                    }
                }
            }
            //pegando as tags filhas do xml e importando no banco de dados, da tag ide
            NodeList listaDePessoas = doc.getElementsByTagName("ide");
            int tamanhoLista = listaDePessoas.getLength();
            for (int i = 0; i < tamanhoLista; i++) {
                Node noPessoa = listaDePessoas.item(i);
                if (noPessoa.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementoPessoa = (Element) noPessoa;
                    NodeList listaDeFilhosDaPessoa = elementoPessoa.getChildNodes();
                    int tamanhoListaFilhos = listaDeFilhosDaPessoa.getLength();
                    for (int j = 0; j < tamanhoListaFilhos; j++) {
                        Node noFilho = listaDeFilhosDaPessoa.item(j);
                        if (noFilho.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementoFilho = (Element) noFilho;
                            switch (elementoFilho.getTagName()) {
                                case "indFinal":
                                    try {
                                        stmt = con.prepareStatement("INSERT INTO indfinal (indFinal,chNFe) VALUES(?,?)");
                                        stmt.setString(1, elementoFilho.getTextContent());
                                        stmt.setString(2, chnfe);
                                        stmt.execute();
                                    } catch (SQLException erro) {
                                        Alert alerta = new Alert(Alert.AlertType.ERROR);
                                        alerta.setTitle("Erro com indFinal");
                                        alerta.setContentText("Erro ao inserir os dados de indFinal no banco de dados!" + erro);
                                        alerta.showAndWait();
                                    }
                                    break;
                            }
                        }
                    }
                }
            }
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="FINNFE">
    public void finNFe() throws SAXException, ParserConfigurationException, IOException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        String chnfe = null;
        //Pegando os arquivos para a leitura
        for (Object caminho_ob : array_caminho) {
            //lendo os arquivos XML's
            File diretorio = new File((String) caminho_ob);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(diretorio);
            /*pegando o numero da nota fiscal e importando no banco de dados junto com os outros campos do xml 
            para identificação dos dados futuramente */
            NodeList se = doc.getElementsByTagName("infProt");
            int sea = se.getLength();
            for (int i = 0; i < sea; i++) {
                Node noide = se.item(i);
                if (noide.getNodeType() == Node.ELEMENT_NODE) {
                    Element listaide = (Element) noide;
                    NodeList listafilhoide = listaide.getChildNodes();
                    int tamanholistaide = listafilhoide.getLength();
                    for (int j = 0; j < tamanholistaide; j++) {
                        Node idei = listafilhoide.item(j);
                        if (idei.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementofilho = (Element) idei;
                            switch (elementofilho.getTagName()) {
                                case "chNFe":
                                    chnfe = elementofilho.getTextContent();
                                    break;
                            }
                        }
                    }
                }
            }
            //pegando as tags filhas do xml e importando no banco de dados, da tag ide
            NodeList listaDePessoas = doc.getElementsByTagName("ide");
            int tamanhoLista = listaDePessoas.getLength();
            for (int i = 0; i < tamanhoLista; i++) {
                Node noPessoa = listaDePessoas.item(i);
                if (noPessoa.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementoPessoa = (Element) noPessoa;
                    NodeList listaDeFilhosDaPessoa = elementoPessoa.getChildNodes();
                    int tamanhoListaFilhos = listaDeFilhosDaPessoa.getLength();
                    for (int j = 0; j < tamanhoListaFilhos; j++) {
                        Node noFilho = listaDeFilhosDaPessoa.item(j);
                        if (noFilho.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementoFilho = (Element) noFilho;
                            switch (elementoFilho.getTagName()) {
                                case "finNFe":
                                    try {
                                        stmt = con.prepareStatement("INSERT INTO finnfe (finNFe,chNFe) VALUES(?,?)");
                                        stmt.setString(1, elementoFilho.getTextContent());
                                        stmt.setString(2, chnfe);
                                        stmt.execute();
                                    } catch (SQLException erro) {
                                        Alert alerta = new Alert(Alert.AlertType.ERROR);
                                        alerta.setTitle("Erro com finNFe");
                                        alerta.setContentText("Erro ao inserir os dados de finNFe no banco de dados!" + erro);
                                        alerta.showAndWait();
                                    }
                                    break;
                            }
                        }
                    }
                }
            }
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="TPAMB">
    public void tpAmb() throws SAXException, ParserConfigurationException, IOException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        String chnfe = null;
        //Pegando os arquivos para a leitura
        for (Object caminho_ob : array_caminho) {
            //lendo os arquivos XML's
            File diretorio = new File((String) caminho_ob);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(diretorio);
            /*pegando o numero da nota fiscal e importando no banco de dados junto com os outros campos do xml 
            para identificação dos dados futuramente */
            NodeList se = doc.getElementsByTagName("infProt");
            int sea = se.getLength();
            for (int i = 0; i < sea; i++) {
                Node noide = se.item(i);
                if (noide.getNodeType() == Node.ELEMENT_NODE) {
                    Element listaide = (Element) noide;
                    NodeList listafilhoide = listaide.getChildNodes();
                    int tamanholistaide = listafilhoide.getLength();
                    for (int j = 0; j < tamanholistaide; j++) {
                        Node idei = listafilhoide.item(j);
                        if (idei.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementofilho = (Element) idei;
                            switch (elementofilho.getTagName()) {
                                case "chNFe":
                                    chnfe = elementofilho.getTextContent();
                                    break;
                            }
                        }
                    }
                }
            }
            //pegando as tags filhas do xml e importando no banco de dados, da tag ide
            NodeList listaDePessoas = doc.getElementsByTagName("ide");
            int tamanhoLista = listaDePessoas.getLength();
            for (int i = 0; i < tamanhoLista; i++) {
                Node noPessoa = listaDePessoas.item(i);
                if (noPessoa.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementoPessoa = (Element) noPessoa;
                    NodeList listaDeFilhosDaPessoa = elementoPessoa.getChildNodes();
                    int tamanhoListaFilhos = listaDeFilhosDaPessoa.getLength();
                    for (int j = 0; j < tamanhoListaFilhos; j++) {
                        Node noFilho = listaDeFilhosDaPessoa.item(j);
                        if (noFilho.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementoFilho = (Element) noFilho;
                            switch (elementoFilho.getTagName()) {
                                case "tpAmb":
                                    try {
                                        stmt = con.prepareStatement("INSERT INTO tpamb (tpAmb,chNFe) VALUES(?,?)");
                                        stmt.setString(1, elementoFilho.getTextContent());
                                        stmt.setString(2, chnfe);
                                        stmt.execute();
                                    } catch (SQLException erro) {
                                        Alert alerta = new Alert(Alert.AlertType.ERROR);
                                        alerta.setTitle("Erro com tpAmb");
                                        alerta.setContentText("Erro ao inserir os dados de tpAmb no banco de dados!" + erro);
                                        alerta.showAndWait();
                                    }
                                    break;
                            }
                        }
                    }
                }
            }
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="CDV">
    public void cDV() throws SAXException, ParserConfigurationException, IOException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        String chnfe = null;
        //Pegando os arquivos para a leitura
        for (Object caminho_ob : array_caminho) {
            //lendo os arquivos XML's
            File diretorio = new File((String) caminho_ob);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(diretorio);
            /*pegando o numero da nota fiscal e importando no banco de dados junto com os outros campos do xml 
            para identificação dos dados futuramente */
            NodeList se = doc.getElementsByTagName("infProt");
            int sea = se.getLength();
            for (int i = 0; i < sea; i++) {
                Node noide = se.item(i);
                if (noide.getNodeType() == Node.ELEMENT_NODE) {
                    Element listaide = (Element) noide;
                    NodeList listafilhoide = listaide.getChildNodes();
                    int tamanholistaide = listafilhoide.getLength();
                    for (int j = 0; j < tamanholistaide; j++) {
                        Node idei = listafilhoide.item(j);
                        if (idei.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementofilho = (Element) idei;
                            switch (elementofilho.getTagName()) {
                                case "chNFe":
                                    chnfe = elementofilho.getTextContent();
                                    break;
                            }
                        }
                    }
                }
            }
            //pegando as tags filhas do xml e importando no banco de dados, da tag ide
            NodeList listaDePessoas = doc.getElementsByTagName("ide");
            int tamanhoLista = listaDePessoas.getLength();
            for (int i = 0; i < tamanhoLista; i++) {
                Node noPessoa = listaDePessoas.item(i);
                if (noPessoa.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementoPessoa = (Element) noPessoa;
                    NodeList listaDeFilhosDaPessoa = elementoPessoa.getChildNodes();
                    int tamanhoListaFilhos = listaDeFilhosDaPessoa.getLength();
                    for (int j = 0; j < tamanhoListaFilhos; j++) {
                        Node noFilho = listaDeFilhosDaPessoa.item(j);
                        if (noFilho.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementoFilho = (Element) noFilho;
                            switch (elementoFilho.getTagName()) {
                                case "cDV":
                                    try {
                                        stmt = con.prepareStatement("INSERT INTO cdv (cDV,chNFe) VALUES(?,?)");
                                        stmt.setString(1, elementoFilho.getTextContent());
                                        stmt.setString(2, chnfe);
                                        stmt.execute();
                                    } catch (SQLException erro) {
                                        Alert alerta = new Alert(Alert.AlertType.ERROR);
                                        alerta.setTitle("Erro com cDV");
                                        alerta.setContentText("Erro ao inserir os dados de cDV no banco de dados!" + erro);
                                        alerta.showAndWait();
                                    }
                                    break;
                            }
                        }
                    }
                }
            }
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="TPEMIS">
    public void tpEmis() throws SAXException, ParserConfigurationException, IOException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        String chnfe = null;
        //Pegando os arquivos para a leitura
        for (Object caminho_ob : array_caminho) {
            //lendo os arquivos XML's
            File diretorio = new File((String) caminho_ob);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(diretorio);
            /*pegando o numero da nota fiscal e importando no banco de dados junto com os outros campos do xml 
            para identificação dos dados futuramente */
            NodeList se = doc.getElementsByTagName("infProt");
            int sea = se.getLength();
            for (int i = 0; i < sea; i++) {
                Node noide = se.item(i);
                if (noide.getNodeType() == Node.ELEMENT_NODE) {
                    Element listaide = (Element) noide;
                    NodeList listafilhoide = listaide.getChildNodes();
                    int tamanholistaide = listafilhoide.getLength();
                    for (int j = 0; j < tamanholistaide; j++) {
                        Node idei = listafilhoide.item(j);
                        if (idei.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementofilho = (Element) idei;
                            switch (elementofilho.getTagName()) {
                                case "chNFe":
                                    chnfe = elementofilho.getTextContent();
                                    break;
                            }
                        }
                    }
                }
            }
            //pegando as tags filhas do xml e importando no banco de dados, da tag ide
            NodeList listaDePessoas = doc.getElementsByTagName("ide");
            int tamanhoLista = listaDePessoas.getLength();
            for (int i = 0; i < tamanhoLista; i++) {
                Node noPessoa = listaDePessoas.item(i);
                if (noPessoa.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementoPessoa = (Element) noPessoa;
                    NodeList listaDeFilhosDaPessoa = elementoPessoa.getChildNodes();
                    int tamanhoListaFilhos = listaDeFilhosDaPessoa.getLength();
                    for (int j = 0; j < tamanhoListaFilhos; j++) {
                        Node noFilho = listaDeFilhosDaPessoa.item(j);
                        if (noFilho.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementoFilho = (Element) noFilho;
                            switch (elementoFilho.getTagName()) {
                                case "tpEmis":
                                    try {
                                        stmt = con.prepareStatement("INSERT INTO tpemis (tpEmis,chNFe) VALUES(?,?)");
                                        stmt.setString(1, elementoFilho.getTextContent());
                                        stmt.setString(2, chnfe);
                                        stmt.execute();
                                    } catch (SQLException erro) {
                                        Alert alerta = new Alert(Alert.AlertType.ERROR);
                                        alerta.setTitle("Erro com tpEmis");
                                        alerta.setContentText("Erro ao inserir os dados de tpEmis no banco de dados!" + erro);
                                        alerta.showAndWait();
                                    }
                                    break;
                            }
                        }
                    }
                }
            }
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="TPIMP">
    public void tpImp() throws SAXException, ParserConfigurationException, IOException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        String chnfe = null;
        //Pegando os arquivos para a leitura
        for (Object caminho_ob : array_caminho) {
            //lendo os arquivos XML's
            File diretorio = new File((String) caminho_ob);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(diretorio);
            /*pegando o numero da nota fiscal e importando no banco de dados junto com os outros campos do xml 
            para identificação dos dados futuramente */
            NodeList se = doc.getElementsByTagName("infProt");
            int sea = se.getLength();
            for (int i = 0; i < sea; i++) {
                Node noide = se.item(i);
                if (noide.getNodeType() == Node.ELEMENT_NODE) {
                    Element listaide = (Element) noide;
                    NodeList listafilhoide = listaide.getChildNodes();
                    int tamanholistaide = listafilhoide.getLength();
                    for (int j = 0; j < tamanholistaide; j++) {
                        Node idei = listafilhoide.item(j);
                        if (idei.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementofilho = (Element) idei;
                            switch (elementofilho.getTagName()) {
                                case "chNFe":
                                    chnfe = elementofilho.getTextContent();
                                    break;
                            }
                        }
                    }
                }
            }
            //pegando as tags filhas do xml e importando no banco de dados, da tag ide
            NodeList listaDePessoas = doc.getElementsByTagName("ide");
            int tamanhoLista = listaDePessoas.getLength();
            for (int i = 0; i < tamanhoLista; i++) {
                Node noPessoa = listaDePessoas.item(i);
                if (noPessoa.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementoPessoa = (Element) noPessoa;
                    NodeList listaDeFilhosDaPessoa = elementoPessoa.getChildNodes();
                    int tamanhoListaFilhos = listaDeFilhosDaPessoa.getLength();
                    for (int j = 0; j < tamanhoListaFilhos; j++) {
                        Node noFilho = listaDeFilhosDaPessoa.item(j);
                        if (noFilho.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementoFilho = (Element) noFilho;
                            switch (elementoFilho.getTagName()) {
                                case "tpImp":
                                    try {
                                        stmt = con.prepareStatement("INSERT INTO tpimp (tpImp,chNFe) VALUES(?,?)");
                                        stmt.setString(1, elementoFilho.getTextContent());
                                        stmt.setString(2, chnfe);
                                        stmt.execute();

                                    } catch (SQLException erro) {
                                        Alert alerta = new Alert(Alert.AlertType.ERROR);
                                        alerta.setTitle("Erro com tpImp");
                                        alerta.setContentText("Erro ao inserir os dados de tpImp no banco de dados!" + erro);
                                        alerta.showAndWait();
                                    }
                                    break;
                            }
                        }
                    }
                }
            }
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="CMUNFG">
    public void cMunFG() throws SAXException, ParserConfigurationException, IOException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        String chnfe = null;
        //Pegando os arquivos para a leitura
        for (Object caminho_ob : array_caminho) {
            //lendo os arquivos XML's
            File diretorio = new File((String) caminho_ob);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(diretorio);
            /*pegando o numero da nota fiscal e importando no banco de dados junto com os outros campos do xml 
            para identificação dos dados futuramente */
            NodeList se = doc.getElementsByTagName("infProt");
            int sea = se.getLength();
            for (int i = 0; i < sea; i++) {
                Node noide = se.item(i);
                if (noide.getNodeType() == Node.ELEMENT_NODE) {
                    Element listaide = (Element) noide;
                    NodeList listafilhoide = listaide.getChildNodes();
                    int tamanholistaide = listafilhoide.getLength();
                    for (int j = 0; j < tamanholistaide; j++) {
                        Node idei = listafilhoide.item(j);
                        if (idei.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementofilho = (Element) idei;
                            switch (elementofilho.getTagName()) {
                                case "chNFe":
                                    chnfe = elementofilho.getTextContent();
                                    break;
                            }
                        }
                    }
                }
            }
            //pegando as tags filhas do xml e importando no banco de dados, da tag ide
            NodeList listaDePessoas = doc.getElementsByTagName("ide");
            int tamanhoLista = listaDePessoas.getLength();
            for (int i = 0; i < tamanhoLista; i++) {
                Node noPessoa = listaDePessoas.item(i);
                if (noPessoa.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementoPessoa = (Element) noPessoa;
                    NodeList listaDeFilhosDaPessoa = elementoPessoa.getChildNodes();
                    int tamanhoListaFilhos = listaDeFilhosDaPessoa.getLength();
                    for (int j = 0; j < tamanhoListaFilhos; j++) {
                        Node noFilho = listaDeFilhosDaPessoa.item(j);
                        if (noFilho.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementoFilho = (Element) noFilho;
                            switch (elementoFilho.getTagName()) {
                                case "cMunFG":
                                    try {
                                        stmt = con.prepareStatement("INSERT INTO cmunfg (cMunFG,chNFe) VALUES(?,?)");
                                        stmt.setString(1, elementoFilho.getTextContent());
                                        stmt.setString(2, chnfe);
                                        stmt.execute();

                                    } catch (SQLException erro) {
                                        Alert alerta = new Alert(Alert.AlertType.ERROR);
                                        alerta.setTitle("Erro com cMunFG");
                                        alerta.setContentText("Erro ao inserir os dados de cMunFG no banco de dados!" + erro);
                                        alerta.showAndWait();
                                    }
                                    break;
                            }
                        }
                    }
                }
            }
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="IDDEST">
    public void idDest() throws SAXException, ParserConfigurationException, IOException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        String chnfe = null;
        //Pegando os arquivos para a leitura
        for (Object caminho_ob : array_caminho) {
            //lendo os arquivos XML's
            File diretorio = new File((String) caminho_ob);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(diretorio);
            /*pegando o numero da nota fiscal e importando no banco de dados junto com os outros campos do xml 
            para identificação dos dados futuramente */
            NodeList se = doc.getElementsByTagName("infProt");
            int sea = se.getLength();
            for (int i = 0; i < sea; i++) {
                Node noide = se.item(i);
                if (noide.getNodeType() == Node.ELEMENT_NODE) {
                    Element listaide = (Element) noide;
                    NodeList listafilhoide = listaide.getChildNodes();
                    int tamanholistaide = listafilhoide.getLength();
                    for (int j = 0; j < tamanholistaide; j++) {
                        Node idei = listafilhoide.item(j);
                        if (idei.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementofilho = (Element) idei;
                            switch (elementofilho.getTagName()) {
                                case "chNFe":
                                    chnfe = elementofilho.getTextContent();
                                    break;
                            }
                        }
                    }
                }
            }
            //pegando as tags filhas do xml e importando no banco de dados, da tag ide
            NodeList listaDePessoas = doc.getElementsByTagName("ide");
            int tamanhoLista = listaDePessoas.getLength();
            for (int i = 0; i < tamanhoLista; i++) {
                Node noPessoa = listaDePessoas.item(i);
                if (noPessoa.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementoPessoa = (Element) noPessoa;
                    NodeList listaDeFilhosDaPessoa = elementoPessoa.getChildNodes();
                    int tamanhoListaFilhos = listaDeFilhosDaPessoa.getLength();
                    for (int j = 0; j < tamanhoListaFilhos; j++) {
                        Node noFilho = listaDeFilhosDaPessoa.item(j);
                        if (noFilho.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementoFilho = (Element) noFilho;
                            switch (elementoFilho.getTagName()) {
                                case "idDest":
                                    try {
                                        stmt = con.prepareStatement("INSERT INTO iddest (idDest,chNFe) VALUES(?,?)");
                                        stmt.setString(1, elementoFilho.getTextContent());
                                        stmt.setString(2, chnfe);
                                        stmt.execute();

                                    } catch (SQLException erro) {
                                        Alert alerta = new Alert(Alert.AlertType.ERROR);
                                        alerta.setTitle("Erro com idDest");
                                        alerta.setContentText("Erro ao inserir os dados de idDest no banco de dados!" + erro);
                                        alerta.showAndWait();
                                    }
                                    break;
                            }
                        }
                    }
                }
            }
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="TPNF">
    public void tpNF() throws SAXException, ParserConfigurationException, IOException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        String chnfe = null;
        //Pegando os arquivos para a leitura
        for (Object caminho_ob : array_caminho) {
            //lendo os arquivos XML's
            File diretorio = new File((String) caminho_ob);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(diretorio);
            /*pegando o numero da nota fiscal e importando no banco de dados junto com os outros campos do xml 
            para identificação dos dados futuramente */
            NodeList se = doc.getElementsByTagName("infProt");
            int sea = se.getLength();
            for (int i = 0; i < sea; i++) {
                Node noide = se.item(i);
                if (noide.getNodeType() == Node.ELEMENT_NODE) {
                    Element listaide = (Element) noide;
                    NodeList listafilhoide = listaide.getChildNodes();
                    int tamanholistaide = listafilhoide.getLength();
                    for (int j = 0; j < tamanholistaide; j++) {
                        Node idei = listafilhoide.item(j);
                        if (idei.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementofilho = (Element) idei;
                            switch (elementofilho.getTagName()) {
                                case "chNFe":
                                    chnfe = elementofilho.getTextContent();
                                    break;
                            }
                        }
                    }
                }
            }
            //pegando as tags filhas do xml e importando no banco de dados, da tag ide
            NodeList listaDePessoas = doc.getElementsByTagName("ide");
            int tamanhoLista = listaDePessoas.getLength();
            for (int i = 0; i < tamanhoLista; i++) {
                Node noPessoa = listaDePessoas.item(i);
                if (noPessoa.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementoPessoa = (Element) noPessoa;
                    NodeList listaDeFilhosDaPessoa = elementoPessoa.getChildNodes();
                    int tamanhoListaFilhos = listaDeFilhosDaPessoa.getLength();
                    for (int j = 0; j < tamanhoListaFilhos; j++) {
                        Node noFilho = listaDeFilhosDaPessoa.item(j);
                        if (noFilho.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementoFilho = (Element) noFilho;
                            switch (elementoFilho.getTagName()) {
                                case "tpNF":
                                    try {
                                        stmt = con.prepareStatement("INSERT INTO tpnf (tpNF,chNFe) VALUES(?,?)");
                                        stmt.setString(1, elementoFilho.getTextContent());
                                        stmt.setString(2, chnfe);
                                        stmt.execute();

                                    } catch (SQLException erro) {
                                        Alert alerta = new Alert(Alert.AlertType.ERROR);
                                        alerta.setTitle("Erro com tpNF");
                                        alerta.setContentText("Erro ao inserir os dados de tpNF no banco de dados!" + erro);
                                        alerta.showAndWait();
                                    }
                                    break;
                            }
                        }
                    }
                }
            }
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="DHSAIENT">
    public void dhSaiEnt() throws SAXException, ParserConfigurationException, IOException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        String chnfe = null;
        //Pegando os arquivos para a leitura
        for (Object caminho_ob : array_caminho) {
            //lendo os arquivos XML's
            File diretorio = new File((String) caminho_ob);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(diretorio);
            /*pegando o numero da nota fiscal e importando no banco de dados junto com os outros campos do xml 
            para identificação dos dados futuramente */
            NodeList se = doc.getElementsByTagName("infProt");
            int sea = se.getLength();
            for (int i = 0; i < sea; i++) {
                Node noide = se.item(i);
                if (noide.getNodeType() == Node.ELEMENT_NODE) {
                    Element listaide = (Element) noide;
                    NodeList listafilhoide = listaide.getChildNodes();
                    int tamanholistaide = listafilhoide.getLength();
                    for (int j = 0; j < tamanholistaide; j++) {
                        Node idei = listafilhoide.item(j);
                        if (idei.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementofilho = (Element) idei;
                            switch (elementofilho.getTagName()) {
                                case "chNFe":
                                    chnfe = elementofilho.getTextContent();
                                    break;
                            }
                        }
                    }
                }
            }
            //pegando as tags filhas do xml e importando no banco de dados, da tag ide
            NodeList listaDePessoas = doc.getElementsByTagName("ide");
            int tamanhoLista = listaDePessoas.getLength();
            for (int i = 0; i < tamanhoLista; i++) {
                Node noPessoa = listaDePessoas.item(i);
                if (noPessoa.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementoPessoa = (Element) noPessoa;
                    NodeList listaDeFilhosDaPessoa = elementoPessoa.getChildNodes();
                    int tamanhoListaFilhos = listaDeFilhosDaPessoa.getLength();
                    for (int j = 0; j < tamanhoListaFilhos; j++) {
                        Node noFilho = listaDeFilhosDaPessoa.item(j);
                        if (noFilho.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementoFilho = (Element) noFilho;
                            switch (elementoFilho.getTagName()) {
                                case "dhSaiEnt":
                                    try {
                                        stmt = con.prepareStatement("INSERT INTO dhsaient (dhSaiEnt,chNFe) VALUES(?,?)");
                                        stmt.setString(1, elementoFilho.getTextContent());
                                        stmt.setString(2, chnfe);
                                        stmt.execute();

                                    } catch (SQLException erro) {
                                        Alert alerta = new Alert(Alert.AlertType.ERROR);
                                        alerta.setTitle("Erro com dhSaiEnt");
                                        alerta.setContentText("Erro ao inserir os dados de dhSaiEnt no banco de dados!" + erro);
                                        alerta.showAndWait();
                                    }
                                    break;
                            }
                        }
                    }
                }
            }
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="DHEMI">
    public void dhEmi() throws SAXException, ParserConfigurationException, IOException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        String chnfe = null;
        //Pegando os arquivos para a leitura
        for (Object caminho_ob : array_caminho) {
            //lendo os arquivos XML's
            File diretorio = new File((String) caminho_ob);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(diretorio);
            /*pegando o numero da nota fiscal e importando no banco de dados junto com os outros campos do xml 
            para identificação dos dados futuramente */
            NodeList se = doc.getElementsByTagName("infProt");
            int sea = se.getLength();
            for (int i = 0; i < sea; i++) {
                Node noide = se.item(i);
                if (noide.getNodeType() == Node.ELEMENT_NODE) {
                    Element listaide = (Element) noide;
                    NodeList listafilhoide = listaide.getChildNodes();
                    int tamanholistaide = listafilhoide.getLength();
                    for (int j = 0; j < tamanholistaide; j++) {
                        Node idei = listafilhoide.item(j);
                        if (idei.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementofilho = (Element) idei;
                            switch (elementofilho.getTagName()) {
                                case "chNFe":
                                    chnfe = elementofilho.getTextContent();
                                    break;
                            }
                        }
                    }
                }
            }
            //pegando as tags filhas do xml e importando no banco de dados, da tag ide
            NodeList listaDePessoas = doc.getElementsByTagName("ide");
            int tamanhoLista = listaDePessoas.getLength();
            for (int i = 0; i < tamanhoLista; i++) {
                Node noPessoa = listaDePessoas.item(i);
                if (noPessoa.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementoPessoa = (Element) noPessoa;
                    NodeList listaDeFilhosDaPessoa = elementoPessoa.getChildNodes();
                    int tamanhoListaFilhos = listaDeFilhosDaPessoa.getLength();
                    for (int j = 0; j < tamanhoListaFilhos; j++) {
                        Node noFilho = listaDeFilhosDaPessoa.item(j);
                        if (noFilho.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementoFilho = (Element) noFilho;
                            switch (elementoFilho.getTagName()) {
                                case "dhEmi":
                                    try {
                                        stmt = con.prepareStatement("INSERT INTO dhemi (dhEmi,chNFe) VALUES(?,?)");
                                        stmt.setString(1, elementoFilho.getTextContent());
                                        stmt.setString(2, chnfe);
                                        stmt.execute();

                                    } catch (SQLException erro) {
                                        Alert alerta = new Alert(Alert.AlertType.ERROR);
                                        alerta.setTitle("Erro com dhEmi");
                                        alerta.setContentText("Erro ao inserir os dados de dhEmi no banco de dados!" + erro);
                                        alerta.showAndWait();
                                    }
                                    break;
                            }
                        }
                    }
                }
            }
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="NNF">
    public void nNF() throws SAXException, ParserConfigurationException, IOException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        String chnfe = null;
        //Pegando os arquivos para a leitura
        for (Object caminho_ob : array_caminho) {
            //lendo os arquivos XML's
            File diretorio = new File((String) caminho_ob);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(diretorio);
            /*pegando o numero da nota fiscal e importando no banco de dados junto com os outros campos do xml 
            para identificação dos dados futuramente */
            NodeList se = doc.getElementsByTagName("infProt");
            int sea = se.getLength();
            for (int i = 0; i < sea; i++) {
                Node noide = se.item(i);
                if (noide.getNodeType() == Node.ELEMENT_NODE) {
                    Element listaide = (Element) noide;
                    NodeList listafilhoide = listaide.getChildNodes();
                    int tamanholistaide = listafilhoide.getLength();
                    for (int j = 0; j < tamanholistaide; j++) {
                        Node idei = listafilhoide.item(j);
                        if (idei.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementofilho = (Element) idei;
                            switch (elementofilho.getTagName()) {
                                case "chNFe":
                                    chnfe = elementofilho.getTextContent();
                                    break;
                            }
                        }
                    }
                }
            }
            //pegando as tags filhas do xml e importando no banco de dados, da tag ide
            NodeList listaDePessoas = doc.getElementsByTagName("ide");
            int tamanhoLista = listaDePessoas.getLength();
            for (int i = 0; i < tamanhoLista; i++) {
                Node noPessoa = listaDePessoas.item(i);
                if (noPessoa.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementoPessoa = (Element) noPessoa;
                    NodeList listaDeFilhosDaPessoa = elementoPessoa.getChildNodes();
                    int tamanhoListaFilhos = listaDeFilhosDaPessoa.getLength();
                    for (int j = 0; j < tamanhoListaFilhos; j++) {
                        Node noFilho = listaDeFilhosDaPessoa.item(j);
                        if (noFilho.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementoFilho = (Element) noFilho;
                            switch (elementoFilho.getTagName()) {
                                case "nNF":
                                    try {
                                        stmt = con.prepareStatement("INSERT INTO nnf (nNF,chNFe) VALUES(?,?)");
                                        stmt.setString(1, elementoFilho.getTextContent());
                                        stmt.setString(2, chnfe);
                                        stmt.execute();

                                    } catch (SQLException erro) {
                                        Alert alerta = new Alert(Alert.AlertType.ERROR);
                                        alerta.setTitle("Erro com nNF");
                                        alerta.setContentText("Erro ao inserir os dados de nNF no banco de dados!" + erro);
                                        alerta.showAndWait();
                                    }
                                    break;
                            }
                        }
                    }
                }
            }
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="SERIE">
    public void serie() throws SAXException, ParserConfigurationException, IOException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        String chnfe = null;
        //Pegando os arquivos para a leitura
        for (Object caminho_ob : array_caminho) {
            //lendo os arquivos XML's
            File diretorio = new File((String) caminho_ob);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(diretorio);
            /*pegando o numero da nota fiscal e importando no banco de dados junto com os outros campos do xml 
            para identificação dos dados futuramente */
            NodeList se = doc.getElementsByTagName("infProt");
            int sea = se.getLength();
            for (int i = 0; i < sea; i++) {
                Node noide = se.item(i);
                if (noide.getNodeType() == Node.ELEMENT_NODE) {
                    Element listaide = (Element) noide;
                    NodeList listafilhoide = listaide.getChildNodes();
                    int tamanholistaide = listafilhoide.getLength();
                    for (int j = 0; j < tamanholistaide; j++) {
                        Node idei = listafilhoide.item(j);
                        if (idei.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementofilho = (Element) idei;
                            switch (elementofilho.getTagName()) {
                                case "chNFe":
                                    chnfe = elementofilho.getTextContent();
                                    break;
                            }
                        }
                    }
                }
            }
            //pegando as tags filhas do xml e importando no banco de dados, da tag ide
            NodeList listaDePessoas = doc.getElementsByTagName("ide");
            int tamanhoLista = listaDePessoas.getLength();
            for (int i = 0; i < tamanhoLista; i++) {
                Node noPessoa = listaDePessoas.item(i);
                if (noPessoa.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementoPessoa = (Element) noPessoa;
                    NodeList listaDeFilhosDaPessoa = elementoPessoa.getChildNodes();
                    int tamanhoListaFilhos = listaDeFilhosDaPessoa.getLength();
                    for (int j = 0; j < tamanhoListaFilhos; j++) {
                        Node noFilho = listaDeFilhosDaPessoa.item(j);
                        if (noFilho.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementoFilho = (Element) noFilho;
                            switch (elementoFilho.getTagName()) {
                                case "serie":
                                    try {
                                        stmt = con.prepareStatement("INSERT INTO serie (Serie,chNFe) VALUES(?,?)");
                                        stmt.setString(1, elementoFilho.getTextContent());
                                        stmt.setString(2, chnfe);
                                        stmt.execute();

                                    } catch (SQLException erro) {
                                        Alert alerta = new Alert(Alert.AlertType.ERROR);
                                        alerta.setTitle("Erro com Serie");
                                        alerta.setContentText("Erro ao inserir os dados de Serie no banco de dados!" + erro);
                                        alerta.showAndWait();
                                    }
                                    break;
                            }
                        }
                    }
                }
            }
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="MOD">
    public void mod() throws SAXException, ParserConfigurationException, IOException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        String chnfe = null;
        //Pegando os arquivos para a leitura
        for (Object caminho_ob : array_caminho) {
            //lendo os arquivos XML's
            File diretorio = new File((String) caminho_ob);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(diretorio);
            /*pegando o numero da nota fiscal e importando no banco de dados junto com os outros campos do xml 
            para identificação dos dados futuramente */
            NodeList se = doc.getElementsByTagName("infProt");
            int sea = se.getLength();
            for (int i = 0; i < sea; i++) {
                Node noide = se.item(i);
                if (noide.getNodeType() == Node.ELEMENT_NODE) {
                    Element listaide = (Element) noide;
                    NodeList listafilhoide = listaide.getChildNodes();
                    int tamanholistaide = listafilhoide.getLength();
                    for (int j = 0; j < tamanholistaide; j++) {
                        Node idei = listafilhoide.item(j);
                        if (idei.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementofilho = (Element) idei;
                            switch (elementofilho.getTagName()) {
                                case "chNFe":
                                    chnfe = elementofilho.getTextContent();
                                    break;
                            }
                        }
                    }
                }
            }
            //pegando as tags filhas do xml e importando no banco de dados, da tag ide
            NodeList listaDePessoas = doc.getElementsByTagName("ide");
            int tamanhoLista = listaDePessoas.getLength();
            for (int i = 0; i < tamanhoLista; i++) {
                Node noPessoa = listaDePessoas.item(i);
                if (noPessoa.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementoPessoa = (Element) noPessoa;
                    NodeList listaDeFilhosDaPessoa = elementoPessoa.getChildNodes();
                    int tamanhoListaFilhos = listaDeFilhosDaPessoa.getLength();
                    for (int j = 0; j < tamanhoListaFilhos; j++) {
                        Node noFilho = listaDeFilhosDaPessoa.item(j);
                        if (noFilho.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementoFilho = (Element) noFilho;
                            switch (elementoFilho.getTagName()) {
                                case "mod":
                                    try {
                                        stmt = con.prepareStatement("INSERT INTO mod_xml (Mod_xml,chNFe) VALUES(?,?)");
                                        stmt.setString(1, elementoFilho.getTextContent());
                                        stmt.setString(2, chnfe);
                                        stmt.execute();

                                    } catch (SQLException erro) {
                                        Alert alerta = new Alert(Alert.AlertType.ERROR);
                                        alerta.setTitle("Erro com mod_xml");
                                        alerta.setContentText("Erro ao inserir os dados de mod_xml no banco de dados!" + erro);
                                        alerta.showAndWait();
                                    }
                                    break;
                            }
                        }
                    }
                }
            }
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="INDPAG">
    public void indPag() throws SAXException, ParserConfigurationException, IOException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        String chnfe = null;
        //Pegando os arquivos para a leitura
        for (Object caminho_ob : array_caminho) {
            //lendo os arquivos XML's
            File diretorio = new File((String) caminho_ob);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(diretorio);
            /*pegando o numero da nota fiscal e importando no banco de dados junto com os outros campos do xml 
            para identificação dos dados futuramente */
            NodeList se = doc.getElementsByTagName("infProt");
            int sea = se.getLength();
            for (int i = 0; i < sea; i++) {
                Node noide = se.item(i);
                if (noide.getNodeType() == Node.ELEMENT_NODE) {
                    Element listaide = (Element) noide;
                    NodeList listafilhoide = listaide.getChildNodes();
                    int tamanholistaide = listafilhoide.getLength();
                    for (int j = 0; j < tamanholistaide; j++) {
                        Node idei = listafilhoide.item(j);
                        if (idei.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementofilho = (Element) idei;
                            switch (elementofilho.getTagName()) {
                                case "chNFe":
                                    chnfe = elementofilho.getTextContent();
                                    break;
                            }
                        }
                    }
                }
            }
            //pegando as tags filhas do xml e importando no banco de dados, da tag ide
            NodeList listaDePessoas = doc.getElementsByTagName("ide");
            int tamanhoLista = listaDePessoas.getLength();
            for (int i = 0; i < tamanhoLista; i++) {
                Node noPessoa = listaDePessoas.item(i);
                if (noPessoa.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementoPessoa = (Element) noPessoa;
                    NodeList listaDeFilhosDaPessoa = elementoPessoa.getChildNodes();
                    int tamanhoListaFilhos = listaDeFilhosDaPessoa.getLength();
                    for (int j = 0; j < tamanhoListaFilhos; j++) {
                        Node noFilho = listaDeFilhosDaPessoa.item(j);
                        if (noFilho.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementoFilho = (Element) noFilho;
                            switch (elementoFilho.getTagName()) {
                                case "indPag":
                                    try {
                                        stmt = con.prepareStatement("INSERT INTO indpag (indPag,chNFe) VALUES(?,?)");
                                        stmt.setString(1, elementoFilho.getTextContent());
                                        stmt.setString(2, chnfe);
                                        stmt.execute();

                                    } catch (SQLException erro) {
                                        Alert alerta = new Alert(Alert.AlertType.ERROR);
                                        alerta.setTitle("Erro com indPag");
                                        alerta.setContentText("Erro ao inserir os dados de indPag no banco de dados!" + erro);
                                        alerta.showAndWait();
                                    }
                                    break;
                            }
                        }
                    }
                }
            }
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="NATOP">
    public void natOp() throws SAXException, ParserConfigurationException, IOException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        String chnfe = null;
        //Pegando os arquivos para a leitura
        for (Object caminho_ob : array_caminho) {
            //lendo os arquivos XML's
            File diretorio = new File((String) caminho_ob);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(diretorio);
            /*pegando o numero da nota fiscal e importando no banco de dados junto com os outros campos do xml 
            para identificação dos dados futuramente */
            NodeList se = doc.getElementsByTagName("infProt");
            int sea = se.getLength();
            for (int i = 0; i < sea; i++) {
                Node noide = se.item(i);
                if (noide.getNodeType() == Node.ELEMENT_NODE) {
                    Element listaide = (Element) noide;
                    NodeList listafilhoide = listaide.getChildNodes();
                    int tamanholistaide = listafilhoide.getLength();
                    for (int j = 0; j < tamanholistaide; j++) {
                        Node idei = listafilhoide.item(j);
                        if (idei.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementofilho = (Element) idei;
                            switch (elementofilho.getTagName()) {
                                case "chNFe":
                                    chnfe = elementofilho.getTextContent();
                                    break;
                            }
                        }
                    }
                }
            }
            //pegando as tags filhas do xml e importando no banco de dados, da tag ide
            NodeList listaDePessoas = doc.getElementsByTagName("ide");
            int tamanhoLista = listaDePessoas.getLength();
            for (int i = 0; i < tamanhoLista; i++) {
                Node noPessoa = listaDePessoas.item(i);
                if (noPessoa.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementoPessoa = (Element) noPessoa;
                    NodeList listaDeFilhosDaPessoa = elementoPessoa.getChildNodes();
                    int tamanhoListaFilhos = listaDeFilhosDaPessoa.getLength();
                    for (int j = 0; j < tamanhoListaFilhos; j++) {
                        Node noFilho = listaDeFilhosDaPessoa.item(j);
                        if (noFilho.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementoFilho = (Element) noFilho;
                            switch (elementoFilho.getTagName()) {
                                case "natOp":
                                    try {
                                        stmt = con.prepareStatement("INSERT INTO natop (natOp,chNFe) VALUES(?,?)");
                                        stmt.setString(1, elementoFilho.getTextContent());
                                        stmt.setString(2, chnfe);
                                        stmt.execute();

                                    } catch (SQLException erro) {
                                        Alert alerta = new Alert(Alert.AlertType.ERROR);
                                        alerta.setTitle("Erro com natOp");
                                        alerta.setContentText("Erro ao inserir os dados de natOp no banco de dados!" + erro);
                                        alerta.showAndWait();
                                    }
                                    break;
                            }
                        }
                    }
                }
            }
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="CNF">
    public void cNF() throws SAXException, ParserConfigurationException, IOException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        String chnfe = null;
        //Pegando os arquivos para a leitura
        for (Object caminho_ob : array_caminho) {
            //lendo os arquivos XML's
            File diretorio = new File((String) caminho_ob);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(diretorio);
            /*pegando o numero da nota fiscal e importando no banco de dados junto com os outros campos do xml 
            para identificação dos dados futuramente */
            NodeList se = doc.getElementsByTagName("infProt");
            int sea = se.getLength();
            for (int i = 0; i < sea; i++) {
                Node noide = se.item(i);
                if (noide.getNodeType() == Node.ELEMENT_NODE) {
                    Element listaide = (Element) noide;
                    NodeList listafilhoide = listaide.getChildNodes();
                    int tamanholistaide = listafilhoide.getLength();
                    for (int j = 0; j < tamanholistaide; j++) {
                        Node idei = listafilhoide.item(j);
                        if (idei.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementofilho = (Element) idei;
                            switch (elementofilho.getTagName()) {
                                case "chNFe":
                                    chnfe = elementofilho.getTextContent();
                                    break;
                            }
                        }
                    }
                }
            }
            //pegando as tags filhas do xml e importando no banco de dados, da tag ide
            NodeList listaDePessoas = doc.getElementsByTagName("ide");
            int tamanhoLista = listaDePessoas.getLength();
            for (int i = 0; i < tamanhoLista; i++) {
                Node noPessoa = listaDePessoas.item(i);
                if (noPessoa.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementoPessoa = (Element) noPessoa;
                    NodeList listaDeFilhosDaPessoa = elementoPessoa.getChildNodes();
                    int tamanhoListaFilhos = listaDeFilhosDaPessoa.getLength();
                    for (int j = 0; j < tamanhoListaFilhos; j++) {
                        Node noFilho = listaDeFilhosDaPessoa.item(j);
                        if (noFilho.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementoFilho = (Element) noFilho;
                            switch (elementoFilho.getTagName()) {
                                case "cNF":
                                    try {
                                        stmt = con.prepareStatement("INSERT INTO cnf(cNF,chNFe) VALUES(?,?)");
                                        stmt.setString(1, elementoFilho.getTextContent());
                                        stmt.setString(2, chnfe);
                                        stmt.execute();

                                    } catch (SQLException erro) {
                                        Alert alerta = new Alert(Alert.AlertType.ERROR);
                                        alerta.setTitle("Erro com cNF");
                                        alerta.setContentText("Erro ao inserir os dados de cNF no banco de dados!" + erro);
                                        alerta.showAndWait();
                                    }
                                    break;
                            }
                        }
                    }
                }
            }
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="CUF">
    public void cUF() throws SAXException, ParserConfigurationException, IOException, SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        String chnfe = null;
        //Pegando os arquivos para a leitura
        for (Object caminho_ob : array_caminho) {
            //lendo os arquivos XML's
            File diretorio = new File((String) caminho_ob);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(diretorio);
            /*pegando o numero da nota fiscal e importando no banco de dados junto com os outros campos do xml 
            para identificação dos dados futuramente */
            NodeList se = doc.getElementsByTagName("infProt");
            int sea = se.getLength();
            for (int i = 0; i < sea; i++) {
                Node noide = se.item(i);
                if (noide.getNodeType() == Node.ELEMENT_NODE) {
                    Element listaide = (Element) noide;
                    NodeList listafilhoide = listaide.getChildNodes();
                    int tamanholistaide = listafilhoide.getLength();
                    for (int j = 0; j < tamanholistaide; j++) {
                        Node idei = listafilhoide.item(j);
                        if (idei.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementofilho = (Element) idei;
                            switch (elementofilho.getTagName()) {
                                case "chNFe":
                                    chnfe = elementofilho.getTextContent();
                                    break;
                            }
                        }
                    }
                }
            }
            //pegando as tags filhas do xml e importando no banco de dados, da tag ide
            NodeList listaDePessoas = doc.getElementsByTagName("ide");
            int tamanhoLista = listaDePessoas.getLength();
            for (int i = 0; i < tamanhoLista; i++) {
                Node noPessoa = listaDePessoas.item(i);
                if (noPessoa.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementoPessoa = (Element) noPessoa;
                    NodeList listaDeFilhosDaPessoa = elementoPessoa.getChildNodes();
                    int tamanhoListaFilhos = listaDeFilhosDaPessoa.getLength();
                    for (int j = 0; j < tamanhoListaFilhos; j++) {
                        Node noFilho = listaDeFilhosDaPessoa.item(j);
                        if (noFilho.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementoFilho = (Element) noFilho;
                            switch (elementoFilho.getTagName()) {
                                case "cUF":
                                    try {
                                        stmt = con.prepareStatement("INSERT INTO cuf(cUF,chNFe) VALUES(?,?)");
                                        stmt.setString(1, elementoFilho.getTextContent());
                                        stmt.setString(2, chnfe);
                                        stmt.execute();

                                    } catch (SQLException erro) {
                                        Alert alerta = new Alert(Alert.AlertType.ERROR);
                                        alerta.setTitle("Erro com cUF");
                                        alerta.setContentText("Erro ao inserir os dados de cUF no banco de dados!" + erro);
                                        alerta.showAndWait();
                                    }
                                    break;
                            }
                        }
                    }
                }
            }
        }
    }

    //</editor-fold>
    //</editor-fold>
    public void truncarTabelas() throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        stmt = con.prepareStatement("TRUNCATE TABLE cdv");
        stmt.execute();
        stmt = con.prepareStatement("TRUNCATE TABLE cean");
        stmt.execute();
        stmt = con.prepareStatement("TRUNCATE TABLE cfop");
        stmt.execute();
        stmt = con.prepareStatement("TRUNCATE TABLE cfop_final");
        stmt.execute();
        stmt = con.prepareStatement("TRUNCATE TABLE cmun");
        stmt.execute();
        stmt = con.prepareStatement("TRUNCATE TABLE cmunfg");
        stmt.execute();
        stmt = con.prepareStatement("TRUNCATE TABLE cnf");
        stmt.execute();
        stmt = con.prepareStatement("TRUNCATE TABLE cnpj");
        stmt.execute();
        stmt = con.prepareStatement("TRUNCATE TABLE cprod");
        stmt.execute();
        stmt = con.prepareStatement("TRUNCATE TABLE csosn");
        stmt.execute();
        stmt = con.prepareStatement("TRUNCATE TABLE icms");
        stmt.execute();
        stmt = con.prepareStatement("TRUNCATE TABLE cuf");
        stmt.execute();
        stmt = con.prepareStatement("TRUNCATE TABLE dhemi");
        stmt.execute();
        stmt = con.prepareStatement("TRUNCATE TABLE dhsaient");
        stmt.execute();
        stmt = con.prepareStatement("TRUNCATE TABLE finnfe");
        stmt.execute();
        stmt = con.prepareStatement("TRUNCATE TABLE iddest");
        stmt.execute();
        stmt = con.prepareStatement("TRUNCATE TABLE ie");
        stmt.execute();
        stmt = con.prepareStatement("TRUNCATE TABLE indfinal");
        stmt.execute();
        stmt = con.prepareStatement("TRUNCATE TABLE indpag");
        stmt.execute();
        stmt = con.prepareStatement("TRUNCATE TABLE indpres");
        stmt.execute();
        stmt = con.prepareStatement("TRUNCATE TABLE mod_xml");
        stmt.execute();
        stmt = con.prepareStatement("TRUNCATE TABLE modfrete");
        stmt.execute();
        stmt = con.prepareStatement("TRUNCATE TABLE natop");
        stmt.execute();
        stmt = con.prepareStatement("TRUNCATE TABLE ncm");
        stmt.execute();
        stmt = con.prepareStatement("TRUNCATE TABLE nnf");
        stmt.execute();
        stmt = con.prepareStatement("TRUNCATE TABLE procemi");
        stmt.execute();
        stmt = con.prepareStatement("TRUNCATE TABLE saida_informacoes");
        stmt.execute();
        stmt = con.prepareStatement("TRUNCATE TABLE serie");
        stmt.execute();
        stmt = con.prepareStatement("TRUNCATE TABLE tpamb");
        stmt.execute();
        stmt = con.prepareStatement("TRUNCATE TABLE tpemis");
        stmt.execute();
        stmt = con.prepareStatement("TRUNCATE TABLE tpimp");
        stmt.execute();
        stmt = con.prepareStatement("TRUNCATE TABLE tpnf");
        stmt.execute();
        stmt = con.prepareStatement("TRUNCATE TABLE uf");
        stmt.execute();
        stmt = con.prepareStatement("TRUNCATE TABLE vdesc");
        stmt.execute();
        stmt = con.prepareStatement("TRUNCATE TABLE verproc");
        stmt.execute();
        stmt = con.prepareStatement("TRUNCATE TABLE voutro");
        stmt.execute();
        stmt = con.prepareStatement("TRUNCATE TABLE vprod");
        stmt.execute();
        stmt = con.prepareStatement("TRUNCATE TABLE xprod");
        stmt.execute();
        stmt = con.prepareStatement("TRUNCATE TABLE vprod_total");
        stmt.execute();
        stmt = con.prepareStatement("TRUNCATE TABLE vdesc_total");
        stmt.execute();
        stmt = con.prepareStatement("TRUNCATE TABLE vfrete_item");
        stmt.execute();
        stmt = con.prepareStatement("TRUNCATE TABLE vfrete_total");
        stmt.execute();
        stmt = con.prepareStatement("TRUNCATE TABLE vnf_total");
        stmt.execute();
        stmt = con.prepareStatement("TRUNCATE TABLE voutro_total");
        stmt.execute();
        stmt = con.prepareStatement("TRUNCATE TABLE vprod_total");
        stmt.execute();
        stmt = con.prepareStatement("TRUNCATE TABLE vseg_item");
        stmt.execute();
        stmt = con.prepareStatement("TRUNCATE TABLE vseg_total");
        stmt.execute();
    }

    public void arrayOpen() throws SAXException, IOException, ParserConfigurationException, ParserConfigurationException {
        Stage stage = programacontabil.primaryStage;
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Abrir arquivos");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML", "*.xml"));
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
        File caminhofolle = new File("C:\\");
        FileChooser chooser = new FileChooser();
        chooser.setInitialDirectory(caminhofolle);
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text file (*.txt)", "*.txt"));
        file = chooser.showSaveDialog(stage);

    }

    @FXML
    private void buttonSalvar(ActionEvent event) {
        CFOPDados c = tableCFOP.getSelectionModel().getSelectedItem();
        pegaValoresCFOP(c);
        serviceCFOP.salvar(c);
        atualizaTableCFOP();
    }

    @FXML
    private void buttonApagar(ActionEvent event) {
        CFOPDados c = tableCFOP.getSelectionModel().getSelectedItem();
        serviceCFOP.apagar(c.getId());
        atualizaTableCFOP();
    }

    @FXML
    private void buttonFecharCFOP(ActionEvent event) {
        groupCFOP.setVisible(false);
    }

    // <editor-fold defaultstate="collapsed" desc="CFOP">
    private void atualizaTableCFOP() {
        tableCFOP.getItems().setAll(serviceCFOP.buscarTodas());
        limpar();
    }

    private void limpar() {
        txtFiedlCFOPSaida.setText("");
        txtFieldCFOPEntrada.setText("");
        txtFieldID.setText("");
    }

    private void pegaValoresCFOP(CFOPDados c) {
        if (txtFieldCFOPEntrada.getText().length() != 4) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Erro com o campo CFOP Entrada");
            alerta.setContentText("Por favor insira o CFOP de entrada com 5 digitos");
            alerta.showAndWait();
            txtFieldCFOPEntrada.clear();
        } else {
            if (txtFieldCFOPEntrada.getText().substring(0, 1).equals("1") || txtFieldCFOPEntrada.getText().substring(0, 1).equals("2")) {
                c.setCfop_entrada(txtFieldCFOPEntrada.getText());
            } else {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Erro com o campo CFOP de Entrada");
                alerta.setContentText("Por favor insira o CFOP de entrada corretamente");
                alerta.showAndWait();

            }
        }
        if (txtFiedlCFOPSaida.getText().length() != 4) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Erro com o campo CFOP de Saida");
            alerta.setContentText("Por favor insira o CFOP de saida com 5 digitos");
            alerta.showAndWait();
            txtFiedlCFOPSaida.clear();

        } else {
            if (txtFiedlCFOPSaida.getText().substring(0, 1).equals("5") || txtFiedlCFOPSaida.getText().substring(0, 1).equals("6")) {
                c.setCfop_saida(txtFiedlCFOPSaida.getText());
            } else {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Erro com o campo CFOP de Saida");
                alerta.setContentText("Por favor insira o CFOP de saida corretamente");
                alerta.showAndWait();
            }

        }
        c.setId(Integer.parseInt(txtFieldID.getText()));
    }

    public void configuraColunasCFOP() {
        colCFOPEntrada.setCellValueFactory(new PropertyValueFactory<>("cfop_entrada"));
        colCFOPSaida.setCellValueFactory(new PropertyValueFactory<>("cfop_saida"));
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));

    }

    public void ConfiguraBindingsCFOP() {
        BooleanBinding camposPreenchidos = txtFieldID.textProperty().isEmpty().or(txtFieldCFOPEntrada.textProperty().isEmpty().or(txtFiedlCFOPSaida.textProperty().isEmpty()));
        BooleanBinding algoSelecionadoCFOP = tableCFOP.getSelectionModel().selectedItemProperty().isNull();
        btnApagar.disableProperty().bind(algoSelecionadoCFOP);
        btnSalvar.disableProperty().bind(algoSelecionadoCFOP);
        tableCFOP.getSelectionModel().selectedItemProperty().addListener((b, o, n) -> {
            if (n != null) {
                txtFieldCFOPEntrada.setText(n.getCfop_entrada());
                txtFiedlCFOPSaida.setText(n.getCfop_saida());
                txtFieldID.setText(String.valueOf(n.getId()));
            }
        });
    }
    //</editor-fold>

    @FXML
    private void buttonAbrirChoice(ActionEvent event) {
        if (choiceBoxBD.getValue().equals("Inserir CFOP")) {
            groupCFOP.setVisible(true);
        }
    }

}
