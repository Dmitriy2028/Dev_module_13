package org.example.dao;

import org.example.entities.Planet;
import org.example.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class PlanetDaoImpl implements PlanetDao {
    private SessionFactory sessionFactory = HibernateUtil.getINSTANCE().getSessionFactory();

    //Create
    @Override
    public boolean save(Planet planet){
        boolean result = false;
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            try {
                session.persist(planet);
                tx.commit();
                result = true;
            }catch (Exception ex){
                ex.printStackTrace();
                tx.rollback();
            }
        }
        return result;
    }

    //Read
    @Override
    public Planet findById(String id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Planet.class, id);
        }
    }

    @Override
    public List<Planet> getAllPlanets () {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Planet", Planet.class).list();
        }
    }

    //Update
    @Override
    public boolean update(Planet planet) {
        boolean result = false;
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            try {
                session.merge(planet);
                tx.commit();
                result = true;
            }catch (Exception ex){
                ex.printStackTrace();
                tx.rollback();
            }
        }
        return result;
    }

    //Delete
    @Override
    public boolean delete(Planet planet) {
        boolean result = false;
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            try {
                session.remove(planet);
                tx.commit();
                result = true;
            }catch (Exception ex){
                ex.printStackTrace();
                tx.rollback();
            }
        }
        return result;
    }
}
