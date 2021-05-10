package ua.public_health.app.services;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ua.public_health.app.model.Location;
import ua.public_health.app.model.Location_Data;

public class API_Services {
    private String baseURL = "https://covid19-api.vost.pt/Requests/";
    private String url;
    public RestTemplate restTemplate = new RestTemplateBuilder().build();

    public Location_Data getInfoByLocation(String cidade) {
        url = baseURL + "get_last_update_specific_county/" + cidade;
        Location_Data[] response = this.restTemplate.getForObject(url, Location_Data[].class);
        return response[0];
    }

    public Location_Data[] getInfoByLocationBetweenDates(String cidade, String from, String to){
        url = baseURL + "/get_entry_county/" + from + "_until_" + to + "_" + cidade;
        Location_Data[] response = this.restTemplate.getForObject(url, Location_Data[].class);
        return response;
    }

    public Location[] getListLocations(){
        url = baseURL + "get_county_list/";
        Location[] response = this.restTemplate.getForObject(url, Location[].class);
        return response;
    }

}
