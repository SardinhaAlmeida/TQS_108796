package HW1.unitTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import HW1.model.Person;
import HW1.repository.PersonRepository;
import HW1.service.serviceImpl.PersonServiceImpl;


@ExtendWith(MockitoExtension.class)
public class PersonService_UnitTest {

    @Mock(lenient = true)
    private PersonRepository person_repository;

    @InjectMocks
    private PersonServiceImpl person_service;

    // @BeforeEach
    // public void setUp() {

    //     Person maria = new Person(
    //             1L, 
    //             "Maria",
    //             "Joana", 
    //             "maria.joana@example.com", 
    //             "1234567890",
    //             "Rua da Alegria 123", 
    //             "Viseu", 
    //             "3660-123", 
    //             "Portugal" 
    //     );

    //     Person joaquim = new Person(
    //             "Joaquim",
    //             "Manuel", 
    //             "joao@gmail.com",
    //             "9876543210",
    //             "Rua da Tristeza 321",
    //             "Porto",
    //             "4000-123",
    //             "Portugal"
    //     );
    //     joaquim.setPersonId(2L);

    // }

    @Test
    @DisplayName("Test savePerson")
    void testSavePerson() {

        Person maria = new Person(
            1L, 
            "Maria",
            "Joana", 
            "maria.joana@example.com", 
            "1234567890",
            "Rua da Alegria 123", 
            "Viseu", 
            "3660-123", 
            "Portugal" 
        );

        when(person_repository.save(maria)).thenReturn(maria);
        Person savedPerson = person_service.savePerson(maria);
        assertEquals(maria, savedPerson);
    }
    
}
