package book_search;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;
 
public class Library {
	private final List<Book> store = new ArrayList<>();
 
	public void addBook(final Book book) {
		store.add(book);
	}
 
	public List<Book> findBooksFrom_To(final LocalDate from, final LocalDate to) {
        List<Book> right_books = new ArrayList<>();

        for (Book book: store){
            if (book.getPublished().isAfter(from) && book.getPublished().isBefore(to)){
                right_books.add(book);
            }
        }
        right_books.sort((b1, b2) -> b2.getPublished().compareTo(b1.getPublished()));

        return right_books;

	}

    public List<Book> findBooksGenre (final List<String> genres){
        List<Book> right_books = new ArrayList<>();

        for (Book book: store){
            for (String genre: genres){
                if (book.getGenres().contains(genre)){
                    right_books.add(book);
                }
            }
        }

        right_books.sort((b1, b2) -> b2.getPublished().compareTo(b1.getPublished()));

        return right_books;
    }
}
