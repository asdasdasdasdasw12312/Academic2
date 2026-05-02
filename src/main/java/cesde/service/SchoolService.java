//para todos los service y el menu app use regions, para mi es una forma mas organizada de modular bloques de codigo
package cesde.service;

import cesde.domain.School;
import cesde.repository.SchoolRepository;
import cesde.util.TypeValidator;
import cesde.clsGenerales;

public class SchoolService {
    private final SchoolRepository schoolRepository;
    static clsGenerales cg = new clsGenerales();

    // region Constructor
    public SchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }
    // endregion


    // region Crear
    public School createSchool() {
        School school = new School();
        school.setId(TypeValidator.validateInt("Ingrese el id de la escuela"));
        school.setName(TypeValidator.validateString("Ingrese el nombre de la escuela"));
        school.setDirector(TypeValidator.validateString("Ingrese el director de la escuela"));
        return schoolRepository.createSchool(school);
    }
    // endregion


    // region Buscar
    public School getSchoolById(int id) {
        return schoolRepository.getSchoolById(id);
    }


    public String showDirector(int id) {
        School school = getSchoolById(id);
        if (school != null) {
            cg.Mensaje("El director de " + school.getName() + " es: " + school.getDirector());
            return school.getDirector();
        }
        cg.Mensaje("Escuela no encontrada");
        return null;
    }
    // endregion

    // region Actualizar
    public School updateSchool(int id) {
        School school = schoolRepository.getSchoolById(id);
        if (school != null && id == school.getId()) {
            int option = TypeValidator.validateInt("Seleccione el dato a actualizar \n" +
                    "1. id \n" +
                    "2. Nombre \n" +
                    "3. Director \nOpcion: ");

            switch (option) {
                case 1:
                    school.setId(TypeValidator.validateInt("Actualizar id"));
                    break;
                case 2:
                    school.setName(TypeValidator.validateString("Actualizar Nombre"));
                    break;
                case 3:
                    school.setDirector(TypeValidator.validateString("Actualizar Director"));
                    break;
                default:
                    cg.Mensaje("Seleccione una opción valida");
            }
        }
        return school;
    }
    // endregion
}
