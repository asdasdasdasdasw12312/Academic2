package cesde.view;


import cesde.service.CourseService;
import cesde.clsGenerales;

public class CourseView {

    static clsGenerales cg = new clsGenerales();
    private final CourseService courseService;

    public CourseView(CourseService courseService) {
        this.courseService = courseService; // Esto es inyeccion de dependencias
    }

    public void createCourse() {
        courseService.createCourse();
    }

    public void getCourseById(int id) {
        courseService.getCourseById(id);
    }

    public void showCourse(int id) {
        courseService.showCourse(id);
    }

    public void updateCourse(int id) {
        courseService.updateCourse(id);
    }
}
