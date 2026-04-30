package cesde.domain;

public class Teacher {
    private int id;
    private String name;
    private String lastName;
    private String email;
    private String speciality;
    private boolean status;

    public Teacher() {}

    public Teacher(int id, String name, String lastName, String email, String speciality, boolean status) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.speciality = speciality;
        this.status = status;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getSpeciality() { return speciality; }
    public void setSpeciality(String speciality) { this.speciality = speciality; }
    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }
}
// Todas las clases, aparte de student quize que estuvieran mas organizadas, y con la menor lineas de codigo posibles
