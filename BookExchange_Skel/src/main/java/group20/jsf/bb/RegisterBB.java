/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.jsf.bb;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


/**
 * The backing bean for register.xhtml
 * @author Patrik
 */
@Named("registerBB")
@RequestScoped
public class RegisterBB implements Serializable{
    
    private String fname;
    private String lname;
    private String cid;
    private String email;
    private String password;
    private String confirmPassword;
    
    public void setFname(String fname){ this.fname = fname; }
    public String getFname() { return fname; }
    
    public void setLname(String lname){ this.lname = lname; }
    public String getLname() { return lname; }
    
    public void setCID(String cid){ this.cid = cid; }
    public String getCID() { return cid; }
    
    public void setEmail(String email){ this.email = email; }
    public String getEmail() { return email; }
    
    public void setPassword(String password){ this.password = password; }
    public String getPassword() { return password; }
    
    public void setConfirmPassword(String confirmPassword){ this.confirmPassword = confirmPassword; }
    public String getConfirmPassword() { return confirmPassword; }
}