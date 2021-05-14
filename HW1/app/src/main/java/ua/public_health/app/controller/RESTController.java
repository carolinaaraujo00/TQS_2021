package ua.public_health.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.public_health.app.model.Location;
import ua.public_health.app.model.Covid19_Information;
import ua.public_health.app.service.API_Service;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class RESTController {
    private Logger logger = Logger.getLogger(RESTController.class.getName());
    private API_Service service = new API_Service();

    @GetMapping("info/location_names")
    // CURL: http://localhost:8080/info/location_names

    public Location[] location_names() {
        logger.log(Level.INFO, "REST Controller call retrieve all location names");

        return service.getListLocations();
    }

    @GetMapping("info/by_location")
    // CURL: http://localhost:8080/info/by_location/?location=aveiro

    public Covid19_Information info_by_location(@RequestParam(value = "location") String cidade) {
        logger.log(Level.INFO, String.format("REST Controller retrieve data from location: %s", cidade));

        return service.getInfoByLocation(cidade);
    }
}
