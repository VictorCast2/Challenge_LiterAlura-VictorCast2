package com.LiterAlura.VictCast.LiterAlura.Models;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "Books")
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "download_count", nullable = false)
    private int downloadCount;

    @Column(name = "language", nullable = false)
    private String language;

    public Books() {
    }

    public Books(String author, int downloadCount, int id, String language, String title) {
        this.author = author;
        this.downloadCount = downloadCount;
        this.id = id;
        this.language = language;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(int downloadCount) {
        this.downloadCount = downloadCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}