package cars.lab3_2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import cars.lab3_2.Service.CarManagerService;

@WebMvcTest(CarController.class)
public class CarControllerTest {

    @Autowired
    private MockMvc mvc;  

    @MockBean
    private CarManagerService car_service;

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void whenPostCar_thenCreateCar() throws Exception {
        Car my_car = new Car("BMW", "e36 318tds compact");

        when(car_service.save(Mockito.any())).thenReturn(my_car);

        mvc.perform(
            post("/api/car").contentType(MediaType.APPLICATION_JSON).content(JsonUtils.toJson(my_car)))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.maker", is("BMW")));
        
        verify(car_service, times(1)).save(Mockito.any());
    }

    @Test
    public void givenCars_whenGetAllCars_thenReturnJsonArray() throws Exception {
        Car my_car = new Car("BMW", "e36 318tds compact");
        Car another = new Car("Toyota", "Auris");
        Car another2 = new Car("Volkswagen", "Polo");

        List<Car> all_cars = Arrays.asList(my_car, another, another2);

        when(car_service.getAllcars()).thenReturn(all_cars);

        mvc.perform(get("/api/cars").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(3)))
            .andExpect(jsonPath("$[0].maker", is(my_car.getMaker())))
            .andExpect(jsonPath("$[1].maker", is(another.getMaker())))
            .andExpect(jsonPath("$[2].maker", is(another2.getMaker())));
        
        verify(car_service, times(1)).getAllcars();
    }

    @Test
    public void givenCar_whenGetCarById_thenReturnJson() throws Exception {
        Car my_car = new Car("BMW", "e36 318tds compact");

        when(car_service.getCarDetails(Mockito.any())).thenReturn(my_car);

        mvc.perform(get("/api/cars/1").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.maker", is("BMW")));
        
        verify(car_service, times(1)).getCarDetails( Mockito.any() );
    }
    
}
