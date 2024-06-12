package eu.ibacz.moviedatabase.service;

import eu.ibacz.moviedatabase.dto.MovieDto;
import eu.ibacz.moviedatabase.mapper.MovieActorMapper;
import eu.ibacz.moviedatabase.mapper.MovieGenreMapper;
import eu.ibacz.moviedatabase.mapper.MovieMapper;
import eu.ibacz.moviedatabase.model.Movie;
import eu.ibacz.moviedatabase.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;

import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@RequiredArgsConstructor
public class MovieService {

    Logger logger = LoggerFactory.getLogger(MovieService.class);

    private final MovieRepository movieRepository;
    private final ActorRepository actorRepository;
    private final GenreRepository genreRepository;
    private final MovieActorRepository movieActorRepository;
    private final MovieGenreRepository movieGenreRepository;

    private final MovieMapper movieMapper;
    private final MovieActorMapper movieActorMapper;
    private final MovieGenreMapper movieGenreMapper;

    public Flux<MovieDto> getAllMovies() {
        return movieRepository.findAll()
                .flatMap(this::enrichWithActors)
                .flatMap(this::enrichWithGenres)
                .map(movieMapper::toDto);
    }

    public Mono<MovieDto> getMovieById(Long id) {
        return  movieRepository.findById(id)
                .flatMap(this::enrichWithActors)
                .flatMap(this::enrichWithGenres)
                .map(movieMapper::toDto);
    }

    @Transactional
    public Mono<MovieDto> createMovie(Movie movie) {
        return movieRepository.save(movie)
                .flatMap(savedMovie
                        -> movieActorRepository.saveAll(movieActorMapper.toMovieActors(savedMovie.getId(), savedMovie.getActors())) .collectList()
                        .then(Mono.just(savedMovie)))
                .flatMap(savedMovie
                        -> movieGenreRepository.saveAll(movieGenreMapper.toMovieGenres(savedMovie.getId(), savedMovie.getGenres()))
                        .collectList()
                        .then(Mono.just(savedMovie)))
                .map(movieMapper::toDto);
    }

    @Transactional
    public Mono<MovieDto> updateMovie(Long id, Movie movie) {
        logger.info("movie:" + movie);

        // TODO
        movieActorRepository.deleteAllByMovieId(id);

        Mono<MovieDto> result = movieRepository.findById(id)
                .flatMap(existingMovie -> {
                    movie.setId(id);
                    return movieRepository.save(movie);
                })
                .map(movieMapper::toDto);

        return result;
    }

    public Mono<Void> deleteMovie(Long id) {
        return movieRepository.deleteById(id);
    }

    private Mono<Movie> enrichWithActors(final Movie movie) {

       return actorRepository.getActorsForMovie(movie.getId())
                .collectList()
                .map(movie::withActors);

    }

    private Mono<Movie> enrichWithGenres(final Movie movie) {

        return genreRepository.getGenresForMovie(movie.getId())
                .collectList()
                .map(movie::withGenres);
    }
}
