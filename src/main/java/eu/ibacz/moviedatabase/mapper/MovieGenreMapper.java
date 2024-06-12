package eu.ibacz.moviedatabase.mapper;

import eu.ibacz.moviedatabase.model.Genre;
import eu.ibacz.moviedatabase.model.MovieGenre;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

@Mapper( componentModel = "spring")
public interface MovieGenreMapper {

    default Collection<MovieGenre> toMovieGenres(Long id, Collection<Genre> genres) {
        if(genres == null) {
            return new LinkedHashSet<>();
        }

        return genres.stream()
                .map(genre -> new MovieGenre(id, genre.getId()))
                .collect(Collectors.toSet());
    }
}

