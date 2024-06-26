package vrize.community.moviereview.movie.internal;

import jakarta.persistence.*;
import lombok.Data;
import vrize.community.moviereview.movie.internal.Movie;
import vrize.community.moviereview.user.UserInfo;

import java.time.ZonedDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "movie_reviews")
public class MovieReview {

    @Id
    @GeneratedValue
    @Column(name = "id", columnDefinition = "UUID")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "reviewer_id", nullable = false)
    private UserInfo reviewer;

    @Column(name = "review_text")
    private String reviewText;

    @Column(name = "rating", nullable = false)
    private int rating;

    @Column(name = "review_date", columnDefinition = "TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP")
    private ZonedDateTime reviewDate;

}


