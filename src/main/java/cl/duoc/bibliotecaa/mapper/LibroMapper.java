package cl.duoc.bibliotecaa.mapper;

import cl.duoc.bibliotecaa.dto.CreateLibroRequest;
import cl.duoc.bibliotecaa.dto.UpdateLibroRequest;
import cl.duoc.bibliotecaa.model.Libro;
import org.springframework.stereotype.Component;

@Component
public class LibroMapper {

    public Libro toEntity(CreateLibroRequest request) {
        Libro libro = new Libro();
        libro.setIsbn(request.getIsbn());
        libro.setTitulo(request.getTitulo());
        libro.setEditorial(request.getEditorial());
        libro.setFechaPublicacion(request.getFechaPublicacion());
        libro.setAutor(request.getAutor());
        return libro;
    }

    public void updateEntity(Libro libro, UpdateLibroRequest request) {
        libro.setIsbn(request.getIsbn());
        libro.setTitulo(request.getTitulo());
        libro.setEditorial(request.getEditorial());
        libro.setFechaPublicacion(request.getFechaPublicacion());
        libro.setAutor(request.getAutor());
    }
}
