package HW1.service;

import HW1.model.Reservation;

import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public interface ReservationService {

    public String makeReservation(Reservation reservation);
    public Optional<Reservation> getReservation(String token);
    
}
