package fr.diginamic.sandbox;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.diginamic.sandbox.services.AnimalService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class SandboxApplication implements CommandLineRunner {

	private static final int ID = 2;

	private final AnimalService animalService;

	public SandboxApplication(final AnimalService animalService) {
		this.animalService = animalService;
	}

	public static void main(final String[] args) {
		SpringApplication.run(SandboxApplication.class, args);
	}

	@Override
	public void run(final String... args) throws Exception {
		log.info("all animals : {}", animalService.findAll());
		log.info("found animal : {]", animalService.findAnimal(1));
		log.info("last two chat: {}", animalService.findLastTwo("Chat"));
		log.info("animals of owner : {}", animalService.findByOwner(ID));
		log.info("animals of colors : {}", animalService.findAnimalsOfColors(Arrays.asList("Blanc", "Noir")));
	}

}
