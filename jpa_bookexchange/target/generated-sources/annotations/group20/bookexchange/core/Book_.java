package group20.bookexchange.core;

import group20.bookexchange.core.Book.BookState;
import group20.bookexchange.core.User;
import group20.bookexchange.utils.AbstractEntity_;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-10-13T13:49:46")
@StaticMetamodel(Book.class)
public class Book_ extends AbstractEntity_ {

    public static volatile SingularAttribute<Book, String> course;
    public static volatile SingularAttribute<Book, String> author;
    public static volatile SingularAttribute<Book, String> title;
    public static volatile SingularAttribute<Book, Integer> price;
    public static volatile SingularAttribute<Book, Date> bookDate;
    public static volatile SingularAttribute<Book, User> owner;
    public static volatile SingularAttribute<Book, BookState> bookState;

}