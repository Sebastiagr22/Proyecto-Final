import java.util.Scanner;
import java.util.HashMap;

public class Simulador {

    public static void main(String[] args) {

        Scanner scanner =
                new Scanner(System.in);

        HashMap<String, Estudiante>
                estudiantes =
                new HashMap<String, Estudiante>();

        HashMap<String, Materia>
                materias =
                new HashMap<String, Materia>();

        Aula aula =
                new Aula("Aula 101");

        Rutas rutas =
                new Rutas();

        SistemaDeshacer sistema =
                new SistemaDeshacer();

        ReporteAcademico reporte =
                new ReporteAcademico();

        int opcion = 0;

        while (opcion != 21) {

            System.out.println("");
            System.out.println("=== GESTION DE ESTUDIANTES ===");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Buscar estudiante");
            System.out.println("3. Listar estudiantes");
            System.out.println("4. Eliminar estudiante");

            System.out.println("");
            System.out.println("=== GESTION DE MATERIAS ===");
            System.out.println("5. Crear materia");
            System.out.println("6. Agregar pre requisito");
            System.out.println("7. Mostrar pre requisitos");
            System.out.println("8. Inscribir estudiante");
            System.out.println("9. Cancelar inscripcion");
            System.out.println("10. Mostrar cola");

            System.out.println("");
            System.out.println("=== GESTION HORARIOS ===");
            System.out.println("11. Reservar horario");
            System.out.println("12. Liberar horario");
            System.out.println("13. Consultar horario");

            System.out.println("");
            System.out.println("=== RUTAS ===");
            System.out.println("14. Calcular ruta mas corta");
            System.out.println("15. Mostrar matriz");

            System.out.println("");
            System.out.println("=== REPORTES ===");
            System.out.println("16. Registrar nota");
            System.out.println("17. Ver reporte");

            System.out.println("");
            System.out.println("=== DESHACER ===");
            System.out.println("18. Deshacer");
            System.out.println("19. Rehacer");

            System.out.println("");
            System.out.println("20. Navegacion reportes");

            System.out.println("");
            System.out.println("21. Salir");

            System.out.print("Seleccione opcion: ");

            opcion = scanner.nextInt();

            scanner.nextLine();

            switch (opcion) {

                case 1:

                    System.out.print("Nombre: ");
                    String nombre =
                            scanner.nextLine();

                    System.out.print("ID: ");
                    String id =
                            scanner.nextLine();

                    System.out.print("Email: ");
                    String email =
                            scanner.nextLine();

                    System.out.print("Semestre: ");
                    int semestre =
                            scanner.nextInt();

                    Estudiante estudiante =
                            new Estudiante(
                                    nombre,
                                    id,
                                    email,
                                    semestre);

                    estudiantes.put(
                            id,
                            estudiante);

                    sistema.guardarOperacion(
                            "Registrar estudiante");

                    System.out.println(
                            "Estudiante registrado");

                    break;

                case 2:

                    System.out.print(
                            "Ingrese ID: ");

                    String buscar =
                            scanner.nextLine();

                    if (estudiantes.containsKey(
                            buscar)) {

                        estudiantes.get(buscar)
                                .mostrarInformacion();

                    } else {

                        System.out.println(
                                "Estudiante no encontrado");
                    }

                    break;

                case 3:

                    if (estudiantes.isEmpty()) {

                        System.out.println(
                                "No hay estudiantes");

                    } else {

                        for (Estudiante e :
                                estudiantes.values()) {

                            e.mostrarInformacion();

                            System.out.println("");
                        }
                    }

                    break;

                case 4:

                    System.out.print(
                            "ID estudiante: ");

                    String eliminar =
                            scanner.nextLine();

                    if (estudiantes.containsKey(
                            eliminar)) {

                        estudiantes.remove(
                                eliminar);

                        System.out.println(
                                "Estudiante eliminado");

                    } else {

                        System.out.println(
                                "No existe");
                    }

                    break;

                case 5:

                    System.out.print(
                            "Codigo: ");

                    String codigo =
                            scanner.nextLine();

                    System.out.print(
                            "Nombre materia: ");

                    String nombreMateria =
                            scanner.nextLine();

                    System.out.print(
                            "Cupos: ");

                    int cupos =
                            scanner.nextInt();

                    System.out.print(
                            "Creditos: ");

                    int creditos =
                            scanner.nextInt();

                    System.out.print(
                            "Dia: ");

                    int dia =
                            scanner.nextInt();

                    System.out.print(
                            "Hora: ");

                    int hora =
                            scanner.nextInt();

                    Materia materia =
                            new Materia(
                                    codigo,
                                    nombreMateria,
                                    cupos,
                                    creditos,
                                    dia,
                                    hora);

                    materias.put(
                            codigo,
                            materia);

                    System.out.println(
                            "Materia creada");

                    break;

                case 6:

                    System.out.print(
                            "Codigo materia: ");

                    String cod =
                            scanner.nextLine();

                    System.out.print(
                            "Pre requisito: ");

                    String pre =
                            scanner.nextLine();

                    if (materias.containsKey(cod)) {

                        materias.get(cod)
                                .agregarPreRequisito(pre);

                    } else {

                        System.out.println(
                                "Materia no existe");
                    }

                    break;

                case 7:

                    System.out.print(
                            "Codigo materia: ");

                    String mostrar =
                            scanner.nextLine();

                    if (materias.containsKey(
                            mostrar)) {

                        materias.get(mostrar)
                                .mostrarPreRequisitos();

                    } else {

                        System.out.println(
                                "Materia no encontrada");
                    }

                    break;

                case 8:

                    System.out.print(
                            "ID estudiante: ");

                    String idEst =
                            scanner.nextLine();

                    System.out.print(
                            "Codigo materia: ");

                    String codMat =
                            scanner.nextLine();

                    if (estudiantes.containsKey(idEst)
                            &&
                            materias.containsKey(codMat)) {

                        materias.get(codMat)
                                .inscribirEstudiante(
                                        estudiantes.get(idEst));

                    } else {

                        System.out.println(
                                "Datos invalidos");
                    }

                    break;

                case 9:

                    System.out.print(
                            "ID estudiante: ");

                    String idCan =
                            scanner.nextLine();

                    System.out.print(
                            "Codigo materia: ");

                    String matCan =
                            scanner.nextLine();

                    if (estudiantes.containsKey(idCan)
                            &&
                            materias.containsKey(matCan)) {

                        materias.get(matCan)
                                .cancelarInscripcion(
                                        estudiantes.get(idCan));

                    } else {

                        System.out.println(
                                "Datos invalidos");
                    }

                    break;

                case 10:

                    System.out.print(
                            "Codigo materia: ");

                    String cola =
                            scanner.nextLine();

                    if (materias.containsKey(
                            cola)) {

                        materias.get(cola)
                                .mostrarCola();

                    } else {

                        System.out.println(
                                "Materia no encontrada");
                    }

                    break;

                case 11:

                    System.out.print(
                            "Dia: ");

                    int diaReserva =
                            scanner.nextInt();

                    System.out.print(
                            "Hora: ");

                    int horaReserva =
                            scanner.nextInt();

                    System.out.print(
                            "Duracion: ");

                    int duracion =
                            scanner.nextInt();

                    aula.reservar(
                            diaReserva,
                            horaReserva,
                            duracion);

                    break;

                case 12:

                    System.out.print(
                            "Dia: ");

                    int diaLiberar =
                            scanner.nextInt();

                    System.out.print(
                            "Hora: ");

                    int horaLiberar =
                            scanner.nextInt();

                    System.out.print(
                            "Duracion: ");

                    int duracionLiberar =
                            scanner.nextInt();

                    aula.liberar(
                            diaLiberar,
                            horaLiberar,
                            duracionLiberar);

                    break;

                case 13:

                    System.out.print(
                            "Dia: ");

                    int diaConsulta =
                            scanner.nextInt();

                    System.out.print(
                            "Hora: ");

                    int horaConsulta =
                            scanner.nextInt();

                    aula.consultar(
                            diaConsulta,
                            horaConsulta);

                    break;

                case 14:

                    rutas.mostrarEdificios();

                    System.out.print(
                            "Origen: ");

                    int origenRuta =
                            scanner.nextInt();

                    System.out.print(
                            "Destino: ");

                    int destinoRuta =
                            scanner.nextInt();

                    rutas.dijkstra(
                            origenRuta,
                            destinoRuta);

                    break;

                case 15:

                    rutas.mostrarMatriz();

                    break;

                case 16:

                    System.out.print(
                            "ID estudiante: ");

                    String notaId =
                            scanner.nextLine();

                    System.out.print(
                            "Codigo materia: ");

                    String notaMat =
                            scanner.nextLine();

                    System.out.print(
                            "Nota: ");

                    double nota =
                            scanner.nextDouble();

                    if (estudiantes.containsKey(
                            notaId)) {

                        estudiantes.get(notaId)
                                .registrarNota(
                                        notaMat,
                                        nota);

                        System.out.println(
                                "Nota registrada");

                    } else {

                        System.out.println(
                                "Estudiante no encontrado");
                    }

                    break;

                case 17:

                    System.out.print(
                            "ID estudiante: ");

                    String rep =
                            scanner.nextLine();

                    if (estudiantes.containsKey(
                            rep)) {

                        reporte.mostrarReporte(
                                estudiantes.get(rep));

                    } else {

                        System.out.println(
                                "No encontrado");
                    }

                    break;

                case 18:

                    sistema.deshacer();

                    break;

                case 19:

                    sistema.rehacer();

                    break;

                case 20:

                    System.out.println(
                            "Sistema de navegacion");

                    System.out.println(
                            "Use deshacer y rehacer");

                    break;

                case 21:

                    System.out.println(
                            "Fin del programa");

                    break;

                default:

                    System.out.println(
                            "Opcion invalida");
            }
        }

        scanner.close();
    }
}