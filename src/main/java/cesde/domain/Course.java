package cesde.domain;

public class Course {
    private int id;
    private int number;
   
    private String name;
    private Teacher professor;
    private School school;

    public Course() {}

    public Course(int id, int number,  String name, Teacher professor, School school) {
        this.id = id;
        this.number = number;
       
        this.name = name;
        this.professor = professor;
        this.school = school;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getNumber() { return number; }
    public void setNumber(int number) { this.number = number; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Teacher getProfessor() { return professor; }
    public void setProfessor(Teacher professor) { this.professor = professor; }
    public School getSchool() { return school; }
    public void setSchool(School school) { this.school = school; }
}
// Todas las clases, aparte de student quize que estuvieran mas organizadas, y con la menor lineas de codigo posibles
