
import java.util.HashMap;

public class Comercio {
	private Almacen almacen;
	private HashMap<String, Cliente> clientes;
	
	public Comercio(Almacen almacen, HashMap<String, Cliente> clientes) {
		this.almacen = almacen;
		this.clientes = new HashMap<String, Cliente>();
	}
	
	public Comercio() {
		this.almacen = new Almacen();
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
		
		if(!clienteExiste(dni)) {
			cliente = new Cliente(nombre,apellidos,dni,descuento);
			clientes.put(dni, cliente);
			codigo = 0;
		} else {
			codigo = 1;
		}
		return codigo;
	}
	
	public int incorporarProducto(String nombre,double precio,int stock) {
		int codigo = -1;
		if(!almacen.existeProducto(nombre)) {
			almacen.agregarProductos(nombre, precio,stock);
			codigo = 0;
		}else {
			codigo = 1;
		}
		
		return codigo;
	}
	
	public int actualizarStock(String nombre, int cantidad) {
		int codigo = -1;
		if(almacen.existeProducto(nombre)) {
			almacen.reponerStock(nombre, cantidad);
			codigo = 0;
		}else if(!almacen.existeProducto(nombre)){
			codigo = 1;
		}else if(almacen == null) {
			codigo = 2;
		}
		return codigo;
	}

}
