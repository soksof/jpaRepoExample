package eu.codschool.jpa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import eu.codschool.jpa.entity.Genre;
import eu.codschool.jpa.repository.GenreRepository;

@Service
public class GenreServiceImpl implements GenreService {
	private final GenreRepository genreRepository;

	public GenreServiceImpl(GenreRepository genreRepository) {
		this.genreRepository = genreRepository;
	}

	@Override
	public List<Genre> findAll() {
		return genreRepository.findAll();
	}

	@Override
	public Genre save(Genre genre) {
		return genreRepository.save(genre);
	}

	@Override
	public void delete(Integer id) {
		genreRepository.deleteById(id);
	}

	@Override
	public void delete(Genre genre) {
		genreRepository.delete(genre);
	}
}