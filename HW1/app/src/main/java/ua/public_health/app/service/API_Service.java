package ua.public_health.app.service;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import ua.public_health.app.model.Location;
import ua.public_health.app.model.Covid19_Information;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
@Configurable
public class API_Service {
    public RestTemplate restTemplate = new RestTemplateBuilder().build();
    private Logger logger = Logger.getLogger(API_Service.class.getName());
    private static final String baseURL = "https://covid19-api.vost.pt/Requests/";
    private String url;

    public Covid19_Information getInfoByLocation(String cidade) {
        logger.log(Level.INFO, String.format("API Service call to get data from location: %s", cidade));

        try {
            url = baseURL + "get_last_update_specific_county/" + cidade;
            Covid19_Information[] response = this.restTemplate.getForObject(url, Covid19_Information[].class);
            return response[0];
        } catch (Exception e) {
            logger.log(Level.WARNING, String.format("API Service call can not find location: %s", cidade));
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "API Service call can not find location.");
        }
    }

    public Covid19_Information[] getInfoByLocationBetweenDates(String cidade, String from, String to){
        logger.log(Level.INFO, String.format("API Service call to get data from (%s) to (%s), location: %s", from, to, cidade));

        url = baseURL + "/get_entry_county/" + from + "_until_" + to + "_" + cidade;
        Covid19_Information[] response = this.restTemplate.getForObject(url, Covid19_Information[].class);

        return response;
    }

    public Location[] getListLocations(){
        logger.log(Level.INFO, "API Service call to get data for all location names");

        url = baseURL + "get_county_list/";
        Location[] response = this.restTemplate.getForObject(url, Location[].class);

        return response;
    }

}
