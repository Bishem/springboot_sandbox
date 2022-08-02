package fr.diginamic.sandbox.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import fr.diginamic.sandbox.repositories.AnimalRepository;
import fr.diginamic.sandbox.repositories.PersonRepository;
import fr.diginamic.sandbox.utils.beans.PersonBean;
import fr.diginamic.sandbox.utils.models.Person;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;

	@Autowired
	private AnimalRepository animalRepository;

	public Person findPerson(final Integer id) {
		return repository.findById(id).orElseThrow();
	}

	public List<Person> findAllOwners(final Integer animalId) {
		return repository.findByAnimals_Id(animalId);
	}

	public Person save(@Valid final PersonBean bean) {
		Assert.isNull(bean.getId(), "id must be null");
		return repository.save(convertToModel(bean));
	}

	public Person update(@Valid final PersonBean bean) {
		Assert.notNull(bean.getId(), "id must not be null");
		return repository.save(updateModel(repository.findById(bean.getId()).orElseThrow(), bean));
	}

	public void remove(final Integer id) {
		repository.deleteById(id);
	}

	// FIXME: not scalable, find a way to streamline the process, model mapper ?
	private Person convertToModel(@Valid final PersonBean bean) {

		final var person = Person.builder();

		if (bean.getAge() != null) person.age(bean.getAge());
		if (bean.getFirstname() != null) person.firstname(bean.getFirstname());
		if (bean.getLastname() != null) person.lastname(bean.getLastname());

		final var animalIds = bean.getAnimalIds();

		if (animalIds != null && !animalIds.isEmpty()) {
			person.animals(animalIds.stream()
					.map(animalId -> animalRepository.findById(animalId).orElseThrow())
					.toList());
		}

		return person.build();
	}

	// FIXME: memory hog needs optimizing ASAP
	private Person updateModel(@Valid final Person person, @Valid final PersonBean bean) {

		if (bean.getAge() != null) person.setAge(bean.getAge());
		if (bean.getFirstname() != null) person.setFirstname(bean.getFirstname());
		if (bean.getLastname() != null) person.setLastname(bean.getLastname());

		final var animalIds = bean.getAnimalIds();

		if (animalIds != null && !animalIds.isEmpty()) {

			final var newLinks = animalIds.stream()
					.map(animalId -> animalRepository.findById(animalId).orElseThrow())
					.toList();

			Assert.isTrue(!person.getAnimals().containsAll(newLinks), "duplicates exists in links to add");

			person.getAnimals().addAll(newLinks);
		}

		return person;
	}
}
