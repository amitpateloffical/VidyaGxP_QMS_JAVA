package com.inn.qms;

import com.inn.qms.SpringSecurityConfiguration.Entities.Role;
import com.inn.qms.SpringSecurityConfiguration.Entities.User;
import com.inn.qms.SpringSecurityConfiguration.Repository.UserRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
@EnableJpaRepositories
@ComponentScan(basePackages = {"com.inn.qms"})
@OpenAPIDefinition(info = @Info(title = "QMS Swagger UI",version = "1.0.0"))
public class QmsRunner implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
       public static void main(String[] args) {
		SpringApplication.run(QmsRunner.class, args);
	}

	public void run(String... args){
		User adminAccount = userRepository.findByRole(Role.ADMIN);
		if(null == adminAccount){
			User user = new User();

			user.setFirstname("admin");
			user.setLastname("admin");
			user.setEmail("admin@gmail.com");
			user.setRole(Role.ADMIN);
			user.setPassword(new BCryptPasswordEncoder().encode("admin"));
			userRepository.save(user);

		}
	}
       
}
