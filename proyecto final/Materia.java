import java.util.LinkedList;
import java.util.Queue;

public class Materia {

    protected String codigo;
    protected String nombre;
    protected int cupos;
    protected int creditos;

    protected int dia;
    protected int hora;
    /* aqui se definen los pre requisitos */
    protected LinkedList<String> preRequisitos;

    /* aqui se definen los estudiantes inscritos */
    protected LinkedList<Estudiante> inscritos;

    /* aqui se define la cola de espera */
    protected Queue<Estudiante> colaEspera;

    public Materia(
            String codigo, String nombre, int cupos, int creditos, int dia, int hora) {

        this.codigo = codigo;
        this.nombre = nombre;
        this.cupos = cupos;
        this.creditos = creditos;
        this.dia = dia;
        this.hora = hora;

        preRequisitos = new LinkedList<String>();

        inscritos = new LinkedList<Estudiante>();

        colaEspera = new LinkedList<Estudiante>();
    }

    public void agregarPreRequisito(
            String materia) {

        preRequisitos.add(materia);

        System.out.println(
                "Pre requisito agregado");
    }

    public void mostrarPreRequisitos() {

        System.out.println(
                "Pre requisitos:");

        for (String materia : preRequisitos) {

            System.out.println(materia);
        }
    }

    public void inscribirEstudiante(
            Estudiante estudiante) {

        if (inscritos.size() < cupos) {

            inscritos.add(estudiante);

            estudiante.agregarMateria(this);

            System.out.println(
                    "Estudiante inscrito");

        } else {

            colaEspera.offer(estudiante);

            System.out.println(
                    "Materia llena");

            System.out.println(
                    "Agregado a cola");
        }
    }
    /*
     * aqui se cancela la inscripcion de un estudiante, si el estudiante estaba
     * inscrito, se elimina de la
     * lista de inscritos y se agrega a la materia al siguiente estudiante en la
     * cola de espera.
     * Si el estudiante no estaba inscrito, se muestra un mensaje indicando que no
     * estaba inscrito.
     */

    public void cancelarInscripcion(
            Estudiante estudiante) {

        if (inscritos.remove(estudiante)) {

            estudiante.eliminarMateria(this);

            System.out.println(
                    "Inscripcion cancelada");

            if (!colaEspera.isEmpty()) {

                Estudiante siguiente = colaEspera.poll();

                inscritos.add(siguiente);

                siguiente.agregarMateria(this);

                System.out.println(
                        siguiente.getNombre()
                                + " ingreso desde cola");
            }

        } else {

            System.out.println(
                    "No estaba inscrito");
        }
    }

    /* aqui se muestra la lista de estudiantes inscritos y la cola de espera. */
    public void mostrarInscritos() {

        System.out.println(
                "Inscritos:");

        for (Estudiante e : inscritos) {

            System.out.println(
                    e.getNombre());
        }
    }

    public void mostrarCola() {

        System.out.println(
                "Cola de espera:");

        for (Estudiante e : colaEspera) {

            System.out.println(
                    e.getNombre());
        }
    }

    public String getCodigo() {

        return codigo;
    }

    public String getNombre() {

        return nombre;
    }

    public int getDia() {

        return dia;
    }

    public int getHora() {

        return hora;
    }
}