import java.util.Scanner;

public class PruebaComercio {

	public static void main(String[] args) {
		Scanner in1 = new Scanner(System.in);
		
		Comercio amazon = new Comercio();
		
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
					System.out.println("Cliente Agregado con Exito!");
				}else if(codigo == 1) {
					System.out.println("\tERROR al Agregar Cliente!");
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
				amazon.incorporarProducto(nombreP, precioP, stock);
				
				
				
			}
		}

	}

}
