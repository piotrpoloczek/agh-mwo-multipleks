package pl.edu.agh.mwo.java1;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String email;
    private List<Ticket> tickets;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
        this.tickets = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    // Dodaje bilet do listy posiadanych przez klienta
    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    // Wypisuje wszystkie bilety przypisane do klienta
    public void printTickets() {
        System.out.println("Bilety klienta " + name + ":");
        for (Ticket ticket : tickets) {
            System.out.println(ticket.getDetails());
        }
    }
}
