package cars.lab3_2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)  
@AutoConfigureTestDatabase                                                     
//@TestPropertySource(locations = "classpath:application-integrationtest.properties")
public class CarAPITest {

    @LocalServerPort
    int randomServerPort;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private CarRepository car_repository;

    @AfterEach
    public void resetDb() {
        car_repository.deleteAll();
    }

    @Test
    public void whenValidInput_thenCreateCar() {
        Car bb_car = new Car("Toyota", "Auris");
        ResponseEntity<Car> entity = restTemplate.postForEntity("/api/car", bb_car, Car.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        List<Car> found = car_repository.findAll();
        assertThat(found).extracting(Car::getModel).containsOnly(bb_car.getModel());
    }

    @Test
    public void givenCars_whenGetCars_thenStatus200() {
        Car my_car = new Car("BMW", "e36 318tds compact");
        car_repository.saveAndFlush(my_car);

        Car another_one = new Car("McLaren", "720S Coupé");
        car_repository.saveAndFlush(another_one);

        ResponseEntity<List<Car>> response = restTemplate.exchange("/api/cars", HttpMethod.GET, null, new ParameterizedTypeReference<List<Car>>() {
        });

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).extracting(Car::getModel).containsExactly("e36 318tds compact", "720S Coupé");
    }
    
}
