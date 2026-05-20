public class Rutas {

    protected int distancias[][];

    protected String edificios[];

    /*
     Constructor
    */
    public Rutas() {

        edificios = new String[5];

        distancias = new int[5][5];

        edificios[0] = "Ingenieria";
        edificios[1] = "Biblioteca";
        edificios[2] = "Cafeteria";
        edificios[3] = "Rectoria";
        edificios[4] = "Laboratorios";

        /*
         Conexiones ya definidas
        */

        distancias[0][1] = 100;
        distancias[1][0] = 100;

        distancias[1][2] = 50;
        distancias[2][1] = 50;

        distancias[2][3] = 180;
        distancias[3][2] = 180;

        distancias[0][4] = 200;
        distancias[4][0] = 200;

        distancias[4][3] = 120;
        distancias[3][4] = 120;
    }

    /*
     Muestra edificios
    */
    public void mostrarEdificios() {

        for (int i = 0; i < edificios.length; i++) {

            System.out.println(
                    i + ". " + edificios[i]);
        }
    }

    /*
     Muestra matriz
    */
    public void mostrarMatriz() {

        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < 5; j++) {

                System.out.print(
                        distancias[i][j] + " ");
            }

            System.out.println();
        }
    }

    /*
     Dijkstra basico
    */
    public void dijkstra(
        int origen,
        int destino) {

    if (distancias[origen][destino] != 0) {

        System.out.println(
                "Ruta mas corta:");

        System.out.println(
                edificios[origen]
                + " -> "
                + edificios[destino]);

        System.out.println(
                "Distancia total: "
                + distancias[origen][destino]
                + " metros");

    } else {

        /*
         Buscar rutas intermedias
        */

        for (int i = 0; i < 5; i++) {

            if (distancias[origen][i] != 0
                    &&
                    distancias[i][destino] != 0) {

                int total =
                        distancias[origen][i]
                        +
                        distancias[i][destino];

                System.out.println(
                        "Ruta mas corta:");

                System.out.println(
                        edificios[origen]
                        + " -> "
                        + edificios[i]
                        + " -> "
                        + edificios[destino]);

                System.out.println(
                        "Distancia total: "
                        + total
                        + " metros");

                return;
            }
        }

        System.out.println(
                "No existe ruta");
    }
}
}