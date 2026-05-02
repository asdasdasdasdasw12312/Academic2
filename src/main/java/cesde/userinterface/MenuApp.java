package cesde.userinterface;
import cesde.util.TypeValidator;
import cesde.view.*;
import cesde.clsGenerales;

public class MenuApp {

    static clsGenerales cg = new clsGenerales();

    private final StudentView studentView;
    private final ClassroomView classroomView;
    private final CourseView courseView;
    private final SchoolView schoolView;
    private final TeacherView teacherView;

    // region Constructor
    public MenuApp(StudentView studentView, ClassroomView classroomView, CourseView courseView, SchoolView schoolView, TeacherView teacherView){
        this.studentView = studentView;
        this.classroomView = classroomView;
        this.courseView = courseView;
        this.schoolView = schoolView;
        this.teacherView = teacherView;
    }
    // endregion


    // region Menu Principal
   public void mainMenu(){

       int init = cg.leerEntero("Presione 1 para iniciar la Aplicación\nPresione 0 para salir");

       while(init != 0){

           int option = cg.leerEntero("Seleccione una opción\n1. Registro\n2. Inicio de Sesion\n3. Salir");

           switch (option){

               case 1:
                   cg.Mensaje("Crear usuario");
                   studentView.createStudent();
                   break;
               case 2:
                   cg.Mensaje("Iniciar Sesión");
                   boolean token= true;
                   menuApplication(token);
                   break;
               case 3:
                   cg.Mensaje("Salir del sistema ");
                   init = 0;
                   break;
               default:
                   cg.Mensaje("Ingrese una opción valida");
           }
       }

   }


   public void menuApplication(boolean control){

        while(control) {
            int menu = cg.leerEntero("Seleccione\n1. Estudiante\n2. Gestion de Cursos\n3. Gestion de Profesores\n4. Gestion de Aulas\n5. Gestion de Escuelas\n6. Volver");
            switch (menu) {
                case 1:
                    cg.Mensaje("Estudiante");
                    studentMenu();
                    break;
                case 2:
                    cg.Mensaje("Gestion de Cursos");
                    courseMenu();
                    break;
                case 3:
                    cg.Mensaje("Gestion de Profesores");
                    teacherMenu();
                    break;
                case 4:
                    cg.Mensaje("Gestion de Aulas");
                    classroomMenu();
                    break;
                case 5:
                    cg.Mensaje("Gestion de Escuelas");
                    schoolMenu();
                    break;
                case 6:
                    cg.Mensaje("Volviendo al menú principal");
                    control = false;
                    break;
                default:
                    cg.Mensaje("Seleccione menu valido");
            }

        }

   }
   // endregion


   // region Menu Curso
   public void courseMenu(){

       cg.Mensaje("Menu Curso");
       boolean init = true;

       while(init){
           int opt = cg.leerEntero("1. Crear Curso\n2. Actualizar curso\n3. Ver Curso por Id\n4. Volver");
           switch (opt){
               case 1:
                   cg.Mensaje("Crear Curso");
                   courseView.createCourse();
                   break;
               case 2:
                   cg.Mensaje("Actualizar Curso");
                   courseView.updateCourse(TypeValidator.validateInt("Ingrese el id del curso a actualizar"));
                   break;
               case 3:
                   cg.Mensaje("Ver Curso por id");
                   courseView.showCourse(TypeValidator.validateInt("Ingrese el id del curso"));
                   break;
               case 4:
                   init = false;
                   break;
               default:
                   cg.Mensaje("Seleccione opción valida");
           }
       }
   }
   // endregion



    // region Menu Estudiante
    public void studentMenu(){

        cg.Mensaje("Menu Estudiante");
        boolean init = true;

        while(init){
            int opt = cg.leerEntero("1. Crear Estudiante\n2. Actualizar Estudiante\n3. ver Estudiantes\n4. Ver Estudiante por Id\n5. Eliminar Estudiante\n6. Volver");
            switch (opt){
                case 1:
                    cg.Mensaje("Crear Estudiante");
                    studentView.createStudent();
                    break;
                case 2:
                    cg.Mensaje("Actualizar Estudiante");
                    studentView.updateStudent(TypeValidator.validateInt("Ingrese el id del estudiante a actualizar"));
                    break;
                case 3:
                    cg.Mensaje("Ver Estudiantes");
                    studentView.getAllStudents();
                    break;
                case 4:
                    cg.Mensaje("Ver estudiante por id");
                    studentView.getStudentById(TypeValidator.validateInt("Ingrese el id del estudiante"));
                    break;
                case 5:
                    cg.Mensaje("Eliminar Estudiante");
                    studentView.deleteStudent(TypeValidator.validateInt("Ingrese el id del estudiante a eliminar"));
                    break;
                case 6:
                    cg.Mensaje("Volviendo al menú principal");
                    init = false;
                    break;
                default:
                    cg.Mensaje("Seleccione opción valida");
            }
        }
    }
    // endregion
    
    // region Menu Profesor
    public void teacherMenu(){
        cg.Mensaje("Menu Profesor");
        boolean init = true;

        while(init){
            int opt = cg.leerEntero("1. Crear Profesor\n2. Actualizar Profesor\n3. Ver Profesor por Id\n4. Ver Estado de Profesor\n5. Volver");
            switch (opt){
                case 1:
                    cg.Mensaje("Crear Profesor");
                    teacherView.createProfessor();
                    break;
                case 2:
                    cg.Mensaje("Actualizar Profesor");
                    teacherView.updateTeacher(TypeValidator.validateInt("Ingrese el id del profesor a actualizar"));
                    break;
                case 3:
                    cg.Mensaje("Ver Profesor por id");
                    teacherView.getProfessorById(TypeValidator.validateInt("Ingrese el id del profesor"));
                    break;
                case 4:
                    cg.Mensaje("Ver estado de Profesor");
                    teacherView.professorStatus(TypeValidator.validateInt("Ingrese el id del profesor"));
                    break;
                case 5:
                    init = false;
                    break;
                default:
                    cg.Mensaje("Seleccione opción valida");
            }
        }
    }
    // endregion
    
    // region Menu Aula
    public void classroomMenu(){
        cg.Mensaje("Menu Aula");
        boolean init = true;

        while(init){
            int opt = cg.leerEntero("1. Crear Aula\n2. Actualizar Aula\n3. Ver Aula por Id\n4. Ver Estado de Aula\n5. Volver");
            switch (opt){
                case 1:
                    cg.Mensaje("Crear Aula");
                    classroomView.createClassroom();
                    break;
                case 2:
                    cg.Mensaje("Actualizar Aula");
                    classroomView.updateClassroom(TypeValidator.validateInt("Ingrese el id del aula a actualizar"));
                    break;
                case 3:
                    cg.Mensaje("Ver Aula por id");
                    classroomView.getClassroomById(TypeValidator.validateInt("Ingrese el id del aula"));
                    break;
                case 4:
                    cg.Mensaje("Ver estado de Aula");
                    classroomView.classroomStatus(TypeValidator.validateInt("Ingrese el id del aula"));
                    break;
                case 5:
                    init = false;
                    break;
                default:
                    cg.Mensaje("Seleccione opción valida");
            }
        }
    }
    // endregion
    
    // region Menu Escuela
    public void schoolMenu(){
        cg.Mensaje("Menu Escuela");
        boolean init = true;

        while(init){
            int opt = cg.leerEntero("1. Crear Escuela\n2. Actualizar Escuela\n3. Ver Escuela por Id\n4. Ver Director de Escuela\n5. Volver");
            switch (opt){
                case 1:
                    cg.Mensaje("Crear Escuela");
                    schoolView.createSchool();
                    break;
                case 2:
                    cg.Mensaje("Actualizar Escuela");
                    schoolView.updateSchool(TypeValidator.validateInt("Ingrese el id de la escuela a actualizar"));
                    break;
                case 3:
                    cg.Mensaje("Ver Escuela por id");
                    schoolView.getSchoolById(TypeValidator.validateInt("Ingrese el id de la escuela"));
                    break;
                case 4:
                    cg.Mensaje("Ver Director de Escuela");
                    schoolView.showDirector(TypeValidator.validateInt("Ingrese el id de la escuela"));
                    break;
                case 5:
                    init = false;
                    break;
                default:
                    cg.Mensaje("Seleccione opción valida");
            }
        }
    }
    // endregion

}
