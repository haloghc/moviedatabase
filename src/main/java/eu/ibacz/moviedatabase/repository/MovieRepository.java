package eu.ibacz.moviedatabase.repository;

import eu.ibacz.moviedatabase.model.Movie;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends ReactiveCrudRepository<Movie, Long> {
}

