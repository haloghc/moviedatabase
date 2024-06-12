package eu.ibacz.moviedatabase.model;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("movie_genres")
public class MovieGenre {
    @Id
    private Long id;

    @NonNull
    private Long movieId;
    @NonNull
    private Long genreId;
}
