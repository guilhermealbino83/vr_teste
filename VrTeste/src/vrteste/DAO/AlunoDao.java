package vrteste.DAO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import vrteste.models.Aluno;

/**
 * Classe responsável pela persistencia da Entidade Aluno
 *
 * @author guilh
 */
public class AlunoDao {

    private final String insert = "INSERT INTO alunos(nome, matricula, doc_rg, doc_cpf) VALUES (?, ?, ?, ? )";
    private final String update = "UPDATE alunos SET nome = ?, matricula = ?, doc_rg = ? , doc_cpf =? WHERE cod_aluno = ?";
    private final String deletePorId = "DELETE FROM alunos WHERE cod_aluno = ?";
    private final String deletePorDados = "DELETE FROM alunos WHERE nome = ? AND matricula = ? AND doc_rg = ? AND doc_cpf = ?";
    private final String qryTodosAlunos = "SELECT cod_aluno, matricula, nome, doc_rg, doc_cpf FROM alunos ORDER BY nome";
    private final String qryAlunoPorNome = "SELECT cod_aluno, matricula, nome, doc_rg, doc_cpf FROM alunos WHERE nome = ? ORDER BY nome";
    private final String qryAlunoPorMatricula = "SELECT cod_aluno, matricula, nome, doc_rg, doc_cpf FROM alunos WHERE matricula = ? ORDER BY nome";

    /**
     * Inclui no Banco de dados os dados contidos na Entidade Aluno
     */
    public boolean salvar(Aluno aluno) throws SQLException {
        boolean retorno = false;

        if (aluno != null) {
            try {
                Connection conn = AplicacaoDao.abreConexao();
                PreparedStatement st = conn.prepareStatement(insert);
                st.setString(1, aluno.getNome());
                st.setString(2, aluno.getMatricula());
                st.setString(3, aluno.getDocRg());
                st.setString(4, aluno.getDocCpf());
                st.execute();
                AplicacaoDao.fechaConexao(conn);
                retorno = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                retorno = false;
            }
        } else {
            System.out.println("AlunoDao.Salvar: Parametro Vazio!");
            retorno = false;
        }
        return retorno;
    }

    /**
     * Altera Pelo ID, no Banco de dados, os dados contidos na Entidade Aluno
     */
    public boolean alterar(Aluno aluno) throws SQLException {
        boolean retorno = false;

        if ((aluno != null) || (aluno.getCodAluno() == -1)) {
            try {
                Connection conn = AplicacaoDao.abreConexao();
                PreparedStatement st = conn.prepareStatement(update);

                st.setString(1, aluno.getNome());
                st.setString(2, aluno.getMatricula());
                st.setString(3, aluno.getDocRg());
                st.setString(4, aluno.getDocCpf());
                st.setInt(5, aluno.getCodAluno());

                st.execute();
                AplicacaoDao.fechaConexao(conn);
                retorno = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                retorno = false;
            }
        } else {
            System.out.println("AlunoDao.Alterar: Parametro Vazio!");
            retorno = false;
        }
        return retorno;
    }

    /**
     * Delete Pelo ID, no Banco de dados, os dados contidos na Entidade Aluno.
     * Caso não haja ID, a deleção ocorre pelos dados em conjunto da entidade
     */
    public boolean deletar(Aluno aluno) throws SQLException {
        boolean retorno = false;

        if (aluno != null) {
            PreparedStatement st;
            Connection conn = AplicacaoDao.abreConexao();

            try {
                if (aluno.getCodAluno() != -1) {
                    st = conn.prepareStatement(deletePorId);
                    st.setInt(1, aluno.getCodAluno());
                    System.out.println(aluno.getCodAluno());
                } else {
                    st = conn.prepareStatement(deletePorDados);
                    st.setString(1, aluno.getNome());
                    st.setString(2, aluno.getMatricula());
                    st.setString(3, aluno.getDocRg());
                    st.setString(4, aluno.getDocCpf());
                    System.out.println(aluno.getNome());
                    System.out.println(aluno.getMatricula());
                    System.out.println(aluno.getDocRg());
                    System.out.println(aluno.getDocCpf());
                }

                st.execute();
                AplicacaoDao.fechaConexao(conn);
                System.out.println("fim");
                retorno = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                retorno = false;
            }
        } else {
            System.out.println("AlunoDao.Deletar: Parametro Vazio!");
            retorno = false;
        }
        return retorno;
    }

    /**
     * Retorna a lista de todos os alunos cadatrados
     */
    public List<Aluno> listar() throws SQLException {
        ArrayList<Aluno> alunos = new ArrayList<>();
        Connection conn = AplicacaoDao.abreConexao();
        PreparedStatement st = conn.prepareStatement(qryTodosAlunos);
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            Aluno aluno = new Aluno();
            aluno.setCodAluno(rs.getInt("cod_aluno"));
            aluno.setNome(rs.getString("nome"));
            aluno.setMatricula(rs.getString("matricula"));
            aluno.setDocRg(rs.getString("doc_rg"));
            aluno.setDocCpf(rs.getString("doc_cpf"));
            alunos.add(aluno);
        }

        AplicacaoDao.fechaConexao(conn);
        return alunos;
    }

    /**
     * Retorna a lista de alunos por um nome específico
     */
    public List<Aluno> listarPorNome(String nome) throws SQLException {

        ArrayList<Aluno> alunos = new ArrayList<>();
        Connection conn = AplicacaoDao.abreConexao();
        PreparedStatement st = conn.prepareStatement(qryAlunoPorNome);
        st.setString(1, nome);
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            Aluno aluno = new Aluno();
            aluno.setCodAluno(rs.getInt("cod_aluno"));
            aluno.setNome(rs.getString("nome"));
            aluno.setMatricula(rs.getString("matricula"));
            aluno.setDocRg(rs.getString("doc_rg"));
            aluno.setDocCpf(rs.getString("doc_cpf"));
            alunos.add(aluno);
        }

        AplicacaoDao.fechaConexao(conn);
        return alunos;
    }

    /**
     * Retorna a lista de alunos por uma matrícula
     */
    public List<Aluno> listarPorMatricula(String matricula) throws SQLException {

        ArrayList<Aluno> alunos = new ArrayList<>();
        Connection conn = AplicacaoDao.abreConexao();
        PreparedStatement st = conn.prepareStatement(qryAlunoPorMatricula);
        st.setString(1, matricula);
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            Aluno aluno = new Aluno();

            aluno.setCodAluno(rs.getInt("cod_aluno"));
            aluno.setNome(rs.getString("nome"));
            aluno.setMatricula(rs.getString("matricula"));
            aluno.setDocRg(rs.getString("doc_rg"));
            aluno.setDocCpf(rs.getString("doc_cpf"));

            alunos.add(aluno);
        }

        AplicacaoDao.fechaConexao(conn);
        return alunos;
    }
}
