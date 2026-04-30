package cesde.repository;

import cesde.domain.Classroom;
import cesde.clsGenerales;
import java.util.ArrayList;
import java.util.List;

public class ClassroomRepository {
    static clsGenerales cg = new clsGenerales();
    private List<Classroom> classrooms = new ArrayList<>();

    public Classroom createClassroom(Classroom classroom) {
        classrooms.add(classroom);
        return classroom;
    }

    public Classroom getClassroomById(int id) {
        for (Classroom classroom : classrooms) {
            if (classroom.getId() == id) {
                return classroom;
            }
        }
        return null;
    }

    public List<Classroom> getAllClassrooms() {
        return classrooms;
    }

    public void updateClassroom(Classroom classroom) {
        Classroom existing = getClassroomById(classroom.getId());
        if (existing != null) {
            existing.setRoom(classroom.getRoom());
            existing.setFloor(classroom.getFloor());
            existing.setCapacity(classroom.getCapacity());
            existing.setStatus(classroom.isStatus());
        }
    }

    public void deleteClassroom(int id) {
        for (Classroom classroom : classrooms) {
            if (classroom.getId() == id) {
                classrooms.remove(classroom);
                cg.Mensaje("Classroom removed");
                return;
            }
        }
        cg.Mensaje("Classroom not found");
    }
}
