package com.agashchuk.vueDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class VueDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(VueDemoApplication.class, args);
	}
}
