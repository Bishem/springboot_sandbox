package fr.diginamic.sandbox.services;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.diginamic.sandbox.repositories.AnimalRepository;
import fr.diginamic.sandbox.utils.models.Animal;

@Service
public class AnimalService {

	private final AnimalRepository repository;
	private final SpecieService specieService;
	private final PersonService personService;

	protected AnimalService(final AnimalRepository animalRepository, final SpecieService specieService,
			final PersonService personService) {
		repository = animalRepository;
		this.specieService = specieService;
		this.personService = personService;
	}

	public List<Animal> findAll() {
		return repository.findAll();
	}

	public Animal findAnimal(final Integer id) {
		return repository.findById(id).orElseThrow();
	}

	public List<Animal> findLastTwo(final String commonName) {
		return repository.findFirst2BySpecieOrderByNameDesc(specieService.findCommonName(commonName));
	}

	public List<Animal> findByOwner(final Integer id) {
		return repository.findByPersons(personService.findPerson(id));
	}

	public List<Animal> findAnimalsOfColors(final List<String> colors) {
		return repository.findByColorIn(colors);
	}
}
