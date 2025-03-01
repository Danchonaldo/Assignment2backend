package org.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("vipService")
@Qualifier("vipService")
public class VIPTickets implements TicketService {
    private final TicketRepository repository;

    @Autowired
    public VIPTickets(TicketRepository repository){
        this.repository = repository;
    }
    @Override
    public void buyTickets(String match, String customer, int quantity) {
        for (int i = 0; i < quantity; i++) {
            repository.saveVipTicket(match, customer);
        }
        System.out.println(quantity + " ticket(s) purchased: " + match + " for " + customer);
    }

    @Override
    public void cancelTicket(String match, String customer) {
        repository.removeTicket(match, customer, true);
        System.out.println("VIP Ticket canceled: " + match + " for " + customer);
    }

    @Override
    public void listAllTickets() {
        System.out.println("All VIP Tickets: " + repository.getAllVipTickets());
    }
}
