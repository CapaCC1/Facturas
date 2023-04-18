import java.time.LocalDateTime;
import java.util.ArrayList;

public class Factura {
	private LocalDateTime fechaCreacion;
	private Cliente cliente;
	private double total;
	private ArrayList<Pedido> pedidos;
	
	public Factura(String id, ArrayList<Pedido> pedidos, Cliente cliente, double total) {
		this.fechaCreacion = LocalDateTime.now();
		this.pedidos = pedidos;
		this.cliente = cliente;
		this.total = total;
	}
	
	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
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
	
	
}
