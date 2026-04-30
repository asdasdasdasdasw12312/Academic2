package cesde.repository;

import cesde.domain.Course;
import cesde.clsGenerales;
import java.util.ArrayList;
import java.util.List;

public class CourseRepository {
    static clsGenerales cg = new clsGenerales();
    private List<Course> courses = new ArrayList<>();

    public Course createCourse(Course course) {
        courses.add(course);
        return course;
    }

    public Course getCourseById(int id) {
        for (Course course : courses) {
            if (course.getId() == id) {
                return course;
            }
        }
        return null;
    }

    public List<Course> getAllCourses() {
        return courses;
    }

    public void updateCourse(Course course) {
        Course existing = getCourseById(course.getId());
        if (existing != null) {
            existing.setNumber(course.getNumber());
            existing.setName(course.getName());
            existing.setProfessor(course.getProfessor());
            existing.setSchool(course.getSchool());
        }
    }

    public void deleteCourse(int id) {
        for (Course course : courses) {
            if (course.getId() == id) {
                courses.remove(course);
                cg.Mensaje("course removed");
                return;
            }
        }
        cg.Mensaje("Course not found");
    }
}
