/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.bookexchange.pm;

/**
 *
 * @author Patrik
 */
public class PMController implements IPMController{
    
    private IConversationsList conversationsList;
    
    public PMController(String puName){
        conversationsList = new ConversationsList(puName);
    }
    
    @Override
    public IConversationsList getConversationsList() {
        return conversationsList;
    }
    
}
