package ua.public_health.app.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ua.public_health.app.model.Location;
import ua.public_health.app.model.Location_Data;
import ua.public_health.app.services.API_Services;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.net.MalformedURLException;

import java.util.logging.Logger;
import java.util.logging.Level;

@Controller
public class RESTController {
    private API_Services service = new API_Services();
    private Logger logger = Logger.getLogger(UIController.class.getName());

    @GetMapping(value = "/info/location_names")
    public Location[] location_names(Model model) throws MalformedURLException, JsonProcessingException {
        return service.getListLocations();
    }

    @GetMapping(value = "/info/by_location={cidade}")
    public Location_Data info_by_location(@PathVariable("cidade") String cidade) {
        return service.getInfoByLocation(cidade);
    }
}
