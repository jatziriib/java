 public class prueba {
    public static void main(String[] args) {
        System.out.println("hello world");
    }
}
public class cliente {
    private String nombre;
    private String direccion_envio;
    public cliente(String nombre,String direccion_envio ) {
        this.nombre=nombre;
        this.direccion_envio=direccion_envio;
        

    }    
}
public class pedido {
    private cliente cliente;
    private Int num_pedido;
    private Int articulos; 
    public pedido(int num_pedido, int articulos, String cliente){
        this.cliente=cliente;
        this.num_pedido=num_pedido;
        this.articulos=articulos;
    }
}
public class pago {
    private pedido pedido;
    private String metodo_de_pago;
    private Int cantidad;
    public pago(Int pedido, String metodo_de_pago, String cantidad){
        this.pedido=pedido;
        this.metodo_de_pago=metodo_de_pago;
        this.cantidad=cantidad;
    }
}
public class notificacion {
    private pedido pedido;
    private String correo;
    public notificacion(Int pedido, String correo){
        this.pedido=pedido;
        this.correo=correo;
    }
    
}