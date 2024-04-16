package org.example.dao;

import org.example.entities.Ticket;
import org.example.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Objects;

public class TicketDaoImpl implements TicketDao {
    private SessionFactory sessionFactory = HibernateUtil.getINSTANCE().getSessionFactory();

    @Override
    public boolean save(Ticket ticket) {
        boolean result = false;
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            try {
                ticket.setId(null);
                session.persist(ticket);
                tx.commit();
                result = true;
            }catch (Exception ex){
                ex.printStackTrace();
                tx.rollback();
            }
        }
        return result;
    }

    @Override
    public Ticket findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Ticket.class, id);
        }
    }

    @Override
    public List<Ticket> getAllTickets() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Ticket", Ticket.class).list();
        }
    }

    @Override
    public boolean update(Ticket ticket) {
        boolean result =false;
        if (Objects.isNull(ticket.getId())) {
            return false;
        }
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            try {
                session.merge(ticket);
                tx.commit();
                result = true;
            }catch (Exception ex){
                ex.printStackTrace();
                tx.rollback();
            }
        }
        return result;
    }

    @Override
    public boolean delete(Ticket ticket) {
        boolean result = false;
        if (Objects.isNull(ticket.getId())) {
            return false;
        }
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            try {
                session.remove(ticket);
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
