public class Orden {
    
    private int numOrden;
    private String ingredientes;
    private int cantPizzas;

    public Orden(int numOrden, String ingredientes, int cantPizzas) {
        this.numOrden = numOrden;
        this.ingredientes = ingredientes;
        this.cantPizzas = cantPizzas;
    }

    public void mostrarOrden() {
        System.out.println("\n----- ORDEN -----");
        System.out.println("Numero de orden" + numOrden);
        System.out.println("Ingredientes: " + ingredientes);
        System.out.println("Cantidad de pizzas: " + cantPizzas);
        System.out.println("-----------------");
    }

    public int getCantPizzas() {
        return cantPizzas;
    }
}
