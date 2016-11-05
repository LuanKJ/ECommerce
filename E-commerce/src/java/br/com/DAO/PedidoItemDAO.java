package br.com.DAO;

import br.com.conexao.Mysql;
import br.com.modelo.PedidoItem;


public class PedidoItemDAO extends Mysql {
    
    private StringBuffer sql = new StringBuffer();
   
    public void inserirPedidoItem(PedidoItem pi) {
        sql.delete(0, sql.length());

        sql.append("INSERT INTO PEDIDO_ITEM (ID_PEDIDO, ID_PRODUTO, QUANTIDADE, VL_UNITARIO)").append(" VALUES (");
        sql.append(pi.getPedido().getId()).append(", ");
        sql.append(pi.getProduto().getId()).append(", ");
        sql.append(pi.getQuantidade()).append(", ");
        sql.append(pi.getValorUnitario()).append(")");
       
        System.out.println(sql.toString());

        super.insertSQL(sql.toString());
    }
}
