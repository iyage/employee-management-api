package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
@Configuration
@EnableSwagger2
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public Docket SwaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfo(
				"Employee management Api",
				"<h2 style='margin:2px'> Author: Ofunrein Iyaghe.</h2> " +
						"<article> <h2>Description </h2>" +
						"The Api endpoints help with Basic employee management CRUD  operation<br/>" +
						"uml diagram: https://drive.google.com/file/d/1Jt98ia5ZzlepHYRs1E8O-oCbvnWDd7c6/view?usp=sharing" +
						"<article>.<br/>",
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Ofunrein Iyaghe", "https://github.com/iyage", "yahg.concept@gmail.com"),
				"API License",
				"https://github.com/iyage",
				Collections.emptyList());
	}

}
