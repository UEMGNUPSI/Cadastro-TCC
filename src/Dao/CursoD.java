/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.CursoM;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Danilo-NOTE
 */
public class CursoD {
    
    
    public CursoM buscaNome(String nome) throws SQLException{
        PreparedStatement pst;
        String sql;
        CursoM curso = null;        
        sql = "select * from Curso where nome = ?";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setString(1, nome);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            curso = new CursoM(
                            rs.getInt("id"),
                            rs.getString("nome"));
        }
        pst.close();
        return curso;
    }
    public CursoM busca(int id) throws SQLException{
        PreparedStatement pst;
        String sql;
        CursoM curso = null;        
        sql = "select * from Modelo where id = ?";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            curso = new CursoM(
                            rs.getInt("id"),
                            rs.getString("nome"));
        }
        pst.close();
        return curso;
    }
}
