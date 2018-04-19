/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.CadtccM;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danilo-NOTE
 */
public class CadtccD {
    
    CursoD cursodao = new CursoD();
    
    public void salvar (CadtccM cadtcc) throws SQLException{
        PreparedStatement pst;
        String sql;
        sql = "insert into Cadtcc set id = ?, autor = ?, titulo = ?, orientador = ?, coorientador = ?, idcurso = ?,"
                + " registro = ?, dataentrega = ?, dataapresentacao = ?, trabalho = ?";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setInt(1,0);
        pst.setString(2, cadtcc.getAutor());
        pst.setString(3, cadtcc.getTitulo());
        pst.setString(4, cadtcc.getOrientador());
        pst.setString(5, cadtcc.getCoorientador());
        pst.setInt(6, cadtcc.getIdCurso().getId());
        pst.setString(7, cadtcc.getRegistro()); 
        pst.setString(8, cadtcc.getDataEntrega());
        pst.setString(9, cadtcc.getDataApresentacao());
        pst.setString(10, cadtcc.getTrabalho());       
        pst.execute();
        pst.close();
    }
    
    
    public void excluir(CadtccM cadtcc) throws SQLException{
        PreparedStatement pst;
        String sql;
        sql = "delete from Cadtcc where id = ?";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, cadtcc.getId());
        pst.execute();
        pst.close();
    }
    
    public void alterar(CadtccM cadtcc) throws SQLException{
        PreparedStatement pst;
        String sql;
        sql = "update Cadtcc set "
                        + "autor = ?, "
                        + "titulo = ?, "
                        + "orientador = ?, "
                        + "coorientador = ?, "
                        + "idcurso = ?, "
                        + "registro  = ?, "
                        + "dataentrega  = ?, "
                        + "dataapresentacao  = ?, "
                        + "trabalho  = ?, "

                        + "where id = ?";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setString(1, cadtcc.getAutor());
        pst.setString(2, cadtcc.getTitulo());
        pst.setString(3, cadtcc.getOrientador());
        pst.setString(4, cadtcc.getCoorientador());
        pst.setInt(5, cadtcc.getIdCurso().getId());
        pst.setString(6, cadtcc.getRegistro()); 
        pst.setString(7, cadtcc.getDataEntrega());
        pst.setString(8, cadtcc.getDataApresentacao());
        pst.setString(9, cadtcc.getTrabalho());
        pst.setInt(10,cadtcc.getId());
        pst.execute();
        pst.close();
     }
    
    public List<CadtccM> listaTodos() throws SQLException{
        PreparedStatement pst;
        String sql;
        List<CadtccM> listaCadtcc = new ArrayList<>();
        sql = "select * from Cadtcc order by autor";
        pst = Conexao.getInstance().prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        
        while(rs.next()){
            listaCadtcc.add(new CadtccM(
                            rs.getInt("id"),
                            rs.getString("autor"),
                            rs.getString("titulo"),
                            rs.getString("orientador"),
                            rs.getString("coorientador"),
                            cursodao.busca(rs.getInt("idcurso")),
                            rs.getString("registro"),
                            rs.getString("dataentrega"),
                            rs.getString("dataapresentacao"),
                            rs.getString("trabalho")));
        }
        pst.close();
        return listaCadtcc;
    }
    
    public List<CadtccM> listaAutor(String nome, String curso, String tipo) throws SQLException{
        PreparedStatement pst;
        String sql = null;
        List<CadtccM> listaCadtcc = new ArrayList<>();
        pst = Conexao.getInstance().prepareStatement(sql);
        sql = "select * from Cadtcc ";
        
        if(tipo.equals("Autor")){
            sql = sql+"where autor like %?%";
            pst.setString(1, nome);
        }else if(tipo.equals("Título")){
            sql = sql+"where titulo like %?%";
            pst.setString(1, nome);
        }else if(tipo.equals("Registro")){
            sql = sql+"where registro like %?%";
            pst.setString(1, nome);
        }else if(tipo.equals("Apresentação")){
            sql = sql+"where dataapresentacao like %?%";
            pst.setString(1, nome);
        }else if(tipo.equals("Entrega")){
            sql = sql+"where dataentrega like %?%";
            pst.setString(1, nome);
        }
        
        if(!curso.equals("todos")){
            sql = sql+ " and curso = ?";
            pst.setString(2, curso);
        }
        
        ResultSet rs = pst.executeQuery();
        
        while(rs.next()){
            listaCadtcc.add(new CadtccM(
                            rs.getInt("id"),
                            rs.getString("autor"),
                            rs.getString("titulo"),
                            rs.getString("orientador"),
                            rs.getString("coorientador"),
                            cursodao.busca(rs.getInt("idcurso")),
                            rs.getString("registro"),
                            rs.getString("dataentrega"),
                            rs.getString("dataapresentacao"),
                            rs.getString("trabalho")));
        }
        pst.close();
        return listaCadtcc;
    }
    
    public CadtccM buscaUltimoRegistro() throws SQLException{
        int i = 0;
        PreparedStatement pst;
        String sql;
        CadtccM cadtcc = null;        
        sql = "select * from cadtcc order by id desc";
        pst = Conexao.getInstance().prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            cadtcc = new CadtccM(
                            rs.getInt("id"),
                            rs.getString("autor"),
                            rs.getString("titulo"),
                            rs.getString("orientador"),
                            rs.getString("coorientador"),
                            cursodao.busca(rs.getInt("idcurso")),
                            rs.getString("registro"),
                            rs.getString("dataentrega"),
                            rs.getString("dataapresentacao"),
                            rs.getString("trabalho"));
            i++;
        }
        pst.close();
        
        if(i==0){
            return null;
        }else{
            return cadtcc;
        }
    }
}
