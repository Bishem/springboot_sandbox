package fr.diginamic.sandbox.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import fr.diginamic.sandbox.repositories.SpecieRepository;
import fr.diginamic.sandbox.utils.models.Specie;

@Service
public class SpecieService {

	@Autowired
	private SpecieRepository repository;

	public Specie findSpecie(final Integer id) {
		return repository.findById(id).orElseThrow();
	}

	public List<Specie> findAll() {
		return repository.findAll();
	}

	public Specie findCommonName(final String commonName) {
		return repository.findFirstByCommonName(commonName).orElseThrow();
	}

	public Page<Specie> findPage(final Integer page, final Integer size) {
		return repository.findAll(PageRequest.of(page, size));
	}
}
