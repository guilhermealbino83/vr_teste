
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import vrteste.controller.AlunosController;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author guilh
 */
public class sandBox {

    public static void main(String[] args) {
        AlunosController ac;
        String matricula = "SDA004";
        String nome = "Galadriel";
        String docRg = "459879876";
        String docCpf = "65412369852";
        Map<Integer, String[]> retPorNome = new HashMap<>();
        boolean retDelete;

        ac = new AlunosController();
        retPorNome = ac.listarPorMatricula(matricula);
        System.out.println(retPorNome.size());
        System.out.println(retPorNome.keySet());
        for (int codAluno : retPorNome.keySet()) {
            String[] elemento = retPorNome.get(codAluno);
            if (elemento[1].equals(nome)){
              System.out.println(codAluno);      
            }
        }
    }
}
