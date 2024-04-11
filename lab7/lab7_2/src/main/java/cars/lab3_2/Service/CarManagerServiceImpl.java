package cars.lab3_2.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import cars.lab3_2.entities.Car;
import cars.lab3_2.repository.CarRepository;

@Service
public class CarManagerServiceImpl implements CarManagerService{

    private CarRepository carRepository;

    public CarManagerServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Override
    public List<Car> getAllcars() {
        return carRepository.findAll();
    }

    @Override
    public Car getCarDetails(Long carId) {
        return carRepository.findByCarId(carId);
    }
    
}
