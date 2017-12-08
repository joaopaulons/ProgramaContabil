package br.com.tutorial;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Exemplo {

    public static void main(String[] args) {
        try {
            BufferedReader buffer = new BufferedReader(new FileReader("C:\\RECEBIMENTOS BANCO 5.txt"));
            String linha = null;
            while ((linha = buffer.readLine()) != null) {
                String[] linhaSeparado = linha.split("\t");
                for (int i = 0; i < linhaSeparado.length; i++) {
                    System.out.println(linhaSeparado[i]);
                    i++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
