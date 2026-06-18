package cl.duoc.bibliotecaa.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Biblioteca Duoc")
                        .version("1.0")
                        .description("API REST para gestionar libros de una biblioteca")
                        .contact(new Contact()
                                .name("Alejandro Salazar")
                                .email("os6578983@gmail.com")));
    }
}