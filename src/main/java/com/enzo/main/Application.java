/**
 * 
 */
package com.enzo.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author enzo
 *
 */
//@SpringBootApplication
@Configuration 
@EnableAutoConfiguration
//@EnableWebMvc
@ComponentScan({"com.enzo"})
public class Application {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
	}

}
