package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import modelo.Kebab;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KebabDAO {
    private EntityManagerFactory emf;

    public KebabDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void insertarKebab(Kebab k) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(k);
        em.getTransaction().commit();
        em.close();
    }

    public void actualizarKebab(Kebab k) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Kebab kb = em.find(Kebab.class, k.getId());
        if (kb != null) {
            kb.setTipoPan(k.getTipoPan());
            kb.setCantidad(k.getCantidad());
            kb.setPrecio(k.getPrecio());
            kb.setTieneCosas(k.isTieneCosas());
        }
        em.getTransaction().commit();
        em.close();
    }

    public void borrarKebab(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Kebab kb = em.find(Kebab.class, id);
        if (kb != null) {
            em.remove(kb);
        }
        em.getTransaction().commit();
        em.close();
    }

    public Kebab obtenerKebab(int id) {
        EntityManager em = emf.createEntityManager();
        Kebab kb = em.find(Kebab.class, id);
        em.close();
        return kb;
    }

    public List<Kebab> obtenerKebabs() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Kebab> query = em.createQuery("select k from Kebab k", Kebab.class);
        List<Kebab> res = query.getResultList();
        em.close();
        return res;
    }

    public double obtenerMedia() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Double> query = em.createQuery("select avg(k.precio) from Kebab k", Double.class);
        double media = query.getSingleResult();
        em.close();
        return media;
    }

    public long obtenerTotalKebabs() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Long> query = em.createQuery("select count(k) from Kebab k", Long.class);
        long total = query.getSingleResult();
        em.close();
        return total;
    }

    public Map<String, Long> obtenerGruposPan() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Object[]> query = em.createQuery("select k.tipoPan, count(k) from Kebab k group by k.tipoPan", Object[].class);
        List<Object[]> gruposPan = query.getResultList();
        Map<String, Long> gruposPanMap = new HashMap<>();
        for (Object[] fila: gruposPan) {
            String tipoPan = (String) fila[0];
            long cuenta = (long) fila[1];
            gruposPanMap.put(tipoPan, cuenta);
        }
        em.close();
        return gruposPanMap;
    }
}
