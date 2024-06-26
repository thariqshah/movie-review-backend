package vrize.community.moviereview.movie.internal;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue
    @Column(name = "id", columnDefinition = "UUID")
    private UUID id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "movie_db_id", nullable = false)
    private int movieDbId;

    @Column(name = "imdb_id", nullable = false)
    private int imdbId;

    @Column(name = "year")
    private Integer year;

    @Column(name = "description")
    private String description;
}
