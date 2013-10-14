/*
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package group20.bookexchange.core;

import group20.bookexchange.utils.AbstractEntity;
import javax.persistence.Entity;
import javax.persistence.Table;

/*
 *
 * @author Daniel
 */
@Entity
@Table(name = "bookUser")
public class User extends AbstractEntity {

    private String fname;
    private String lname;
    private String cid;
    private String email;
    private String password;

    public User() {
    }

    public User(String fname,
            String lname, String cid, String email) {
        this.fname = fname;
        this.lname = lname;
        this.cid = cid;
        this.email = email;
    }
    public User(Long id, String fname,
            String lname, String cid, String email) {
        super(id);
        this.fname = fname;
        this.lname = lname;
        this.cid = cid;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }
    public String getCID(){
        return cid;
    }
    public String getPassword(){
        return password;
    }
}
