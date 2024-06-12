package eu.ibacz.moviedatabase.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("movie_actors")
public class MovieActor {
    @Id
    private Long id;

    @NonNull
    private Long movieId;
    @NonNull
    private Long actorId;
}
