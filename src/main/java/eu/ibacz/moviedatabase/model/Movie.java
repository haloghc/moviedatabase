package eu.ibacz.moviedatabase.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.List;

@Data
@Table("movies")
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    @Id
    private Long id;
    private String title;
    private String description;
    private LocalDate releaseDate;

    @Transient
    private List<Actor> actors;

    @Transient
    private List<Genre> genres;

    public Movie withActors(List<Actor> actors) {
        this.actors = actors;
        return this;
    }

    public Movie withGenres(List<Genre> genres) {
        this.genres = genres;
        return this;
    }
}
