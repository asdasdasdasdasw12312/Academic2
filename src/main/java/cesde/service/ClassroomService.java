//para todos los service y el menu app use regions, para mi es una forma mas organizada de modular bloques de codigo
package cesde.service;

import cesde.domain.Classroom;
import cesde.repository.ClassroomRepository;
import cesde.util.TypeValidator;

public class ClassroomService {
    static cesde.clsGenerales cg = new cesde.clsGenerales();
    private final ClassroomRepository classroomRepository;

    // region Constructor
    public ClassroomService(ClassroomRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
    }
    // endregion


    // region Crear
    public Classroom createClassroom() {
        Classroom classroom = new Classroom();
        classroom.setId(TypeValidator.validateInt("Ingrese el id del salon"));
        classroom.setRoom(TypeValidator.validateString("Ingrese el numero del salon"));
        classroom.setFloor(TypeValidator.validateInt("Ingrese el piso del salon"));
        classroom.setCapacity(TypeValidator.validateInt("Ingrese la capacidad"));
        classroom.setStatus(TypeValidator.validateBoolean("Ingrese el estado del salon"));
        return classroomRepository.createClassroom(classroom);
    }
    // endregion


    // region Buscar
    public Classroom getClassroomById(int id) {
        return classroomRepository.getClassroomById(id);
    }


    public boolean classroomStatus(int id) {
        Classroom classroom = getClassroomById(id);
        if (classroom != null) {
            return classroom.isStatus();
        }
        return false;
    }
    // endregion

    // region Actualizar
    public Classroom updateClassroom(int id) {
        Classroom classroom = classroomRepository.getClassroomById(id);
        if (classroom != null && id == classroom.getId()) {
            int option = TypeValidator.validateInt("Seleccione el dato a actualizar \n" +
                    "1. id \n" +
                    "2. Numero de Salon \n" +
                    "3. Piso \n" +
                    "4. Capacidad \n" +
                    "5. Estado \nOpcion: ");

            switch (option) {
                case 1:
                    classroom.setId(TypeValidator.validateInt("Actualizar id"));
                    break;
                case 2:
                    classroom.setRoom(TypeValidator.validateString("Actualizar Numero de Salon"));
                    break;
                case 3:
                    classroom.setFloor(TypeValidator.validateInt("Actualizar Piso"));
                    break;
                case 4:
                    classroom.setCapacity(TypeValidator.validateInt("Actualizar Capacidad"));
                    break;
                case 5:
                    classroom.setStatus(TypeValidator.validateBoolean("Actualizar Estado"));
                    break;
                default:
                    cg.Mensaje("Seleccione una opción valida");
            }
        }
        return classroom;
    }
    // endregion
}
