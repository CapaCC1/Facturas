
public class Comercio {
	private Factura ultimaFactura;
	private Almacen almacen;
	
	public Comercio(Factura ultimaFactura, Almacen almacen) {
		super();
		this.ultimaFactura = ultimaFactura;
		this.almacen = almacen;
	}

	public Factura getUltimaFactura() {
		return ultimaFactura;
	}

	public void setUltimaFactura(Factura ultimaFactura) {
		this.ultimaFactura = ultimaFactura;
	}

	public Almacen getAlmacen() {
		return almacen;
	}

	public void setAlmacen(Almacen almacen) {
		this.almacen = almacen;
	}
	
	
	
}
