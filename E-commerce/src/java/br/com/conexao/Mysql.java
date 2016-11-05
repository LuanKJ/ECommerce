package br.com.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Mysql {

    private static boolean connect = false;
    public static ResultSet resultset = null;

    public static java.sql.Connection getConexaoMySQL() {
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            String serverName = "localhost";
            String database = "e-commerce";
            String url = "jdbc:mysql://" + serverName + "/" + database;
            String username = "root";
            String password = "system";

            connection = DriverManager.getConnection(url, username, password);

            connect = (connection != null);
        } catch (ClassNotFoundException e) {
            System.out.println("O driver expecificado nao foi encontrado.");
        } catch (SQLException e) {
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
        }

        return connection;
    }

    public static boolean conectado() {
        return connect;
    }

    public static boolean FecharConexao() {
        try {
            Mysql.getConexaoMySQL().close();
            return true;
        } catch (SQLException e) {
            return false;
        }

    }

    public static java.sql.Connection ReiniciarConexao() {
        FecharConexao();
        return Mysql.getConexaoMySQL();
    }
    
    public void insertSQL(String sql) {
        Connection con = getConexaoMySQL();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);

            stmt.executeUpdate();

            System.out.println("Gravado com sucesso!");
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao inserir no banco de dados:", ex);
        } finally {
            FecharConexao();
        }
    }

    public void updateSQL(String sql) {
        Connection con = getConexaoMySQL();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);

            stmt.executeUpdate();

            System.out.println("Atualizado com sucesso!");
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao fazer update no banco de dados:", ex);
        } finally {
            FecharConexao();
        }
    }

    public void deleteSQL(String sql) {
        Connection con = getConexaoMySQL();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);

            stmt.executeUpdate();

            System.out.println("Deletado com sucesso!");
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao deletar dados do banco de dados:", ex);
        } finally {
            FecharConexao();
        }
    }

    public void executeSQL(String sql) {
        Connection con = getConexaoMySQL();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);

            resultset = stmt.executeQuery();

            System.out.println("Executado com sucesso!");
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao executar select no banco de dados:", ex);
        }
    }
    
}
