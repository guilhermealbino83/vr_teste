/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vrteste.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import vrteste.DAO.AlunoDao;
import vrteste.models.Aluno;

/**
 * Contém as regras de negócio relacionadas exclusivamente a entidade Aluno.
 *
 * @author guilh
 */
public class AlunosController {

    public AlunosController() {

    }

    /**
     * Metodo Interno que converte uma lista de Objetos Alunos para um MAP com a
     * seguinte estrutura: ID = Codigo do aluno (PK). As correspondicas no Vetor
     * de String são: 0 = Matricula; 1: Nome; 2: RG; 3: CPF.
     */
    private Map<Integer, String[]> mapListaAlunos(List<Aluno> alunos) {
        Map<Integer, String[]> retorno = new HashMap<>();
        for (Aluno a : alunos) {
            String[] elemento = new String[4];
            elemento[0] = a.getMatricula();
            elemento[1] = a.getNome();
            elemento[2] = a.getDocRg();
            elemento[3] = a.getDocCpf();

            retorno.put(a.getCodAluno(), elemento);
        }
        return retorno;
    }

    /**
     * Metodo responsável por validar os dados antes de persistir as informações
     */
    public boolean salvar(String matricula, String nome, String docRg, String docCpf) {
        AlunoDao alunoDao = new AlunoDao();
        Aluno aluno = new Aluno(matricula, nome, docRg, docCpf);
        boolean retorno = false;
        try {
            retorno = alunoDao.salvar(aluno);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            retorno = false;
        }
        return retorno;
    }

    /**
     * Metodo responsável por validar os dados antes de persistir as informações
     */
    public boolean alterar(int codAluno, String matricula, String nome, String docRg, String docCpf) {
        AlunoDao alunoDao = new AlunoDao();
        Aluno aluno = new Aluno(codAluno, matricula, nome, docRg, docCpf);
        boolean retorno = false;
        try {
            retorno = alunoDao.alterar(aluno);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return retorno;
    }

    /**
     * Metodo responsável por deletar os dados
     */
    private boolean deletar(Aluno aluno) {
        boolean retorno = false;
        AlunoDao alunoDao = new AlunoDao();
        try {
            retorno = alunoDao.deletar(aluno);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            retorno = false;
        }
        return retorno;
    }

    /**
     * Metodo responsável por validar os dados quando a deleção é passada o ID
     * do Aluno, ou seja, quando temos a certeza que o registro já existe no
     * banco de dados.
     */
    public boolean deletar(int codAluno, String matricula, String nome, String docRg, String docCpf) {
        Aluno aluno = new Aluno(codAluno, matricula, nome, docRg, docCpf);
        return deletar(aluno);
    }

    /**
     * Metodo responsável por validar os dados quando a deleção é feita apenas
     * com as informações do aluno
     */
    public boolean deletar(String matricula, String nome, String docRg, String docCpf) {
        Aluno aluno = new Aluno(matricula, nome, docRg, docCpf);
        return deletar(aluno);
    }

    /**
     * Metodo que retorna uma lista de todos os alunos cadastrados. O formato do
     * retorno contém somente dados nativos.
     */
    public Map<Integer, String[]> listarTodos() {
        AlunoDao alunoDao = new AlunoDao();
        Map<Integer, String[]> retorno = new HashMap<>();
        try {
            retorno = mapListaAlunos(alunoDao.listar());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return retorno;
    }

    /**
     * Metodo que retorna uma lista de alunos cadastrados com um nome
     * específico. O formato do retorno contém somente dados nativos.
     */
    public Map<Integer, String[]> listarPorNome(String nome) {
        AlunoDao alunoDao = new AlunoDao();
        Map<Integer, String[]> retorno = new HashMap<>();
        try {
            retorno = mapListaAlunos(alunoDao.listarPorNome(nome));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return retorno;
    }

    /**
     * Metodo que retorna uma lista de alunos cadastrados com uma matrícula
     * específico. O formato do retorno contém somente dados nativos.
     */
    public Map<Integer, String[]> listarPorMatricula(String matricula) {
        AlunoDao alunoDao = new AlunoDao();
        Map<Integer, String[]> retorno = new HashMap<>();
        try {
            retorno = mapListaAlunos(alunoDao.listarPorMatricula(matricula));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return retorno;
    }
}
