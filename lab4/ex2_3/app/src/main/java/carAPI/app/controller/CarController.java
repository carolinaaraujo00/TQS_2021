package carAPI.app.controller;

import carAPI.app.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import carAPI.app.services.CarManagerService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CarController {

    @Autowired
    private CarManagerService carManagerService;

    @GetMapping(path = "/cars")
    public List<Car> getAllCars(){
        return carManagerService.getAllCars();
    }

    @GetMapping(path = "/cars/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable(value = "id") Long carId) throws ResourceNotFoundException{
        Car car = carManagerService.getCarDetails(carId).orElseThrow(() -> new ResourceNotFoundException("No car with the id " + carId + " was found."));
        return ResponseEntity.ok().body(car);
    }

    @PostMapping(path = "/cars")
    public ResponseEntity<Car> createCar(@RequestBody Car newcar){
        return new ResponseEntity<Car>(carManagerService.save(newcar), HttpStatus.CREATED);
    }
}
