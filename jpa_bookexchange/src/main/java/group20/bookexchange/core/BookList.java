package group20.bookexchange.core;

import group20.bookexchange.db.AbstractDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 * BookList is the database connection for the Book object. 
 * @author Patrik
 */
public class BookList extends AbstractDAO<Book,Long> implements IBookList {
    
    public BookList(String puName){
        super(Book.class, puName);
    }
    
    @Override
    public List<Book> getByTitle(String title){
        title = title.toLowerCase();
        EntityManager em = getEMF().createEntityManager();
        List<Book> books;
        TypedQuery<Book> q = em.createQuery
                ("SELECT b FROM Book b WHERE LOWER(b.title) LIKE '%" + title + "%'", Book.class);
        books = q.getResultList();
        em.close();
        return books;
    }
    @Override
    public List<Book> getByAuthor(String author){
        author = author.toLowerCase();
        EntityManager em = getEMF().createEntityManager();
        List<Book> books;
        TypedQuery<Book> q = em.createQuery
                ("SELECT b FROM Book b WHERE LOWER(b.author) LIKE '%" + author + "%'", Book.class);
        books = q.getResultList();
        em.close();
        return books;
    }
    @Override
    public List<Book> getByCourse(String course){
        course = course.toLowerCase();
        EntityManager em = getEMF().createEntityManager();
        List<Book> books;
        TypedQuery<Book> q = em.createQuery
                ("SELECT b FROM Book b WHERE LOWER(b.course) LIKE '%" + course + "%'", Book.class);
        books = q.getResultList();
        em.close();
        return books;
    }
    @Override
    public List<Book> getByState(Book.BookState bookState){
        EntityManager em = getEMF().createEntityManager();
        List<Book> books;
        TypedQuery<Book> q = em.createQuery
                ("SELECT b FROM Book b WHERE b.bookState = :BOKS", Book.class).
                setParameter("BOKS", bookState.toString());
        books = q.getResultList();
        em.close();
        return books;
    }
    @Override
    public List<Book> getByUser(User user){
        EntityManager em = getEMF().createEntityManager();
        List<Book> books;
        TypedQuery<Book> q = em.createQuery
                ("SELECT b FROM Book b WHERE b.owner.id = '" + user.getId() + "'", Book.class);
        books = q.getResultList();
        em.close();
        return books;
    }
    /**
     * Returns the N latest books with X as state.
     * @param nrOfBooks N
     * @param bookState X
     * @return 
     */
    @Override
    public List<Book> getRangeDate(Integer nrOfBooks, Book.BookState bookState){
        EntityManager em = getEMF().createEntityManager();
        List<Book> books;
        TypedQuery<Book> q = em.createQuery
                ("SELECT b FROM Book AS b"
                + " WHERE b.bookState = :BOKS"
                + " ORDER BY b.bookDate DESC", Book.class).
                setParameter("BOKS", bookState);
                 
        q.setMaxResults(nrOfBooks);
        books = q.getResultList();
        em.close();
        return books;
    }
}
