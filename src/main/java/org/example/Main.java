package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        TicketService defaultTicketService = context.getBean("defaultService",TicketService.class);
        TicketService vipTicketService = context.getBean("vipService",TicketService.class);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an action: 1 - Buy Ticket, 2 - Cancel Ticket, 3 - View All, 4 - Exit");
            int action = scanner.nextInt();
            scanner.nextLine();  // Очистка буфера

            if (action == 4) break;  // Выход

            System.out.println("Enter match name:");
            String match = scanner.nextLine();

            System.out.println("Enter customer name:");
            String customer = scanner.nextLine();

            System.out.println("Choose ticket type: 1 - Regular, 2 - VIP");
            int choice = scanner.nextInt();

            boolean isVip = (choice == 2);

            if (action == 1) {
                System.out.println("Enter number of tickets:");
                int quantity = scanner.nextInt();
                if (isVip) {
                    vipTicketService.buyTickets(match, customer, quantity);
                } else {
                    defaultTicketService.buyTickets(match, customer, quantity);
                }
            } else if (action == 2) {
                if (isVip) {
                    vipTicketService.cancelTicket(match, customer);
                } else {
                    defaultTicketService.cancelTicket(match, customer);
                }
            } else if (action == 3) {
                defaultTicketService.listAllTickets();
                vipTicketService.listAllTickets();
                context.getBean(LazyBean.class);
            }
        }
    }
}