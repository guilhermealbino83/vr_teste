/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vrteste.models;


/**
 *
 * @author guilh
 */
public class Aluno {

    private int codAluno;
    private String matricula;
    private String nome;
    private String docRg;

    public int getCodAluno() {
        return codAluno;
    }

    public void setCodAluno(int codAluno) {
        this.codAluno = codAluno;
    }
    private String docCpf;

    public Aluno(String matricula, String nome, String docRg, String docCpf) {
        this.codAluno = -1;
        this.matricula = matricula;
        this.nome = nome;
        this.docRg = docRg;
        this.docCpf = docCpf;
    }

    public Aluno(int codAluno, String matricula, String nome, String docRg, String docCpf) {
        this.codAluno = codAluno;
        this.matricula = matricula;
        this.nome = nome;
        this.docRg = docRg;
        this.docCpf = docCpf;
    }
    public Aluno() {

    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocRg() {
        return docRg;
    }

    public void setDocRg(String docRg) {
        this.docRg = docRg;
    }

    public String getDocCpf() {
        return docCpf;
    }

    public void setDocCpf(String docCpf) {
        this.docCpf = docCpf;
    }

}
