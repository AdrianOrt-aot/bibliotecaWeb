/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.bibliotecaWeb.model;

/**
 *
 * @author Cesar Adrian Ortega Perez
 */
public abstract class clsMaterialBibliografico {
    //Creacion de atributos
    private String titulo;
    private String autor;
    private boolean disponible;
    
    //Creacion del constructor de la clase
    public clsMaterialBibliografico(String Titulo, String Autor){
        if(Titulo == null || Titulo.isBlank())
            throw new IllegalArgumentException("El titulo no puede estar vacio.");        
        
        if(Autor == null || Autor.isBlank())
            throw new IllegalArgumentException("El autor no puede estar vacio");
                
        titulo = Titulo;
        autor = Autor;
        disponible = true;
    }
    
    //Creacion de getters    
    public String getTitulo(){
        return titulo;
    }
    
    public String getAutor(){
        return autor;
    }
    
    public boolean getDisponible(){
        return disponible;
    }
    
    //Creacion de setters
    public void setTitulo(String Titulo){
        if(Titulo == null || Titulo.isBlank())
            throw new IllegalArgumentException("El titulo no puede estar vacio");
        
        titulo = Titulo;
    }
    
    public void setAutor(String Autor){
        if(Autor == null || Autor.isBlank())
            throw new IllegalArgumentException("El autor no puede estar vacio");
        
        autor = Autor;
    }
    
    public void setDisponible(boolean Disponible){
        disponible = Disponible;
    }
}
