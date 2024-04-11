package test_containers.lab7_3;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.junit.jupiter.api.*;

import test_containers.lab7_3.entities.Book;
import test_containers.lab7_3.repository.BookRepository;

@Testcontainers
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ContainerTest {

    @Container
    public static PostgreSQLContainer<?> container = new PostgreSQLContainer<>("postgres:latest")
            .withUsername("sara")
            .withPassword("sardinha")
            .withDatabaseName("tqs_lab7");

    @Autowired
    private BookRepository book_repository;

    @DynamicPropertySource
    static void properties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", container::getJdbcUrl);
        registry.add("spring.datasource.password", container::getPassword);
        registry.add("spring.datasource.username", container::getUsername);
    }

    @Test
    @Order(1)
    void test_create() {

        Book book = new Book(1L,"Never never", "Colleen Hoover", LocalDate.now(), "Romance");
        book_repository.save(book);
        
        assertTrue(book_repository.findById(1L).isPresent());
    }

    @Test
    @Order(2)
    void test_update() {

        Book book = book_repository.findById(1L).get();
        book.setGenre("Thriller");
        book_repository.save(book);
        
        assertTrue(book_repository.findById(1L).get().getGenre().equals("Thriller"));
    }

    @Test
    @Order(3)
    void test_delete() {

        book_repository.deleteById(1L);
        
        assertTrue(book_repository.findById(1L).isEmpty());
    }

    @Test
    @Order(4)
    void test_findId() {
            
        Book book = new Book(2L,"Verity", "Colleen Hoover", LocalDate.now(), "Romance");
        book_repository.save(book);
        
        assertTrue(book_repository.findById(2L).isPresent());
    }

    @Test
    @Order(5)
    void test_findTitle() {
            
        Book book = new Book(3L,"Isto Acaba Aqui", "Colleen Hoover", LocalDate.now(), "Romance");
        book_repository.save(book);
        
        assertTrue(book_repository.findByTitle("Isto Acaba Aqui").isPresent());
    }


}
