import java.util.ArrayList;

public class Factura {
	private Cliente cliente;
	private ArrayList<Pedido>pedidos;
	private double total;
	
	public Factura(Cliente cliente, ArrayList<Pedido> pedidos, double total) {
		this.cliente = cliente;
		this.pedidos = pedidos;
		this.total = total;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	
}
