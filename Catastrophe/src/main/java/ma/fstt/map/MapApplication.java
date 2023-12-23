package ma.fstt.map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "ma.fstt.map.model")
@EnableJpaRepositories(basePackages = "ma.fstt.map.repo")
@ComponentScan(basePackages = "ma.fstt.map.service")
@ComponentScan(basePackages = "ma.fstt.map.serviceimp")
@ComponentScan(basePackages = "ma.fstt.map.controller")
public class MapApplication {

	public static void main(String[] args) {
		SpringApplication.run(MapApplication.class, args);
	}

}
