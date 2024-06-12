package eu.ibacz.moviedatabase.controller;

import eu.ibacz.moviedatabase.dto.MovieDto;
import eu.ibacz.moviedatabase.model.Movie;
import eu.ibacz.moviedatabase.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @GetMapping
    public Flux<MovieDto> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public Mono<MovieDto> getMovieById(@PathVariable Long id) {
        return movieService.getMovieById(id);
    }

    @PostMapping
    public Mono<MovieDto> createMovie(@RequestBody Movie movie) {
        return movieService.createMovie(movie);
    }

    @PutMapping("/{id}")
    public Mono<MovieDto> updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
        return movieService.updateMovie(id, movie);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteMovie(@PathVariable Long id) {
        return movieService.deleteMovie(id);
    }
}
