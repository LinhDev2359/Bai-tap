package orrg.aibles.user;

import antlr.BaseAST;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;
import orrg.aibles.user.entity.User;
import orrg.aibles.user.repository.UserRepository;

@SpringBootApplication
public class UserApplication  {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}



}
