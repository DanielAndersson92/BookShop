package group20.jsf.cb;
 
import group20.bookexchange.core.User;
import group20.jsf.mb.ExchangeBean;
import java.io.Serializable;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
 
 
/**
 * Simple login bean.
 *
 * @author itcuties
 */

@Named("loginBean")
@SessionScoped
public class LoginBean implements Serializable {
 
    private static final long serialVersionUID = 7765876811740798583L;
    
    @Inject
    private ExchangeBean bookExchange;
     
    private User user;
    private String cid;
    private String password;
     
    private boolean loggedIn;
     
    public String doLogin() {
        try{
            user = bookExchange.getUserRegistry().getByCID(cid);
            if (user.getPassword().equals(password)) {
                loggedIn = true;
                return "mypage";
            }

            // Set login ERROR
            FacesMessage msg = new FacesMessage("Login error!", "ERROR MSG");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, msg);

            // To to login page
            return "login";
        }
        catch(Exception e){
            FacesMessage msg = new FacesMessage("Login error!", "ERROR MSG");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, msg);
            
            return "login";
        }
    }
     
    public String doLogout() {
        loggedIn = false;
        //FacesContext.getCurrentInstance().getExternalContext().invalidateSession();       
        return "start";
    }
 
    // ------------------------------
    // Getters & Setters
     
    public User getUser(){ return user; }
    public String getCid() {
        return cid;
    }
 
    public void setCid(String cid) {
        this.cid = cid;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public boolean isLoggedIn() {
        return loggedIn;
    }
 
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

}