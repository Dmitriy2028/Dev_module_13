package org.example.dao;

import org.example.entities.Client;
import org.example.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Objects;

public class ClientDaoImpl implements ClientDao {
    private SessionFactory sessionFactory = HibernateUtil.getINSTANCE().getSessionFactory();

    //Create
    @Override
    public boolean save(Client client){
        boolean result = false;
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            try {
                client.setId(null);
                session.persist(client);
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
    public Client findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Client.class, id);
        }
    }

    @Override
    public List<Client> getAllClients () {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Client", Client.class).list();
        }
    }

    //Update
    @Override
    public boolean update(Client client) {
        boolean result =false;
        if (Objects.isNull(client.getId())) {
            return false;
        }
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            try {
                session.merge(client);
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
    public boolean delete(Client client) {
        boolean result = false;
        if (Objects.isNull(client.getId())) {
            return false;
        }
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            try {
                session.remove(client);
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
