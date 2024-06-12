package eu.ibacz.moviedatabase.mapper;

import eu.ibacz.moviedatabase.dto.MovieDto;
import eu.ibacz.moviedatabase.model.Movie;
import org.mapstruct.Mapper;
import reactor.core.publisher.Mono;


@Mapper( componentModel = "spring")
public interface MovieMapper {
    MovieDto toDto(Movie movie);
    Movie toEntity(MovieDto movieDto);
}

