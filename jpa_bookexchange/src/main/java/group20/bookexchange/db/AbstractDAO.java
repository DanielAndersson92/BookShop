package group20.bookexchange.db;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public abstract class AbstractDAO<T, K>
        implements IDAO<T, K> {

    private EntityManagerFactory emf;
    private final Class<T> clazz;

    protected AbstractDAO(Class<T> clazz, String puName){
        this.clazz = clazz;
        emf = Persistence.createEntityManagerFactory(puName);
    }
    
    public EntityManagerFactory getEMF(){
        return emf;
    }
    
    @Override
    public void add(T t) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(t);
        tx.commit();
        em.close();
    }

    @Override
    public T remove(K id) {
        EntityManager em = null;
        T t = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            t = em.getReference(clazz, id);
            em.remove(t);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return t;
    }
    @Override
    public T update(T t) {
        EntityManager em = null;
        T ut = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            ut = em.merge(t);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return ut;
    }

    @Override
    public T find(K id) {
        EntityManager em = emf.createEntityManager();
        T t = em.find(clazz, id);
        return t;
    }

    @Override
    public List<T> getRange(int first, int nItems) {
        EntityManager em = emf.createEntityManager();
        List<T> items = new ArrayList<>();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(clazz));
            Query q = em.createQuery(cq);
            q.setMaxResults(nItems);
            q.setFirstResult(first);
            items.addAll(q.getResultList());
        } finally {
            em.close();
        }
        return items;
    }

    @Override
    public int getCount() {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder qb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = qb.createQuery(Long.class);
        cq.select(qb.count(cq.from(clazz)));
        int r = (em.createQuery(cq).getSingleResult()).intValue();
        em.close();
        return r;
        
    }
}
