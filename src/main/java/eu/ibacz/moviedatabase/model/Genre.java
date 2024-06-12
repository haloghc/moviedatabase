package eu.ibacz.moviedatabase.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("genres")
public class Genre {
    @Id
    private Long id;
    private String name;
}
