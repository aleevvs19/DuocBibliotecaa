package cl.duoc.bibliotecaa.repository;

import cl.duoc.bibliotecaa.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LibroRepositoryy extends JpaRepository<Libro, Integer> {

    List<Libro> findByAutorContainingIgnoreCase(String autor);

    List<Libro> findByEditorialContainingIgnoreCase(String editorial);

    Optional<Libro> findByIsbn(String isbn);
}