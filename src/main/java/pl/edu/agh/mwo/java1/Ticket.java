package pl.edu.agh.mwo.java1;

import java.time.format.DateTimeFormatter;

public class Ticket {
    private Screening screening;
    private String seat;
    private Customer customer;  // może być null przy rezerwacji anonimowej

    public Ticket(Screening screening, String seat, Customer customer) {
        this.screening = screening;
        this.seat = seat;
        this.customer = customer;
    }

    // Zwraca szczegółowy opis biletu
    public String getDetails() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String detail = "Film: " + screening.getMovie().getTitle() +
                ", Sala: " + screening.getHall().getName() +
                ", Godzina: " + screening.getStartTime().format(formatter) +
                ", Miejsce: " + seat;
        if (customer != null) {
            detail += ", Klient: " + customer.getName();
        }
        return detail;
    }
}
