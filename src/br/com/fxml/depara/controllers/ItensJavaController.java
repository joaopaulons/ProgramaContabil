/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fxml.depara.controllers;

import static br.com.fxml.controllers.ExtratoDrogaEcoCapivariController.array_caminho;
import static br.com.fxml.controllers.ExtratoDrogaEcoCapivariController.file;
import static br.com.fxml.controllers.ImportacaoFolleCostaController.file;
import br.com.programacontabil;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
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
public class ItensJavaController implements Initializable {

    public static ArrayList array_caminho = new ArrayList<>();
    public static String salvarArquivo;
    public static PrintWriter gravarArq;
    public static File file;

    @FXML
    private TextArea txtAreaExemplo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

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
    private void buttonLerXML(ActionEvent event) throws SAXException, IOException, ParserConfigurationException {
        /*----------------------------------*/
//////////////////////////////       |
// <editor-fold defaultstate="collapsed" desc="VARIÁVEIS CFOP DE SAIDA">
        String var5101 = "5101";
        String var5102 = "5102";
        String var5104 = "5104";
        String var5106 = "5106";
        String var5109 = "5109";
        String var5122 = "5122";
        String var5124 = "5124";
        String var5125 = "5125";
        String var5152 = "5152";
        String var5201 = "5201";
        String var5202 = "5202";
        String var5401 = "5401";
        String var5402 = "5402";
        String var5403 = "5403";
        String var5405 = "5405";
        String var5409 = "5409";
        String var5410 = "5410";
        String var5411 = "5411";
        String var5556 = "5556";
        String var1411 = "1411";
        String var5901 = "5901";
        String var5902 = "5902";
        String var5910 = "5910";
        String var5911 = "5911";
        String var5915 = "5915";
        String var5916 = "5916";
        String var5920 = "5920";
        String var5921 = "5921";
        String var5924 = "5924";
        String var5925 = "5925";
        String var5929 = "5929";
        String var5949 = "5949";
        String var6101 = "6101";
        String var6102 = "6102";
        String var6104 = "6104";
        String var6106 = "6101";
        String var6152 = "6152";
        String var6201 = "6201";
        String var6202 = "6202";
        String var6401 = "6401";
        String var6402 = "6402";
        String var6403 = "6403";
        String var6404 = "6404";
        String var6409 = "6409";
        String var6410 = "6410";
        String var6411 = "6411";
        String var6413 = "6413";
        String var6556 = "6556";
        String var6901 = "6901";
        String var6902 = "6902";
        String var6910 = "6910";
        String var6911 = "6911";
        String var6915 = "6915";
        String var6916 = "6916";
        String var6920 = "6920";
        String var6921 = "6921";
        String var6924 = "6924";
        String var6925 = "6925";
        String var6929 = "6929";
        String var6949 = "6949";
        String var1410 = "1410";
        String var5105 = "5105";

//</editor-fold>     *       |
//////////////////////////////       |
/*----------------------------------*/
///////////////////////////////      |
// <editor-fold defaultstate="collapsed" desc="VARIÁVEL DE VERIFICAÇÃO">
        String cfopat1403 = null;
        String cfopat1925 = null;
        String cfopat1102 = null;
        String cfopat1949 = null;
        String cfopat2102 = null;
        String cfopat1152 = null;
        String cfopat1122 = null;
        String cfopat2403 = null;
        String cfopat2152 = null;
        String cfopat1125 = null;
        String cfopat1124 = null;
        String cfopat1410 = null;
        String cfopat1201 = null;
        String cfopat1411 = null;
        String cfopat1202 = null;
        String cfopat2202 = null;
        String cfopat2411 = null;
        String cfopat2410 = null;
        String cfopat2901 = null;
        String cfopat1924 = null;
        String cfopat2902 = null;
        String cfopat2924 = null;
        String cfopat2925 = null;
        String cfopat2921 = null;
        String cfopat2201 = null;
        String cfopat2920 = null;
        String cfopat1901 = null;
        String cfopat1902 = null;
        String cfopat1910 = null;
        String cfopat1911 = null;
        String cfopat2910 = null;
        String cfopat1915 = null;
        String cfopat1916 = null;
        String cfopat2915 = null;
        String cfopat1920 = null;
        String cfopat1921 = null;
        String cfopat2949 = null;
        String cfopat1409 = null;
        String cfopat2409 = null;

//</editor-fold>      *      |
///////////////////////////////      |
/*----------------------------------*/
/////////////////////////////////    |
// <editor-fold defaultstate="collapsed" desc="VARIÁVEIS SAÍDA DE INFORMAÇÕES">
        int saida5101 = 0;
        int saida5102 = 0;
        int saida5104 = 0;
        int saida5105 = 0;
        int saida5106 = 0;
        int saida5109 = 0;
        int saida5122 = 0;
        int saida5124 = 0;
        int saida5125 = 0;
        int saida5152 = 0;
        int saida5201 = 0;
        int saida5202 = 0;
        int saida5401 = 0;
        int saida5402 = 0;
        int saida5403 = 0;
        int saida5405 = 0;
        int saida5409 = 0;
        int saida5410 = 0;
        int saida5411 = 0;
        int saida5556 = 0;
        int saida5901 = 0;
        int saida5902 = 0;
        int saida5910 = 0;
        int saida5911 = 0;
        int saida5915 = 0;
        int saida5916 = 0;
        int saida5920 = 0;
        int saida5921 = 0;
        int saida5924 = 0;
        int saida5925 = 0;
        int saida5929 = 0;
        int saida5949 = 0;
        int saida6101 = 0;
        int saida6102 = 0;
        int saida6104 = 0;
        int saida6106 = 0;
        int saida6152 = 0;
        int saida6201 = 0;
        int saida6202 = 0;
        int saida6401 = 0;
        int saida6402 = 0;
        int saida6403 = 0;
        int saida6404 = 0;
        int saida6409 = 0;
        int saida6410 = 0;
        int saida6411 = 0;
        int saida6413 = 0;
        int saida6556 = 0;
        int saida6901 = 0;
        int saida6902 = 0;
        int saida6910 = 0;
        int saida6911 = 0;
        int saida6915 = 0;
        int saida6916 = 0;
        int saida6920 = 0;
        int saida6921 = 0;
        int saida6924 = 0;
        int saida6925 = 0;
        int saida6929 = 0;
        int saida6949 = 0;
//-------------------------------//        
        int saida1411 = 0;
        int saida1410 = 0;
//</editor-fold> *    |
/////////////////////////////////    |
/*----------------------------------*/
///////////////////////////////      |
// <editor-fold defaultstate="collapsed" desc="VARIÁVEIS VERIFICAÇÃO VOUTRO">

        float voutroverif5101 = 0;
        float voutroverif5102 = 0;
        float voutroverif5104 = 0;
        float voutroverif5105 = 0;
        float voutroverif5106 = 0;
        float voutroverif5109 = 0;
        float voutroverif5122 = 0;
        float voutroverif5124 = 0;
        float voutroverif5125 = 0;
        float voutroverif5152 = 0;
        float voutroverif5201 = 0;
        float voutroverif5202 = 0;
        float voutroverif5401 = 0;
        float voutroverif5402 = 0;
        float voutroverif5403 = 0;
        float voutroverif5405 = 0;
        float voutroverif5409 = 0;
        float voutroverif5410 = 0;
        float voutroverif5411 = 0;
        float voutroverif5556 = 0;
        float voutroverif5901 = 0;
        float voutroverif5902 = 0;
        float voutroverif5910 = 0;
        float voutroverif5911 = 0;
        float voutroverif5915 = 0;
        float voutroverif5916 = 0;
        float voutroverif5920 = 0;
        float voutroverif5921 = 0;
        float voutroverif5924 = 0;
        float voutroverif5925 = 0;
        float voutroverif5929 = 0;
        float voutroverif5949 = 0;
        float voutroverif6101 = 0;
        float voutroverif6102 = 0;
        float voutroverif6104 = 0;
        float voutroverif6106 = 0;
        float voutroverif6152 = 0;
        float voutroverif6201 = 0;
        float voutroverif6202 = 0;
        float voutroverif6401 = 0;
        float voutroverif6402 = 0;
        float voutroverif6403 = 0;
        float voutroverif6404 = 0;
        float voutroverif6409 = 0;
        float voutroverif6410 = 0;
        float voutroverif6411 = 0;
        float voutroverif6413 = 0;
        float voutroverif6556 = 0;
        float voutroverif6901 = 0;
        float voutroverif6902 = 0;
        float voutroverif6910 = 0;
        float voutroverif6911 = 0;
        float voutroverif6915 = 0;
        float voutroverif6916 = 0;
        float voutroverif6920 = 0;
        float voutroverif6921 = 0;
        float voutroverif6924 = 0;
        float voutroverif6925 = 0;
        float voutroverif6929 = 0;
        float voutroverif6949 = 0;
//-----------------------------------//
        float voutroverif1411 = 0;
        float voutroverif1410 = 0;
//</editor-fold> *      |
///////////////////////////////      |
/*----------------------------------*/
///////////////////////////////      |
// <editor-fold defaultstate="collapsed" desc="VARIÁVEIS VERIFICAÇÃO UNTRIB">
        float vprod5921 = 0;
        float vprod5101 = 0;
        float vprod5102 = 0;
        float vprod5104 = 0;
        float vprod5105 = 0;
        float vprod5106 = 0;
        float vprod5109 = 0;
        float vprod5122 = 0;
        float vprod5124 = 0;
        float vprod5125 = 0;
        float vprod5152 = 0;
        float vprod5201 = 0;
        float vprod5202 = 0;
        float vprod5401 = 0;
        float vprod5402 = 0;
        float vprod5403 = 0;
        float vprod5405 = 0;
        float vprod5409 = 0;
        float vprod5410 = 0;
        float vprod5411 = 0;
        float vprod5556 = 0;
        float vprod5901 = 0;
        float vprod5902 = 0;
        float vprod5910 = 0;
        float vprod5911 = 0;
        float vprod5915 = 0;
        float vprod5916 = 0;
        float vprod5920 = 0;
        float vprod5924 = 0;
        float vprod5925 = 0;
        float vprod5929 = 0;
        float vprod5949 = 0;
        float vprod6101 = 0;
        float vprod6102 = 0;
        float vprod6104 = 0;
        float vprod6106 = 0;
        float vprod6152 = 0;
        float vprod6201 = 0;
        float vprod6202 = 0;
        float vprod6401 = 0;
        float vprod6402 = 0;
        float vprod6403 = 0;
        float vprod6404 = 0;
        float vprod6409 = 0;
        float vprod6410 = 0;
        float vprod6411 = 0;
        float vprod6413 = 0;
        float vprod6556 = 0;
        float vprod6901 = 0;
        float vprod6902 = 0;
        float vprod6910 = 0;
        float vprod6911 = 0;
        float vprod6915 = 0;
        float vprod6916 = 0;
        float vprod6920 = 0;
        float vprod6921 = 0;
        float vprod6924 = 0;
        float vprod6925 = 0;
        float vprod6929 = 0;
        float vprod6949 = 0;
//--------------------------------//
        float vprod1411 = 0;
        float vprod1410 = 0;

//</editor-fold> *      |
///////////////////////////////      |
/*----------------------------------*/
///////////////////////////////      |
// <editor-fold defaultstate="collapsed" desc="VARIÁVEIS CST's">
        String cst60 = "60";
        String cst00 = "00";
        String cst10 = "10";
        String cst20 = "20";
        String cst30 = "30";
        String cst40 = "40";
        String cst41 = "41";
        String cst50 = "50";
        String cst51 = "51";
        String cst70 = "70";
        String cst90 = "90";
        String icmssn101 = "101";
        String icmssn102 = "102";
        String icmssn103 = "103";
        String icmssn3 = "3";
        String icmssn201 = "201";
        String icmssn202 = "202";
        String icmssn203 = "203";
        String icmssn500 = "500";
        String icmssn900 = "900";
        String icmssn300 = "300";
        String icmssn400 = "400";

//</editor-fold>              *      |
///////////////////////////////      |
/*----------------------------------*/
///////////////////////////////      |
// <editor-fold defaultstate="collapsed" desc="VARIÁVEIS CST's CONDICIONAIS">
        float outras5405 = 0;
        float outras5102 = 0;
        float outras5921 = 0;
        float outras5101 = 0;
        float outras5104 = 0;
        float outras5105 = 0;
        float outras5106 = 0;
        float outras5109 = 0;
        float outras5122 = 0;
        float outras5124 = 0;
        float outras5125 = 0;
        float outras5152 = 0;
        float outras5201 = 0;
        float outras5202 = 0;
        float outras5401 = 0;
        float outras5402 = 0;
        float outras5403 = 0;
        float outras5409 = 0;
        float outras5410 = 0;
        float outras5411 = 0;
        float outras5556 = 0;
        float outras5901 = 0;
        float outras5902 = 0;
        float outras5910 = 0;
        float outras5911 = 0;
        float outras5915 = 0;
        float outras5916 = 0;
        float outras5920 = 0;
        float outras5924 = 0;
        float outras5925 = 0;
        float outras5929 = 0;
        float outras5949 = 0;
        float outras6101 = 0;
        float outras6102 = 0;
        float outras6104 = 0;
        float outras6106 = 0;
        float outras6152 = 0;
        float outras6201 = 0;
        float outras6202 = 0;
        float outras6401 = 0;
        float outras6402 = 0;
        float outras6403 = 0;
        float outras6404 = 0;
        float outras6409 = 0;
        float outras6410 = 0;
        float outras6411 = 0;
        float outras6413 = 0;
        float outras6556 = 0;
        float outras6901 = 0;
        float outras6902 = 0;
        float outras6910 = 0;
        float outras6911 = 0;
        float outras6915 = 0;
        float outras6916 = 0;
        float outras6920 = 0;
        float outras6921 = 0;
        float outras6924 = 0;
        float outras6925 = 0;
        float outras6929 = 0;
        float outras6949 = 0;
//-------------------------------//
        float outras1411 = 0;
        float outras1410 = 0;
//</editor-fold> *      |
///////////////////////////////      |
/*----------------------------------*/
///////////////////////////////      |
// <editor-fold defaultstate="collapsed" desc="VARIÁVEIS FLOAT ALEATÓRIOS">
        float ipi_nao_creditado = 0;
        float valor_isentas_naotributadas5102 = 0;
        float valor_isentas_naotributadas5101 = 0;
        float base_calculo_icms = 0;
        float icms_creditado = 0;
        float isentas_naotributadas = 0;
        float aliquota_icms = 0;
        float base_calculo_ipi = 0;
        float ipi_creditado = 0;
        float ipi_creditado_50 = 0;
        float isentas_naotributadas_zerado = 0;
        float outras_zerado = 0;
        float sit_especial_valor1 = 0;
        float sit_especial_valor2 = 0;
        float sit_especial_valor3 = 0;
        float sit_especial_valor4 = 0;
        float base_calc_subst_tribut = 0;
        float float_num_doc = 0;
        float imposto_retido_subst_tribut = 0;
        float valor_frete = 0;
        float valor_seguro = 0;
        float valor_total_outras5102 = 0;
        float valor_total_outras5101 = 0;

//</editor-fold>   *      |
///////////////////////////////      |
/*----------------------------------*/
 /*----------------------------------*/
///////////////////////////////      |
// <editor-fold defaultstate="collapsed" desc="VARIÁVEIS TOTAL OUTRAS">
        float total_outras5405 = 0;
        float total_outras5102 = 0;
        float total_outras5921 = 0;
        float total_outras5101 = 0;
        float total_outras5104 = 0;
        float total_outras5105 = 0;
        float total_outras5106 = 0;
        float total_outras5109 = 0;
        float total_outras5122 = 0;
        float total_outras5124 = 0;
        float total_outras5125 = 0;
        float total_outras5152 = 0;
        float total_outras5201 = 0;
        float total_outras5202 = 0;
        float total_outras5401 = 0;
        float total_outras5402 = 0;
        float total_outras5403 = 0;
        float total_outras5409 = 0;
        float total_outras5410 = 0;
        float total_outras5411 = 0;
        float total_outras5556 = 0;
        float total_outras5901 = 0;
        float total_outras5902 = 0;
        float total_outras5910 = 0;
        float total_outras5911 = 0;
        float total_outras5915 = 0;
        float total_outras5916 = 0;
        float total_outras5920 = 0;
        float total_outras5924 = 0;
        float total_outras5925 = 0;
        float total_outras5929 = 0;
        float total_outras5949 = 0;
        float total_outras6101 = 0;
        float total_outras6102 = 0;
        float total_outras6104 = 0;
        float total_outras6106 = 0;
        float total_outras6152 = 0;
        float total_outras6201 = 0;
        float total_outras6202 = 0;
        float total_outras6401 = 0;
        float total_outras6402 = 0;
        float total_outras6403 = 0;
        float total_outras6404 = 0;
        float total_outras6409 = 0;
        float total_outras6410 = 0;
        float total_outras6411 = 0;
        float total_outras6413 = 0;
        float total_outras6556 = 0;
        float total_outras6901 = 0;
        float total_outras6902 = 0;
        float total_outras6910 = 0;
        float total_outras6911 = 0;
        float total_outras6915 = 0;
        float total_outras6916 = 0;
        float total_outras6920 = 0;
        float total_outras6921 = 0;
        float total_outras6924 = 0;
        float total_outras6925 = 0;
        float total_outras6929 = 0;
        float total_outras6949 = 0;
//---------------------------------------//
        float total_outras1411 = 0;
        float total_outras1410 = 0;

//</editor-fold>   *      |
///////////////////////////////      |
/*----------------------------------*/
 /*---------------------------------*/
//////////                           |
// <editor-fold defaultstate="collapsed" desc="FLAGS">
        int flag5405 = 0;
        int flag5102 = 0;
        int flag5921 = 0;
        int flag5101 = 0;
        int flag5104 = 0;
        int flag5105 = 0;
        int flag5106 = 0;
        int flag5109 = 0;
        int flag5122 = 0;
        int flag5124 = 0;
        int flag5125 = 0;
        int flag5152 = 0;
        int flag5201 = 0;
        int flag5202 = 0;
        int flag5401 = 0;
        int flag5402 = 0;
        int flag5403 = 0;
        int flag5409 = 0;
        int flag5410 = 0;
        int flag5411 = 0;
        int flag5556 = 0;
        int flag5901 = 0;
        int flag5902 = 0;
        int flag5910 = 0;
        int flag5911 = 0;
        int flag5915 = 0;
        int flag5916 = 0;
        int flag5920 = 0;
        int flag5924 = 0;
        int flag5925 = 0;
        int flag5929 = 0;
        int flag5949 = 0;
        int flag6101 = 0;
        int flag6102 = 0;
        int flag6104 = 0;
        int flag6106 = 0;
        int flag6152 = 0;
        int flag6201 = 0;
        int flag6202 = 0;
        int flag6401 = 0;
        int flag6402 = 0;
        int flag6403 = 0;
        int flag6404 = 0;
        int flag6409 = 0;
        int flag6410 = 0;
        int flag6411 = 0;
        int flag6413 = 0;
        int flag6556 = 0;
        int flag6901 = 0;
        int flag6902 = 0;
        int flag6910 = 0;
        int flag6911 = 0;
        int flag6915 = 0;
        int flag6916 = 0;
        int flag6920 = 0;
        int flag6921 = 0;
        int flag6924 = 0;
        int flag6925 = 0;
        int flag6929 = 0;
        int flag6949 = 0;
//------------------------------//
        int flag1411 = 0;
        int flag1410 = 0;
//</editor-fold>   *                           |
/////////                            |
/*----------------------------------*/
 /*---------------------------------*/
///////////////////////////////      |
// <editor-fold defaultstate="collapsed" desc="VARIÁVEIS DE DESCONTO">

        float vdesc5405 = 0;
        float vdesc5102 = 0;
        float vdesc5921 = 0;
        float vdesc5101 = 0;
        float vdesc5104 = 0;
        float vdesc5105 = 0;
        float vdesc5106 = 0;
        float vdesc5109 = 0;
        float vdesc5122 = 0;
        float vdesc5124 = 0;
        float vdesc5125 = 0;
        float vdesc5152 = 0;
        float vdesc5201 = 0;
        float vdesc5202 = 0;
        float vdesc5401 = 0;
        float vdesc5402 = 0;
        float vdesc5403 = 0;
        float vdesc5409 = 0;
        float vdesc5410 = 0;
        float vdesc5411 = 0;
        float vdesc5556 = 0;
        float vdesc5901 = 0;
        float vdesc5902 = 0;
        float vdesc5910 = 0;
        float vdesc5911 = 0;
        float vdesc5915 = 0;
        float vdesc5916 = 0;
        float vdesc5920 = 0;
        float vdesc5924 = 0;
        float vdesc5925 = 0;
        float vdesc5929 = 0;
        float vdesc5949 = 0;
        float vdesc6101 = 0;
        float vdesc6102 = 0;
        float vdesc6104 = 0;
        float vdesc6106 = 0;
        float vdesc6152 = 0;
        float vdesc6201 = 0;
        float vdesc6202 = 0;
        float vdesc6401 = 0;
        float vdesc6402 = 0;
        float vdesc6403 = 0;
        float vdesc6404 = 0;
        float vdesc6409 = 0;
        float vdesc6410 = 0;
        float vdesc6411 = 0;
        float vdesc6413 = 0;
        float vdesc6556 = 0;
        float vdesc6901 = 0;
        float vdesc6902 = 0;
        float vdesc6910 = 0;
        float vdesc6911 = 0;
        float vdesc6915 = 0;
        float vdesc6916 = 0;
        float vdesc6920 = 0;
        float vdesc6921 = 0;
        float vdesc6924 = 0;
        float vdesc6925 = 0;
        float vdesc6929 = 0;
        float vdesc6949 = 0;
//------------------------------//
        float vdesc1411 = 0;
        float vdesc1410 = 0;

//</editor-fold>        *      |
///////////////////////////////      |
/*----------------------------------*/
 /*----------------------------------*/
///////////////////////////////      |
// <editor-fold defaultstate="collapsed" desc="VARIÁVEIS VALOR_TOTAL_NOTA">
        float valor_total_nota5405 = 0;
        float valor_total_nota5102 = 0;
        float valor_total_nota5921 = 0;
        float valor_total_nota5101 = 0;
        float valor_total_nota5104 = 0;
        float valor_total_nota5105 = 0;
        float valor_total_nota5106 = 0;
        float valor_total_nota5109 = 0;
        float valor_total_nota5122 = 0;
        float valor_total_nota5124 = 0;
        float valor_total_nota5125 = 0;
        float valor_total_nota5152 = 0;
        float valor_total_nota5201 = 0;
        float valor_total_nota5202 = 0;
        float valor_total_nota5401 = 0;
        float valor_total_nota5402 = 0;
        float valor_total_nota5403 = 0;
        float valor_total_nota5409 = 0;
        float valor_total_nota5410 = 0;
        float valor_total_nota5411 = 0;
        float valor_total_nota5556 = 0;
        float valor_total_nota5901 = 0;
        float valor_total_nota5902 = 0;
        float valor_total_nota5910 = 0;
        float valor_total_nota5911 = 0;
        float valor_total_nota5915 = 0;
        float valor_total_nota5916 = 0;
        float valor_total_nota5920 = 0;
        float valor_total_nota5924 = 0;
        float valor_total_nota5925 = 0;
        float valor_total_nota5929 = 0;
        float valor_total_nota5949 = 0;
        float valor_total_nota6101 = 0;
        float valor_total_nota6102 = 0;
        float valor_total_nota6104 = 0;
        float valor_total_nota6106 = 0;
        float valor_total_nota6152 = 0;
        float valor_total_nota6201 = 0;
        float valor_total_nota6202 = 0;
        float valor_total_nota6401 = 0;
        float valor_total_nota6402 = 0;
        float valor_total_nota6403 = 0;
        float valor_total_nota6404 = 0;
        float valor_total_nota6409 = 0;
        float valor_total_nota6410 = 0;
        float valor_total_nota6411 = 0;
        float valor_total_nota6413 = 0;
        float valor_total_nota6556 = 0;
        float valor_total_nota6901 = 0;
        float valor_total_nota6902 = 0;
        float valor_total_nota6910 = 0;
        float valor_total_nota6911 = 0;
        float valor_total_nota6915 = 0;
        float valor_total_nota6916 = 0;
        float valor_total_nota6920 = 0;
        float valor_total_nota6921 = 0;
        float valor_total_nota6924 = 0;
        float valor_total_nota6925 = 0;
        float valor_total_nota6929 = 0;
        float valor_total_nota6949 = 0;
//----------------------------------------//

        float valor_total_nota1411 = 0;
        float valor_total_nota1410 = 0;

//</editor-fold>   *      |
///////////////////////////////      |
/*----------------------------------*/
// <editor-fold defaultstate="collapsed" desc="VARIÁVEIS GLOBAIS">
        String caminho = null;
        String salvarArquivo = null;
        String cnp = null;
        String sai = null;
        String emi = null;
        String cfop = null;
        String nfe = null;
        String cfopat = null;
        String hora_emi = null;
        String vprod = null;
        String voutro = null;
        String cst = null;
        String vdesc = null;
        String cprod = null;
        String insc_estadual = null;
        String modFrete = null;
        String un_federal = null;
        String cod_municipal = null;
        String serie = null;
        String num_doc = null;
        DecimalFormat format_num_doc = new DecimalFormat("0000000000");
        DecimalFormat sit_especial = new DecimalFormat("000000000.00");
        DecimalFormat format_serie = new DecimalFormat("000");
        DecimalFormat format_insc_estadual = new DecimalFormat("000000000000");
        DecimalFormat aliquo_icms = new DecimalFormat("00.00");
        DecimalFormat df = new DecimalFormat("00000000000.00");
        DecimalFormat format_vdesc = new DecimalFormat("00000000000.00");
        String comparar_nfe = null;
        String espaco = "      ";
        float parsefloat = 0;
        float soma_vdesc = 0;
        float float_insc_estadual = 0;
        int int_insc_estadual = 0;
        String[] palavras = null;
        int desdo = 0;
        int quant = -1;
        int a, e, k;
        String valor_csosn = null;
        Connection con;
        PreparedStatement st;
        ResultSet rs;
        String sql;

//</editor-fold>
// <editor-fold defaultstate="collapsed" desc="Variáveis">
        String cEAN = null;
        String xProd = null;
        String NCM = null;
        String uCom = null;
        String qCom = null;
        String vUnCom = null;
        String vProd = null;
        String cEANTrib = null;
        String uTrib = null;
        String qTrib = null;
        String vUnTrib = null;
        String indTot = null;
        String vTotTrib = null;
        String orig = null;
        String CSOSN = null;
        String pCredSN = null;
        String vCredICMSSN = null;
        String cEnq = null;
        String CST = null;
        String vBC = null;
        String vDespAdu = null;
        String vII = null;
        String vIOF = null;
        // <editor-fold defaultstate="collapsed" desc="Variáveis EMIT">
        String CNPJ_emit = null;
        String xNome_emit = null;
        String xFant_emit = null;
        String xLgr_emit = null;
        String nro_emit = null;
        String xBairro_emit = null;
        String cMun_emit = null;
        String xMun_emit = null;
        String UF_emit = null;
        String CEP_emit = null;
        String cPais_emit = null;
        String xPais_emit = null;
        String fone_emit = null;
        String IE_emit = null;
        String IM_emit = null;
        String CNAE_emit = null;
        String CRT_emit = null;
        //</editor-fold>
        // <editor-fold defaultstate="collapsed" desc="Variáveis DEST">
        String CNPJ_dest = null;
        String xNome_dest = null;
        String xFant_dest = null;
        String xLgr_dest = null;
        String nro_dest = null;
        String xBairro_dest = null;
        String cMun_dest = null;
        String xMun_dest = null;
        String UF_dest = null;
        String CEP_dest = null;
        String cPais_dest = null;
        String xPais_dest = null;
        String fone_dest = null;
        String IE_dest = null;
        String IM_dest = null;
        String CNAE_dest = null;
        String CRT_dest = null;
        //</editor-fold>
        String cUF = null;
        String cNF = null;
        String natOp = null;
        String indPag = null;
        String mod = null;
        String nNF = null;
        String dhEmi = null;
        String dhSaiEnt = null;
        String tpNF = null;
        String idDest = null;
        String cMunFG = null;
        String tpImp = null;
        String tpEmis = null;
        String cDV = null;
        String tpAmb = null;
        String finNFe = null;
        String indFinal = null;
        String indPres = null;
        String procEmi = null;
        String verProc = null;
        String vICMS = null;
        String vICMSDeson = null;
        String vBCST = null;
        String vST = null;
        String vFrete = null;
        String vSeg = null;
        String vDesc = null;
        String vIPI = null;
        String vPIS = null;
        String vCOFINS = null;
        String vOutro = null;
        String vNF = null;
        String vRetCSLL = null;
        String nFat = null;
        String vOrig = null;
        String vLiq = null;
        String nDup = null;
        String dVenc = null;
        String vDup = null;
        String infCpl = null;
        String chNFe = null;
        String retorno_ncm = null;
        String retorno_produto = null;
        String comparar_produto = null;
        String retorno_novo_produto = null;
        String get_cnpj = null;
        String novo_produto = null;
        String vBC_total = null;
        String vICMS_total = null;
        String vICMSDeson_total = null;
        String vBCST_total = null;
        String vST_total = null;
        String vProd_total = null;
        String vFrete_total = null;
        String vSeg_total = null;
        String vDesc_total = null;
        String vII_total = null;
        String vIPI_total = null;
        String vPIS_total = null;
        String vCOFINS_total = null;
        String vOutro_total = null;
        String vNF_total = null;
        String vTotTrib_total = null;
        String placa = null;
        String qVol = null;
        String nVol = null;
        String pesoL = null;
        String pesoB = null;

        //</editor-fold>
        arrayOpen();
        for (Object caminho_ob : array_caminho) {

            File diretorio = new File((String) caminho_ob);

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(diretorio);

// <editor-fold defaultstate="collapsed" desc="CÓDIGO NFE">
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
                                    nfe = elementofilho.getTextContent();
                                    comparar_nfe = nfe.toString();
                                    break;
                            }

                        }
                    }
                }
            }
//</editor-fold>

// <editor-fold defaultstate="collapsed" desc="CNPJ">
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
                                    cnp = elementofilhos.getTextContent();

                                    break;
                            }
                        }
                    }
                }
            }
//</editor-fold>

// <editor-fold defaultstate="collapsed" desc="DATA ENTRADA">
            NodeList idee = doc.getElementsByTagName("ide");

            int tamanhoide = idee.getLength();

            for (int i = 0; i < tamanhoide; i++) {

                Node noide = idee.item(i);

                if (noide.getNodeType() == Node.ELEMENT_NODE) {

                    Element listaide = (Element) noide;

                    NodeList listafilhoide = listaide.getChildNodes();

                    int tamanholistaide = listafilhoide.getLength();

                    for (int j = 0; j < tamanholistaide; j++) {

                        Node idei = listafilhoide.item(j);

                        if (idei.getNodeType() == Node.ELEMENT_NODE) {

                            Element elementofilho = (Element) idei;

                            switch (elementofilho.getTagName()) {

                                case "dhSaiEnt":

                                    String mb = elementofilho.getTextContent();
                                    String ano = mb.substring(2, 4);
                                    String mes = mb.substring(5, 7);
                                    String dia = mb.substring(8, 10);
                                    sai = dia + mes + ano;

                            }

                        }
                    }
                }
            }
//</editor-fold>

// <editor-fold defaultstate="collapsed" desc="DATA EMISSÃO">
            NodeList saient = doc.getElementsByTagName("ide");

            int saiente = saient.getLength();

            for (int i = 0; i < saiente; i++) {

                Node noide = saient.item(i);

                if (noide.getNodeType() == Node.ELEMENT_NODE) {

                    Element listaide = (Element) noide;

                    NodeList listafilhoide = listaide.getChildNodes();

                    int tamanholistaide = listafilhoide.getLength();

                    for (int j = 0; j < tamanholistaide; j++) {

                        Node idei = listafilhoide.item(j);

                        if (idei.getNodeType() == Node.ELEMENT_NODE) {

                            Element elementofilho = (Element) idei;

                            switch (elementofilho.getTagName()) {

                                case "dhEmi":

                                    String mb = elementofilho.getTextContent();

                                    String ano = mb.substring(2, 4);
                                    String mes = mb.substring(5, 7);
                                    String dia = mb.substring(8, 10);
                                    String hora = mb.substring(11, 19);
                                    emi = dia + mes + ano;
                                    hora_emi = hora;

                            }

                        }
                    }
                }
            }
//</editor-fold>

// <editor-fold defaultstate="collapsed" desc="INSCRIÇÃO ESTADUAL DO EMITENTE">
            NodeList emit = doc.getElementsByTagName("emit");

            int emitt = emit.getLength();

            for (int i = 0; i < emitt; i++) {

                Node noide = emit.item(i);

                if (noide.getNodeType() == Node.ELEMENT_NODE) {

                    Element listaide = (Element) noide;

                    NodeList listafilhoide = listaide.getChildNodes();

                    int tamanholistaide = listafilhoide.getLength();

                    for (int j = 0; j < tamanholistaide; j++) {

                        Node idei = listafilhoide.item(j);

                        if (idei.getNodeType() == Node.ELEMENT_NODE) {

                            Element elementofilho = (Element) idei;
                            switch (elementofilho.getTagName()) {

                                case "IE":
                                    insc_estadual = elementofilho.getTextContent();
                                    float_insc_estadual = Float.parseFloat(insc_estadual);
                                    int_insc_estadual = insc_estadual.length();

                                    // <editor-fold defaultstate="collapsed" desc="CONDIÇÕES ESPAÇO">
                                    if (int_insc_estadual == 18) {
                                        espaco = "";
                                    } else {
                                        if (int_insc_estadual == 17) {
                                            espaco = " ";
                                        } else {
                                            if (int_insc_estadual == 16) {
                                                espaco = "  ";
                                            } else {
                                                if (int_insc_estadual == 15) {
                                                    espaco = "   ";
                                                } else {
                                                    if (int_insc_estadual == 14) {
                                                        espaco = "    ";
                                                    } else {
                                                        if (int_insc_estadual == 13) {
                                                            espaco = "     ";
                                                        } else {
                                                            if (int_insc_estadual == 12) {
                                                                espaco = "      ";
                                                            } else {
                                                                if (int_insc_estadual == 11) {
                                                                    espaco = "       ";
                                                                } else {
                                                                    if (int_insc_estadual == 10) {
                                                                        espaco = "        ";
                                                                    } else {
                                                                        if (int_insc_estadual == 9) {
                                                                            espaco = "         ";
                                                                        } else {
                                                                            if (int_insc_estadual == 8) {
                                                                                espaco = "          ";
                                                                            } else {
                                                                                if (int_insc_estadual == 7) {
                                                                                    espaco = "           ";
                                                                                } else {
                                                                                    if (int_insc_estadual == 6) {
                                                                                        espaco = "            ";
                                                                                    } else {
                                                                                        if (int_insc_estadual == 5) {
                                                                                            espaco = "             ";
                                                                                        } else {
                                                                                            if (int_insc_estadual == 4) {
                                                                                                espaco = "              ";
                                                                                            } else {
                                                                                                if (int_insc_estadual == 3) {
                                                                                                    espaco = "               ";
                                                                                                } else {
                                                                                                    if (int_insc_estadual == 2) {
                                                                                                        espaco = "                ";
                                                                                                    } else {
                                                                                                        if (int_insc_estadual == 1) {
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
                                    un_federal = elementofilho.getTextContent();
                                    break;
                                case "cMun":
                                    cod_municipal = elementofilho.getTextContent();
                                    break;

                            }
                        }
                    }
                }

            }
//</editor-fold>

// <editor-fold defaultstate="collapsed" desc="SÉRIE">
            NodeList ide = doc.getElementsByTagName("ide");

            int ideea = ide.getLength();

            for (int i = 0; i < ideea; i++) {

                Node noide = ide.item(i);

                if (noide.getNodeType() == Node.ELEMENT_NODE) {

                    Element listaide = (Element) noide;

                    NodeList listafilhoide = listaide.getChildNodes();

                    int tamanholistaide = listafilhoide.getLength();

                    for (int j = 0; j < tamanholistaide; j++) {

                        Node idei = listafilhoide.item(j);

                        if (idei.getNodeType() == Node.ELEMENT_NODE) {

                            Element elementofilho = (Element) idei;
                            switch (elementofilho.getTagName()) {
                                case "serie":
                                    serie = elementofilho.getTextContent();

                                    break;
                                case "nNF":
                                    num_doc = elementofilho.getTextContent();
                                    float_num_doc = Float.parseFloat(num_doc);

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
                            modFrete = elementodadoss.getTextContent();

                            break;

                    }
                }
            }

            NodeList voutroa = doc.getElementsByTagName("vOutro");

            int voutroaa = voutroa.getLength();

            for (int o = 0; o < voutroaa; o++) {

                Node noFilhoss = voutroa.item(o);

                if (noFilhoss.getNodeType() == Node.ELEMENT_NODE) {

                    Element elementodadoss = (Element) noFilhoss;
                    switch (elementodadoss.getTagName()) {

                        case "vOutro":
                            voutro = elementodadoss.getTextContent();

                            break;

                    }
                }
            }
//</editor-fold>

// <editor-fold defaultstate="collapsed" desc="DET">
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
                                            cprod = elementodados.getTextContent();
                                            break;
//</editor-fold>

                                        // <editor-fold defaultstate="collapsed" desc="cEAN">
                                        case "cEAN":
                                            cEAN = elementodados.getTextContent();

                                            break;
//</editor-fold>

                                        // <editor-fold defaultstate="collapsed" desc="xProd">
                                        case "xProd":
                                            xProd = elementodados.getTextContent();

                                            break;
                                        //</editor-fold>

                                        // <editor-fold defaultstate="collapsed" desc="NCM">
                                        case "NCM":
                                            NCM = elementodados.getTextContent();

                                            break;
                                        //</editor-fold>

                                        // <editor-fold defaultstate="collapsed" desc="CEST">
                                        case "CEST":

                                            // txtAreaExemplo.appendText("\t" + "CEST = " + "\t" + elementodados.getTextContent());
                                            break;
//</editor-fold>

                                        // <editor-fold defaultstate="collapsed" desc="CFOP">
                                        case "CFOP":
                                            cfop = elementodados.getTextContent();

                                            palavras = cfop.split(" ");

                                            for (a = 0; a < palavras.length; a++) {

                                                // <editor-fold defaultstate="collapsed" desc="CONDIÇÕES CFOP DE SAIDA">
                                                // <editor-fold defaultstate="collapsed" desc="CFOP 5405">
                                                if (flag5405 == 1) {

                                                } else {

                                                    if (palavras[a].equals(var5405)) {
                                                        quant++;
                                                        flag5405 = 1;
                                                        cfopat1403 = "1403";
                                                        saida5405 = quant;

                                                    }
                                                }

                                                //</editor-fold>
                                                // <editor-fold defaultstate="collapsed" desc="CFOP 5102">
                                                if (flag5102 == 1) {

                                                } else {
                                                    if (palavras[a].equals(var5102)) {
                                                        quant++;
                                                        flag5102 = 1;
                                                        cfopat1102 = "1102";
                                                        saida5102 = quant;

                                                    }

                                                }

                                                //</editor-fold>
                                                // <editor-fold defaultstate="collapsed" desc="CFOP 5101">
                                                if (flag5101 == 1) {

                                                } else {
                                                    if (palavras[a].equals(var5101)) {
                                                        quant++;
                                                        cfopat1102 = "1102";
                                                        flag5101 = 1;
                                                        saida5101 = quant;

                                                    }
                                                }
//</editor-fold>

                                                // <editor-fold defaultstate="collapsed" desc="CFOP 5401">
                                                if (flag5401 == 1) {

                                                } else {
                                                    if (palavras[a].equals(var5401)) {
                                                        quant++;
                                                        flag5401 = 1;
                                                        cfopat1403 = "1403";
                                                        saida5401 = quant;

                                                    }
                                                }
//</editor-fold>

                                                // <editor-fold defaultstate="collapsed" desc="CFOP 5910">
                                                if (flag5910 == 1) {

                                                } else {
                                                    if (palavras[a].equals(var5910)) {
                                                        quant++;
                                                        flag5910 = 1;
                                                        cfopat1910 = "1910";
                                                        saida5910 = quant;

                                                    }
                                                }
//</editor-fold>

                                                // <editor-fold defaultstate="collapsed" desc="CFOP 5949">
                                                if (flag5949 == 1) {

                                                } else {
                                                    if (palavras[a].equals(var5949)) {
                                                        quant++;
                                                        flag5949 = 1;
                                                        cfopat1949 = "1949";
                                                        saida5949 = quant;

                                                    }
                                                }
//</editor-fold>

                                                // <editor-fold defaultstate="collapsed" desc="CFOP 5104">
                                                if (flag5104 == 1) {

                                                } else {
                                                    if (palavras[a].equals(var5104)) {
                                                        quant++;
                                                        flag5104 = 1;
                                                        cfopat1102 = "1102";
                                                        saida5104 = quant;

                                                    }
                                                }
//</editor-fold>

                                                // <editor-fold defaultstate="collapsed" desc="CFOP 5403">
                                                if (flag5403 == 1) {

                                                } else {
                                                    if (palavras[a].equals(var5403)) {
                                                        quant++;
                                                        flag5403 = 1;
                                                        cfopat1403 = "1403";
                                                        saida5403 = quant;

                                                    }
                                                }
//</editor-fold>

                                                // <editor-fold defaultstate="collapsed" desc="CFOP 1411">
                                                if (flag1411 == 1) {

                                                } else {

                                                    if (palavras[a].equals(var1411)) {
                                                        quant++;
                                                        flag1411 = 1;
                                                        cfopat1411 = "1411";
                                                        saida1411 = quant;

                                                    }
                                                }

                                                //</editor-fold>
                                                // <editor-fold defaultstate="collapsed" desc="CFOP 5929">
                                                if (flag5929 == 1) {

                                                } else {

                                                    if (palavras[a].equals(var5929)) {
                                                        quant++;
                                                        flag5929 = 1;
                                                        saida5929 = quant;

                                                    }
                                                }

                                                //</editor-fold>
                                                // <editor-fold defaultstate="collapsed" desc="CFOP 1410">
                                                if (flag1410 == 1) {

                                                } else {

                                                    if (palavras[a].equals(var1410)) {
                                                        quant++;
                                                        flag1410 = 1;
                                                        cfopat1410 = "1410";
                                                        saida1410 = quant;

                                                    }
                                                }

                                                //</editor-fold>
                                                // <editor-fold defaultstate="collapsed" desc="CFOP 6910">
                                                if (flag6910 == 1) {

                                                } else {

                                                    if (palavras[a].equals(var6910)) {
                                                        quant++;
                                                        flag6910 = 1;
                                                        cfopat2910 = "2910";
                                                        saida6910 = quant;

                                                    }
                                                }

                                                //</editor-fold>
                                                // <editor-fold defaultstate="collapsed" desc="CFOP 6102">
                                                if (flag6102 == 1) {

                                                } else {

                                                    if (palavras[a].equals(var6102)) {
                                                        quant++;
                                                        flag6102 = 1;
                                                        cfopat2102 = "2102";
                                                        saida6102 = quant;

                                                    }
                                                }

                                                //</editor-fold>
                                                // <editor-fold defaultstate="collapsed" desc="CFOP 5911">
                                                if (flag5911 == 1) {

                                                } else {
                                                    if (palavras[a].equals(var5911)) {
                                                        quant++;
                                                        flag5911 = 1;
                                                        cfopat1911 = "1911";
                                                        saida5911 = quant;

                                                    }
                                                }
//</editor-fold>

                                                // <editor-fold defaultstate="collapsed" desc="CFOP 5106">
                                                if (flag5106 == 1) {

                                                } else {
                                                    if (palavras[a].equals(var5106)) {
                                                        quant++;
                                                        flag5106 = 1;
                                                        cfopat1102 = "1102";
                                                        saida5106 = quant;

                                                    }
                                                }
//</editor-fold>

                                                // <editor-fold defaultstate="collapsed" desc="CFOP 5105">
                                                if (flag5105 == 1) {

                                                } else {
                                                    if (palavras[a].equals(var5105)) {
                                                        quant++;
                                                        flag5105 = 1;
                                                        cfopat1102 = "1102";
                                                        saida5105 = quant;

                                                    }
                                                }
//</editor-fold>
// </editor-fold>   
                                            }
                                            break;
//</editor-fold>

                                        // <editor-fold defaultstate="collapsed" desc="vDesc">
                                        case "vDesc":
                                            vdesc = elementodados.getTextContent();
                                            soma_vdesc = Float.parseFloat(vdesc);

                                            // <editor-fold defaultstate="collapsed" desc="VDESC5405">
                                            if (cfop.equals(var5405)) {
                                                vdesc5405 = vdesc5405 + soma_vdesc;

                                            }
                                            // </editor-fold>    

                                            // <editor-fold defaultstate="collapsed" desc="VDESC5102">    
                                            if (cfop.equals(var5102)) {
                                                vdesc5102 = vdesc5102 + soma_vdesc;

                                            }
                                            // </editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="VDESC5101">
                                            if (cfop.equals(var5101)) {
                                                vdesc5101 = vdesc5101 + soma_vdesc;

                                            }
                                            // </editor-fold>                                             

                                            // <editor-fold defaultstate="collapsed" desc="VDESC5104">    
                                            if (cfop.equals(var5104)) {
                                                vdesc5104 = vdesc5104 + soma_vdesc;

                                            }
                                            // </editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="VDESC5910">    
                                            if (cfop.equals(var5910)) {
                                                vdesc5910 = vdesc5910 + soma_vdesc;

                                            }
                                            // </editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="VDESC5401">    
                                            if (cfop.equals(var5401)) {
                                                vdesc5401 = vdesc5401 + soma_vdesc;

                                            }
                                            // </editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="VDESC5949">    
                                            if (cfop.equals(var5949)) {
                                                vdesc5949 = vdesc5949 + soma_vdesc;

                                            }
                                            // </editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="VDESC5403">    
                                            if (cfop.equals(var5403)) {
                                                vdesc5403 = vdesc5403 + soma_vdesc;

                                            }
                                            // </editor-fold>   

                                            // <editor-fold defaultstate="collapsed" desc="VDESC1411">
                                            if (cfop.equals(var1411)) {
                                                vdesc1411 = vdesc1411 + soma_vdesc;

                                            }
                                            // </editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="VDESC5929">
                                            if (cfop.equals(var5929)) {
                                                vdesc5929 = vdesc5929 + soma_vdesc;

                                            }
                                            // </editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="VDESC1410">
                                            if (cfop.equals(var1410)) {
                                                vdesc1410 = vdesc1410 + soma_vdesc;

                                            }
                                            // </editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="VDESC6910">
                                            if (cfop.equals(var6910)) {
                                                vdesc6910 = vdesc6910 + soma_vdesc;

                                            }
                                            // </editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="VDESC6102">
                                            if (cfop.equals(var6102)) {
                                                vdesc6102 = vdesc6102 + soma_vdesc;

                                            }
                                            // </editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="VDESC5911">    
                                            if (cfop.equals(var5911)) {
                                                vdesc5911 = vdesc5911 + soma_vdesc;

                                            }
                                            // </editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="VDESC5106">    
                                            if (cfop.equals(var5106)) {
                                                vdesc5106 = vdesc5106 + soma_vdesc;

                                            }
                                            // </editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="VDESC5105">    
                                            if (cfop.equals(var5105)) {
                                                vdesc5105 = vdesc5105 + soma_vdesc;

                                            }
                                            // </editor-fold>
                                            break;
                                        // </editor-fold>

                                        // <editor-fold defaultstate="collapsed" desc="uCom">
                                        case "uCom":

                                            // txtAreaExemplo.appendText("\t" + "UNIDADE = " + "\t" + elementodados.getTextContent());
                                            break;
                                        //</editor-fold>

                                        // <editor-fold defaultstate="collapsed" desc="vOutro">
                                        case "vOutro":

                                            voutro = elementodados.getTextContent();

                                            float parsefloatvoutro = Float.parseFloat(voutro);
                                            // <editor-fold defaultstate="collapsed" desc="CONDIÇÕES VOUTRO">

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5102">
                                            if ("5102".equals(cfop)) {
                                                voutroverif5102 = parsefloatvoutro + voutroverif5102;

                                            } else {

                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5405">
                                            if (cfop.equals("5405")) {
                                                voutroverif5405 = parsefloatvoutro + voutroverif5405;

                                            } else {

                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5101">
                                            if (cfop.equals("5101")) {
                                                voutroverif5101 = parsefloatvoutro + voutroverif5101;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5104">
                                            if (cfop.equals("5104")) {
                                                voutroverif5104 = parsefloatvoutro + voutroverif5104;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5106">
                                            if (cfop.equals("5106")) {
                                                voutroverif5106 = parsefloatvoutro + voutroverif5106;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5109">
                                            if (cfop.equals("5109")) {
                                                voutroverif5109 = parsefloatvoutro + voutroverif5109;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5122">
                                            if (cfop.equals("5122")) {
                                                voutroverif5122 = parsefloatvoutro + voutroverif5122;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5124">
                                            if (cfop.equals("5124")) {
                                                voutroverif5124 = parsefloatvoutro + voutroverif5124;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5125">
                                            if (cfop.equals("5125")) {
                                                voutroverif5125 = parsefloatvoutro + voutroverif5125;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5152">
                                            if (cfop.equals("5152")) {
                                                voutroverif5152 = parsefloatvoutro + voutroverif5152;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5201">
                                            if (cfop.equals("5201")) {
                                                voutroverif5201 = parsefloatvoutro + voutroverif5201;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5401">
                                            if (cfop.equals("5401")) {
                                                voutroverif5401 = parsefloatvoutro + voutroverif5401;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5402">
                                            if (cfop.equals("5402")) {
                                                voutroverif5402 = parsefloatvoutro + voutroverif5402;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5403">
                                            if (cfop.equals("5403")) {
                                                voutroverif5403 = parsefloatvoutro + voutroverif5403;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5409">
                                            if (cfop.equals("5409")) {
                                                voutroverif5409 = parsefloatvoutro + voutroverif5409;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5410">
                                            if (cfop.equals("5410")) {
                                                voutroverif5410 = parsefloatvoutro + voutroverif5410;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5411">
                                            if (cfop.equals("5411")) {
                                                voutroverif5411 = parsefloatvoutro + voutroverif5411;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5556">
                                            if (cfop.equals("5556")) {
                                                voutroverif5556 = parsefloatvoutro + voutroverif5556;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5556">
                                            if (cfop.equals("5556")) {
                                                voutroverif5556 = parsefloatvoutro + voutroverif5556;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5901">
                                            if (cfop.equals("5901")) {
                                                voutroverif5901 = parsefloatvoutro + voutroverif5901;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5902">
                                            if (cfop.equals("5902")) {
                                                voutroverif5902 = parsefloatvoutro + voutroverif5902;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5910">
                                            if (cfop.equals("5910")) {
                                                voutroverif5910 = parsefloatvoutro + voutroverif5910;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5911">
                                            if (cfop.equals("5911")) {
                                                voutroverif5911 = parsefloatvoutro + voutroverif5911;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5915">
                                            if (cfop.equals("5915")) {
                                                voutroverif5915 = parsefloatvoutro + voutroverif5915;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5916">
                                            if (cfop.equals("5916")) {
                                                voutroverif5916 = parsefloatvoutro + voutroverif5916;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5920">
                                            if (cfop.equals("5920")) {
                                                voutroverif5920 = parsefloatvoutro + voutroverif5920;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5921">
                                            if (cfop.equals("5921")) {
                                                voutroverif5921 = parsefloatvoutro + voutroverif5921;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5924">
                                            if (cfop.equals("5924")) {
                                                voutroverif5924 = parsefloatvoutro + voutroverif5924;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5925">
                                            if (cfop.equals("5925")) {
                                                voutroverif5925 = parsefloatvoutro + voutroverif5915;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5929">
                                            if (cfop.equals("5929")) {
                                                voutroverif5929 = parsefloatvoutro + voutroverif5929;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5949">
                                            if (cfop.equals("5949")) {
                                                voutroverif5949 = parsefloatvoutro + voutroverif5949;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif6101">
                                            if (cfop.equals("6101")) {
                                                voutroverif6101 = parsefloatvoutro + voutroverif6101;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif6102">
                                            if (cfop.equals("6102")) {
                                                voutroverif6102 = parsefloatvoutro + voutroverif6102;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif6104">
                                            if (cfop.equals("6104")) {
                                                voutroverif6104 = parsefloatvoutro + voutroverif6104;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif6106">
                                            if (cfop.equals("6106")) {
                                                voutroverif6106 = parsefloatvoutro + voutroverif6106;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif6152">
                                            if (cfop.equals("6152")) {
                                                voutroverif6152 = parsefloatvoutro + voutroverif6152;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif6201">
                                            if (cfop.equals("6201")) {
                                                voutroverif6201 = parsefloatvoutro + voutroverif6201;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif6202">
                                            if (cfop.equals("6202")) {
                                                voutroverif6202 = parsefloatvoutro + voutroverif6202;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif6401">
                                            if (cfop.equals("6401")) {
                                                voutroverif6401 = parsefloatvoutro + voutroverif6401;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif6402">
                                            if (cfop.equals("6402")) {
                                                voutroverif6402 = parsefloatvoutro + voutroverif6402;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif6403">
                                            if (cfop.equals("6403")) {
                                                voutroverif6403 = parsefloatvoutro + voutroverif6403;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif6404">
                                            if (cfop.equals("6404")) {
                                                voutroverif6404 = parsefloatvoutro + voutroverif6404;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif6409">
                                            if (cfop.equals("6409")) {
                                                voutroverif6409 = parsefloatvoutro + voutroverif6409;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif6410">
                                            if (cfop.equals("6410")) {
                                                voutroverif6410 = parsefloatvoutro + voutroverif6410;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif6411">
                                            if (cfop.equals("6411")) {
                                                voutroverif6411 = parsefloatvoutro + voutroverif6411;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif6413">
                                            if (cfop.equals("6413")) {
                                                voutroverif6413 = parsefloatvoutro + voutroverif6413;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif6556">
                                            if (cfop.equals("6556")) {
                                                voutroverif6556 = parsefloatvoutro + voutroverif6556;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif6901">
                                            if (cfop.equals("6901")) {
                                                voutroverif6901 = parsefloatvoutro + voutroverif6901;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif6902">
                                            if (cfop.equals("6902")) {
                                                voutroverif6902 = parsefloatvoutro + voutroverif6902;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif6910">
                                            if (cfop.equals("6910")) {
                                                voutroverif6910 = parsefloatvoutro + voutroverif6910;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5915">
                                            if (cfop.equals("5915")) {
                                                voutroverif5915 = parsefloatvoutro + voutroverif5915;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif6911">
                                            if (cfop.equals("6911")) {
                                                voutroverif6911 = parsefloatvoutro + voutroverif6911;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif6915">
                                            if (cfop.equals("6915")) {
                                                voutroverif6915 = parsefloatvoutro + voutroverif6915;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif6916">
                                            if (cfop.equals("6916")) {
                                                voutroverif6916 = parsefloatvoutro + voutroverif6916;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif6920">
                                            if (cfop.equals("6920")) {
                                                voutroverif6920 = parsefloatvoutro + voutroverif6920;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif6921">
                                            if (cfop.equals("6921")) {
                                                voutroverif6921 = parsefloatvoutro + voutroverif6921;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif6924">
                                            if (cfop.equals("6924")) {
                                                voutroverif6924 = parsefloatvoutro + voutroverif6924;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif6925">
                                            if (cfop.equals("6925")) {
                                                voutroverif6925 = parsefloatvoutro + voutroverif6925;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif6929">
                                            if (cfop.equals("6929")) {
                                                voutroverif6929 = parsefloatvoutro + voutroverif6929;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif6949">
                                            if (cfop.equals("6949")) {
                                                voutroverif6949 = parsefloatvoutro + voutroverif6949;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif1411">
                                            if (cfop.equals("1411")) {
                                                voutroverif1411 = parsefloatvoutro + voutroverif1411;

                                            } else {

                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif1410">
                                            if (cfop.equals("1410")) {
                                                voutroverif1410 = parsefloatvoutro + voutroverif1410;

                                            } else {

                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5105">
                                            if (cfop.equals("5105")) {
                                                voutroverif5105 = parsefloatvoutro + voutroverif5105;
                                            }
                                            //</editor-fold>

//</editor-fold>
                                            break;
                                        //</editor-fold>

                                        // <editor-fold defaultstate="collapsed" desc="qCom">
                                        case "qCom":

                                            // txtAreaExemplo.appendText("\t" + "QUANTIDADE COMERCIAL = " + "\t" + elementodados.getTextContent());
                                            break;
                                        //</editor-fold>

                                        // <editor-fold defaultstate="collapsed" desc="vUnCom">
                                        case "vUnCom":

                                            // txtAreaExemplo.appendText("\t" + "VALOR UNIDADE COMERCIAL = " + "\t" + elementodados.getTextContent());
                                            break;
                                        //</editor-fold>

                                        // <editor-fold defaultstate="collapsed" desc="vProd">
                                        case "vProd":
                                            vprod = elementodados.getTextContent();

                                            break;
                                        //</editor-fold>

                                        // <editor-fold defaultstate="collapsed" desc="cEANTrib">
                                        case "cEANTrib":

                                            // txtAreaExemplo.appendText("\t" + "CÓDIGO EAN TRIBUTAVEL = " + "\t" + elementodados.getTextContent());
                                            break;
                                        //</editor-fold>

                                        // <editor-fold defaultstate="collapsed" desc="uTrib">
                                        case "uTrib":

                                            // txtAreaExemplo.appendText("\t" + "UNIDADE TRIBUTAVEL = " + "\t" + elementodados.getTextContent());
                                            break;
                                        //</editor-fold>

                                        // <editor-fold defaultstate="collapsed" desc="qTrib">
                                        case "qTrib":

                                            //txtAreaExemplo.appendText("\t" + "QUANTIDADE TRIBUTAVEL = " + "\t" + elementodados.getTextContent());
                                            break;
                                        //</editor-fold>

                                        // <editor-fold defaultstate="collapsed" desc="vUnTrib">
                                        case "vUnTrib":

                                            break;
                                        //</editor-fold>

                                        // <editor-fold defaultstate="collapsed" desc="indTot">
                                        case "indTot":

                                            // txtAreaExemplo.appendText("\t" + "INDTOT = " + "\t" + elementodados.getTextContent());
                                            break;
                                        //</editor-fold>

                                        // <editor-fold defaultstate="collapsed" desc="xPed">
                                        case "xPed":

                                            //txtAreaExemplo.appendText("\t" + "XPED = " + "\t" + elementodados.getTextContent());
                                            break;
                                        //</editor-fold>

                                        // <editor-fold defaultstate="collapsed" desc="nFCI">
                                        case "nFCI":

                                            //txtAreaExemplo.appendText("\t" + "NFCI = " + "\t" + elementodados.getTextContent());
                                            break;
                                        //</editor-fold>

                                        // <editor-fold defaultstate="collapsed" desc="med">
                                        case "med":
// <editor-fold defaultstate="collapsed" desc="nLote">
                                            NodeList nlote = elementoFilho.getElementsByTagName("nLote");
                                            int nlotee = nlote.getLength();

                                            for (int o = 0; o < nlotee; o++) {

                                                Node noFilhoss = nlote.item(o);

                                                if (noFilhoss.getNodeType() == Node.ELEMENT_NODE) {

                                                    Element elementodadoss = (Element) noFilhoss;
                                                    switch (elementodadoss.getTagName()) {
                                                        case "nLote":
                                                            //txtAreaExemplo.appendText("\t" + "nLote=" + "\t" + elementodadoss.getTextContent());
                                                            break;

                                                    }

                                                }

                                            }
                                            //</editor-fold>

// <editor-fold defaultstate="collapsed" desc="qLote">
                                            NodeList qlote = elementoFilho.getElementsByTagName("qLote");
                                            int qlotee = qlote.getLength();

                                            for (int o = 0; o < qlotee; o++) {

                                                Node noFilhoss = qlote.item(o);

                                                if (noFilhoss.getNodeType() == Node.ELEMENT_NODE) {

                                                    Element elementodadoss = (Element) noFilhoss;
                                                    switch (elementodadoss.getTagName()) {
                                                        case "qLote":
                                                            // txtAreaExemplo.appendText("\t" + "qLote = " + "\t" + elementodadoss.getTextContent());
                                                            break;

                                                    }

                                                }

                                            }
                                            //</editor-fold>

// <editor-fold defaultstate="collapsed" desc="dFab">
                                            NodeList dfab = elementoFilho.getElementsByTagName("dFab");
                                            int dfabb = dfab.getLength();

                                            for (int o = 0; o < dfabb; o++) {

                                                Node noFilhoss = dfab.item(o);

                                                if (noFilhoss.getNodeType() == Node.ELEMENT_NODE) {

                                                    Element elementodadoss = (Element) noFilhoss;
                                                    switch (elementodadoss.getTagName()) {
                                                        case "dFab":
                                                            //txtAreaExemplo.appendText("\t" + "dFab = " + "\t" + elementodadoss.getTextContent());
                                                            break;

                                                    }

                                                }

                                            }
                                            //</editor-fold>

// <editor-fold defaultstate="collapsed" desc="dVal">
                                            NodeList dval = elementoFilho.getElementsByTagName("dVal");
                                            int dvall = dval.getLength();

                                            for (int o = 0; o < dvall; o++) {

                                                Node noFilhoss = dval.item(o);

                                                if (noFilhoss.getNodeType() == Node.ELEMENT_NODE) {

                                                    Element elementodadoss = (Element) noFilhoss;
                                                    switch (elementodadoss.getTagName()) {
                                                        case "dVal":
                                                            //txtAreaExemplo.appendText("\t" + "dVal = " + "\t" + elementodadoss.getTextContent());
                                                            break;

                                                    }

                                                }

                                            }
                                            //</editor-fold>

// <editor-fold defaultstate="collapsed" desc="vPMC">
                                            NodeList vpmc = elementoFilho.getElementsByTagName("vPMC");
                                            int vpmcc = vpmc.getLength();

                                            for (int o = 0; o < vpmcc; o++) {

                                                Node noFilhoss = vpmc.item(o);

                                                if (noFilhoss.getNodeType() == Node.ELEMENT_NODE) {

                                                    Element elementodadoss = (Element) noFilhoss;
                                                    switch (elementodadoss.getTagName()) {
                                                        case "vPMC":
                                                            // txtAreaExemplo.appendText("\t" + "vPMC = " + "\t" + elementodadoss.getTextContent());
                                                            break;

                                                    }

                                                }

                                            }
                                            //</editor-fold>

                                            break;
                                        //</editor-fold>

                                        // <editor-fold defaultstate="collapsed" desc="ORIG(ICMS)">
                                        case "ICMS":

                                            NodeList icmss = elementoFilho.getElementsByTagName("orig");
                                            int tamanhodadosss = icmss.getLength();

                                            for (int o = 0; o < tamanhodadosss; o++) {

                                                Node noFilhoss = icmss.item(o);

                                                if (noFilhoss.getNodeType() == Node.ELEMENT_NODE) {

                                                    Element elementodadoss = (Element) noFilhoss;
                                                    switch (elementodadoss.getTagName()) {
                                                        case "orig":
                                                            //txtAreaExemplo.appendText("\t" + "orig = " + "\t" + elementodadoss.getTextContent());
                                                            break;

                                                    }

                                                }

                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="vBCSTRet">
                                            NodeList vb = elementoFilho.getElementsByTagName("vBCSTRet");
                                            int vbb = vb.getLength();

                                            for (int o = 0; o < vbb; o++) {

                                                Node noFilhoss = vb.item(o);

                                                if (noFilhoss.getNodeType() == Node.ELEMENT_NODE) {

                                                    Element elementodadoss = (Element) noFilhoss;
                                                    switch (elementodadoss.getTagName()) {
                                                        case "vBCSTRet":
                                                            //txtAreaExemplo.appendText("\t" + "vBCSTRet = " + "\t" + elementodadoss.getTextContent());
                                                            break;

                                                    }

                                                }

                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="vICMSSTRet">
                                            NodeList vi = elementoFilho.getElementsByTagName("vICMSSTRet");
                                            int vii = vi.getLength();

                                            for (int o = 0; o < vii; o++) {

                                                Node noFilhoss = vi.item(o);

                                                if (noFilhoss.getNodeType() == Node.ELEMENT_NODE) {

                                                    Element elementodadoss = (Element) noFilhoss;
                                                    switch (elementodadoss.getTagName()) {
                                                        case "vICMSSTRet":
                                                            // txtAreaExemplo.appendText("\t" + "vICMSSTRet = " + "\t" + elementodadoss.getTextContent());
                                                            break;

                                                    }

                                                }

                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="CST"> //  
                                            NodeList icms = elementoFilho.getElementsByTagName("CST");

                                            int tamanhodadoss = icms.getLength();

                                            for (int o = 0; o < tamanhodadoss; o++) {

                                                Node noFilhoss = icms.item(o);

                                                if (noFilhoss.getNodeType() == Node.ELEMENT_NODE) {

                                                    Element elementodadoss = (Element) noFilhoss;
                                                    switch (elementodadoss.getTagName()) {

                                                        case "CST":
                                                            cst = elementodadoss.getTextContent();
                                                            parsefloat = Float.parseFloat(vprod);

                                                            // <editor-fold defaultstate="collapsed" desc="CST5405">
                                                            if (cfop.equals(var5405) && cst.equals(cst60) || cfop.equals(var5405) && cst.equals(cst00) || cfop.equals(var5405) && cst.equals(cst10)
                                                                    || cfop.equals(var5405) && cst.equals(cst20) || cfop.equals(var5405) && cst.equals(cst30) || cfop.equals(var5405) && cst.equals(cst40)
                                                                    || cfop.equals(var5405) && cst.equals(cst41) || cfop.equals(var5405) && cst.equals(cst50) || cfop.equals(var5405) && cst.equals(cst51)
                                                                    || cfop.equals(var5405) && cst.equals(cst70) || cfop.equals(var5405) && cst.equals(cst90)) {

                                                                vprod5405 = parsefloat + vprod5405;
                                                                total_outras5405 = vprod5405 + voutroverif5405 - vdesc5405;
                                                                valor_total_nota5405 = vprod5405 + voutroverif5405 - vdesc5405;

                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST5102">
                                                            if (cfop.equals(var5102) && cst.equals(cst60) || cfop.equals(var5102) && cst.equals(cst00) || cfop.equals(var5102) && cst.equals(cst10)
                                                                    || cfop.equals(var5102) && cst.equals(cst20) || cfop.equals(var5102) && cst.equals(cst30) || cfop.equals(var5102) && cst.equals(cst40)
                                                                    || cfop.equals(var5102) && cst.equals(cst41) || cfop.equals(var5102) && cst.equals(cst50) || cfop.equals(var5102) && cst.equals(cst51)
                                                                    || cfop.equals(var5102) && cst.equals(cst70) || cfop.equals(var5102) && cst.equals(cst90)) {

                                                                vprod5102 = parsefloat + vprod5102;
                                                                valor_total_nota5102 = vprod5102 + voutroverif5102 - vdesc5102;

                                                                if (cst.equals(cst40) || cst.equals(cst41) || cst.equals(50) || cst.equals(icmssn102) || cst.equals(icmssn103) || cst.equals(icmssn3)) {

                                                                    valor_isentas_naotributadas5102 = valor_isentas_naotributadas5102 + parsefloat + voutroverif5102 - vdesc5102;

                                                                }
                                                                total_outras5102 = vprod5102 + voutroverif5102 - vdesc5102 - valor_isentas_naotributadas5102;

                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST5101">
                                                            if (cfop.equals(var5101) && cst.equals(cst60) || cfop.equals(var5101) && cst.equals(cst00) || cfop.equals(var5101) && cst.equals(cst10)
                                                                    || cfop.equals(var5101) && cst.equals(cst20) || cfop.equals(var5101) && cst.equals(cst30) || cfop.equals(var5101) && cst.equals(cst40)
                                                                    || cfop.equals(var5101) && cst.equals(cst41) || cfop.equals(var5101) && cst.equals(cst50) || cfop.equals(var5101) && cst.equals(cst51)
                                                                    || cfop.equals(var5101) && cst.equals(cst70) || cfop.equals(var5101) && cst.equals(cst90)) {

                                                                vprod5101 = parsefloat + vprod5101;

                                                                valor_total_nota5101 = vprod5101 + voutroverif5101 - vdesc5101;

                                                                if (cst.equals(cst40) || cst.equals(cst41) || cst.equals(50) || cst.equals(icmssn102) || cst.equals(icmssn103) || cst.equals(icmssn3)) {

                                                                    valor_isentas_naotributadas5101 = valor_isentas_naotributadas5101 + parsefloat - vdesc5101 + voutroverif5101;

                                                                }
                                                                total_outras5101 = vprod5101 + voutroverif5101 - vdesc5101 - valor_isentas_naotributadas5101;

                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST5104">
                                                            if (cfop.equals(var5104) && cst.equals(cst60) || cfop.equals(var5104) && cst.equals(cst00) || cfop.equals(var5104) && cst.equals(cst10)
                                                                    || cfop.equals(var5104) && cst.equals(cst20) || cfop.equals(var5104) && cst.equals(cst30) || cfop.equals(var5104) && cst.equals(cst40)
                                                                    || cfop.equals(var5104) && cst.equals(cst41) || cfop.equals(var5104) && cst.equals(cst50) || cfop.equals(var5104) && cst.equals(cst51)
                                                                    || cfop.equals(var5104) && cst.equals(cst70) || cfop.equals(var5104) && cst.equals(cst90)) {

                                                                vprod5104 = parsefloat + vprod5104;
                                                                valor_total_nota5104 = vprod5104 + voutroverif5104 - vdesc5104;
                                                                total_outras5104 = vprod5104 + voutroverif5104 - vdesc5104;

                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST5403">
                                                            if (cfop.equals(var5403) && cst.equals(cst60) || cfop.equals(var5403) && cst.equals(cst00) || cfop.equals(var5403) && cst.equals(cst10)
                                                                    || cfop.equals(var5403) && cst.equals(cst20) || cfop.equals(var5403) && cst.equals(cst30) || cfop.equals(var5403) && cst.equals(cst40)
                                                                    || cfop.equals(var5403) && cst.equals(cst41) || cfop.equals(var5403) && cst.equals(cst50) || cfop.equals(var5403) && cst.equals(cst51)
                                                                    || cfop.equals(var5403) && cst.equals(cst70) || cfop.equals(var5403) && cst.equals(cst90)) {

                                                                vprod5403 = parsefloat + vprod5403;
                                                                valor_total_nota5403 = vprod5403 + voutroverif5403 - vdesc5403;
                                                                total_outras5403 = vprod5403 + voutroverif5403 - vdesc5403;
                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST5401">
                                                            if (cfop.equals(var5401) && cst.equals(cst60) || cfop.equals(var5401) && cst.equals(cst00) || cfop.equals(var5401) && cst.equals(cst10)
                                                                    || cfop.equals(var5401) && cst.equals(cst20) || cfop.equals(var5401) && cst.equals(cst30) || cfop.equals(var5401) && cst.equals(cst40)
                                                                    || cfop.equals(var5401) && cst.equals(cst41) || cfop.equals(var5401) && cst.equals(cst50) || cfop.equals(var5401) && cst.equals(cst51)
                                                                    || cfop.equals(var5401) && cst.equals(cst70) || cfop.equals(var5401) && cst.equals(cst90)) {
                                                                vprod5401 = parsefloat + vprod5401;
                                                                valor_total_nota5401 = vprod5401 + voutroverif5401 - vdesc5401;
                                                                total_outras5401 = vprod5401 + voutroverif5401 - vdesc5401;
                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST5910">
                                                            if (cfop.equals(var5910) && cst.equals(cst60) || cfop.equals(var5910) && cst.equals(cst00) || cfop.equals(var5910) && cst.equals(cst10)
                                                                    || cfop.equals(var5910) && cst.equals(cst20) || cfop.equals(var5910) && cst.equals(cst30) || cfop.equals(var5910) && cst.equals(cst40)
                                                                    || cfop.equals(var5910) && cst.equals(cst41) || cfop.equals(var5910) && cst.equals(cst50) || cfop.equals(var5910) && cst.equals(cst51)
                                                                    || cfop.equals(var5910) && cst.equals(cst70) || cfop.equals(var5910) && cst.equals(cst90)) {
                                                                vprod5910 = parsefloat + vprod5910;
                                                                valor_total_nota5910 = vprod5910 + voutroverif5910 - vdesc5910;
                                                                total_outras5910 = vprod5910 + voutroverif5910 - vdesc5910;
                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST5949">
                                                            if (cfop.equals(var5949) && cst.equals(cst60) || cfop.equals(var5949) && cst.equals(cst00) || cfop.equals(var5949) && cst.equals(cst10)
                                                                    || cfop.equals(var5949) && cst.equals(cst20) || cfop.equals(var5949) && cst.equals(cst30) || cfop.equals(var5949) && cst.equals(cst40)
                                                                    || cfop.equals(var5949) && cst.equals(cst41) || cfop.equals(var5949) && cst.equals(cst50) || cfop.equals(var5949) && cst.equals(cst51)
                                                                    || cfop.equals(var5949) && cst.equals(cst70) || cfop.equals(var5949) && cst.equals(cst90)) {
                                                                vprod5949 = parsefloat + vprod5949;
                                                                valor_total_nota5949 = vprod5949 + voutroverif5949 - vdesc5949;
                                                                total_outras5949 = vprod5949 + voutroverif5949 - vdesc5949;
                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST1411">
                                                            if (cfop.equals(var1411) && cst.equals(cst60) || cfop.equals(var1411) && cst.equals(cst00) || cfop.equals(var1411) && cst.equals(cst10)
                                                                    || cfop.equals(var1411) && cst.equals(cst20) || cfop.equals(var1411) && cst.equals(cst30) || cfop.equals(var1411) && cst.equals(cst40)
                                                                    || cfop.equals(var1411) && cst.equals(cst41) || cfop.equals(var1411) && cst.equals(cst50) || cfop.equals(var1411) && cst.equals(cst51)
                                                                    || cfop.equals(var1411) && cst.equals(cst70) || cfop.equals(var1411) && cst.equals(cst90)) {
                                                                vprod1411 = parsefloat + vprod1411;
                                                                valor_total_nota1411 = vprod1411 + voutroverif1411 - vdesc1411;
                                                                total_outras1411 = vprod1411 + voutroverif1411 - vdesc1411;
                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST5929">
                                                            if (cfop.equals(var5929) && cst.equals(cst60) || cfop.equals(var5929) && cst.equals(cst00) || cfop.equals(var5929) && cst.equals(cst10)
                                                                    || cfop.equals(var5929) && cst.equals(cst20) || cfop.equals(var5929) && cst.equals(cst30) || cfop.equals(var5929) && cst.equals(cst40)
                                                                    || cfop.equals(var5929) && cst.equals(cst41) || cfop.equals(var5929) && cst.equals(cst50) || cfop.equals(var5929) && cst.equals(cst51)
                                                                    || cfop.equals(var5929) && cst.equals(cst70) || cfop.equals(var5929) && cst.equals(cst90)) {

                                                                vprod5929 = parsefloat + vprod5929;
                                                                total_outras5929 = vprod5929 + voutroverif5929 - vdesc5929;
                                                                valor_total_nota5929 = vprod5929 + voutroverif5929 - vdesc5929;
                                                                if (cst.equals(cst00) || cst.equals(cst40) || cst.equals(cst41) || cst.equals(cst20)) {
                                                                    cfopat1949 = "1102";
                                                                } else {
                                                                    cfopat1949 = "1403";
                                                                }

                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST1410">
                                                            if (cfop.equals(var1410) && cst.equals(cst60) || cfop.equals(var1410) && cst.equals(cst00) || cfop.equals(var1410) && cst.equals(cst10)
                                                                    || cfop.equals(var1410) && cst.equals(cst20) || cfop.equals(var1410) && cst.equals(cst30) || cfop.equals(var1410) && cst.equals(cst40)
                                                                    || cfop.equals(var1410) && cst.equals(cst41) || cfop.equals(var1410) && cst.equals(cst50) || cfop.equals(var1410) && cst.equals(cst51)
                                                                    || cfop.equals(var1410) && cst.equals(cst70) || cfop.equals(var1410) && cst.equals(cst90)) {
                                                                vprod1410 = parsefloat + vprod1410;
                                                                valor_total_nota1410 = vprod1410 + voutroverif1410 - vdesc1410;
                                                                total_outras1410 = vprod1410 + voutroverif1410 - vdesc1410;
                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST6910">
                                                            if (cfop.equals(var6910) && cst.equals(cst60) || cfop.equals(var6910) && cst.equals(cst00) || cfop.equals(var6910) && cst.equals(cst10)
                                                                    || cfop.equals(var6910) && cst.equals(cst20) || cfop.equals(var6910) && cst.equals(cst30) || cfop.equals(var6910) && cst.equals(cst40)
                                                                    || cfop.equals(var6910) && cst.equals(cst41) || cfop.equals(var6910) && cst.equals(cst50) || cfop.equals(var6910) && cst.equals(cst51)
                                                                    || cfop.equals(var6910) && cst.equals(cst70) || cfop.equals(var6910) && cst.equals(cst90)) {

                                                                vprod6910 = parsefloat + vprod6910;
                                                                total_outras6910 = vprod6910 + voutroverif6910 - vdesc6910;
                                                                valor_total_nota6910 = vprod6910 + voutroverif6910 - vdesc6910;

                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST6102">
                                                            if (cfop.equals(var6102) && cst.equals(cst60) || cfop.equals(var6102) && cst.equals(cst00) || cfop.equals(var6102) && cst.equals(cst10)
                                                                    || cfop.equals(var6102) && cst.equals(cst20) || cfop.equals(var6102) && cst.equals(cst30) || cfop.equals(var6102) && cst.equals(cst40)
                                                                    || cfop.equals(var6102) && cst.equals(cst41) || cfop.equals(var6102) && cst.equals(cst50) || cfop.equals(var6102) && cst.equals(cst51)
                                                                    || cfop.equals(var6102) && cst.equals(cst70) || cfop.equals(var6102) && cst.equals(cst90)) {

                                                                vprod6102 = parsefloat + vprod6102;
                                                                total_outras6102 = vprod6102 + voutroverif6102 - vdesc6102;
                                                                valor_total_nota6102 = vprod6102 + voutroverif6102 - vdesc6102;

                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST5911">
                                                            if (cfop.equals(var5911) && cst.equals(cst60) || cfop.equals(var5911) && cst.equals(cst00) || cfop.equals(var5911) && cst.equals(cst10)
                                                                    || cfop.equals(var5911) && cst.equals(cst20) || cfop.equals(var5911) && cst.equals(cst30) || cfop.equals(var5911) && cst.equals(cst40)
                                                                    || cfop.equals(var5911) && cst.equals(cst41) || cfop.equals(var5911) && cst.equals(cst50) || cfop.equals(var5911) && cst.equals(cst51)
                                                                    || cfop.equals(var5911) && cst.equals(cst70) || cfop.equals(var5911) && cst.equals(cst90)) {
                                                                vprod5911 = parsefloat + vprod5911;
                                                                valor_total_nota5911 = vprod5911 + voutroverif5911 - vdesc5911;
                                                                total_outras5911 = vprod5911 + voutroverif5911 - vdesc5911;
                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST5106">
                                                            if (cfop.equals(var5106) && cst.equals(cst60) || cfop.equals(var5106) && cst.equals(cst00) || cfop.equals(var5106) && cst.equals(cst10)
                                                                    || cfop.equals(var5106) && cst.equals(cst20) || cfop.equals(var5106) && cst.equals(cst30) || cfop.equals(var5106) && cst.equals(cst40)
                                                                    || cfop.equals(var5106) && cst.equals(cst41) || cfop.equals(var5106) && cst.equals(cst50) || cfop.equals(var5106) && cst.equals(cst51)
                                                                    || cfop.equals(var5106) && cst.equals(cst70) || cfop.equals(var5106) && cst.equals(cst90)) {
                                                                vprod5106 = parsefloat + vprod5106;
                                                                valor_total_nota5106 = vprod5106 + voutroverif5106 - vdesc5106;
                                                                total_outras5106 = vprod5106 + voutroverif5106 - vdesc5106;
                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST5105">
                                                            if (cfop.equals(var5105) && cst.equals(cst60) || cfop.equals(var5105) && cst.equals(cst00) || cfop.equals(var5105) && cst.equals(cst10)
                                                                    || cfop.equals(var5105) && cst.equals(cst20) || cfop.equals(var5105) && cst.equals(cst30) || cfop.equals(var5105) && cst.equals(cst40)
                                                                    || cfop.equals(var5105) && cst.equals(cst41) || cfop.equals(var5105) && cst.equals(cst50) || cfop.equals(var5105) && cst.equals(cst51)
                                                                    || cfop.equals(var5105) && cst.equals(cst70) || cfop.equals(var5105) && cst.equals(cst90)) {
                                                                vprod5105 = parsefloat + vprod5105;
                                                                valor_total_nota5105 = vprod5105 + voutroverif5105 - vdesc5105;
                                                                total_outras5105 = vprod5105 + voutroverif5105 - vdesc5105;
                                                            }
                                                            //</editor-fold>
                                                            break;
                                                    }
                                                }
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="CSOSN"> 
                                            NodeList csocsn = elementoFilho.getElementsByTagName("CSOSN");

                                            int csocsna = csocsn.getLength();

                                            for (int o = 0; o < csocsna; o++) {

                                                Node noFilhoss = csocsn.item(o);

                                                if (noFilhoss.getNodeType() == Node.ELEMENT_NODE) {

                                                    Element elementodadoss = (Element) noFilhoss;
                                                    switch (elementodadoss.getTagName()) {

                                                        case "CSOSN":
                                                            valor_csosn = elementodadoss.getTextContent();
                                                            parsefloat = Float.parseFloat(vprod);

                                                            // <editor-fold defaultstate="collapsed" desc="CST5405">
                                                            if (cfop.equals(var5405) && valor_csosn.equals(icmssn101) || cfop.equals(var5405) && valor_csosn.equals(icmssn102)
                                                                    || cfop.equals(var5405) && valor_csosn.equals(icmssn103) || cfop.equals(var5405) && valor_csosn.equals(icmssn3) || cfop.equals(var5405) && valor_csosn.equals(icmssn201)
                                                                    || cfop.equals(var5405) && valor_csosn.equals(icmssn202) || cfop.equals(var5405) && valor_csosn.equals(icmssn203) || cfop.equals(var5405) && valor_csosn.equals(icmssn203)
                                                                    || cfop.equals(var5405) && valor_csosn.equals(icmssn500) || cfop.equals(var5405) && valor_csosn.equals(icmssn900) || cfop.equals(var5405) && valor_csosn.equals(icmssn300) || cfop.equals(var5405) && valor_csosn.equals(icmssn400)) {

                                                                vprod5405 = parsefloat + vprod5405;
                                                                total_outras5405 = vprod5405 + voutroverif5405 - vdesc5405;
                                                                valor_total_nota5405 = vprod5405 + voutroverif5405 - vdesc5405;

                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST5102">
                                                            if (cfop.equals(var5102) && valor_csosn.equals(icmssn101) || cfop.equals(var5102) && valor_csosn.equals(icmssn102)
                                                                    || cfop.equals(var5102) && valor_csosn.equals(icmssn103) || cfop.equals(var5102) && valor_csosn.equals(icmssn3) || cfop.equals(var5102) && valor_csosn.equals(icmssn201)
                                                                    || cfop.equals(var5102) && valor_csosn.equals(icmssn202) || cfop.equals(var5102) && valor_csosn.equals(icmssn203) || cfop.equals(var5102) && valor_csosn.equals(icmssn203)
                                                                    || cfop.equals(var5102) && valor_csosn.equals(icmssn500) || cfop.equals(var5102) && valor_csosn.equals(icmssn900) || cfop.equals(var5102) && valor_csosn.equals(icmssn300) || cfop.equals(var5102) && valor_csosn.equals(icmssn400)) {

                                                                vprod5102 = parsefloat + vprod5102;
                                                                valor_total_nota5102 = vprod5102 + voutroverif5102 - vdesc5102;

                                                                if (valor_csosn.equals(icmssn102) || valor_csosn.equals(icmssn103) || valor_csosn.equals(icmssn3)) {

                                                                    valor_isentas_naotributadas5102 = valor_isentas_naotributadas5102 + parsefloat + voutroverif5102 - vdesc5102;

                                                                }
                                                                total_outras5102 = vprod5102 + voutroverif5102 - vdesc5102 - valor_isentas_naotributadas5102;

                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST5101">
                                                            if (cfop.equals(var5101) && valor_csosn.equals(icmssn101) || cfop.equals(var5101) && valor_csosn.equals(icmssn102)
                                                                    || cfop.equals(var5101) && valor_csosn.equals(icmssn103) || cfop.equals(var5101) && valor_csosn.equals(icmssn3) || cfop.equals(var5101) && valor_csosn.equals(icmssn201)
                                                                    || cfop.equals(var5101) && valor_csosn.equals(icmssn202) || cfop.equals(var5101) && valor_csosn.equals(icmssn203) || cfop.equals(var5101) && valor_csosn.equals(icmssn203)
                                                                    || cfop.equals(var5101) && valor_csosn.equals(icmssn500) || cfop.equals(var5101) && valor_csosn.equals(icmssn900) || cfop.equals(var5101) && valor_csosn.equals(icmssn300) || cfop.equals(var5101) && valor_csosn.equals(icmssn400)) {

                                                                vprod5101 = parsefloat + vprod5101;

                                                                valor_total_nota5101 = vprod5101 + voutroverif5101 - vdesc5101;

                                                                if (valor_csosn.equals(icmssn102) || valor_csosn.equals(icmssn103) || valor_csosn.equals(icmssn3)) {

                                                                    valor_isentas_naotributadas5101 = valor_isentas_naotributadas5101 + parsefloat - vdesc5101 + voutroverif5101;

                                                                }
                                                                total_outras5101 = vprod5101 + voutroverif5101 - vdesc5101 - valor_isentas_naotributadas5101;

                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST5104">
                                                            if (cfop.equals(var5104) && valor_csosn.equals(icmssn101) || cfop.equals(var5104) && valor_csosn.equals(icmssn102)
                                                                    || cfop.equals(var5104) && valor_csosn.equals(icmssn103) || cfop.equals(var5104) && valor_csosn.equals(icmssn3) || cfop.equals(var5104) && valor_csosn.equals(icmssn201)
                                                                    || cfop.equals(var5104) && valor_csosn.equals(icmssn202) || cfop.equals(var5104) && valor_csosn.equals(icmssn203) || cfop.equals(var5104) && valor_csosn.equals(icmssn203)
                                                                    || cfop.equals(var5104) && valor_csosn.equals(icmssn500) || cfop.equals(var5104) && valor_csosn.equals(icmssn900) || cfop.equals(var5104) && valor_csosn.equals(icmssn300) || cfop.equals(var5104) && valor_csosn.equals(icmssn400)) {

                                                                vprod5104 = parsefloat + vprod5104;
                                                                valor_total_nota5104 = vprod5104 + voutroverif5104 - vdesc5104;
                                                                total_outras5104 = vprod5104 + voutroverif5104 - vdesc5104;

                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST5403">
                                                            if (cfop.equals(var5403) && valor_csosn.equals(icmssn101) || cfop.equals(var5403) && valor_csosn.equals(icmssn102)
                                                                    || cfop.equals(var5403) && valor_csosn.equals(icmssn103) || cfop.equals(var5403) && valor_csosn.equals(icmssn3) || cfop.equals(var5403) && valor_csosn.equals(icmssn201)
                                                                    || cfop.equals(var5403) && valor_csosn.equals(icmssn202) || cfop.equals(var5403) && valor_csosn.equals(icmssn203) || cfop.equals(var5403) && valor_csosn.equals(icmssn203)
                                                                    || cfop.equals(var5403) && valor_csosn.equals(icmssn500) || cfop.equals(var5403) && valor_csosn.equals(icmssn900) || cfop.equals(var5403) && valor_csosn.equals(icmssn300) || cfop.equals(var5403) && valor_csosn.equals(icmssn400)) {

                                                                vprod5403 = parsefloat + vprod5403;
                                                                valor_total_nota5403 = vprod5403 + voutroverif5403 - vdesc5403;
                                                                total_outras5403 = vprod5403 + voutroverif5403 - vdesc5403;
                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST5401">
                                                            if (cfop.equals(5401) && valor_csosn.equals(icmssn101) || cfop.equals(5401) && valor_csosn.equals(icmssn102)
                                                                    || cfop.equals(5401) && valor_csosn.equals(icmssn103) || cfop.equals(5401) && valor_csosn.equals(icmssn3) || cfop.equals(5401) && valor_csosn.equals(icmssn201)
                                                                    || cfop.equals(5401) && valor_csosn.equals(icmssn202) || cfop.equals(5401) && valor_csosn.equals(icmssn203) || cfop.equals(5401) && valor_csosn.equals(icmssn203)
                                                                    || cfop.equals(5401) && valor_csosn.equals(icmssn500) || cfop.equals(5401) && valor_csosn.equals(icmssn900) || cfop.equals(5929) && valor_csosn.equals(icmssn300) || cfop.equals(5929) && valor_csosn.equals(icmssn400)) {
                                                                vprod5401 = parsefloat + vprod5401;
                                                                valor_total_nota5401 = vprod5401 + voutroverif5401 - vdesc5401;
                                                                total_outras5401 = vprod5401 + voutroverif5401 - vdesc5401;
                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST5910">
                                                            if (cfop.equals(5910) && valor_csosn.equals(icmssn101) || cfop.equals(5910) && valor_csosn.equals(icmssn102)
                                                                    || cfop.equals(5910) && valor_csosn.equals(icmssn103) || cfop.equals(5910) && valor_csosn.equals(icmssn3) || cfop.equals(5910) && valor_csosn.equals(icmssn201)
                                                                    || cfop.equals(5910) && valor_csosn.equals(icmssn202) || cfop.equals(5910) && valor_csosn.equals(icmssn203) || cfop.equals(5910) && valor_csosn.equals(icmssn203)
                                                                    || cfop.equals(5910) && valor_csosn.equals(icmssn500) || cfop.equals(5910) && valor_csosn.equals(icmssn900) || cfop.equals(5929) && valor_csosn.equals(icmssn300) || cfop.equals(5929) && valor_csosn.equals(icmssn400)) {
                                                                vprod5910 = parsefloat + vprod5910;
                                                                valor_total_nota5910 = vprod5910 + voutroverif5910 - vdesc5910;
                                                                total_outras5910 = vprod5910 + voutroverif5910 - vdesc5910;
                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST5949">
                                                            if (cfop.equals(var5949) && valor_csosn.equals(icmssn101) || cfop.equals(var5949) && valor_csosn.equals(icmssn102)
                                                                    || cfop.equals(var5949) && valor_csosn.equals(icmssn103) || cfop.equals(var5949) && valor_csosn.equals(icmssn3) || cfop.equals(var5949) && valor_csosn.equals(icmssn201)
                                                                    || cfop.equals(var5949) && valor_csosn.equals(icmssn202) || cfop.equals(var5949) && valor_csosn.equals(icmssn203) || cfop.equals(var5949) && valor_csosn.equals(icmssn203)
                                                                    || cfop.equals(var5949) && valor_csosn.equals(icmssn500) || cfop.equals(var5949) && valor_csosn.equals(icmssn900) || cfop.equals(var5949) && valor_csosn.equals(icmssn300) || cfop.equals(var5949) && valor_csosn.equals(icmssn400)) {
                                                                vprod5949 = parsefloat + vprod5949;
                                                                valor_total_nota5949 = vprod5949 + voutroverif5949 - vdesc5949;
                                                                total_outras5949 = vprod5949 + voutroverif5949 - vdesc5949;
                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST1411">
                                                            if (cfop.equals(var1411) && valor_csosn.equals(icmssn101) || cfop.equals(var1411) && valor_csosn.equals(icmssn102)
                                                                    || cfop.equals(var1411) && valor_csosn.equals(icmssn103) || cfop.equals(var1411) && valor_csosn.equals(icmssn3) || cfop.equals(var1411) && valor_csosn.equals(icmssn201)
                                                                    || cfop.equals(var1411) && valor_csosn.equals(icmssn202) || cfop.equals(var1411) && valor_csosn.equals(icmssn203) || cfop.equals(var1411) && valor_csosn.equals(icmssn203)
                                                                    || cfop.equals(var1411) && valor_csosn.equals(icmssn500) || cfop.equals(var1411) && valor_csosn.equals(icmssn900) || cfop.equals(var1411) && valor_csosn.equals(icmssn300) || cfop.equals(var1411) && valor_csosn.equals(icmssn400)) {
                                                                vprod1411 = parsefloat + vprod1411;
                                                                valor_total_nota1411 = vprod1411 + voutroverif1411 - vdesc1411;
                                                                total_outras1411 = vprod1411 + voutroverif1411 - vdesc1411;
                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST5929">
                                                            if (cfop.equals(var5929) && valor_csosn.equals(icmssn101) || cfop.equals(var5929) && valor_csosn.equals(icmssn102)
                                                                    || cfop.equals(var5929) && valor_csosn.equals(icmssn103) || cfop.equals(var5929) && valor_csosn.equals(icmssn3) || cfop.equals(var5929) && valor_csosn.equals(icmssn201)
                                                                    || cfop.equals(var5929) && valor_csosn.equals(icmssn202) || cfop.equals(var5929) && valor_csosn.equals(icmssn203) || cfop.equals(var5929) && valor_csosn.equals(icmssn203)
                                                                    || cfop.equals(var5929) && valor_csosn.equals(icmssn500) || cfop.equals(var5929) && valor_csosn.equals(icmssn900) || cfop.equals(var5929) && valor_csosn.equals(icmssn300) || cfop.equals(var5929) && valor_csosn.equals(icmssn400)) {

                                                                vprod5929 = parsefloat + vprod5929;
                                                                total_outras5929 = vprod5929 + voutroverif5929 - vdesc5929;
                                                                valor_total_nota5929 = vprod5929 + voutroverif5929 - vdesc5929;
                                                                if (valor_csosn.equals(icmssn101) || valor_csosn.equals(icmssn103) || valor_csosn.equals(icmssn300) || valor_csosn.equals(icmssn400)) {
                                                                    cfopat1949 = "1102";
                                                                } else {
                                                                    cfopat1949 = "1403";
                                                                }

                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST1410">
                                                            if (cfop.equals(var1410) && valor_csosn.equals(icmssn101) || cfop.equals(var1410) && valor_csosn.equals(icmssn102)
                                                                    || cfop.equals(var1410) && valor_csosn.equals(icmssn103) || cfop.equals(var1410) && valor_csosn.equals(icmssn3) || cfop.equals(var1410) && valor_csosn.equals(icmssn201)
                                                                    || cfop.equals(var1410) && valor_csosn.equals(icmssn202) || cfop.equals(var1410) && valor_csosn.equals(icmssn203) || cfop.equals(var1410) && valor_csosn.equals(icmssn203)
                                                                    || cfop.equals(var1410) && valor_csosn.equals(icmssn500) || cfop.equals(var1410) && valor_csosn.equals(icmssn900) || cfop.equals(var1410) && valor_csosn.equals(icmssn300) || cfop.equals(var1410) && valor_csosn.equals(icmssn400)) {
                                                                vprod1410 = parsefloat + vprod1410;
                                                                valor_total_nota1410 = vprod1410 + voutroverif1410 - vdesc1410;
                                                                total_outras1410 = vprod1410 + voutroverif1410 - vdesc1410;
                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST6910">
                                                            if (cfop.equals(var6910) && valor_csosn.equals(icmssn101) || cfop.equals(var6910) && valor_csosn.equals(icmssn102)
                                                                    || cfop.equals(var6910) && valor_csosn.equals(icmssn103) || cfop.equals(var6910) && valor_csosn.equals(icmssn3) || cfop.equals(var6910) && valor_csosn.equals(icmssn201)
                                                                    || cfop.equals(var6910) && valor_csosn.equals(icmssn202) || cfop.equals(var6910) && valor_csosn.equals(icmssn203) || cfop.equals(var6910) && valor_csosn.equals(icmssn203)
                                                                    || cfop.equals(var6910) && valor_csosn.equals(icmssn500) || cfop.equals(var6910) && valor_csosn.equals(icmssn900)) {

                                                                vprod6910 = parsefloat + vprod6910;
                                                                total_outras6910 = vprod6910 + voutroverif6910 - vdesc6910;
                                                                valor_total_nota6910 = vprod6910 + voutroverif6910 - vdesc6910;

                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST6102">
                                                            if (cfop.equals(var6102) && valor_csosn.equals(icmssn101) || cfop.equals(var6102) && valor_csosn.equals(icmssn102)
                                                                    || cfop.equals(var6102) && valor_csosn.equals(icmssn103) || cfop.equals(var6102) && valor_csosn.equals(icmssn3) || cfop.equals(var6102) && valor_csosn.equals(icmssn201)
                                                                    || cfop.equals(var6102) && valor_csosn.equals(icmssn202) || cfop.equals(var6102) && valor_csosn.equals(icmssn203) || cfop.equals(var6102) && valor_csosn.equals(icmssn203)
                                                                    || cfop.equals(var6102) && valor_csosn.equals(icmssn500) || cfop.equals(var6102) && valor_csosn.equals(icmssn900)) {

                                                                vprod6102 = parsefloat + vprod6102;
                                                                total_outras6102 = vprod6102 + voutroverif6102 - vdesc6102;
                                                                valor_total_nota6102 = vprod6102 + voutroverif6102 - vdesc6102;

                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST5911">
                                                            if (cfop.equals(5911) && valor_csosn.equals(icmssn101) || cfop.equals(5911) && valor_csosn.equals(icmssn102)
                                                                    || cfop.equals(5911) && valor_csosn.equals(icmssn103) || cfop.equals(5911) && valor_csosn.equals(icmssn3) || cfop.equals(5911) && valor_csosn.equals(icmssn201)
                                                                    || cfop.equals(5911) && valor_csosn.equals(icmssn202) || cfop.equals(5911) && valor_csosn.equals(icmssn203) || cfop.equals(5911) && valor_csosn.equals(icmssn203)
                                                                    || cfop.equals(5911) && valor_csosn.equals(icmssn500) || cfop.equals(5911) && valor_csosn.equals(icmssn900) || cfop.equals(5929) && valor_csosn.equals(icmssn300) || cfop.equals(5929) && valor_csosn.equals(icmssn400)) {
                                                                vprod5911 = parsefloat + vprod5911;
                                                                valor_total_nota5911 = vprod5911 + voutroverif5911 - vdesc5911;
                                                                total_outras5911 = vprod5911 + voutroverif5911 - vdesc5911;
                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST5106">
                                                            if (cfop.equals(5106) && valor_csosn.equals(icmssn101) || cfop.equals(5106) && valor_csosn.equals(icmssn102)
                                                                    || cfop.equals(5106) && valor_csosn.equals(icmssn103) || cfop.equals(5106) && valor_csosn.equals(icmssn3) || cfop.equals(5106) && valor_csosn.equals(icmssn201)
                                                                    || cfop.equals(5106) && valor_csosn.equals(icmssn202) || cfop.equals(5106) && valor_csosn.equals(icmssn203) || cfop.equals(5106) && valor_csosn.equals(icmssn203)
                                                                    || cfop.equals(5106) && valor_csosn.equals(icmssn500) || cfop.equals(5106) && valor_csosn.equals(icmssn900) || cfop.equals(5929) && valor_csosn.equals(icmssn300) || cfop.equals(5929) && valor_csosn.equals(icmssn400)) {
                                                                vprod5106 = parsefloat + vprod5106;
                                                                valor_total_nota5106 = vprod5106 + voutroverif5106 - vdesc5106;
                                                                total_outras5106 = vprod5106 + voutroverif5106 - vdesc5106;
                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST5105">
                                                            if (cfop.equals(5105) && valor_csosn.equals(icmssn101) || cfop.equals(5105) && valor_csosn.equals(icmssn102)
                                                                    || cfop.equals(5105) && valor_csosn.equals(icmssn103) || cfop.equals(5105) && valor_csosn.equals(icmssn3) || cfop.equals(5105) && valor_csosn.equals(icmssn201)
                                                                    || cfop.equals(5105) && valor_csosn.equals(icmssn202) || cfop.equals(5105) && valor_csosn.equals(icmssn203) || cfop.equals(5105) && valor_csosn.equals(icmssn203)
                                                                    || cfop.equals(5105) && valor_csosn.equals(icmssn500) || cfop.equals(5105) && valor_csosn.equals(icmssn900) || cfop.equals(5929) && valor_csosn.equals(icmssn300) || cfop.equals(5929) && valor_csosn.equals(icmssn400)) {
                                                                vprod5105 = parsefloat + vprod5105;
                                                                valor_total_nota5105 = vprod5105 + voutroverif5105 - vdesc5105;
                                                                total_outras5105 = vprod5105 + voutroverif5105 - vdesc5105;
                                                            }
                                                            //</editor-fold>

                                                            break;
                                                        //</editor-fold>

                                                    }
                                                }
                                            }
                                        /* txtAreaExemplo.appendText(NCM);
                                            con = ConnectionFactory.getConnection();
                                            sql = "SELECT * FROM camargo";
                                            st = con.prepareStatement(sql);
                                            rs = st.executeQuery();
                                            while (rs.next()) {
                                                retorno_ncm = rs.getString("ncm");
                                                if (NCM.equals(retorno_ncm)) {
                                                    txtAreaExemplo.appendText("-------------------------");
                                                    retorno_produto = rs.getString("codigo_produto");
                                                    txtAreaExemplo.appendText(retorno_produto);
                                                    txtAreaExemplo.appendText("-------------------------");
                                                }
                                            }
                                            ConnectionFactory.closeConnection(con, st, rs);*/
                                    }

                                }

                            }
                        }

                    }
                }

            }
//</editor-fold>

            // <editor-fold defaultstate="collapsed" desc="DESDOBRAMENTO 5405">
            if (flag5405 == 1) {
                desdo++;

                saida5405 = desdo;

            }

            //</editor-fold>
            // <editor-fold defaultstate="collapsed" desc="DESDOBRAMENTO 5102">
            if (flag5102 == 1) {
                desdo++;
                saida5102 = desdo;

            }

            //</editor-fold>
            // <editor-fold defaultstate="collapsed" desc="DESDOBRAMENTO 5101">
            if (flag5101 == 1) {

                desdo++;
                saida5101 = desdo;

            }

            //</editor-fold>
            // <editor-fold defaultstate="collapsed" desc="DESDOBRAMENTO 5949">
            if (flag5949 == 1) {

                desdo++;
                saida5949 = desdo;
            }

            //</editor-fold>
            // <editor-fold defaultstate="collapsed" desc="DESDOBRAMENTO 5403">
            if (flag5403 == 1) {

                desdo++;
                saida5403 = desdo;
            }

            //</editor-fold>
            // <editor-fold defaultstate="collapsed" desc="DESDOBRAMENTO 5104">
            if (flag5104 == 1) {

                desdo++;
                saida5104 = desdo;
            }

            //</editor-fold>
            // <editor-fold defaultstate="collapsed" desc="DESDOBRAMENTO 5401">
            if (flag5401 == 1) {

                desdo++;
                saida5401 = desdo;

            }

            //</editor-fold> 
            // <editor-fold defaultstate="collapsed" desc="DESDOBRAMENTO 5910">
            if (flag5910 == 1) {
                desdo++;
                saida5910 = desdo;
            }

            //</editor-fold>
            // <editor-fold defaultstate="collapsed" desc="DESDOBRAMENTO 1411">
            if (flag1411 == 1) {
                desdo++;
                saida1411 = desdo;
            }

            //</editor-fold>
            // <editor-fold defaultstate="collapsed" desc="DESDOBRAMENTO 5929">
            if (flag5929 == 1) {
                desdo++;

                saida5929 = desdo;

            }

            //</editor-fold>
            // <editor-fold defaultstate="collapsed" desc="DESDOBRAMENTO 1410">
            if (flag1410 == 1) {
                desdo++;
                saida1410 = desdo;
            }

            //</editor-fold>
            // <editor-fold defaultstate="collapsed" desc="DESDOBRAMENTO 6910">
            if (flag6910 == 1) {
                desdo++;
                saida6910 = desdo;
            }

            //</editor-fold>
            // <editor-fold defaultstate="collapsed" desc="DESDOBRAMENTO 6102">
            if (flag6102 == 1) {
                desdo++;
                saida6102 = desdo;
            }

            //</editor-fold>
            // <editor-fold defaultstate="collapsed" desc="DESDOBRAMENTO 5911">
            if (flag5911 == 1) {
                desdo++;
                saida5911 = desdo;
            }

            //</editor-fold>
            // <editor-fold defaultstate="collapsed" desc="DESDOBRAMENTO 5106">
            if (flag5106 == 1) {
                desdo++;
                saida5106 = desdo;
            }

            //</editor-fold>
            // <editor-fold defaultstate="collapsed" desc="DESDOBRAMENTO 5105">
            if (flag5105 == 1) {
                desdo++;
                saida5105 = desdo;
            }

            //</editor-fold>
            desdo = 0;

            // <editor-fold defaultstate="collapsed" desc="SAÍDA DAS INFORMAÇÕES">
            // <editor-fold defaultstate="collapsed" desc="SAÍDA5405">
            if (flag5405 == 0) {

            } else {

                // <editor-fold defaultstate="collapsed" desc="CONDIÇÃO VDESC FORMAT">
                if (vdesc5405 == 0) {
                    format_vdesc = new DecimalFormat("00000000000000");
                } else {
                    if (vdesc5405 != 0) {
                        format_vdesc = new DecimalFormat("00000000000.00");
                    }
                }
                //</editor-fold>   

                txtAreaExemplo.appendText("    " + cnp + emi + emi + "            " + saida5405 + "        " + df.format(vprod5405).replace(",", ".") + df.format(base_calculo_icms).replace(",", ".") + df.format(icms_creditado).replace(",", ".") + df.format(isentas_naotributadas).replace(",", ".") + df.format(total_outras5405).replace(",", ".") + df.format(ipi_nao_creditado).replace(",", ".") + aliquo_icms.format(aliquota_icms).replace(",", ".") + df.format(base_calculo_ipi).replace(",", ".") + df.format(ipi_creditado).replace(",", ".") + df.format(ipi_creditado_50).replace(",", ".") + df.format(isentas_naotributadas_zerado).replace(",", ".") + df.format(outras_zerado).replace(",", ".") + df.format(valor_total_nota5405).replace(",", ".") + "1" + "     " + sit_especial.format(sit_especial_valor1).replace(",", ".") + sit_especial.format(sit_especial_valor2).replace(",", ".") + sit_especial.format(sit_especial_valor3).replace(",", ".") + sit_especial.format(sit_especial_valor4).replace(",", ".") + "                                                                                                                                                                                                                            "
                        + "" + insc_estadual + espaco + un_federal + "1" + "                                                                                                        " + cfopat1403 + cod_municipal + "                                                                                                                                            " + df.format(base_calc_subst_tribut).replace(",", ".") + df.format(imposto_retido_subst_tribut).replace(",", ".") + "      " + "0" + "      " + df.format(valor_frete).replace(",", ".") + df.format(valor_seguro).replace(",", ".") + df.format(voutroverif5405).replace(",", ".") + "NF-E" + " " + "0" + "1" + "    " + format_num_doc.format(float_num_doc) + "00000000000000000000" + "        " + hora_emi + "        " + "00000000000000000000000000000000000000000000000000" + nfe + "                                                                         " + "0" + "                                   " + format_vdesc.format(vdesc5405).replace(",", ".") + "00" + "                        " + "1" + "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                " + "000000000.000000.00000000000.00" + sit_especial.format(outras5405).replace(",", ".") + "    " + "000.0000" + "                    " + "00000000000000.000000000000000.000000000000000.000000000000000.00" + "\n");

            }
            //</editor-fold>

            // <editor-fold defaultstate="collapsed" desc="SAÍDA5102">
            if (flag5102 == 0) {

            } else {

                // <editor-fold defaultstate="collapsed" desc="CONDIÇÃO VDESC FORMAT">
                if (vdesc5102 == 0) {
                    format_vdesc = new DecimalFormat("00000000000000");
                } else {
                    if (vdesc5102 != 0) {
                        format_vdesc = new DecimalFormat("00000000000.00");
                    }
                }
                //</editor-fold>
                // <editor-fold defaultstate="collapsed" desc="CONDIÇÃO ISENTAS NAO TRIBUTADAS">

                if (valor_isentas_naotributadas5102 != 0) {
                    valor_total_outras5102 = vprod5102 + voutroverif5102 - vdesc5102 - valor_isentas_naotributadas5102;

                }
                //</editor-fold>

                txtAreaExemplo.appendText("    " + cnp + emi + emi + "            " + saida5102 + "        " + df.format(vprod5102).replace(",", ".") + df.format(base_calculo_icms).replace(",", ".") + df.format(icms_creditado).replace(",", ".") + df.format(valor_isentas_naotributadas5102).replace(",", ".") + df.format(total_outras5102).replace(",", ".").replace("-", "") + df.format(ipi_nao_creditado).replace(",", ".") + aliquo_icms.format(aliquota_icms).replace(",", ".") + df.format(base_calculo_ipi).replace(",", ".") + df.format(ipi_creditado).replace(",", ".") + df.format(ipi_creditado_50).replace(",", ".") + df.format(isentas_naotributadas_zerado).replace(",", ".") + df.format(outras_zerado).replace(",", ".") + df.format(valor_total_nota5102).replace(",", ".") + "1" + "     " + sit_especial.format(sit_especial_valor1).replace(",", ".") + sit_especial.format(sit_especial_valor2).replace(",", ".") + sit_especial.format(sit_especial_valor3).replace(",", ".") + sit_especial.format(sit_especial_valor4).replace(",", ".") + "                                                                                                                                                                                                                            "
                        + "" + insc_estadual + espaco + un_federal + "1" + "                                                                                                        " + cfopat1102 + cod_municipal + "                                                                                                                                            " + df.format(base_calc_subst_tribut).replace(",", ".") + df.format(imposto_retido_subst_tribut).replace(",", ".") + "      " + "0" + "      " + df.format(valor_frete).replace(",", ".") + df.format(valor_seguro).replace(",", ".") + df.format(voutroverif5102).replace(",", ".") + "NF-E" + " " + "0" + "1" + "    " + format_num_doc.format(float_num_doc) + "00000000000000000000" + "        " + hora_emi + "        " + "00000000000000000000000000000000000000000000000000" + nfe + "                                                                         " + "0" + "                                   " + format_vdesc.format(vdesc5102).replace(",", ".") + "00" + "                        " + "1" + "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                " + "000000000.000000.00000000000.00" + sit_especial.format(outras5102).replace(",", ".") + "    " + "000.0000" + "                    " + "00000000000000.000000000000000.000000000000000.000000000000000.00" + "\n");

            }
            //</editor-fold>

            // <editor-fold defaultstate="collapsed" desc="SAÍDA5101">
            if (flag5101 == 0) {

            } else {

                // <editor-fold defaultstate="collapsed" desc="CONDIÇÃO VDESC FORMAT">
                if (vdesc5101 == 0) {
                    format_vdesc = new DecimalFormat("00000000000000");
                } else {
                    if (vdesc5101 != 0) {
                        format_vdesc = new DecimalFormat("00000000000.00");
                    }
                }
                //</editor-fold>
                // <editor-fold defaultstate="collapsed" desc="CONDIÇÃO ISENTAS NAO TRIBUTADAS">

                if (valor_isentas_naotributadas5101 != 0) {
                    valor_total_outras5101 = vprod5101 + voutroverif5101 - vdesc5101 - valor_isentas_naotributadas5101;

                }
                //</editor-fold>

                txtAreaExemplo.appendText("    " + cnp + emi + emi + "            " + saida5101 + "        " + df.format(vprod5101).replace(",", ".") + df.format(base_calculo_icms).replace(",", ".") + df.format(icms_creditado).replace(",", ".") + df.format(valor_isentas_naotributadas5101).replace(",", ".") + df.format(total_outras5101).replace(",", ".").replace("-", "") + df.format(ipi_nao_creditado).replace(",", ".") + aliquo_icms.format(aliquota_icms).replace(",", ".") + df.format(base_calculo_ipi).replace(",", ".") + df.format(ipi_creditado).replace(",", ".") + df.format(ipi_creditado_50).replace(",", ".") + df.format(isentas_naotributadas_zerado).replace(",", ".") + df.format(outras_zerado).replace(",", ".") + df.format(valor_total_nota5101).replace(",", ".") + "1" + "     " + sit_especial.format(sit_especial_valor1).replace(",", ".") + sit_especial.format(sit_especial_valor2).replace(",", ".") + sit_especial.format(sit_especial_valor3).replace(",", ".") + sit_especial.format(sit_especial_valor4).replace(",", ".") + "                                                                                                                                                                                                                            "
                        + "" + insc_estadual + espaco + un_federal + "1" + "                                                                                                        " + cfopat1102 + cod_municipal + "                                                                                                                                            " + df.format(base_calc_subst_tribut).replace(",", ".") + df.format(imposto_retido_subst_tribut).replace(",", ".") + "      " + "0" + "      " + df.format(valor_frete).replace(",", ".") + df.format(valor_seguro).replace(",", ".") + df.format(voutroverif5101).replace(",", ".") + "NF-E" + " " + "0" + "1" + "    " + format_num_doc.format(float_num_doc) + "00000000000000000000" + "        " + hora_emi + "        " + "00000000000000000000000000000000000000000000000000" + nfe + "                                                                         " + "0" + "                                   " + format_vdesc.format(vdesc5101).replace(",", ".") + "00" + "                        " + "1" + "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                " + "000000000.000000.00000000000.00" + sit_especial.format(outras5101).replace(",", ".") + "    " + "000.0000" + "                    " + "00000000000000.000000000000000.000000000000000.000000000000000.00" + "\n");

            }
            //</editor-fold>

            // <editor-fold defaultstate="collapsed" desc="SAÍDA5949">
            if (flag5949 == 0) {

            } else {

                // <editor-fold defaultstate="collapsed" desc="CONDIÇÃO VDESC FORMAT">
                if (vdesc5949 == 0) {
                    format_vdesc = new DecimalFormat("00000000000000");
                } else {
                    if (vdesc5949 != 0) {
                        format_vdesc = new DecimalFormat("00000000000.00");
                    }
                }
                //</editor-fold>                        

                txtAreaExemplo.appendText("    " + cnp + emi + emi + "            " + saida5949 + "        " + df.format(vprod5949).replace(",", ".") + df.format(base_calculo_icms).replace(",", ".") + df.format(icms_creditado).replace(",", ".") + df.format(isentas_naotributadas).replace(",", ".") + df.format(total_outras5949).replace(",", ".") + df.format(ipi_nao_creditado).replace(",", ".") + aliquo_icms.format(aliquota_icms).replace(",", ".") + df.format(base_calculo_ipi).replace(",", ".") + df.format(ipi_creditado).replace(",", ".") + df.format(ipi_creditado_50).replace(",", ".") + df.format(isentas_naotributadas_zerado).replace(",", ".") + df.format(outras_zerado).replace(",", ".") + df.format(valor_total_nota5949).replace(",", ".") + "1" + "     " + sit_especial.format(sit_especial_valor1).replace(",", ".") + sit_especial.format(sit_especial_valor2).replace(",", ".") + sit_especial.format(sit_especial_valor3).replace(",", ".") + sit_especial.format(sit_especial_valor4).replace(",", ".") + "                                                                                                                                                                                                                            "
                        + "" + insc_estadual + espaco + un_federal + "1" + "                                                                                                        " + cfopat1949 + cod_municipal + "                                                                                                                                            " + df.format(base_calc_subst_tribut).replace(",", ".") + df.format(imposto_retido_subst_tribut).replace(",", ".") + "      " + "0" + "      " + df.format(valor_frete).replace(",", ".") + df.format(valor_seguro).replace(",", ".") + df.format(voutroverif5949).replace(",", ".") + "NF-E" + " " + "0" + "1" + "    " + format_num_doc.format(float_num_doc) + "00000000000000000000" + "        " + hora_emi + "        " + "00000000000000000000000000000000000000000000000000" + nfe + "                                                                         " + "0" + "                                   " + format_vdesc.format(vdesc5949).replace(",", ".") + "00" + "                        " + "1" + "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                " + "000000000.000000.00000000000.00" + sit_especial.format(outras5949).replace(",", ".") + "    " + "000.0000" + "                    " + "00000000000000.000000000000000.000000000000000.000000000000000.00" + "\n");

            }
            //</editor-fold>

            // <editor-fold defaultstate="collapsed" desc="SAÍDA5403">
            if (flag5403 == 0) {

            } else {

                // <editor-fold defaultstate="collapsed" desc="CONDIÇÃO VDESC FORMAT">
                if (vdesc5403 == 0) {
                    format_vdesc = new DecimalFormat("00000000000000");
                } else {
                    if (vdesc5403 != 0) {
                        format_vdesc = new DecimalFormat("00000000000.00");
                    }
                }
                //</editor-fold>                        

                txtAreaExemplo.appendText("    " + cnp + emi + emi + "            " + saida5403 + "        " + df.format(vprod5403).replace(",", ".") + df.format(base_calculo_icms).replace(",", ".") + df.format(icms_creditado).replace(",", ".") + df.format(isentas_naotributadas).replace(",", ".") + df.format(total_outras5403).replace(",", ".") + df.format(ipi_nao_creditado).replace(",", ".") + aliquo_icms.format(aliquota_icms).replace(",", ".") + df.format(base_calculo_ipi).replace(",", ".") + df.format(ipi_creditado).replace(",", ".") + df.format(ipi_creditado_50).replace(",", ".") + df.format(isentas_naotributadas_zerado).replace(",", ".") + df.format(outras_zerado).replace(",", ".") + df.format(valor_total_nota5403).replace(",", ".") + "1" + "     " + sit_especial.format(sit_especial_valor1).replace(",", ".") + sit_especial.format(sit_especial_valor2).replace(",", ".") + sit_especial.format(sit_especial_valor3).replace(",", ".") + sit_especial.format(sit_especial_valor4).replace(",", ".") + "                                                                                                                                                                                                                            "
                        + "" + insc_estadual + espaco + un_federal + "1" + "                                                                                                        " + cfopat1403 + cod_municipal + "                                                                                                                                            " + df.format(base_calc_subst_tribut).replace(",", ".") + df.format(imposto_retido_subst_tribut).replace(",", ".") + "      " + "0" + "      " + df.format(valor_frete).replace(",", ".") + df.format(valor_seguro).replace(",", ".") + df.format(voutroverif5403).replace(",", ".") + "NF-E" + " " + "0" + "1" + "    " + format_num_doc.format(float_num_doc) + "00000000000000000000" + "        " + hora_emi + "        " + "00000000000000000000000000000000000000000000000000" + nfe + "                                                                         " + "0" + "                                   " + format_vdesc.format(vdesc5403).replace(",", ".") + "00" + "                        " + "1" + "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                " + "000000000.000000.00000000000.00" + sit_especial.format(outras5403).replace(",", ".") + "    " + "000.0000" + "                    " + "00000000000000.000000000000000.000000000000000.000000000000000.00" + "\n");

            }
            //</editor-fold>

            // <editor-fold defaultstate="collapsed" desc="SAÍDA5104">
            if (flag5104 == 0) {

            } else {

                // <editor-fold defaultstate="collapsed" desc="CONDIÇÃO VDESC FORMAT">
                if (vdesc5104 == 0) {
                    format_vdesc = new DecimalFormat("00000000000000");
                } else {
                    if (vdesc5104 != 0) {
                        format_vdesc = new DecimalFormat("00000000000.00");
                    }
                }
                //</editor-fold>                        

                txtAreaExemplo.appendText("    " + cnp + emi + emi + "            " + saida5104 + "        " + df.format(vprod5104).replace(",", ".") + df.format(base_calculo_icms).replace(",", ".") + df.format(icms_creditado).replace(",", ".") + df.format(isentas_naotributadas).replace(",", ".") + df.format(total_outras5104).replace(",", ".") + df.format(ipi_nao_creditado).replace(",", ".") + aliquo_icms.format(aliquota_icms).replace(",", ".") + df.format(base_calculo_ipi).replace(",", ".") + df.format(ipi_creditado).replace(",", ".") + df.format(ipi_creditado_50).replace(",", ".") + df.format(isentas_naotributadas_zerado).replace(",", ".") + df.format(outras_zerado).replace(",", ".") + df.format(valor_total_nota5104).replace(",", ".") + "1" + "     " + sit_especial.format(sit_especial_valor1).replace(",", ".") + sit_especial.format(sit_especial_valor2).replace(",", ".") + sit_especial.format(sit_especial_valor3).replace(",", ".") + sit_especial.format(sit_especial_valor4).replace(",", ".") + "                                                                                                                                                                                                                            "
                        + "" + insc_estadual + espaco + un_federal + "1" + "                                                                                                        " + cfopat1403 + cod_municipal + "                                                                                                                                            " + df.format(base_calc_subst_tribut).replace(",", ".") + df.format(imposto_retido_subst_tribut).replace(",", ".") + "      " + "0" + "      " + df.format(valor_frete).replace(",", ".") + df.format(valor_seguro).replace(",", ".") + df.format(voutroverif5104).replace(",", ".") + "NF-E" + " " + "0" + "1" + "    " + format_num_doc.format(float_num_doc) + "00000000000000000000" + "        " + hora_emi + "        " + "00000000000000000000000000000000000000000000000000" + nfe + "                                                                         " + "0" + "                                   " + format_vdesc.format(vdesc5104).replace(",", ".") + "00" + "                        " + "1" + "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                " + "000000000.000000.00000000000.00" + sit_especial.format(outras5104).replace(",", ".") + "    " + "000.0000" + "                    " + "00000000000000.000000000000000.000000000000000.000000000000000.00" + "\n");

            }
            //</editor-fold> 

            // <editor-fold defaultstate="collapsed" desc="SAÍDA5401">
            if (flag5401 == 0) {

            } else {

                // <editor-fold defaultstate="collapsed" desc="CONDIÇÃO VDESC FORMAT">
                if (vdesc5401 == 0) {
                    format_vdesc = new DecimalFormat("00000000000000");
                } else {
                    if (vdesc5401 != 0) {
                        format_vdesc = new DecimalFormat("00000000000.00");
                    }
                }
                //</editor-fold>   

                txtAreaExemplo.appendText("    " + cnp + emi + emi + "            " + saida5401 + "        " + df.format(vprod5401).replace(",", ".") + df.format(base_calculo_icms).replace(",", ".") + df.format(icms_creditado).replace(",", ".") + df.format(isentas_naotributadas).replace(",", ".") + df.format(total_outras5401).replace(",", ".") + df.format(ipi_nao_creditado).replace(",", ".") + aliquo_icms.format(aliquota_icms).replace(",", ".") + df.format(base_calculo_ipi).replace(",", ".") + df.format(ipi_creditado).replace(",", ".") + df.format(ipi_creditado_50).replace(",", ".") + df.format(isentas_naotributadas_zerado).replace(",", ".") + df.format(outras_zerado).replace(",", ".") + df.format(valor_total_nota5401).replace(",", ".") + "1" + "     " + sit_especial.format(sit_especial_valor1).replace(",", ".") + sit_especial.format(sit_especial_valor2).replace(",", ".") + sit_especial.format(sit_especial_valor3).replace(",", ".") + sit_especial.format(sit_especial_valor4).replace(",", ".") + "                                                                                                                                                                                                                            "
                        + "" + insc_estadual + espaco + un_federal + "1" + "                                                                                                        " + cfopat1403 + cod_municipal + "                                                                                                                                            " + df.format(base_calc_subst_tribut).replace(",", ".") + df.format(imposto_retido_subst_tribut).replace(",", ".") + "      " + "0" + "      " + df.format(valor_frete).replace(",", ".") + df.format(valor_seguro).replace(",", ".") + df.format(voutroverif5401).replace(",", ".") + "NF-E" + " " + "0" + "1" + "    " + format_num_doc.format(float_num_doc) + "00000000000000000000" + "        " + hora_emi + "        " + "00000000000000000000000000000000000000000000000000" + nfe + "                                                                         " + "0" + "                                   " + format_vdesc.format(vdesc5401).replace(",", ".") + "00" + "                        " + "1" + "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                " + "000000000.000000.00000000000.00" + sit_especial.format(outras5401).replace(",", ".") + "    " + "000.0000" + "                    " + "00000000000000.000000000000000.000000000000000.000000000000000.00" + "\n");

            }
            //</editor-fold>

            // <editor-fold defaultstate="collapsed" desc="SAÍDA5910">
            if (flag5910 == 0) {

            } else {

                // <editor-fold defaultstate="collapsed" desc="CONDIÇÃO VDESC FORMAT">
                if (vdesc5910 == 0) {
                    format_vdesc = new DecimalFormat("00000000000000");
                } else {
                    if (vdesc5910 != 0) {
                        format_vdesc = new DecimalFormat("00000000000.00");
                    }
                }
                //</editor-fold>   

                txtAreaExemplo.appendText("    " + cnp + emi + emi + "            " + saida5910 + "        " + df.format(vprod5910).replace(",", ".") + df.format(base_calculo_icms).replace(",", ".") + df.format(icms_creditado).replace(",", ".") + df.format(isentas_naotributadas).replace(",", ".") + df.format(total_outras5910).replace(",", ".") + df.format(ipi_nao_creditado).replace(",", ".") + aliquo_icms.format(aliquota_icms).replace(",", ".") + df.format(base_calculo_ipi).replace(",", ".") + df.format(ipi_creditado).replace(",", ".") + df.format(ipi_creditado_50).replace(",", ".") + df.format(isentas_naotributadas_zerado).replace(",", ".") + df.format(outras_zerado).replace(",", ".") + df.format(valor_total_nota5910).replace(",", ".") + "1" + "     " + sit_especial.format(sit_especial_valor1).replace(",", ".") + sit_especial.format(sit_especial_valor2).replace(",", ".") + sit_especial.format(sit_especial_valor3).replace(",", ".") + sit_especial.format(sit_especial_valor4).replace(",", ".") + "                                                                                                                                                                                                                            "
                        + "" + insc_estadual + espaco + un_federal + "1" + "                                                                                                        " + cfopat1403 + cod_municipal + "                                                                                                                                            " + df.format(base_calc_subst_tribut).replace(",", ".") + df.format(imposto_retido_subst_tribut).replace(",", ".") + "      " + "0" + "      " + df.format(valor_frete).replace(",", ".") + df.format(valor_seguro).replace(",", ".") + df.format(voutroverif5910).replace(",", ".") + "NF-E" + " " + "0" + "1" + "    " + format_num_doc.format(float_num_doc) + "00000000000000000000" + "        " + hora_emi + "        " + "00000000000000000000000000000000000000000000000000" + nfe + "                                                                         " + "0" + "                                   " + format_vdesc.format(vdesc5910).replace(",", ".") + "00" + "                        " + "1" + "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                " + "000000000.000000.00000000000.00" + sit_especial.format(outras5910).replace(",", ".") + "    " + "000.0000" + "                    " + "00000000000000.000000000000000.000000000000000.000000000000000.00" + "\n");

            }
            //</editor-fold>

            // <editor-fold defaultstate="collapsed" desc="SAÍDA1411">
            if (flag1411 == 0) {

            } else {

                // <editor-fold defaultstate="collapsed" desc="CONDIÇÃO VDESC FORMAT">
                if (vdesc1411 == 0) {
                    format_vdesc = new DecimalFormat("00000000000000");
                } else {
                    if (vdesc1411 != 0) {
                        format_vdesc = new DecimalFormat("00000000000.00");
                    }
                }
                //</editor-fold>   

                txtAreaExemplo.appendText("    " + cnp + emi + emi + "            " + saida1411 + "        " + df.format(vprod1411).replace(",", ".") + df.format(base_calculo_icms).replace(",", ".") + df.format(icms_creditado).replace(",", ".") + df.format(isentas_naotributadas).replace(",", ".") + df.format(total_outras1411).replace(",", ".") + df.format(ipi_nao_creditado).replace(",", ".") + aliquo_icms.format(aliquota_icms).replace(",", ".") + df.format(base_calculo_ipi).replace(",", ".") + df.format(ipi_creditado).replace(",", ".") + df.format(ipi_creditado_50).replace(",", ".") + df.format(isentas_naotributadas_zerado).replace(",", ".") + df.format(outras_zerado).replace(",", ".") + df.format(valor_total_nota1411).replace(",", ".") + "1" + "     " + sit_especial.format(sit_especial_valor1).replace(",", ".") + sit_especial.format(sit_especial_valor2).replace(",", ".") + sit_especial.format(sit_especial_valor3).replace(",", ".") + sit_especial.format(sit_especial_valor4).replace(",", ".") + "                                                                                                                                                                                                                            "
                        + "" + insc_estadual + espaco + un_federal + "1" + "                                                                                                        " + cfopat1411 + cod_municipal + "                                                                                                                                            " + df.format(base_calc_subst_tribut).replace(",", ".") + df.format(imposto_retido_subst_tribut).replace(",", ".") + "      " + "0" + "      " + df.format(valor_frete).replace(",", ".") + df.format(valor_seguro).replace(",", ".") + df.format(voutroverif1411).replace(",", ".") + "NF-E" + " " + "0" + "1" + "    " + format_num_doc.format(float_num_doc) + "00000000000000000000" + "        " + hora_emi + "        " + "00000000000000000000000000000000000000000000000000" + nfe + "                                                                         " + "0" + "                                   " + format_vdesc.format(vdesc1411).replace(",", ".") + "00" + "                        " + "1" + "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                " + "000000000.000000.00000000000.00" + sit_especial.format(outras1411).replace(",", ".") + "    " + "000.0000" + "                    " + "00000000000000.000000000000000.000000000000000.000000000000000.00" + "\n");

            }
            //</editor-fold>

            // <editor-fold defaultstate="collapsed" desc="SAÍDA5929">
            if (flag5929 == 0) {

            } else {

                // <editor-fold defaultstate="collapsed" desc="CONDIÇÃO VDESC FORMAT">
                if (vdesc5929 == 0) {
                    format_vdesc = new DecimalFormat("00000000000000");
                } else {
                    if (vdesc5929 != 0) {
                        format_vdesc = new DecimalFormat("00000000000.00");
                    }
                }
                //</editor-fold>   

                txtAreaExemplo.appendText("    " + cnp + emi + emi + "            " + saida5929 + "        " + df.format(vprod5929).replace(",", ".") + df.format(base_calculo_icms).replace(",", ".") + df.format(icms_creditado).replace(",", ".") + df.format(isentas_naotributadas).replace(",", ".") + df.format(total_outras5929).replace(",", ".") + df.format(ipi_nao_creditado).replace(",", ".") + aliquo_icms.format(aliquota_icms).replace(",", ".") + df.format(base_calculo_ipi).replace(",", ".") + df.format(ipi_creditado).replace(",", ".") + df.format(ipi_creditado_50).replace(",", ".") + df.format(isentas_naotributadas_zerado).replace(",", ".") + df.format(outras_zerado).replace(",", ".") + df.format(valor_total_nota5929).replace(",", ".") + "1" + "     " + sit_especial.format(sit_especial_valor1).replace(",", ".") + sit_especial.format(sit_especial_valor2).replace(",", ".") + sit_especial.format(sit_especial_valor3).replace(",", ".") + sit_especial.format(sit_especial_valor4).replace(",", ".") + "                                                                                                                                                                                                                            "
                        + "" + insc_estadual + espaco + un_federal + "1" + "                                                                                                        " + cfopat1949 + cod_municipal + "                                                                                                                                            " + df.format(base_calc_subst_tribut).replace(",", ".") + df.format(imposto_retido_subst_tribut).replace(",", ".") + "      " + "0" + "      " + df.format(valor_frete).replace(",", ".") + df.format(valor_seguro).replace(",", ".") + df.format(voutroverif5929).replace(",", ".") + "NF-E" + " " + "0" + "1" + "    " + format_num_doc.format(float_num_doc) + "00000000000000000000" + "        " + hora_emi + "        " + "00000000000000000000000000000000000000000000000000" + nfe + "                                                                         " + "0" + "                                   " + format_vdesc.format(vdesc5929).replace(",", ".") + "00" + "                        " + "1" + "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                " + "000000000.000000.00000000000.00" + sit_especial.format(outras5929).replace(",", ".") + "    " + "000.0000" + "                    " + "00000000000000.000000000000000.000000000000000.000000000000000.00" + "\n");

            }
            //</editor-fold>

            // <editor-fold defaultstate="collapsed" desc="SAÍDA1410">
            if (flag1410 == 0) {

            } else {

                // <editor-fold defaultstate="collapsed" desc="CONDIÇÃO VDESC FORMAT">
                if (vdesc1410 == 0) {
                    format_vdesc = new DecimalFormat("00000000000000");
                } else {
                    if (vdesc1410 != 0) {
                        format_vdesc = new DecimalFormat("00000000000.00");
                    }
                }
                //</editor-fold>   

                txtAreaExemplo.appendText("    " + cnp + emi + emi + "            " + saida1410 + "        " + df.format(vprod1410).replace(",", ".") + df.format(base_calculo_icms).replace(",", ".") + df.format(icms_creditado).replace(",", ".") + df.format(isentas_naotributadas).replace(",", ".") + df.format(total_outras1410).replace(",", ".") + df.format(ipi_nao_creditado).replace(",", ".") + aliquo_icms.format(aliquota_icms).replace(",", ".") + df.format(base_calculo_ipi).replace(",", ".") + df.format(ipi_creditado).replace(",", ".") + df.format(ipi_creditado_50).replace(",", ".") + df.format(isentas_naotributadas_zerado).replace(",", ".") + df.format(outras_zerado).replace(",", ".") + df.format(valor_total_nota1410).replace(",", ".") + "1" + "     " + sit_especial.format(sit_especial_valor1).replace(",", ".") + sit_especial.format(sit_especial_valor2).replace(",", ".") + sit_especial.format(sit_especial_valor3).replace(",", ".") + sit_especial.format(sit_especial_valor4).replace(",", ".") + "                                                                                                                                                                                                                            "
                        + "" + insc_estadual + espaco + un_federal + "1" + "                                                                                                        " + cfopat1410 + cod_municipal + "                                                                                                                                            " + df.format(base_calc_subst_tribut).replace(",", ".") + df.format(imposto_retido_subst_tribut).replace(",", ".") + "      " + "0" + "      " + df.format(valor_frete).replace(",", ".") + df.format(valor_seguro).replace(",", ".") + df.format(voutroverif1410).replace(",", ".") + "NF-E" + " " + "0" + "1" + "    " + format_num_doc.format(float_num_doc) + "00000000000000000000" + "        " + hora_emi + "        " + "00000000000000000000000000000000000000000000000000" + nfe + "                                                                         " + "0" + "                                   " + format_vdesc.format(vdesc1410).replace(",", ".") + "00" + "                        " + "1" + "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                " + "000000000.000000.00000000000.00" + sit_especial.format(outras1410).replace(",", ".") + "    " + "000.0000" + "                    " + "00000000000000.000000000000000.000000000000000.000000000000000.00" + "\n");

            }
            //</editor-fold>

            // <editor-fold defaultstate="collapsed" desc="SAÍDA6910">
            if (flag6910 == 0) {

            } else {

                // <editor-fold defaultstate="collapsed" desc="CONDIÇÃO VDESC FORMAT">
                if (vdesc6910 == 0) {
                    format_vdesc = new DecimalFormat("00000000000000");
                } else {
                    if (vdesc6910 != 0) {
                        format_vdesc = new DecimalFormat("00000000000.00");
                    }
                }
                //</editor-fold>   

                txtAreaExemplo.appendText("    " + cnp + emi + emi + "            " + saida6910 + "        " + df.format(vprod6910).replace(",", ".") + df.format(base_calculo_icms).replace(",", ".") + df.format(icms_creditado).replace(",", ".") + df.format(isentas_naotributadas).replace(",", ".") + df.format(total_outras6910).replace(",", ".") + df.format(ipi_nao_creditado).replace(",", ".") + aliquo_icms.format(aliquota_icms).replace(",", ".") + df.format(base_calculo_ipi).replace(",", ".") + df.format(ipi_creditado).replace(",", ".") + df.format(ipi_creditado_50).replace(",", ".") + df.format(isentas_naotributadas_zerado).replace(",", ".") + df.format(outras_zerado).replace(",", ".") + df.format(valor_total_nota6910).replace(",", ".") + "1" + "     " + sit_especial.format(sit_especial_valor1).replace(",", ".") + sit_especial.format(sit_especial_valor2).replace(",", ".") + sit_especial.format(sit_especial_valor3).replace(",", ".") + sit_especial.format(sit_especial_valor4).replace(",", ".") + "                                                                                                                                                                                                                            "
                        + "" + insc_estadual + espaco + un_federal + "1" + "                                                                                                        " + cfopat2910 + cod_municipal + "                                                                                                                                            " + df.format(base_calc_subst_tribut).replace(",", ".") + df.format(imposto_retido_subst_tribut).replace(",", ".") + "      " + "0" + "      " + df.format(valor_frete).replace(",", ".") + df.format(valor_seguro).replace(",", ".") + df.format(voutroverif6910).replace(",", ".") + "NF-E" + " " + "0" + "1" + "    " + format_num_doc.format(float_num_doc) + "00000000000000000000" + "        " + hora_emi + "        " + "00000000000000000000000000000000000000000000000000" + nfe + "                                                                         " + "0" + "                                   " + format_vdesc.format(vdesc6910).replace(",", ".") + "00" + "                        " + "1" + "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                " + "000000000.000000.00000000000.00" + sit_especial.format(outras6910).replace(",", ".") + "    " + "000.0000" + "                    " + "00000000000000.000000000000000.000000000000000.000000000000000.00" + "\n");

            }
            //</editor-fold>

            // <editor-fold defaultstate="collapsed" desc="SAÍDA6102">
            if (flag6102 == 0) {

            } else {

                // <editor-fold defaultstate="collapsed" desc="CONDIÇÃO VDESC FORMAT">
                if (vdesc6102 == 0) {
                    format_vdesc = new DecimalFormat("00000000000000");
                } else {
                    if (vdesc6102 != 0) {
                        format_vdesc = new DecimalFormat("00000000000.00");
                    }
                }
                //</editor-fold>   

                txtAreaExemplo.appendText("    " + cnp + emi + emi + "            " + saida6102 + "        " + df.format(vprod6102).replace(",", ".") + df.format(base_calculo_icms).replace(",", ".") + df.format(icms_creditado).replace(",", ".") + df.format(isentas_naotributadas).replace(",", ".") + df.format(total_outras6102).replace(",", ".") + df.format(ipi_nao_creditado).replace(",", ".") + aliquo_icms.format(aliquota_icms).replace(",", ".") + df.format(base_calculo_ipi).replace(",", ".") + df.format(ipi_creditado).replace(",", ".") + df.format(ipi_creditado_50).replace(",", ".") + df.format(isentas_naotributadas_zerado).replace(",", ".") + df.format(outras_zerado).replace(",", ".") + df.format(valor_total_nota6102).replace(",", ".") + "1" + "     " + sit_especial.format(sit_especial_valor1).replace(",", ".") + sit_especial.format(sit_especial_valor2).replace(",", ".") + sit_especial.format(sit_especial_valor3).replace(",", ".") + sit_especial.format(sit_especial_valor4).replace(",", ".") + "                                                                                                                                                                                                                            "
                        + "" + insc_estadual + espaco + un_federal + "1" + "                                                                                                        " + cfopat2102 + cod_municipal + "                                                                                                                                            " + df.format(base_calc_subst_tribut).replace(",", ".") + df.format(imposto_retido_subst_tribut).replace(",", ".") + "      " + "0" + "      " + df.format(valor_frete).replace(",", ".") + df.format(valor_seguro).replace(",", ".") + df.format(voutroverif6102).replace(",", ".") + "NF-E" + " " + "0" + "1" + "    " + format_num_doc.format(float_num_doc) + "00000000000000000000" + "        " + hora_emi + "        " + "00000000000000000000000000000000000000000000000000" + nfe + "                                                                         " + "0" + "                                   " + format_vdesc.format(vdesc6102).replace(",", ".") + "00" + "                        " + "1" + "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                " + "000000000.000000.00000000000.00" + sit_especial.format(outras6102).replace(",", ".") + "    " + "000.0000" + "                    " + "00000000000000.000000000000000.000000000000000.000000000000000.00" + "\n");

            }
            //</editor-fold>

            // <editor-fold defaultstate="collapsed" desc="SAÍDA5911">
            if (flag5911 == 0) {

            } else {

                // <editor-fold defaultstate="collapsed" desc="CONDIÇÃO VDESC FORMAT">
                if (vdesc5911 == 0) {
                    format_vdesc = new DecimalFormat("00000000000000");
                } else {
                    if (vdesc5911 != 0) {
                        format_vdesc = new DecimalFormat("00000000000.00");
                    }
                }
                //</editor-fold>   

                txtAreaExemplo.appendText("    " + cnp + emi + emi + "            " + saida5911 + "        " + df.format(vprod5911).replace(",", ".") + df.format(base_calculo_icms).replace(",", ".") + df.format(icms_creditado).replace(",", ".") + df.format(isentas_naotributadas).replace(",", ".") + df.format(total_outras5911).replace(",", ".") + df.format(ipi_nao_creditado).replace(",", ".") + aliquo_icms.format(aliquota_icms).replace(",", ".") + df.format(base_calculo_ipi).replace(",", ".") + df.format(ipi_creditado).replace(",", ".") + df.format(ipi_creditado_50).replace(",", ".") + df.format(isentas_naotributadas_zerado).replace(",", ".") + df.format(outras_zerado).replace(",", ".") + df.format(valor_total_nota5911).replace(",", ".") + "1" + "     " + sit_especial.format(sit_especial_valor1).replace(",", ".") + sit_especial.format(sit_especial_valor2).replace(",", ".") + sit_especial.format(sit_especial_valor3).replace(",", ".") + sit_especial.format(sit_especial_valor4).replace(",", ".") + "                                                                                                                                                                                                                            "
                        + "" + insc_estadual + espaco + un_federal + "1" + "                                                                                                        " + cfopat1911 + cod_municipal + "                                                                                                                                            " + df.format(base_calc_subst_tribut).replace(",", ".") + df.format(imposto_retido_subst_tribut).replace(",", ".") + "      " + "0" + "      " + df.format(valor_frete).replace(",", ".") + df.format(valor_seguro).replace(",", ".") + df.format(voutroverif5911).replace(",", ".") + "NF-E" + " " + "0" + "1" + "    " + format_num_doc.format(float_num_doc) + "00000000000000000000" + "        " + hora_emi + "        " + "00000000000000000000000000000000000000000000000000" + nfe + "                                                                         " + "0" + "                                   " + format_vdesc.format(vdesc5911).replace(",", ".") + "00" + "                        " + "1" + "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                " + "000000000.000000.00000000000.00" + sit_especial.format(outras5911).replace(",", ".") + "    " + "000.0000" + "                    " + "00000000000000.000000000000000.000000000000000.000000000000000.00" + "\n");

            }
            //</editor-fold>

            // <editor-fold defaultstate="collapsed" desc="SAÍDA5106">
            if (flag5106 == 0) {

            } else {

                // <editor-fold defaultstate="collapsed" desc="CONDIÇÃO VDESC FORMAT">
                if (vdesc5106 == 0) {
                    format_vdesc = new DecimalFormat("00000000000000");
                } else {
                    if (vdesc5106 != 0) {
                        format_vdesc = new DecimalFormat("00000000000.00");
                    }
                }
                //</editor-fold>   

                txtAreaExemplo.appendText("    " + cnp + emi + emi + "            " + saida5106 + "        " + df.format(vprod5106).replace(",", ".") + df.format(base_calculo_icms).replace(",", ".") + df.format(icms_creditado).replace(",", ".") + df.format(isentas_naotributadas).replace(",", ".") + df.format(total_outras5106).replace(",", ".") + df.format(ipi_nao_creditado).replace(",", ".") + aliquo_icms.format(aliquota_icms).replace(",", ".") + df.format(base_calculo_ipi).replace(",", ".") + df.format(ipi_creditado).replace(",", ".") + df.format(ipi_creditado_50).replace(",", ".") + df.format(isentas_naotributadas_zerado).replace(",", ".") + df.format(outras_zerado).replace(",", ".") + df.format(valor_total_nota5106).replace(",", ".") + "1" + "     " + sit_especial.format(sit_especial_valor1).replace(",", ".") + sit_especial.format(sit_especial_valor2).replace(",", ".") + sit_especial.format(sit_especial_valor3).replace(",", ".") + sit_especial.format(sit_especial_valor4).replace(",", ".") + "                                                                                                                                                                                                                            "
                        + "" + insc_estadual + espaco + un_federal + "1" + "                                                                                                        " + cfopat1102 + cod_municipal + "                                                                                                                                            " + df.format(base_calc_subst_tribut).replace(",", ".") + df.format(imposto_retido_subst_tribut).replace(",", ".") + "      " + "0" + "      " + df.format(valor_frete).replace(",", ".") + df.format(valor_seguro).replace(",", ".") + df.format(voutroverif5106).replace(",", ".") + "NF-E" + " " + "0" + "1" + "    " + format_num_doc.format(float_num_doc) + "00000000000000000000" + "        " + hora_emi + "        " + "00000000000000000000000000000000000000000000000000" + nfe + "                                                                         " + "0" + "                                   " + format_vdesc.format(vdesc5106).replace(",", ".") + "00" + "                        " + "1" + "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                " + "000000000.000000.00000000000.00" + sit_especial.format(outras5106).replace(",", ".") + "    " + "000.0000" + "                    " + "00000000000000.000000000000000.000000000000000.000000000000000.00" + "\n");

            }
            //</editor-fold>

            // <editor-fold defaultstate="collapsed" desc="SAÍDA5105">
            if (flag5105 == 0) {

            } else {

                // <editor-fold defaultstate="collapsed" desc="CONDIÇÃO VDESC FORMAT">
                if (vdesc5105 == 0) {
                    format_vdesc = new DecimalFormat("00000000000000");
                } else {
                    if (vdesc5105 != 0) {
                        format_vdesc = new DecimalFormat("00000000000.00");
                    }
                }
                //</editor-fold>   

                txtAreaExemplo.appendText("    " + cnp + emi + emi + "            " + saida5105 + "        " + df.format(vprod5105).replace(",", ".") + df.format(base_calculo_icms).replace(",", ".") + df.format(icms_creditado).replace(",", ".") + df.format(isentas_naotributadas).replace(",", ".") + df.format(total_outras5105).replace(",", ".") + df.format(ipi_nao_creditado).replace(",", ".") + aliquo_icms.format(aliquota_icms).replace(",", ".") + df.format(base_calculo_ipi).replace(",", ".") + df.format(ipi_creditado).replace(",", ".") + df.format(ipi_creditado_50).replace(",", ".") + df.format(isentas_naotributadas_zerado).replace(",", ".") + df.format(outras_zerado).replace(",", ".") + df.format(valor_total_nota5105).replace(",", ".") + "1" + "     " + sit_especial.format(sit_especial_valor1).replace(",", ".") + sit_especial.format(sit_especial_valor2).replace(",", ".") + sit_especial.format(sit_especial_valor3).replace(",", ".") + sit_especial.format(sit_especial_valor4).replace(",", ".") + "                                                                                                                                                                                                                            "
                        + "" + insc_estadual + espaco + un_federal + "1" + "                                                                                                        " + cfopat1102 + cod_municipal + "                                                                                                                                            " + df.format(base_calc_subst_tribut).replace(",", ".") + df.format(imposto_retido_subst_tribut).replace(",", ".") + "      " + "0" + "      " + df.format(valor_frete).replace(",", ".") + df.format(valor_seguro).replace(",", ".") + df.format(voutroverif5105).replace(",", ".") + "NF-E" + " " + "0" + "1" + "    " + format_num_doc.format(float_num_doc) + "00000000000000000000" + "        " + hora_emi + "        " + "00000000000000000000000000000000000000000000000000" + nfe + "                                                                         " + "0" + "                                   " + format_vdesc.format(vdesc5105).replace(",", ".") + "00" + "                        " + "1" + "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                " + "000000000.000000.00000000000.00" + sit_especial.format(outras5105).replace(",", ".") + "    " + "000.0000" + "                    " + "00000000000000.000000000000000.000000000000000.000000000000000.00" + "\n");

            }
            //</editor-fold>
//</editor-fold>

            // <editor-fold defaultstate="collapsed" desc="ZERANDO VARIAVEIS">
            flag5405 = 0;
            flag5102 = 0;
            flag5101 = 0;
            flag5949 = 0;
            flag5403 = 0;
            flag5104 = 0;
            flag5401 = 0;
            flag5911 = 0;
            flag1411 = 0;
            flag5929 = 0;
            flag1410 = 0;
            flag6910 = 0;
            flag6102 = 0;
            flag5910 = 0;
            flag5106 = 0;
            flag5105 = 0;

            vprod5405 = 0;
            valor_total_nota5405 = 0;
            vdesc5405 = 0;
            total_outras5405 = 0;
            outras5405 = 0;
            voutroverif5405 = 0;

            vprod5102 = 0;
            vdesc5102 = 0;
            outras5102 = 0;
            total_outras5102 = 0;
            valor_isentas_naotributadas5102 = 0;
            valor_total_nota5102 = 0;
            valor_total_outras5102 = 0;
            voutroverif5102 = 0;

            vprod5101 = 0;
            vdesc5101 = 0;
            outras5101 = 0;
            total_outras5101 = 0;
            valor_isentas_naotributadas5101 = 0;
            valor_total_nota5101 = 0;
            valor_total_outras5101 = 0;
            voutroverif5101 = 0;

            vprod5949 = 0;
            valor_total_nota5949 = 0;
            vdesc5949 = 0;
            total_outras5949 = 0;
            outras5949 = 0;
            voutroverif5949 = 0;

            vprod5403 = 0;
            valor_total_nota5403 = 0;
            vdesc5403 = 0;
            total_outras5403 = 0;
            outras5403 = 0;
            voutroverif5403 = 0;

            vprod5910 = 0;
            valor_total_nota5910 = 0;
            vdesc5910 = 0;
            total_outras5910 = 0;
            outras5910 = 0;
            voutroverif5910 = 0;

            vprod5401 = 0;
            valor_total_nota5401 = 0;
            vdesc5401 = 0;
            total_outras5401 = 0;
            outras5401 = 0;
            voutroverif5401 = 0;

            vprod5104 = 0;
            valor_total_nota5104 = 0;
            vdesc5104 = 0;
            total_outras5104 = 0;
            outras5104 = 0;
            voutroverif5104 = 0;

            vprod1411 = 0;
            valor_total_nota1411 = 0;
            vdesc1411 = 0;
            total_outras1411 = 0;
            outras1411 = 0;
            voutroverif1411 = 0;

            vprod5929 = 0;
            valor_total_nota5929 = 0;
            vdesc5929 = 0;
            total_outras5929 = 0;
            outras5929 = 0;
            voutroverif5929 = 0;

            vprod1410 = 0;
            valor_total_nota1410 = 0;
            vdesc1410 = 0;
            total_outras1410 = 0;
            outras1410 = 0;
            voutroverif1410 = 0;

            vprod6910 = 0;
            valor_total_nota6910 = 0;
            vdesc6910 = 0;
            total_outras6910 = 0;
            outras6910 = 0;
            voutroverif6910 = 0;

            vprod6102 = 0;
            valor_total_nota6102 = 0;
            vdesc6102 = 0;
            total_outras6102 = 0;
            outras6102 = 0;
            voutroverif6102 = 0;

            vprod5911 = 0;
            valor_total_nota5911 = 0;
            vdesc5911 = 0;
            total_outras5911 = 0;
            outras5911 = 0;
            voutroverif5911 = 0;

            vprod5106 = 0;
            valor_total_nota5106 = 0;
            vdesc5106 = 0;
            total_outras5106 = 0;
            outras5106 = 0;
            voutroverif5106 = 0;

            vprod5105 = 0;
            valor_total_nota5105 = 0;
            vdesc5105 = 0;
            total_outras5105 = 0;
            outras5105 = 0;
            voutroverif5105 = 0;
//</editor-fold>
        }
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Gravar Dados");
        alerta.setHeaderText(null);
        alerta.setContentText("Dados gravados com sucesso!");

        alerta.showAndWait();
    }

    @FXML
    private void buttonGerarTxt(ActionEvent event) throws ParserConfigurationException, SAXException, IOException {
        /*----------------------------------*/
//////////////////////////////       |
// <editor-fold defaultstate="collapsed" desc="VARIÁVEIS CFOP DE SAIDA">
        String var5101 = "5101";
        String var5102 = "5102";
        String var5104 = "5104";
        String var5106 = "5106";
        String var5109 = "5109";
        String var5122 = "5122";
        String var5124 = "5124";
        String var5125 = "5125";
        String var5152 = "5152";
        String var5201 = "5201";
        String var5202 = "5202";
        String var5401 = "5401";
        String var5402 = "5402";
        String var5403 = "5403";
        String var5405 = "5405";
        String var5409 = "5409";
        String var5410 = "5410";
        String var5411 = "5411";
        String var5556 = "5556";
        String var1411 = "1411";
        String var5901 = "5901";
        String var5902 = "5902";
        String var5910 = "5910";
        String var5911 = "5911";
        String var5915 = "5915";
        String var5916 = "5916";
        String var5920 = "5920";
        String var5921 = "5921";
        String var5924 = "5924";
        String var5925 = "5925";
        String var5929 = "5929";
        String var5949 = "5949";
        String var6101 = "6101";
        String var6102 = "6102";
        String var6104 = "6104";
        String var6106 = "6101";
        String var6152 = "6152";
        String var6201 = "6201";
        String var6202 = "6202";
        String var6401 = "6401";
        String var6402 = "6402";
        String var6403 = "6403";
        String var6404 = "6404";
        String var6409 = "6409";
        String var6410 = "6410";
        String var6411 = "6411";
        String var6413 = "6413";
        String var6556 = "6556";
        String var6901 = "6901";
        String var6902 = "6902";
        String var6910 = "6910";
        String var6911 = "6911";
        String var6915 = "6915";
        String var6916 = "6916";
        String var6920 = "6920";
        String var6921 = "6921";
        String var6924 = "6924";
        String var6925 = "6925";
        String var6929 = "6929";
        String var6949 = "6949";
        String var1410 = "1410";
        String var5105 = "5105";

//</editor-fold>     *       |
//////////////////////////////       |
/*----------------------------------*/
///////////////////////////////      |
// <editor-fold defaultstate="collapsed" desc="VARIÁVEL DE VERIFICAÇÃO">
        String cfopat1403 = null;
        String cfopat1925 = null;
        String cfopat1102 = null;
        String cfopat1949 = null;
        String cfopat2102 = null;
        String cfopat1152 = null;
        String cfopat1122 = null;
        String cfopat2403 = null;
        String cfopat2152 = null;
        String cfopat1125 = null;
        String cfopat1124 = null;
        String cfopat1410 = null;
        String cfopat1201 = null;
        String cfopat1411 = null;
        String cfopat1202 = null;
        String cfopat2202 = null;
        String cfopat2411 = null;
        String cfopat2410 = null;
        String cfopat2901 = null;
        String cfopat1924 = null;
        String cfopat2902 = null;
        String cfopat2924 = null;
        String cfopat2925 = null;
        String cfopat2921 = null;
        String cfopat2201 = null;
        String cfopat2920 = null;
        String cfopat1901 = null;
        String cfopat1902 = null;
        String cfopat1910 = null;
        String cfopat1911 = null;
        String cfopat2910 = null;
        String cfopat1915 = null;
        String cfopat1916 = null;
        String cfopat2915 = null;
        String cfopat1920 = null;
        String cfopat1921 = null;
        String cfopat2949 = null;
        String cfopat1409 = null;
        String cfopat2409 = null;

//</editor-fold>      *      |
///////////////////////////////      |
/*----------------------------------*/
/////////////////////////////////    |
// <editor-fold defaultstate="collapsed" desc="VARIÁVEIS SAÍDA DE INFORMAÇÕES">
        int saida5101 = 0;
        int saida5102 = 0;
        int saida5104 = 0;
        int saida5105 = 0;
        int saida5106 = 0;
        int saida5109 = 0;
        int saida5122 = 0;
        int saida5124 = 0;
        int saida5125 = 0;
        int saida5152 = 0;
        int saida5201 = 0;
        int saida5202 = 0;
        int saida5401 = 0;
        int saida5402 = 0;
        int saida5403 = 0;
        int saida5405 = 0;
        int saida5409 = 0;
        int saida5410 = 0;
        int saida5411 = 0;
        int saida5556 = 0;
        int saida5901 = 0;
        int saida5902 = 0;
        int saida5910 = 0;
        int saida5911 = 0;
        int saida5915 = 0;
        int saida5916 = 0;
        int saida5920 = 0;
        int saida5921 = 0;
        int saida5924 = 0;
        int saida5925 = 0;
        int saida5929 = 0;
        int saida5949 = 0;
        int saida6101 = 0;
        int saida6102 = 0;
        int saida6104 = 0;
        int saida6106 = 0;
        int saida6152 = 0;
        int saida6201 = 0;
        int saida6202 = 0;
        int saida6401 = 0;
        int saida6402 = 0;
        int saida6403 = 0;
        int saida6404 = 0;
        int saida6409 = 0;
        int saida6410 = 0;
        int saida6411 = 0;
        int saida6413 = 0;
        int saida6556 = 0;
        int saida6901 = 0;
        int saida6902 = 0;
        int saida6910 = 0;
        int saida6911 = 0;
        int saida6915 = 0;
        int saida6916 = 0;
        int saida6920 = 0;
        int saida6921 = 0;
        int saida6924 = 0;
        int saida6925 = 0;
        int saida6929 = 0;
        int saida6949 = 0;
//-------------------------------//        
        int saida1411 = 0;
        int saida1410 = 0;
//</editor-fold> *    |
/////////////////////////////////    |
/*----------------------------------*/
///////////////////////////////      |
// <editor-fold defaultstate="collapsed" desc="VARIÁVEIS VERIFICAÇÃO VOUTRO">

        float voutroverif5101 = 0;
        float voutroverif5102 = 0;
        float voutroverif5104 = 0;
        float voutroverif5105 = 0;
        float voutroverif5106 = 0;
        float voutroverif5109 = 0;
        float voutroverif5122 = 0;
        float voutroverif5124 = 0;
        float voutroverif5125 = 0;
        float voutroverif5152 = 0;
        float voutroverif5201 = 0;
        float voutroverif5202 = 0;
        float voutroverif5401 = 0;
        float voutroverif5402 = 0;
        float voutroverif5403 = 0;
        float voutroverif5405 = 0;
        float voutroverif5409 = 0;
        float voutroverif5410 = 0;
        float voutroverif5411 = 0;
        float voutroverif5556 = 0;
        float voutroverif5901 = 0;
        float voutroverif5902 = 0;
        float voutroverif5910 = 0;
        float voutroverif5911 = 0;
        float voutroverif5915 = 0;
        float voutroverif5916 = 0;
        float voutroverif5920 = 0;
        float voutroverif5921 = 0;
        float voutroverif5924 = 0;
        float voutroverif5925 = 0;
        float voutroverif5929 = 0;
        float voutroverif5949 = 0;
        float voutroverif6101 = 0;
        float voutroverif6102 = 0;
        float voutroverif6104 = 0;
        float voutroverif6106 = 0;
        float voutroverif6152 = 0;
        float voutroverif6201 = 0;
        float voutroverif6202 = 0;
        float voutroverif6401 = 0;
        float voutroverif6402 = 0;
        float voutroverif6403 = 0;
        float voutroverif6404 = 0;
        float voutroverif6409 = 0;
        float voutroverif6410 = 0;
        float voutroverif6411 = 0;
        float voutroverif6413 = 0;
        float voutroverif6556 = 0;
        float voutroverif6901 = 0;
        float voutroverif6902 = 0;
        float voutroverif6910 = 0;
        float voutroverif6911 = 0;
        float voutroverif6915 = 0;
        float voutroverif6916 = 0;
        float voutroverif6920 = 0;
        float voutroverif6921 = 0;
        float voutroverif6924 = 0;
        float voutroverif6925 = 0;
        float voutroverif6929 = 0;
        float voutroverif6949 = 0;
//-----------------------------------//
        float voutroverif1411 = 0;
        float voutroverif1410 = 0;
//</editor-fold> *      |
///////////////////////////////      |
/*----------------------------------*/
///////////////////////////////      |
// <editor-fold defaultstate="collapsed" desc="VARIÁVEIS VERIFICAÇÃO UNTRIB">
        float vprod5921 = 0;
        float vprod5101 = 0;
        float vprod5102 = 0;
        float vprod5104 = 0;
        float vprod5105 = 0;
        float vprod5106 = 0;
        float vprod5109 = 0;
        float vprod5122 = 0;
        float vprod5124 = 0;
        float vprod5125 = 0;
        float vprod5152 = 0;
        float vprod5201 = 0;
        float vprod5202 = 0;
        float vprod5401 = 0;
        float vprod5402 = 0;
        float vprod5403 = 0;
        float vprod5405 = 0;
        float vprod5409 = 0;
        float vprod5410 = 0;
        float vprod5411 = 0;
        float vprod5556 = 0;
        float vprod5901 = 0;
        float vprod5902 = 0;
        float vprod5910 = 0;
        float vprod5911 = 0;
        float vprod5915 = 0;
        float vprod5916 = 0;
        float vprod5920 = 0;
        float vprod5924 = 0;
        float vprod5925 = 0;
        float vprod5929 = 0;
        float vprod5949 = 0;
        float vprod6101 = 0;
        float vprod6102 = 0;
        float vprod6104 = 0;
        float vprod6106 = 0;
        float vprod6152 = 0;
        float vprod6201 = 0;
        float vprod6202 = 0;
        float vprod6401 = 0;
        float vprod6402 = 0;
        float vprod6403 = 0;
        float vprod6404 = 0;
        float vprod6409 = 0;
        float vprod6410 = 0;
        float vprod6411 = 0;
        float vprod6413 = 0;
        float vprod6556 = 0;
        float vprod6901 = 0;
        float vprod6902 = 0;
        float vprod6910 = 0;
        float vprod6911 = 0;
        float vprod6915 = 0;
        float vprod6916 = 0;
        float vprod6920 = 0;
        float vprod6921 = 0;
        float vprod6924 = 0;
        float vprod6925 = 0;
        float vprod6929 = 0;
        float vprod6949 = 0;
//--------------------------------//
        float vprod1411 = 0;
        float vprod1410 = 0;

//</editor-fold> *      |
///////////////////////////////      |
/*----------------------------------*/
///////////////////////////////      |
// <editor-fold defaultstate="collapsed" desc="VARIÁVEIS CST's">
        String cst60 = "60";
        String cst00 = "00";
        String cst10 = "10";
        String cst20 = "20";
        String cst30 = "30";
        String cst40 = "40";
        String cst41 = "41";
        String cst50 = "50";
        String cst51 = "51";
        String cst70 = "70";
        String cst90 = "90";
        String icmssn101 = "101";
        String icmssn102 = "102";
        String icmssn103 = "103";
        String icmssn3 = "3";
        String icmssn201 = "201";
        String icmssn202 = "202";
        String icmssn203 = "203";
        String icmssn500 = "500";
        String icmssn900 = "900";
        String icmssn300 = "300";
        String icmssn400 = "400";

//</editor-fold>              *      |
///////////////////////////////      |
/*----------------------------------*/
///////////////////////////////      |
// <editor-fold defaultstate="collapsed" desc="VARIÁVEIS CST's CONDICIONAIS">
        float outras5405 = 0;
        float outras5102 = 0;
        float outras5921 = 0;
        float outras5101 = 0;
        float outras5104 = 0;
        float outras5105 = 0;
        float outras5106 = 0;
        float outras5109 = 0;
        float outras5122 = 0;
        float outras5124 = 0;
        float outras5125 = 0;
        float outras5152 = 0;
        float outras5201 = 0;
        float outras5202 = 0;
        float outras5401 = 0;
        float outras5402 = 0;
        float outras5403 = 0;
        float outras5409 = 0;
        float outras5410 = 0;
        float outras5411 = 0;
        float outras5556 = 0;
        float outras5901 = 0;
        float outras5902 = 0;
        float outras5910 = 0;
        float outras5911 = 0;
        float outras5915 = 0;
        float outras5916 = 0;
        float outras5920 = 0;
        float outras5924 = 0;
        float outras5925 = 0;
        float outras5929 = 0;
        float outras5949 = 0;
        float outras6101 = 0;
        float outras6102 = 0;
        float outras6104 = 0;
        float outras6106 = 0;
        float outras6152 = 0;
        float outras6201 = 0;
        float outras6202 = 0;
        float outras6401 = 0;
        float outras6402 = 0;
        float outras6403 = 0;
        float outras6404 = 0;
        float outras6409 = 0;
        float outras6410 = 0;
        float outras6411 = 0;
        float outras6413 = 0;
        float outras6556 = 0;
        float outras6901 = 0;
        float outras6902 = 0;
        float outras6910 = 0;
        float outras6911 = 0;
        float outras6915 = 0;
        float outras6916 = 0;
        float outras6920 = 0;
        float outras6921 = 0;
        float outras6924 = 0;
        float outras6925 = 0;
        float outras6929 = 0;
        float outras6949 = 0;
//-------------------------------//
        float outras1411 = 0;
        float outras1410 = 0;
//</editor-fold> *      |
///////////////////////////////      |
/*----------------------------------*/
///////////////////////////////      |
// <editor-fold defaultstate="collapsed" desc="VARIÁVEIS FLOAT ALEATÓRIOS">
        float ipi_nao_creditado = 0;
        float valor_isentas_naotributadas5102 = 0;
        float valor_isentas_naotributadas5101 = 0;
        float base_calculo_icms = 0;
        float icms_creditado = 0;
        float isentas_naotributadas = 0;
        float aliquota_icms = 0;
        float base_calculo_ipi = 0;
        float ipi_creditado = 0;
        float ipi_creditado_50 = 0;
        float isentas_naotributadas_zerado = 0;
        float outras_zerado = 0;
        float sit_especial_valor1 = 0;
        float sit_especial_valor2 = 0;
        float sit_especial_valor3 = 0;
        float sit_especial_valor4 = 0;
        float base_calc_subst_tribut = 0;
        float float_num_doc = 0;
        float imposto_retido_subst_tribut = 0;
        float valor_frete = 0;
        float valor_seguro = 0;
        float valor_total_outras5102 = 0;
        float valor_total_outras5101 = 0;

//</editor-fold>   *      |
///////////////////////////////      |
/*----------------------------------*/
 /*----------------------------------*/
///////////////////////////////      |
// <editor-fold defaultstate="collapsed" desc="VARIÁVEIS TOTAL OUTRAS">
        float total_outras5405 = 0;
        float total_outras5102 = 0;
        float total_outras5921 = 0;
        float total_outras5101 = 0;
        float total_outras5104 = 0;
        float total_outras5105 = 0;
        float total_outras5106 = 0;
        float total_outras5109 = 0;
        float total_outras5122 = 0;
        float total_outras5124 = 0;
        float total_outras5125 = 0;
        float total_outras5152 = 0;
        float total_outras5201 = 0;
        float total_outras5202 = 0;
        float total_outras5401 = 0;
        float total_outras5402 = 0;
        float total_outras5403 = 0;
        float total_outras5409 = 0;
        float total_outras5410 = 0;
        float total_outras5411 = 0;
        float total_outras5556 = 0;
        float total_outras5901 = 0;
        float total_outras5902 = 0;
        float total_outras5910 = 0;
        float total_outras5911 = 0;
        float total_outras5915 = 0;
        float total_outras5916 = 0;
        float total_outras5920 = 0;
        float total_outras5924 = 0;
        float total_outras5925 = 0;
        float total_outras5929 = 0;
        float total_outras5949 = 0;
        float total_outras6101 = 0;
        float total_outras6102 = 0;
        float total_outras6104 = 0;
        float total_outras6106 = 0;
        float total_outras6152 = 0;
        float total_outras6201 = 0;
        float total_outras6202 = 0;
        float total_outras6401 = 0;
        float total_outras6402 = 0;
        float total_outras6403 = 0;
        float total_outras6404 = 0;
        float total_outras6409 = 0;
        float total_outras6410 = 0;
        float total_outras6411 = 0;
        float total_outras6413 = 0;
        float total_outras6556 = 0;
        float total_outras6901 = 0;
        float total_outras6902 = 0;
        float total_outras6910 = 0;
        float total_outras6911 = 0;
        float total_outras6915 = 0;
        float total_outras6916 = 0;
        float total_outras6920 = 0;
        float total_outras6921 = 0;
        float total_outras6924 = 0;
        float total_outras6925 = 0;
        float total_outras6929 = 0;
        float total_outras6949 = 0;
//---------------------------------------//
        float total_outras1411 = 0;
        float total_outras1410 = 0;

//</editor-fold>   *      |
///////////////////////////////      |
/*----------------------------------*/
 /*---------------------------------*/
//////////                           |
// <editor-fold defaultstate="collapsed" desc="FLAGS">
        int flag5405 = 0;
        int flag5102 = 0;
        int flag5921 = 0;
        int flag5101 = 0;
        int flag5104 = 0;
        int flag5105 = 0;
        int flag5106 = 0;
        int flag5109 = 0;
        int flag5122 = 0;
        int flag5124 = 0;
        int flag5125 = 0;
        int flag5152 = 0;
        int flag5201 = 0;
        int flag5202 = 0;
        int flag5401 = 0;
        int flag5402 = 0;
        int flag5403 = 0;
        int flag5409 = 0;
        int flag5410 = 0;
        int flag5411 = 0;
        int flag5556 = 0;
        int flag5901 = 0;
        int flag5902 = 0;
        int flag5910 = 0;
        int flag5911 = 0;
        int flag5915 = 0;
        int flag5916 = 0;
        int flag5920 = 0;
        int flag5924 = 0;
        int flag5925 = 0;
        int flag5929 = 0;
        int flag5949 = 0;
        int flag6101 = 0;
        int flag6102 = 0;
        int flag6104 = 0;
        int flag6106 = 0;
        int flag6152 = 0;
        int flag6201 = 0;
        int flag6202 = 0;
        int flag6401 = 0;
        int flag6402 = 0;
        int flag6403 = 0;
        int flag6404 = 0;
        int flag6409 = 0;
        int flag6410 = 0;
        int flag6411 = 0;
        int flag6413 = 0;
        int flag6556 = 0;
        int flag6901 = 0;
        int flag6902 = 0;
        int flag6910 = 0;
        int flag6911 = 0;
        int flag6915 = 0;
        int flag6916 = 0;
        int flag6920 = 0;
        int flag6921 = 0;
        int flag6924 = 0;
        int flag6925 = 0;
        int flag6929 = 0;
        int flag6949 = 0;
//------------------------------//
        int flag1411 = 0;
        int flag1410 = 0;
//</editor-fold>   *                           |
/////////                            |
/*----------------------------------*/
 /*---------------------------------*/
///////////////////////////////      |
// <editor-fold defaultstate="collapsed" desc="VARIÁVEIS DE DESCONTO">

        float vdesc5405 = 0;
        float vdesc5102 = 0;
        float vdesc5921 = 0;
        float vdesc5101 = 0;
        float vdesc5104 = 0;
        float vdesc5105 = 0;
        float vdesc5106 = 0;
        float vdesc5109 = 0;
        float vdesc5122 = 0;
        float vdesc5124 = 0;
        float vdesc5125 = 0;
        float vdesc5152 = 0;
        float vdesc5201 = 0;
        float vdesc5202 = 0;
        float vdesc5401 = 0;
        float vdesc5402 = 0;
        float vdesc5403 = 0;
        float vdesc5409 = 0;
        float vdesc5410 = 0;
        float vdesc5411 = 0;
        float vdesc5556 = 0;
        float vdesc5901 = 0;
        float vdesc5902 = 0;
        float vdesc5910 = 0;
        float vdesc5911 = 0;
        float vdesc5915 = 0;
        float vdesc5916 = 0;
        float vdesc5920 = 0;
        float vdesc5924 = 0;
        float vdesc5925 = 0;
        float vdesc5929 = 0;
        float vdesc5949 = 0;
        float vdesc6101 = 0;
        float vdesc6102 = 0;
        float vdesc6104 = 0;
        float vdesc6106 = 0;
        float vdesc6152 = 0;
        float vdesc6201 = 0;
        float vdesc6202 = 0;
        float vdesc6401 = 0;
        float vdesc6402 = 0;
        float vdesc6403 = 0;
        float vdesc6404 = 0;
        float vdesc6409 = 0;
        float vdesc6410 = 0;
        float vdesc6411 = 0;
        float vdesc6413 = 0;
        float vdesc6556 = 0;
        float vdesc6901 = 0;
        float vdesc6902 = 0;
        float vdesc6910 = 0;
        float vdesc6911 = 0;
        float vdesc6915 = 0;
        float vdesc6916 = 0;
        float vdesc6920 = 0;
        float vdesc6921 = 0;
        float vdesc6924 = 0;
        float vdesc6925 = 0;
        float vdesc6929 = 0;
        float vdesc6949 = 0;
//------------------------------//
        float vdesc1411 = 0;
        float vdesc1410 = 0;

//</editor-fold>        *      |
///////////////////////////////      |
/*----------------------------------*/
 /*----------------------------------*/
///////////////////////////////      |
// <editor-fold defaultstate="collapsed" desc="VARIÁVEIS VALOR_TOTAL_NOTA">
        float valor_total_nota5405 = 0;
        float valor_total_nota5102 = 0;
        float valor_total_nota5921 = 0;
        float valor_total_nota5101 = 0;
        float valor_total_nota5104 = 0;
        float valor_total_nota5105 = 0;
        float valor_total_nota5106 = 0;
        float valor_total_nota5109 = 0;
        float valor_total_nota5122 = 0;
        float valor_total_nota5124 = 0;
        float valor_total_nota5125 = 0;
        float valor_total_nota5152 = 0;
        float valor_total_nota5201 = 0;
        float valor_total_nota5202 = 0;
        float valor_total_nota5401 = 0;
        float valor_total_nota5402 = 0;
        float valor_total_nota5403 = 0;
        float valor_total_nota5409 = 0;
        float valor_total_nota5410 = 0;
        float valor_total_nota5411 = 0;
        float valor_total_nota5556 = 0;
        float valor_total_nota5901 = 0;
        float valor_total_nota5902 = 0;
        float valor_total_nota5910 = 0;
        float valor_total_nota5911 = 0;
        float valor_total_nota5915 = 0;
        float valor_total_nota5916 = 0;
        float valor_total_nota5920 = 0;
        float valor_total_nota5924 = 0;
        float valor_total_nota5925 = 0;
        float valor_total_nota5929 = 0;
        float valor_total_nota5949 = 0;
        float valor_total_nota6101 = 0;
        float valor_total_nota6102 = 0;
        float valor_total_nota6104 = 0;
        float valor_total_nota6106 = 0;
        float valor_total_nota6152 = 0;
        float valor_total_nota6201 = 0;
        float valor_total_nota6202 = 0;
        float valor_total_nota6401 = 0;
        float valor_total_nota6402 = 0;
        float valor_total_nota6403 = 0;
        float valor_total_nota6404 = 0;
        float valor_total_nota6409 = 0;
        float valor_total_nota6410 = 0;
        float valor_total_nota6411 = 0;
        float valor_total_nota6413 = 0;
        float valor_total_nota6556 = 0;
        float valor_total_nota6901 = 0;
        float valor_total_nota6902 = 0;
        float valor_total_nota6910 = 0;
        float valor_total_nota6911 = 0;
        float valor_total_nota6915 = 0;
        float valor_total_nota6916 = 0;
        float valor_total_nota6920 = 0;
        float valor_total_nota6921 = 0;
        float valor_total_nota6924 = 0;
        float valor_total_nota6925 = 0;
        float valor_total_nota6929 = 0;
        float valor_total_nota6949 = 0;
//----------------------------------------//

        float valor_total_nota1411 = 0;
        float valor_total_nota1410 = 0;

//</editor-fold>   *      |
///////////////////////////////      |
/*----------------------------------*/
// <editor-fold defaultstate="collapsed" desc="VARIÁVEIS GLOBAIS">
        String caminho = null;
        String salvarArquivo = null;
        String cnp = null;
        String sai = null;
        String emi = null;
        String cfop = null;
        String nfe = null;
        String cfopat = null;
        String hora_emi = null;
        String vprod = null;
        String voutro = null;
        String cst = null;
        String vdesc = null;
        String cprod = null;
        String insc_estadual = null;
        String modFrete = null;
        String un_federal = null;
        String cod_municipal = null;
        String serie = null;
        String num_doc = null;
        DecimalFormat format_num_doc = new DecimalFormat("0000000000");
        DecimalFormat sit_especial = new DecimalFormat("000000000.00");
        DecimalFormat format_serie = new DecimalFormat("000");
        DecimalFormat format_insc_estadual = new DecimalFormat("000000000000");
        DecimalFormat aliquo_icms = new DecimalFormat("00.00");
        DecimalFormat df = new DecimalFormat("00000000000.00");
        DecimalFormat format_vdesc = new DecimalFormat("00000000000.00");
        String comparar_nfe = null;
        String espaco = "      ";
        float parsefloat = 0;
        float soma_vdesc = 0;
        float float_insc_estadual = 0;
        int int_insc_estadual = 0;
        String[] palavras = null;
        int desdo = 0;
        int quant = -1;
        int a, e, k;
        String valor_csosn = null;
        Connection con;
        PreparedStatement st;
        ResultSet rs;
        String sql;

//</editor-fold>
// <editor-fold defaultstate="collapsed" desc="Variáveis">
        String cEAN = null;
        String xProd = null;
        String NCM = null;
        String uCom = null;
        String qCom = null;
        String vUnCom = null;
        String vProd = null;
        String cEANTrib = null;
        String uTrib = null;
        String qTrib = null;
        String vUnTrib = null;
        String indTot = null;
        String vTotTrib = null;
        String orig = null;
        String CSOSN = null;
        String pCredSN = null;
        String vCredICMSSN = null;
        String cEnq = null;
        String CST = null;
        String vBC = null;
        String vDespAdu = null;
        String vII = null;
        String vIOF = null;
        // <editor-fold defaultstate="collapsed" desc="Variáveis EMIT">
        String CNPJ_emit = null;
        String xNome_emit = null;
        String xFant_emit = null;
        String xLgr_emit = null;
        String nro_emit = null;
        String xBairro_emit = null;
        String cMun_emit = null;
        String xMun_emit = null;
        String UF_emit = null;
        String CEP_emit = null;
        String cPais_emit = null;
        String xPais_emit = null;
        String fone_emit = null;
        String IE_emit = null;
        String IM_emit = null;
        String CNAE_emit = null;
        String CRT_emit = null;
        //</editor-fold>
        // <editor-fold defaultstate="collapsed" desc="Variáveis DEST">
        String CNPJ_dest = null;
        String xNome_dest = null;
        String xFant_dest = null;
        String xLgr_dest = null;
        String nro_dest = null;
        String xBairro_dest = null;
        String cMun_dest = null;
        String xMun_dest = null;
        String UF_dest = null;
        String CEP_dest = null;
        String cPais_dest = null;
        String xPais_dest = null;
        String fone_dest = null;
        String IE_dest = null;
        String IM_dest = null;
        String CNAE_dest = null;
        String CRT_dest = null;
        //</editor-fold>
        String cUF = null;
        String cNF = null;
        String natOp = null;
        String indPag = null;
        String mod = null;
        String nNF = null;
        String dhEmi = null;
        String dhSaiEnt = null;
        String tpNF = null;
        String idDest = null;
        String cMunFG = null;
        String tpImp = null;
        String tpEmis = null;
        String cDV = null;
        String tpAmb = null;
        String finNFe = null;
        String indFinal = null;
        String indPres = null;
        String procEmi = null;
        String verProc = null;
        String vICMS = null;
        String vICMSDeson = null;
        String vBCST = null;
        String vST = null;
        String vFrete = null;
        String vSeg = null;
        String vDesc = null;
        String vIPI = null;
        String vPIS = null;
        String vCOFINS = null;
        String vOutro = null;
        String vNF = null;
        String vRetCSLL = null;
        String nFat = null;
        String vOrig = null;
        String vLiq = null;
        String nDup = null;
        String dVenc = null;
        String vDup = null;
        String infCpl = null;
        String chNFe = null;
        String retorno_ncm = null;
        String retorno_produto = null;
        String comparar_produto = null;
        String retorno_novo_produto = null;
        String get_cnpj = null;
        String novo_produto = null;
        String vBC_total = null;
        String vICMS_total = null;
        String vICMSDeson_total = null;
        String vBCST_total = null;
        String vST_total = null;
        String vProd_total = null;
        String vFrete_total = null;
        String vSeg_total = null;
        String vDesc_total = null;
        String vII_total = null;
        String vIPI_total = null;
        String vPIS_total = null;
        String vCOFINS_total = null;
        String vOutro_total = null;
        String vNF_total = null;
        String vTotTrib_total = null;
        String placa = null;
        String qVol = null;
        String nVol = null;
        String pesoL = null;
        String pesoB = null;

        //</editor-fold>
        arquivoSave();
        for (Object caminho_ob : array_caminho) {

            File diretorio = new File((String) caminho_ob);

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(diretorio);

// <editor-fold defaultstate="collapsed" desc="CÓDIGO NFE">
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
                                    nfe = elementofilho.getTextContent();
                                    comparar_nfe = nfe.toString();
                                    break;
                            }

                        }
                    }
                }
            }
//</editor-fold>

// <editor-fold defaultstate="collapsed" desc="CNPJ">
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
                                    cnp = elementofilhos.getTextContent();

                                    break;
                            }
                        }
                    }
                }
            }
//</editor-fold>

// <editor-fold defaultstate="collapsed" desc="DATA ENTRADA">
            NodeList idee = doc.getElementsByTagName("ide");

            int tamanhoide = idee.getLength();

            for (int i = 0; i < tamanhoide; i++) {

                Node noide = idee.item(i);

                if (noide.getNodeType() == Node.ELEMENT_NODE) {

                    Element listaide = (Element) noide;

                    NodeList listafilhoide = listaide.getChildNodes();

                    int tamanholistaide = listafilhoide.getLength();

                    for (int j = 0; j < tamanholistaide; j++) {

                        Node idei = listafilhoide.item(j);

                        if (idei.getNodeType() == Node.ELEMENT_NODE) {

                            Element elementofilho = (Element) idei;

                            switch (elementofilho.getTagName()) {

                                case "dhSaiEnt":

                                    String mb = elementofilho.getTextContent();
                                    String ano = mb.substring(2, 4);
                                    String mes = mb.substring(5, 7);
                                    String dia = mb.substring(8, 10);
                                    sai = dia + mes + ano;

                            }

                        }
                    }
                }
            }
//</editor-fold>

// <editor-fold defaultstate="collapsed" desc="DATA EMISSÃO">
            NodeList saient = doc.getElementsByTagName("ide");

            int saiente = saient.getLength();

            for (int i = 0; i < saiente; i++) {

                Node noide = saient.item(i);

                if (noide.getNodeType() == Node.ELEMENT_NODE) {

                    Element listaide = (Element) noide;

                    NodeList listafilhoide = listaide.getChildNodes();

                    int tamanholistaide = listafilhoide.getLength();

                    for (int j = 0; j < tamanholistaide; j++) {

                        Node idei = listafilhoide.item(j);

                        if (idei.getNodeType() == Node.ELEMENT_NODE) {

                            Element elementofilho = (Element) idei;

                            switch (elementofilho.getTagName()) {

                                case "dhEmi":

                                    String mb = elementofilho.getTextContent();

                                    String ano = mb.substring(2, 4);
                                    String mes = mb.substring(5, 7);
                                    String dia = mb.substring(8, 10);
                                    String hora = mb.substring(11, 19);
                                    emi = dia + mes + ano;
                                    hora_emi = hora;

                            }

                        }
                    }
                }
            }
//</editor-fold>

// <editor-fold defaultstate="collapsed" desc="INSCRIÇÃO ESTADUAL DO EMITENTE">
            NodeList emit = doc.getElementsByTagName("emit");

            int emitt = emit.getLength();

            for (int i = 0; i < emitt; i++) {

                Node noide = emit.item(i);

                if (noide.getNodeType() == Node.ELEMENT_NODE) {

                    Element listaide = (Element) noide;

                    NodeList listafilhoide = listaide.getChildNodes();

                    int tamanholistaide = listafilhoide.getLength();

                    for (int j = 0; j < tamanholistaide; j++) {

                        Node idei = listafilhoide.item(j);

                        if (idei.getNodeType() == Node.ELEMENT_NODE) {

                            Element elementofilho = (Element) idei;
                            switch (elementofilho.getTagName()) {

                                case "IE":
                                    insc_estadual = elementofilho.getTextContent();
                                    float_insc_estadual = Float.parseFloat(insc_estadual);
                                    int_insc_estadual = insc_estadual.length();

                                    // <editor-fold defaultstate="collapsed" desc="CONDIÇÕES ESPAÇO">
                                    if (int_insc_estadual == 18) {
                                        espaco = "";
                                    } else {
                                        if (int_insc_estadual == 17) {
                                            espaco = " ";
                                        } else {
                                            if (int_insc_estadual == 16) {
                                                espaco = "  ";
                                            } else {
                                                if (int_insc_estadual == 15) {
                                                    espaco = "   ";
                                                } else {
                                                    if (int_insc_estadual == 14) {
                                                        espaco = "    ";
                                                    } else {
                                                        if (int_insc_estadual == 13) {
                                                            espaco = "     ";
                                                        } else {
                                                            if (int_insc_estadual == 12) {
                                                                espaco = "      ";
                                                            } else {
                                                                if (int_insc_estadual == 11) {
                                                                    espaco = "       ";
                                                                } else {
                                                                    if (int_insc_estadual == 10) {
                                                                        espaco = "        ";
                                                                    } else {
                                                                        if (int_insc_estadual == 9) {
                                                                            espaco = "         ";
                                                                        } else {
                                                                            if (int_insc_estadual == 8) {
                                                                                espaco = "          ";
                                                                            } else {
                                                                                if (int_insc_estadual == 7) {
                                                                                    espaco = "           ";
                                                                                } else {
                                                                                    if (int_insc_estadual == 6) {
                                                                                        espaco = "            ";
                                                                                    } else {
                                                                                        if (int_insc_estadual == 5) {
                                                                                            espaco = "             ";
                                                                                        } else {
                                                                                            if (int_insc_estadual == 4) {
                                                                                                espaco = "              ";
                                                                                            } else {
                                                                                                if (int_insc_estadual == 3) {
                                                                                                    espaco = "               ";
                                                                                                } else {
                                                                                                    if (int_insc_estadual == 2) {
                                                                                                        espaco = "                ";
                                                                                                    } else {
                                                                                                        if (int_insc_estadual == 1) {
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
                                    un_federal = elementofilho.getTextContent();
                                    break;
                                case "cMun":
                                    cod_municipal = elementofilho.getTextContent();
                                    break;

                            }
                        }
                    }
                }

            }
//</editor-fold>

// <editor-fold defaultstate="collapsed" desc="SÉRIE">
            NodeList ide = doc.getElementsByTagName("ide");

            int ideea = ide.getLength();

            for (int i = 0; i < ideea; i++) {

                Node noide = ide.item(i);

                if (noide.getNodeType() == Node.ELEMENT_NODE) {

                    Element listaide = (Element) noide;

                    NodeList listafilhoide = listaide.getChildNodes();

                    int tamanholistaide = listafilhoide.getLength();

                    for (int j = 0; j < tamanholistaide; j++) {

                        Node idei = listafilhoide.item(j);

                        if (idei.getNodeType() == Node.ELEMENT_NODE) {

                            Element elementofilho = (Element) idei;
                            switch (elementofilho.getTagName()) {
                                case "serie":
                                    serie = elementofilho.getTextContent();

                                    break;
                                case "nNF":
                                    num_doc = elementofilho.getTextContent();
                                    float_num_doc = Float.parseFloat(num_doc);

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
                            modFrete = elementodadoss.getTextContent();

                            break;

                    }
                }
            }

            NodeList voutroa = doc.getElementsByTagName("vOutro");

            int voutroaa = voutroa.getLength();

            for (int o = 0; o < voutroaa; o++) {

                Node noFilhoss = voutroa.item(o);

                if (noFilhoss.getNodeType() == Node.ELEMENT_NODE) {

                    Element elementodadoss = (Element) noFilhoss;
                    switch (elementodadoss.getTagName()) {

                        case "vOutro":
                            voutro = elementodadoss.getTextContent();

                            break;

                    }
                }
            }
//</editor-fold>

// <editor-fold defaultstate="collapsed" desc="DET">
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
                                            cprod = elementodados.getTextContent();
                                            break;
//</editor-fold>

                                        // <editor-fold defaultstate="collapsed" desc="cEAN">
                                        case "cEAN":
                                            cEAN = elementodados.getTextContent();

                                            break;
//</editor-fold>

                                        // <editor-fold defaultstate="collapsed" desc="xProd">
                                        case "xProd":
                                            xProd = elementodados.getTextContent();

                                            break;
                                        //</editor-fold>

                                        // <editor-fold defaultstate="collapsed" desc="NCM">
                                        case "NCM":
                                            NCM = elementodados.getTextContent();

                                            break;
                                        //</editor-fold>

                                        // <editor-fold defaultstate="collapsed" desc="CEST">
                                        case "CEST":

                                            // txtAreaExemplo.appendText("\t" + "CEST = " + "\t" + elementodados.getTextContent());
                                            break;
//</editor-fold>

                                        // <editor-fold defaultstate="collapsed" desc="CFOP">
                                        case "CFOP":
                                            cfop = elementodados.getTextContent();

                                            palavras = cfop.split(" ");

                                            for (a = 0; a < palavras.length; a++) {

                                                // <editor-fold defaultstate="collapsed" desc="CONDIÇÕES CFOP DE SAIDA">
                                                // <editor-fold defaultstate="collapsed" desc="CFOP 5405">
                                                if (flag5405 == 1) {

                                                } else {

                                                    if (palavras[a].equals(var5405)) {
                                                        quant++;
                                                        flag5405 = 1;
                                                        cfopat1403 = "1403";
                                                        saida5405 = quant;

                                                    }
                                                }

                                                //</editor-fold>
                                                // <editor-fold defaultstate="collapsed" desc="CFOP 5102">
                                                if (flag5102 == 1) {

                                                } else {
                                                    if (palavras[a].equals(var5102)) {
                                                        quant++;
                                                        flag5102 = 1;
                                                        cfopat1102 = "1102";
                                                        saida5102 = quant;

                                                    }

                                                }

                                                //</editor-fold>
                                                // <editor-fold defaultstate="collapsed" desc="CFOP 5101">
                                                if (flag5101 == 1) {

                                                } else {
                                                    if (palavras[a].equals(var5101)) {
                                                        quant++;
                                                        cfopat1102 = "1102";
                                                        flag5101 = 1;
                                                        saida5101 = quant;

                                                    }
                                                }
//</editor-fold>

                                                // <editor-fold defaultstate="collapsed" desc="CFOP 5401">
                                                if (flag5401 == 1) {

                                                } else {
                                                    if (palavras[a].equals(var5401)) {
                                                        quant++;
                                                        flag5401 = 1;
                                                        cfopat1403 = "1403";
                                                        saida5401 = quant;

                                                    }
                                                }
//</editor-fold>

                                                // <editor-fold defaultstate="collapsed" desc="CFOP 5910">
                                                if (flag5910 == 1) {

                                                } else {
                                                    if (palavras[a].equals(var5910)) {
                                                        quant++;
                                                        flag5910 = 1;
                                                        cfopat1910 = "1910";
                                                        saida5910 = quant;

                                                    }
                                                }
//</editor-fold>

                                                // <editor-fold defaultstate="collapsed" desc="CFOP 5949">
                                                if (flag5949 == 1) {

                                                } else {
                                                    if (palavras[a].equals(var5949)) {
                                                        quant++;
                                                        flag5949 = 1;
                                                        cfopat1949 = "1949";
                                                        saida5949 = quant;

                                                    }
                                                }
//</editor-fold>

                                                // <editor-fold defaultstate="collapsed" desc="CFOP 5104">
                                                if (flag5104 == 1) {

                                                } else {
                                                    if (palavras[a].equals(var5104)) {
                                                        quant++;
                                                        flag5104 = 1;
                                                        cfopat1102 = "1102";
                                                        saida5104 = quant;

                                                    }
                                                }
//</editor-fold>

                                                // <editor-fold defaultstate="collapsed" desc="CFOP 5403">
                                                if (flag5403 == 1) {

                                                } else {
                                                    if (palavras[a].equals(var5403)) {
                                                        quant++;
                                                        flag5403 = 1;
                                                        cfopat1403 = "1403";
                                                        saida5403 = quant;

                                                    }
                                                }
//</editor-fold>

                                                // <editor-fold defaultstate="collapsed" desc="CFOP 1411">
                                                if (flag1411 == 1) {

                                                } else {

                                                    if (palavras[a].equals(var1411)) {
                                                        quant++;
                                                        flag1411 = 1;
                                                        cfopat1411 = "1411";
                                                        saida1411 = quant;

                                                    }
                                                }

                                                //</editor-fold>
                                                // <editor-fold defaultstate="collapsed" desc="CFOP 5929">
                                                if (flag5929 == 1) {

                                                } else {

                                                    if (palavras[a].equals(var5929)) {
                                                        quant++;
                                                        flag5929 = 1;
                                                        saida5929 = quant;

                                                    }
                                                }

                                                //</editor-fold>
                                                // <editor-fold defaultstate="collapsed" desc="CFOP 1410">
                                                if (flag1410 == 1) {

                                                } else {

                                                    if (palavras[a].equals(var1410)) {
                                                        quant++;
                                                        flag1410 = 1;
                                                        cfopat1410 = "1410";
                                                        saida1410 = quant;

                                                    }
                                                }

                                                //</editor-fold>
                                                // <editor-fold defaultstate="collapsed" desc="CFOP 6910">
                                                if (flag6910 == 1) {

                                                } else {

                                                    if (palavras[a].equals(var6910)) {
                                                        quant++;
                                                        flag6910 = 1;
                                                        cfopat2910 = "2910";
                                                        saida6910 = quant;

                                                    }
                                                }

                                                //</editor-fold>
                                                // <editor-fold defaultstate="collapsed" desc="CFOP 6102">
                                                if (flag6102 == 1) {

                                                } else {

                                                    if (palavras[a].equals(var6102)) {
                                                        quant++;
                                                        flag6102 = 1;
                                                        cfopat2102 = "2102";
                                                        saida6102 = quant;

                                                    }
                                                }

                                                //</editor-fold>
                                                // <editor-fold defaultstate="collapsed" desc="CFOP 5911">
                                                if (flag5911 == 1) {

                                                } else {
                                                    if (palavras[a].equals(var5911)) {
                                                        quant++;
                                                        flag5911 = 1;
                                                        cfopat1911 = "1911";
                                                        saida5911 = quant;

                                                    }
                                                }
//</editor-fold>

                                                // <editor-fold defaultstate="collapsed" desc="CFOP 5106">
                                                if (flag5106 == 1) {

                                                } else {
                                                    if (palavras[a].equals(var5106)) {
                                                        quant++;
                                                        flag5106 = 1;
                                                        cfopat1102 = "1102";
                                                        saida5106 = quant;

                                                    }
                                                }
//</editor-fold>

                                                // <editor-fold defaultstate="collapsed" desc="CFOP 5105">
                                                if (flag5105 == 1) {

                                                } else {
                                                    if (palavras[a].equals(var5105)) {
                                                        quant++;
                                                        flag5105 = 1;
                                                        cfopat1102 = "1102";
                                                        saida5105 = quant;

                                                    }
                                                }
//</editor-fold>
// </editor-fold>   
                                            }
                                            break;
//</editor-fold>

                                        // <editor-fold defaultstate="collapsed" desc="vDesc">
                                        case "vDesc":
                                            vdesc = elementodados.getTextContent();
                                            soma_vdesc = Float.parseFloat(vdesc);

                                            // <editor-fold defaultstate="collapsed" desc="VDESC5405">
                                            if (cfop.equals(var5405)) {
                                                vdesc5405 = vdesc5405 + soma_vdesc;

                                            }
                                            // </editor-fold>    

                                            // <editor-fold defaultstate="collapsed" desc="VDESC5102">    
                                            if (cfop.equals(var5102)) {
                                                vdesc5102 = vdesc5102 + soma_vdesc;

                                            }
                                            // </editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="VDESC5101">
                                            if (cfop.equals(var5101)) {
                                                vdesc5101 = vdesc5101 + soma_vdesc;

                                            }
                                            // </editor-fold>                                             

                                            // <editor-fold defaultstate="collapsed" desc="VDESC5104">    
                                            if (cfop.equals(var5104)) {
                                                vdesc5104 = vdesc5104 + soma_vdesc;

                                            }
                                            // </editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="VDESC5910">    
                                            if (cfop.equals(var5910)) {
                                                vdesc5910 = vdesc5910 + soma_vdesc;

                                            }
                                            // </editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="VDESC5401">    
                                            if (cfop.equals(var5401)) {
                                                vdesc5401 = vdesc5401 + soma_vdesc;

                                            }
                                            // </editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="VDESC5949">    
                                            if (cfop.equals(var5949)) {
                                                vdesc5949 = vdesc5949 + soma_vdesc;

                                            }
                                            // </editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="VDESC5403">    
                                            if (cfop.equals(var5403)) {
                                                vdesc5403 = vdesc5403 + soma_vdesc;

                                            }
                                            // </editor-fold>   

                                            // <editor-fold defaultstate="collapsed" desc="VDESC1411">
                                            if (cfop.equals(var1411)) {
                                                vdesc1411 = vdesc1411 + soma_vdesc;

                                            }
                                            // </editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="VDESC5929">
                                            if (cfop.equals(var5929)) {
                                                vdesc5929 = vdesc5929 + soma_vdesc;

                                            }
                                            // </editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="VDESC1410">
                                            if (cfop.equals(var1410)) {
                                                vdesc1410 = vdesc1410 + soma_vdesc;

                                            }
                                            // </editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="VDESC6910">
                                            if (cfop.equals(var6910)) {
                                                vdesc6910 = vdesc6910 + soma_vdesc;

                                            }
                                            // </editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="VDESC6102">
                                            if (cfop.equals(var6102)) {
                                                vdesc6102 = vdesc6102 + soma_vdesc;

                                            }
                                            // </editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="VDESC5911">    
                                            if (cfop.equals(var5911)) {
                                                vdesc5911 = vdesc5911 + soma_vdesc;

                                            }
                                            // </editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="VDESC5106">    
                                            if (cfop.equals(var5106)) {
                                                vdesc5106 = vdesc5106 + soma_vdesc;

                                            }
                                            // </editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="VDESC5105">    
                                            if (cfop.equals(var5105)) {
                                                vdesc5105 = vdesc5105 + soma_vdesc;

                                            }
                                            // </editor-fold>
                                            break;
                                        // </editor-fold>

                                        // <editor-fold defaultstate="collapsed" desc="uCom">
                                        case "uCom":

                                            // txtAreaExemplo.appendText("\t" + "UNIDADE = " + "\t" + elementodados.getTextContent());
                                            break;
                                        //</editor-fold>

                                        // <editor-fold defaultstate="collapsed" desc="vOutro">
                                        case "vOutro":

                                            voutro = elementodados.getTextContent();

                                            float parsefloatvoutro = Float.parseFloat(voutro);
                                            // <editor-fold defaultstate="collapsed" desc="CONDIÇÕES VOUTRO">

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5102">
                                            if ("5102".equals(cfop)) {
                                                voutroverif5102 = parsefloatvoutro + voutroverif5102;

                                            } else {

                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5405">
                                            if (cfop.equals("5405")) {
                                                voutroverif5405 = parsefloatvoutro + voutroverif5405;

                                            } else {

                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5101">
                                            if (cfop.equals("5101")) {
                                                voutroverif5101 = parsefloatvoutro + voutroverif5101;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5104">
                                            if (cfop.equals("5104")) {
                                                voutroverif5104 = parsefloatvoutro + voutroverif5104;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5106">
                                            if (cfop.equals("5106")) {
                                                voutroverif5106 = parsefloatvoutro + voutroverif5106;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5109">
                                            if (cfop.equals("5109")) {
                                                voutroverif5109 = parsefloatvoutro + voutroverif5109;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5122">
                                            if (cfop.equals("5122")) {
                                                voutroverif5122 = parsefloatvoutro + voutroverif5122;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5124">
                                            if (cfop.equals("5124")) {
                                                voutroverif5124 = parsefloatvoutro + voutroverif5124;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5125">
                                            if (cfop.equals("5125")) {
                                                voutroverif5125 = parsefloatvoutro + voutroverif5125;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5152">
                                            if (cfop.equals("5152")) {
                                                voutroverif5152 = parsefloatvoutro + voutroverif5152;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5201">
                                            if (cfop.equals("5201")) {
                                                voutroverif5201 = parsefloatvoutro + voutroverif5201;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5401">
                                            if (cfop.equals("5401")) {
                                                voutroverif5401 = parsefloatvoutro + voutroverif5401;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5402">
                                            if (cfop.equals("5402")) {
                                                voutroverif5402 = parsefloatvoutro + voutroverif5402;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5403">
                                            if (cfop.equals("5403")) {
                                                voutroverif5403 = parsefloatvoutro + voutroverif5403;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5409">
                                            if (cfop.equals("5409")) {
                                                voutroverif5409 = parsefloatvoutro + voutroverif5409;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5410">
                                            if (cfop.equals("5410")) {
                                                voutroverif5410 = parsefloatvoutro + voutroverif5410;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5411">
                                            if (cfop.equals("5411")) {
                                                voutroverif5411 = parsefloatvoutro + voutroverif5411;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5556">
                                            if (cfop.equals("5556")) {
                                                voutroverif5556 = parsefloatvoutro + voutroverif5556;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5556">
                                            if (cfop.equals("5556")) {
                                                voutroverif5556 = parsefloatvoutro + voutroverif5556;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5901">
                                            if (cfop.equals("5901")) {
                                                voutroverif5901 = parsefloatvoutro + voutroverif5901;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5902">
                                            if (cfop.equals("5902")) {
                                                voutroverif5902 = parsefloatvoutro + voutroverif5902;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5910">
                                            if (cfop.equals("5910")) {
                                                voutroverif5910 = parsefloatvoutro + voutroverif5910;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5911">
                                            if (cfop.equals("5911")) {
                                                voutroverif5911 = parsefloatvoutro + voutroverif5911;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5915">
                                            if (cfop.equals("5915")) {
                                                voutroverif5915 = parsefloatvoutro + voutroverif5915;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5916">
                                            if (cfop.equals("5916")) {
                                                voutroverif5916 = parsefloatvoutro + voutroverif5916;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5920">
                                            if (cfop.equals("5920")) {
                                                voutroverif5920 = parsefloatvoutro + voutroverif5920;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5921">
                                            if (cfop.equals("5921")) {
                                                voutroverif5921 = parsefloatvoutro + voutroverif5921;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5924">
                                            if (cfop.equals("5924")) {
                                                voutroverif5924 = parsefloatvoutro + voutroverif5924;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5925">
                                            if (cfop.equals("5925")) {
                                                voutroverif5925 = parsefloatvoutro + voutroverif5915;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5929">
                                            if (cfop.equals("5929")) {
                                                voutroverif5929 = parsefloatvoutro + voutroverif5929;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5949">
                                            if (cfop.equals("5949")) {
                                                voutroverif5949 = parsefloatvoutro + voutroverif5949;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif6101">
                                            if (cfop.equals("6101")) {
                                                voutroverif6101 = parsefloatvoutro + voutroverif6101;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif6102">
                                            if (cfop.equals("6102")) {
                                                voutroverif6102 = parsefloatvoutro + voutroverif6102;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif6104">
                                            if (cfop.equals("6104")) {
                                                voutroverif6104 = parsefloatvoutro + voutroverif6104;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif6106">
                                            if (cfop.equals("6106")) {
                                                voutroverif6106 = parsefloatvoutro + voutroverif6106;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif6152">
                                            if (cfop.equals("6152")) {
                                                voutroverif6152 = parsefloatvoutro + voutroverif6152;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif6201">
                                            if (cfop.equals("6201")) {
                                                voutroverif6201 = parsefloatvoutro + voutroverif6201;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif6202">
                                            if (cfop.equals("6202")) {
                                                voutroverif6202 = parsefloatvoutro + voutroverif6202;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif6401">
                                            if (cfop.equals("6401")) {
                                                voutroverif6401 = parsefloatvoutro + voutroverif6401;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif6402">
                                            if (cfop.equals("6402")) {
                                                voutroverif6402 = parsefloatvoutro + voutroverif6402;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif6403">
                                            if (cfop.equals("6403")) {
                                                voutroverif6403 = parsefloatvoutro + voutroverif6403;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif6404">
                                            if (cfop.equals("6404")) {
                                                voutroverif6404 = parsefloatvoutro + voutroverif6404;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif6409">
                                            if (cfop.equals("6409")) {
                                                voutroverif6409 = parsefloatvoutro + voutroverif6409;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif6410">
                                            if (cfop.equals("6410")) {
                                                voutroverif6410 = parsefloatvoutro + voutroverif6410;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif6411">
                                            if (cfop.equals("6411")) {
                                                voutroverif6411 = parsefloatvoutro + voutroverif6411;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif6413">
                                            if (cfop.equals("6413")) {
                                                voutroverif6413 = parsefloatvoutro + voutroverif6413;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif6556">
                                            if (cfop.equals("6556")) {
                                                voutroverif6556 = parsefloatvoutro + voutroverif6556;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif6901">
                                            if (cfop.equals("6901")) {
                                                voutroverif6901 = parsefloatvoutro + voutroverif6901;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif6902">
                                            if (cfop.equals("6902")) {
                                                voutroverif6902 = parsefloatvoutro + voutroverif6902;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif6910">
                                            if (cfop.equals("6910")) {
                                                voutroverif6910 = parsefloatvoutro + voutroverif6910;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5915">
                                            if (cfop.equals("5915")) {
                                                voutroverif5915 = parsefloatvoutro + voutroverif5915;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif6911">
                                            if (cfop.equals("6911")) {
                                                voutroverif6911 = parsefloatvoutro + voutroverif6911;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif6915">
                                            if (cfop.equals("6915")) {
                                                voutroverif6915 = parsefloatvoutro + voutroverif6915;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif6916">
                                            if (cfop.equals("6916")) {
                                                voutroverif6916 = parsefloatvoutro + voutroverif6916;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif6920">
                                            if (cfop.equals("6920")) {
                                                voutroverif6920 = parsefloatvoutro + voutroverif6920;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif6921">
                                            if (cfop.equals("6921")) {
                                                voutroverif6921 = parsefloatvoutro + voutroverif6921;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif6924">
                                            if (cfop.equals("6924")) {
                                                voutroverif6924 = parsefloatvoutro + voutroverif6924;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif6925">
                                            if (cfop.equals("6925")) {
                                                voutroverif6925 = parsefloatvoutro + voutroverif6925;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif6929">
                                            if (cfop.equals("6929")) {
                                                voutroverif6929 = parsefloatvoutro + voutroverif6929;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif6949">
                                            if (cfop.equals("6949")) {
                                                voutroverif6949 = parsefloatvoutro + voutroverif6949;
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif1411">
                                            if (cfop.equals("1411")) {
                                                voutroverif1411 = parsefloatvoutro + voutroverif1411;

                                            } else {

                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif1410">
                                            if (cfop.equals("1410")) {
                                                voutroverif1410 = parsefloatvoutro + voutroverif1410;

                                            } else {

                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="voutroverif5105">
                                            if (cfop.equals("5105")) {
                                                voutroverif5105 = parsefloatvoutro + voutroverif5105;
                                            }
                                            //</editor-fold>

//</editor-fold>
                                            break;
                                        //</editor-fold>

                                        // <editor-fold defaultstate="collapsed" desc="qCom">
                                        case "qCom":

                                            // txtAreaExemplo.appendText("\t" + "QUANTIDADE COMERCIAL = " + "\t" + elementodados.getTextContent());
                                            break;
                                        //</editor-fold>

                                        // <editor-fold defaultstate="collapsed" desc="vUnCom">
                                        case "vUnCom":

                                            // txtAreaExemplo.appendText("\t" + "VALOR UNIDADE COMERCIAL = " + "\t" + elementodados.getTextContent());
                                            break;
                                        //</editor-fold>

                                        // <editor-fold defaultstate="collapsed" desc="vProd">
                                        case "vProd":
                                            vprod = elementodados.getTextContent();

                                            break;
                                        //</editor-fold>

                                        // <editor-fold defaultstate="collapsed" desc="cEANTrib">
                                        case "cEANTrib":

                                            // txtAreaExemplo.appendText("\t" + "CÓDIGO EAN TRIBUTAVEL = " + "\t" + elementodados.getTextContent());
                                            break;
                                        //</editor-fold>

                                        // <editor-fold defaultstate="collapsed" desc="uTrib">
                                        case "uTrib":

                                            // txtAreaExemplo.appendText("\t" + "UNIDADE TRIBUTAVEL = " + "\t" + elementodados.getTextContent());
                                            break;
                                        //</editor-fold>

                                        // <editor-fold defaultstate="collapsed" desc="qTrib">
                                        case "qTrib":

                                            //txtAreaExemplo.appendText("\t" + "QUANTIDADE TRIBUTAVEL = " + "\t" + elementodados.getTextContent());
                                            break;
                                        //</editor-fold>

                                        // <editor-fold defaultstate="collapsed" desc="vUnTrib">
                                        case "vUnTrib":

                                            break;
                                        //</editor-fold>

                                        // <editor-fold defaultstate="collapsed" desc="indTot">
                                        case "indTot":

                                            // txtAreaExemplo.appendText("\t" + "INDTOT = " + "\t" + elementodados.getTextContent());
                                            break;
                                        //</editor-fold>

                                        // <editor-fold defaultstate="collapsed" desc="xPed">
                                        case "xPed":

                                            //txtAreaExemplo.appendText("\t" + "XPED = " + "\t" + elementodados.getTextContent());
                                            break;
                                        //</editor-fold>

                                        // <editor-fold defaultstate="collapsed" desc="nFCI">
                                        case "nFCI":

                                            //txtAreaExemplo.appendText("\t" + "NFCI = " + "\t" + elementodados.getTextContent());
                                            break;
                                        //</editor-fold>

                                        // <editor-fold defaultstate="collapsed" desc="med">
                                        case "med":
// <editor-fold defaultstate="collapsed" desc="nLote">
                                            NodeList nlote = elementoFilho.getElementsByTagName("nLote");
                                            int nlotee = nlote.getLength();

                                            for (int o = 0; o < nlotee; o++) {

                                                Node noFilhoss = nlote.item(o);

                                                if (noFilhoss.getNodeType() == Node.ELEMENT_NODE) {

                                                    Element elementodadoss = (Element) noFilhoss;
                                                    switch (elementodadoss.getTagName()) {
                                                        case "nLote":
                                                            //txtAreaExemplo.appendText("\t" + "nLote=" + "\t" + elementodadoss.getTextContent());
                                                            break;

                                                    }

                                                }

                                            }
                                            //</editor-fold>

// <editor-fold defaultstate="collapsed" desc="qLote">
                                            NodeList qlote = elementoFilho.getElementsByTagName("qLote");
                                            int qlotee = qlote.getLength();

                                            for (int o = 0; o < qlotee; o++) {

                                                Node noFilhoss = qlote.item(o);

                                                if (noFilhoss.getNodeType() == Node.ELEMENT_NODE) {

                                                    Element elementodadoss = (Element) noFilhoss;
                                                    switch (elementodadoss.getTagName()) {
                                                        case "qLote":
                                                            // txtAreaExemplo.appendText("\t" + "qLote = " + "\t" + elementodadoss.getTextContent());
                                                            break;

                                                    }

                                                }

                                            }
                                            //</editor-fold>

// <editor-fold defaultstate="collapsed" desc="dFab">
                                            NodeList dfab = elementoFilho.getElementsByTagName("dFab");
                                            int dfabb = dfab.getLength();

                                            for (int o = 0; o < dfabb; o++) {

                                                Node noFilhoss = dfab.item(o);

                                                if (noFilhoss.getNodeType() == Node.ELEMENT_NODE) {

                                                    Element elementodadoss = (Element) noFilhoss;
                                                    switch (elementodadoss.getTagName()) {
                                                        case "dFab":
                                                            //txtAreaExemplo.appendText("\t" + "dFab = " + "\t" + elementodadoss.getTextContent());
                                                            break;

                                                    }

                                                }

                                            }
                                            //</editor-fold>

// <editor-fold defaultstate="collapsed" desc="dVal">
                                            NodeList dval = elementoFilho.getElementsByTagName("dVal");
                                            int dvall = dval.getLength();

                                            for (int o = 0; o < dvall; o++) {

                                                Node noFilhoss = dval.item(o);

                                                if (noFilhoss.getNodeType() == Node.ELEMENT_NODE) {

                                                    Element elementodadoss = (Element) noFilhoss;
                                                    switch (elementodadoss.getTagName()) {
                                                        case "dVal":
                                                            //txtAreaExemplo.appendText("\t" + "dVal = " + "\t" + elementodadoss.getTextContent());
                                                            break;

                                                    }

                                                }

                                            }
                                            //</editor-fold>

// <editor-fold defaultstate="collapsed" desc="vPMC">
                                            NodeList vpmc = elementoFilho.getElementsByTagName("vPMC");
                                            int vpmcc = vpmc.getLength();

                                            for (int o = 0; o < vpmcc; o++) {

                                                Node noFilhoss = vpmc.item(o);

                                                if (noFilhoss.getNodeType() == Node.ELEMENT_NODE) {

                                                    Element elementodadoss = (Element) noFilhoss;
                                                    switch (elementodadoss.getTagName()) {
                                                        case "vPMC":
                                                            // txtAreaExemplo.appendText("\t" + "vPMC = " + "\t" + elementodadoss.getTextContent());
                                                            break;

                                                    }

                                                }

                                            }
                                            //</editor-fold>

                                            break;
                                        //</editor-fold>

                                        // <editor-fold defaultstate="collapsed" desc="ORIG(ICMS)">
                                        case "ICMS":

                                            NodeList icmss = elementoFilho.getElementsByTagName("orig");
                                            int tamanhodadosss = icmss.getLength();

                                            for (int o = 0; o < tamanhodadosss; o++) {

                                                Node noFilhoss = icmss.item(o);

                                                if (noFilhoss.getNodeType() == Node.ELEMENT_NODE) {

                                                    Element elementodadoss = (Element) noFilhoss;
                                                    switch (elementodadoss.getTagName()) {
                                                        case "orig":
                                                            //txtAreaExemplo.appendText("\t" + "orig = " + "\t" + elementodadoss.getTextContent());
                                                            break;

                                                    }

                                                }

                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="vBCSTRet">
                                            NodeList vb = elementoFilho.getElementsByTagName("vBCSTRet");
                                            int vbb = vb.getLength();

                                            for (int o = 0; o < vbb; o++) {

                                                Node noFilhoss = vb.item(o);

                                                if (noFilhoss.getNodeType() == Node.ELEMENT_NODE) {

                                                    Element elementodadoss = (Element) noFilhoss;
                                                    switch (elementodadoss.getTagName()) {
                                                        case "vBCSTRet":
                                                            //txtAreaExemplo.appendText("\t" + "vBCSTRet = " + "\t" + elementodadoss.getTextContent());
                                                            break;

                                                    }

                                                }

                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="vICMSSTRet">
                                            NodeList vi = elementoFilho.getElementsByTagName("vICMSSTRet");
                                            int vii = vi.getLength();

                                            for (int o = 0; o < vii; o++) {

                                                Node noFilhoss = vi.item(o);

                                                if (noFilhoss.getNodeType() == Node.ELEMENT_NODE) {

                                                    Element elementodadoss = (Element) noFilhoss;
                                                    switch (elementodadoss.getTagName()) {
                                                        case "vICMSSTRet":
                                                            // txtAreaExemplo.appendText("\t" + "vICMSSTRet = " + "\t" + elementodadoss.getTextContent());
                                                            break;

                                                    }

                                                }

                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="CST"> //  
                                            NodeList icms = elementoFilho.getElementsByTagName("CST");

                                            int tamanhodadoss = icms.getLength();

                                            for (int o = 0; o < tamanhodadoss; o++) {

                                                Node noFilhoss = icms.item(o);

                                                if (noFilhoss.getNodeType() == Node.ELEMENT_NODE) {

                                                    Element elementodadoss = (Element) noFilhoss;
                                                    switch (elementodadoss.getTagName()) {

                                                        case "CST":
                                                            cst = elementodadoss.getTextContent();
                                                            parsefloat = Float.parseFloat(vprod);

                                                            // <editor-fold defaultstate="collapsed" desc="CST5405">
                                                            if (cfop.equals(var5405) && cst.equals(cst60) || cfop.equals(var5405) && cst.equals(cst00) || cfop.equals(var5405) && cst.equals(cst10)
                                                                    || cfop.equals(var5405) && cst.equals(cst20) || cfop.equals(var5405) && cst.equals(cst30) || cfop.equals(var5405) && cst.equals(cst40)
                                                                    || cfop.equals(var5405) && cst.equals(cst41) || cfop.equals(var5405) && cst.equals(cst50) || cfop.equals(var5405) && cst.equals(cst51)
                                                                    || cfop.equals(var5405) && cst.equals(cst70) || cfop.equals(var5405) && cst.equals(cst90)) {

                                                                vprod5405 = parsefloat + vprod5405;
                                                                total_outras5405 = vprod5405 + voutroverif5405 - vdesc5405;
                                                                valor_total_nota5405 = vprod5405 + voutroverif5405 - vdesc5405;

                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST5102">
                                                            if (cfop.equals(var5102) && cst.equals(cst60) || cfop.equals(var5102) && cst.equals(cst00) || cfop.equals(var5102) && cst.equals(cst10)
                                                                    || cfop.equals(var5102) && cst.equals(cst20) || cfop.equals(var5102) && cst.equals(cst30) || cfop.equals(var5102) && cst.equals(cst40)
                                                                    || cfop.equals(var5102) && cst.equals(cst41) || cfop.equals(var5102) && cst.equals(cst50) || cfop.equals(var5102) && cst.equals(cst51)
                                                                    || cfop.equals(var5102) && cst.equals(cst70) || cfop.equals(var5102) && cst.equals(cst90)) {

                                                                vprod5102 = parsefloat + vprod5102;
                                                                valor_total_nota5102 = vprod5102 + voutroverif5102 - vdesc5102;

                                                                if (cst.equals(cst40) || cst.equals(cst41) || cst.equals(50) || cst.equals(icmssn102) || cst.equals(icmssn103) || cst.equals(icmssn3)) {

                                                                    valor_isentas_naotributadas5102 = valor_isentas_naotributadas5102 + parsefloat + voutroverif5102 - vdesc5102;

                                                                }
                                                                total_outras5102 = vprod5102 + voutroverif5102 - vdesc5102 - valor_isentas_naotributadas5102;

                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST5101">
                                                            if (cfop.equals(var5101) && cst.equals(cst60) || cfop.equals(var5101) && cst.equals(cst00) || cfop.equals(var5101) && cst.equals(cst10)
                                                                    || cfop.equals(var5101) && cst.equals(cst20) || cfop.equals(var5101) && cst.equals(cst30) || cfop.equals(var5101) && cst.equals(cst40)
                                                                    || cfop.equals(var5101) && cst.equals(cst41) || cfop.equals(var5101) && cst.equals(cst50) || cfop.equals(var5101) && cst.equals(cst51)
                                                                    || cfop.equals(var5101) && cst.equals(cst70) || cfop.equals(var5101) && cst.equals(cst90)) {

                                                                vprod5101 = parsefloat + vprod5101;

                                                                valor_total_nota5101 = vprod5101 + voutroverif5101 - vdesc5101;

                                                                if (cst.equals(cst40) || cst.equals(cst41) || cst.equals(50) || cst.equals(icmssn102) || cst.equals(icmssn103) || cst.equals(icmssn3)) {

                                                                    valor_isentas_naotributadas5101 = valor_isentas_naotributadas5101 + parsefloat - vdesc5101 + voutroverif5101;

                                                                }
                                                                total_outras5101 = vprod5101 + voutroverif5101 - vdesc5101 - valor_isentas_naotributadas5101;

                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST5104">
                                                            if (cfop.equals(var5104) && cst.equals(cst60) || cfop.equals(var5104) && cst.equals(cst00) || cfop.equals(var5104) && cst.equals(cst10)
                                                                    || cfop.equals(var5104) && cst.equals(cst20) || cfop.equals(var5104) && cst.equals(cst30) || cfop.equals(var5104) && cst.equals(cst40)
                                                                    || cfop.equals(var5104) && cst.equals(cst41) || cfop.equals(var5104) && cst.equals(cst50) || cfop.equals(var5104) && cst.equals(cst51)
                                                                    || cfop.equals(var5104) && cst.equals(cst70) || cfop.equals(var5104) && cst.equals(cst90)) {

                                                                vprod5104 = parsefloat + vprod5104;
                                                                valor_total_nota5104 = vprod5104 + voutroverif5104 - vdesc5104;
                                                                total_outras5104 = vprod5104 + voutroverif5104 - vdesc5104;

                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST5403">
                                                            if (cfop.equals(var5403) && cst.equals(cst60) || cfop.equals(var5403) && cst.equals(cst00) || cfop.equals(var5403) && cst.equals(cst10)
                                                                    || cfop.equals(var5403) && cst.equals(cst20) || cfop.equals(var5403) && cst.equals(cst30) || cfop.equals(var5403) && cst.equals(cst40)
                                                                    || cfop.equals(var5403) && cst.equals(cst41) || cfop.equals(var5403) && cst.equals(cst50) || cfop.equals(var5403) && cst.equals(cst51)
                                                                    || cfop.equals(var5403) && cst.equals(cst70) || cfop.equals(var5403) && cst.equals(cst90)) {

                                                                vprod5403 = parsefloat + vprod5403;
                                                                valor_total_nota5403 = vprod5403 + voutroverif5403 - vdesc5403;
                                                                total_outras5403 = vprod5403 + voutroverif5403 - vdesc5403;
                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST5401">
                                                            if (cfop.equals(var5401) && cst.equals(cst60) || cfop.equals(var5401) && cst.equals(cst00) || cfop.equals(var5401) && cst.equals(cst10)
                                                                    || cfop.equals(var5401) && cst.equals(cst20) || cfop.equals(var5401) && cst.equals(cst30) || cfop.equals(var5401) && cst.equals(cst40)
                                                                    || cfop.equals(var5401) && cst.equals(cst41) || cfop.equals(var5401) && cst.equals(cst50) || cfop.equals(var5401) && cst.equals(cst51)
                                                                    || cfop.equals(var5401) && cst.equals(cst70) || cfop.equals(var5401) && cst.equals(cst90)) {
                                                                vprod5401 = parsefloat + vprod5401;
                                                                valor_total_nota5401 = vprod5401 + voutroverif5401 - vdesc5401;
                                                                total_outras5401 = vprod5401 + voutroverif5401 - vdesc5401;
                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST5910">
                                                            if (cfop.equals(var5910) && cst.equals(cst60) || cfop.equals(var5910) && cst.equals(cst00) || cfop.equals(var5910) && cst.equals(cst10)
                                                                    || cfop.equals(var5910) && cst.equals(cst20) || cfop.equals(var5910) && cst.equals(cst30) || cfop.equals(var5910) && cst.equals(cst40)
                                                                    || cfop.equals(var5910) && cst.equals(cst41) || cfop.equals(var5910) && cst.equals(cst50) || cfop.equals(var5910) && cst.equals(cst51)
                                                                    || cfop.equals(var5910) && cst.equals(cst70) || cfop.equals(var5910) && cst.equals(cst90)) {
                                                                vprod5910 = parsefloat + vprod5910;
                                                                valor_total_nota5910 = vprod5910 + voutroverif5910 - vdesc5910;
                                                                total_outras5910 = vprod5910 + voutroverif5910 - vdesc5910;
                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST5949">
                                                            if (cfop.equals(var5949) && cst.equals(cst60) || cfop.equals(var5949) && cst.equals(cst00) || cfop.equals(var5949) && cst.equals(cst10)
                                                                    || cfop.equals(var5949) && cst.equals(cst20) || cfop.equals(var5949) && cst.equals(cst30) || cfop.equals(var5949) && cst.equals(cst40)
                                                                    || cfop.equals(var5949) && cst.equals(cst41) || cfop.equals(var5949) && cst.equals(cst50) || cfop.equals(var5949) && cst.equals(cst51)
                                                                    || cfop.equals(var5949) && cst.equals(cst70) || cfop.equals(var5949) && cst.equals(cst90)) {
                                                                vprod5949 = parsefloat + vprod5949;
                                                                valor_total_nota5949 = vprod5949 + voutroverif5949 - vdesc5949;
                                                                total_outras5949 = vprod5949 + voutroverif5949 - vdesc5949;
                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST1411">
                                                            if (cfop.equals(var1411) && cst.equals(cst60) || cfop.equals(var1411) && cst.equals(cst00) || cfop.equals(var1411) && cst.equals(cst10)
                                                                    || cfop.equals(var1411) && cst.equals(cst20) || cfop.equals(var1411) && cst.equals(cst30) || cfop.equals(var1411) && cst.equals(cst40)
                                                                    || cfop.equals(var1411) && cst.equals(cst41) || cfop.equals(var1411) && cst.equals(cst50) || cfop.equals(var1411) && cst.equals(cst51)
                                                                    || cfop.equals(var1411) && cst.equals(cst70) || cfop.equals(var1411) && cst.equals(cst90)) {
                                                                vprod1411 = parsefloat + vprod1411;
                                                                valor_total_nota1411 = vprod1411 + voutroverif1411 - vdesc1411;
                                                                total_outras1411 = vprod1411 + voutroverif1411 - vdesc1411;
                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST5929">
                                                            if (cfop.equals(var5929) && cst.equals(cst60) || cfop.equals(var5929) && cst.equals(cst00) || cfop.equals(var5929) && cst.equals(cst10)
                                                                    || cfop.equals(var5929) && cst.equals(cst20) || cfop.equals(var5929) && cst.equals(cst30) || cfop.equals(var5929) && cst.equals(cst40)
                                                                    || cfop.equals(var5929) && cst.equals(cst41) || cfop.equals(var5929) && cst.equals(cst50) || cfop.equals(var5929) && cst.equals(cst51)
                                                                    || cfop.equals(var5929) && cst.equals(cst70) || cfop.equals(var5929) && cst.equals(cst90)) {

                                                                vprod5929 = parsefloat + vprod5929;
                                                                total_outras5929 = vprod5929 + voutroverif5929 - vdesc5929;
                                                                valor_total_nota5929 = vprod5929 + voutroverif5929 - vdesc5929;
                                                                if (cst.equals(cst00) || cst.equals(cst40) || cst.equals(cst41) || cst.equals(cst20)) {
                                                                    cfopat1949 = "1102";
                                                                } else {
                                                                    cfopat1949 = "1403";
                                                                }

                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST1410">
                                                            if (cfop.equals(var1410) && cst.equals(cst60) || cfop.equals(var1410) && cst.equals(cst00) || cfop.equals(var1410) && cst.equals(cst10)
                                                                    || cfop.equals(var1410) && cst.equals(cst20) || cfop.equals(var1410) && cst.equals(cst30) || cfop.equals(var1410) && cst.equals(cst40)
                                                                    || cfop.equals(var1410) && cst.equals(cst41) || cfop.equals(var1410) && cst.equals(cst50) || cfop.equals(var1410) && cst.equals(cst51)
                                                                    || cfop.equals(var1410) && cst.equals(cst70) || cfop.equals(var1410) && cst.equals(cst90)) {
                                                                vprod1410 = parsefloat + vprod1410;
                                                                valor_total_nota1410 = vprod1410 + voutroverif1410 - vdesc1410;
                                                                total_outras1410 = vprod1410 + voutroverif1410 - vdesc1410;
                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST6910">
                                                            if (cfop.equals(var6910) && cst.equals(cst60) || cfop.equals(var6910) && cst.equals(cst00) || cfop.equals(var6910) && cst.equals(cst10)
                                                                    || cfop.equals(var6910) && cst.equals(cst20) || cfop.equals(var6910) && cst.equals(cst30) || cfop.equals(var6910) && cst.equals(cst40)
                                                                    || cfop.equals(var6910) && cst.equals(cst41) || cfop.equals(var6910) && cst.equals(cst50) || cfop.equals(var6910) && cst.equals(cst51)
                                                                    || cfop.equals(var6910) && cst.equals(cst70) || cfop.equals(var6910) && cst.equals(cst90)) {

                                                                vprod6910 = parsefloat + vprod6910;
                                                                total_outras6910 = vprod6910 + voutroverif6910 - vdesc6910;
                                                                valor_total_nota6910 = vprod6910 + voutroverif6910 - vdesc6910;

                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST6102">
                                                            if (cfop.equals(var6102) && cst.equals(cst60) || cfop.equals(var6102) && cst.equals(cst00) || cfop.equals(var6102) && cst.equals(cst10)
                                                                    || cfop.equals(var6102) && cst.equals(cst20) || cfop.equals(var6102) && cst.equals(cst30) || cfop.equals(var6102) && cst.equals(cst40)
                                                                    || cfop.equals(var6102) && cst.equals(cst41) || cfop.equals(var6102) && cst.equals(cst50) || cfop.equals(var6102) && cst.equals(cst51)
                                                                    || cfop.equals(var6102) && cst.equals(cst70) || cfop.equals(var6102) && cst.equals(cst90)) {

                                                                vprod6102 = parsefloat + vprod6102;
                                                                total_outras6102 = vprod6102 + voutroverif6102 - vdesc6102;
                                                                valor_total_nota6102 = vprod6102 + voutroverif6102 - vdesc6102;

                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST5911">
                                                            if (cfop.equals(var5911) && cst.equals(cst60) || cfop.equals(var5911) && cst.equals(cst00) || cfop.equals(var5911) && cst.equals(cst10)
                                                                    || cfop.equals(var5911) && cst.equals(cst20) || cfop.equals(var5911) && cst.equals(cst30) || cfop.equals(var5911) && cst.equals(cst40)
                                                                    || cfop.equals(var5911) && cst.equals(cst41) || cfop.equals(var5911) && cst.equals(cst50) || cfop.equals(var5911) && cst.equals(cst51)
                                                                    || cfop.equals(var5911) && cst.equals(cst70) || cfop.equals(var5911) && cst.equals(cst90)) {
                                                                vprod5911 = parsefloat + vprod5911;
                                                                valor_total_nota5911 = vprod5911 + voutroverif5911 - vdesc5911;
                                                                total_outras5911 = vprod5911 + voutroverif5911 - vdesc5911;
                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST5106">
                                                            if (cfop.equals(var5106) && cst.equals(cst60) || cfop.equals(var5106) && cst.equals(cst00) || cfop.equals(var5106) && cst.equals(cst10)
                                                                    || cfop.equals(var5106) && cst.equals(cst20) || cfop.equals(var5106) && cst.equals(cst30) || cfop.equals(var5106) && cst.equals(cst40)
                                                                    || cfop.equals(var5106) && cst.equals(cst41) || cfop.equals(var5106) && cst.equals(cst50) || cfop.equals(var5106) && cst.equals(cst51)
                                                                    || cfop.equals(var5106) && cst.equals(cst70) || cfop.equals(var5106) && cst.equals(cst90)) {
                                                                vprod5106 = parsefloat + vprod5106;
                                                                valor_total_nota5106 = vprod5106 + voutroverif5106 - vdesc5106;
                                                                total_outras5106 = vprod5106 + voutroverif5106 - vdesc5106;
                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST5105">
                                                            if (cfop.equals(var5105) && cst.equals(cst60) || cfop.equals(var5105) && cst.equals(cst00) || cfop.equals(var5105) && cst.equals(cst10)
                                                                    || cfop.equals(var5105) && cst.equals(cst20) || cfop.equals(var5105) && cst.equals(cst30) || cfop.equals(var5105) && cst.equals(cst40)
                                                                    || cfop.equals(var5105) && cst.equals(cst41) || cfop.equals(var5105) && cst.equals(cst50) || cfop.equals(var5105) && cst.equals(cst51)
                                                                    || cfop.equals(var5105) && cst.equals(cst70) || cfop.equals(var5105) && cst.equals(cst90)) {
                                                                vprod5105 = parsefloat + vprod5105;
                                                                valor_total_nota5105 = vprod5105 + voutroverif5105 - vdesc5105;
                                                                total_outras5105 = vprod5105 + voutroverif5105 - vdesc5105;
                                                            }
                                                            //</editor-fold>
                                                            break;
                                                    }
                                                }
                                            }
                                            //</editor-fold>

                                            // <editor-fold defaultstate="collapsed" desc="CSOSN"> 
                                            NodeList csocsn = elementoFilho.getElementsByTagName("CSOSN");

                                            int csocsna = csocsn.getLength();

                                            for (int o = 0; o < csocsna; o++) {

                                                Node noFilhoss = csocsn.item(o);

                                                if (noFilhoss.getNodeType() == Node.ELEMENT_NODE) {

                                                    Element elementodadoss = (Element) noFilhoss;
                                                    switch (elementodadoss.getTagName()) {

                                                        case "CSOSN":
                                                            valor_csosn = elementodadoss.getTextContent();
                                                            parsefloat = Float.parseFloat(vprod);

                                                            // <editor-fold defaultstate="collapsed" desc="CST5405">
                                                            if (cfop.equals(var5405) && valor_csosn.equals(icmssn101) || cfop.equals(var5405) && valor_csosn.equals(icmssn102)
                                                                    || cfop.equals(var5405) && valor_csosn.equals(icmssn103) || cfop.equals(var5405) && valor_csosn.equals(icmssn3) || cfop.equals(var5405) && valor_csosn.equals(icmssn201)
                                                                    || cfop.equals(var5405) && valor_csosn.equals(icmssn202) || cfop.equals(var5405) && valor_csosn.equals(icmssn203) || cfop.equals(var5405) && valor_csosn.equals(icmssn203)
                                                                    || cfop.equals(var5405) && valor_csosn.equals(icmssn500) || cfop.equals(var5405) && valor_csosn.equals(icmssn900) || cfop.equals(var5405) && valor_csosn.equals(icmssn300) || cfop.equals(var5405) && valor_csosn.equals(icmssn400)) {

                                                                vprod5405 = parsefloat + vprod5405;
                                                                total_outras5405 = vprod5405 + voutroverif5405 - vdesc5405;
                                                                valor_total_nota5405 = vprod5405 + voutroverif5405 - vdesc5405;

                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST5102">
                                                            if (cfop.equals(var5102) && valor_csosn.equals(icmssn101) || cfop.equals(var5102) && valor_csosn.equals(icmssn102)
                                                                    || cfop.equals(var5102) && valor_csosn.equals(icmssn103) || cfop.equals(var5102) && valor_csosn.equals(icmssn3) || cfop.equals(var5102) && valor_csosn.equals(icmssn201)
                                                                    || cfop.equals(var5102) && valor_csosn.equals(icmssn202) || cfop.equals(var5102) && valor_csosn.equals(icmssn203) || cfop.equals(var5102) && valor_csosn.equals(icmssn203)
                                                                    || cfop.equals(var5102) && valor_csosn.equals(icmssn500) || cfop.equals(var5102) && valor_csosn.equals(icmssn900) || cfop.equals(var5102) && valor_csosn.equals(icmssn300) || cfop.equals(var5102) && valor_csosn.equals(icmssn400)) {

                                                                vprod5102 = parsefloat + vprod5102;
                                                                valor_total_nota5102 = vprod5102 + voutroverif5102 - vdesc5102;

                                                                if (valor_csosn.equals(icmssn102) || valor_csosn.equals(icmssn103) || valor_csosn.equals(icmssn3)) {

                                                                    valor_isentas_naotributadas5102 = valor_isentas_naotributadas5102 + parsefloat + voutroverif5102 - vdesc5102;

                                                                }
                                                                total_outras5102 = vprod5102 + voutroverif5102 - vdesc5102 - valor_isentas_naotributadas5102;

                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST5101">
                                                            if (cfop.equals(var5101) && valor_csosn.equals(icmssn101) || cfop.equals(var5101) && valor_csosn.equals(icmssn102)
                                                                    || cfop.equals(var5101) && valor_csosn.equals(icmssn103) || cfop.equals(var5101) && valor_csosn.equals(icmssn3) || cfop.equals(var5101) && valor_csosn.equals(icmssn201)
                                                                    || cfop.equals(var5101) && valor_csosn.equals(icmssn202) || cfop.equals(var5101) && valor_csosn.equals(icmssn203) || cfop.equals(var5101) && valor_csosn.equals(icmssn203)
                                                                    || cfop.equals(var5101) && valor_csosn.equals(icmssn500) || cfop.equals(var5101) && valor_csosn.equals(icmssn900) || cfop.equals(var5101) && valor_csosn.equals(icmssn300) || cfop.equals(var5101) && valor_csosn.equals(icmssn400)) {

                                                                vprod5101 = parsefloat + vprod5101;

                                                                valor_total_nota5101 = vprod5101 + voutroverif5101 - vdesc5101;

                                                                if (valor_csosn.equals(icmssn102) || valor_csosn.equals(icmssn103) || valor_csosn.equals(icmssn3)) {

                                                                    valor_isentas_naotributadas5101 = valor_isentas_naotributadas5101 + parsefloat - vdesc5101 + voutroverif5101;

                                                                }
                                                                total_outras5101 = vprod5101 + voutroverif5101 - vdesc5101 - valor_isentas_naotributadas5101;

                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST5104">
                                                            if (cfop.equals(var5104) && valor_csosn.equals(icmssn101) || cfop.equals(var5104) && valor_csosn.equals(icmssn102)
                                                                    || cfop.equals(var5104) && valor_csosn.equals(icmssn103) || cfop.equals(var5104) && valor_csosn.equals(icmssn3) || cfop.equals(var5104) && valor_csosn.equals(icmssn201)
                                                                    || cfop.equals(var5104) && valor_csosn.equals(icmssn202) || cfop.equals(var5104) && valor_csosn.equals(icmssn203) || cfop.equals(var5104) && valor_csosn.equals(icmssn203)
                                                                    || cfop.equals(var5104) && valor_csosn.equals(icmssn500) || cfop.equals(var5104) && valor_csosn.equals(icmssn900) || cfop.equals(var5104) && valor_csosn.equals(icmssn300) || cfop.equals(var5104) && valor_csosn.equals(icmssn400)) {

                                                                vprod5104 = parsefloat + vprod5104;
                                                                valor_total_nota5104 = vprod5104 + voutroverif5104 - vdesc5104;
                                                                total_outras5104 = vprod5104 + voutroverif5104 - vdesc5104;

                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST5403">
                                                            if (cfop.equals(var5403) && valor_csosn.equals(icmssn101) || cfop.equals(var5403) && valor_csosn.equals(icmssn102)
                                                                    || cfop.equals(var5403) && valor_csosn.equals(icmssn103) || cfop.equals(var5403) && valor_csosn.equals(icmssn3) || cfop.equals(var5403) && valor_csosn.equals(icmssn201)
                                                                    || cfop.equals(var5403) && valor_csosn.equals(icmssn202) || cfop.equals(var5403) && valor_csosn.equals(icmssn203) || cfop.equals(var5403) && valor_csosn.equals(icmssn203)
                                                                    || cfop.equals(var5403) && valor_csosn.equals(icmssn500) || cfop.equals(var5403) && valor_csosn.equals(icmssn900) || cfop.equals(var5403) && valor_csosn.equals(icmssn300) || cfop.equals(var5403) && valor_csosn.equals(icmssn400)) {

                                                                vprod5403 = parsefloat + vprod5403;
                                                                valor_total_nota5403 = vprod5403 + voutroverif5403 - vdesc5403;
                                                                total_outras5403 = vprod5403 + voutroverif5403 - vdesc5403;
                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST5401">
                                                            if (cfop.equals(5401) && valor_csosn.equals(icmssn101) || cfop.equals(5401) && valor_csosn.equals(icmssn102)
                                                                    || cfop.equals(5401) && valor_csosn.equals(icmssn103) || cfop.equals(5401) && valor_csosn.equals(icmssn3) || cfop.equals(5401) && valor_csosn.equals(icmssn201)
                                                                    || cfop.equals(5401) && valor_csosn.equals(icmssn202) || cfop.equals(5401) && valor_csosn.equals(icmssn203) || cfop.equals(5401) && valor_csosn.equals(icmssn203)
                                                                    || cfop.equals(5401) && valor_csosn.equals(icmssn500) || cfop.equals(5401) && valor_csosn.equals(icmssn900) || cfop.equals(5929) && valor_csosn.equals(icmssn300) || cfop.equals(5929) && valor_csosn.equals(icmssn400)) {
                                                                vprod5401 = parsefloat + vprod5401;
                                                                valor_total_nota5401 = vprod5401 + voutroverif5401 - vdesc5401;
                                                                total_outras5401 = vprod5401 + voutroverif5401 - vdesc5401;
                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST5910">
                                                            if (cfop.equals(5910) && valor_csosn.equals(icmssn101) || cfop.equals(5910) && valor_csosn.equals(icmssn102)
                                                                    || cfop.equals(5910) && valor_csosn.equals(icmssn103) || cfop.equals(5910) && valor_csosn.equals(icmssn3) || cfop.equals(5910) && valor_csosn.equals(icmssn201)
                                                                    || cfop.equals(5910) && valor_csosn.equals(icmssn202) || cfop.equals(5910) && valor_csosn.equals(icmssn203) || cfop.equals(5910) && valor_csosn.equals(icmssn203)
                                                                    || cfop.equals(5910) && valor_csosn.equals(icmssn500) || cfop.equals(5910) && valor_csosn.equals(icmssn900) || cfop.equals(5929) && valor_csosn.equals(icmssn300) || cfop.equals(5929) && valor_csosn.equals(icmssn400)) {
                                                                vprod5910 = parsefloat + vprod5910;
                                                                valor_total_nota5910 = vprod5910 + voutroverif5910 - vdesc5910;
                                                                total_outras5910 = vprod5910 + voutroverif5910 - vdesc5910;
                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST5949">
                                                            if (cfop.equals(var5949) && valor_csosn.equals(icmssn101) || cfop.equals(var5949) && valor_csosn.equals(icmssn102)
                                                                    || cfop.equals(var5949) && valor_csosn.equals(icmssn103) || cfop.equals(var5949) && valor_csosn.equals(icmssn3) || cfop.equals(var5949) && valor_csosn.equals(icmssn201)
                                                                    || cfop.equals(var5949) && valor_csosn.equals(icmssn202) || cfop.equals(var5949) && valor_csosn.equals(icmssn203) || cfop.equals(var5949) && valor_csosn.equals(icmssn203)
                                                                    || cfop.equals(var5949) && valor_csosn.equals(icmssn500) || cfop.equals(var5949) && valor_csosn.equals(icmssn900) || cfop.equals(var5949) && valor_csosn.equals(icmssn300) || cfop.equals(var5949) && valor_csosn.equals(icmssn400)) {
                                                                vprod5949 = parsefloat + vprod5949;
                                                                valor_total_nota5949 = vprod5949 + voutroverif5949 - vdesc5949;
                                                                total_outras5949 = vprod5949 + voutroverif5949 - vdesc5949;
                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST1411">
                                                            if (cfop.equals(var1411) && valor_csosn.equals(icmssn101) || cfop.equals(var1411) && valor_csosn.equals(icmssn102)
                                                                    || cfop.equals(var1411) && valor_csosn.equals(icmssn103) || cfop.equals(var1411) && valor_csosn.equals(icmssn3) || cfop.equals(var1411) && valor_csosn.equals(icmssn201)
                                                                    || cfop.equals(var1411) && valor_csosn.equals(icmssn202) || cfop.equals(var1411) && valor_csosn.equals(icmssn203) || cfop.equals(var1411) && valor_csosn.equals(icmssn203)
                                                                    || cfop.equals(var1411) && valor_csosn.equals(icmssn500) || cfop.equals(var1411) && valor_csosn.equals(icmssn900) || cfop.equals(var1411) && valor_csosn.equals(icmssn300) || cfop.equals(var1411) && valor_csosn.equals(icmssn400)) {
                                                                vprod1411 = parsefloat + vprod1411;
                                                                valor_total_nota1411 = vprod1411 + voutroverif1411 - vdesc1411;
                                                                total_outras1411 = vprod1411 + voutroverif1411 - vdesc1411;
                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST5929">
                                                            if (cfop.equals(var5929) && valor_csosn.equals(icmssn101) || cfop.equals(var5929) && valor_csosn.equals(icmssn102)
                                                                    || cfop.equals(var5929) && valor_csosn.equals(icmssn103) || cfop.equals(var5929) && valor_csosn.equals(icmssn3) || cfop.equals(var5929) && valor_csosn.equals(icmssn201)
                                                                    || cfop.equals(var5929) && valor_csosn.equals(icmssn202) || cfop.equals(var5929) && valor_csosn.equals(icmssn203) || cfop.equals(var5929) && valor_csosn.equals(icmssn203)
                                                                    || cfop.equals(var5929) && valor_csosn.equals(icmssn500) || cfop.equals(var5929) && valor_csosn.equals(icmssn900) || cfop.equals(var5929) && valor_csosn.equals(icmssn300) || cfop.equals(var5929) && valor_csosn.equals(icmssn400)) {

                                                                vprod5929 = parsefloat + vprod5929;
                                                                total_outras5929 = vprod5929 + voutroverif5929 - vdesc5929;
                                                                valor_total_nota5929 = vprod5929 + voutroverif5929 - vdesc5929;
                                                                if (valor_csosn.equals(icmssn101) || valor_csosn.equals(icmssn103) || valor_csosn.equals(icmssn300) || valor_csosn.equals(icmssn400)) {
                                                                    cfopat1949 = "1102";
                                                                } else {
                                                                    cfopat1949 = "1403";
                                                                }

                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST1410">
                                                            if (cfop.equals(var1410) && valor_csosn.equals(icmssn101) || cfop.equals(var1410) && valor_csosn.equals(icmssn102)
                                                                    || cfop.equals(var1410) && valor_csosn.equals(icmssn103) || cfop.equals(var1410) && valor_csosn.equals(icmssn3) || cfop.equals(var1410) && valor_csosn.equals(icmssn201)
                                                                    || cfop.equals(var1410) && valor_csosn.equals(icmssn202) || cfop.equals(var1410) && valor_csosn.equals(icmssn203) || cfop.equals(var1410) && valor_csosn.equals(icmssn203)
                                                                    || cfop.equals(var1410) && valor_csosn.equals(icmssn500) || cfop.equals(var1410) && valor_csosn.equals(icmssn900) || cfop.equals(var1410) && valor_csosn.equals(icmssn300) || cfop.equals(var1410) && valor_csosn.equals(icmssn400)) {
                                                                vprod1410 = parsefloat + vprod1410;
                                                                valor_total_nota1410 = vprod1410 + voutroverif1410 - vdesc1410;
                                                                total_outras1410 = vprod1410 + voutroverif1410 - vdesc1410;
                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST6910">
                                                            if (cfop.equals(var6910) && valor_csosn.equals(icmssn101) || cfop.equals(var6910) && valor_csosn.equals(icmssn102)
                                                                    || cfop.equals(var6910) && valor_csosn.equals(icmssn103) || cfop.equals(var6910) && valor_csosn.equals(icmssn3) || cfop.equals(var6910) && valor_csosn.equals(icmssn201)
                                                                    || cfop.equals(var6910) && valor_csosn.equals(icmssn202) || cfop.equals(var6910) && valor_csosn.equals(icmssn203) || cfop.equals(var6910) && valor_csosn.equals(icmssn203)
                                                                    || cfop.equals(var6910) && valor_csosn.equals(icmssn500) || cfop.equals(var6910) && valor_csosn.equals(icmssn900)) {

                                                                vprod6910 = parsefloat + vprod6910;
                                                                total_outras6910 = vprod6910 + voutroverif6910 - vdesc6910;
                                                                valor_total_nota6910 = vprod6910 + voutroverif6910 - vdesc6910;

                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST6102">
                                                            if (cfop.equals(var6102) && valor_csosn.equals(icmssn101) || cfop.equals(var6102) && valor_csosn.equals(icmssn102)
                                                                    || cfop.equals(var6102) && valor_csosn.equals(icmssn103) || cfop.equals(var6102) && valor_csosn.equals(icmssn3) || cfop.equals(var6102) && valor_csosn.equals(icmssn201)
                                                                    || cfop.equals(var6102) && valor_csosn.equals(icmssn202) || cfop.equals(var6102) && valor_csosn.equals(icmssn203) || cfop.equals(var6102) && valor_csosn.equals(icmssn203)
                                                                    || cfop.equals(var6102) && valor_csosn.equals(icmssn500) || cfop.equals(var6102) && valor_csosn.equals(icmssn900)) {

                                                                vprod6102 = parsefloat + vprod6102;
                                                                total_outras6102 = vprod6102 + voutroverif6102 - vdesc6102;
                                                                valor_total_nota6102 = vprod6102 + voutroverif6102 - vdesc6102;

                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST5911">
                                                            if (cfop.equals(5911) && valor_csosn.equals(icmssn101) || cfop.equals(5911) && valor_csosn.equals(icmssn102)
                                                                    || cfop.equals(5911) && valor_csosn.equals(icmssn103) || cfop.equals(5911) && valor_csosn.equals(icmssn3) || cfop.equals(5911) && valor_csosn.equals(icmssn201)
                                                                    || cfop.equals(5911) && valor_csosn.equals(icmssn202) || cfop.equals(5911) && valor_csosn.equals(icmssn203) || cfop.equals(5911) && valor_csosn.equals(icmssn203)
                                                                    || cfop.equals(5911) && valor_csosn.equals(icmssn500) || cfop.equals(5911) && valor_csosn.equals(icmssn900) || cfop.equals(5929) && valor_csosn.equals(icmssn300) || cfop.equals(5929) && valor_csosn.equals(icmssn400)) {
                                                                vprod5911 = parsefloat + vprod5911;
                                                                valor_total_nota5911 = vprod5911 + voutroverif5911 - vdesc5911;
                                                                total_outras5911 = vprod5911 + voutroverif5911 - vdesc5911;
                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST5106">
                                                            if (cfop.equals(5106) && valor_csosn.equals(icmssn101) || cfop.equals(5106) && valor_csosn.equals(icmssn102)
                                                                    || cfop.equals(5106) && valor_csosn.equals(icmssn103) || cfop.equals(5106) && valor_csosn.equals(icmssn3) || cfop.equals(5106) && valor_csosn.equals(icmssn201)
                                                                    || cfop.equals(5106) && valor_csosn.equals(icmssn202) || cfop.equals(5106) && valor_csosn.equals(icmssn203) || cfop.equals(5106) && valor_csosn.equals(icmssn203)
                                                                    || cfop.equals(5106) && valor_csosn.equals(icmssn500) || cfop.equals(5106) && valor_csosn.equals(icmssn900) || cfop.equals(5929) && valor_csosn.equals(icmssn300) || cfop.equals(5929) && valor_csosn.equals(icmssn400)) {
                                                                vprod5106 = parsefloat + vprod5106;
                                                                valor_total_nota5106 = vprod5106 + voutroverif5106 - vdesc5106;
                                                                total_outras5106 = vprod5106 + voutroverif5106 - vdesc5106;
                                                            }
                                                            //</editor-fold>

                                                            // <editor-fold defaultstate="collapsed" desc="CST5105">
                                                            if (cfop.equals(5105) && valor_csosn.equals(icmssn101) || cfop.equals(5105) && valor_csosn.equals(icmssn102)
                                                                    || cfop.equals(5105) && valor_csosn.equals(icmssn103) || cfop.equals(5105) && valor_csosn.equals(icmssn3) || cfop.equals(5105) && valor_csosn.equals(icmssn201)
                                                                    || cfop.equals(5105) && valor_csosn.equals(icmssn202) || cfop.equals(5105) && valor_csosn.equals(icmssn203) || cfop.equals(5105) && valor_csosn.equals(icmssn203)
                                                                    || cfop.equals(5105) && valor_csosn.equals(icmssn500) || cfop.equals(5105) && valor_csosn.equals(icmssn900) || cfop.equals(5929) && valor_csosn.equals(icmssn300) || cfop.equals(5929) && valor_csosn.equals(icmssn400)) {
                                                                vprod5105 = parsefloat + vprod5105;
                                                                valor_total_nota5105 = vprod5105 + voutroverif5105 - vdesc5105;
                                                                total_outras5105 = vprod5105 + voutroverif5105 - vdesc5105;
                                                            }
                                                            //</editor-fold>

                                                            break;
                                                        //</editor-fold>

                                                    }
                                                }
                                            }
                                        /* txtAreaExemplo.appendText(NCM);
                                            con = ConnectionFactory.getConnection();
                                            sql = "SELECT * FROM camargo";
                                            st = con.prepareStatement(sql);
                                            rs = st.executeQuery();
                                            while (rs.next()) {
                                                retorno_ncm = rs.getString("ncm");
                                                if (NCM.equals(retorno_ncm)) {
                                                    txtAreaExemplo.appendText("-------------------------");
                                                    retorno_produto = rs.getString("codigo_produto");
                                                    txtAreaExemplo.appendText(retorno_produto);
                                                    txtAreaExemplo.appendText("-------------------------");
                                                }
                                            }
                                            ConnectionFactory.closeConnection(con, st, rs);*/
                                    }

                                }

                            }
                        }

                    }
                }

            }
//</editor-fold>

            // <editor-fold defaultstate="collapsed" desc="DESDOBRAMENTO 5405">
            if (flag5405 == 1) {
                desdo++;

                saida5405 = desdo;

            }

            //</editor-fold>
            // <editor-fold defaultstate="collapsed" desc="DESDOBRAMENTO 5102">
            if (flag5102 == 1) {
                desdo++;
                saida5102 = desdo;

            }

            //</editor-fold>
            // <editor-fold defaultstate="collapsed" desc="DESDOBRAMENTO 5101">
            if (flag5101 == 1) {

                desdo++;
                saida5101 = desdo;

            }

            //</editor-fold>
            // <editor-fold defaultstate="collapsed" desc="DESDOBRAMENTO 5949">
            if (flag5949 == 1) {

                desdo++;
                saida5949 = desdo;
            }

            //</editor-fold>
            // <editor-fold defaultstate="collapsed" desc="DESDOBRAMENTO 5403">
            if (flag5403 == 1) {

                desdo++;
                saida5403 = desdo;
            }

            //</editor-fold>
            // <editor-fold defaultstate="collapsed" desc="DESDOBRAMENTO 5104">
            if (flag5104 == 1) {

                desdo++;
                saida5104 = desdo;
            }

            //</editor-fold>
            // <editor-fold defaultstate="collapsed" desc="DESDOBRAMENTO 5401">
            if (flag5401 == 1) {

                desdo++;
                saida5401 = desdo;

            }

            //</editor-fold> 
            // <editor-fold defaultstate="collapsed" desc="DESDOBRAMENTO 5910">
            if (flag5910 == 1) {
                desdo++;
                saida5910 = desdo;
            }

            //</editor-fold>
            // <editor-fold defaultstate="collapsed" desc="DESDOBRAMENTO 1411">
            if (flag1411 == 1) {
                desdo++;
                saida1411 = desdo;
            }

            //</editor-fold>
            // <editor-fold defaultstate="collapsed" desc="DESDOBRAMENTO 5929">
            if (flag5929 == 1) {
                desdo++;

                saida5929 = desdo;

            }

            //</editor-fold>
            // <editor-fold defaultstate="collapsed" desc="DESDOBRAMENTO 1410">
            if (flag1410 == 1) {
                desdo++;
                saida1410 = desdo;
            }

            //</editor-fold>
            // <editor-fold defaultstate="collapsed" desc="DESDOBRAMENTO 6910">
            if (flag6910 == 1) {
                desdo++;
                saida6910 = desdo;
            }

            //</editor-fold>
            // <editor-fold defaultstate="collapsed" desc="DESDOBRAMENTO 6102">
            if (flag6102 == 1) {
                desdo++;
                saida6102 = desdo;
            }

            //</editor-fold>
            // <editor-fold defaultstate="collapsed" desc="DESDOBRAMENTO 5911">
            if (flag5911 == 1) {
                desdo++;
                saida5911 = desdo;
            }

            //</editor-fold>
            // <editor-fold defaultstate="collapsed" desc="DESDOBRAMENTO 5106">
            if (flag5106 == 1) {
                desdo++;
                saida5106 = desdo;
            }

            //</editor-fold>
            // <editor-fold defaultstate="collapsed" desc="DESDOBRAMENTO 5105">
            if (flag5105 == 1) {
                desdo++;
                saida5105 = desdo;
            }

            //</editor-fold>
            desdo = 0;
            try (FileWriter fw = new FileWriter(file, true); PrintWriter gravarArq = new PrintWriter(fw)) {
                // <editor-fold defaultstate="collapsed" desc="SAÍDA DAS INFORMAÇÕES">
                // <editor-fold defaultstate="collapsed" desc="SAÍDA5405">
                if (flag5405 == 0) {

                } else {

                    // <editor-fold defaultstate="collapsed" desc="CONDIÇÃO VDESC FORMAT">
                    if (vdesc5405 == 0) {
                        format_vdesc = new DecimalFormat("00000000000000");
                    } else {
                        if (vdesc5405 != 0) {
                            format_vdesc = new DecimalFormat("00000000000.00");
                        }
                    }
                    //</editor-fold>   

                    gravarArq.println("    " + cnp + emi + emi + "            " + saida5405 + "        " + df.format(vprod5405).replace(",", ".") + df.format(base_calculo_icms).replace(",", ".") + df.format(icms_creditado).replace(",", ".") + df.format(isentas_naotributadas).replace(",", ".") + df.format(total_outras5405).replace(",", ".") + df.format(ipi_nao_creditado).replace(",", ".") + aliquo_icms.format(aliquota_icms).replace(",", ".") + df.format(base_calculo_ipi).replace(",", ".") + df.format(ipi_creditado).replace(",", ".") + df.format(ipi_creditado_50).replace(",", ".") + df.format(isentas_naotributadas_zerado).replace(",", ".") + df.format(outras_zerado).replace(",", ".") + df.format(valor_total_nota5405).replace(",", ".") + "1" + "     " + sit_especial.format(sit_especial_valor1).replace(",", ".") + sit_especial.format(sit_especial_valor2).replace(",", ".") + sit_especial.format(sit_especial_valor3).replace(",", ".") + sit_especial.format(sit_especial_valor4).replace(",", ".") + "                                                                                                                                                                                                                            "
                            + "" + insc_estadual + espaco + un_federal + "1" + "                                                                                                        " + cfopat1403 + cod_municipal + "                                                                                                                                            " + df.format(base_calc_subst_tribut).replace(",", ".") + df.format(imposto_retido_subst_tribut).replace(",", ".") + "      " + "0" + "      " + df.format(valor_frete).replace(",", ".") + df.format(valor_seguro).replace(",", ".") + df.format(voutroverif5405).replace(",", ".") + "NF-E" + " " + "0" + "1" + "    " + format_num_doc.format(float_num_doc) + "00000000000000000000" + "        " + hora_emi + "        " + "00000000000000000000000000000000000000000000000000" + nfe + "                                                                         " + "0" + "                                   " + format_vdesc.format(vdesc5405).replace(",", ".") + "00" + "                        " + "1" + "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                " + "000000000.000000.00000000000.00" + sit_especial.format(outras5405).replace(",", ".") + "    " + "000.0000" + "                    " + "00000000000000.000000000000000.000000000000000.000000000000000.00");

                }
                //</editor-fold>

                // <editor-fold defaultstate="collapsed" desc="SAÍDA5102">
                if (flag5102 == 0) {

                } else {

                    // <editor-fold defaultstate="collapsed" desc="CONDIÇÃO VDESC FORMAT">
                    if (vdesc5102 == 0) {
                        format_vdesc = new DecimalFormat("00000000000000");
                    } else {
                        if (vdesc5102 != 0) {
                            format_vdesc = new DecimalFormat("00000000000.00");
                        }
                    }
                    //</editor-fold>
                    // <editor-fold defaultstate="collapsed" desc="CONDIÇÃO ISENTAS NAO TRIBUTADAS">

                    if (valor_isentas_naotributadas5102 != 0) {
                        valor_total_outras5102 = vprod5102 + voutroverif5102 - vdesc5102 - valor_isentas_naotributadas5102;

                    }
                    //</editor-fold>

                    gravarArq.println("    " + cnp + emi + emi + "            " + saida5102 + "        " + df.format(vprod5102).replace(",", ".") + df.format(base_calculo_icms).replace(",", ".") + df.format(icms_creditado).replace(",", ".") + df.format(valor_isentas_naotributadas5102).replace(",", ".") + df.format(total_outras5102).replace(",", ".").replace("-", "") + df.format(ipi_nao_creditado).replace(",", ".") + aliquo_icms.format(aliquota_icms).replace(",", ".") + df.format(base_calculo_ipi).replace(",", ".") + df.format(ipi_creditado).replace(",", ".") + df.format(ipi_creditado_50).replace(",", ".") + df.format(isentas_naotributadas_zerado).replace(",", ".") + df.format(outras_zerado).replace(",", ".") + df.format(valor_total_nota5102).replace(",", ".") + "1" + "     " + sit_especial.format(sit_especial_valor1).replace(",", ".") + sit_especial.format(sit_especial_valor2).replace(",", ".") + sit_especial.format(sit_especial_valor3).replace(",", ".") + sit_especial.format(sit_especial_valor4).replace(",", ".") + "                                                                                                                                                                                                                            "
                            + "" + insc_estadual + espaco + un_federal + "1" + "                                                                                                        " + cfopat1102 + cod_municipal + "                                                                                                                                            " + df.format(base_calc_subst_tribut).replace(",", ".") + df.format(imposto_retido_subst_tribut).replace(",", ".") + "      " + "0" + "      " + df.format(valor_frete).replace(",", ".") + df.format(valor_seguro).replace(",", ".") + df.format(voutroverif5102).replace(",", ".") + "NF-E" + " " + "0" + "1" + "    " + format_num_doc.format(float_num_doc) + "00000000000000000000" + "        " + hora_emi + "        " + "00000000000000000000000000000000000000000000000000" + nfe + "                                                                         " + "0" + "                                   " + format_vdesc.format(vdesc5102).replace(",", ".") + "00" + "                        " + "1" + "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                " + "000000000.000000.00000000000.00" + sit_especial.format(outras5102).replace(",", ".") + "    " + "000.0000" + "                    " + "00000000000000.000000000000000.000000000000000.000000000000000.00" );

                }
                //</editor-fold>

                // <editor-fold defaultstate="collapsed" desc="SAÍDA5101">
                if (flag5101 == 0) {

                } else {

                    // <editor-fold defaultstate="collapsed" desc="CONDIÇÃO VDESC FORMAT">
                    if (vdesc5101 == 0) {
                        format_vdesc = new DecimalFormat("00000000000000");
                    } else {
                        if (vdesc5101 != 0) {
                            format_vdesc = new DecimalFormat("00000000000.00");
                        }
                    }
                    //</editor-fold>
                    // <editor-fold defaultstate="collapsed" desc="CONDIÇÃO ISENTAS NAO TRIBUTADAS">

                    if (valor_isentas_naotributadas5101 != 0) {
                        valor_total_outras5101 = vprod5101 + voutroverif5101 - vdesc5101 - valor_isentas_naotributadas5101;

                    }
                    //</editor-fold>

                    gravarArq.println("    " + cnp + emi + emi + "            " + saida5101 + "        " + df.format(vprod5101).replace(",", ".") + df.format(base_calculo_icms).replace(",", ".") + df.format(icms_creditado).replace(",", ".") + df.format(valor_isentas_naotributadas5101).replace(",", ".") + df.format(total_outras5101).replace(",", ".").replace("-", "") + df.format(ipi_nao_creditado).replace(",", ".") + aliquo_icms.format(aliquota_icms).replace(",", ".") + df.format(base_calculo_ipi).replace(",", ".") + df.format(ipi_creditado).replace(",", ".") + df.format(ipi_creditado_50).replace(",", ".") + df.format(isentas_naotributadas_zerado).replace(",", ".") + df.format(outras_zerado).replace(",", ".") + df.format(valor_total_nota5101).replace(",", ".") + "1" + "     " + sit_especial.format(sit_especial_valor1).replace(",", ".") + sit_especial.format(sit_especial_valor2).replace(",", ".") + sit_especial.format(sit_especial_valor3).replace(",", ".") + sit_especial.format(sit_especial_valor4).replace(",", ".") + "                                                                                                                                                                                                                            "
                            + "" + insc_estadual + espaco + un_federal + "1" + "                                                                                                        " + cfopat1102 + cod_municipal + "                                                                                                                                            " + df.format(base_calc_subst_tribut).replace(",", ".") + df.format(imposto_retido_subst_tribut).replace(",", ".") + "      " + "0" + "      " + df.format(valor_frete).replace(",", ".") + df.format(valor_seguro).replace(",", ".") + df.format(voutroverif5101).replace(",", ".") + "NF-E" + " " + "0" + "1" + "    " + format_num_doc.format(float_num_doc) + "00000000000000000000" + "        " + hora_emi + "        " + "00000000000000000000000000000000000000000000000000" + nfe + "                                                                         " + "0" + "                                   " + format_vdesc.format(vdesc5101).replace(",", ".") + "00" + "                        " + "1" + "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                " + "000000000.000000.00000000000.00" + sit_especial.format(outras5101).replace(",", ".") + "    " + "000.0000" + "                    " + "00000000000000.000000000000000.000000000000000.000000000000000.00" );

                }
                //</editor-fold>

                // <editor-fold defaultstate="collapsed" desc="SAÍDA5949">
                if (flag5949 == 0) {

                } else {

                    // <editor-fold defaultstate="collapsed" desc="CONDIÇÃO VDESC FORMAT">
                    if (vdesc5949 == 0) {
                        format_vdesc = new DecimalFormat("00000000000000");
                    } else {
                        if (vdesc5949 != 0) {
                            format_vdesc = new DecimalFormat("00000000000.00");
                        }
                    }
                    //</editor-fold>                        

                    gravarArq.println("    " + cnp + emi + emi + "            " + saida5949 + "        " + df.format(vprod5949).replace(",", ".") + df.format(base_calculo_icms).replace(",", ".") + df.format(icms_creditado).replace(",", ".") + df.format(isentas_naotributadas).replace(",", ".") + df.format(total_outras5949).replace(",", ".") + df.format(ipi_nao_creditado).replace(",", ".") + aliquo_icms.format(aliquota_icms).replace(",", ".") + df.format(base_calculo_ipi).replace(",", ".") + df.format(ipi_creditado).replace(",", ".") + df.format(ipi_creditado_50).replace(",", ".") + df.format(isentas_naotributadas_zerado).replace(",", ".") + df.format(outras_zerado).replace(",", ".") + df.format(valor_total_nota5949).replace(",", ".") + "1" + "     " + sit_especial.format(sit_especial_valor1).replace(",", ".") + sit_especial.format(sit_especial_valor2).replace(",", ".") + sit_especial.format(sit_especial_valor3).replace(",", ".") + sit_especial.format(sit_especial_valor4).replace(",", ".") + "                                                                                                                                                                                                                            "
                            + "" + insc_estadual + espaco + un_federal + "1" + "                                                                                                        " + cfopat1949 + cod_municipal + "                                                                                                                                            " + df.format(base_calc_subst_tribut).replace(",", ".") + df.format(imposto_retido_subst_tribut).replace(",", ".") + "      " + "0" + "      " + df.format(valor_frete).replace(",", ".") + df.format(valor_seguro).replace(",", ".") + df.format(voutroverif5949).replace(",", ".") + "NF-E" + " " + "0" + "1" + "    " + format_num_doc.format(float_num_doc) + "00000000000000000000" + "        " + hora_emi + "        " + "00000000000000000000000000000000000000000000000000" + nfe + "                                                                         " + "0" + "                                   " + format_vdesc.format(vdesc5949).replace(",", ".") + "00" + "                        " + "1" + "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                " + "000000000.000000.00000000000.00" + sit_especial.format(outras5949).replace(",", ".") + "    " + "000.0000" + "                    " + "00000000000000.000000000000000.000000000000000.000000000000000.00" );

                }
                //</editor-fold>

                // <editor-fold defaultstate="collapsed" desc="SAÍDA5403">
                if (flag5403 == 0) {

                } else {

                    // <editor-fold defaultstate="collapsed" desc="CONDIÇÃO VDESC FORMAT">
                    if (vdesc5403 == 0) {
                        format_vdesc = new DecimalFormat("00000000000000");
                    } else {
                        if (vdesc5403 != 0) {
                            format_vdesc = new DecimalFormat("00000000000.00");
                        }
                    }
                    //</editor-fold>                        

                    gravarArq.println("    " + cnp + emi + emi + "            " + saida5403 + "        " + df.format(vprod5403).replace(",", ".") + df.format(base_calculo_icms).replace(",", ".") + df.format(icms_creditado).replace(",", ".") + df.format(isentas_naotributadas).replace(",", ".") + df.format(total_outras5403).replace(",", ".") + df.format(ipi_nao_creditado).replace(",", ".") + aliquo_icms.format(aliquota_icms).replace(",", ".") + df.format(base_calculo_ipi).replace(",", ".") + df.format(ipi_creditado).replace(",", ".") + df.format(ipi_creditado_50).replace(",", ".") + df.format(isentas_naotributadas_zerado).replace(",", ".") + df.format(outras_zerado).replace(",", ".") + df.format(valor_total_nota5403).replace(",", ".") + "1" + "     " + sit_especial.format(sit_especial_valor1).replace(",", ".") + sit_especial.format(sit_especial_valor2).replace(",", ".") + sit_especial.format(sit_especial_valor3).replace(",", ".") + sit_especial.format(sit_especial_valor4).replace(",", ".") + "                                                                                                                                                                                                                            "
                            + "" + insc_estadual + espaco + un_federal + "1" + "                                                                                                        " + cfopat1403 + cod_municipal + "                                                                                                                                            " + df.format(base_calc_subst_tribut).replace(",", ".") + df.format(imposto_retido_subst_tribut).replace(",", ".") + "      " + "0" + "      " + df.format(valor_frete).replace(",", ".") + df.format(valor_seguro).replace(",", ".") + df.format(voutroverif5403).replace(",", ".") + "NF-E" + " " + "0" + "1" + "    " + format_num_doc.format(float_num_doc) + "00000000000000000000" + "        " + hora_emi + "        " + "00000000000000000000000000000000000000000000000000" + nfe + "                                                                         " + "0" + "                                   " + format_vdesc.format(vdesc5403).replace(",", ".") + "00" + "                        " + "1" + "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                " + "000000000.000000.00000000000.00" + sit_especial.format(outras5403).replace(",", ".") + "    " + "000.0000" + "                    " + "00000000000000.000000000000000.000000000000000.000000000000000.00" );

                }
                //</editor-fold>

                // <editor-fold defaultstate="collapsed" desc="SAÍDA5104">
                if (flag5104 == 0) {

                } else {

                    // <editor-fold defaultstate="collapsed" desc="CONDIÇÃO VDESC FORMAT">
                    if (vdesc5104 == 0) {
                        format_vdesc = new DecimalFormat("00000000000000");
                    } else {
                        if (vdesc5104 != 0) {
                            format_vdesc = new DecimalFormat("00000000000.00");
                        }
                    }
                    //</editor-fold>                        

                    gravarArq.println("    " + cnp + emi + emi + "            " + saida5104 + "        " + df.format(vprod5104).replace(",", ".") + df.format(base_calculo_icms).replace(",", ".") + df.format(icms_creditado).replace(",", ".") + df.format(isentas_naotributadas).replace(",", ".") + df.format(total_outras5104).replace(",", ".") + df.format(ipi_nao_creditado).replace(",", ".") + aliquo_icms.format(aliquota_icms).replace(",", ".") + df.format(base_calculo_ipi).replace(",", ".") + df.format(ipi_creditado).replace(",", ".") + df.format(ipi_creditado_50).replace(",", ".") + df.format(isentas_naotributadas_zerado).replace(",", ".") + df.format(outras_zerado).replace(",", ".") + df.format(valor_total_nota5104).replace(",", ".") + "1" + "     " + sit_especial.format(sit_especial_valor1).replace(",", ".") + sit_especial.format(sit_especial_valor2).replace(",", ".") + sit_especial.format(sit_especial_valor3).replace(",", ".") + sit_especial.format(sit_especial_valor4).replace(",", ".") + "                                                                                                                                                                                                                            "
                            + "" + insc_estadual + espaco + un_federal + "1" + "                                                                                                        " + cfopat1403 + cod_municipal + "                                                                                                                                            " + df.format(base_calc_subst_tribut).replace(",", ".") + df.format(imposto_retido_subst_tribut).replace(",", ".") + "      " + "0" + "      " + df.format(valor_frete).replace(",", ".") + df.format(valor_seguro).replace(",", ".") + df.format(voutroverif5104).replace(",", ".") + "NF-E" + " " + "0" + "1" + "    " + format_num_doc.format(float_num_doc) + "00000000000000000000" + "        " + hora_emi + "        " + "00000000000000000000000000000000000000000000000000" + nfe + "                                                                         " + "0" + "                                   " + format_vdesc.format(vdesc5104).replace(",", ".") + "00" + "                        " + "1" + "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                " + "000000000.000000.00000000000.00" + sit_especial.format(outras5104).replace(",", ".") + "    " + "000.0000" + "                    " + "00000000000000.000000000000000.000000000000000.000000000000000.00" );

                }
                //</editor-fold> 

                // <editor-fold defaultstate="collapsed" desc="SAÍDA5401">
                if (flag5401 == 0) {

                } else {

                    // <editor-fold defaultstate="collapsed" desc="CONDIÇÃO VDESC FORMAT">
                    if (vdesc5401 == 0) {
                        format_vdesc = new DecimalFormat("00000000000000");
                    } else {
                        if (vdesc5401 != 0) {
                            format_vdesc = new DecimalFormat("00000000000.00");
                        }
                    }
                    //</editor-fold>   

                    gravarArq.println("    " + cnp + emi + emi + "            " + saida5401 + "        " + df.format(vprod5401).replace(",", ".") + df.format(base_calculo_icms).replace(",", ".") + df.format(icms_creditado).replace(",", ".") + df.format(isentas_naotributadas).replace(",", ".") + df.format(total_outras5401).replace(",", ".") + df.format(ipi_nao_creditado).replace(",", ".") + aliquo_icms.format(aliquota_icms).replace(",", ".") + df.format(base_calculo_ipi).replace(",", ".") + df.format(ipi_creditado).replace(",", ".") + df.format(ipi_creditado_50).replace(",", ".") + df.format(isentas_naotributadas_zerado).replace(",", ".") + df.format(outras_zerado).replace(",", ".") + df.format(valor_total_nota5401).replace(",", ".") + "1" + "     " + sit_especial.format(sit_especial_valor1).replace(",", ".") + sit_especial.format(sit_especial_valor2).replace(",", ".") + sit_especial.format(sit_especial_valor3).replace(",", ".") + sit_especial.format(sit_especial_valor4).replace(",", ".") + "                                                                                                                                                                                                                            "
                            + "" + insc_estadual + espaco + un_federal + "1" + "                                                                                                        " + cfopat1403 + cod_municipal + "                                                                                                                                            " + df.format(base_calc_subst_tribut).replace(",", ".") + df.format(imposto_retido_subst_tribut).replace(",", ".") + "      " + "0" + "      " + df.format(valor_frete).replace(",", ".") + df.format(valor_seguro).replace(",", ".") + df.format(voutroverif5401).replace(",", ".") + "NF-E" + " " + "0" + "1" + "    " + format_num_doc.format(float_num_doc) + "00000000000000000000" + "        " + hora_emi + "        " + "00000000000000000000000000000000000000000000000000" + nfe + "                                                                         " + "0" + "                                   " + format_vdesc.format(vdesc5401).replace(",", ".") + "00" + "                        " + "1" + "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                " + "000000000.000000.00000000000.00" + sit_especial.format(outras5401).replace(",", ".") + "    " + "000.0000" + "                    " + "00000000000000.000000000000000.000000000000000.000000000000000.00" );

                }
                //</editor-fold>

                // <editor-fold defaultstate="collapsed" desc="SAÍDA5910">
                if (flag5910 == 0) {

                } else {

                    // <editor-fold defaultstate="collapsed" desc="CONDIÇÃO VDESC FORMAT">
                    if (vdesc5910 == 0) {
                        format_vdesc = new DecimalFormat("00000000000000");
                    } else {
                        if (vdesc5910 != 0) {
                            format_vdesc = new DecimalFormat("00000000000.00");
                        }
                    }
                    //</editor-fold>   

                    gravarArq.println("    " + cnp + emi + emi + "            " + saida5910 + "        " + df.format(vprod5910).replace(",", ".") + df.format(base_calculo_icms).replace(",", ".") + df.format(icms_creditado).replace(",", ".") + df.format(isentas_naotributadas).replace(",", ".") + df.format(total_outras5910).replace(",", ".") + df.format(ipi_nao_creditado).replace(",", ".") + aliquo_icms.format(aliquota_icms).replace(",", ".") + df.format(base_calculo_ipi).replace(",", ".") + df.format(ipi_creditado).replace(",", ".") + df.format(ipi_creditado_50).replace(",", ".") + df.format(isentas_naotributadas_zerado).replace(",", ".") + df.format(outras_zerado).replace(",", ".") + df.format(valor_total_nota5910).replace(",", ".") + "1" + "     " + sit_especial.format(sit_especial_valor1).replace(",", ".") + sit_especial.format(sit_especial_valor2).replace(",", ".") + sit_especial.format(sit_especial_valor3).replace(",", ".") + sit_especial.format(sit_especial_valor4).replace(",", ".") + "                                                                                                                                                                                                                            "
                            + "" + insc_estadual + espaco + un_federal + "1" + "                                                                                                        " + cfopat1403 + cod_municipal + "                                                                                                                                            " + df.format(base_calc_subst_tribut).replace(",", ".") + df.format(imposto_retido_subst_tribut).replace(",", ".") + "      " + "0" + "      " + df.format(valor_frete).replace(",", ".") + df.format(valor_seguro).replace(",", ".") + df.format(voutroverif5910).replace(",", ".") + "NF-E" + " " + "0" + "1" + "    " + format_num_doc.format(float_num_doc) + "00000000000000000000" + "        " + hora_emi + "        " + "00000000000000000000000000000000000000000000000000" + nfe + "                                                                         " + "0" + "                                   " + format_vdesc.format(vdesc5910).replace(",", ".") + "00" + "                        " + "1" + "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                " + "000000000.000000.00000000000.00" + sit_especial.format(outras5910).replace(",", ".") + "    " + "000.0000" + "                    " + "00000000000000.000000000000000.000000000000000.000000000000000.00" );

                }
                //</editor-fold>

                // <editor-fold defaultstate="collapsed" desc="SAÍDA1411">
                if (flag1411 == 0) {

                } else {

                    // <editor-fold defaultstate="collapsed" desc="CONDIÇÃO VDESC FORMAT">
                    if (vdesc1411 == 0) {
                        format_vdesc = new DecimalFormat("00000000000000");
                    } else {
                        if (vdesc1411 != 0) {
                            format_vdesc = new DecimalFormat("00000000000.00");
                        }
                    }
                    //</editor-fold>   

                    gravarArq.println("    " + cnp + emi + emi + "            " + saida1411 + "        " + df.format(vprod1411).replace(",", ".") + df.format(base_calculo_icms).replace(",", ".") + df.format(icms_creditado).replace(",", ".") + df.format(isentas_naotributadas).replace(",", ".") + df.format(total_outras1411).replace(",", ".") + df.format(ipi_nao_creditado).replace(",", ".") + aliquo_icms.format(aliquota_icms).replace(",", ".") + df.format(base_calculo_ipi).replace(",", ".") + df.format(ipi_creditado).replace(",", ".") + df.format(ipi_creditado_50).replace(",", ".") + df.format(isentas_naotributadas_zerado).replace(",", ".") + df.format(outras_zerado).replace(",", ".") + df.format(valor_total_nota1411).replace(",", ".") + "1" + "     " + sit_especial.format(sit_especial_valor1).replace(",", ".") + sit_especial.format(sit_especial_valor2).replace(",", ".") + sit_especial.format(sit_especial_valor3).replace(",", ".") + sit_especial.format(sit_especial_valor4).replace(",", ".") + "                                                                                                                                                                                                                            "
                            + "" + insc_estadual + espaco + un_federal + "1" + "                                                                                                        " + cfopat1411 + cod_municipal + "                                                                                                                                            " + df.format(base_calc_subst_tribut).replace(",", ".") + df.format(imposto_retido_subst_tribut).replace(",", ".") + "      " + "0" + "      " + df.format(valor_frete).replace(",", ".") + df.format(valor_seguro).replace(",", ".") + df.format(voutroverif1411).replace(",", ".") + "NF-E" + " " + "0" + "1" + "    " + format_num_doc.format(float_num_doc) + "00000000000000000000" + "        " + hora_emi + "        " + "00000000000000000000000000000000000000000000000000" + nfe + "                                                                         " + "0" + "                                   " + format_vdesc.format(vdesc1411).replace(",", ".") + "00" + "                        " + "1" + "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                " + "000000000.000000.00000000000.00" + sit_especial.format(outras1411).replace(",", ".") + "    " + "000.0000" + "                    " + "00000000000000.000000000000000.000000000000000.000000000000000.00" );

                }
                //</editor-fold>

                // <editor-fold defaultstate="collapsed" desc="SAÍDA5929">
                if (flag5929 == 0) {

                } else {

                    // <editor-fold defaultstate="collapsed" desc="CONDIÇÃO VDESC FORMAT">
                    if (vdesc5929 == 0) {
                        format_vdesc = new DecimalFormat("00000000000000");
                    } else {
                        if (vdesc5929 != 0) {
                            format_vdesc = new DecimalFormat("00000000000.00");
                        }
                    }
                    //</editor-fold>   

                    gravarArq.println("    " + cnp + emi + emi + "            " + saida5929 + "        " + df.format(vprod5929).replace(",", ".") + df.format(base_calculo_icms).replace(",", ".") + df.format(icms_creditado).replace(",", ".") + df.format(isentas_naotributadas).replace(",", ".") + df.format(total_outras5929).replace(",", ".") + df.format(ipi_nao_creditado).replace(",", ".") + aliquo_icms.format(aliquota_icms).replace(",", ".") + df.format(base_calculo_ipi).replace(",", ".") + df.format(ipi_creditado).replace(",", ".") + df.format(ipi_creditado_50).replace(",", ".") + df.format(isentas_naotributadas_zerado).replace(",", ".") + df.format(outras_zerado).replace(",", ".") + df.format(valor_total_nota5929).replace(",", ".") + "1" + "     " + sit_especial.format(sit_especial_valor1).replace(",", ".") + sit_especial.format(sit_especial_valor2).replace(",", ".") + sit_especial.format(sit_especial_valor3).replace(",", ".") + sit_especial.format(sit_especial_valor4).replace(",", ".") + "                                                                                                                                                                                                                            "
                            + "" + insc_estadual + espaco + un_federal + "1" + "                                                                                                        " + cfopat1949 + cod_municipal + "                                                                                                                                            " + df.format(base_calc_subst_tribut).replace(",", ".") + df.format(imposto_retido_subst_tribut).replace(",", ".") + "      " + "0" + "      " + df.format(valor_frete).replace(",", ".") + df.format(valor_seguro).replace(",", ".") + df.format(voutroverif5929).replace(",", ".") + "NF-E" + " " + "0" + "1" + "    " + format_num_doc.format(float_num_doc) + "00000000000000000000" + "        " + hora_emi + "        " + "00000000000000000000000000000000000000000000000000" + nfe + "                                                                         " + "0" + "                                   " + format_vdesc.format(vdesc5929).replace(",", ".") + "00" + "                        " + "1" + "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                " + "000000000.000000.00000000000.00" + sit_especial.format(outras5929).replace(",", ".") + "    " + "000.0000" + "                    " + "00000000000000.000000000000000.000000000000000.000000000000000.00" );

                }
                //</editor-fold>

                // <editor-fold defaultstate="collapsed" desc="SAÍDA1410">
                if (flag1410 == 0) {

                } else {

                    // <editor-fold defaultstate="collapsed" desc="CONDIÇÃO VDESC FORMAT">
                    if (vdesc1410 == 0) {
                        format_vdesc = new DecimalFormat("00000000000000");
                    } else {
                        if (vdesc1410 != 0) {
                            format_vdesc = new DecimalFormat("00000000000.00");
                        }
                    }
                    //</editor-fold>   

                    gravarArq.println("    " + cnp + emi + emi + "            " + saida1410 + "        " + df.format(vprod1410).replace(",", ".") + df.format(base_calculo_icms).replace(",", ".") + df.format(icms_creditado).replace(",", ".") + df.format(isentas_naotributadas).replace(",", ".") + df.format(total_outras1410).replace(",", ".") + df.format(ipi_nao_creditado).replace(",", ".") + aliquo_icms.format(aliquota_icms).replace(",", ".") + df.format(base_calculo_ipi).replace(",", ".") + df.format(ipi_creditado).replace(",", ".") + df.format(ipi_creditado_50).replace(",", ".") + df.format(isentas_naotributadas_zerado).replace(",", ".") + df.format(outras_zerado).replace(",", ".") + df.format(valor_total_nota1410).replace(",", ".") + "1" + "     " + sit_especial.format(sit_especial_valor1).replace(",", ".") + sit_especial.format(sit_especial_valor2).replace(",", ".") + sit_especial.format(sit_especial_valor3).replace(",", ".") + sit_especial.format(sit_especial_valor4).replace(",", ".") + "                                                                                                                                                                                                                            "
                            + "" + insc_estadual + espaco + un_federal + "1" + "                                                                                                        " + cfopat1410 + cod_municipal + "                                                                                                                                            " + df.format(base_calc_subst_tribut).replace(",", ".") + df.format(imposto_retido_subst_tribut).replace(",", ".") + "      " + "0" + "      " + df.format(valor_frete).replace(",", ".") + df.format(valor_seguro).replace(",", ".") + df.format(voutroverif1410).replace(",", ".") + "NF-E" + " " + "0" + "1" + "    " + format_num_doc.format(float_num_doc) + "00000000000000000000" + "        " + hora_emi + "        " + "00000000000000000000000000000000000000000000000000" + nfe + "                                                                         " + "0" + "                                   " + format_vdesc.format(vdesc1410).replace(",", ".") + "00" + "                        " + "1" + "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                " + "000000000.000000.00000000000.00" + sit_especial.format(outras1410).replace(",", ".") + "    " + "000.0000" + "                    " + "00000000000000.000000000000000.000000000000000.000000000000000.00" );

                }
                //</editor-fold>

                // <editor-fold defaultstate="collapsed" desc="SAÍDA6910">
                if (flag6910 == 0) {

                } else {

                    // <editor-fold defaultstate="collapsed" desc="CONDIÇÃO VDESC FORMAT">
                    if (vdesc6910 == 0) {
                        format_vdesc = new DecimalFormat("00000000000000");
                    } else {
                        if (vdesc6910 != 0) {
                            format_vdesc = new DecimalFormat("00000000000.00");
                        }
                    }
                    //</editor-fold>   

                    gravarArq.println("    " + cnp + emi + emi + "            " + saida6910 + "        " + df.format(vprod6910).replace(",", ".") + df.format(base_calculo_icms).replace(",", ".") + df.format(icms_creditado).replace(",", ".") + df.format(isentas_naotributadas).replace(",", ".") + df.format(total_outras6910).replace(",", ".") + df.format(ipi_nao_creditado).replace(",", ".") + aliquo_icms.format(aliquota_icms).replace(",", ".") + df.format(base_calculo_ipi).replace(",", ".") + df.format(ipi_creditado).replace(",", ".") + df.format(ipi_creditado_50).replace(",", ".") + df.format(isentas_naotributadas_zerado).replace(",", ".") + df.format(outras_zerado).replace(",", ".") + df.format(valor_total_nota6910).replace(",", ".") + "1" + "     " + sit_especial.format(sit_especial_valor1).replace(",", ".") + sit_especial.format(sit_especial_valor2).replace(",", ".") + sit_especial.format(sit_especial_valor3).replace(",", ".") + sit_especial.format(sit_especial_valor4).replace(",", ".") + "                                                                                                                                                                                                                            "
                            + "" + insc_estadual + espaco + un_federal + "1" + "                                                                                                        " + cfopat2910 + cod_municipal + "                                                                                                                                            " + df.format(base_calc_subst_tribut).replace(",", ".") + df.format(imposto_retido_subst_tribut).replace(",", ".") + "      " + "0" + "      " + df.format(valor_frete).replace(",", ".") + df.format(valor_seguro).replace(",", ".") + df.format(voutroverif6910).replace(",", ".") + "NF-E" + " " + "0" + "1" + "    " + format_num_doc.format(float_num_doc) + "00000000000000000000" + "        " + hora_emi + "        " + "00000000000000000000000000000000000000000000000000" + nfe + "                                                                         " + "0" + "                                   " + format_vdesc.format(vdesc6910).replace(",", ".") + "00" + "                        " + "1" + "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                " + "000000000.000000.00000000000.00" + sit_especial.format(outras6910).replace(",", ".") + "    " + "000.0000" + "                    " + "00000000000000.000000000000000.000000000000000.000000000000000.00" );

                }
                //</editor-fold>

                // <editor-fold defaultstate="collapsed" desc="SAÍDA6102">
                if (flag6102 == 0) {

                } else {

                    // <editor-fold defaultstate="collapsed" desc="CONDIÇÃO VDESC FORMAT">
                    if (vdesc6102 == 0) {
                        format_vdesc = new DecimalFormat("00000000000000");
                    } else {
                        if (vdesc6102 != 0) {
                            format_vdesc = new DecimalFormat("00000000000.00");
                        }
                    }
                    //</editor-fold>   

                    gravarArq.println("    " + cnp + emi + emi + "            " + saida6102 + "        " + df.format(vprod6102).replace(",", ".") + df.format(base_calculo_icms).replace(",", ".") + df.format(icms_creditado).replace(",", ".") + df.format(isentas_naotributadas).replace(",", ".") + df.format(total_outras6102).replace(",", ".") + df.format(ipi_nao_creditado).replace(",", ".") + aliquo_icms.format(aliquota_icms).replace(",", ".") + df.format(base_calculo_ipi).replace(",", ".") + df.format(ipi_creditado).replace(",", ".") + df.format(ipi_creditado_50).replace(",", ".") + df.format(isentas_naotributadas_zerado).replace(",", ".") + df.format(outras_zerado).replace(",", ".") + df.format(valor_total_nota6102).replace(",", ".") + "1" + "     " + sit_especial.format(sit_especial_valor1).replace(",", ".") + sit_especial.format(sit_especial_valor2).replace(",", ".") + sit_especial.format(sit_especial_valor3).replace(",", ".") + sit_especial.format(sit_especial_valor4).replace(",", ".") + "                                                                                                                                                                                                                            "
                            + "" + insc_estadual + espaco + un_federal + "1" + "                                                                                                        " + cfopat2102 + cod_municipal + "                                                                                                                                            " + df.format(base_calc_subst_tribut).replace(",", ".") + df.format(imposto_retido_subst_tribut).replace(",", ".") + "      " + "0" + "      " + df.format(valor_frete).replace(",", ".") + df.format(valor_seguro).replace(",", ".") + df.format(voutroverif6102).replace(",", ".") + "NF-E" + " " + "0" + "1" + "    " + format_num_doc.format(float_num_doc) + "00000000000000000000" + "        " + hora_emi + "        " + "00000000000000000000000000000000000000000000000000" + nfe + "                                                                         " + "0" + "                                   " + format_vdesc.format(vdesc6102).replace(",", ".") + "00" + "                        " + "1" + "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                " + "000000000.000000.00000000000.00" + sit_especial.format(outras6102).replace(",", ".") + "    " + "000.0000" + "                    " + "00000000000000.000000000000000.000000000000000.000000000000000.00" );

                }
                //</editor-fold>

                // <editor-fold defaultstate="collapsed" desc="SAÍDA5911">
                if (flag5911 == 0) {

                } else {

                    // <editor-fold defaultstate="collapsed" desc="CONDIÇÃO VDESC FORMAT">
                    if (vdesc5911 == 0) {
                        format_vdesc = new DecimalFormat("00000000000000");
                    } else {
                        if (vdesc5911 != 0) {
                            format_vdesc = new DecimalFormat("00000000000.00");
                        }
                    }
                    //</editor-fold>   

                    gravarArq.println("    " + cnp + emi + emi + "            " + saida5911 + "        " + df.format(vprod5911).replace(",", ".") + df.format(base_calculo_icms).replace(",", ".") + df.format(icms_creditado).replace(",", ".") + df.format(isentas_naotributadas).replace(",", ".") + df.format(total_outras5911).replace(",", ".") + df.format(ipi_nao_creditado).replace(",", ".") + aliquo_icms.format(aliquota_icms).replace(",", ".") + df.format(base_calculo_ipi).replace(",", ".") + df.format(ipi_creditado).replace(",", ".") + df.format(ipi_creditado_50).replace(",", ".") + df.format(isentas_naotributadas_zerado).replace(",", ".") + df.format(outras_zerado).replace(",", ".") + df.format(valor_total_nota5911).replace(",", ".") + "1" + "     " + sit_especial.format(sit_especial_valor1).replace(",", ".") + sit_especial.format(sit_especial_valor2).replace(",", ".") + sit_especial.format(sit_especial_valor3).replace(",", ".") + sit_especial.format(sit_especial_valor4).replace(",", ".") + "                                                                                                                                                                                                                            "
                            + "" + insc_estadual + espaco + un_federal + "1" + "                                                                                                        " + cfopat1911 + cod_municipal + "                                                                                                                                            " + df.format(base_calc_subst_tribut).replace(",", ".") + df.format(imposto_retido_subst_tribut).replace(",", ".") + "      " + "0" + "      " + df.format(valor_frete).replace(",", ".") + df.format(valor_seguro).replace(",", ".") + df.format(voutroverif5911).replace(",", ".") + "NF-E" + " " + "0" + "1" + "    " + format_num_doc.format(float_num_doc) + "00000000000000000000" + "        " + hora_emi + "        " + "00000000000000000000000000000000000000000000000000" + nfe + "                                                                         " + "0" + "                                   " + format_vdesc.format(vdesc5911).replace(",", ".") + "00" + "                        " + "1" + "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                " + "000000000.000000.00000000000.00" + sit_especial.format(outras5911).replace(",", ".") + "    " + "000.0000" + "                    " + "00000000000000.000000000000000.000000000000000.000000000000000.00" );

                }
                //</editor-fold>

                // <editor-fold defaultstate="collapsed" desc="SAÍDA5106">
                if (flag5106 == 0) {

                } else {

                    // <editor-fold defaultstate="collapsed" desc="CONDIÇÃO VDESC FORMAT">
                    if (vdesc5106 == 0) {
                        format_vdesc = new DecimalFormat("00000000000000");
                    } else {
                        if (vdesc5106 != 0) {
                            format_vdesc = new DecimalFormat("00000000000.00");
                        }
                    }
                    //</editor-fold>   

                    gravarArq.println("    " + cnp + emi + emi + "            " + saida5106 + "        " + df.format(vprod5106).replace(",", ".") + df.format(base_calculo_icms).replace(",", ".") + df.format(icms_creditado).replace(",", ".") + df.format(isentas_naotributadas).replace(",", ".") + df.format(total_outras5106).replace(",", ".") + df.format(ipi_nao_creditado).replace(",", ".") + aliquo_icms.format(aliquota_icms).replace(",", ".") + df.format(base_calculo_ipi).replace(",", ".") + df.format(ipi_creditado).replace(",", ".") + df.format(ipi_creditado_50).replace(",", ".") + df.format(isentas_naotributadas_zerado).replace(",", ".") + df.format(outras_zerado).replace(",", ".") + df.format(valor_total_nota5106).replace(",", ".") + "1" + "     " + sit_especial.format(sit_especial_valor1).replace(",", ".") + sit_especial.format(sit_especial_valor2).replace(",", ".") + sit_especial.format(sit_especial_valor3).replace(",", ".") + sit_especial.format(sit_especial_valor4).replace(",", ".") + "                                                                                                                                                                                                                            "
                            + "" + insc_estadual + espaco + un_federal + "1" + "                                                                                                        " + cfopat1102 + cod_municipal + "                                                                                                                                            " + df.format(base_calc_subst_tribut).replace(",", ".") + df.format(imposto_retido_subst_tribut).replace(",", ".") + "      " + "0" + "      " + df.format(valor_frete).replace(",", ".") + df.format(valor_seguro).replace(",", ".") + df.format(voutroverif5106).replace(",", ".") + "NF-E" + " " + "0" + "1" + "    " + format_num_doc.format(float_num_doc) + "00000000000000000000" + "        " + hora_emi + "        " + "00000000000000000000000000000000000000000000000000" + nfe + "                                                                         " + "0" + "                                   " + format_vdesc.format(vdesc5106).replace(",", ".") + "00" + "                        " + "1" + "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                " + "000000000.000000.00000000000.00" + sit_especial.format(outras5106).replace(",", ".") + "    " + "000.0000" + "                    " + "00000000000000.000000000000000.000000000000000.000000000000000.00" );

                }
                //</editor-fold>

                // <editor-fold defaultstate="collapsed" desc="SAÍDA5105">
                if (flag5105 == 0) {

                } else {

                    // <editor-fold defaultstate="collapsed" desc="CONDIÇÃO VDESC FORMAT">
                    if (vdesc5105 == 0) {
                        format_vdesc = new DecimalFormat("00000000000000");
                    } else {
                        if (vdesc5105 != 0) {
                            format_vdesc = new DecimalFormat("00000000000.00");
                        }
                    }
                    //</editor-fold>   

                    gravarArq.println("    " + cnp + emi + emi + "            " + saida5105 + "        " + df.format(vprod5105).replace(",", ".") + df.format(base_calculo_icms).replace(",", ".") + df.format(icms_creditado).replace(",", ".") + df.format(isentas_naotributadas).replace(",", ".") + df.format(total_outras5105).replace(",", ".") + df.format(ipi_nao_creditado).replace(",", ".") + aliquo_icms.format(aliquota_icms).replace(",", ".") + df.format(base_calculo_ipi).replace(",", ".") + df.format(ipi_creditado).replace(",", ".") + df.format(ipi_creditado_50).replace(",", ".") + df.format(isentas_naotributadas_zerado).replace(",", ".") + df.format(outras_zerado).replace(",", ".") + df.format(valor_total_nota5105).replace(",", ".") + "1" + "     " + sit_especial.format(sit_especial_valor1).replace(",", ".") + sit_especial.format(sit_especial_valor2).replace(",", ".") + sit_especial.format(sit_especial_valor3).replace(",", ".") + sit_especial.format(sit_especial_valor4).replace(",", ".") + "                                                                                                                                                                                                                            "
                            + "" + insc_estadual + espaco + un_federal + "1" + "                                                                                                        " + cfopat1102 + cod_municipal + "                                                                                                                                            " + df.format(base_calc_subst_tribut).replace(",", ".") + df.format(imposto_retido_subst_tribut).replace(",", ".") + "      " + "0" + "      " + df.format(valor_frete).replace(",", ".") + df.format(valor_seguro).replace(",", ".") + df.format(voutroverif5105).replace(",", ".") + "NF-E" + " " + "0" + "1" + "    " + format_num_doc.format(float_num_doc) + "00000000000000000000" + "        " + hora_emi + "        " + "00000000000000000000000000000000000000000000000000" + nfe + "                                                                         " + "0" + "                                   " + format_vdesc.format(vdesc5105).replace(",", ".") + "00" + "                        " + "1" + "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                " + "000000000.000000.00000000000.00" + sit_especial.format(outras5105).replace(",", ".") + "    " + "000.0000" + "                    " + "00000000000000.000000000000000.000000000000000.000000000000000.00" );

                }
                //</editor-fold>
            }
//</editor-fold>

            // <editor-fold defaultstate="collapsed" desc="ZERANDO VARIAVEIS">
            flag5405 = 0;
            flag5102 = 0;
            flag5101 = 0;
            flag5949 = 0;
            flag5403 = 0;
            flag5104 = 0;
            flag5401 = 0;
            flag5911 = 0;
            flag1411 = 0;
            flag5929 = 0;
            flag1410 = 0;
            flag6910 = 0;
            flag6102 = 0;
            flag5910 = 0;
            flag5106 = 0;
            flag5105 = 0;

            vprod5405 = 0;
            valor_total_nota5405 = 0;
            vdesc5405 = 0;
            total_outras5405 = 0;
            outras5405 = 0;
            voutroverif5405 = 0;

            vprod5102 = 0;
            vdesc5102 = 0;
            outras5102 = 0;
            total_outras5102 = 0;
            valor_isentas_naotributadas5102 = 0;
            valor_total_nota5102 = 0;
            valor_total_outras5102 = 0;
            voutroverif5102 = 0;

            vprod5101 = 0;
            vdesc5101 = 0;
            outras5101 = 0;
            total_outras5101 = 0;
            valor_isentas_naotributadas5101 = 0;
            valor_total_nota5101 = 0;
            valor_total_outras5101 = 0;
            voutroverif5101 = 0;

            vprod5949 = 0;
            valor_total_nota5949 = 0;
            vdesc5949 = 0;
            total_outras5949 = 0;
            outras5949 = 0;
            voutroverif5949 = 0;

            vprod5403 = 0;
            valor_total_nota5403 = 0;
            vdesc5403 = 0;
            total_outras5403 = 0;
            outras5403 = 0;
            voutroverif5403 = 0;

            vprod5910 = 0;
            valor_total_nota5910 = 0;
            vdesc5910 = 0;
            total_outras5910 = 0;
            outras5910 = 0;
            voutroverif5910 = 0;

            vprod5401 = 0;
            valor_total_nota5401 = 0;
            vdesc5401 = 0;
            total_outras5401 = 0;
            outras5401 = 0;
            voutroverif5401 = 0;

            vprod5104 = 0;
            valor_total_nota5104 = 0;
            vdesc5104 = 0;
            total_outras5104 = 0;
            outras5104 = 0;
            voutroverif5104 = 0;

            vprod1411 = 0;
            valor_total_nota1411 = 0;
            vdesc1411 = 0;
            total_outras1411 = 0;
            outras1411 = 0;
            voutroverif1411 = 0;

            vprod5929 = 0;
            valor_total_nota5929 = 0;
            vdesc5929 = 0;
            total_outras5929 = 0;
            outras5929 = 0;
            voutroverif5929 = 0;

            vprod1410 = 0;
            valor_total_nota1410 = 0;
            vdesc1410 = 0;
            total_outras1410 = 0;
            outras1410 = 0;
            voutroverif1410 = 0;

            vprod6910 = 0;
            valor_total_nota6910 = 0;
            vdesc6910 = 0;
            total_outras6910 = 0;
            outras6910 = 0;
            voutroverif6910 = 0;

            vprod6102 = 0;
            valor_total_nota6102 = 0;
            vdesc6102 = 0;
            total_outras6102 = 0;
            outras6102 = 0;
            voutroverif6102 = 0;

            vprod5911 = 0;
            valor_total_nota5911 = 0;
            vdesc5911 = 0;
            total_outras5911 = 0;
            outras5911 = 0;
            voutroverif5911 = 0;

            vprod5106 = 0;
            valor_total_nota5106 = 0;
            vdesc5106 = 0;
            total_outras5106 = 0;
            outras5106 = 0;
            voutroverif5106 = 0;

            vprod5105 = 0;
            valor_total_nota5105 = 0;
            vdesc5105 = 0;
            total_outras5105 = 0;
            outras5105 = 0;
            voutroverif5105 = 0;
//</editor-fold>
        }
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Gravar Dados");
        alerta.setHeaderText(null);
        alerta.setContentText("Dados gravados com sucesso!");

        alerta.showAndWait();
    }
}
