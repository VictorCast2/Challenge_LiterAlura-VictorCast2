package com.LiterAlura.VictCast.LiterAlura.Repository;

import com.LiterAlura.VictCast.LiterAlura.Models.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Books, Integer> {
}