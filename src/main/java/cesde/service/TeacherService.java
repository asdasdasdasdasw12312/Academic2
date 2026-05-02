//para todos los service y el menu app use regions, para mi es una forma mas organizada de modular bloques de codigo
package cesde.service;

import cesde.domain.Teacher;
import cesde.repository.TeacherRepository;
import cesde.util.TypeValidator;

public class TeacherService {
    static cesde.clsGenerales cg = new cesde.clsGenerales();
    private final TeacherRepository teacherRepository;

    // region Constructor
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }
    // endregion


    // region Crear
    public Teacher createProfessor() {
        Teacher teacher = new Teacher();
        teacher.setId(TypeValidator.validateInt("Ingrese el id del profesor"));
        teacher.setName(TypeValidator.validateString("Ingrese el nombre"));
        teacher.setLastName(TypeValidator.validateString("Ingrese el apellido"));
        teacher.setEmail(TypeValidator.validateEmail("Ingrese el email"));
        teacher.setSpeciality(TypeValidator.validateString("Ingrese la especialidad"));
        teacher.setStatus(TypeValidator.validateBoolean("Ingrese el estado"));
        return teacherRepository.createTeacher(teacher);
    }
    // endregion


    // region Buscar
    public Teacher getProfessorById(int id) {
        return teacherRepository.getTeacherById(id);
    }

    public boolean professorStatus(int id) {
        Teacher teacher = getProfessorById(id);
        if (teacher != null) {
            return teacher.isStatus();
        }
        return false;
    }
    // endregion

    // region Actualizar
    public Teacher updateTeacher(int id) {
        Teacher teacher = teacherRepository.getTeacherById(id);
        if (teacher != null && id == teacher.getId()) {
            int option = TypeValidator.validateInt("Seleccione el dato a actualizar \n" +
                    "1. id \n" +
                    "2. Nombre \n" +
                    "3. Apellido \n" +
                    "4. Email \n" +
                    "5. Especialidad \n" +
                    "6. Estado \nOpcion: ");

            switch (option) {
                case 1:
                    teacher.setId(TypeValidator.validateInt("Actualizar id"));
                    break;
                case 2:
                    teacher.setName(TypeValidator.validateString("Actualizar Nombre"));
                    break;
                case 3:
                    teacher.setLastName(TypeValidator.validateString("Actualizar Apellido"));
                    break;
                case 4:
                    teacher.setEmail(TypeValidator.validateEmail("Actualizar Email"));
                    break;
                case 5:
                    teacher.setSpeciality(TypeValidator.validateString("Actualizar Especialidad"));
                    break;
                case 6:
                    teacher.setStatus(TypeValidator.validateBoolean("Actualizar Estado"));
                    break;
                default:
                    cg.Mensaje("Seleccione una opción valida");
            }
        }
        return teacher;
    }
    // endregion
}
