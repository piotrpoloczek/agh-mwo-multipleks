package pl.edu.agh.mwo.java1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Cinema {
    private String name;
    private String address;
    private List<Screening> screenings;

    public Cinema(String name, String address) {
        this.name = name;
        this.address = address;
        this.screenings = new ArrayList<>();
    }

    // Dodaje seans do repertuaru kina
    public void addScreening(Screening screening) {
        screenings.add(screening);
    }

    // Zwraca seanse w formie tablicy
    public Screening[] getScreenings() {
        return screenings.toArray(new Screening[0]);
    }

    // Wypisuje repertuar seansów zaplanowanych na najbliższy tydzień
    public void printProgramme() {
        System.out.println("Program kina " + name + " (" + address + "):");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime oneWeekLater = now.plusDays(7);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        for (Screening screening : screenings) {
            if (screening.getStartTime().isAfter(now) && screening.getStartTime().isBefore(oneWeekLater)) {
                System.out.println("Film: " + screening.getMovie().getTitle() +
                        ", Sala: " + screening.getHall().getName() +
                        ", Godzina: " + screening.getStartTime().format(formatter) +
                        ", Typ seansu: " + screening.getType());
            }
        }
    }

    // Wyszukuje film na podstawie fragmentu tytułu – przegląda seanse i zwraca pierwszy pasujący film
    public Movie findMovie(String title) {
        for (Screening screening : screenings) {
            if (screening.getMovie().getTitle().toLowerCase().contains(title.toLowerCase())) {
                return screening.getMovie();
            }
        }
        System.out.println("Film o tytule '" + title + "' nie został znaleziony.");
        return null;
    }
}
