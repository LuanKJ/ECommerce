package br.com.DAO;

import br.com.conexao.Mysql;
import static br.com.conexao.Mysql.resultset;
import br.com.modelo.Produto;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoDAO extends Mysql {

    private StringBuffer sql = new StringBuffer();

    public void inserirProduto(Produto p) {
        sql.delete(0, sql.length());

        sql.append("INSERT INTO PRODUTO (DESCRICAO, INFORMACAO, VALOR)");
        sql.append(" VALUES ('").append(p.getDescricao()).append("','");
        sql.append(p.getInformacao()).append("',");
        sql.append(p.getValor()).append(")");
        
        System.out.println(sql.toString());

        super.insertSQL(sql.toString());
    }

    public void alterarProduto(Produto p) {
        sql.delete(0, sql.length());

        sql.append("UPDATE PRODUTO SET ");
        sql.append("DESCRICAO = '").append(p.getDescricao());
        sql.append("', INFORMACAO = '").append(p.getInformacao());
        sql.append("', VALOR = ").append(p.getValor());
        sql.append(" WHERE ID =").append(p.getId());
          
        super.insertSQL(sql.toString());
    }

    public void excluirProduto(Produto p) {
        sql.delete(0, sql.length());

        sql.append("DELETE FROM PRODUTO WHERE ID = ").append(p.getId());

        super.deleteSQL(sql.toString());
    }
    
    public ResultSet consultarProdutos() {
        sql.delete(0, sql.length());
        sql.append("SELECT * FROM PRODUTO");
        executeSQL(sql.toString());

        return resultset;
    }
    
    public ResultSet consultarProdutosCodigo(int id) {
        sql.delete(0, sql.length());
        sql.append("SELECT * FROM PRODUTO");
        sql.append(" WHERE ID = ");
        sql.append(id);

        executeSQL(sql.toString());
        return resultset;
    }

    public ResultSet consultarProdutosDescricao(String descricao) {
        sql.delete(0, sql.length());
        sql.append("SELECT * FROM PRODUTO WHERE DESCRICAO LIKE '%");
        sql.append(descricao).append("%'");
        executeSQL(sql.toString());
        return resultset;
    }
    
}
