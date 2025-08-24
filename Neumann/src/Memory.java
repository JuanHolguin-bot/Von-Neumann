import java.util.HashMap;
import java.util.Map;

public class Memory {

    public Memory() {
    }

    private String registroDirecciones;
    private String registroDatos;

    private Map<String,String> memoria =  new HashMap<>();  //Dirección - dato

    public void ingresarMemoria(String direccion,String dato){
        if (direccion.length() != 4 ){ throw new IllegalArgumentException("La dirección debe ser de 4 bits");}
        if (dato.length() != 8 ){ throw new IllegalArgumentException("El dato debe ser de 8 bits");}

        memoria.put(direccion,dato);
    }

    public String leer(String direccion){
        direccion = memoria.get(direccion);
        return direccion;
    }

}