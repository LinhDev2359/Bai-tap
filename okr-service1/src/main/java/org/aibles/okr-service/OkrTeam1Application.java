package org.aibles.okr_team1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class OkrTeam1Application {

	public static void main(String[] args) {
		SpringApplication.run(OkrTeam1Application.class, args);
	}

}
