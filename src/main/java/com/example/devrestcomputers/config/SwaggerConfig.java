package com.example.devrestcomputers.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

/**
 * Configuracion Swagger para la generacion de documentacion de la API REST
 * https://localhost:8080/swagger-ui/
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetails())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiDetails() {

        return new ApiInfo("Spring Boot Laptop API REST",
                "Laptops API REST docs",
                "1.0",
                "none",
                new Contact("devlcsn", "http://github.com/lc1191", "any"),
                "License MIT",
                "any",
                Collections.emptyList());
    }
}
