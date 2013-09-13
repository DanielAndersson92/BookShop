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
    public List<Book> getByName(String name){
        List<Book> found = new ArrayList<>();
        for (Book b : getRange(0, getCount())) {
            if (b.getName().equals(name)) {
                found.add(b);
            }
        }
        return found;
    }
    @Override
    public List<Book> getByAuthor(String author){
        List<Book> found = new ArrayList<>();
        for (Book b : getRange(0, getCount())) {
            if (b.getAuthor().equals(author)) {
                found.add(b);
            }
        }
        return found;
    }
    @Override
    public List<Book> getByCourse(String course){
        List<Book> found = new ArrayList<>();
        for (Book b : getRange(0, getCount())) {
            if (b.getCourse().equals(course)) {
                found.add(b);
            }
        }
        return found;
    }
}
