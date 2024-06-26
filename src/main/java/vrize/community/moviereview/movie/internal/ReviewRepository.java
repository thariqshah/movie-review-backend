package vrize.community.moviereview.movie.internal;

import org.springframework.data.jpa.repository.JpaRepository;
import vrize.community.moviereview.movie.internal.MovieReview;

import java.util.UUID;

public interface ReviewRepository extends JpaRepository<MovieReview, UUID> {
}
