Al principio me di cuenta de que el UML que había hecho no estaba bien para convertirlo
directamente en código. Por ejemplo, en Pizza solo tenía los atributos escritos de una
forma muy básica:

String masa;
String salsa;
String toppings;
int tamaño;

Después vi que necesitaba organizar mejor la clase, así que agregué un constructor:

public Pizza(String masa, String salsa, String toppings, int tamaño) {
    this.masa = masa;
    this.salsa = salsa;
    this.toppings = toppings;
    this.tamaño = tamaño;
}

También me di cuenta de que en Cocina no estaba claro cómo iba a recibir una orden, por lo
que agregué un método:

public void recibirOrden(Order orden) {
    ordenesPendientes++;
}

Otro cambio fue que antes la información de la orden prácticamente estaba fija, pero
después pensé que sería mejor que el usuario pudiera ingresar sus propias indicaciones. Por
eso agregué Scanner:

Scanner scanner = new Scanner(System.in);
System.out.print("Ingrese la cantidad de pizzas: ");
int cantidadPizzas = scanner.nextInt();
scanner.nextLine();
System.out.print("Ingrese los ingredientes: ");
String ingredientes = scanner.nextLine();

También agregué un ciclo para que, si el usuario pide varias pizzas, el programa las
prepare todas:

for (int i = 1; i <= cantidadPizzas; i++) {
    Pizza pizza = new Pizza(masa, salsa, ingredientes, tamaño);
    cocina.prepararPizza(pizza);
}

Así fui corrigiendo los errores que encontré mientras intentaba pasar el UML a Java. Al
final, el programa ya no solo representa las clases del UML, sino que también permite
ingresar una orden desde la terminal y simula el proceso de preparar las pizzas.