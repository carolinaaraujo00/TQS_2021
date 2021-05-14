package ua.public_health.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.public_health.app.cache.Cache;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class UIController {
    private Cache cache = new Cache();
    private Logger logger = Logger.getLogger(UIController.class.getName());

    @GetMapping("/")
    public String getIndex() {
        logger.log(Level.INFO, "Interface Controller call to get data home page");

        return "index";
    }

    @GetMapping("/location")
    public String getDataByLocation(@RequestParam(required=true) String location, Model model) {
        logger.log(Level.INFO, String.format("Interface Controller call to get data for location %s", location));

        model.addAttribute("location", cache.cacheCall(location.toLowerCase(Locale.ROOT)));
        model.addAttribute("data", true);

        return "index";
    }

    @GetMapping("/cache")
    public String getCacheStats(Model model) {
        logger.log(Level.INFO, "Interface Controller call to get cache page");

        model.addAttribute("hit", cache.getHit());
        model.addAttribute("miss", cache.getMiss());
        model.addAttribute("requests", cache.getRequests());

        return "cache";
    }
}
