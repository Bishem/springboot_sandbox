package fr.diginamic.sandbox.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import fr.diginamic.sandbox.repositories.AnimalRepository;
import fr.diginamic.sandbox.repositories.PersonRepository;
import fr.diginamic.sandbox.repositories.SpecieRepository;
import fr.diginamic.sandbox.utils.beans.AnimalBean;
import fr.diginamic.sandbox.utils.models.Animal;

@Service
public class AnimalService {

	@Autowired
	private AnimalRepository repository;

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private SpecieRepository specieRepository;

	public Animal findAnimal(final Integer id) {
		return repository.findById(id).orElseThrow();
	}

	public List<Animal> findAll() {
		return repository.findAll();
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

	public Animal save(@Valid final AnimalBean bean) {

		Assert.isNull(bean.getId(), "id must be null");

		final var animal = Animal.builder().color(bean.getColor()).name(bean.getName()).sex(bean.getSex())
				.specie(specieRepository.findById(bean.getSpecieId()).orElseThrow());

		final var personIds = bean.getPersonIds();

		if (((personIds != null) && !personIds.isEmpty())) {
			animal.persons(
					personIds.stream().map(personId -> personRepository.findById(personId).orElseThrow()).toList());
		}

		return repository.save(animal.build());
	}
}
