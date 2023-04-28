
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
			cliente = new Cliente(dni,nombre,apellidos,descuento);
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
	
	public String mostrarProductos() {
		return almacen.toString();
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
	
	public int generarPedido(String dniCliente, String nombreProducto, int cantidad) {
    int codigo = -1;
    Cliente cliente = clientes.get(dniCliente);
    if (cliente != null) {
            int stockActual = almacen.consultaStock(nombreProducto);
            if (stockActual >= cantidad) {
                cliente.agregarNuevoPedido(nombreProducto, cantidad);
                almacen.actualizarStock(nombreProducto, cantidad);
                codigo = 0;
                cliente.mostrarPedidos();
            } else {
                codigo = 1;
            }
    } else {
        codigo = 2;
    }
    return codigo;
}	
	public String generarFactura(String dni) {
		String resultado = "";
		Cliente cliente = buscaCliente(dni);
		if(cliente == null) {
			resultado += "El Cliente NO Existe!";
		}else if(cliente.getPedidos().isEmpty()) {
			resultado+= "El Pedido esta Vacio!";
		}else {
			Factura factura = cliente.crearFactura(cliente);
			cliente.almacenarFactura(factura);
			resultado+="La Factura se a Generado Correctamente con Numero: " + factura.getFechaCreacion();
		}
		return resultado;
	}
	
	public String mostrarFactura(String numFactura) {
		String resultado = "";
	    for (Cliente cliente : clientes.values()) {
	        Factura factura = cliente.buscarFactura(numFactura);
	        if (factura != null) {
	            resultado += ("Factura nº: " + numFactura);
	            resultado +=("Cliente: " + cliente.getNombre() + " " + cliente.getApellidos());
	            factura.mostrarFactura(); 
	        }
	    }
	    resultado +=("La factura nº " + numFactura + " no existe.");
	    return resultado;
	}
		
	@Override
	public String toString() {
		return almacen.toString();
	} 
	
	
}