package cesde.view;

import cesde.domain.Classroom;
import cesde.service.ClassroomService;
import cesde.clsGenerales;

public class ClassroomView {

    static clsGenerales cg = new clsGenerales();
    private final ClassroomService classroomService;

    public ClassroomView(ClassroomService classroomService) {
        this.classroomService = classroomService; // Esto es inyeccion de dependencias
    }

    public void createClassroom() {
        classroomService.createClassroom();
    }

    public void getClassroomById(int id) {
        Classroom classroom = classroomService.getClassroomById(id);
        if(classroom != null){
            cg.Mensaje("Aula encontrada:\nSala: " + classroom.getRoom() + "\nPiso: " + classroom.getFloor() + "\nCapacidad: " + classroom.getCapacity());
        } else {
            cg.Mensaje("Aula no encontrada con id: " + id);
        }
    }

    public void classroomStatus(int id) {
        boolean status = classroomService.classroomStatus(id);
        cg.Mensaje("El aula esta disponible: " + status);
    }

    public void updateClassroom(int id) {
        classroomService.updateClassroom(id);
    }
}
