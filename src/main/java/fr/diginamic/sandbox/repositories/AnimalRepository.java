package fr.diginamic.sandbox.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.diginamic.sandbox.utils.models.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

	List<Animal> findByColorIn(List<String> colors);

	List<Animal> findFirst2BySpecie_CommonNameOrderByNameDesc(String commonName);

	List<Animal> findByPersons_Id(Integer ownerId);
}
