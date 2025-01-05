package com.LiterAlura.VictCast.LiterAlura.Controllers;

import com.LiterAlura.VictCast.LiterAlura.Services.BooksServices;
import com.LiterAlura.VictCast.LiterAlura.View.BooksView;
import com.LiterAlura.VictCast.LiterAlura.Models.Books;
import lombok.*;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;

@Data
@AllArgsConstructor
@Getter
@Setter
@Controller
public class BooksController {

    private final BooksServices bookService;
    private final BooksView booksView;

    public BooksController() {
        this.bookService = null;
        this.booksView = null;
    }

    // Iniciar el menú de consola
    public void startMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n===== Menú LiterAlura =====");
            System.out.println("1. Listar todos los libros");
            System.out.println("2. Buscar libro por ID");
            System.out.println("3. Consumir API y guardar libros");
            System.out.println("4. Eliminar libro por ID");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    listAllBooks();
                    break;
                case 2:
                    findBookById(scanner);
                    break;
                case 3:
                    fetchAndSaveBooks();
                    break;
                case 4:
                    deleteBookById(scanner);
                    break;
                case 5:
                    System.out.println("Saliendo del sistema. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (option != 5);
    }

    private void listAllBooks() {
        List<Books> books = bookService.getAllBooks();
        booksView.displayBooks(books);
    }

    private void findBookById(Scanner scanner) {
        System.out.print("Ingrese el ID del libro: ");
        int id = scanner.nextInt();
        Books book = bookService.getBookById(id);
        booksView.displayBook(book);
    }

    private void fetchAndSaveBooks() {
        try {
            List<Books> books = bookService.fetchAndSaveBooks();
            booksView.displayFetchResult(books.size());
        } catch (Exception e) {
            booksView.displayError("Error al consumir la API: " + e.getMessage());
        }
    }

    private void deleteBookById(Scanner scanner) {
        System.out.print("Ingrese el ID del libro a eliminar: ");
        int id = scanner.nextInt();
        try {
            bookService.deleteBookById(id);
            System.out.println("Libro eliminado correctamente.");
        } catch (Exception e) {
            booksView.displayError(e.getMessage());
        }
    }

}