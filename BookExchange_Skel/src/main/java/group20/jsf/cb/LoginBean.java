package group20.jsf.cb;
 
import group20.bookexchange.core.User;
import group20.jsf.mb.ExchangeBean;
import java.io.Serializable;
 
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
 
 
/**
 * Simple login bean.
 *
 * @author itcuties
 */

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {
 
    private static final long serialVersionUID = 7765876811740798583L;
 
    // Simple user database :)
    private static final String[] users = {"anna:qazwsx","kate:123456"};
    
    @Inject
    private ExchangeBean bookExchange;
     
    private User user;
    private String cid;
    private String password;
     
    private boolean loggedIn;
 
    @ManagedProperty(value="#{navigationBean}")
    private NavigationBean navigationBean;
     
    /**
     * Login operation.
     * @return
     */
    public String doLogin() {
        user = bookExchange.getUserRegistry().getByCID(cid);
        
            // Successful login
        if (user.getPassword().equals(password)) {
            loggedIn = true;
            return navigationBean.redirectToMypage();
        }
         
        // Set login ERROR
        FacesMessage msg = new FacesMessage("Login error!", "ERROR MSG");
        msg.setSeverity(FacesMessage.SEVERITY_ERROR);
        FacesContext.getCurrentInstance().addMessage(null, msg);
         
        // To to login page
        return navigationBean.toLogin();
         
    }
     
    /**
     * Logout operation.
     * @return
     */
    public String doLogout() {
        // Set the paremeter indicating that user is logged in to false
        loggedIn = false;
         
        // Set logout message
        FacesMessage msg = new FacesMessage("Logout success!", "INFO MSG");
        msg.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(null, msg);
         
        return navigationBean.toIndex();
    }
 
    // ------------------------------
    // Getters & Setters
     
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
 
    public void setNavigationBean(NavigationBean navigationBean) {
        this.navigationBean = navigationBean;
    }
     
}