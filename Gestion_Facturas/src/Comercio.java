
import java.util.HashMap;

public class Comercio {
	private Almacen almacen;
	private HashMap<String, Cliente> clientes;
	private HashMap<String, Factura> facturas;
	
	public Comercio(Almacen almacen, HashMap<String, Cliente> clientes, HashMap<String, Factura> facturas) {
		this.almacen = almacen;
		this.clientes = new HashMap<String, Cliente>();
		this.facturas = new HashMap<String, Factura>();
	}

	public HashMap<String, Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(HashMap<String, Cliente> clientes) {
		this.clientes = clientes;
	}

	public Almacen getAlmacen() {
		return almacen;
	}

	public void setAlmacen(Almacen almacen) {
		this.almacen = almacen;
	}

	public HashMap<String, Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(HashMap<String, Factura> facturas) {
		this.facturas = facturas;
	}

}
