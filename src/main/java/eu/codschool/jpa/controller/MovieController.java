package eu.codschool.jpa.controller;

import eu.codschool.jpa.entity.Movie;
import eu.codschool.jpa.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping(value = "/movie/list", method = RequestMethod.GET)
    public String getMovieList(Model model) {
        List<Movie> movies= movieService.findAll();
        model.addAttribute("movies", movies);
        return "fragments/movies";
    }

    @RequestMapping("/movie/view/{id}")
    public String moviePage(@PathVariable int id, Model model) {
        model.addAttribute("movie", movieService.findById(id));
        return "fragments/moviePage";
    }
}
