import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Conversor conversor = new Conversor();

        while (true){
            // Menu Principal
            System.out.println("""
                    -------------- Bienvenido al conversor de monedas! -------------
                        Selecciona una operacion:
                            1) Convertir divisas
                            2) Mostrar historial de transacciones
                            0) Salir del programa
                    ----------------------------------------------------------------
                    Opcion:""");

            int userTipoConversion = scanner.nextInt();

            if (userTipoConversion == 0){
                break;
            }
            switch (userTipoConversion){
                case 1:
                    convertirDivisa(scanner, conversor);
                    break;
                case 2:
                    conversor.muestraTransacciones();
                    break;
                default:
                    System.out.println("Opcion no valida!");
                    break;
            }
        }
        System.out.println(" Cerrando programa...");
    }

    private static void convertirDivisa(Scanner scanner, Conversor conversor){
        while (true){
            // Menu Convesor
            System.out.println();
            System.out.println("""
                        -------------- Bienvenido al conversor de monedas! -------------
                           Selecciona una opcion:
                               1) De Peso Mexicano --> Dolar
                               2) De Dolar --> Peso Mexicano
                               3) De Yen --> Dolar
                               4) De Dolar --> Yen
                               5) De Euro --> Dolar
                               6) De Dolar --> Euro
                               0) Regresar al menu principal
                        ----------------------------------------------------------------
                        Opcion:""");

            int userTipoConversion = scanner.nextInt();
            if (userTipoConversion == 0 | userTipoConversion < 1 | userTipoConversion > 6){
                return;
            }

            System.out.println("""
                    ------------------- Convirtiendo! -------------------
                        Introduzca el monto a convertir:""");
            double userMonto = scanner.nextDouble();

            try {
                switch (userTipoConversion){
                    case 1:
                        System.out.println(conversor.obtenerConversion("MXN", "USD", userMonto));
                        break;
                    case 2:
                        System.out.println(conversor.obtenerConversion("USD", "MXN", userMonto));
                        break;
                    case 3:
                        System.out.println(conversor.obtenerConversion("JPY", "USD", userMonto));
                        break;
                    case 4:
                        System.out.println(conversor.obtenerConversion("USD", "JPY", userMonto));
                        break;
                    case 5:
                        System.out.println(conversor.obtenerConversion("EUR", "USD", userMonto));
                        break;
                    case 6:
                        System.out.println(conversor.obtenerConversion("USD", "EUR", userMonto));
                        break;
                }
                System.out.println("-----------------------------------------------------\n");

            } catch (IOException | InterruptedException e) {
                System.out.println("Hubo un problema al convertir la moneda!");
                System.out.println(e.getMessage());
                return;
            } catch (Exception e){
                System.out.println("Error Inesperado!");
                return;
            }
        }
    }
}