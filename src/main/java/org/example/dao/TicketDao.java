package org.example.dao;

import org.example.entities.Ticket;

import java.util.List;

public interface TicketDao {
    boolean save(Ticket ticket);
    Ticket findById(Long id);
    List<Ticket> getAllTickets ();
    boolean update(Ticket ticket);
    boolean delete(Ticket ticket);
}
