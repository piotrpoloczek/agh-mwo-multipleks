package pl.edu.agh.mwo.java1;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Utworzenie kina
        Cinema cinema1 = new Cinema("Super Tarasy", "ul. Akademicka 5");

        // Konfiguracja sali kinowej – tworzymy zbiór miejsc H1, H2, ... H50
        Set<String> hall1Seats = new HashSet<>();
        for (int i = 1; i <= 50; i++) {
            hall1Seats.add("H" + i);
        }
        CinemaHall hall1 = new CinemaHall("Sala 1", hall1Seats);

        // Utworzenie filmów
        Movie movie1 = new Movie("James Bond", 130);
        Movie movie2 = new Movie("Inception", 148);

        // Utworzenie seansów z przykładowymi datami
        LocalDateTime now = LocalDateTime.now();
        Screening screening1 = new Screening(movie1, hall1, now.plusDays(1).withHour(18).withMinute(30), ScreeningType.NORMAL);
        Screening screening2 = new Screening(movie2, hall1, now.plusDays(2).withHour(20).withMinute(0), ScreeningType.THREE_D);
        Screening screening3 = new Screening(movie1, hall1, now.plusDays(3).withHour(16).withMinute(15), ScreeningType.VIP);

        // Dodanie seansów do kina
        cinema1.addScreening(screening1);
        cinema1.addScreening(screening2);
        cinema1.addScreening(screening3);

        // Wyświetlenie repertuaru na najbliższy tydzień
        cinema1.printProgramme();

        // Przykładowe rezerwacje miejsc:
        // Rezerwacja anonimowa
        screening1.reservePlaces("H34", "H35", "H36");
        // Inna metoda rezerwacji anonimowej
        screening1.reservePlaces("H37", "H38");

        // Rezerwacja dla zarejestrowanego klienta
        Customer customer1 = new Customer("Jan Kowalski", "jan.kowalski@example.com");
        screening2.reservePlaces(customer1, "H20", "H21", "H22");

        // Wypisanie biletów klienta
        customer1.printTickets();

        // Przykładowe wyszukiwanie filmu
        Movie foundMovie = cinema1.findMovie("James Bon");
        if (foundMovie != null) {
            System.out.println("Znaleziono film: " + foundMovie.getTitle());
        }
    }
}
