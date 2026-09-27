/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.bibliotecaWeb.model;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 *
 * @author Cesar Adrian Ortega Perez
 */
public class clsBibliotecaTest {
    @Test
    public void probarAgregarLibros(){
        //Se crea una biblioteca
        clsBiblioteca biblioteca = new clsBiblioteca("Biblioteca");
        
        //Se crea un libro
        clsLibro libro1 = new clsLibro(
        "El Principito",
        "Antoine de Saint-Exupery",
        "9780156012195",
        "Literatura");
        
        clsLibro libro2 = new clsLibro(
        "Otro libro",
        "Otro autor",
        "9780156012195",
        "Literatura");
        
        //Se agregan los libros
    boolean resultado1 = biblioteca.agregarLibro(libro1);
    boolean resultado2 = biblioteca.agregarLibro(libro2);

    //El primero debe agregarse correctamente
    assertTrue(resultado1);

    //El segundo debe ser rechazado
    assertFalse(resultado2);

    //La biblioteca debe seguir teniendo solamente un libro
    assertEquals(1, biblioteca.obtenerTotalLibros());
    }
    
    @Test
    public void probarBusquedaRecursiva(){

        //Se crea una biblioteca
        clsBiblioteca biblioteca = new clsBiblioteca("Biblioteca");

        //Se crean tres libros
        clsLibro libro1 = new clsLibro(
                "El Principito",
                "Antoine de Saint-Exupery",
                "9780156012195",
                "Literatura"
        );

        clsLibro libro2 = new clsLibro(
                "Don Quijote de la Mancha",
                "Miguel de Cervantes",
                "9788424119474",
                "Literatura"
        );

        clsLibro libro3 = new clsLibro(
                "Cien años de soledad",
                "Gabriel Garcia Marquez",
                "9780307474728",
                "Literatura"
        );

        //Se agregan los tres libros a la biblioteca
        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);
        biblioteca.agregarLibro(libro3);

        //Se busca el tercer libro mediante su ISBN
        clsLibro libroEncontrado =
                biblioteca.buscarLibro("9780307474728");

        //Se comprueba que el libro haya sido encontrado
        assertNotNull(libroEncontrado);

        //Se comprueba que sea el libro correcto
        assertEquals(
                "Cien años de soledad",
                libroEncontrado.getTitulo()
        );
    }
}
