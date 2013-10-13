package group20.bookexchange.forum;

import group20.bookexchange.core.User;
import group20.bookexchange.utils.AbstractEntity_;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2013-10-13T13:49:46")
@StaticMetamodel(Post.class)
public class Post_ extends AbstractEntity_ {

    public static volatile SingularAttribute<Post, String> message;
    public static volatile SingularAttribute<Post, User> author;
    public static volatile SingularAttribute<Post, Date> postDate;

}