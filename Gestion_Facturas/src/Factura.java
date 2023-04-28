import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Factura {
	private String fechaCreacion;
	private Cliente cliente;
	private double total;
	private boolean estaPagada;
	private ArrayList<Pedido> pedidos;
	
	public Factura(String id, ArrayList<Pedido> pedidos, Cliente cliente, double total) {
		this.fechaCreacion = generarIdUnico();
		this.pedidos = pedidos;
		this.cliente = cliente;
		this.total = total;
	}
	public Factura(Cliente cliente) {
		this.fechaCreacion = generarIdUnico();
		this.cliente = cliente;
	}
	
	
	public boolean isEstaPagada() {
		return estaPagada;
	}
	public void setEstaPagada(boolean estaPagada) {
		this.estaPagada = estaPagada;
	}
	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	private String generarIdUnico() {
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("ddmmHHmm");
        String timestamp = ahora.format(formato);
        return timestamp;
    }
	
	public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }
	
	public String mostrarFactura() {
		String resultado = "";
		resultado += "\nNombre Cliente: " + cliente + "\nFactura Nr: " + fechaCreacion;
		return resultado;
	}
	
	@Override
	public String toString() {
		
		return "\nNombre Cliente: " + cliente + "\nFactura Nr: " + fechaCreacion;
	}
	
	
}
