package ar.edu.unju.fi.ejercicio01.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import ar.edu.unju.fi.ejercicio01.model.Producto;
import ar.edu.unju.fi.ejercicio01.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio01.model.Producto.Origen;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        ArrayList<Producto> listaProductos = new ArrayList<>();

        do {
            try {
                System.out.println("Menú de opciones:");
                System.out.println("1 – Crear Producto");
                System.out.println("2 – Mostrar productos");
                System.out.println("3 – Modificar producto");
                System.out.println("4 – Salir");
                System.out.print("Elija una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); 

                switch (opcion) {
                    case 1:
                        crearProducto(scanner, listaProductos);
                        break;
                    case 2:
                        mostrarProductos(listaProductos);
                        break;
                    case 3:
                        modificarProducto(scanner, listaProductos);
                        break;
                    case 4:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, intente de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número. Intente de nuevo.");
                scanner.next(); // Limpiar buffer
            } catch (IllegalArgumentException e) {
                System.out.println("Error: Opción no válida. " + e.getMessage());
            }
        } while (opcion != 4);

        scanner.close();
    }
    private static void crearProducto(Scanner scanner, ArrayList<Producto> listaProductos) {
        Producto prod = new Producto();

        System.out.print("Ingrese el código del producto: ");
        String codigo = scanner.nextLine();
        System.out.print("Ingrese la descripción del producto: ");
        String descripcion = scanner.nextLine();
        System.out.print("Ingrese el precio unitario del producto: ");
        double precioUnitario = scanner.nextDouble();
        scanner.nextLine(); 
        System.out.println("---- Origen de fabricación ------");
        System.out.print("1-ARGENTINA");
        System.out.print("2-CHINA");
        System.out.print("3-BRASIL");
        System.out.print("4-URUGUAY");
        System.out.print("Elija una opción: ");
        int opcionO = scanner.nextInt();
        Origen origenFabricacion = Origen.values()[opcionO - 1];
        System.out.println("------ Categoría ------");

        System.out.print("Elija una opción: ");
        System.out.print("1-TELEFONIA");
        System.out.print("2-INFORMATICA");
        System.out.print("3-ELECTROHOGAR");
        System.out.print("4-HERRAMIENTAS");
        int opcionC = scanner.nextInt();
        
        Categoria categoria = Categoria.values()[opcionC - 1];

        scanner.nextLine();
        listaProductos.add(prod);    
        System.out.println("Producto creado exitosamente!");
        prod.setCodigo(codigo);
        prod.setDesc(descripcion);
        prod.setPu(precioUnitario);
        prod.setOrigen(origenFabricacion);
        prod.setCategoria(categoria);
    }
    private static void mostrarProductos(ArrayList<Producto> listaProductos) {
        if (listaProductos.isEmpty()) {
            System.out.println("No hay productos para mostrar.");
        } else {
            for (Producto producto : listaProductos) {
                System.out.println(producto);
            }
        }
    }
    
    private static void modificarProducto(Scanner scanner, ArrayList<Producto> listaProductos) {
        System.out.print("Ingrese el código del producto a modificar: ");
        String codigo = scanner.nextLine();
        Producto productoEncontrado = null;
        for (Producto producto : listaProductos) {
            if (producto.getCodigo().equals(codigo)) {
                productoEncontrado = producto;
                break;
            }
        }

        if (productoEncontrado != null) {
            System.out.print("Ingrese la nueva descripción: ");
            productoEncontrado.setDesc(scanner.nextLine());
            System.out.print("Ingrese el nuevo precio unitario: ");
            productoEncontrado.setPu(scanner.nextDouble());
            scanner.nextLine(); 
            
            System.out.println("---- Origen de fabricación ------");
            for (Origen origen : Origen.values()) {
                System.out.println((origen.ordinal() + 1) + " - " + origen);
            }
            System.out.print("Elija el nuevo origen de fabricación: ");
            int nuevaOpcionOrigen = scanner.nextInt();
            Origen nuevoOrigen = Origen.values()[nuevaOpcionOrigen - 1];
            productoEncontrado.setOrigen(nuevoOrigen);

            System.out.println("------ Categoría ------");
            for (Categoria cat : Categoria.values()) {
                System.out.println((cat.ordinal() + 1) + " - " + cat);
            }
            System.out.print("Elija la nueva categoría: ");
            int nuevaOpcionC = scanner.nextInt();
            Categoria nuevaC = Categoria.values()[nuevaOpcionC - 1];
            productoEncontrado.setCategoria(nuevaC);

            scanner.nextLine();

            System.out.println("Producto modificado exitosamente!");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }




}
