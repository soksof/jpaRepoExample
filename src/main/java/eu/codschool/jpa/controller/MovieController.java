package eu.codschool.jpa.controller;

import eu.codschool.jpa.entity.Movie;
import eu.codschool.jpa.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String getDirectorList(Model model) {
        List<Movie> movies= movieService.findAll();
        model.addAttribute("movies", movies);
        return "fragments/movies";
    }
}
