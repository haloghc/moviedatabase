package eu.ibacz.moviedatabase.dto;

import eu.ibacz.moviedatabase.model.Actor;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
public class MovieDto {
    private Long id;
    private String title;
    private String description;
    private LocalDate releaseDate;
    private Set<Actor> actors;
    private Set<Actor> genres;
}
