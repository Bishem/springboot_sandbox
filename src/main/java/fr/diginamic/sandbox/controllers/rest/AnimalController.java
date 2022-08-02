package fr.diginamic.sandbox.controllers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.sandbox.services.AnimalService;
import fr.diginamic.sandbox.utils.models.Animal;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/animal")
public class AnimalController {

	@Autowired
	private AnimalService service;

	@GetMapping("/hello")
	public Mono<String> sayHello(@RequestParam(required = false) final String name) {
		return Mono.just(name != null ? "hello " + name : "wait, who are you again ?");
	}

	@GetMapping("/{id}")
	public Mono<Animal> get(@PathVariable final Integer id) {
		return Mono.just(service.findAnimal(id));
	}

	@GetMapping
	public Mono<List<Animal>> getAll() {
		return Mono.just(service.findAll());
	}

	@GetMapping("/lastTwo")
	public Mono<List<Animal>> getLastTwo(@RequestParam final String commonName) {
		return Mono.just(service.findLastTwo(commonName));
	}

	@GetMapping("/ownedBy")
	public Mono<List<Animal>> getOwnedBy(@RequestParam final Integer id) {
		return Mono.just(service.findByOwner(id));
	}

	// must check how to sent a generic list of resources in a post request body
	@GetMapping("/colors")
	public Mono<List<Animal>> getAllOfColors(@RequestBody final List<String> colors) {
		return Mono.just(service.findAnimalsOfColors(colors));
	}
}
