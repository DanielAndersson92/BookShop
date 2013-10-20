/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.jsf.bb;

import group20.bookexchange.core.Book;
import java.util.logging.Logger;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;


/**
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
