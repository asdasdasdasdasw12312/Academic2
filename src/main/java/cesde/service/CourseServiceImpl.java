package cesde.service;

import cesde.domain.Course;
import cesde.repository.CourseRepository;
import cesde.util.TypeValidator;
import cesde.clsGenerales;

public class CourseServiceImpl {
    private final CourseRepository courseRepository;
    static clsGenerales cg = new clsGenerales();

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }


    public Course createCourse() {
        Course course = new Course();
        course.setId(TypeValidator.validateInt("Ingrese el id del curso"));
        course.setNumber(TypeValidator.validateInt("Ingrese el numero del curso"));
        course.setName(TypeValidator.validateString("Ingrese el nombre del curso"));
        return courseRepository.createCourse(course);
    }


    public Course getCourseById(int id) {
        return courseRepository.getCourseById(id);
    }


    public void showCourse(int id) {
        Course course = getCourseById(id);
        if (course != null) {
            cg.Mensaje("Curso: " + course.getName() + " - Numero: " + course.getNumber());
        } else {
            cg.Mensaje("Curso no encontrado");
        }
    }

    public Course updateCourse(int id) {
        Course course = courseRepository.getCourseById(id);
        if (course != null && id == course.getId()) {
            int option = TypeValidator.validateInt("Seleccione el dato a actualizar \n" +
                    "1. id \n" +
                    "2. Numero \n" +
                    "3. Nombre \nOpcion: ");

            switch (option) {
                case 1:
                    course.setId(TypeValidator.validateInt("Actualizar id"));
                    break;
                case 2:
                    course.setNumber(TypeValidator.validateInt("Actualizar Numero"));
                    break;
                
                case 3:
                    course.setName(TypeValidator.validateString("Actualizar Nombre"));
                    break;
                default:
                    cg.Mensaje("Seleccione una opción valida");
            }
        }
        return course;
    }
}
