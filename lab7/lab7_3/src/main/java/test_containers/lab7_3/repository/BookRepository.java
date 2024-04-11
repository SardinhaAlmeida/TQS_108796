package test_containers.lab7_3.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import test_containers.lab7_3.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findById(Long id);
    Optional<Book> findByTitle(String title);
}