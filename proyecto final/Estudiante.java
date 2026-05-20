import java.util.LinkedList;
import java.util.HashMap;

/*hereda de persona */
public class Estudiante extends Persona {

    protected int semestre;

    protected LinkedList<Materia> materias;

    protected HashMap<String, Double> notas;

    public Estudiante(
            String nombre, String id, String email, int semestre) {

        super(nombre, id, email);

        this.semestre = semestre;

        /*- HashMap para guardar notas, LinkedList para historial*/

        materias = new LinkedList<Materia>();

        notas = new HashMap<String, Double>();
    }

    @Override
    public void mostrarInformacion() {

        System.out.println(
                "Nombre: " + nombre);

        System.out.println(
                "ID: " + id);

        System.out.println(
                "Email: " + email);

        System.out.println(
                "Semestre: " + semestre);

        System.out.println(
                "Promedio: " + calcularPromedio());
    }

    public void agregarMateria(
            Materia materia) {

        materias.add(materia);
    }

    public void eliminarMateria(
            Materia materia) {

        materias.remove(materia);
    }

    public void registrarNota(
            String codigo, double nota) {

        notas.put(codigo, nota);
    }

    public double calcularPromedio() {

        if (notas.size() == 0) {

            return 0;
        }

        double suma = 0;

        for (double nota : notas.values()) {

            suma = suma + nota;
        }

        return suma / notas.size();
    }

    public void mostrarNotas() {

        if (notas.isEmpty()) {

            System.out.println(
                    "No hay notas");

            return;
        }

        for (String codigo : notas.keySet()) {

            System.out.println(
                    codigo + " -> " + notas.get(codigo));
        }

        System.out.println(
                "Promedio: "
                        + calcularPromedio());
    }

    public LinkedList<Materia> getMaterias() {

        return materias;
    }
}