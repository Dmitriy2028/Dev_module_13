package org.example.services;

import org.example.dao.TicketDao;
import org.example.dao.TicketDaoImpl;
import org.example.entities.Ticket;

import java.util.List;

public class TicketCrudService {
    private TicketDao ticketDao = new TicketDaoImpl();

    public void saveTicket(Ticket ticket) {
        ticketDao.save(ticket);
    }

    public Ticket findTicketById(Long id) {
        return ticketDao.findById(id);
    }

    public List<Ticket> getAllTickets () {return ticketDao.getAllTickets();}

    public void updateTicket(Ticket ticket) {
        ticketDao.update(ticket);
    }

    public void deleteTicket(Ticket ticket) {
        ticketDao.delete(ticket);
    }
}
