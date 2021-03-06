package br.com.natiteste.swagger.configuration;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("br.com.natiteste"))
				.paths(PathSelectors.any()).build().apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfo("Rest API NATI", 
				"Some description about your API", 
				"V1", "terms Of Service Url", 
					new Contact("Ronaldo Almeida", 
							    "https://www.linkedin.com/in/ronaldo-almeida-9a8a8316b/",
							    "ronaldoalm1812@edu.unifor.br"), "License Of API", "License of URL", Collections.emptyList());
	}
}
