package fr.diginamic.sandbox.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.diginamic.sandbox.utils.models.Animal;
import fr.diginamic.sandbox.utils.models.Person;
import fr.diginamic.sandbox.utils.models.Specie;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

	List<Animal> findFirst2BySpecieOrderByNameDesc(Specie specie);

	List<Animal> findByPersons(Person person);

	List<Animal> findByColorIn(List<String> colors);
}
