package org.example;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TicketRepository {
    private final Map<String, List<String>> defaultTickets = new HashMap<>();
    private final Map<String, List<String>> vipTickets = new HashMap<>();

    public void saveDefaultTicket(String match, String customer) {
        if (!defaultTickets.containsKey(match)) {
            defaultTickets.put(match, new ArrayList<>());
        }
        defaultTickets.get(match).add(customer);
    }

    public void saveVipTicket(String match, String customer) {
        if (!vipTickets.containsKey(match)) {
            vipTickets.put(match, new ArrayList<>());
        }
        vipTickets.get(match).add(customer);
    }

    public void removeTicket(String match, String customer, boolean isVip) {
        Map<String, List<String>> tickets = isVip ? vipTickets : defaultTickets;

        List<String> matchTickets = tickets.get(match);

        if (matchTickets != null) {
            matchTickets.remove(customer);

            if (matchTickets.isEmpty()) {
                tickets.remove(match);
            }
        }
    }

    public Map<String, List<String>> getAllDefaultTickets() {
        return defaultTickets;
    }

    public Map<String, List<String>> getAllVipTickets() {
        return vipTickets;
    }
}

