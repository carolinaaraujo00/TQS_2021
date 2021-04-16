package carAPI.app.controller;

import carAPI.app.model.Car;
import carAPI.app.repository.CarRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

// switch AutoConfigureTestDatabase with TestPropertySource to use a real database
//@TestPropertySource( locations = "application-integrationtest.properties")

@TestPropertySource(locations = "application-integrationtest.properties")
public class CarAPI_IntegrationTest_RealDB {

    @LocalServerPort
    int serverPort;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private CarRepository repository;

    @AfterEach
    public void resetDB() {
        repository.deleteAll();
    }

    @Test
    public void whenPostCar_thenCreateCar() {
        Car fiat500 = new Car("Fiat", "500");
        ResponseEntity<Car> response = restTemplate.postForEntity("/api/cars", fiat500, Car.class);

        List<Car> cars = repository.findAll();
        assertThat(cars).extracting(Car::getMaker).containsOnly("Fiat");
    }


    @Test
    public void testAllCars() {
        createCar_Test("Fiat", "500");
        createCar_Test("Fiat", "500L");
        createCar_Test("Fiat", "600");


        ResponseEntity<List<Car>> response = restTemplate
                .exchange("/api/cars", HttpMethod.GET, null, new ParameterizedTypeReference<List<Car>>() {
                });

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).extracting(Car::getModel).containsExactly("500", "500L", "600");

    }

    private void createCar_Test(String maker, String model) {
        Car newCar = new Car(maker, model);
        repository.saveAndFlush(newCar);
    }


}