package fr.diginamic.sandbox.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.diginamic.sandbox.utils.models.Specie;

@Repository
public interface SpecieRepository extends JpaRepository<Specie, Integer> {

	Optional<Specie> findFirstByCommonName(String commonName);
}
