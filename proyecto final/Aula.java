public class Aula {

    protected String nombre;

    protected boolean horarios[][];

    public Aula(String nombre) {

        this.nombre = nombre;

        horarios = new boolean[7][24];
    }

    public boolean reservar(
            int dia, int hora, int duracion) {

        for (int i = hora;
                i < hora + duracion;
                i++) {

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