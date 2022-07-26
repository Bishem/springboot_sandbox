package fr.diginamic.sandbox.controllers.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/specie")
public class SpecieController {

	@GetMapping("/hello")
	public Mono<String> sayHello(@RequestParam(required = false) final String name) {

		final var response = name != null ? "hello " + name : "wait, who are you again ?";

		return Mono.just(response);
	}
}
