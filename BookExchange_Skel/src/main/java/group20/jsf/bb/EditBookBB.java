package group20.jsf.bb;

import group20.bookexchange.core.Book;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;


/**
 * Backing bean for editBook.xhtml
 *
 * @author alexandralazic
 */
@Named("editBook")
@ConversationScoped
public class EditBookBB extends Conversational{

    @Override
    protected void execute() {
        Book b = new Book(getId(), getTitle(), getAuthor(), 
                Integer.parseInt(getPrice()), getUser(), getCourse(), 
                getState(), getDate(), getDescr());
        getBookList().update(b);
    }

}
