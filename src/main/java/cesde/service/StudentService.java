//para todos los service y el menu app use regions, para mi es una forma mas organizada de modular bloques de codigo
package cesde.service;

import cesde.domain.Student;
import cesde.repository.StudentRepository;
import cesde.util.TypeValidator;

import java.util.List;
import java.util.Optional;

public class StudentService {
    static cesde.clsGenerales cg = new cesde.clsGenerales();

    private final StudentRepository studentRepository;

    // region Constructor
    public StudentService( StudentRepository studentRepository){

        this.studentRepository= studentRepository;// Esto es una inyeccion de dependencias
    }
    // endregion


    // region Crear
    public Student createStudentService(){

        Student student = new Student();

        student.setId(TypeValidator.validateInt("Ingrese el id del estudiante"));
        student.setName(TypeValidator.validateString("Ingrese el Nombre del Estudiante"));
        student.setLastName(TypeValidator.validateString("Ingrese el apellido del estudiante"));
        student.setEmail(TypeValidator.validateEmail("Ingrese un email valido"));
        student.setStatus(TypeValidator.validateBoolean("Seleccione un estado"));

        return studentRepository.createStudentRepository(student);
    }
    // endregion


    // region Actualizar
    public Student updateStudentService(int id){

        Student student = studentRepository.getStudentById(id);

        if(student != null && id == student.getId()){
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
                    student.setEmail(TypeValidator.validateEmail("Actualizar Email"));
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
    // endregion


    // region Buscar
    public Optional<Student> getStudentById(int id) {

        Student student = studentRepository.getStudentById(id);

        if (student != null && id == student.getId()) {
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
    // endregion


    // region Delete
    public void deleteStudent(int id) {
        cg.Mensaje("Estoy en el service");
        studentRepository.deleteStudentRepository(id);
    }
    // endregion


    // region Extra Methods
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
    // endregion
}
