package fr.diginamic.sandbox.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.sandbox.repositories.SpecieRepository;
import fr.diginamic.sandbox.utils.models.Specie;

@Service
public class SpecieService {

	@Autowired
	private SpecieRepository repository;

	public Specie findCommonName(final String commonName) {
		return repository.findFirstByCommonName(commonName).orElseThrow();
	}

	public List<Specie> getAll() {
		return repository.findAll();
	}

	public Specie findSpecie(final Integer id) {
		return repository.findById(id).orElseThrow();
	}
}
