package book_search;

import java.time.LocalDate;
import java.util.List;

public class Book {

    private final String title;
	private final String author;
	private final LocalDate published;
    private List<String> genres;

    public Book(String title, String author, LocalDate published) {
        this.title = title;
        this.author = author;
        this.published = published;
    }

    public Book(String title, String author, LocalDate published, List<String> genres) {
        this.title = title;
        this.author = author;
        this.published = published;
        this.genres = genres;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDate getPublished() {
        return published;
    }


    public List<String> getGenres() {
        return genres;
    }

    @Override
    public String toString() {
        return "Book [title=" + title + ", author=" + author + ", published=" + published + ", genre=" + genres + "]";
    }
    
    
}
