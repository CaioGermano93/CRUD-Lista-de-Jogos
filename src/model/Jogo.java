/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Yago
 */
public class Jogo {
    private int id;
    private String nome;
    private String genero;
    private String empresa;
    
  
    //--------------------------------------Constructors
    public Jogo(){
        
    }

    public Jogo(int id, String nome, String genero, String empresa) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.empresa = empresa;
    }

    public Jogo(String nome, String genero, String empresa) {
        this.nome = nome;
        this.genero = genero;
        this.empresa = empresa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
    
    
    


    
    
 
    
    
}
