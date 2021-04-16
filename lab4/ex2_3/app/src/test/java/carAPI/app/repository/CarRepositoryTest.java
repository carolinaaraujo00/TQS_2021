package carAPI.app.repository;

import static org.junit.jupiter.api.Assertions.*;

import carAPI.app.model.Car;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CarRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CarRepository carRepository;

    @Test
    public void testCarValidId() {
        Car fiat500 = new Car("Fiat", "500");
        entityManager.persistAndFlush(fiat500);

        Car carFound = carRepository.findByCarId(fiat500.getCarId()).orElse(null);
        assertThat(carFound).isNotNull();
        assertThat(carFound.getModel()).isEqualTo(fiat500.getModel());
    }

    @Test
    public void testCarInvalidId() {
        Car carFound = carRepository.findById(15L).orElse(null);
        assertThat(carFound).isNull();
    }

    @Test
    public void testAllCars() {
        Car fiat500 = new Car("Fiat", "500");
        entityManager.persist(fiat500);

        Car fiat500L = new Car("Fiat", "500L");
        entityManager.persist(fiat500L);

        Car fiat600 = new Car("Fiat", "600");
        entityManager.persist(fiat600);

        entityManager.flush();

        List<Car> allCars = carRepository.findAll();
        assertThat(allCars).hasSize(3).extracting(Car::getModel).containsOnly(fiat500.getModel(), fiat500L.getModel(), fiat600.getModel());
    }

}