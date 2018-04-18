/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Danilo-NOTE
 */
public class LogM {
    private int Id;
    private String Acao;
    private UsuarioM IdUsuario;
    private String Hora;
    private String Data;
    private String TituloTrabalho;

    public LogM() {
    }

    public LogM(int Id, String Acao, UsuarioM IdUsuario, String Hora, String Data, String TituloTrabalho) {
        this.Id = Id;
        this.Acao = Acao;
        this.IdUsuario = IdUsuario;
        this.Hora = Hora;
        this.Data = Data;
        this.TituloTrabalho = TituloTrabalho;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getAcao() {
        return Acao;
    }

    public void setAcao(String Acao) {
        this.Acao = Acao;
    }

    public UsuarioM getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(UsuarioM IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String Hora) {
        this.Hora = Hora;
    }

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }

    public String getTituloTrabalho() {
        return TituloTrabalho;
    }

    public void setTituloTrabalho(String TituloTrabalho) {
        this.TituloTrabalho = TituloTrabalho;
    }

    
}
