import java.util.ArrayList;
import java.util.HashMap;

public class Almacen {
	private ArrayList<Producto> productos;
	private HashMap<Producto, Integer> stock;
	
	public Almacen(ArrayList<Producto> productos, HashMap<Producto, Integer> stock) {
		this.productos = new ArrayList<Producto>();
		this.stock = new HashMap<Producto, Integer>();
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	public HashMap<Producto, Integer> getStock() {
		return stock;
	}

	public void setStock(HashMap<Producto, Integer> stock) {
		this.stock = stock;
	}
	
	
}
