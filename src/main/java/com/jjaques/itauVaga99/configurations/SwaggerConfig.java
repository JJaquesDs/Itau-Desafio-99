package com.jjaques.itauVaga99.configurations;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    /** Classe de Configuração do Swagger **/

    @Bean
    public OpenAPI customOpenAPI(){//para customizar o swagger
        return new OpenAPI().info(new Info()
                .title("Desafio Itau Vaga 99")
                .version("1.0.0")
                .description("Documentação da API desafio Itau vaga 99")
        );
    }
}
