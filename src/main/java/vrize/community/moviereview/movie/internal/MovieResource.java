package vrize.community.moviereview.movie.internal;

import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
public class MovieResource {

    public List<Movie> fetchLatestMovies(){
        return Collections.EMPTY_LIST;
    }
}
