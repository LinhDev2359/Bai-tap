package org.aibles.animal;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class AnimalApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AnimalApplication.class, args);
	}
	
	@Override
	public void run(String... args)  {
		log.info("Run winner");
	}
}
