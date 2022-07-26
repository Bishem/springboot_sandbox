package fr.diginamic.sandbox.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.sandbox.repositories.AnimalRepository;
import fr.diginamic.sandbox.utils.models.Animal;

@Service
public class AnimalService {

	@Autowired
	private AnimalRepository repository;

	public List<Animal> getAll() {
		return repository.findAll();
	}

	public Animal findAnimal(final Integer id) {
		return repository.findById(id).orElseThrow();
	}

	public List<Animal> findLastTwo(final String commonName) {
		return repository.findFirst2BySpecie_CommonNameOrderByNameDesc(commonName);
	}

	public List<Animal> findByOwner(final Integer ownerId) {
		return repository.findByPersons_Id(ownerId);
	}

	public List<Animal> findAnimalsOfColors(final List<String> colors) {
		return repository.findByColorIn(colors);
	}

	public Animal persist(@Valid final Animal animal) {
		return repository.save(animal);
	}
}
