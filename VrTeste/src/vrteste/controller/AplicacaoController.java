package vrteste.controller;

import java.sql.SQLException;
import vrteste.DAO.AplicacaoDao;

/**
 * @author guilh
 */
public class AplicacaoController {
    
    public boolean inicializacao(){
        return AplicacaoDao.existeBanco();
    }
    
    public void criarBanco() throws SQLException{
        AplicacaoDao.criaBanco();
    }
    
}
