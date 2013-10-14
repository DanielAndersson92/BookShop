/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.jsf.bb;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


/**
 *
 * @author Patrik
 */
@Named("registerBB")
@RequestScoped
public class RegisterBB implements Serializable{

    private static final Logger LOGGER = Logger.getLogger("InfoLogging");
    
    private String fname;
    private String lname;
    private String cid;
    private String email;
    private String password;
    private String confirmPassword;
    
    public void setFname(String fname){ 
        this.fname = fname;
        LOGGER.info(fname);
    }
    public String getFname() { return fname; }
    
    public void setLname(String lname){ this.lname = lname;
        LOGGER.info(lname);
    }
    public String getLname() { return lname; }
    
    public void setCID(String cid){ this.cid = cid; 
        LOGGER.info(cid);
    }
    public String getCID() { return cid; }
    
    public void setEmail(String email){ this.email = email; 
        LOGGER.info(email);
    }
    public String getEmail() { return email; }
    
    public void setPassword(String password){ this.password = password; 
    LOGGER.info(password);}
    public String getPassword() { return password; }
    
    public void setConfirmPassword(String confirmPassword){ this.confirmPassword = confirmPassword; 
    LOGGER.info(confirmPassword);}
    public String getConfirmPassword() { return confirmPassword; }
}