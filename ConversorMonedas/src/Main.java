import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Conversor conversor = new Conversor();

        while (true){
            // Menu
            System.out.println("""
                    -------------- Bienvenido al conversor de monedas! -------------
                       Selecciona una opcion:
                           1) De Peso Mexicano --> Dolar
                           2) De Dolar --> Peso Mexicano
                           3) De Yen --> Dolar
                           4) De Dolar --> Yen
                           5) De Euro --> Dolar
                           6) De Dolar --> Euro
                           0) Salir del programa
                    ----------------------------------------------------------------
                    Opcion:""");
            int userTipoConversion = scanner.nextInt();

            if (userTipoConversion == 0){
                break;
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
            } catch (Exception e){
                System.out.println("Error Inesperado!");
                break;
            }
        }
        System.out.println(" Cerrando programa...");
    }
}