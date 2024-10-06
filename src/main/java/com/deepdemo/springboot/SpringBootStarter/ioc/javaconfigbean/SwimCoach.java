package com.deepdemo.springboot.SpringBootStarter.ioc.javaconfigbean;

import com.deepdemo.springboot.SpringBootStarter.ioc.common.Coach;
import org.springframework.context.annotation.Primary;

//not using @Component
public class SwimCoach implements Coach {

    public SwimCoach() {
        System.out.println("In constructor :" + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkOut() {
        return "Practice daily swim";
    }
}
