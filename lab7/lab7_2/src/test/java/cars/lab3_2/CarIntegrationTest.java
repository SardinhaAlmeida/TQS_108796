package cars.lab3_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.TestPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

import cars.lab3_2.entities.Car;
import cars.lab3_2.repository.CarRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
@TestPropertySource(properties = "spring.jpa.hibernate.ddl-auto=create")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CarIntegrationTest {

    @Container
    public static PostgreSQLContainer<?> container = new PostgreSQLContainer<>("postgres:latest")
            .withUsername("sara")
            .withPassword("sardinha")
            .withDatabaseName("tqs_lab7");

    @LocalServerPort
    int localPortForTestServer;


    @Autowired
    private CarRepository car_repository;

    @DynamicPropertySource
    static void properties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", container::getJdbcUrl);
        registry.add("spring.datasource.password", container::getPassword);
        registry.add("spring.datasource.username", container::getUsername);
    }

    @AfterEach
    void clean() {
        car_repository.deleteAll();
    }

    @Test
    @Order(1)
    void test_create() {

        Car car = new Car("Toyota", "Yaris");
        car_repository.save(car);

        given().port(localPortForTestServer).contentType("application/json").body(car).post("/api/car").then().statusCode(201);

        assertTrue(car_repository.findById(car.getCarId()).isPresent());
    }

    @Test
    @Order(2)
    void test_getAll() {
        Car my_car = new Car("BMW", "e36 318tds compact");
        Car another = new Car("Toyota", "Auris");
        Car another2 = new Car("Volkswagen", "Polo");

        car_repository.save(my_car);
        car_repository.save(another);
        car_repository.save(another2);

        given().port(localPortForTestServer).get("/api/cars").then().statusCode(200).assertThat().body("maker", hasItems("BMW", "Toyota", "Volkswagen"));
    }

    @Test
    @Order(3)
    void test_getById() {
        Car my_car = new Car("BMW", "e36 318tds compact");
        car_repository.save(my_car);

        given().port(localPortForTestServer).get("/api/cars/{id}", my_car.getCarId()).then().statusCode(200).assertThat().body("maker", equalTo("BMW"));
    }
    
}
