package HW1.repository;

import HW1.model.Bus;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository <Bus, Long>{

    Bus findByBusNumber(int BusNumber);
    List<Bus> findByOriginAndDestinationAndDate(String origin, String destination, String Date);
}
