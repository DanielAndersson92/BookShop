
package group20.bookexchange.utils;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Base class for all entities (later to be stored in database), 
 * Product, Order, etc
 * @author hajo
 */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable{

    @Id
    @GeneratedValue
    private Long id; 
   
    protected AbstractEntity(){

    }
    protected AbstractEntity(Long id){
        this.id = id;
    }
    
    public Long getId(){
        return id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AbstractEntity other = (AbstractEntity) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
