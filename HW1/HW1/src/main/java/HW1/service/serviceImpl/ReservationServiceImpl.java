package HW1.service.serviceImpl;

import HW1.service.ReservationService;
import HW1.model.Reservation;
import HW1.repository.ReservationRepository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {
    
    private ReservationRepository reservationRepository;
    
    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }
    
    @Override
    public String makeReservation(Reservation reservation) {
        String accessToken = UUID.randomUUID().toString();
        reservation.setToken(accessToken);
        reservationRepository.save(reservation);
        return accessToken;
    }
    
    @Override
    public Optional<Reservation> getReservation(String token) {
        return reservationRepository.findByToken(token);
    }
    
}
