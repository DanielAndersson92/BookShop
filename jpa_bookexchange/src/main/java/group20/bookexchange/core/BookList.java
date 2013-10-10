/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.bookexchange.core;

import group20.bookexchange.db.AbstractDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;



public class BookList extends AbstractDAO<Book,Long> implements IBookList {
    
    public BookList(String puName){
        super(Book.class, puName);
    }
    
    @Override
    public List<Book> getByTitle(String title){
        EntityManager em = getEMF().createEntityManager();
        List<Book> books;
        TypedQuery<Book> q = em.createQuery
                ("SELECT b FROM Book b WHERE b.title = '" + title + "'", Book.class);
        books = q.getResultList();
        em.close();
        return books;
    }
    @Override
    public List<Book> getByAuthor(String author){
        EntityManager em = getEMF().createEntityManager();
        List<Book> books;
        TypedQuery<Book> q = em.createQuery
                ("SELECT b FROM Book b WHERE b.author = '" + author + "'", Book.class);
        books = q.getResultList();
        em.close();
        return books;
    }
    @Override
    public List<Book> getByCourse(String course){
        EntityManager em = getEMF().createEntityManager();
        List<Book> books;
        TypedQuery<Book> q = em.createQuery
                ("SELECT b FROM Book b WHERE b.course = '" + course + "'", Book.class);
        books = q.getResultList();
        em.close();
        return books;
    }
    public List<Book> getByState(Book.BookState bookState){
        EntityManager em = getEMF().createEntityManager();
        List<Book> books;
        TypedQuery<Book> q = em.createQuery
                ("SELECT b FROM Book b WHERE b.bookState = '" + bookState + "'", Book.class);
        books = q.getResultList();
        em.close();
        return books;
    }
}
