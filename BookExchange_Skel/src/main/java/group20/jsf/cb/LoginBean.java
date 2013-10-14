package group20.jsf.cb;
 
import group20.bookexchange.core.User;
import group20.jsf.mb.ExchangeBean;
import java.io.Serializable;
import java.util.logging.Logger;
 
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
 
    private static final Logger LOGGER = Logger.getLogger("InfoLogging");
    
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
        try{
            user = bookExchange.getUserRegistry().getByCID(cid);
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
        catch(Exception e){
            FacesMessage msg = new FacesMessage("Login error!", "ERROR MSG");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, msg);
            
            // To to login page
            return navigationBean.toLogin();
        }
    }
     
    /**
     * Logout operation.
     * @return
     */
    public String doLogout() {
        LOGGER.info("Nu loggar jag ut förihelvette!");
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();       
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