package br.com.DAO;

import br.com.conexao.Mysql;
import br.com.modelo.Pedido;
import java.sql.SQLException;

public class PedidoDAO extends Mysql{
    
    private StringBuffer sql = new StringBuffer();
   
    public void inserirPedido(Pedido p) {
        sql.delete(0, sql.length());

        sql.append("INSERT INTO PEDIDO (ID_USUARIO)");
        sql.append(" VALUES (").append(p.getIdUsuario()).append(")");
        
        System.out.println(sql.toString());

        super.insertSQL(sql.toString());
    }
    
    public String ultimaOcorrencia(String tabela, String atributo) {
        String sql = "SELECT COALESCE(MAX(" + atributo + "), 0) AS ULTIMO FROM "
                + tabela;
        executeSQL(sql);
        
        try {
            resultset.first();
            return resultset.getString("ULTIMO");
        } catch (SQLException ex) {
            System.out.println("Erro ao encontrar número de sequência! " + ex);
            return "";
        }
    }
   
}
