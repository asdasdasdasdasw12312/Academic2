package cesde.userinterface;

import cesde.domain.Student;
import cesde.util.TypeValidator;
import cesde.view.StudentView;
import cesde.clsGenerales;

public class MenuApp {

    static clsGenerales cg = new clsGenerales();

    private final StudentView studentView;

    public MenuApp(StudentView studentView){
        this.studentView = studentView;
    }


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
            int menu = cg.leerEntero("Seleccione\n1. Estudiante\n2. Gestion de Cursos\n6. Volver");
            switch (menu) {
                case 1:
                    cg.Mensaje("Estudiante");
                    studentMenu();
                    break;
                case 2:
                    cg.Mensaje("Gestion de Cursos");
                    courseMenu();
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


   public void courseMenu(){

       cg.Mensaje("Menu Curso");
       boolean init = true;

       while(init){
           int opt = cg.leerEntero("1. Crear Curso\n2. Actualizar curso\n3. ver Cursos\n4. Ver curso por Id\n5. Eliminar Curso\n6. Volver");
           switch (opt){
               case 1:
                   cg.Mensaje("Crear Curso");
                   break;
               case 6:
                   init = false;
                   break;
               default:
                   cg.Mensaje("Seleccione opción valida");
           }
       }
   }



    public void studentMenu(){

        cg.Mensaje("Menu Estudiante");
        boolean init = true;

        while(init){
            int opt = cg.leerEntero("1. Crear Estudiante\n2. Actualizar Estudiante\n3. ver Estudiantes\n4. VerEstudiante por Id\n5. Eliminar Estudiante\n6. Volver");
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
                    int id = cg.leerEntero("Ingrese el id del estudiante");
                    studentView.getStudentById(id);
                    break;
                case 5:
                    cg.Mensaje("Eliminar Estudiante");
                    int idToRemove = cg.leerEntero("Ingrese el id del estudiante a eliminar");
                    studentView.deleteStudent(idToRemove);
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


}
