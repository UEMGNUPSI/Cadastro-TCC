package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Danilo-NOTE
 */
public class UsuarioM {
    private int Id;
    private String Nome;
    private String Masp;
    private String Senha;
    private Boolean Inativo;

    public UsuarioM() {
    }

    public UsuarioM(int Id, String Nome, String Masp, String Senha, Boolean Inativo) {
        this.Id = Id;
        this.Nome = Nome;
        this.Masp = Masp;
        this.Senha = Senha;
        this.Inativo = Inativo;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getMasp() {
        return Masp;
    }

    public void setMasp(String Masp) {
        this.Masp = Masp;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    public Boolean getInativo() {
        return Inativo;
    }

    public void setInativo(Boolean Inativo) {
        this.Inativo = Inativo;
    }

    
}
