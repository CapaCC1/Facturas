
import java.util.LinkedHashMap;

public class Almacen {
	private LinkedHashMap<String, Producto> productos;
	private LinkedHashMap<Integer, Producto> stock;
	
	public Almacen(LinkedHashMap<Integer, Producto> stock) {
		this.stock = new LinkedHashMap<Integer, Producto>();
	}

	public LinkedHashMap<Integer, Producto> getStock() {
		return stock;
	}

	public void setStock(LinkedHashMap<Integer, Producto> stock) {
		this.stock = stock;
	}

	public LinkedHashMap<String, Producto> getProductos() {
		return productos;
	}

	public void setProductos(LinkedHashMap<String, Producto> productos) {
		this.productos = productos;
	}
	
	public boolean existeProducto(String nombre, double precio) {
		
		boolean existe = false;
		if(productos.containsKey(nombre)) {
			existe = true;
		}
		return existe;
	}
	
	public int agregarProductos(String nombre, double precio, int cantidad) {
		
		int codigo = -1;
		Producto producto = null;
		if(existeProducto(nombre, precio) && (producto == null)) {
			producto = new Producto(nombre,precio);
			stock.put(cantidad, producto);
			productos.put(nombre, producto);
			codigo = 0;
		}else {
			codigo = 1;
		}
		return codigo;
	}
	
}
