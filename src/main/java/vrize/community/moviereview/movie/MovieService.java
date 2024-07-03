package vrize.community.moviereview.movie;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vrize.community.moviereview.movie.internal.Movie;
import vrize.community.moviereview.movie.internal.MovieRepository;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie addMovie(MovieDTO movie) {
        var movieEntity = new Movie();
        movieEntity.setTitle(movie.title());
        movieEntity.setMovieDbId(movie.movieDBId());
        movieEntity.setImdbId(0);
        movieEntity.setDescription(movie.overview());
        return movieRepository.save(movieEntity);
    }

    public Page<Movie> getPaginatedMovieList(Pageable pageable) {
        return movieRepository.findAll(pageable);
    }
}
