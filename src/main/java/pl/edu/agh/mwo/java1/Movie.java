package pl.edu.agh.mwo.java1;

public class Movie {
    private String title;
    private int duration; // czas trwania w minutach

    public Movie(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }
}
