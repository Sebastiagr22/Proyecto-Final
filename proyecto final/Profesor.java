public class Profesor extends Persona {

    /*
     * hereda de persona, esta clase representa a un profesor con una especialidad
     */

    protected String especialidad;

    public Profesor(
            String nombre, String id, String email, String especialidad) {

        super(nombre, id, email);

        this.especialidad = especialidad;
    }
    /*
     * metodo para mostrar la informacion del profesor, sobreescribe el metodo de la
     * clase padre
     */

    @Override
    public void mostrarInformacion() {

        System.out.println(
                "Profesor: " + nombre);

        System.out.println(
                "Especialidad: " + especialidad);
    }
}