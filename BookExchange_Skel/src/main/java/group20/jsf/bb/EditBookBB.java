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
@Named("editBook")
@ConversationScoped
public class EditBookBB extends Conversational{

    @Override
    protected void execute() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
