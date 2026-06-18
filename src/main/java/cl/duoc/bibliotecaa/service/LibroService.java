package cl.duoc.bibliotecaa.service;

import cl.duoc.bibliotecaa.dto.CreateLibroRequest;
import cl.duoc.bibliotecaa.dto.UpdateLibroRequest;
import cl.duoc.bibliotecaa.exception.ResourceNotFoundException;
import cl.duoc.bibliotecaa.mapper.LibroMapper;
import cl.duoc.bibliotecaa.model.Libro;
import cl.duoc.bibliotecaa.repository.LibroRepositoryy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    private final LibroRepositoryy libroRepositoryy;
    private final LibroMapper libroMapper;

    public LibroService(LibroRepositoryy libroRepositoryy, LibroMapper libroMapper) {
        this.libroRepositoryy = libroRepositoryy;
        this.libroMapper = libroMapper;
    }

    public List<Libro> getLibros() {
        return libroRepositoryy.findAll();
    }

    public Libro getLibroId(Integer id) {
        return libroRepositoryy.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Libro no encontrado con ID: " + id));
    }

    public List<Libro> getLibrosPorAutor(String autor) {
        return libroRepositoryy.findByAutorContainingIgnoreCase(autor);
    }

    public List<Libro> getLibrosPorEditorial(String editorial) {
        return libroRepositoryy.findByEditorialContainingIgnoreCase(editorial);
    }

    public Libro crearLibro(CreateLibroRequest request) {
        Libro libro = libroMapper.toEntity(request);
        return libroRepositoryy.save(libro);
    }

    public Libro actualizarLibro(Integer id, UpdateLibroRequest request) {
        Libro libroExistente = getLibroId(id);
        libroMapper.updateEntity(libroExistente, request);
        return libroRepositoryy.save(libroExistente);
    }

    public void eliminarLibro(Integer id) {
        Libro libroExistente = getLibroId(id);
        libroRepositoryy.delete(libroExistente);
    }
}