/**
 * 
 */
package com.enzo.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author enzo
 *
 */
@Configuration 
@EnableAutoConfiguration
@ComponentScan({"com.enzo"})
public class Application extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
	}

}
