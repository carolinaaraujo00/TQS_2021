package ua.public_health.app.cache;

import ua.public_health.app.model.Covid19_Information;
import ua.public_health.app.service.API_Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import java.util.logging.Logger;
import java.util.logging.Level;

public class Cache {
    private Logger logger = Logger.getLogger(Cache.class.getName());

    private static int miss;
    private static int hit;

    private static Map<String, Covid19_Information> requests_data;
    private static Map<String, Date> requests_timestamp;

    private API_Service service = new API_Service();

    public Cache() {
        this.requests_timestamp = new HashMap<>();
        this.requests_data = new HashMap<>();
        this.hit = 0;
        this.miss = 0;
    }

    public Covid19_Information cacheCall(String cidade) {
        if ( !requests_data.containsKey(cidade) ) {

            logger.log(Level.WARNING, String.format("Cache call MISS for location %s.", cidade));
            this.miss++;

            requests_data.put(cidade, service.getInfoByLocation(cidade));
            requests_timestamp.put(cidade, new Date());

            return requests_data.get(cidade);

        } else if ( requests_data.containsKey(cidade)
                && (Math.abs(requests_timestamp.get(cidade).getTime() - new Date().getTime()) >= 120000)) {

            logger.log(Level.WARNING, String.format("Cache call MISS for location %s.", cidade));
            this.miss++;

            requests_data.put(cidade, service.getInfoByLocation(cidade));
            requests_timestamp.put(cidade, new Date());

            return requests_data.get(cidade);

        } else {

            logger.log(Level.INFO, String.format("Cache call HIT for location %s", cidade));
            this.hit++;

            return requests_data.get(cidade);
        }
    }

    public int getMiss(){
        logger.log(Level.INFO, String.format("Cache call MISS count: %d", this.miss));

        return this.miss;
    }
    public int getHit() {
        logger.log(Level.INFO, String.format("Cache call HIT count: %d", this.hit));

        return this.hit;
    }
    public int getRequests() {
        logger.log(Level.INFO, String.format("Cache call REQUEST count: %d", this.hit + this.miss));

        return this.hit + this.miss;
    }
}
