package eu.codschool.jpa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import eu.codschool.jpa.entity.Director;
import eu.codschool.jpa.repository.DirectorRepository;

@Service
public class DirectorServiceImpl implements DirectorService {
	private final DirectorRepository directorRepository;

	public DirectorServiceImpl(DirectorRepository directorRepository) {
		this.directorRepository = directorRepository;
	}

	@Override
	public List<Director> findByName(String name) {
		return directorRepository.findByName(name);
	}

	@Override
	public Director getDirectorById(int id) {
		return directorRepository.getOne(id);
	}

	@Override
    public List<Director> findAll() {
    	return directorRepository.findAll();
    }

	@Override
	public Director save(Director director) {
		return directorRepository.save(director);
	}

	@Override
	public void delete(Integer id) {
		directorRepository.deleteById(id);
	}

	@Override
	public void delete(Director director) {
		directorRepository.delete(director);
	}
	@Override
	public List<Director> findByNameContaining(String searchTerm) {
		return directorRepository.findByNameContaining(searchTerm);
	}
}