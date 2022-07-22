package fr.diginamic.sandbox.services;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.diginamic.sandbox.repositories.PersonRepository;
import fr.diginamic.sandbox.utils.models.Person;

@Service
public class PersonService {

	private final PersonRepository repository;

	public PersonService(final PersonRepository repository) {
		this.repository = repository;
	}

	public Person findPerson(final Integer id) {
		return repository.findById(id).orElseThrow();
	}

	public List<Person> findAllOwners(final Integer animalId) {
		return repository.findByAnimals_Id(animalId);
	}
}
