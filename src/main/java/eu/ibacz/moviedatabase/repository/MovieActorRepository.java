package eu.ibacz.moviedatabase.repository;

import eu.ibacz.moviedatabase.model.MovieActor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface MovieActorRepository extends ReactiveCrudRepository<MovieActor, Long> {

    Flux<Long> deleteAllByMovieId(Long movieId);
}

