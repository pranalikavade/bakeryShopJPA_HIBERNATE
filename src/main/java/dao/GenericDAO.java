package dao;
import jakarta.persistence.*;
import config.JPAUtil;
import java.util.List;

public class GenericDAO<T> {
    private Class<T> clazz;
    public GenericDAO(Class<T> clazz) { this.clazz = clazz; }

    public void create(T e) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        em.close();
    }
    public T find(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        T e = em.find(clazz, id);
        em.close();
        return e;
    }
    public List<T> findAll() {
        EntityManager em = JPAUtil.getEntityManager();
        List<T> list = em.createQuery("FROM " + clazz.getSimpleName(), clazz).getResultList();
        em.close();
        return list;
    }
    public void update(T e) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(e);
        em.getTransaction().commit();
        em.close();
    }
    public void delete(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        T e = em.find(clazz, id);
        if (e != null) em.remove(e);
        em.getTransaction().commit();
        em.close();
    }
}
