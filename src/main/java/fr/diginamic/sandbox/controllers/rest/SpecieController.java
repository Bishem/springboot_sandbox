package fr.diginamic.sandbox.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.sandbox.services.SpecieService;
import fr.diginamic.sandbox.utils.models.Specie;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/specie")
public class SpecieController {

	@Autowired
	SpecieService service;

	@GetMapping("/hello")
	public Mono<String> sayHello(@RequestParam(required = false) final String name) {
		return Mono.just(name != null ? "hello " + name : "wait, who are you again ?");
	}

	@GetMapping
	public Mono<Page<Specie>> getPage(@RequestParam final Integer page, @RequestParam final Integer size) {
		return Mono.just(service.findPage(page, size));
	}
}
