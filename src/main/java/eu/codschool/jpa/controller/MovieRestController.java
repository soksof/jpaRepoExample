package eu.codschool.jpa.controller;

import eu.codschool.jpa.entity.Movie;
import eu.codschool.jpa.service.MovieService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieRestController {
    private final MovieService movieService;

    public MovieRestController(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping(value="/rest/movie/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Movie> getMovieList() {
        List<Movie> allmovies= movieService.findAll();
        return allmovies;
    }
}
