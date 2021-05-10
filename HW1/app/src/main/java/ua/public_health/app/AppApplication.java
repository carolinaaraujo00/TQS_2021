package ua.public_health.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import ua.public_health.app.services.API_Services;

import java.security.SecureRandom;

@SpringBootApplication
public class AppApplication {

	private static final Logger log = LoggerFactory.getLogger(AppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
		API_Services service = new API_Services();


		// WORKS:
		// service.getListLocations();
		// service.getInfoByLocation("aveiro");
		// service.getInfoByLocationBetweenDates("AVEIRO", "28-04-2021", "30-04-2021");
	}

	// https://github.com/carolinaaraujo00/TQS/tree/main/lab4/ex2_3/app/src/main/java/carAPI/app
	// https://covid19-api.vost.pt/
}
