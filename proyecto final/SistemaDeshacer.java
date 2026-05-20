import java.util.Stack;
public class SistemaDeshacer {
/*esta clase se encarga de manejar las operaciones de deshacer y rehacer*/
    protected Stack<String> pilaDeshacer;

    protected Stack<String> pilaRehacer;

    public SistemaDeshacer() {

        pilaDeshacer =
                new Stack<String>();

        pilaRehacer =
                new Stack<String>();
    }
 /*metodo para guardar las operaciones en la pila de deshacer*/

    public void guardarOperacion(
            String operacion) {

        pilaDeshacer.push(operacion);

        System.out.println(
                "Operacion guardada");
    }

    public void deshacer() {

        if (!pilaDeshacer.isEmpty()) {

            String operacion =
                    pilaDeshacer.pop();

            pilaRehacer.push(operacion);

            System.out.println(
                    "Operacion deshecha: "
                    + operacion);

        } else {

            System.out.println(
                    "No hay operaciones");
        }
    }
 /*metodo para rehacer las operaciones guardadas en la pila de rehacer*/
    public void rehacer() {

        if (!pilaRehacer.isEmpty()) {

            String operacion =
                    pilaRehacer.pop();

            pilaDeshacer.push(operacion);

            System.out.println(
                    "Operacion rehecha: "
                    + operacion);

        } else {

            System.out.println(
                    "No hay operaciones");
        }
    }
}