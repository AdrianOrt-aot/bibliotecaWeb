# Biblioteca Web

Aplicación web para la administración básica de libros, desarrollada con Java, Spring Boot y Thymeleaf.

El proyecto permite registrar, buscar, prestar, devolver y eliminar libros mediante una interfaz web. La información se administra en memoria utilizando una estructura de datos implementada en la clase `clsBiblioteca`.

## Autor

**Cesar Adrian Ortega Perez**

## Tecnologías utilizadas

- Java 21
- Spring Boot
- Thymeleaf
- Maven
- HTML5
- CSS3
- NetBeans
- Git y GitHub

## Funcionalidades

La aplicación permite realizar las siguientes operaciones:

- Registrar libros.
- Buscar libros mediante su ISBN.
- Prestar libros disponibles.
- Devolver libros prestados.
- Eliminar libros.
- Consultar el estado de disponibilidad de los libros.
- Evitar el registro de ISBN duplicados.
- Validar los datos ingresados.

## Estructura principal del proyecto

El proyecto utiliza las siguientes clases:

### `clsMaterialBibliografico`

Clase abstracta que contiene los atributos y comportamientos comunes de los materiales bibliográficos.

Entre sus atributos se encuentran:

- Título
- Autor
- Disponibilidad

### `clsLibro`

Hereda de `clsMaterialBibliografico` y agrega información específica de un libro, como:

- ISBN
- Categoría

### `clsBiblioteca`

Representa el TDA (Tipo de Dato Abstracto) principal del proyecto.

Internamente administra una colección de objetos `clsLibro` mediante un `ArrayList`.

Incluye operaciones para:

- Agregar libros.
- Buscar libros.
- Eliminar libros.
- Prestar libros.
- Devolver libros.
- Contar libros disponibles.
- Obtener el total de libros.

## Recursividad

La búsqueda de libros por ISBN utiliza un método recursivo.

El método evalúa los elementos almacenados en la biblioteca uno por uno hasta encontrar el ISBN solicitado.

La recursividad contiene:

- **Caso base:** se alcanza el final de la colección sin encontrar el libro.
- **Caso de éxito:** el ISBN del libro actual coincide con el ISBN buscado.
- **Avance recursivo:** se realiza una nueva llamada incrementando la posición de búsqueda.

## Programación Orientada a Objetos

En el proyecto se aplican conceptos de Programación Orientada a Objetos como:

- Encapsulamiento.
- Herencia.
- Abstracción.
- Constructores.
- Validación de datos.
- Getters y setters.
- Manejo de objetos y colecciones.

## Interfaz web

La aplicación utiliza Spring Boot y Thymeleaf para proporcionar una interfaz gráfica desde el navegador.

Las operaciones realizadas desde la interfaz se comunican con la lógica de la biblioteca mediante un controlador de Spring.

## Validaciones

El sistema incluye validaciones para evitar, entre otros casos:

- Títulos vacíos.
- Autores vacíos.
- ISBN vacíos.
- Categorías vacías.
- ISBN duplicados.
- Préstamos de libros que no están disponibles.

## Pruebas

El proyecto incluye pruebas para comprobar parte de la lógica de la aplicación, incluyendo:

- Registro de libros.
- Prevención de ISBN duplicados.
- Búsqueda recursiva de libros.

## Ejecución

Para ejecutar el proyecto:

1. Abrir el proyecto con NetBeans.
2. Verificar que se esté utilizando Java 21.
3. Ejecutar el proyecto Spring Boot.
4. Esperar a que el servidor inicie correctamente.
5. Abrir un navegador web.
6. Acceder a:

   `http://localhost:8080/`

## Almacenamiento de datos

Este proyecto no utiliza una base de datos.

Los libros se almacenan temporalmente en memoria mediante un `ArrayList`, por lo que la información se elimina cuando se detiene o reinicia la aplicación.

## Repositorio

Proyecto desarrollado con fines académicos para demostrar la aplicación de estructuras de datos, recursividad, Programación Orientada a Objetos y desarrollo de interfaces web con Java.

---

**Desarrollado por Cesar Adrian Ortega Perez**