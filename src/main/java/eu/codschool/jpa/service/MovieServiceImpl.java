package eu.codschool.jpa.service;

import java.util.List;
import org.springframework.stereotype.Service;

import eu.codschool.jpa.entity.Director;
import eu.codschool.jpa.entity.Genre;
import eu.codschool.jpa.entity.Movie;
import eu.codschool.jpa.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {
	private final MovieRepository movieRepository;

	public MovieServiceImpl(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	@Override
	public List<Movie> findAllByGenre(Genre genre) {
		return movieRepository.findAllByGenre(genre);
	}

	@Override
	public Movie findById(int id) {
		return movieRepository.findById(id).orElse(null);
	}

	@Override
	public List<Movie> findAll() {
		return movieRepository.findAll();
	}
	
	@Override
	public List<Movie> findByTitleContaining(String searchTerm) {
		return movieRepository.findByTitleContaining(searchTerm);
	}

	@Override
	public List<Movie> findByDirector(Director director) {
		return movieRepository.findByDirector(director);
	}

	@Override
	public Movie save(Movie movie) {
		return movieRepository.save(movie);
	}

	@Override
	public void delete(Integer id) {
		movieRepository.deleteById(id);
	}

	@Override
	public void delete(Movie movie) {
		movieRepository.delete(movie);
	}
}