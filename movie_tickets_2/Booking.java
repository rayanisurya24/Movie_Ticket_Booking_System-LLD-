import java.util.List;

public class Booking {
    private final String id;
    private User user;
    private Show show;
    private List<Seat> reservedSeats;
    private double totalAmount;
    private BookingStatus bookingStatus;

    public Booking(User user, Show show, List<Seat> reservedSeats, double totalAmount) {
        this.id = IdGene.generateId();
        this.user = user;
        this.show = show;
        this.reservedSeats = reservedSeats;
        this.totalAmount = totalAmount;
        this.bookingStatus = BookingStatus.PENDING;
    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Show getShow() {
        return show;
    }

    public List<Seat> getReservedSeats() {
        return reservedSeats;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    @Override
    public String toString() {
        return "Booking ID: " + id + ", User: " + user.getName() + ", Show: " + show.getShowTime() + ", Status: " + bookingStatus;
    }
}
