package vrize.community.moviereview.movie;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public record MovieDBMovieList(List<MovieResult> results) {
    @JsonIgnoreProperties(ignoreUnknown = true)
    record MovieResult(String title, String id, String overview, String release_date){};

}
