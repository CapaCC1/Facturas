import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Objects;

public class Cliente {
	private String dni;
	private String nombre;
	private String apellidos;
	private int descuento;
	private ArrayList<Pedido> pedidos;
	private LinkedHashMap<LocalDateTime, Factura> facturas;
	
	public Cliente(String dni, String nombre, String apellidos, int descuento) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.descuento = descuento;
		this.pedidos = new ArrayList<Pedido>();
		this.facturas = new LinkedHashMap<LocalDateTime, Factura>();
	}
	
	public Cliente() {
		this.pedidos = new ArrayList<Pedido>();
		this.facturas = new LinkedHashMap<LocalDateTime, Factura>();
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellidos, dni, nombre);
	}

	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public LinkedHashMap<LocalDateTime, Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(LinkedHashMap<LocalDateTime, Factura> facturas) {
		this.facturas = facturas;
	}
	
	public void agregarNuevoPedido(int cantidad, String nombreProducto, Producto producto) {
		
		Pedido pedidoExistente = null;
	    for (Pedido pedido : pedidos) {
	        if (pedido.existeProductoPedido(producto)) {
	            pedidoExistente = pedido;
	        }
	        
	    }if(pedidoExistente != null) {
	    	pedidoExistente.aumentarCantidadProducto(producto, cantidad);
	    }else {
	    	Pedido pedido = new Pedido(cantidad);
	        pedido.agregarProducto(nombreProducto,producto,cantidad);
	        pedidos.add(pedido);
	    }	
    }
	
	
	public void mostrarPedidos() {
		for (Pedido pedido : pedidos) {
	        System.out.print("Cantidad: " + pedido.getCantidad());
	        System.out.print(" Productos:");
	        for (Producto producto : pedido.getProductos().values()) {
	            System.out.println(producto.getNombre() + " - " + producto.getPrecio());
	            
	        }
	    }
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(dni, other.dni);
	}

	@Override
	public String toString() {
		return "DNI: " + dni + "\nNombre: " + nombre + "\nApellidos: " + apellidos + "\nPedidos: " + pedidos;
	}
	
	
}