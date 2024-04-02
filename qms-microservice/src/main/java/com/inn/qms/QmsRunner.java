package com.inn.qms;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories
@ComponentScan(basePackages = {"com.inn.qms"})
@OpenAPIDefinition(info = @Info(title = "QMS Swagger UI",version = "1.0.0"))
public class QmsRunner {
       public static void main(String[] args) {
		SpringApplication.run(QmsRunner.class, args);
	}
}
