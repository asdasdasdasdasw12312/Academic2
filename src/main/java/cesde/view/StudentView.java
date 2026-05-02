package cesde.view;

import cesde.domain.Student;
import cesde.service.StudentService;
import cesde.clsGenerales;

import java.util.List;

public class StudentView {

    static clsGenerales cg = new clsGenerales();

    private final StudentService studentService;

    public StudentView(StudentService studentService){

        this.studentService = studentService; // Esto es inyeccion de dependencias
    }


    public void createStudent(){

        studentService.createStudentService();

    }

    public void getStudentById(int id){


        studentService.getStudentById(id);


    }

    public void getAllStudents(){
        List<Student> students = studentService.getAllStudents();
        if(students.isEmpty()){
            cg.Mensaje("No hay estudiantes registrados.");
            return;
        }
        StringBuilder sb = new StringBuilder("Lista de estudiantes:\n");
        for(Student s : students){
            sb.append("- Id: ").append(s.getId()).append(" | Nombre: ").append(s.getName()).append(" ").append(s.getLastName()).append("\n");
        }
        cg.Mensaje(sb.toString());
    }

    public void updateStudent(int id){

        studentService.updateStudentService(id);

    }

    public void deleteStudent(int id){
            cg.Mensaje("estoy en el view");
            studentService.deleteStudent(id);
    }





}
