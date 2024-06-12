package eu.ibacz.moviedatabase.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("actors")
@NoArgsConstructor
@AllArgsConstructor
public class Actor {
    @Id
    private Long id;
    private String name;
}
