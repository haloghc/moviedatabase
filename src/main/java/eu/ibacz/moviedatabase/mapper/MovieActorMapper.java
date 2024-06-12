package eu.ibacz.moviedatabase.mapper;

import eu.ibacz.moviedatabase.model.Actor;
import eu.ibacz.moviedatabase.model.MovieActor;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

@Mapper( componentModel = "spring")
public interface MovieActorMapper {

    default Collection<MovieActor> toMovieActors(Long id, Collection<Actor> actors) {
        if(actors == null) {
            return new LinkedHashSet<>();
        }

        return actors.stream()
                .map(actor -> new MovieActor(id, actor.getId()))
                .collect(Collectors.toSet());
    }
}

