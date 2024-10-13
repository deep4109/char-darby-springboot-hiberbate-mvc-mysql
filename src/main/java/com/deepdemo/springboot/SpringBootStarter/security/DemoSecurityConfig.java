package com.deepdemo.springboot.SpringBootStarter.security;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//import org.springframework.security.provisioning.UserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {


    //add support for jdbc ...not  ore Hardcoded
  /*  @Bean
    public UserDetailsManager userDetailsManager(@Qualifier("secondaryDataSource") DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        //password for all user john fun123
        //define query
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_id,pw,active from members where user_id=?"
        );
        //define query to retrive the roles by usename
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id,role from roles where user_id=?"
        );

        return jdbcUserDetailsManager;
    }*/


    /*@Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails john = User.builder()
                .username("john")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();

        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(john, mary, susan);
    }*/

  /*  @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.authorizeHttpRequests(configurer ->
                configurer.requestMatchers(HttpMethod.GET, "/magic-api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/magic-api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/magic-api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/magic-api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/magic-api/employees").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/magic-api/employees/**").hasRole("ADMIN")
        );

        // userr HTTP Basic Authentication
        httpSecurity.httpBasic(Customizer.withDefaults());

        //disable Cross Site Request Forgery
        httpSecurity.csrf(csrf -> csrf.disable());
        return httpSecurity.build();
    }*/

}
