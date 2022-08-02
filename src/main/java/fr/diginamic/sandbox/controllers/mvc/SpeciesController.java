package fr.diginamic.sandbox.controllers.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.diginamic.sandbox.services.SpecieService;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/species")
public class SpeciesController {

	private final SpecieService specieService;

	public SpeciesController(final SpecieService specieService) {
		this.specieService = specieService;
	}

	@GetMapping
	public Mono<String> getMethodName(final Model model) {
		model.addAttribute("species", specieService.findAll());
		return Mono.just("species");
	}
}
