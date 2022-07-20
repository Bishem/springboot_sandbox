package fr.diginamic.sandbox.services;

import org.springframework.stereotype.Service;

import fr.diginamic.sandbox.repositories.SpecieRepository;
import fr.diginamic.sandbox.utils.models.Specie;

@Service
public class SpecieService {

	private final SpecieRepository repository;

	public SpecieService(final SpecieRepository repository) {
		this.repository = repository;
	}

	public Specie findCommonName(final String commonName) {
		return repository.findFirstByCommonName(commonName).orElseThrow();
	}

}
