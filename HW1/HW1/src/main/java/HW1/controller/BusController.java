package HW1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import HW1.model.Bus;
import HW1.service.BusService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class BusController {

    @Autowired
    private BusService busService;

    @GetMapping("/")
    public String home(Model model) {
        return "index";
    }
    
    // @GetMapping("/teste")
    // public ResponseEntity<List<Bus>> teste() {
    //     List<Bus> buses = busService.getAll();
        
    //     // Add the list of buses to the model
    //     System.out.println(buses);
        
    //     // Forward the user to the page displaying the available buses
    //     return new ResponseEntity<>(buses, HttpStatus.OK);
    // }


    @PostMapping("/api/bus")
    public String searchBuses(@RequestParam("origin") String origin,
                              @RequestParam("destination") String destination,
                              @RequestParam("date") String date,
                              Model model) {
        // Retrieve buses from the service based on the provided origin and destination
        List<Bus> buses = busService.getBuses(origin, destination, date);
        
        // Add the list of buses to the model
        model.addAttribute("buses", buses);
        // System.out.println(buses);
        
        // Forward the user to the page displaying the available buses
        return "table";
    }

}
