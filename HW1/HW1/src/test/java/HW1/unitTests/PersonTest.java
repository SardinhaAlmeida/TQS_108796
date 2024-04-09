package HW1.unitTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import HW1.model.Person;

@ExtendWith(MockitoExtension.class)
public class PersonTest {

    @Test
    @DisplayName("Test to person because excludes in pom not working")
    void testPerson() {
        Person joaquim = new Person(
            "Joaquim",
            "Manuel", 
            "joao@gmail.com",
            "9876543210",
            "Rua da Tristeza 321",
            "Porto",
            "4000-123",
            "Portugal"
        );

        assertEquals("Joaquim", joaquim.getName());
        assertEquals("Manuel", joaquim.getSurname());
        assertEquals("joao@gmail.com", joaquim.getEmail());
        assertEquals("9876543210", joaquim.getPhoneNumber());
        assertEquals("Rua da Tristeza 321", joaquim.getAddress());
        assertEquals("Porto", joaquim.getCity());
        assertEquals("4000-123", joaquim.getPostalCode());
        assertEquals("Portugal", joaquim.getCountry());
    }
    
}
