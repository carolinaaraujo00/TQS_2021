package carAPI.app.services;

import static org.junit.jupiter.api.Assertions.*;

import carAPI.app.controller.ResourceNotFoundException;
import carAPI.app.model.Car;
import carAPI.app.repository.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.times;


@ExtendWith(MockitoExtension.class)
class CarManagerServiceTest {

    @Mock(lenient = true)
    private CarRepository carRepository;

    @InjectMocks
    private CarManagerService carManagerService;

    @BeforeEach
    public void setUp() {
        Car fiat500 = new Car("Fiat", "500");
        fiat500.setCarId(1L);

        Car fiat500L = new Car("Fiat", "500L");
        fiat500L.setCarId(2L);

        Car fiat600 = new Car("Fiat", "600");
        fiat600.setCarId(3L);

        List<Car> allCars = Arrays.asList(fiat500, fiat500L, fiat600);

        Mockito.when(carRepository.findAll()).thenReturn(allCars);
        Mockito.when(carRepository.findByCarId(fiat500.getCarId())).thenReturn(Optional.of(fiat500));
        Mockito.when(carRepository.findByCarId(fiat500L.getCarId())).thenReturn(Optional.of(fiat500L));
        Mockito.when(carRepository.findByCarId(fiat600.getCarId())).thenReturn(Optional.of(fiat600));

        Mockito.when(carRepository.findByCarId(15L)).thenReturn(Optional.empty());
    }

    @Test
    public void testCarValidId() throws ResourceNotFoundException {
        Car carFound = carManagerService.getCarDetails(1L).orElseThrow(() -> new ResourceNotFoundException("Car with id 1 not found!"));
        assertThat(carFound.getModel()).isEqualTo("500");

        verifyFindByIdIsCalledOnce();
    }

    @Test
    public void testCarInvalidId() throws ResourceNotFoundException {
        assertThatThrownBy(() -> {
            carManagerService.getCarDetails(15L).orElseThrow(() -> new ResourceNotFoundException("Car with id 15 not found!"));
        }).isInstanceOf(ResourceNotFoundException.class)
                .hasMessageContaining("Car with id 15 not found!");

        verifyFindByIdIsCalledOnce();
    }

    @Test
    public void testAllCars() {
        Car fiat500 = new Car("Fiat", "500");
        fiat500.setCarId(1L);

        Car fiat500L = new Car("Fiat", "500L");
        fiat500L.setCarId(2L);

        Car fiat600 = new Car("Fiat", "600");
        fiat600.setCarId(3L);

        List<Car> allCars = carManagerService.getAllCars();

        verifyFindAllCarsIsCalledOnce();
        assertThat(allCars).hasSize(3).extracting(Car::getModel).contains(fiat500.getModel(), fiat500L.getModel(), fiat600.getModel());
    }

    private void verifyFindByIdIsCalledOnce() {
        Mockito.verify(carRepository, times(1)).findByCarId(Mockito.anyLong());
    }

    private void verifyFindAllCarsIsCalledOnce() {
        Mockito.verify(carRepository, times(1)).findAll();
    }
}