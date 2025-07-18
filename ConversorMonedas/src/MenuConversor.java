import java.util.Scanner;

/**
 * Clase encargada de mostrar el menú interactivo en consola,
 * capturar la entrada del usuario y coordinar la conversión de monedas.
 */


public class MenuConversor {

    /**
     * Muestra el menú principal y gestiona el ciclo de interacción con el usuario.
     * Permite elegir una conversión de moneda, ingresar la cantidad y visualizar el resultado.
     */

    public void mostrarMenu(){
        Scanner scanner = new Scanner(System.in);
        ClienteAPI clienteAPI = new ClienteAPI(); // Cliente para conectarse a la API

        TasasCambio tasas = clienteAPI.obtenerTasaCambio("MXN"); // base: peso mexicano
        ConversorMonedas conversor = new ConversorMonedas(tasas);// Clase encargada de realizar las conversiones

        boolean continuar = true;

        while (continuar) {
            // Mostrar opciones al usuario

            System.out.println("\n\tBienvenid@ al Conversor de Monedas :D");
            System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::");

            System.out.println("Ingrese la opcion deseada: \n");
            System.out.println("1) Peso mexicano -> Yuan [Moneda china]");
            System.out.println("2) Yuan [moneda china] -> Peso mexicano");
            System.out.println("3) Peso mexicano -> Won [Moneda surcoreana] ");
            System.out.println("4) Won [moneda surcoreana] -> Peso mexicano");
            System.out.println("5) Peso mexicano -> Yen [Moneda japonesa]");
            System.out.println("6) Yen [moneda japonesa] -> Peso mexicano");
            System.out.println("\n7) Salir");

            System.out.println("\n:::::::::::::::::::::::::::::::::::::::::::::::::");
            System.out.print("Opción: ");
            int opcion = scanner.nextInt();

            // Salir del programa si elige la opción 7
            if (opcion == 7) {
                continuar = false;
                System.out.println("👋 Gracias por usar el conversor. ¡Hasta pronto! :D");
                break;
            }

            // Validar que la opción esté entre 1 y 6 antes de pedir cantidad
            if (opcion < 1 || opcion > 6) {
                System.out.println("** Opción inválida. Intente de nuevo. **");
                continue; // vuelve a mostrar el menú sin pedir cantidad
            }

            // Capturar la cantidad a convertir
            System.out.print("Ingrese la cantidad a convertir: ");
            double cantidad = scanner.nextDouble();
            System.out.println("\n:::::::::::::::::::::::::::::::::::::::::::::::::");

            // Determinar monedas según la opción
            String monedaOrigen = "";
            String monedaDestino = "";

            switch (opcion) {
                case 1 -> { monedaOrigen = "MXN"; monedaDestino = "CNY"; }
                case 2 -> { monedaOrigen = "CNY"; monedaDestino = "MXN"; }
                case 3 -> { monedaOrigen = "MXN"; monedaDestino = "KRW"; }
                case 4 -> { monedaOrigen = "KRW"; monedaDestino = "MXN"; }
                case 5 -> { monedaOrigen = "MXN"; monedaDestino = "JPY"; }
                case 6 -> { monedaOrigen = "JPY"; monedaDestino = "MXN"; }
            }

            try {
                double resultado = conversor.convertir(monedaOrigen, monedaDestino, cantidad);

                System.out.println("\n:::::::::::::::::::::::::::::::::::::::::::::::::");
                System.out.printf("\t %.2f %s equivale a %.2f %s",
                        cantidad, monedaOrigen, resultado, monedaDestino);
                System.out.println("\n:::::::::::::::::::::::::::::::::::::::::::::::::\n\n");

            } catch (IllegalArgumentException e) {
                System.out.println("\n:::::::::::::::::::::::::::::::::::::::::::::::::");
                System.out.println("❌ Error en la conversión: " + e.getMessage() +"❌");
                System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::\n\n");
            }

        }

    }
}
