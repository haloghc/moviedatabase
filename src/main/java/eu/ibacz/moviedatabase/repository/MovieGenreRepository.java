package eu.ibacz.moviedatabase.repository;

import eu.ibacz.moviedatabase.model.MovieGenre;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieGenreRepository extends ReactiveCrudRepository<MovieGenre, Long> {
}

