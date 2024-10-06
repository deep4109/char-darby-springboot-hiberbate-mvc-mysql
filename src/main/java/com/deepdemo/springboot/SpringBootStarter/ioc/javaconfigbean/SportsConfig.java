package com.deepdemo.springboot.SpringBootStarter.ioc.javaconfigbean;

import com.deepdemo.springboot.SpringBootStarter.ioc.common.Coach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportsConfig {

    @Bean
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
