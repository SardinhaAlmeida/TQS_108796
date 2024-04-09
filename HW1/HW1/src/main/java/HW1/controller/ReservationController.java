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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

import lombok.AllArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@AllArgsConstructor
@RequestMapping("/api")
public class ReservationController {

    private static final Logger log = LoggerFactory.getLogger(ReservationController.class);

    @Autowired
    private BusService busService;
    private PersonService personService;
    private ReservationService reservationService;

    @PostMapping("/details")
    public String fillData(@RequestParam("busNumber") int busNumber, Model model) {
        Bus bus = busService.getBusByBusNumber(busNumber);

        model.addAttribute("bus", bus);

        return "personal";
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
        log.info("Person saved: " + savedPerson.getName());
        log.info("Bus saved: " + busService.getBusByBusNumber(busNumber).getBusNumber());

        String token = reservationService.makeReservation(reservation);
        log.info("Reservation successful: " + token);

        model.addAttribute("token", token);
        return "reservation";
    }

    @PostMapping("/reservation/check")
    public String getReservations(Model model) {
        return "check";
    }

    @GetMapping("/reservation/check")
    @ResponseBody
    public ResponseEntity<Reservation> getReservations(@RequestParam("token") String token, Model model) {
        Optional<Reservation> reservation = reservationService.getReservation(token);
        if (reservation.isPresent()) {
            model.addAttribute("reservationDetails", reservation.get());
            model.addAttribute("token", token);
            return ResponseEntity.ok(reservation.get());
        } else {
            return ResponseEntity.notFound().build();
        }

    }

}
