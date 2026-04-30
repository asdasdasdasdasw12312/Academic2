package cesde.domain;

public class School {
    private int id;
    private String name;
    private String director;

    public School() {}

    public School(int id, String name, String director) {
        this.id = id;
        this.name = name;
        this.director = director;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDirector() { return director; }
    public void setDirector(String director) { this.director = director; }
}
// Todas las clases, aparte de student quize que estuvieran mas organizadas, y con la menor lineas de codigo posibles
