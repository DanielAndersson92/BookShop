/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.jsf.bb;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Patrik
 */
@Named("pmBB")
@SessionScoped
public class PmBB implements Serializable{

    private String reciever;
    private String message;
    
    public void setReciever(String reciever){ this.reciever = reciever; }
    public String getReciever(){ return reciever; }
    
    public void setMessage(String message){ this.message = message; }
    public String getMessage(){ return message; }
}
