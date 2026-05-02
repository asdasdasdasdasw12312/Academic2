package cesde.view;

import cesde.domain.School;
import cesde.service.SchoolService;
import cesde.clsGenerales;

public class SchoolView {

    static clsGenerales cg = new clsGenerales();
    private final SchoolService schoolService;

    public SchoolView(SchoolService schoolService) {
        this.schoolService = schoolService; // Esto es inyeccion de dependencias
    }

    public void createSchool() {
        schoolService.createSchool();
    }

    public void getSchoolById(int id) {
        School school = schoolService.getSchoolById(id);
        if(school != null){
            cg.Mensaje("Escuela encontrada:\nNombre: " + school.getName() + "\nDirector: " + school.getDirector());
        } else {
            cg.Mensaje("Escuela no encontrada con id: " + id);
        }
    }

    public void showDirector(int id) {
        School school = schoolService.getSchoolById(id);
        if(school != null) {
            cg.Mensaje("El director de la escuela " + school.getName() + " es: " + school.getDirector());
        } else {
            cg.Mensaje("Escuela no encontrada con id: " + id);
        }
    }

    public void updateSchool(int id) {
        schoolService.updateSchool(id);
    }
}
