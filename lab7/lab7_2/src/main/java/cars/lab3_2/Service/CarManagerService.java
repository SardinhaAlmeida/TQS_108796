package cars.lab3_2.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import cars.lab3_2.entities.Car;

@Service
public interface CarManagerService {

    public Car save(Car car);

    public List<Car> getAllcars();

    public Car getCarDetails(Long carId);
    
}
