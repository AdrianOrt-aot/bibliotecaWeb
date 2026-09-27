/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.bibliotecaWeb.model;
//Se importan ArrayList y List
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cesar Adrian Ortega Perez
 */
public class clsBiblioteca {
    //Se crean atributos
    private String nombre;
    private List<clsLibro> libros;
    
    //Getters
    public String getNombre(){
        return nombre;
    }
    
    public List<clsLibro> getLibros(){
        return new ArrayList<>(libros);
    }
    
    //Setters
    public void setNombre(String Nombre){
        if(Nombre == null || Nombre.isBlank())
            throw new IllegalArgumentException("El nombre de la biblioteca no puede estar vacio");
        
        nombre = Nombre;
    }
    
    //Se crea el constructor
    public clsBiblioteca(String Nombre){
        if(Nombre == null || Nombre.isBlank())
            throw new IllegalArgumentException("El nombre de la biblioteca no puede estar vacio");
        
        nombre = Nombre;
        libros = new ArrayList<>();
    }
    
    //Creacion de metodos
    //Metodo para agregar libro
    public boolean agregarLibro(clsLibro Libro){
        if(Libro == null)
            return false;
        
        if((buscarLibro(Libro.getIsbn()) != null))
            return false;
        
        libros.add(Libro);
        return true;
    }
    
    
    //Metodo publico para buscar libro
    public clsLibro buscarLibro(String Isbn){
        if(Isbn == null || Isbn.isBlank())
            return null;
        
        return buscarLibro(Isbn, 0);
    }
    
    
    //Metodo privado para buscar libro
    private clsLibro buscarLibro(String Isbn, int Posicion){
        //Caso base: LLegar al final de la coleccion
        if(Posicion >= libros.size())
            return null;
        
        //Caso de extio: Encontrar el ISBN
        if(libros.get(Posicion).getIsbn().equalsIgnoreCase(Isbn))
            return libros.get(Posicion);
        
        return buscarLibro(Isbn, Posicion + 1);
    }
    
    //Metodo oara eliminar libro
    public boolean eliminarLibro(String Isbn){
        clsLibro libro = buscarLibro(Isbn);
        
        if(libro == null)
            return false;
        
        libros.remove(libro);
        return true;
    }
    
    //Metodo para prestar libro
    public boolean prestarLibro(String Isbn){
        clsLibro libro = buscarLibro(Isbn);
        
        if(libro == null || !libro.getDisponible())
            return false;
        
        libro.setDisponible(false);
        return true;
    }
    
    //Metodo para devolver libro
    public boolean devolverLibro(String Isbn){
        clsLibro libro = buscarLibro(Isbn);
        
        if(libro == null || libro.getDisponible())
            return false;
        
        libro.setDisponible(true);
        return true;
    }
    
    //Metodo para contar libros disponibles
    public int contarDisponibles(){
        int contador = 0;
        
        for(clsLibro libro: libros)
            if(libro.getDisponible())
                contador++;
        
        return contador;
    }
    
    //Metodo para obtener cantidad total de libros
    public int obtenerTotalLibros(){
        return libros.size();
    }
    
}
