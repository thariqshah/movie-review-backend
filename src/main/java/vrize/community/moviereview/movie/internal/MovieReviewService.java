package vrize.community.moviereview.movie.internal;


import org.springframework.stereotype.Service;
import vrize.community.moviereview.user.Userprofile;

import java.time.ZonedDateTime;
import java.util.UUID;

@Service
public class MovieReviewService {

    private final ReviewRepository reviewRepository;

    public MovieReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public MovieReview saveReview(String review, Movie movie, Userprofile userprofile){
        MovieReview movieReview = new MovieReview();
        movieReview.setMovie(movie);
        movieReview.setReviewer(userprofile);
        movieReview.setReviewText(review);
        movieReview.setRating(0);
        movieReview.setReviewDate(ZonedDateTime.now());
        reviewRepository.save(movieReview);
        return movieReview;
    }

    //todo get claims, load user, find movie, add review
    public void saveReview(UUID movieId, String review) {
    }
}
