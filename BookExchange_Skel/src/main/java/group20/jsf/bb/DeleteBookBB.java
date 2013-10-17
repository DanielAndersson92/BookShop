/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.jsf.bb;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;


/**
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
