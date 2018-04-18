/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.LogM;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Danilo-NOTE
 */
public class LogD {
    
    public void Salvar (LogM log) throws SQLException{
        PreparedStatement pst;
        String sql;
        sql = "insert into Log values (?,?,?,?,?,?)";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setInt(1,0);
        pst.setString(2, log.getAcao());
        pst.setInt(3, log.getIdUsuario().getId());
        pst.setString(4, log.getHora());
        pst.setString(5, log.getData());
        pst.setString(6, log.getTituloTrabalho());
        
        pst.execute();
        pst.close();
    }
}
