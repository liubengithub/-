package com.liu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

@SpringBootApplication
public class MyfirstsiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyfirstsiteApplication.class, args);

        }

}
