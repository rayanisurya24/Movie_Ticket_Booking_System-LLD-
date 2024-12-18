import java.util.ArrayList;
import java.util.List;

public class Show {
    private String id;
    private Movie movie;
    private String showTime;
    private Screen screen;
    private List<Seat> availableSeats;
    private List<Seat> reservedSeats;

    public Show(String id, Movie movie, String showTime, Screen screen) {
        this.id = id;
        this.movie = movie;
        this.showTime = showTime;
        this.screen = screen;
        this.availableSeats = new ArrayList<>(screen.getAvailableSeats());
        this.reservedSeats = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public Movie getMovie() {
        return movie;
    }

    public String getShowTime() {
        return showTime;
    }

    public Screen getScreen() {
        return screen;
    }

    public List<Seat> getAvailableSeats() {
        return availableSeats;
    }

    public List<Seat> getReservedSeats() {
        return reservedSeats;
    }
}
