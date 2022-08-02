package fr.diginamic.sandbox.controllers.rest;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.sandbox.services.PersonService;
import fr.diginamic.sandbox.utils.beans.PersonBean;
import fr.diginamic.sandbox.utils.models.Person;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/person")
public class PersonController {

	@Autowired
	private PersonService service;

	@GetMapping("/hello")
	public Mono<String> sayHello(@RequestParam(required = false) final String name) {
		return Mono.just(name != null ? "hello " + name : "wait, who are you again ?");
	}

	@PostMapping
	@Transactional
	public Mono<Person> create(@RequestBody @Valid final PersonBean person) {
		return Mono.just(service.save(person));
	}

	@PutMapping
	@Transactional
	public Mono<Person> update(@RequestBody @Valid final PersonBean person) {
		return Mono.just(service.update(person));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable final Integer id) {
		service.remove(id);
	}

}
