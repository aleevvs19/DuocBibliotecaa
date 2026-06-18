package cl.duoc.bibliotecaa.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

public class UpdateLibroRequest {

    @NotBlank(message = "El ISBN es obligatorio")
    @Schema(description = "ISBN actualizado del libro", example = "842340949X")
    private String isbn;

    @NotBlank(message = "El título es obligatorio")
    @Schema(description = "Título actualizado del libro", example = "El Método Lean Startup Actualizado")
    private String titulo;

    @NotBlank(message = "La editorial es obligatoria")
    @Schema(description = "Editorial actualizada del libro", example = "Deusto")
    private String editorial;

    @PositiveOrZero(message = "La fecha de publicación debe ser positiva o cero")
    @Schema(description = "Año de publicación actualizado", example = "2018")
    private Integer fechaPublicacion;

    @NotBlank(message = "El autor es obligatorio")
    @Schema(description = "Autor actualizado del libro", example = "Eric Ries")
    private String autor;

    public UpdateLibroRequest() {
    }

    public UpdateLibroRequest(String isbn, String titulo, String editorial, Integer fechaPublicacion, String autor) {
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