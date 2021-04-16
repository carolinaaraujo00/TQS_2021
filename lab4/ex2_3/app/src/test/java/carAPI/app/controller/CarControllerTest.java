package carAPI.app.controller;

import carAPI.app.model.Car;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import carAPI.app.services.CarManagerService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
class CarControllerTest {

    @Autowired
    private MockMvc mockMVC;

    @MockBean
    private CarManagerService carService;

    @Test
    public void testPostCar_ReturnsCar() throws Exception{
        Car fiat500 = new Car("Fiat", "500");
        fiat500.setCarId(1L);

        when(carService.save(Mockito.any())).thenReturn(fiat500);

        mockMVC.perform(post("/api/cars").contentType(MediaType.APPLICATION_JSON).content(JsonUtil.toJson(fiat500)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.maker", is("Fiat")))
                .andExpect(jsonPath("$.model", is("500")));

        verify(carService, times(1)).save(fiat500);
    }

    @Test
    public void testValid_id_ofCar() throws Exception{
        Car fiat500 = new Car("Fiat", "500");
        fiat500.setCarId(1L);

        when(carService.getCarDetails(fiat500.getCarId())).thenReturn(Optional.of(fiat500));

        mockMVC.perform(get("/api/cars/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("maker").value("Fiat"))
                .andExpect(jsonPath("model").value("500"));

        verify(carService, times(1)).getCarDetails(fiat500.getCarId());
    }

    @Test
    public void testGetAllCars() throws Exception{
        Car fiat500 = new Car("Fiat", "500");
        Car fiat600 = new Car("Fiat", "600");
        Car fiat500L = new Car("Fiat", "500L");

        List<Car> cars = Arrays.asList(fiat500L, fiat600, fiat500);
        given(carService.getAllCars()).willReturn(cars);

        mockMVC.perform(get("/api/cars").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].maker", is(fiat500L.getMaker())))
                .andExpect(jsonPath("$[1].model", is(fiat600.getModel())))
                .andExpect(jsonPath("$[2].model", is(fiat500.getModel())))
                .andExpect(jsonPath("$[2].maker", is(fiat500.getMaker())));

        verify(carService, times(1)).getAllCars();
    }
}