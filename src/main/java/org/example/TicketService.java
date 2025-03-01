package org.example;

public interface TicketService {
    void buyTickets(String match, String customer, int quantity);
    void cancelTicket(String match, String customer);
    void listAllTickets();
}
