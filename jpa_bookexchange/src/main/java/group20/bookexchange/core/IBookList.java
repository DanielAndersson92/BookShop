package group20.bookexchange.core;

import group20.bookexchange.db.IDAO;
import java.util.List;

/**
 * BookList is the database connection for the Book object. 
 * @author Daniel
 */
public interface IBookList extends IDAO<Book, Long> {
    public List<Book> getByTitle(String title);
    public List<Book> getByAuthor(String author);
    public List<Book> getByCourse(String course);
    public List<Book> getByState(Book.BookState bookState);
    public List<Book> getByUser(User user);
    public List<Book> getRangeDate(Integer nrOfBooks, Book.BookState bookState);
}
