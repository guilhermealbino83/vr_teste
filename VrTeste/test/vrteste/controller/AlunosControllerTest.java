package vrteste.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author guilh
 */
public class AlunosControllerTest {
    
    public AlunosControllerTest() {
    }

    @Before
    public void setUp() throws Exception {
        
    }
    
    /**
     * Test of salvar method, of class AlunosController.
     */
    
    @Test
    public void testSalvar() {
        AlunosController ac;
        String matricula = "SDA999999";
        String nome = "Galadriel";
        String docRg = "459879876";
        String docCpf = "65412369852";
        Map<Integer, String[]> retPorNome = new HashMap<>();
        boolean validaNome = false;
        
        ac = new AlunosController();
        
        //Insere o Aluno
        assertTrue(ac.salvar(matricula, nome, docRg, docCpf));
        //Busca pela matrícula
        retPorNome = ac.listarPorMatricula(matricula);
        //se certifica que somente teve 1 retorno
        assertEquals(retPorNome.size(), 1);
        //se certifica que o retorno é do aluno quem questão
        for (String[] ret: retPorNome.values()){
          if(ret[1].equals(nome)){
              validaNome = true;
              break;
          }    
        }
        assertTrue(validaNome);

        //Deleta os dados dos alunos em questão
        assertTrue(ac.deletar(matricula, nome, docRg, docCpf));
                    
    }
    
    @Test
    public void testDeletarPorDados(){
        AlunosController ac; 
        String matricula = "SDA999999";
        String nome = "Galadriel";
        String docRg = "459879876";
        String docCpf = "65412369852";
        Map<Integer, String[]> retAposInsert = new HashMap<>();
        Map<Integer, String[]> retAposDelete = new HashMap<>();
        boolean validaAposInsert = false;
        boolean validaAposDelete = false;
        
        ac = new AlunosController();
        
        //Cria o Aluno para Deleção
        ac.salvar(matricula, nome, docRg, docCpf);
        //Se Certifica que ele foi inserido
        retAposInsert = ac.listarPorMatricula(matricula);
        for (String[] ret: retAposInsert.values()){
          if(ret[1].equals(nome)){
              validaAposInsert = true;
              break;
          }    
        }
        assertTrue(validaAposInsert);
        
        //Deleta o Aluno
        assertTrue(ac.deletar(matricula, nome, docRg, docCpf));
        //Se Certifica que foi deletado
        retAposDelete = ac.listarPorMatricula(matricula);
        for (String[] ret: retAposDelete.values()){
          if(ret[1].equals(nome)){
              validaAposDelete = true;
              break;
          }    
        }
        assertFalse(validaAposDelete);
        
    }

    @Test
    public void testDeletarPorId(){
        AlunosController ac; 
        String matricula = "SDA999999";
        String nome = "Galadriel";
        String docRg = "459879876";
        String docCpf = "65412369852";
        int codAluno = 0;
        Map<Integer, String[]> retAposInsert = new HashMap<>();
        Map<Integer, String[]> retAposDelete = new HashMap<>();
        boolean validaAposInsert = false;
        boolean validaAposDelete = false;
        
        ac = new AlunosController();
        
        //Cria o Aluno para Deleção
        ac.salvar(matricula, nome, docRg, docCpf);
        //Resgata o ID do aluno Salvo
        retAposInsert = ac.listarPorMatricula(matricula);
        for (int id : retAposInsert.keySet()) {
            String[] elemento = retAposInsert.get(id);
            if (elemento[1].equals(nome)){
              codAluno = id;
              break;
            }
        }
        
        //Deleta o Aluno
        assertTrue(ac.deletar(codAluno, matricula, nome, docRg, docCpf));
        //Se Certifica que foi deletado
        retAposDelete = ac.listarPorMatricula(matricula);
        for (String[] ret: retAposDelete.values()){
          if(ret[1].equals(nome)){
              validaAposDelete = true;
              break;
          }    
        }
        assertFalse(validaAposDelete);
        
    }
    
    
}
