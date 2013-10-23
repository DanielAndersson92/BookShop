/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.bookexchange.pm;


/**
 * Produced a PMController.
 * @author Patrik
 */
public class PMControllerFactory {
    public static IPMController getBookList() {
        return new PMController("BookExchange");
    }
}
