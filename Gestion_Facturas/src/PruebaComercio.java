import java.util.Scanner;

public class PruebaComercio {

	public static void main(String[] args) {
		Scanner in1 = new Scanner(System.in);
		
		Comercio amazon = new Comercio();
		/*amazon.agregarCliente("Paco", "Sainz", "1", 5);
		amazon.agregarCliente("Jesus", "Lopez", "2", 6);
		amazon.agregarCliente("Lucas", "Marco", "3", 7);
		amazon.agregarCliente("Eric", "Torices", "4", 8);
		
		amazon.incorporarProducto("Coca-Cola", 1.3, 5);
		amazon.incorporarProducto("Fanta", 1.2, 5);
		amazon.incorporarProducto("Lacasitos", 1.1, 5);
		amazon.incorporarProducto("Chuapa-Chups", 1, 5);*/
		boolean salir = true;
		while(salir) {
			
			System.out.println("\n\t\t-- PRUEBA COMERCIO --\n");
			System.out.println("\t1. Registrar Un Cliente");
			System.out.println("\t2. Incorporacion de Nuevos Productos al Almacen");
			System.out.println("\t3. Reposicion de Existencias de Productos");
			System.out.println("\t4. Generacion de Pedido con Control de Existencias");
			System.out.println("\t5. Generacion de una Factura");
			System.out.println("\t6. Visualizar por Pantalla una Factura");
			System.out.println("\t7. Visualizar las Facturas de un Cliente");
			System.out.println("\t8. Guardar una Factura en un Archivo");
			System.out.println("\t9. Salir\n");
			System.out.print("\tIntroduce una Opcion: ");
			int opcion = in1.nextInt();
			switch(opcion) {
			case 1:
				System.out.println("\n--REGISTRAR UN CLIENTE--\n");
				System.out.print("Introduzca el Nombre: ");
				String nombre = in1.next();
				System.out.print("Introduzca el Apellido: ");
				in1.nextLine();
				String apellidos = in1.nextLine();
				System.out.print("Introduzca el DNI: ");
				String dni = in1.next();
				System.out.print("Introduzca el Descuento Aplicable al Cliente: ");
				int descuento = in1.nextInt();
				int codigo = amazon.agregarCliente(nombre, apellidos, dni, descuento);
				if(codigo == 0) {
					System.out.println("\nCliente Agregado con Exito!");
				}else if(codigo == 1) {
					System.out.println("\nERROR al Agregar Cliente!");
				}
				break;
				
			case 2:
				System.out.println("\n--INCORPORAR PRODUCTOS--\n");
				System.out.print("Introduzca el Nombre del Producto: ");
				String nombreP = in1.next();
				System.out.print("Introduza el Precio: ");
				double precioP = in1.nextDouble();
				System.out.print("Introduzca la Cantidad: ");
				int stock = in1.nextInt();
				codigo = amazon.incorporarProducto(nombreP, precioP, stock);
				if(codigo == 0) {
					System.out.println("\nProducto Incorporado con EXITO!");
					
				}else if(codigo == 1) {
					System.out.println("\nERROR al Incorporar Producto!");
				}
				System.out.println(amazon.mostrarProductos());
				break;
				
			case 3:
				System.out.println("\n--REPONER STOCK--\n");
				System.out.print("Introduce el Nombre del Producto a Reponer: ");
				nombreP = in1.next();
				System.out.print("Introduce la Cantidad a Reponer: ");
				int cantidad = in1.nextInt();
				codigo = amazon.actualizarStock(nombreP, cantidad);
				if(codigo == 0) {
					System.out.println("\nStock Actualizado!");
				}else if(codigo == 1) {
					System.out.println("\nERROR El Producto No Existe!");
				}
				break;
			case 4:
				System.out.println("\n--GENERAR PEDIDO--\n");
				System.out.print("Introduce el DNI del Cliente: ");
				dni = in1.next();
				System.out.println(amazon.mostrarProductos());
				System.out.print("\nIntroduce el Producto que quieres Comprar: ");
				nombreP = in1.next();
				System.out.print("Introduce la cantidad a Comprar: ");
				cantidad = in1.nextInt();
				
				codigo = amazon.generarPedido(dni, nombreP, cantidad);
				if(codigo == 0) {
					 System.out.println("\nPedido generado correctamente.");
				}else if(codigo == 1) {
					System.out.println("\nNo hay suficiente stock del producto seleccionado.");
				}else if(codigo == 2) {
					System.out.println("\nNo existe un producto con ese nombre.");
				}else if(codigo == 3) {
					System.out.println("\nNo existe un cliente con ese DNI.");
				}
				break;
			}
		}

	}

}
