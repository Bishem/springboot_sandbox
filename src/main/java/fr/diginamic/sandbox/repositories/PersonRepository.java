package fr.diginamic.sandbox.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.diginamic.sandbox.utils.models.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

}
