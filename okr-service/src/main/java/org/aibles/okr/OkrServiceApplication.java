package org.aibles.okr;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class OkrServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(OkrServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("successfully run the project okr");
	}
}
