public class Profesor extends Persona {

    protected String especialidad;

    public Profesor(
            String nombre,
            String id,
            String email,
            String especialidad) {

        super(nombre, id, email);

        this.especialidad = especialidad;
    }

    @Override
    public void mostrarInformacion() {

        System.out.println(
                "Profesor: " + nombre);

        System.out.println(
                "Especialidad: "
                + especialidad);
    }
}