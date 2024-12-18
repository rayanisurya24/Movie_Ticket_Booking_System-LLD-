public class Movie {
    private String id;
    private String name;
    private String language;
    private String genre;
    private String releaseDate;
    private int duration; // in minutes

    public Movie(String name, String language, String genre, String releaseDate, int duration) {
        this.id = IdGene.generateId();
        this.name = name;
        this.language = language;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.duration = duration;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLanguage() {
        return language;
    }

    public String getGenre() {
        return genre;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public int getDuration() {
        return duration;
    }
}
