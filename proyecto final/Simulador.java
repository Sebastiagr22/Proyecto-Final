import java.util.Scanner;
import java.util.HashMap;
import java.util.LinkedList;
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

        ProcesadorLotes lotes =
                new ProcesadorLotes();

        int opcion = 0;

        while (opcion != 22) {

            System.out.println("");
            System.out.println("=== GESTION DE ESTUDIANTES ===");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Buscar estudiante");
            System.out.println("3. Listar estudiantes");
            System.out.println("4. Eliminar estudiante");

            System.out.println("=== GESTION DE MATERIAS ===");
            System.out.println("5. Crear materia");
            System.out.println("6. Agregar pre requisito");
            System.out.println("7. Mostrar pre requisitos");
            System.out.println("8. Inscribir estudiante");
            System.out.println("9. Cancelar inscripcion");
            System.out.println("10. Mostrar cola");

            System.out.println("=== GESTION HORARIOS ===");
            System.out.println("11. Reservar horario");
            System.out.println("12. Liberar horario");
            System.out.println("13. Consultar horario");

            System.out.println("=== RUTAS ===");
            System.out.println("14. Agregar conexion");
            System.out.println("15. Mostrar ruta");

            System.out.println("=== REPORTES ===");
            System.out.println("16. Registrar nota");
            System.out.println("17. Ver reporte");

            System.out.println("=== DESHACER ===");
            System.out.println("18. Deshacer");
            System.out.println("19. Rehacer");

            System.out.println("=== LOTES ===");
            System.out.println("20. Procesar lotes");

            System.out.println("21. Mostrar matriz");

            System.out.println("22. Salir");

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
                                "No encontrado");
                    }

                    break;

                case 3:

                    for (Estudiante e :
                            estudiantes.values()) {

                        e.mostrarInformacion();

                        System.out.println("");
                    }

                    break;

                case 4:

                    System.out.print(
                            "ID: ");

                    String eliminar =
                            scanner.nextLine();

                    estudiantes.remove(eliminar);

                    System.out.println(
                            "Eliminado");

                    break;

                case 5:

                    System.out.print(
                            "Codigo: ");

                    String codigo =
                            scanner.nextLine();

                    System.out.print(
                            "Nombre: ");

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

                    materias.get(cod)
                            .agregarPreRequisito(pre);

                    break;

                case 7:

                    System.out.print(
                            "Codigo materia: ");

                    String mostrar =
                            scanner.nextLine();

                    materias.get(mostrar)
                            .mostrarPreRequisitos();

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

                    materias.get(codMat)
                            .inscribirEstudiante(
                                    estudiantes.get(idEst));

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

                    materias.get(matCan)
                            .cancelarInscripcion(
                                    estudiantes.get(idCan));

                    break;

                case 10:

                    System.out.print(
                            "Codigo materia: ");

                    String cola =
                            scanner.nextLine();

                    materias.get(cola)
                            .mostrarCola();

                    break;

                case 11:

                    aula.reservar(1, 8, 2);

                    break;

                case 12:

                    aula.liberar(1, 8, 2);

                    break;

                case 13:

                    aula.consultar(1, 8);

                    break;

                case 14:

    System.out.println("0. Ingenieria");
    System.out.println("1. Biblioteca");
    System.out.println("2. Cafeteria");
    System.out.println("3. Rectoria");
    System.out.println("4. Laboratorios");

    System.out.print("Origen: ");
    int origen = scanner.nextInt();

    System.out.print("Destino: ");
    int destino = scanner.nextInt();

    System.out.print("Distancia: ");
    int distancia = scanner.nextInt();

    rutas.conectar(
            origen,
            destino,
            distancia);

    break;
               case 15:

    System.out.println("0. Ingenieria");
    System.out.println("1. Biblioteca");
    System.out.println("2. Cafeteria");
    System.out.println("3. Rectoria");
    System.out.println("4. Laboratorios");

    System.out.print("Origen: ");
    int origenRuta = scanner.nextInt();

    System.out.print("Destino: ");
    int destinoRuta = scanner.nextInt();

    rutas.mostrarRuta(
            origenRuta,
            destinoRuta);

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

                    estudiantes.get(notaId)
                            .registrarNota(
                                    notaMat,
                                    nota);

                    System.out.println(
                            "Nota registrada");

                    break;

                case 17:

                    System.out.print(
                            "ID estudiante: ");

                    String rep =
                            scanner.nextLine();

                    reporte.mostrarReporte(
                            estudiantes.get(rep));

                    break;

                case 18:

                    sistema.deshacer();

                    break;

                case 19:

                    sistema.rehacer();

                    break;

                case 20:

                    LinkedList<String> datos =
                            new LinkedList<String>();

                    datos.add(
                            "Juan,CALC1,4.5");

                    datos.add(
                            "Ana,POO,3.8");

                    lotes.procesarNotas(datos);

                    break;

                case 21:

                    rutas.mostrarMatriz();

                    break;

                case 22:

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