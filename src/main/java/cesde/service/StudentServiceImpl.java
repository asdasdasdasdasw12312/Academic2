package cesde.service;

import cesde.domain.Student;
import cesde.repository.StudentRepository;
import cesde.util.TypeValidator;

import java.util.List;
import java.util.Optional;

public class StudentServiceImpl {
    static cesde.clsGenerales cg = new cesde.clsGenerales();

    private final StudentRepository studentRepository;

    public StudentServiceImpl( StudentRepository studentRepository){

        this.studentRepository= studentRepository;// Esto es una inyeccion de dependencias
    }


    public Student createStudentService(){

        Student student = new Student();

        student.setId(TypeValidator.validateInt("Ingrese el id del estudiante"));
        student.setNumber(TypeValidator.validateInt("Ingrese el numero del estudiante"));
        student.setName(TypeValidator.validateString("Ingrese el Nombre del Estudiante"));
        student.setLastName(TypeValidator.validateString("Ingrese el apellido del estudiante"));
        student.setEmail(TypeValidator.validateString("Ingrese un email valido"));
        student.setStatus(TypeValidator.validateBoolean("Seleccione un estado"));

        return studentRepository.createStudentRepository(student);
    }


    public Student updateStudentService(int id){

        Student student = studentRepository.getStudentById(id);

        if(id == student.getId()){
            int option = TypeValidator.validateInt("Seleccione el dato a actualizar \n" +
                    "1. id \n" +
                    "2. Nombre \n" +
                    "3. Apellido \n" +
                    "4. Email \n" +
                    "5. Estado \nOpcion: ");

            switch (option){
                case 1:
                    student.setId(TypeValidator.validateInt("Actualizar id"));
                    break;
                case 2:
                    student.setName(TypeValidator.validateString("Actualizar Nombre"));
                    break;
                case 3:
                    student.setLastName(TypeValidator.validateString("Actualizar Apellido"));
                    break;
                case 4:
                    student.setEmail(TypeValidator.validateString("Actualizar Email"));
                    break;
                case 5:
                    student.setStatus(TypeValidator.validateBoolean("Actualizar Estado"));
                    break;
                default:
                    cg.Mensaje("Seleccione una opción valida");
            }

        }

        return student;
    }


    public Optional<Student> getStudentById(int id) {

        Student student = studentRepository.getStudentById(id);

        if (id == student.getId()) {
            cg.Mensaje("id:" + student.getId() + "\n" +
                    "Nombre:" + student.getName() + "\n" +
                    "Apellido " + student.getLastName() + "\n" +
                    "email: " + student.getEmail() + "\n" +
                    "Status: " + student.isStatus());
        } else {
            cg.Mensaje("Id no encontrado");
        }

        return Optional.ofNullable(student);
    }


    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }


    public void deleteStudent(int id) {
        cg.Mensaje("Estoy en el service");
        studentRepository.deleteStudentRepository(id);
    }


    public Student getStudentByName(String name) {
        for (Student student : studentRepository.getAllStudents()) {
            if (student.getName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        return null;
    }


    public boolean isStudentActive(int id) {
        Student student = studentRepository.getStudentById(id);
        if (student != null) {
            return student.isStatus();
        }
        return false;
    }
}
