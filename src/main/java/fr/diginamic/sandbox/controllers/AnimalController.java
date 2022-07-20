package fr.diginamic.sandbox.controllers;

import java.util.ArrayList;
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
@RequestMapping("/animal")
public class AnimalController {

	@Autowired
	private AnimalService service;

	@GetMapping("/hello")
	public Mono<String> sayHello(@RequestParam(value = "name", required = false) final String name) {
		return Mono.just(name != null ? "hello " + name : "wait, who are you again ?");
	}

	@GetMapping("")
	public Mono<List<Animal>> getAll() {
		return Mono.just(service.findAll());
	}

	@GetMapping("/{id}")
	public Mono<Animal> getAnimal(@PathVariable final Integer id) {
		return Mono.just(service.findAnimal(id));
	}

	@GetMapping("/lastTwo")
	public Mono<List<Animal>> getLastTwo(@RequestParam final String commonName) {
		return Mono.just(service.findLastTwo(commonName));
	}

	@GetMapping("/ownedBy")
	public Mono<List<Animal>> getByOwner(@RequestParam final Integer id) {
		return Mono.just(service.findByOwner(id));
	}

	@GetMapping("/colors")
	public Mono<List<Animal>> getAnimalsOfColors(@RequestBody final ArrayList<String> colors) {
		return Mono.just(service.findAnimalsOfColors(colors));
	}
}
