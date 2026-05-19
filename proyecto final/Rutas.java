public class Rutas {

    protected int distancias[][];

    protected String edificios[];

    public Rutas() {

        edificios = new String[5];

        distancias = new int[5][5];

        edificios[0] = "Ingenieria";
        edificios[1] = "Biblioteca";
        edificios[2] = "Cafeteria";
        edificios[3] = "Rectoria";
        edificios[4] = "Laboratorios";
    }

    public void conectar(
            int origen,
            int destino,
            int distancia) {

        distancias[origen][destino] =
                distancia;

        distancias[destino][origen] =
                distancia;

        System.out.println(
                "Conexion agregada");
    }

    public void mostrarMatriz() {

        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < 5; j++) {

                System.out.print(
                        distancias[i][j]
                        + " ");
            }

            System.out.println();
        }
    }

    public void mostrarRuta(
            int origen,
            int destino) {

        if (distancias[origen][destino] != 0) {

            System.out.println(
                    edificios[origen]
                    + " -> "
                    + edificios[destino]);

            System.out.println(
                    "Distancia: "
                    + distancias[origen][destino]);

        } else {

            System.out.println(
                    "No existe ruta");
        }
    }
}