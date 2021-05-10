package ua.public_health.app.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.public_health.app.services.API_Services;

import java.net.MalformedURLException;
import java.text.ParseException;

import java.util.logging.Logger;
import java.util.logging.Level;

@Controller
public class UIController {
    private API_Services service = new API_Services();
    private Logger logger = Logger.getLogger(UIController.class.getName());

    @GetMapping("/")
    public String getDataByLocation(Model model) throws MalformedURLException, JsonProcessingException {
        return "index";
    }

    @GetMapping("/location")
    public String getDataByLocation(@RequestParam(required=true) String location, Model model) throws MalformedURLException, JsonProcessingException, ParseException {
        model.addAttribute("location", service.getInfoByLocation(location));
        model.addAttribute("data", true);
        return "index";
    }
}
