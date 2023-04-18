
import java.util.HashMap;

public class Almacen {
	private HashMap<Producto, Integer> stock;
	
	public Almacen(HashMap<Producto, Integer> stock) {
		this.stock = new HashMap<Producto, Integer>();
	}

	public HashMap<Producto, Integer> getStock() {
		return stock;
	}

	public void setStock(HashMap<Producto, Integer> stock) {
		this.stock = stock;
	}
	
	
}
