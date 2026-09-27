/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.bibliotecaWeb.controller;
//Import para convertirlo en un Controller de Spring
import org.springframework.stereotype.Controller;
//Se importa clsBiblioteca para que pueda tener acceso
import com.example.bibliotecaWeb.model.clsBiblioteca;
//Import usado en la aplicacion para ir directamente a index
import org.springframework.web.bind.annotation.GetMapping;
//Import para enviar informacion de biblioteca a index.html
import org.springframework.ui.Model;
//Import para llamar a la clase clsLibro
import com.example.bibliotecaWeb.model.clsLibro;
//Import para peticiones Post de HTTP
import org.springframework.web.bind.annotation.PostMapping;
//Import para recibir parámetros enviados desde una petición HTTP
import org.springframework.web.bind.annotation.RequestParam;
//Import para enviar información a otra página después de hacer una redirección
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Cesar Adrian Ortega Perez
 */

//Se agrega @Controller para indicar que se encargara de recibir las solicitudes del navegador
@Controller
public class clsBibliotecaController {
    //Se crea el objeto de la clase biblioteca
    private clsBiblioteca biblioteca;
    
    //Constructor del controlador
    public clsBibliotecaController(){
        biblioteca = new clsBiblioteca("Biblioteca Web");
    }
    
    //Metodo para mostrar la pagina principal
    @GetMapping("/")
    public String mostrarInicio(Model model){
        //Se envia la informacion de la biblioteca a la pagina HTML
        model.addAttribute("nombreBiblioteca", biblioteca.getNombre());
        model.addAttribute("libros", biblioteca.getLibros());
        
        return "index";
    }
    
    @PostMapping("/agregar")
    public String agregarLibro(
        @RequestParam String titulo,
        @RequestParam String autor,
        @RequestParam String isbn,
        @RequestParam String categoria,
        RedirectAttributes redirectAttribute){

        try{
            //Se crea un nuevo libro usando las validaciones del constructor
            clsLibro libro = new clsLibro(
                titulo,
                autor,
                isbn,
                categoria
            );

            //Se intenta agregar el libro a la biblioteca
            boolean agregado = biblioteca.agregarLibro(libro);

            if(agregado)
                redirectAttribute.addFlashAttribute("mensaje", "Libro registrado correctamente.");
            else
                redirectAttribute.addFlashAttribute("error", "No se pudo registrar el libro. El ISBN ya exite");
        }
        catch(IllegalArgumentException e){
            //Muestra al usuario el mensaje generado por la validacion
            redirectAttribute.addFlashAttribute("error", e.getMessage());
        }
        //Se regresa a la pagina principal
        return "redirect:/";
    }
    
    //Metodo para prestar un libro
    @PostMapping("/prestar")
    public String prestarLibro(@RequestParam String isbn, RedirectAttributes redirectAttribute){
        boolean prestado = biblioteca.prestarLibro(isbn);
        
        if(prestado)
            redirectAttribute.addFlashAttribute("mensaje", "Libro prestado correctamente");
        else
            redirectAttribute.addFlashAttribute("error", "No se pudo prestar el libro");
        
        return "redirect:/";
    }
    
    //Metodo para devolver un libro
    @PostMapping("/devolver")
    public String devolverLibro(@RequestParam String isbn, RedirectAttributes redirectAttribute){
        boolean devuelto = biblioteca.devolverLibro(isbn);
        
        if(devuelto)
            redirectAttribute.addFlashAttribute("mensaje", "Libro devuelto correctamente");
        else
            redirectAttribute.addFlashAttribute("error", "No se pudo devolver el libro");
        
        return "redirect:/";
    }
    
    //Metodo para eliminar un libro
    @PostMapping("/eliminar")
    public String eliminarLibro(@RequestParam String isbn, RedirectAttributes redirectAttribute){
        boolean eliminado = biblioteca.eliminarLibro(isbn);
        
        if(eliminado)
            redirectAttribute.addFlashAttribute("mensaje", "Libro eliminado correctamente");
        else
            redirectAttribute.addFlashAttribute("mensaje", "No se pudo eliminar el libro");
        return "redirect:/";
    }
    
    //Metodo para buscar por ISBN
    @GetMapping("/buscar")
    public String buscarLibro(@RequestParam String isbn, Model model){
        clsLibro libroEncontrado = biblioteca.buscarLibro(isbn);
        
        model.addAttribute("nombreBiblioteca", biblioteca.getNombre());
        model.addAttribute("libros", biblioteca.getLibros());
        model.addAttribute("libroEncontrado", libroEncontrado);
        model.addAttribute("isbnBuscado", isbn);
        
        return "index";
    }
}
