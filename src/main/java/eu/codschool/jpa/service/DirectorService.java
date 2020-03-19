package eu.codschool.jpa.service;

import java.util.List;

import eu.codschool.jpa.entity.Director;

public interface DirectorService {
    List<Director> findByName(String name);
    List<Director> findAll();
    List<Director> findByNameContaining(String searchTerm);
    Director getDirectorById(int id);
    Director save(Director director);
	void delete(Integer id);
	void delete(Director director);
}
