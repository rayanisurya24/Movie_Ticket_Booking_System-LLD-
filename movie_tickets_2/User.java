public class User {
    private String id;
    private String name;
    private String email;

    public User(String name, String email) {
        this.id = IdGene.generateId();
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
