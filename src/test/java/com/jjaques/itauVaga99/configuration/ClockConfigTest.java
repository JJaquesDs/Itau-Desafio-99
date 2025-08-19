package com.jjaques.itauVaga99.configuration;

import com.jjaques.itauVaga99.configurations.AppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Clock;

@SpringBootTest(classes = AppConfig.class)
public class ClockConfigTest {



    @Autowired
    private Clock clock;


    @Test
    void deveUsarClockBeanSpring(){
        System.out.println(clock.getClass());
    }
}
