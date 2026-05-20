public class ReporteAcademico {

        /* metodo para mostrar el reporte academico de un estudiante */

        public void mostrarReporte(
                        Estudiante estudiante) {

                System.out.println(
                                "REPORTE");

                estudiante.mostrarInformacion();

                estudiante.mostrarNotas();

                System.out.println(
                                "Materias inscritas:");

                for (Materia materia : estudiante.getMaterias()) {

                        System.out.println(
                                        materia.getCodigo() + " - " + materia.getNombre());
                }
        }
}