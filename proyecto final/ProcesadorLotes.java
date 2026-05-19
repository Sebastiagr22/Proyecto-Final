import java.util.LinkedList;
public class ProcesadorLotes {

    public void procesarNotas(
            LinkedList<String> datos) {

        System.out.println(
                "Procesando lotes");

        for (String linea : datos) {

            System.out.println(
                    "Procesado: "
                    + linea);
        }
    }
}