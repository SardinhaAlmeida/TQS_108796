package cars.lab3_2;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cars.lab3_2.Service.CarManagerService;

@RestController
@RequestMapping("/api")
public class CarController {

    private CarManagerService carManagerService;

    public CarController(CarManagerService carManagerService) {
        this.carManagerService = carManagerService;
    }

    @PostMapping("/car")
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        Car saved = carManagerService.save(car);
        HttpStatus status = HttpStatus.CREATED;
        return new ResponseEntity<>(saved, status);
    }

    @GetMapping("/cars")
    public List<Car> getAllcars() {
        return carManagerService.getAllcars();
    }

    @GetMapping("/cars/{carId}")
    public ResponseEntity<Car> getCarById(Long carId) {
        Car car = carManagerService.getCarDetails(carId);
        HttpStatus status;
        if (car != null) {
            status = HttpStatus.OK;
        } else {
            status = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(car, status);
    }
    
}
