import java.util.LinkedHashMap;

public class Pedido {
	private int cantidad;
	private LinkedHashMap<String,Producto> productos;

	public Pedido(int cantidad, LinkedHashMap<String, Producto> productos) {
		this.cantidad = cantidad;
		this.productos = new LinkedHashMap<String, Producto>();
	}
	
	public Pedido(int cantidad) {
		this.cantidad = 0;
		this.productos = new LinkedHashMap<String, Producto>();
	}
	
	public Pedido() {
		this.cantidad = 0;
		this.productos = new LinkedHashMap<String, Producto>();
	}
	
	public LinkedHashMap<String, Producto> getProductos() {
		return productos;
	}

	public void setProductos(LinkedHashMap<String, Producto> productos) {
		this.productos = productos;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public void agregarProducto(String nombreProducto, int cantidad, double precio) {
		Producto nuevoProducto = new Producto(nombreProducto,precio);
		productos.put(nombreProducto, nuevoProducto);
		aumentarCantidadProducto(nombreProducto, cantidad);
	    }
	
	public void aumentarCantidadProducto(String nombre, int cantidad) {
		int cantidadActual = 0;
		Producto producto = buscarProductoPedido(nombre);
	    for (Producto pc : productos.values()) {
	        if(pc.equals(producto)) {
	        	cantidadActual = getCantidad();
	        	setCantidad(cantidadActual + cantidad);
	        }
	    }
	}
	
	public Producto buscarProductoPedido(String nombre) {
		
		Producto producto = productos.get(nombre);
		return producto;
	}
	
	public boolean existeProductoPedido(String nombre) {
		
		Producto producto = buscarProductoPedido(nombre);
		
		    for (Producto p : productos.values()) {
		        if (p.equals(producto)) {
		            return true;
		        }
		    }
		    return false;
		}
	
	@Override
	public String toString() {
		return "Producto: " + productos + "\nCantidad: " + cantidad;
	}
	
	
	
}