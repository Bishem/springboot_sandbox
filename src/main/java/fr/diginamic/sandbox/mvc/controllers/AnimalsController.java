package fr.diginamic.sandbox.mvc.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.diginamic.sandbox.services.AnimalService;
import fr.diginamic.sandbox.services.SpecieService;
import fr.diginamic.sandbox.utils.models.Animal;
import fr.diginamic.sandbox.utils.models.Specie;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/animals")
public class AnimalsController {

	private static final String ANIMALS = "animals";
	private final AnimalService animalService;
	private final SpecieService specieService;

	public AnimalsController(final AnimalService animalService, final SpecieService specieService) {
		this.animalService = animalService;
		this.specieService = specieService;
	}

	@GetMapping
	public Mono<String> getAll(final Model model) {
		model.addAttribute("animalList", animalService.getAll());
		model.addAttribute("specieList", specieService.getAll());
		final var newAnimal = new Animal();
		newAnimal.setSpecie(new Specie());
		model.addAttribute("animal", newAnimal);
		return Mono.just(AnimalsController.ANIMALS);
	}

	@Transactional
	@PostMapping
	public Mono<String> add(@Valid @ModelAttribute final Animal animal, final Errors errors, final Model model) {

		model.addAttribute("animalList", animalService.getAll());
		model.addAttribute("specieList", specieService.getAll());

		if (errors.hasErrors()) {
			return Mono.just(AnimalsController.ANIMALS);
		}

		animalService.persist(animal);
		return Mono.just(AnimalsController.ANIMALS);
	}

	@Transactional
	@GetMapping("/update/{id}")
	public Mono<String> update(@PathVariable final Integer id, final Model model) {
		model.addAttribute("animal", animalService.findAnimal(id));
		return Mono.just("updateAnimal");
	}
}
