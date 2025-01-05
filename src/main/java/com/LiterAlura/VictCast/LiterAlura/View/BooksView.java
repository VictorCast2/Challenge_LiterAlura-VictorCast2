package com.LiterAlura.VictCast.LiterAlura.View;

import com.LiterAlura.VictCast.LiterAlura.Models.Books;

import java.util.List;

public class BooksView {

    // Método para mostrar todos los libros
    public void displayBooks(List<Books> books) {
        if (books.isEmpty()) {
            System.out.println("No hay libros registrados.");
        } else {
            System.out.println("===== Lista de Libros =====");
            books.forEach(book -> System.out.printf("ID: %d | Título: %s | Autor: %s | Idioma: %s%n",
                    book.getId(), book.getTitle(), book.getAuthor(), book.getLanguage()));
        }
    }

    // Método para mostrar un solo libro
    public void displayBook(Books book) {
        if (book != null) {
            System.out.printf("ID: %d | Título: %s | Autor: %s | Idioma: %s%n",
                    book.getId(), book.getTitle(), book.getAuthor(), book.getLanguage());
        } else {
            System.out.println("Libro no encontrado.");
        }
    }

    // Método para mostrar mensaje de éxito al guardar libros
    public void displayFetchResult(int numberOfBooks) {
        System.out.printf("%d libros guardados en la base de datos.%n", numberOfBooks);
    }

    // Método para mostrar mensaje de error
    public void displayError(String message) {
        System.out.println("Error: " + message);
    }

}