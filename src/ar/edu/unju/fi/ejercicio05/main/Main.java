package ar.edu.unju.fi.ejercicio05.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio01.model.Producto;
import ar.edu.unju.fi.ejercicio05.interfaces.Pago;
import ar.edu.unju.fi.ejercicio05.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio05.model.PagoTarjeta;

public class Main {
	public static void main(String[] args) {
        // Crear una lista de productos
   
        List<Producto> productos = new ArrayList<Producto>();
		List<Producto> ProductoDisponible = new ArrayList<Producto>();

		productos.add(new Producto("001", "Teléfono Móvil X1", 499.99, Producto.Origen.ARGENTINA, Producto.Categoria.TELEFONIA, false));
		productos.add(new Producto("002", "Laptop Pro 15", 1299.99, Producto.Origen.CHINA, Producto.Categoria.INFORMATICA, true));
		productos.add(new Producto("003", "Refrigerador Plus", 899.99, Producto.Origen.BRASIL, Producto.Categoria.ELECTROHOGAR, true));
		productos.add(new Producto("004", "Taladro Inalámbrico Z3", 249.99, Producto.Origen.URUGUAY, Producto.Categoria.HERRAMIENTAS, true));
		productos.add(new Producto("005", "Smartwatch 2.0", 199.99, Producto.Origen.ARGENTINA, Producto.Categoria.TELEFONIA, true));
		productos.add(new Producto("006", "Tablet Fire 8", 299.99, Producto.Origen.CHINA, Producto.Categoria.INFORMATICA, true));
		productos.add(new Producto("007", "Licuadora PowerMix", 99.99, Producto.Origen.BRASIL, Producto.Categoria.ELECTROHOGAR, true));
		productos.add(new Producto("008", "Set de Herramientas Basic", 149.99, Producto.Origen.URUGUAY, Producto.Categoria.HERRAMIENTAS, false));
		productos.add(new Producto("009", "Cámara de Seguridad HD", 199.99, Producto.Origen.CHINA, Producto.Categoria.INFORMATICA, true));
		productos.add(new Producto("010", "Aspiradora Robot V5", 499.99, Producto.Origen.BRASIL, Producto.Categoria.ELECTROHOGAR, true));
		productos.add(new Producto("011", "Smartphone Ultra 12", 999.99, Producto.Origen.ARGENTINA, Producto.Categoria.TELEFONIA, false));
		productos.add(new Producto("012", "Monitor Gamer Curvo 27'", 399.99, Producto.Origen.CHINA, Producto.Categoria.INFORMATICA, true));
		productos.add(new Producto("013", "Microondas QuickCook", 199.99, Producto.Origen.BRASIL, Producto.Categoria.ELECTROHOGAR, true));
		productos.add(new Producto("014", "Sierra Circular 7\"", 129.99, Producto.Origen.URUGUAY, Producto.Categoria.HERRAMIENTAS, true));
		productos.add(new Producto("015", "Auriculares Bluetooth BeatX", 59.99, Producto.Origen.CHINA, Producto.Categoria.TELEFONIA, false));

		filtrar(productos, ProductoDisponible);

		Scanner scanner = new Scanner(System.in);
       

       
        boolean salir = false;

        while (!salir) {
            System.out.println("1 – Mostrar productos");
            System.out.println("2 – Realizar compra");
            System.out.println("3 – Salir");
            int opc =0;
             opc = scanner.nextInt();

            switch (opc) {
                case 1:
                    	
                    		System.out.println("Productos Disponibles");
                    		for(Producto producto:productos) {
                    			System.out.println("Código: " + producto.getCodigo());
                    	        System.out.println("Descripción: " + producto.getDesc());
                    	        System.out.printf("Precio: $%.2f\n", producto.getPu());
                    	        System.out.println("Origen: " + producto.getOrigen());
                    	        System.out.println("Categoría: " + producto.getCategoria());
                    	        System.out.println();
                    	}
                    	
                    break;
                case 2:
                    RealizarCompra(scanner, ProductoDisponible);
                    break;
                case 3:
                	System.out.println("Saliendo .....");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción del menú.");
            }
        }

        scanner.close();
    }
	private static void filtrar(List<Producto>productos,List<Producto>ProductosDisponibles) {
		for(Producto producto:productos) {
			if(producto.isEstado()) {
				ProductosDisponibles.add(producto);
			}
		}
	}
	private static void  RealizarCompra (Scanner scanner,List<Producto> productos) {
		List<Producto> CarritoDeCompras = new ArrayList<Producto>();
	    double monto = 0;
		String opcion;
		do {
			System.out.println();
		    System.out.println("  Monto total:" + monto );
		    System.out.println("  1 - Agregar un producto");
		    System.out.println("  2 - Pago efectivo(10% de descuento)");
		    System.out.println("  3 - Pago con tarjeta(15% de recarga)");
		    System.out.println("  4 - Cancelar");
		    System.out.print("  Ingrese una opción: ");
		    opcion = scanner.nextLine();

		    switch (opcion) {
			    case "1":
			    	System.out.print("  Ingrese el codigo del producto: ");
			    	Producto producto=BuscarProducto(productos,scanner.nextLine());
			    	if(producto!=null) {
			    		monto += producto.getPu();
			    		System.out.println("  Producto agregado al carrito. Total hasta ahora: $" + monto);
			    	}
			    	else {
			    		System.out.println("  No existe el producto.");	
			    	}
			        break;
			    case "2":
			    	PE(monto);
			    	CarritoDeCompras.clear();
			    	monto = 0;
			        break;
			    case "3":
			    	PT(scanner,monto);
			    	CarritoDeCompras.clear();
			    	monto = 0;
			        break;
			    case "4":
			        System.out.println("  Compra cancelada");
			        break;
			    default:
			        System.out.println("  Opción inválida. Intente nuevamente.");
		    	} 

		}while (!opcion.equals("4"));
	}


	private static Producto BuscarProducto(List<Producto>producto, String codigo) {
	    for (Producto productos : producto) {
	        if (productos.getCodigo().equals(codigo)) {
	            return productos;
	        }
	    }
		return null;
	}
	private static void PT(Scanner scanner , Double monto) {
		System.out.print("  Escriba el número de su tarjeta:");
		PagoTarjeta pago = new PagoTarjeta(scanner.nextLine(),LocalDate.now());
		pago.realizarPago(monto);
		pago.imprimirRecibo();
	}


	private static void PE(Double monto) {
		PagoEfectivo pago = new PagoEfectivo(LocalDate.now());
		pago.realizarPago(monto);
		pago.imprimirRecibo();
	 }
}
