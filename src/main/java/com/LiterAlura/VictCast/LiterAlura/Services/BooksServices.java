package com.LiterAlura.VictCast.LiterAlura.Services;

import com.LiterAlura.VictCast.LiterAlura.Models.Books;
import com.LiterAlura.VictCast.LiterAlura.Repository.BooksRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@Service
public class BooksServices {

    private final WebClient webClient = WebClient.create();

    @Autowired
    private BooksRepository booksRepository;

    // Obtener todos los libros
    public List<Books> getAllBooks() {
        return booksRepository.findAll();
    }

    // Buscar libro por ID
    public Books getBookById(int id) {
        return booksRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado con ID: " + id));
    }

    // Consumir la API y guardar libros
    public List<Books> fetchAndSaveBooks() {
        String url = "https://gutendex.com/books/";
        List<Books> booksList = new ArrayList<>();

        try {
            // Consumir la API
            String response = webClient.get()
                    .uri(url)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            // Parsear el JSON
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode root = objectMapper.readTree(response);
            JsonNode results = root.path("results");

            results.forEach(node -> {
                Books book = new Books();
                book.setTitle(node.path("title").asText());
                book.setAuthor(node.path("authors").get(0).path("name").asText());
                book.setDownloadCount(node.path("download_count").asInt());
                book.setLanguage(node.path("languages").get(0).asText());

                // Guardar en la lista y base de datos
                booksList.add(book);
                booksRepository.save(book);
            });

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al consumir la API");
        }

        return booksList;
    }

    // Eliminar libro por ID
    public void deleteBookById(int id) {
        if (booksRepository.existsById(id)) {
            booksRepository.deleteById(id);
        } else {
            throw new RuntimeException("No se pudo eliminar: Libro no encontrado con ID: " + id);
        }
    }

}