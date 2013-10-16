/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.bookexchange.core;

import group20.bookexchange.pm.IPMController;

/**
 *
 * @author Daniel
 */
public interface IBookExchange {
    
    public IUserRegistry getUserRegistry();
    
    public IBookList getBookList();
    
    public IPMController getPMController();
}
