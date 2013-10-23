package group20.jsf.utils;

import group20.jsf.cb.*;
import java.io.IOException;
import javax.inject.Inject;
 
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
/**
 * Filter checks if LoginBean has loginIn property set to true.
 * If it is not set then request is being redirected to the login.xhml page.
 *
 * @author Daniel
 *
 */
public class LoginFilter implements Filter {
    @Inject
    private LoginBean loginBean;
 
    /**
     * Checks if user is logged in. If not it redirects to the login.xhtml page.
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (loginBean == null || !loginBean.isLoggedIn()) {
            String contextPath = ((HttpServletRequest)request).getContextPath();
            ((HttpServletResponse)response).sendRedirect(contextPath + "/jsf/Login/login.xhtml");
        }
        chain.doFilter(request, response);
             
    }
    @Override
    public void init(FilterConfig config) throws ServletException {}//Not in use
    
    @Override
    public void destroy() {}//Not in use  
     
}