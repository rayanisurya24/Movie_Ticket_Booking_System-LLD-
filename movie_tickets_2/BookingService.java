import java.util.*;

public class BookingService {
    private static BookingService instance = null;
    private Map<String, Movie> movies;
    private Map<String, Multiplex> multiplexes;
    private Map<String, Show> shows;
    private Map<String, Booking> bookings;

    private BookingService() {
        movies = new HashMap<>();
        multiplexes = new HashMap<>();
        shows = new HashMap<>();
        bookings = new HashMap<>();
    }

    public static BookingService getInstance() {
        if (instance == null) {
            instance = new BookingService();
        }
        return instance;
    }

    public void addMovie(Movie movie) {
        movies.put(movie.getId(), movie);
    }

    public void addMultiplex(Multiplex multiplex) {
        multiplexes.put(multiplex.getId(), multiplex);
    }

    public void addShow(Show show) {
        shows.put(show.getId(), show);
    }

    public void addBooking(Booking booking) {
        bookings.put(booking.getId(), booking);
    }

    public Movie getMovie(String movieId) {
        return movies.get(movieId);
    }

    public Multiplex getMultiplex(String multiplexId) {
        return multiplexes.get(multiplexId);
    }

    public Show getShow(String showId) {
        return shows.get(showId);
    }

    public Booking getBooking(String bookingId) {
        return bookings.get(bookingId);
    }

    public List<Movie> searchMoviesByName(String movieName) {
        List<Movie> results = new ArrayList<>();
        for (Movie movie : movies.values()) {
            if (movie.getName().toLowerCase().contains(movieName.toLowerCase())) {
                results.add(movie);
            }
        }
        return results;
    }

    public List<Multiplex> searchMultiplexesByName(String multiplexName) {
        List<Multiplex> results = new ArrayList<>();
        for (Multiplex multiplex : multiplexes.values()) {
            if (multiplex.getName().toLowerCase().contains(multiplexName.toLowerCase())) {
                results.add(multiplex);
            }
        }
        return results;
    }

    public boolean checkSeatAvailability(Show show, List<Seat> seats) {
        for (Seat seat : seats) {
            if (!show.getAvailableSeats().contains(seat)) {
                return false;
            }
        }
        return true;
    }

    public Booking bookSeats(User user, Show show, List<Seat> seats) {
        if (checkSeatAvailability(show, seats)) {
            double totalAmount = seats.stream().mapToDouble(Seat::getPrice).sum();
            Booking booking = new Booking(user, show, seats, totalAmount);
            show.getReservedSeats().addAll(seats);
            addBooking(booking);
            return booking;
        }
        return null; // If seats are not available
    }

    public void confirmBooking(String bookingId) {
        Booking booking = bookings.get(bookingId);
        if (booking != null && booking.getBookingStatus() == BookingStatus.PENDING) {
            booking.setBookingStatus(BookingStatus.CONFIRMED);
        }
    }

    public Map<String, Booking> getBookings() {
        return bookings;
    }
}
