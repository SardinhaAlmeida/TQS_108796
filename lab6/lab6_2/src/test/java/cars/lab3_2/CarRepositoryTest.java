package cars.lab3_2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CarRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CarRepository car_repository;

    @BeforeEach
    public void setUp() {
        car_repository.deleteAll();
    }

    @Test
    public void whenFindById_thenReturnCar() {
        Car my_car = new Car("BMW", "e36 318tds compact");
        entityManager.persistAndFlush(my_car);

        Car found = car_repository.findByCarId(my_car.getCarId());
        assertThat(found.getCarId()).isEqualTo(my_car.getCarId());
    }

    
    @Test
    public void whenInvalidCarId_thenReturnNull() {
        Car no = car_repository.findByCarId(400L);
        assertThat(no).isNull();
    }

    
    @Test
    public void whenFindCarByExistingId_thenReturnCar() {
        Car my_car = new Car("BMW", "e36 318tds compact");
        entityManager.persistAndFlush(my_car);

        Car found = car_repository.findById(my_car.getCarId()).orElse(null);
        assertThat(found).isNotNull();
        assertThat(found.getCarId()).isEqualTo(my_car.getCarId());
    }

    
    @Test
    public void whenInvalidId_thenReturnNull() {
        Car from_db = car_repository.findById(-99L).orElse(null);
        assertThat(from_db).isNull();
    }

    @Test
    public void givenSetOfCars_whenFindAll_thenReturnAllCars() {
        Car my_car = new Car("BMW", "e36 318tds compact");
        Car another = new Car("Toyota", "Auris");
        Car another_one = new Car("McLaren", "720S Coupé");

        entityManager.persist(my_car);
        entityManager.persist(another);
        entityManager.persist(another_one);
        entityManager.flush();

        List<Car> all_cars = car_repository.findAll();

        assertThat(all_cars).hasSize(3).extracting(Car::getMaker).containsOnly(my_car.getMaker(), another.getMaker(), another_one.getMaker());
    }

    
}
