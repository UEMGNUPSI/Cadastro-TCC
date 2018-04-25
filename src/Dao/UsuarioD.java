
package Dao;

import Model.UsuarioM;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import view.PrincipalView;



public class UsuarioD {

    PrincipalView principal = new PrincipalView();
    
    
          public static UsuarioM valida(String user, String senha) throws SQLException{
        PreparedStatement pst;
        String sql;
           sql = "select * from usuario where masp = ? and senha = ?";
           pst = Conexao.getInstance().prepareStatement(sql);
           pst.setString(1, user);
           pst.setString(2, senha);
           UsuarioM usuario;
           usuario = null;
           ResultSet rs = pst.executeQuery();
           while(rs.next()){
               usuario = new UsuarioM(rs.getInt("id"),
                       rs.getString("nome"), 
                       rs.getString("masp"),
                       rs.getString("senha"),
                       rs.getBoolean("admin"),
                       rs.getBoolean("inativo"));
            }
            pst.close();
            return usuario;
    }
        
    
          static public List<UsuarioM> listaTodos() throws SQLException{
        PreparedStatement pst;
        String sql;
        List<UsuarioM> listaUser = new ArrayList<UsuarioM>();
        sql = "select * from usuario";
        pst = Conexao.getInstance().prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        
        while(rs.next()){
           listaUser.add(new UsuarioM(rs.getInt("id"),
                       rs.getString("nome"), 
                       rs.getString("masp"),
                       rs.getString("senha"),
                       rs.getBoolean("admin"),
                       rs.getBoolean("inativo"))
                        );
           
            
             
            
         }
         
          pst.close();
         return listaUser;
    }

          
         static public void salvar(UsuarioM usuario) throws SQLException{
        PreparedStatement pst;
        String sql;
        sql = "insert into Usuario values(?,?,?,?,?,?)";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, 0);
        pst.setString(2, usuario.getNome());
        pst.setString(3, usuario.getMasp());
        pst.setString(4, usuario.getSenha());
        pst.setBoolean(5,usuario.getAdmin());
        pst.setBoolean(6,usuario.getInativo());
        pst.execute();
        pst.close();
    }   
         
         
         static public void excluir(UsuarioM usuario) throws SQLException{
        PreparedStatement pst;
        String sql;
        sql = "delete from usuario where id = ?";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, usuario.getId());
        pst.execute();
        pst.close();
    }
         
          static public void alterar(UsuarioM usuario) throws SQLException{
         PreparedStatement pst;
         String sql;
         sql = "update usuario set nome = ?, masp = ?, senha = ?, admin = ?, inativo = ? where id = ?";
         pst = Conexao.getInstance().prepareStatement(sql);
        
        pst.setString(1, usuario.getNome());
        pst.setString(2, usuario.getMasp());
        pst.setString(3, usuario.getSenha());
        pst.setBoolean(4, usuario.getAdmin());
        pst.setBoolean(5, usuario.getInativo());
        pst.setInt(6, usuario.getId());
        pst.execute();
        pst.close();
     } 
        
          static public UsuarioM BuscaPorNome(int id) throws SQLException {
        PreparedStatement pst;
        String sql;
        UsuarioM usuario = null;
        sql = "Select * from usuario where nome=?";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, id);
        pst.executeQuery();
        ResultSet rs = pst.getResultSet();
        while(rs.next()){
               usuario = new UsuarioM(rs.getInt("id"),                       
                       rs.getString("nome"), 
                       rs.getString("masp"),
                       rs.getString("senha"), 
                       rs.getBoolean("inativo"),
                       rs.getBoolean("inativo")
               );
        }
        pst.close();
        return usuario;
    }
}
