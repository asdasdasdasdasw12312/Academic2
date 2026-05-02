package cesde.view;

import cesde.domain.Teacher;
import cesde.service.TeacherService;
import cesde.clsGenerales;

public class TeacherView {

    static clsGenerales cg = new clsGenerales();
    private final TeacherService teacherService;

    public TeacherView(TeacherService teacherService) {
        this.teacherService = teacherService; // Esto es inyeccion de dependencias
    }

    public void createProfessor() {
        teacherService.createProfessor();
    }

    public void getProfessorById(int id) {
        Teacher teacher = teacherService.getProfessorById(id);
        if(teacher != null){
            cg.Mensaje("Profesor encontrado:\nNombre: " + teacher.getName() + " " + teacher.getLastName() + "\nEspecialidad: " + teacher.getSpeciality() + "\nEmail: " + teacher.getEmail());
        } else {
            cg.Mensaje("Profesor no encontrado con id: " + id);
        }
    }

    public void professorStatus(int id) {
        boolean status = teacherService.professorStatus(id);
        cg.Mensaje("El profesor esta disponible: " + status);
    }

    public void updateTeacher(int id) {
        teacherService.updateTeacher(id);
    }
}
