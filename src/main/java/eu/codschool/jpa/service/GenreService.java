package eu.codschool.jpa.service;

import java.util.List;

import eu.codschool.jpa.entity.Genre;

public interface GenreService {
    List<Genre> findAll();
    Genre save(Genre genre);
	void delete(Integer id);
	void delete(Genre genre);
}
