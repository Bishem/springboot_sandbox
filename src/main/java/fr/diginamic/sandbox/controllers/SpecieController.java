package fr.diginamic.sandbox.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.sandbox.services.SpecieService;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/specie")
public class SpecieController {

	private final SpecieService service;

	public SpecieController(final SpecieService service) {
		this.service = service;
	}

	@GetMapping("/hello")
	public Mono<String> sayHello(@RequestParam(value = "name", required = false) final String name) {

		final var response = name != null ? "hello " + name : "wait, who are you again ?";

		return Mono.just(response);
	}
}
