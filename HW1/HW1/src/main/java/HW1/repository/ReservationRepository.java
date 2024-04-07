package HW1.repository;

import HW1.model.Reservation;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository <Reservation, Long>{

    Optional<Reservation> findByToken(String token);
    
}
