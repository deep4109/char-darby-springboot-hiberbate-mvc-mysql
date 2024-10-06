package com.deepdemo.springboot.SpringBootStarter.ioc.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component // make to bean which available for DI
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)  // bean scope note: SCOPE_PROTOTYPE does not call "PreDestroy" lifecycle methods
@Primary
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("In constructor :" + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkOut() {
        return "Practice 15 minutues daily";
    }

    @PostConstruct
    public void Init(){
        System.out.println("onAfterConstruct :" + getClass().getSimpleName());
    }

    @PreDestroy
    public void onPreDestroy(){
        System.out.println("PreDestroy( :" + getClass().getSimpleName());
    }
}
