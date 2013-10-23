package group20.bookexchange.core;

import group20.bookexchange.utils.AbstractEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/*
 * User represents a user in the system.
 * @author Patrik
 */
@Entity
@Table(name = "bookUser")
public class User extends AbstractEntity {

    private String fname;
    private String lname;
    @Column(unique=true)
    private String cid;
    private String email;
    private String password;

    public User() {
    }

    public User(String fname,
            String lname, String cid, String email, String password) {
        this.fname = fname;
        this.lname = lname;
        this.cid = cid;
        this.email = email;
        this.password = password;
    }
    public User(Long id, String fname,
            String lname, String cid, String email, String password) {
        super(id);
        this.fname = fname;
        this.lname = lname;
        this.cid = cid;
        this.email = email;
        this.password = password;
    }

    public String getEmail() { return email; }
    public String getFname() { return fname; }
    public String getLname() { return lname; }
    public String getCID(){ return cid; }
    public String getPassword(){ return password; }
}
