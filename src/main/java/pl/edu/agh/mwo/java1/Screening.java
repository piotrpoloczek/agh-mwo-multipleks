package pl.edu.agh.mwo.java1;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Screening {
    private Movie movie;
    private CinemaHall hall;
    private LocalDateTime startTime;
    private ScreeningType type;
    // Mapa przechowująca zarezerwowane miejsca (klucz: numer miejsca, wartość: bilet)
    private Map<String, Ticket> reservedSeats;

    public Screening(Movie movie, CinemaHall hall, LocalDateTime startTime, ScreeningType type) {
        this.movie = movie;
        this.hall = hall;
        this.startTime = startTime;
        this.type = type;
        this.reservedSeats = new HashMap<>();
    }

    public Movie getMovie() {
        return movie;
    }

    public CinemaHall getHall() {
        return hall;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public ScreeningType getType() {
        return type;
    }

    // Metoda rezerwacji miejsc bez przypisywania do konta (anonimowo)
    public void reservePlaces(String... seatNumbers) {
        reservePlaces(null, seatNumbers);
    }

    // Przeciążona metoda rezerwacji miejsc – dla zarejestrowanego klienta
    public void reservePlaces(Customer customer, String... seatNumbers) {
        for (String seat : seatNumbers) {
            if (!hall.isValidSeat(seat)) {
                System.out.println("Miejsce " + seat + " nie istnieje w sali " + hall.getName());
                continue;
            }
            if (reservedSeats.containsKey(seat)) {
                System.out.println("Miejsce " + seat + " jest już zarezerwowane.");
                continue;
            }
            Ticket ticket = new Ticket(this, seat, customer);
            reservedSeats.put(seat, ticket);
            if (customer != null) {
                customer.addTicket(ticket);
            }
            System.out.println("Miejsce " + seat + " zarezerwowane pomyślnie" +
                    (customer != null ? " dla klienta " + customer.getName() : "") + ".");
        }
    }

    // Zwraca kolekcję zarezerwowanych biletów
    public Collection<Ticket> getReservedTickets() {
        return reservedSeats.values();
    }
}
