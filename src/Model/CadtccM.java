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
public class CadtccM {
  
    private int Id;
    private String Autor;
    private String Titulo;
    private String Orientador;
    private String Coorientador;
    private CursoM IdCurso;
    private String Registro;
    private String DataEntrega;
    private String DataApresentacao;
    private String Trabalho;

    public CadtccM() {
    }

    public CadtccM(int Id, String Autor, String Titulo, String Orientador, String Coorientador, CursoM IdCurso, String Registro, String DataEntrega, String DataApresentacao, String Trabalho) {
        this.Id = Id;
        this.Autor = Autor;
        this.Titulo = Titulo;
        this.Orientador = Orientador;
        this.Coorientador = Coorientador;
        this.IdCurso = IdCurso;
        this.Registro = Registro;
        this.DataEntrega = DataEntrega;
        this.DataApresentacao = DataApresentacao;
        this.Trabalho = Trabalho;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String Autor) {
        this.Autor = Autor;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getOrientador() {
        return Orientador;
    }

    public void setOrientador(String Orientador) {
        this.Orientador = Orientador;
    }

    public String getCoorientador() {
        return Coorientador;
    }

    public void setCoorientador(String Coorientador) {
        this.Coorientador = Coorientador;
    }

    public CursoM getIdCurso() {
        return IdCurso;
    }

    public void setIdCurso(CursoM IdCurso) {
        this.IdCurso = IdCurso;
    }

    public String getRegistro() {
        return Registro;
    }

    public void setRegistro(String Registro) {
        this.Registro = Registro;
    }

    public String getDataEntrega() {
        return DataEntrega;
    }

    public void setDataEntrega(String DataEntrega) {
        this.DataEntrega = DataEntrega;
    }

    public String getDataApresentacao() {
        return DataApresentacao;
    }

    public void setDataApresentacao(String DataApresentacao) {
        this.DataApresentacao = DataApresentacao;
    }

    public String getTrabalho() {
        return Trabalho;
    }

    public void setTrabalho(String Trabalho) {
        this.Trabalho = Trabalho;
    }
    
    
    
}
