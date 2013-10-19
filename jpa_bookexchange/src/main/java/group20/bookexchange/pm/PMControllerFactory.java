/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.bookexchange.pm;


/**
 *
 * @author Patrik
 */
public class PMControllerFactory {
    public static IPMController getBookList() {
        return new PMController("BookExchange");
    }
}
