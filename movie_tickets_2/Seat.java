public class Seat {
    private String id;
    private SeatCategory category;
    private double price;

    public Seat(String id, SeatCategory category, double price) {
        this.id = id;
        this.category = category;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public SeatCategory getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return id + " (" + category + ")";
    }
}
