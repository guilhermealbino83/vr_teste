/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vrteste.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe que prove recursos à aplicação, tais como acesso ao Banco de dados.
 *
 * @author guilh
 */
public class Aplicacao {

    private static String user = "postgres";
    private static String pass = "postgres";
    private static String database = "vrteste";
    private static String port = "5432";
    private static String host = "localhost";

    /**
     * Abre a conexão com o Banco de dados
     */
    public static Connection abreConexao() throws SQLException {
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection("jdbc:postgresql://" + host + ":" + port + "/" + database, user, pass);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conexao;
    }

    /**
     * Fecha a conexão com o Banco de dados
     */
    public static void fechaConexao(Connection conn) {
        try {
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * @todo Fará a validação do banco de dados ao iniciar a aplicação.
     */
    public static void validaBanco() {
        /*Método que validará o banco ao iniciar a aplicação*/
    }

}
