package org.iesch.ad.Ev2_Ej3.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "libros")
public class Libro {
    @Id
    private String id;
    private String isbn;
    private String autor;
    private String titulo;

    public Libro(String id, String isbn, String autor, String titulo) {
        this.id = id;
        this.isbn = isbn;
        this.autor = autor;
        this.titulo = titulo;
    }

    public Libro() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id='" + id + '\'' +
                ", isbn='" + isbn + '\'' +
                ", autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}
