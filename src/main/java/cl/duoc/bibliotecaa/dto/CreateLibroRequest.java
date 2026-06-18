package cl.duoc.bibliotecaa.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

public class CreateLibroRequest {

    @NotBlank(message = "El ISBN es obligatorio")
    @Schema(description = "ISBN del libro", example = "9789561234567", requiredMode = Schema.RequiredMode.REQUIRED)
    private String isbn;

    @NotBlank(message = "El título es obligatorio")
    @Schema(description = "Título del libro", example = "Clean Code", requiredMode = Schema.RequiredMode.REQUIRED)
    private String titulo;

    @NotBlank(message = "La editorial es obligatoria")
    @Schema(description = "Editorial del libro", example = "Prentice Hall", requiredMode = Schema.RequiredMode.REQUIRED)
    private String editorial;

    @PositiveOrZero(message = "La fecha de publicación debe ser positiva o cero")
    @Schema(description = "Año de publicación", example = "2008", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer fechaPublicacion;

    @NotBlank(message = "El autor es obligatorio")
    @Schema(description = "Autor del libro", example = "Robert C. Martin", requiredMode = Schema.RequiredMode.REQUIRED)
    private String autor;

    public CreateLibroRequest() {
    }

    public CreateLibroRequest(String isbn, String titulo, String editorial, Integer fechaPublicacion, String autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.editorial = editorial;
        this.fechaPublicacion = fechaPublicacion;
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public Integer getFechaPublicacion() {
        return fechaPublicacion;
    }

    public String getAutor() {
        return autor;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setFechaPublicacion(Integer fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}