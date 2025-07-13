package com.cognizant.spring_learn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringLearnApplication.class, args);
		displayCountries();
	}

	public static void displayCountries() {
		LOGGER.debug("START displayCountries");

		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		List<Country> countryList = (List<Country>) context.getBean("countryList");

		for (Country c : countryList) {
			LOGGER.debug("Country: {}", c);
		}

		LOGGER.debug("END displayCountries");
	}
}
