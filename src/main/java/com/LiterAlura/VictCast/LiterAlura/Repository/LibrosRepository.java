package com.LiterAlura.VictCast.LiterAlura.Repository;

import com.LiterAlura.VictCast.LiterAlura.Models.Libro;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface LibrosRepository extends JpaRepository<Libro, Long> {
    Optional<Libro> findByTituloContainsIgnoreCase(String titulo);

    List<Libro> findTop5ByOrderByNumeroDescargasDesc();

    @Query("SELECT l FROM Libro l JOIN l.autores a WHERE a.nombre LIKE %:nombreAutor%")
    List<Libro> findLibrosByAutorNombre(String nombreAutor);

    @Query("SELECT l FROM Libro l JOIN l.idiomas i WHERE i = :idioma")
    List<Libro> findLibrosByIdioma(String idioma);
}