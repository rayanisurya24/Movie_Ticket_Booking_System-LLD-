import java.util.*;

public class Screen {
    private String id;
    private String name;
    private Multiplex multiplex;
    private int totalSeats;
    private List<Seat> availableSeats;
    private List<Seat> reservedSeats;

    public Screen(String name, Multiplex multiplex, int totalSeats) {
        this.id = IdGene.generateId();
        this.name = name;
        this.multiplex = multiplex;
        this.totalSeats = totalSeats;
        this.availableSeats = new ArrayList<>();
        this.reservedSeats = new ArrayList<>();
        for (int i = 0; i < totalSeats; i++) {
            availableSeats.add(new Seat("Seat" + (i + 1), SeatCategory.REGULAR, 100));
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Multiplex getMultiplex() {
        return multiplex;
    }

    public List<Seat> getAvailableSeats() {
        return availableSeats;
    }

    public List<Seat> getReservedSeats() {
        return reservedSeats;
    }
}
