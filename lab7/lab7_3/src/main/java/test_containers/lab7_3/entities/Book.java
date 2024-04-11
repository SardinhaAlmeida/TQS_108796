package test_containers.lab7_3.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "author", nullable = false)
	private String author;

    @Column(name = "published", nullable = false)
	private LocalDate published;

    @Column(name = "genre", nullable = false)
    private String genre;

    public Book(String title, String author, LocalDate published) {
        this.title = title;
        this.author = author;
        this.published = published;
    }

    public Book(String title, String author, LocalDate published, String genre) {
        this.title = title;
        this.author = author;
        this.published = published;
        this.genre = genre;
    }


    @Override
    public String toString() {
        return "Book [title=" + title + ", author=" + author + ", published=" + published + ", genre=" + genre + "]";
    }
    
    
}