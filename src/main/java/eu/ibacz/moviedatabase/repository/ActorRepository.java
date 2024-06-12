package eu.ibacz.moviedatabase.repository;

import eu.ibacz.moviedatabase.model.Actor;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ActorRepository extends ReactiveCrudRepository<Actor, Long> {

    @Query("select a.* from actors a join movie_actors ma on a.id = ma.actor_id where ma.movie_id = :movieId order by a.name")
    Flux<Actor> getActorsForMovie(Long movieId);
}
