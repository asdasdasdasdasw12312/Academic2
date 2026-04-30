package cesde.view;

import cesde.domain.Student;
import cesde.service.StudentServiceImpl;
import cesde.clsGenerales;

import java.util.List;

public class StudentView {

    static clsGenerales cg = new clsGenerales();

    private final StudentServiceImpl studentServiceImpl;

    public StudentView(StudentServiceImpl studentServiceImpl){

        this.studentServiceImpl = studentServiceImpl; // Esto es inyeccion de dependencias
    }


    public void createStudent(){

        studentServiceImpl.createStudentService();

    }

    public void getStudentById(int id){


        studentServiceImpl.getStudentById(id);


    }

    public List<Student> getAllStudents(){

        return studentServiceImpl.getAllStudents();
    }

    public void updateStudent(int id){

        studentServiceImpl.updateStudentService(id);

    }

    public void deleteStudent(int id){
            cg.Mensaje("estoy en el view");
            studentServiceImpl.deleteStudent(id);
    }





}
