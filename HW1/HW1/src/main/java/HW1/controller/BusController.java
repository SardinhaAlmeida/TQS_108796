package HW1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import HW1.model.Bus;
import HW1.service.BusService;
import lombok.AllArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@AllArgsConstructor
public class BusController {

    @Autowired
    private BusService busService;

    private static final Logger log = LoggerFactory.getLogger(BusController.class);

    @GetMapping("/")
    public String home(Model model) {
        log.info("got Home page");
        return "index";
    }


    @PostMapping("/api/bus")
    public String searchBuses(@RequestParam("origin") String origin,
                              @RequestParam("destination") String destination,
                              @RequestParam("date") String date,
                              Model model) {
        List<Bus> buses = busService.getBuses(origin, destination, date);
        log.info("Buses: []" + buses);
        log.info("Date: {}" + date);
        model.addAttribute("buses", buses);
        return "table";
    }

}
