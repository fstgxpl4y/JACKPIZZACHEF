public class Cocina {
    
    private HerramientasCocina herramientas;
    private int ordenesPendientes;
    private int temperatura;

    public Cocina() {
        herramientas = new HerramientasCocina();
        ordenesPendientes = 0;
        temperatura = 0;
    }

    public void recibirOrden(Orden orden) {
        ordenesPendientes++;
        System.out.println("\nLa cocina recibio la orden.");
        System.out.println("Ordenes pendientes: " + ordenesPendientes);

    }

    public void prepararPizza(Pizza pizza) {
        System.out.println("\n----- PREPARANDO PIZZA -----");
        pizza.hacerMasa();
        herramientas.usarRodillo();
        pizza.agregarSalsa();
        pizza.agregarToppings();
        herramientas.usarPalaPizza();

        temperatura = 420;
        System.out.println("Temperatura del horno: " + temperatura + "Grados.");

        pizza.cocinar();
        herramientas.usarCortaPizza();

        System.out.println("Pizza terminada.");

    }

    public void terminarOrden() {
        if (ordenesPendientes > 0) {

            ordenesPendientes--;

            System.out.println("\nOrden terminada.");
            System.out.println("Ordenes pendientes: " + ordenesPendientes);

        } else {
            
            System.out.println("No hay órdenes pendientes.");
        }
    }
}
