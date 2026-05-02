package cesde.config;

import cesde.repository.*;
import cesde.service.*;
import cesde.userinterface.MenuApp;
import cesde.view.*;
// el Config se conecta con todo
public class Config {

    public static MenuApp createMenuApp() {

        StudentRepository studentRepository = new StudentRepository();
        StudentService studentService = new StudentService(studentRepository);
        StudentView studentView = new StudentView(studentService);

        ClassroomRepository classroomRepository = new ClassroomRepository();
        ClassroomService classroomService = new ClassroomService(classroomRepository);
        ClassroomView classroomView = new ClassroomView(classroomService);

        CourseRepository courseRepository = new CourseRepository();
        CourseService courseService = new CourseService(courseRepository);
        CourseView courseView = new CourseView(courseService);

        SchoolRepository schoolRepository = new SchoolRepository();
        SchoolService schoolService = new SchoolService(schoolRepository);
        SchoolView schoolView = new SchoolView(schoolService);

        TeacherRepository teacherRepository = new TeacherRepository();
        TeacherService teacherService = new TeacherService(teacherRepository);
        TeacherView teacherView = new TeacherView(teacherService);

        return new MenuApp(studentView, classroomView, courseView, schoolView, teacherView);
    }
}
