/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.bookexchange.core;

import group20.bookexchange.utils.AbstractEntityContainer;
import java.util.ArrayList;
import java.util.List;



public class BookList extends AbstractEntityContainer<Book,Long> implements IBookList {
    
    public BookList(){

    }
    
    @Override
    public List<Book> getByTitle(String title){
        List<Book> found = new ArrayList<>();
        for (Book b : getRange(0, getCount())) {
            if (b.getTitle().toLowerCase().equals(title.toLowerCase())) {
                found.add(b);
            }
        }
        return found;
    }
    @Override
    public List<Book> getByAuthor(String author){
        List<Book> found = new ArrayList<>();
        for (Book b : getRange(0, getCount())) {
            if (b.getAuthor().toLowerCase().equals(author.toLowerCase())) {
                found.add(b);
            }
        }
        return found;
    }
    @Override
    public List<Book> getByCourse(String course){
        List<Book> found = new ArrayList<>();
        for (Book b : getRange(0, getCount())) {
            if (b.getCourse().toLowerCase().equals(course.toLowerCase())) {
                found.add(b);
            }
        }
        return found;
    }
    @Override
    public List<Book> getByState(Book.BookState bookState){
        List<Book> found = new ArrayList<>();
        for (Book b : getRange(0, getCount())) {
            if (b.getBookState().equals(bookState)) {
                found.add(b);
            }
        }
        return found;
    }
}
