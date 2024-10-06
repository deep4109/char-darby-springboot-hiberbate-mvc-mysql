package com.deepdemo.springboot.SpringBootStarter.ioc.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component// convert to bean which available for DI
/*@Lazy*/ //can be set from application.properties file
public class TennisCoach implements Coach {

    public TennisCoach() {
        System.out.println("In constructor :" + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkOut() {
        return "Practice tennis daily";
    }
}
