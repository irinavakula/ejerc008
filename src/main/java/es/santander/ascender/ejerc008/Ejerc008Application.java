package es.santander.ascender.ejerc008;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories
public class Ejerc008Application {

	public static void main(String[] args) {
		SpringApplication.run(Ejerc008Application.class, args);
	}

}
