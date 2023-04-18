import java.util.LinkedHashMap;

public class Pedido {
	private int cantidad;
	private LinkedHashMap<String,Producto> productos;

	public Pedido(int cantidad, LinkedHashMap<String, Producto> productos) {
		super();
		this.cantidad = cantidad;
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
	
	
}
