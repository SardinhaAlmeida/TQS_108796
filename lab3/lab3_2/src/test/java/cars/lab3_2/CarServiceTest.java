package cars.lab3_2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.mockito.junit.jupiter.MockitoExtension;

import cars.lab3_2.Service.CarManagerServiceImpl;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;

@ExtendWith(MockitoExtension.class)
public class CarServiceTest {

    @Mock( lenient = true)
    private CarRepository car_repository;

    @InjectMocks
    private CarManagerServiceImpl car_service;

    @BeforeEach
    public void setUp() {

        Car alt_car = new Car("Range Rover", "Evoque");
        alt_car.setCarId(20L);

        Car my_car = new Car("BMW", "e36 318tds compact");
        Car another_one = new Car("McLaren", "720S Coupé");

        List<Car> all_cars = Arrays.asList(my_car, another_one, alt_car);

        Mockito.when(car_repository.findByCarId(my_car.getCarId())).thenReturn(my_car);
        Mockito.when(car_repository.findByCarId(20L)).thenReturn(alt_car);
        Mockito.when(car_repository.findAll()).thenReturn(all_cars);
        Mockito.when(car_repository.findByCarId(600L)).thenReturn(null);

    }

    @Test
    public void whenValidId_thenCarShouldBeFound() {
        Long alt_car_id = 20L;
        Car found = car_service.getCarDetails(alt_car_id);
        assertThat(found.getCarId()).isEqualTo(alt_car_id);

        Mockito.verify(car_repository, VerificationModeFactory.times(1)).findByCarId(alt_car_id);
    }

    @Test
    public void whenInValidId_thenCarShouldNotBeFound() {
        Car not_found = car_service.getCarDetails(200L);
        assertThat(not_found).isNull();
        Mockito.verify(car_repository, VerificationModeFactory.times(1)).findByCarId(anyLong());
    }

    @Test
    public void given3Cars_whengetAll_thenReturn3Records() {
        Car my_car = new Car("BMW", "e36 318tds compact");
        Car alt_car = new Car("Range Rover", "Evoque");
        Car another_one = new Car("McLaren", "720S Coupé");

        List<Car> all_cars = car_service.getAllcars();
        Mockito.verify(car_repository, VerificationModeFactory.times(1)).findAll();
        assertThat(all_cars).hasSize(3).extracting(Car::getCarId).contains(my_car.getCarId(), another_one.getCarId(), alt_car.getCarId());
    }


    
}
