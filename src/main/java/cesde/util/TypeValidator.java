package cesde.util;

import cesde.clsGenerales;

public class TypeValidator {

    static clsGenerales cg = new clsGenerales();

    public static int validateInt(String promt) {
        return cg.leerEntero(promt);
    }

    public static double validateDouble(String promt) {
        //para este metodo se usa la clase clsGenerales, y su metodo para leer flotantes pero aun no hay un metodo para leer doubles
        //entonces podemos hacer 2 cosas aprovechar el casting explicito o hacer un nuevo metodo que verfique doubles
        //ya que el programa no es tan grande, usar casting explicito me parece lo mas sencillo
        return (double) cg.leerReal_f(promt);
    }

    public static boolean validateBoolean(String promt) {
        return cg.leerBooleano(promt);
    }

    public static String validateString(String promt) {
        return cg.leerCadena(promt);
    }

    public static String validateEmail(String promt) {
        String email;
        while (true) {
            email = cg.leerCadena(promt);
            if (email != null && email.contains("@")) {
                return email;
            } else {
                cg.Mensaje("Error: El correo ingresado no es valido (Debe contener '@'). Por favor, intente de nuevo.");
            }
        }
    }
}
