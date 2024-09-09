import java.util.Scanner;

public class Clase1 {
    private static int numeroPedido = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Recolectar los datos 
        System.out.print("Introduce tu nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Introduce tu dirección: ");
        String direccion = scanner.nextLine();

        System.out.print("Introduce tu correo electrónico: ");
        String correo = scanner.nextLine();

        System.out.print("Introduce los artículos que deseas comprar: ");
        String articulos = scanner.nextLine();

        Cliente cliente = new Cliente(nombre, direccion);

        Pedido pedido = new Pedido(cliente, numeroPedido++, articulos);

        System.out.print("Selecciona el método de pago (1 = Tarjeta, 2 = Efectivo): ");
        int metodoPagoSeleccionado = scanner.nextInt();
        String metodoPago = (metodoPagoSeleccionado == 1) ? "Tarjeta" : "Efectivo";

        int cantidad = 1000; 

        Pago pago = new Pago(pedido, metodoPagoSeleccionado, cantidad);

        Notificacion notificacion = new Notificacion(pedido, correo);

        System.out.println("\n--- Resumen del Pedido ---");
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Dirección: " + cliente.getDireccion());
        System.out.println("Correo: " + notificacion.getCorreo());
        System.out.println("Número de Pedido: " + pedido.getNumPedido());
        System.out.println("Artículos: " + pedido.getArticulos());
        System.out.println("Método de Pago: " + metodoPago);
        System.out.println("Cantidad: $" + pago.getCantidad());

        enviarCorreo(notificacion);
        
        scanner.close();
    }

    public static void enviarCorreo(Notificacion notificacion) {
        System.out.println("\nEnviando correo a " + notificacion.getCorreo() + "...");
        System.out.println("¡Correo enviado con éxito!");
    }

    // Clase Cliente
    public static class Cliente {
        private String nombre;
        private String direccion;

        // Constructor
        public Cliente(String nombre, String direccion) {
            this.nombre = nombre;
            this.direccion = direccion;
        }

        // Getters
        public String getNombre() {
            return nombre;
        }

        public String getDireccion() {
            return direccion;
        }

        // Setters
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }
    }

    // Clase Pedido
    public static class Pedido {
        private Cliente cliente;
        private int numPedido;
        private String articulos;

        // Constructor
        public Pedido(Cliente cliente, int numPedido, String articulos) {
            this.cliente = cliente;
            this.numPedido = numPedido;
            this.articulos = articulos;
        }

        // Getters
        public Cliente getCliente() {
            return cliente;
        }

        public int getNumPedido() {
            return numPedido;
        }

        public String getArticulos() {
            return articulos;
        }

        // Setters
        public void setCliente(Cliente cliente) {
            this.cliente = cliente;
        }

        public void setNumPedido(int numPedido) {
            this.numPedido = numPedido;
        }

        public void setArticulos(String articulos) {
            this.articulos = articulos;
        }
    }

    // Clase Pago
    public static class Pago {
        private Pedido pedido;
        private int metodoPago;
        private int cantidad;

        // Constructor
        public Pago(Pedido pedido, int metodoPago, int cantidad) {
            this.pedido = pedido;
            this.metodoPago = metodoPago;
            this.cantidad = cantidad;
        }

        // Getters
        public Pedido getPedido() {
            return pedido;
        }

        public int getMetodoPago() {
            return metodoPago;
        }

        public int getCantidad() {
            return cantidad;
        }

        // Setters
        public void setPedido(Pedido pedido) {
            this.pedido = pedido;
        }

        public void setMetodoPago(int metodoPago) {
            this.metodoPago = metodoPago;
        }

        public void setCantidad(int cantidad) {
            this.cantidad = cantidad;
        }
    }

    // Clase Notificacion
    public static class Notificacion {
        private Pedido pedido;
        private String correo;

        // Constructor
        public Notificacion(Pedido pedido, String correo) {
            this.pedido = pedido;
            this.correo = correo;
        }

        // Getters
        public Pedido getPedido() {
            return pedido;
        }

        public String getCorreo() {
            return correo;
        }

        // Setters
        public void setPedido(Pedido pedido) {
            this.pedido = pedido;
        }

        public void setCorreo(String correo) {
            this.correo = correo;
        }
    }
}
