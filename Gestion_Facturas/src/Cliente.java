
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Objects;

public class Cliente {
	private String dni;
	private String nombre;
	private String apellidos;
	private int descuento;
	private ArrayList<Pedido> pedidos;
	private LinkedHashMap<String, Factura> facturas;
	
	public Cliente(String dni, String nombre, String apellidos, int descuento) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.descuento = descuento;
		this.pedidos = new ArrayList<Pedido>();
		this.facturas = new LinkedHashMap<String, Factura>();
	}
	
	public Cliente() {
		this.pedidos = new ArrayList<Pedido>();
		this.facturas = new LinkedHashMap<String, Factura>();
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

	public LinkedHashMap<String, Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(LinkedHashMap<String, Factura> facturas) {
		this.facturas = facturas;
	}
	
	
	
	public void agregarNuevoPedido(String nombreProducto, int cantidad) {
		Pedido pedidoExistente = null;
	    for (Pedido pedido : pedidos) {
	        if (pedido.existeProductoPedido(nombreProducto)) {
	            pedidoExistente = pedido;
	        }   
	    }
		if(pedidoExistente != null) {
	    	pedidoExistente.aumentarCantidadProducto(nombreProducto, cantidad);
	    }else {    	
	    Pedido pedido = new Pedido(cantidad);
	    pedido.agregarProducto(nombreProducto, cantidad);
	    agregarPedidoAFactura(pedido);
	    
	    pedidos.add(pedido);
	    }

	}
	
	public void agregarPedidoAFactura(Pedido pedido) {
	    Factura factura = buscarUltimaFactura();
	    if (factura != null) {
	        factura.agregarPedido(pedido);
	    }
	}
	
	private Factura buscarUltimaFactura() {
	    Factura ultimaFactura = null;
	    for (Factura factura : facturas.values()) {
	        if (!factura.isEstaPagada()) {
	            ultimaFactura = factura;
	        }
	    }
	    return ultimaFactura;
	}
	
	public Factura buscarFactura(String numeroFactura) {
	    for (Factura factura : facturas.values()) {
	        if (factura.getFechaCreacion().equals(numeroFactura)) {
	            return factura;
	        }
	    }
	    return null;
	}
	
	public String mostrarFactura(String numFactura) {
		String resultado = "";
        for (Factura factura : facturas.values()) {
            if (factura.getFechaCreacion() == numFactura) {
                resultado = factura.mostrarFactura();
            }
        }
        return resultado;
    }
	
	public void almacenarFactura(Factura factura) {
		facturas.put(factura.getFechaCreacion(), factura);
	}
	
	public Factura crearFactura(Cliente cliente) {
		Factura factura = new Factura(cliente);
		
		return factura;
	}
	
	public String mostrarPedidos() {
		String resultado = "";
		for (Pedido pedido : pedidos) {
	        for (Producto producto : pedido.getProductos().values()) {
	        	resultado +=("\nProducto: ");
	            resultado+=(producto.getNombre());
	            resultado +=("\t\tCantidad: " + pedido.getCantidad());
	            resultado +=("\tPrecio " + producto.getPrecio());
	        }
		}
		return resultado;
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

	
	public String toString() {
		return nombre + " " + apellidos + mostrarPedidos();
	}
	
	
}