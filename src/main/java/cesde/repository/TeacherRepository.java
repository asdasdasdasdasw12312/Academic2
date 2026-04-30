package cesde.repository;

import cesde.domain.Teacher;
import cesde.clsGenerales;
import java.util.ArrayList;
import java.util.List;

public class TeacherRepository {
    static clsGenerales cg = new clsGenerales();
    private List<Teacher> teachers = new ArrayList<>();

    public Teacher createTeacher(Teacher teacher) {
        teachers.add(teacher);
        return teacher;
    }

    public Teacher getTeacherById(int id) {
        for (Teacher teacher : teachers) {
            if (teacher.getId() == id) {
                return teacher;
            }
        }
        return null;
    }

    public List<Teacher> getAllTeachers() {
        return teachers;
    }

    public void updateTeacher(Teacher teacher) {
        Teacher existing = getTeacherById(teacher.getId());
        if (existing != null) {
            existing.setName(teacher.getName());
            existing.setLastName(teacher.getLastName());
            existing.setEmail(teacher.getEmail());
            existing.setSpeciality(teacher.getSpeciality());
            existing.setStatus(teacher.isStatus());
        }
    }

    public void deleteTeacher(int id) {
        for (Teacher teacher : teachers) {
            if (teacher.getId() == id) {
                teachers.remove(teacher);
                cg.Mensaje("Profesor removed");
                return;
            }
        }
        cg.Mensaje("Profesor not found");
    }
}
