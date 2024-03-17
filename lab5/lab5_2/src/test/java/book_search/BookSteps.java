package book_search;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookSteps {

    static final Logger log = getLogger(lookup().lookupClass());

    Library library = new Library();
	List<Book> result = new ArrayList<>();

    @ParameterType("([0-9]{4})-([0-9]{2})-([0-9]{2})")
	public LocalDate iso8601Date(String year, String month, String day){
		return Utils.localDateFromDateParts(year, month, day);
	}

    @DataTableType
	public Book bookEntry(Map<String, String> tableEntry){
        String genresString = tableEntry.get("genres");
        List<String> genres = Arrays.asList(genresString.split(", "));
		return new Book(
				tableEntry.get("title"),
				tableEntry.get("author"),
                Utils.isoTextToLocalDate(tableEntry.get("published")),
				genres);
	}

    @Given("a book with the title {string}, written by {string}, published in {string}")
    public void addBook(String title, String author, String published) {
        Book book = new Book(title, author, Utils.isoTextToLocalDate(published));
        library.addBook(book);
    }

    @And("another book with the title {string}, written by {string}, published in {string}")
    public void addAnotherBook(String title, String author, String published) {
        Book book = new Book(title, author, Utils.isoTextToLocalDate(published));
        library.addBook(book);
    }

    @When("the customer searches for books published between {iso8601Date} and {iso8601Date}")
    public void searchBooks(LocalDate from, LocalDate to) {
        result = library.findBooksFrom_To(from, to);
    }

    @Then("{int} books should have been found")
    public void checkAmountOfBooks(int amount) {
        // log.debug("Found {} books", result.size());
        assert(result.size() == amount);
    }

    @And("Book {int} should have the title {string}")
    public void checkBookTitle(int index, String title) {
        // log.debug("Book {} has title {}", index, title);
        // for (Book book: result){
        //     log.debug("Book: {}", book);
        // }
        assert(result.get(index-1).getTitle().equals(title));
    }

    @Given("that I have this books in the store")
    public void addGenreBooks(DataTable books){
        List<Book> bookList = books.asList(Book.class);
        for (Book book: bookList){
            library.addBook(book);
        }
    }

    @When("the costumer searches for {string} books")
    public void searchBooksGenre(String genres){
        List<String> genresList = Arrays.asList(genres.split(", "));
        result = library.findBooksGenre(genresList);
    }



    
}
