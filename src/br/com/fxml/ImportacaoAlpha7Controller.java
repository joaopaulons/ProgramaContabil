/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fxml;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.Initializable;
import javafx.scene.control.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * FXML Controller class
 *
 * @author joao.santos
 */
public class ImportacaoAlpha7Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            LerExcel();
        } catch (IOException | BiffException ex) {
            Logger.getLogger(ImportacaoAlpha7Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void LerExcel() throws IOException, BiffException {
        Workbook workbook = Workbook.getWorkbook(new File("C:\\Users\\joao.santos\\Downloads\\PLANILHA RECEBIMENTOS - SETEMBRO 2017.xls"));
        Sheet sheet = workbook.getSheet(0);
        int linhas = sheet.getRows();
        System.out.println("Iniciando a leitura da planilha XLS:");

        for (int i = 0; i < linhas; i++) {
            Cell a1 = (Cell) sheet.getCell(0, i);

            Cell a2 = (Cell) sheet.getCell(1, i);

            Cell a3 = (Cell) sheet.getCell(2, i);
            String as1 = a1.getText();

            String as2 = a2.getText();

            String as3 = a3.getText();
            System.out.println("Coluna 1: " + as1);

            System.out.println("Coluna 2: " + as2);

            System.out.println("Coluna 3: " + as3);
        }
        workbook.close();
    }
}
