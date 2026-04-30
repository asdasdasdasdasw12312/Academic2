package cesde.repository;

import cesde.domain.School;
import cesde.clsGenerales;
import java.util.ArrayList;
import java.util.List;

public class SchoolRepository {
    static clsGenerales cg = new clsGenerales();
    private List<School> schools = new ArrayList<>();

    public School createSchool(School school) {
        schools.add(school);
        return school;
    }

    public School getSchoolById(int id) {
        for (School school : schools) {
            if (school.getId() == id) {
                return school;
            }
        }
        return null;
    }

    public List<School> getAllSchools() {
        return schools;
    }

    public void updateSchool(School school) {
        School existing = getSchoolById(school.getId());
        if (existing != null) {
            existing.setName(school.getName());
            existing.setDirector(school.getDirector());
        }
    }

    public void deleteSchool(int id) {
        for (School school : schools) {
            if (school.getId() == id) {
                schools.remove(school);
                cg.Mensaje("school removed");
                return;
            }
        }
        cg.Mensaje("school not found");
    }
}
