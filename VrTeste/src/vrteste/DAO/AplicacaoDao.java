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
public class AplicacaoDao {

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
    public static boolean existeBanco() {
        boolean retorno = false;
        Connection conexao = null;

        try {
            conexao = abreConexao();
            fechaConexao(conexao);
            retorno = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            retorno = false;
        }

        return retorno;

    }

    public static void criaBanco() throws SQLException {
        Connection conexao = null;
        PreparedStatement st = null;
        String criacaoDb = "CREATE DATABASE vrteste"
                + "    WITH "
                + "    OWNER = postgres"
                + "    ENCODING = 'UTF8'"
                + "    LC_COLLATE = 'Portuguese_Brazil.1252'"
                + "    LC_CTYPE = 'Portuguese_Brazil.1252'"
                + "    TABLESPACE = pg_default"
                + "    CONNECTION LIMIT = -1;";
        String objetosDb =  "CREATE SEQUENCE public.alunos_cod_aluno_seq"
                + "    INCREMENT 1"
                + "    START 1"
                + "    MINVALUE 1"
                + "    MAXVALUE 2147483647"
                + "    CACHE 1;"
                + ""
                + "ALTER SEQUENCE public.alunos_cod_aluno_seq"
                + "    OWNER TO postgres;"
                + "CREATE TABLE public.alunos"
                + "("
                + "    cod_aluno integer NOT NULL DEFAULT nextval('alunos_cod_aluno_seq'::regclass),"
                + "    doc_rg character varying COLLATE pg_catalog.\"default\" NOT NULL,"
                + "    matricula character varying COLLATE pg_catalog.\"default\" NOT NULL,"
                + "    nome character varying COLLATE pg_catalog.\"default\" NOT NULL,"
                + "    doc_cpf character varying COLLATE pg_catalog.\"default\" NOT NULL,"
                + "    CONSTRAINT alunos_pkey PRIMARY KEY (cod_aluno)"
                + ")"
                + ";"
                + ""
                + "ALTER TABLE public.alunos"
                + "    OWNER to postgres;";
        
        //Conecta no banco base do postgresql
        conexao = DriverManager.getConnection("jdbc:postgresql://" + host + ":" + port + "/postgres", user, pass);
        st = conexao.prepareStatement(criacaoDb);
        st.execute();
        fechaConexao(conexao);
        //Conecta no banco criado para criar os objetos
        conexao = abreConexao();
        st = conexao.prepareStatement(objetosDb);
        st.execute();
        fechaConexao(conexao);       

    }
}
