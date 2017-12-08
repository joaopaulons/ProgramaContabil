/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fxml.conciliacao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author joao.santos
 */
public class exemplos {
    /*
    String sql_result = "SELECT SUM(valor_contabil)  as soma from calcular group by numero_nota order by numero_nota;";
                    PreparedStatement stmt_result = con.prepareStatement(sql_result);
                    ResultSet rs = stmt_result.executeQuery();
                    while (rs.next()) {
                        novovalor.add(rs.getString("soma"));
                        for (int a = 0; a < novovalor.size(); a++) {
                            Object b = novovalor.get(a);
                            for (int j = a + 1; j < novovalor.size(); j++) {
                                Object c = novovalor.get(j);
                                if (b.equals(c)) {
                                    novovalor.remove(j);
                                    j--;
                                    valor = novovalor.get(j);
                                    
                                }
                            }
                        }

                    }
                    rs.close();
                    stmt_result.close();

                    String sql_busca = "Delete FROM calcular where valor_contabil_final = " + valor + "";
                    stmt_result = con.prepareStatement(sql_busca);
                    stmt_result.execute();
                    stmt_result.close();
*/
    
    
    
    /*public List<Integer> calculaValor(List<String> l, List<String> lval) {
        List<Integer> lTotalCC = new ArrayList<Integer>();
        int total;
        for (int i = 0; i < l.size(); i++) {
            total = 0;
            aux = Integer.parseInt(l.get(i));
            for (int j = 0; j < lval.size(); j++) {
                if (Integer.parseInt(l.get(j)) == aux) {
                    total = total + Integer.parseInt(lval.get(j));
                }
            }
            lTotalCC.add(total);
        }
        return lTotalCC;
    }*/
}
