package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication(exclude = { org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration.class })
public class DemoCrudApplication {

	public static void main(String[] args) {

        ConfigurableApplicationContext ctx= SpringApplication.run(DemoCrudApplication.class, args);
        RegisterUser  userreg = ctx.getBean(RegisterUser.class);
        userreg.registerUser("mike");
        userreg.getUserDetails("mike");
        int x =100;
        int y =200;
    


    }

}
