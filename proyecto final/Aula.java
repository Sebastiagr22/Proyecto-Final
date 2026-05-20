public class Aula {
/*esta clase representa un aula con un horario de reservas*/

    protected String nombre;

    protected boolean horarios[][];

    public Aula(String nombre) {

        this.nombre = nombre;

        horarios = new boolean[7][24];
    }
/*metodo para reservar un horario en el aula, recibe el dia, la hora y la duracion de la reserva*/

    public boolean reservar(
            int dia, int hora, int duracion) {

        for (int i = hora; i < hora + duracion; i++) {

            if (horarios[dia][i]) {

                System.out.println(
                        "Horario ocupado");

                return false;
            }
        }

        for (int i = hora;
                i < hora + duracion;
                i++) {

            horarios[dia][i] = true;
        }

        System.out.println(
                "Horario reservado");

        return true;
    }
/*metodo para liberar un horario en el aula, recibe el dia, la hora y la duracion de la reserva a liberar*/
    public void liberar(
            int dia, int hora, int duracion) {

        for (int i = hora;
                i < hora + duracion;
                i++) {

            horarios[dia][i] = false;
        }

        System.out.println(
                "Horario liberado");
    }
 /*metodo para consultar si un horario esta ocupado o libre, recibe el dia y la hora a consultar*/
 
    public void consultar(
            int dia, int hora) {

        if (horarios[dia][hora]) {

            System.out.println(
                    "Horario ocupado");

        } else {

            System.out.println(
                    "Horario libre");
        }
    }
}