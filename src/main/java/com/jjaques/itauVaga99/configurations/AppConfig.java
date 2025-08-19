package com.jjaques.itauVaga99.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;


@Configuration
public class AppConfig {

    @Bean
    public Clock clock(){
        //retorna o relógio padrão do sistema, utilizando clock para travar horas em testes

        return Clock.systemDefaultZone();
    }
}
