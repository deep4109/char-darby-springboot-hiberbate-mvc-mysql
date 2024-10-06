package com.deepdemo.springboot.SpringBootStarter.ioc.controller;


import com.deepdemo.springboot.SpringBootStarter.ioc.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SportController {

    /*field injection*/
    /*@Autowired*/
    private Coach mCoach;

    /*construction injection*/
    @Autowired
    public SportController(@Qualifier("swimCoach") Coach coach) {
        mCoach = coach;
    }

    /*setter injection*/
   /* @Autowired
    public void setCoach(Coach coach) {
        mCoach = coach;
    }*/

    @GetMapping("/dailyworkout")
    public String getDailyWorkOut() {
        return mCoach.getDailyWorkOut();
    }
}
