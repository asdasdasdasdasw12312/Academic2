package cesde.repository;

import cesde.domain.Student;
import cesde.clsGenerales;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StudentRepository {
    static clsGenerales cg = new clsGenerales();
    List<Student> students = new ArrayList<>();

    public Student createStudentRepository(Student student){

        students.add(student);

        for (Student student1: students) {
            cg.Mensaje(student1.getId() + " " + student1.getName() + " " + student1.getLastName());
        }


        return student;

    }


    public Student getStudentById(int id){

        for (Student student: students) {
            if(student.getId() == id){

                return student;
            }
        }

        return null;
    }

    public List<Student> getAllStudents(){

        for(Student student: students){
            cg.Mensaje(student.getId() + " " + student.getName() + " " + student.getLastName());
        }
        return students;
    }

    public Student updateStudentRepository(int id){

        for (Student student: students) {
            if(student.getId() == id){
                return student;
            }
        }

        return null;
    }


    public void deleteStudentRepository(int id){

        for (Student student: students) {
            if(student.getId() == id){
                students.remove(student);
                cg.Mensaje("Estudiante eliminado");
                return;
            }
        }

        cg.Mensaje("Estudiante no encontrado");
    }






}
