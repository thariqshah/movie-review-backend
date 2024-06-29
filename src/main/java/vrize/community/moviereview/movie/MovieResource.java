package vrize.community.moviereview.movie;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import vrize.community.moviereview.movie.httpclient.MovieDBHttpClient;
import vrize.community.moviereview.movie.internal.Movie;
import vrize.community.moviereview.movie.internal.MovieReviewService;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController("/api/v1/movie")
public class MovieResource {

    private final MovieDBHttpClient movieDbClient;

    private final MovieService movieService;

    private final MovieReviewService movieReviewService;

    public MovieResource(MovieDBHttpClient movieDbClient, MovieService movieService, MovieReviewService movieReviewService) {
        this.movieDbClient = movieDbClient;
        this.movieService = movieService;
        this.movieReviewService = movieReviewService;
    }


    @GetMapping("/search")
    public MovieDBMovieList.MovieResult searchMovie(@RequestParam(name = "query") String query) {
        Map<String, String> map = new HashMap<>();
        return movieDbClient.searchMovie(query, map).results().stream().findFirst().orElseThrow();
    }

    //todo feq fields
    @PostMapping("/add")
    public Movie addMovie(@RequestBody MovieDTO movie) {
        return movieService.addMovie(movie);
    }

    //todo sort and filter
    @PostMapping("/list")
    public Page<Movie> fetchList(@RequestParam(defaultValue = "0") int pageNumber, @RequestParam(defaultValue = "10") int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return movieService.getPaginatedMovieList(pageable);
    }

    @PostMapping("/{movie-id}/review/add")
    public void addReview(@PathVariable(value = "movie-id")UUID movieId, @RequestBody String review){
        movieReviewService.saveReview(movieId,review);
    }
}
