package vrize.community.moviereview.movie.httpclient;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import vrize.community.moviereview.movie.MovieDBMovieList;

import java.util.Map;

public interface MovieDBHttpClient {

    @GetExchange(value = "/3/search/movie",accept = MediaType.APPLICATION_JSON_VALUE)
    MovieDBMovieList searchMovie(@RequestParam String query, @RequestHeader Map<String,String> authorization);
}
