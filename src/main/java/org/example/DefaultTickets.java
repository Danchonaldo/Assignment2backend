package org.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("defaultService")
@Primary
public class DefaultTickets implements TicketService {
    private final TicketRepository repository;

    @Autowired
    public DefaultTickets(TicketRepository repository){
        this.repository = repository;
    }
    @Override
    public void buyTickets(String match, String customer, int quantity) {
        for (int i = 0; i < quantity; i++) {
            repository.saveDefaultTicket(match, customer);
        }
        System.out.println(quantity + " ticket(s) purchased: " + match + " for " + customer);
    }

    @Override
    public void cancelTicket(String match, String customer) {
        repository.removeTicket(match, customer, false);
        System.out.println("Regular ticket canceled: " + match + " for " + customer);
    }

    @Override
    public void listAllTickets() {
        System.out.println("All Tickets: " + repository.getAllDefaultTickets());
    }
}
