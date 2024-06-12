package eu.ibacz.moviedatabase.repository;

import eu.ibacz.moviedatabase.model.Actor;
import eu.ibacz.moviedatabase.model.Genre;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface GenreRepository extends ReactiveCrudRepository<Genre, Long> {

    @Query("select g.* from genres g join movie_genres mg on g.id = mg.genre_id where mg.movie_id = :movieId order by g.name")
    Flux<Genre> getGenresForMovie(Long movieId);
}
