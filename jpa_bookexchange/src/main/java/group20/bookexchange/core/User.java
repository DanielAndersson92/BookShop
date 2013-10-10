/*
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.bookexchange.core;

import group20.bookexchange.utils.AbstractEntity;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/*
 *
 * @author Daniel
 */
@Entity
public class User extends AbstractEntity {

    private String fname;
    private String lname;
    private String cid;
    private String email;
    @OneToOne
    private BookList books;

    public User() {
    }

    public User(String fname,
            String lname, String cid, String email) {
        this.fname = fname;
        this.lname = lname;
        this.cid = cid;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }
    public String getCID(){
        return cid;
    }
    public void addBook(Book book){
        books.add(book);
    }
    public Book removeBook(Long id){
        return books.remove(id); 
    }
    public void updateBook(Book book){
        books.update(book);
    }
    public BookList getBooks(){
        return books;
    }
}
