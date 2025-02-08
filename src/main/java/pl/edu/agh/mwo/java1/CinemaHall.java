package pl.edu.agh.mwo.java1;

import java.util.Set;

public class CinemaHall {
    private String name;
    private Set<String> seats;

    public CinemaHall(String name, Set<String> seats) {
        this.name = name;
        this.seats = seats;
    }

    public String getName() {
        return name;
    }

    // Sprawdza, czy dane miejsce istnieje w sali
    public boolean isValidSeat(String seat) {
        return seats.contains(seat);
    }

    public Set<String> getSeats() {
        return seats;
    }
}
