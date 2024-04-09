package HW1.repositoryTests;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import HW1.model.Bus;
import HW1.repository.BusRepository;

@DataJpaTest
public class BusRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BusRepository bus_repository;
    
    @Disabled
    @Test
    void testFindByBusNumber() {
        Bus bus = new Bus(5, "Porto", "Lisboa", "2024-04-12", "20:00", "23:00", 20, 5);

        entityManager.persistAndFlush(bus);

        Bus found = bus_repository.findByBusNumber(5);

        assertThat(found.getBusNumber()).isEqualTo(bus.getBusNumber());
    }

    // @Disabled
    // @Test
    // public void testFindByOriginAndDestinationAndDate() throws ParseException {
    //     Bus bus = new Bus(5, "Porto", "Lisboa", "2024-04-12", "20:00", "23:00", 20, 5);
        
    //     entityManager.persistAndFlush(bus); // Use persistAndFlush from TestEntityManager

    //     List<Bus> found = bus_repository.findByOriginAndDestinationAndDate("Porto", "Lisboa", "2024-04-12");

    //     assertThat(found).isNotEmpty();
    //     assertThat(found.get(0).getOrigin()).isEqualTo(bus.getOrigin());
    //     assertThat(found.get(0).getDestination()).isEqualTo(bus.getDestination());
    //     assertThat(found.get(0).getDate()).isEqualTo(bus.getDate());
    // }
}
