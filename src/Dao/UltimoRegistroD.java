/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.UltimoRegistroM;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Danilo-NOTE
 */
public class UltimoRegistroD {
    
    public void alterar(UltimoRegistroM ur) throws SQLException{
        PreparedStatement pst;
        String sql;
        sql = "update ultimoregistro set "
                        + "nome = ?"

                        + "where id = ?";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setString(1, ur.getNome());
        pst.setInt(2,ur.getId());
        pst.execute();
        pst.close();
    }
    public String buscaId() throws SQLException{
        PreparedStatement pst;
        String sql;
        UltimoRegistroM ur = null;      
        sql = "select * from ultimoregistro where id = ?";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, 1);
        ResultSet rs = pst.executeQuery();
            while(rs.next()){
                ur = new UltimoRegistroM(
                                rs.getInt("id"),
                                rs.getString("nome"));
            }
        
        pst.close();
        return ur.getNome();
    }
}
