package cesde.util;

import cesde.clsGenerales;

public class TypeValidator {

    static clsGenerales cg = new clsGenerales();

    public static int validateInt(String promt) {
        return cg.leerEntero(promt);
    }

    public static double validateDouble(String promt) {
        // We use leerReal_f which returns float and cast it to double if necessary, or just create a new method in clsGenerales. 
        // For now, casting from float to double is fine.
        return (double) cg.leerReal_f(promt);
    }

    public static boolean validateBoolean(String promt) {
        return cg.leerBooleano(promt);
    }

    public static String validateString(String promt) {
        return cg.leerCadena(promt);
    }

}
