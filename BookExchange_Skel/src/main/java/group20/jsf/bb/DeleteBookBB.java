package group20.jsf.bb;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;


/**
 * Backing bean for deleteBook.xhtml
 *
 * @author alexandralazic
 */
@Named("deleteBook")
@ConversationScoped
public class DeleteBookBB extends Conversational{
    
    @Override
    protected void execute() {
        Long id = getId();
        getBookList().remove(id);    
    }
}
