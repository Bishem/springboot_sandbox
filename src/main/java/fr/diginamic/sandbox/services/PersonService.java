package fr.diginamic.sandbox.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.sandbox.repositories.PersonRepository;
import fr.diginamic.sandbox.utils.exceptions.ArgumentNullException;
import fr.diginamic.sandbox.utils.models.Person;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;

	public Person findPerson(final Integer id) {
		return repository.findById(id).orElseThrow();
	}

	public List<Person> findAllOwners(final Integer animalId) {
		return repository.findByAnimals_Id(animalId);
	}

	public Person save(@Valid final Person person) {
		return repository.save(person);
	}

	public Person update(@Valid final Person person) throws ArgumentNullException {
		if (person.getId() == null) {
			throw new ArgumentNullException(new StringBuilder().append("Argument id of ").append(Person.class)
					.append(" is required").toString());
		}
		return repository.save(person);
	}
}
