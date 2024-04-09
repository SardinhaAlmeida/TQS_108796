// package HW1.repositoryTests;

// import static org.assertj.core.api.Assertions.assertThat;

// import java.util.Optional;
// import java.util.UUID;

// import org.junit.jupiter.api.Disabled;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
// import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

// import HW1.model.Bus;
// import HW1.model.Person;
// import HW1.model.Reservation;
// import HW1.repository.ReservationRepository;

// @DataJpaTest
// public class ReservationRepositoryTNotWorking {

//     @Autowired
//     private TestEntityManager entityManager;

//     @Autowired
//     private ReservationRepository reservation_repository;

//     @Disabled
//     @Test
//     public void testFindByToken() {

//         Bus bus4 = new Bus(4, "Viseu", "Aveiro", "2024-04-12", "18:00", "19:00", 10, 10);

//         Person maria = new Person(
//             1L, 
//             "Maria",
//             "Joana", 
//             "maria.joana@example.com", 
//             "1234567890",
//             "Rua da Alegria 123", 
//             "Viseu", 
//             "3660-123", 
//             "Portugal" 
//         );

//         Reservation reservation3 = new Reservation(
//             1234567890321654L, 
//             11L, 
//             24L, 
//             132L, 
//             maria, 
//             bus4
//         );
//         reservation3.setId(3L);
//         reservation3.setToken(UUID.randomUUID().toString());

//         entityManager.persistAndFlush(reservation3);

//         Optional<Reservation> foundOptional = reservation_repository.findByToken(reservation3.getToken());
//         assertThat(foundOptional).isPresent();

//         Reservation found = foundOptional.get();
//         assertThat(found.getToken()).isEqualTo(reservation3.getToken());

//     }
    
// }
