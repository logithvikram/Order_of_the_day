package com.example.spring_curd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringCurdApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringCurdApplication.class, args);
	}

}
