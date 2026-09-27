/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.bibliotecaWeb.model;

/**
 *
 * @author Cesar Adrian Ortega Perez
 */
public class clsLibro extends clsMaterialBibliografico {
    //Creacion de atributos
    private String isbn;
    private String categoria;
    
    //Creacion del constructor de la clase
    public clsLibro(String Titulo, String Autor, String Isbn, String Categoria){
        super(Titulo, Autor);
        
        if(Isbn == null || Isbn.isBlank())
            throw new IllegalArgumentException("El ISBN no puede estar vacio");
        
        if(Categoria == null || Categoria.isBlank())
            throw new IllegalArgumentException("La categoria no puede estar vacia");
        
        isbn = Isbn;
        categoria = Categoria;
    }
    
    //Creacion de getters
    public String getIsbn(){
        return isbn;
    }
    
    public String getCategoria(){
        return categoria;
    }
    
    //Creacion de setters
    public void setIsbn(String Isbn){
        if(Isbn == null || Isbn.isBlank())
            throw new IllegalArgumentException("El ISBN no puede estar vacio");
        
        isbn = Isbn;
    }
    
    public void setCategoria(String Categoria){
        if(Categoria == null || Categoria.isBlank())
            throw new IllegalArgumentException("La categoria no puede estar vacia");
        
        categoria = Categoria;
    }
}
