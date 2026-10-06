public class Pizza {
    
    private String masa;
    private String salsa;
    private String toppings;
    private int tamano;

    public Pizza(String masa, String salsa, String toppings, int tamano) {
        this.masa = masa;
        this.salsa = salsa;
        this.toppings = toppings;
        this.tamano = tamano;
    }

    public void hacerMasa() {
        System.out.println("Haciendo la masa: " + masa);
    }
    
    public void agregarSalsa() {
        System.out.println("Agregando salsa: " + salsa);
    }

    public void agregarToppings() {
        System.out.println("Agregando ingredientes: " + toppings);
    }

    public void cocinar() {
        System.out.println("cocinando pizza de: " + tamano + "centimetros...");
    }
}
