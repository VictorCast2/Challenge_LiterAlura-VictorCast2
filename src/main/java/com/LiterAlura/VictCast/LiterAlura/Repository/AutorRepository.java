package com.LiterAlura.VictCast.LiterAlura.Repository;

import com.LiterAlura.VictCast.LiterAlura.Models.Autor;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    @Query("SELECT a FROM Autor a WHERE a.nombre LIKE %:nombre%")
    List<Autor> findByNombreContainingIgnoreCase(String nombre);

    @Query("SELECT a.nombre FROM Autor a WHERE a.anioNacimiento <= :anio AND (a.anioMuerte IS NULL OR a.anioMuerte >= :anio)")
    List<String> findAutoresVivosEnAnio(int anio);
}