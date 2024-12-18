import java.util.List;

public class BookingServiceDemo {
    public static void main(String[] args) {
        BookingService bookingService = BookingService.getInstance();

        Movie movie1 = new Movie("Avengers: Endgame", "English", "Action", "2019-04-26", 181);
        Movie movie2 = new Movie("The Lion King", "English", "Animation", "2019-07-19", 118);

        bookingService.addMovie(movie1);
        bookingService.addMovie(movie2);

        Multiplex multiplex = new Multiplex("PVR Cinemas", "Downtown");
        bookingService.addMultiplex(multiplex);

        Screen screen1 = new Screen("Screen 1", multiplex, 100);
        Screen screen2 = new Screen("Screen 2", multiplex, 150);
        multiplex.addScreen(screen1);
        multiplex.addScreen(screen2);

        Show show1 = new Show(IdGene.generateId(), movie1, "2024-12-17 18:00", screen1);
        Show show2 = new Show(IdGene.generateId(), movie2, "2024-12-17 20:00", screen2);
        bookingService.addShow(show1);
        bookingService.addShow(show2);

        User user = new User("John Doe", "john.doe@example.com");

        System.out.println("Searching for movies with 'Avengers':");
        List<Movie> foundMovies = bookingService.searchMoviesByName("Avengers");
        for (Movie movie : foundMovies) {
            System.out.println("Found movie: " + movie.getName());
        }

        System.out.println("\nSearching for multiplexes with 'PVR':");
        List<Multiplex> foundMultiplexes = bookingService.searchMultiplexesByName("PVR");
        for (Multiplex multiplexFound : foundMultiplexes) {
            System.out.println("Found multiplex: " + multiplexFound.getName());
        }

        Show selectedShow = show1;
        List<Seat> seatsToBook = selectedShow.getAvailableSeats().subList(0, 2);

        System.out.println("\nAttempting to book 2 seats for the show: " + selectedShow.getShowTime());
        Booking booking = bookingService.bookSeats(user, selectedShow, seatsToBook);

        if (booking != null) {
            System.out.println("Booking successful! Booking ID: " + booking.getId());
            System.out.println("Total amount: " + booking.getTotalAmount());
            System.out.println("Reserved seats: " + booking.getReservedSeats());
        } else {
            System.out.println("Seats are not available for the selected show.");
        }

        if (booking != null) {
            System.out.println("\nConfirming the booking...");
            bookingService.confirmBooking(booking.getId());
            System.out.println("Booking status after confirmation: " + booking.getBookingStatus());
        }
    }
}
