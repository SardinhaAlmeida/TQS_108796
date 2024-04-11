package cars.lab3_2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cars.lab3_2.entities.Car;

public interface CarRepository extends JpaRepository<Car, Long> {

    public Car findByCarId(Long carId);
    public List<Car> findAll();
}