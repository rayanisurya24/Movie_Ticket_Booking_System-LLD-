import java.util.UUID;

public class IdGene {
    public static String generateId() {
        return UUID.randomUUID().toString();
    }
}
