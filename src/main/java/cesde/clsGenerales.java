//Nota: esta es otra clase aparte para validar los tipos de datos que se ingresan.
package cesde;
import javax.swing.JOptionPane;
public class clsGenerales{

    public clsGenerales(){

   
    }
    public void Mensaje(String texto){
        JOptionPane.showMessageDialog(null, texto);
    }
    
    public int leerEntero(String texto){
        while(true) {
            try{
                return Integer.parseInt(JOptionPane.showInputDialog(null, texto));
            }
            catch(Exception ex){
                Mensaje("Error, tipo de dato entero no valido");
            }
        }
    }
    
    public float leerReal_f (String texto){
        while(true) {
            try{
                return Float.parseFloat(JOptionPane.showInputDialog(null, texto));
            }
            catch(Exception ex){
                Mensaje("Error, tipo de dato no valido");
            }
        }
    }
    
    public String leerCadena(String texto){
        while(true) {
            String input = JOptionPane.showInputDialog(null, texto);
            if (input != null && !input.trim().isEmpty()) {
                return input.trim();
            } else {
                Mensaje("Error, el campo no puede estar vacio");
            }
        }
    }
    
    public int leerEnteroPos(String Texto){
        while(true) {
            try {
                int Dato = Integer.parseInt(JOptionPane.showInputDialog(null, Texto));
                if (Dato >= 0) return Dato;
                else Mensaje("Valor no válido, debe ser entero mayor o igual a cero, reintente por favor");
            } catch (Exception ex) {
                Mensaje("Error. Tipo de dato o valor no válido");
            }
        }
    }

    public int leerEnteroPosMy0(String Texto){
        while(true) {
            try {
                int Dato = Integer.parseInt(JOptionPane.showInputDialog(null, Texto));
                if (Dato > 0) return Dato;
                else Mensaje("Valor no válido, debe ser entero mayor a cero, reintente por favor");
            } catch (Exception ex) {
                Mensaje("Error. Tipo de dato o valor no válido");
            }
        }
    }

    public float leerRealPos_f(String Texto){
        while(true) {
            try {
                float Dato = Float.parseFloat(JOptionPane.showInputDialog(null, Texto));
                if (Dato >= 0) return Dato;
                else Mensaje("Valor no válido, debe ser decimal mayor o igual a cero, reintente por favor");
            } catch (Exception ex) {
                Mensaje("Error. Tipo de dato o valor no válido");
            }
        }
    }

    public float leerRealPosMy0_f(String Texto){
        while(true) {
            try {
                float Dato = Float.parseFloat(JOptionPane.showInputDialog(null, Texto));
                if (Dato > 0) return Dato;
                else Mensaje("Valor no válido, debe ser decimal mayor a cero, reintente por favor");
            } catch (Exception ex) {
                Mensaje("Error. Tipo de dato o valor no válido");
            }
        }
    }
    
    public boolean leerBooleano(String texto) {
        while (true) {
            try {
                String input = JOptionPane.showInputDialog(null, texto + " (true/false)");
                if (input != null && (input.trim().equalsIgnoreCase("true") || input.trim().equalsIgnoreCase("false"))) {
                    return Boolean.parseBoolean(input.trim());
                } else {
                    Mensaje("Error, por favor ingrese 'true' o 'false'");
                }
            } catch (Exception ex) {
                Mensaje("Error. Tipo de dato no válido");
            }
        }
    }
}
