package cl.duoc.bibliotecaa.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único del libro", example = "1")
    private Integer id;

    @Column(length = 20, nullable = false)
    @Schema(description = "Código ISBN del libro", example = "9789561234567")
    private String isbn;

    @Column(length = 200, nullable = false)
    @Schema(description = "Título del libro", example = "Clean Code")
    private String titulo;

    @Column(length = 100, nullable = false)
    @Schema(description = "Editorial del libro", example = "Prentice Hall")
    private String editorial;

    @Column(nullable = false)
    @Schema(description = "Año de publicación", example = "2008")
    private Integer fechaPublicacion;

    @Column(length = 150, nullable = false)
    @Schema(description = "Autor del libro", example = "Robert C. Martin")
    private String autor;

    public Libro() {
    }

    public Libro(Integer id, String isbn, String titulo, String editorial, Integer fechaPublicacion, String autor) {
        this.id = id;
        this.isbn = isbn;
        this.titulo = titulo;
        this.editorial = editorial;
        this.fechaPublicacion = fechaPublicacion;
        this.autor = autor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Integer getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Integer fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}