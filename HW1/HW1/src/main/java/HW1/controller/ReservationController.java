package HW1.controller;

import HW1.model.Bus;
import HW1.model.Person;
import HW1.model.Reservation;
import HW1.service.BusService;
import HW1.service.ReservationService;
import HW1.service.PersonService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/api")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;
    private BusService busService;
    private PersonService personService;

    @PostMapping("/details")
    public String fillData(@RequestParam("busNumber") int busNumber, Model model) {
        Bus bus = busService.getBusByBusNumber(busNumber);

        model.addAttribute("bus", bus);

        return "personal"; // Assuming "personal.html" is the name of your template file
    }

    @PostMapping("/reservation")
    public String bookReservation(@RequestParam("creditCardNumber") Long creditCardNumber,
            @RequestParam("creditCardMM") Long creditCardMM,
            @RequestParam("creditCardYY") Long creditCardYY,
            @RequestParam("creditCardCVV") Long creditCardCVV,
            @RequestParam("busNumber") int busNumber,
            @ModelAttribute Person person,
            Model model) {

        Person savedPerson = personService.savePerson(person);

        Reservation reservation = new Reservation();
        reservation.setCreditCardNumber(creditCardNumber);
        reservation.setCreditCardMM(creditCardMM);
        reservation.setCreditCardYY(creditCardYY);
        reservation.setCreditCardCVV(creditCardCVV);
        reservation.setPerson(savedPerson);
        reservation.setBus(busService.getBusByBusNumber(busNumber));
        System.out.println(reservation.getPerson().getName());
        System.out.println(reservation.getBus().getBusNumber());
        System.out.println(reservation);
        // Save the reservation
        String token = reservationService.makeReservation(reservation);

        // Optionally, you can also return the saved reservation details to the view
        // model.addAttribute("reservationDetails", reservation);
        model.addAttribute("token", token);
        // Return the view where you want to display the reservation details
        return "reservation";
    }

    @PostMapping("/reservation/check")
    public String getReservations(Model model) {
        // Optional<Reservation> reservation = reservationService.getReservation(token);
        // model.addAttribute("reservation", reservation.get());
        return "check";
    }

    // @GetMapping("/reservation/check")
    // public String getReservations(@RequestParam("token") String token, Model model) {
    //     Optional<Reservation> reservation = reservationService.getReservation(token);
    //     if (reservation.isPresent()) {
    //         model.addAttribute("reservationDetails", reservation.get());
    //     } else {
    //         model.addAttribute("reservationDetails", null);
    //     }
    //     model.addAttribute("token", token);
    //     return "check";
    // }

    @GetMapping("/reservation/check")
    @ResponseBody // Ensure that the return value is serialized to JSON
    public ResponseEntity<?> getReservations(@RequestParam("token") String token, Model model) {
        Optional<Reservation> reservation = reservationService.getReservation(token);
        if (reservation.isPresent()) {
            model.addAttribute("reservationDetails", reservation.get());
            model.addAttribute("token", token);
            return ResponseEntity.ok(reservation.get()); // Return the reservation object
        } else {
            return ResponseEntity.notFound().build(); // Return 404 Not Found if reservation is not found
        }

    }


}
