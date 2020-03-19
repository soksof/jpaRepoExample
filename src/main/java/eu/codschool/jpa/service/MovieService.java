package eu.codschool.jpa.service;

import java.util.List;

import eu.codschool.jpa.entity.Director;
import eu.codschool.jpa.entity.Genre;
import eu.codschool.jpa.entity.Movie;

public interface MovieService {
    List<Movie> findAllByGenre(Genre genre);
    List<Movie> findAll();
    List<Movie> findByTitleContaining(String searchTerm);
    List<Movie> findByDirector(Director director);
    Movie save(Movie movie);
	void delete(Integer id);
	void delete(Movie movie);
}
