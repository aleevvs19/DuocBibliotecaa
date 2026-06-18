package cl.duoc.bibliotecaa.controller;

import cl.duoc.bibliotecaa.dto.CreateLibroRequest;
import cl.duoc.bibliotecaa.dto.PokemonResponse;
import cl.duoc.bibliotecaa.dto.UpdateLibroRequest;
import cl.duoc.bibliotecaa.model.Libro;
import cl.duoc.bibliotecaa.service.LibroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
@RequestMapping("/libros")
@Tag(name = "Libros", description = "Endpoints para gestionar libros")
public class LibroController {

    private final LibroService libroService;
    private final WebClient pokeApiWebClient;

    public LibroController(LibroService libroService, WebClient pokeApiWebClient) {
        this.libroService = libroService;
        this.pokeApiWebClient = pokeApiWebClient;
    }

    @GetMapping
    @Operation(summary = "Listar todos los libros")
    public ResponseEntity<List<Libro>> listarLibros() {
        return ResponseEntity.ok(libroService.getLibros());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar un libro por ID")
    public ResponseEntity<Libro> buscarLibroPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(libroService.getLibroId(id));
    }

    @GetMapping("/autor")
    @Operation(summary = "Buscar libros por autor")
    public ResponseEntity<List<Libro>> buscarLibrosPorAutor(@RequestParam String autor) {
        return ResponseEntity.ok(libroService.getLibrosPorAutor(autor));
    }

    @GetMapping("/editorial")
    @Operation(summary = "Buscar libros por editorial")
    public ResponseEntity<List<Libro>> buscarLibrosPorEditorial(@RequestParam String editorial) {
        return ResponseEntity.ok(libroService.getLibrosPorEditorial(editorial));
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo libro")
    public ResponseEntity<Libro> crearLibro(@Valid @RequestBody CreateLibroRequest request) {
        Libro libroCreado = libroService.crearLibro(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(libroCreado);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un libro existente")
    public ResponseEntity<Libro> actualizarLibro(
            @PathVariable Integer id,
            @Valid @RequestBody UpdateLibroRequest request) {

        Libro libroActualizado = libroService.actualizarLibro(id, request);
        return ResponseEntity.ok(libroActualizado);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un libro por ID")
    public ResponseEntity<Void> eliminarLibro(@PathVariable Integer id) {
        libroService.eliminarLibro(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/pokemon/{nombre}")
    @Operation(summary = "Endpoint demo que consume PokeAPI usando WebClient")
    public ResponseEntity<PokemonResponse> buscarPokemon(@PathVariable String nombre) {
        PokemonResponse pokemon = pokeApiWebClient
                .get()
                .uri("/pokemon-species/{nombre}", nombre)
                .retrieve()
                .bodyToMono(PokemonResponse.class)
                .block();

        return ResponseEntity.ok(pokemon);
    }
}