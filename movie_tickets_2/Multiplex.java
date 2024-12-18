import java.util.ArrayList;
import java.util.List;

public class Multiplex {
    private String id;
    private String name;
    private String location;
    private List<Screen> screens;

    public Multiplex(String name, String location) {
        this.id = IdGene.generateId();
        this.name = name;
        this.location = location;
        this.screens = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public void addScreen(Screen screen) {
        screens.add(screen);
    }
}
