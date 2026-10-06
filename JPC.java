import java.util.Scanner;

public class JPC {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        Cocina cocina = new Cocina();

        System.out.println("=============================");
        System.out.println("     JACK PIZZA CHEF");
        System.out.println("=============================");

        System.out.println("Ingrese el numero de orden: ");
        int numeroOrden = scanner.nextInt();

        System.out.println("Ingrese la cantidad de pizzas: ");
        int cantidadPizzas = scanner.nextInt();

        scanner.nextLine();

        System.out.println("Ingrese la masa de la pizza (Integral o Madre): ");
        String masa = scanner.nextLine();
        
        System.out.println("Ingrese la salsa (normal o picante): ");
        String salsa = scanner.nextLine();

        System.out.println("Ingrese los ingredientes o toppings (jamon, pepperoni, chile pimiento, cebolla, tocino): ");
        String ingredientes = scanner.nextLine();

        System.out.println("Ingrese el tamano de la pizza en centrimetros: ");
        int tamano = scanner.nextInt();

        Orden orden = new Orden(numeroOrden, ingredientes, cantidadPizzas);

        cocina.recibirOrden(orden);

        orden.mostrarOrden();

        for (int i = 1; i <= cantidadPizzas; i++) {
            
            System.out.println("\nPizza #" + i);

            Pizza pizza = new Pizza(masa, salsa, ingredientes, tamano);

            cocina.prepararPizza(pizza);
        }


        cocina.terminarOrden();

        System.out.println("\nGracias por utilizar Jack Pizza Chef.");

        scanner.close();
    }

}
