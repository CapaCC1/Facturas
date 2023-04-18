
import java.util.HashMap;

public class Comercio {
	private Almacen almacen;
	private HashMap<String, Cliente> clientes;
	
	public Comercio(Almacen almacen, HashMap<String, Cliente> clientes) {
		this.almacen = almacen;
		this.clientes = new HashMap<String, Cliente>();
	}
	
	public Comercio() {
		this.clientes = new HashMap<String, Cliente>();
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
	
	public boolean clienteExiste(String dni) {
		boolean resultado = false;
		if(clientes.containsKey(dni)) {
			resultado = true;;
		}
		return resultado;
	}
	
	public Cliente buscaCliente(String dni) {
		
		Cliente cliente = clientes.get(dni);
		
		return cliente;
	}
	
	public int agregarCliente(String nombre,String apellidos,String dni, int descuento) {
		int codigo = -1;
		Cliente cliente = null;
		if(!clienteExiste(dni) && (cliente == null)) {
			cliente = new Cliente(nombre,apellidos,dni,descuento);
			clientes.put(dni, cliente);
			codigo = 0;
		}else {
			codigo = 1;
		}
		return codigo;
	}
	
	public void incorporarProducto(String nombre,double precio,int stock) {
		almacen.agregarProductos(nombre, precio,stock);
		
	}
	

}
