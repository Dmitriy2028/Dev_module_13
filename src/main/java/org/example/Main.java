package org.example;

import org.example.entities.Client;
import org.example.entities.Planet;
import org.example.entities.Ticket;
import org.example.hibernate.HibernateUtil;
import org.example.services.ClientCrudService;
import org.example.services.PlanetCrudService;
import org.example.services.TicketCrudService;
import org.hibernate.Session;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        //Didn't delete ccs and pcs to see if relations on delete will work correctly
        Session session = HibernateUtil.getINSTANCE().getSessionFactory().openSession();
        ClientCrudService ccs = new ClientCrudService();
        PlanetCrudService pcs = new PlanetCrudService();
        TicketCrudService tcs = new TicketCrudService();
        clientCrud(ccs);
        planetCrud(pcs);
        ticketCrud(tcs);
        session.close();
    }

    public static void clientCrud(ClientCrudService ccs) {

        //create new client
        Client newClient = new Client();
        newClient.setName("New Client");
        ccs.saveClient(newClient);
        System.out.printf("\nCreate new Client with id: %s and name: %s\n", newClient.getId(), newClient.getName());

        //get client by id
        Client client = ccs.findClientById(5L);
        System.out.println("Get client by id 5: " + client);

        //get all clients
        List<Client> clients = ccs.getAllClients();
        clients.forEach(allClient -> System.out.println("Client list ==> " + allClient));

        //update client
        client.setName("Updated Client");
        ccs.updateClient(client);
        System.out.println("Update Client by id 5 to " + client.getName());

        ccs.deleteClient(client);
        System.out.println("Delete client: " + client);

    }

    public static void planetCrud(PlanetCrudService pcs) {

        //create new planet
        Planet newPlanet = new Planet();
        newPlanet.setId("NEW");
        newPlanet.setName("Mercury");
        pcs.savePlanet(newPlanet);
        System.out.printf("\nCreated planet: %s\n", newPlanet);

        //get planet by id
        Planet planet = pcs.findPlanetById("NEW");
        System.out.println("Result by planet id NEW: " + planet.getName());

        //get all planets
        List<Planet> planets = pcs.getAllPlanets();
        planets.forEach(allPlanets -> System.out.println("Planets list ==> " + allPlanets));

        //update planet
        planet.setName("Pluto");
        pcs.updatePlanet(planet);
        System.out.println("Update planet by Id NEW to name Pluto");

        //delete planet
        pcs.deletePlanet(planet);
        System.out.println("Delete planet: " + planet);

        planet = pcs.findPlanetById("SAT6");
        pcs.deletePlanet(planet);
        System.out.println("Delete planet: " + planet);
    }

    public static void ticketCrud(TicketCrudService tcs) {

        //create new ticket
        Ticket newTicket = new Ticket();
        newTicket.setClient(new ClientCrudService().findClientById(1L));
        newTicket.setFromPlanet(new PlanetCrudService().findPlanetById("EARTH3"));
        newTicket.setToPlanet(new PlanetCrudService().findPlanetById("MARS4"));
        tcs.saveTicket(newTicket);
        System.out.printf("\nCreated ticket: %s\n", newTicket);

        //get ticket by id
        Ticket ticket = tcs.findTicketById(5L);
        System.out.println("Result by ticket id 5: " + ticket);

        //get all tickets
        List<Ticket> tickets = tcs.getAllTickets();
        tickets.forEach(allTickets -> System.out.println("Tickets list ==> " + allTickets));

        //update ticket
        ticket = tcs.findTicketById(31L);
        ticket.setToPlanet(new PlanetCrudService().findPlanetById("JUP5"));
        tcs.updateTicket(ticket);
        System.out.println("Updated ticket by Id 5:" + ticket);

        //delete ticket
        tcs.deleteTicket(ticket);
        System.out.println("Delete ticket: " + ticket);
    }

}