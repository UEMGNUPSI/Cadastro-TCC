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
import java.util.ArrayList;
import java.util.List;

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
        sql = "select * from curso where id = ?";
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
    
      public void Salvar (CursoM curso) throws SQLException{
        PreparedStatement pst;
        String sql;          
        sql = "insert into curso values (?,?)";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, 0);
        pst.setString(2, curso.getNome());
        pst.execute();
        pst.close();
    }
    
       public void Excluir(CursoM curso) throws SQLException{
        PreparedStatement pst;
        String sql;           
        sql = "delete from curso where id = ?";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, curso.getId());
        pst.execute();
        pst.close();
    }
       
           static public void alterar (CursoM curso) throws SQLException{
        PreparedStatement pst;
        String sql;
        sql = "update curso set nome=? where id=?";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setString(1, curso.getNome());
        pst.setInt(2, curso.getId());
        pst.execute();
        pst.close();
        
    }
           
          public List<CursoM> ListaCurso () throws SQLException{
        PreparedStatement pst;
        String sql;
              
        List<CursoM> listaCurso;
        listaCurso = new ArrayList<>();
    
         sql = "select * from curso order by nome";
         pst = Conexao.getInstance().prepareStatement(sql);
         ResultSet rs = pst.executeQuery();
    
         while (rs.next()) {
        listaCurso.add(new CursoM(rs.getInt("id"), rs.getString("nome")));
        }
        pst.close();
        return listaCurso;
    }
}
