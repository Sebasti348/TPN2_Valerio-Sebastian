package ar.edu.unju.fi.ejercicio02.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio02.constantes.Mes;
import ar.edu.unju.fi.ejercicio02.model.Efemeride;

public class Main {
	public static List<Efemeride> efemerides = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
		int opcion = 0;
        do {
            try {
                System.out.println("Menú de opciones:");
                System.out.println("1 – Crear efemeride");
                System.out.println("2 – Mostrar efemeride");
                System.out.println("3 – Eliminar efemeride");
                System.out.println("4 – Modificar efemeride");
                System.out.println("5 – Salir");
                System.out.print("Elija una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); 

                switch (opcion) {
                    case 1:
                        crearEfemeride(efemerides);
                        break;
                    case 2:
                        mosEfemeride(efemerides);
                        break;
                    case 3:
                    	elimiEfemeride(efemerides);
                        break;
                    case 4:
                        modEfemeride(efemerides);
                        break;
                    case 5:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, intente de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número. Intente de nuevo.");
                scanner.next();
            } catch (IllegalArgumentException e) {
                System.out.println("Error: Opción no válida. " + e.getMessage());
            }
        } while (opcion != 5);
	}
			
	//CREA LA EFEMERIDE
	public static void crearEfemeride(List<Efemeride> efemeride){
		System.out.print("Ingrese la codigo: ");
        String codigo = scanner.nextLine();
        for (Mes meses : Mes.values()) {
            System.out.println((meses.ordinal() + 1) + " - " + meses);
        }
        System.out.print("Elija el nuevo mes: ");
        int opcionM = scanner.nextInt();
        Mes mes = Mes.values()[opcionM - 1];
        
        System.out.print("Ingrese el dia: ");
        Byte dia =scanner.nextByte();
        scanner.nextLine();
        System.out.print("Ingrese la detalles: ");
        String detalle = scanner.nextLine();
        
        Efemeride nuevoEfemeride = new Efemeride(codigo, mes, dia, detalle);
        efemerides .add(nuevoEfemeride);
        System.out.println("Producto creado exitosamente!");
	}
	//MUESTRA LA EFEMERIDE
	public static void mosEfemeride(List<Efemeride> efemeride) {
		if (efemerides.isEmpty()) {
	        System.out.println("No hay productos para mostrar.");
	    } else {
	        for (Efemeride efemerides : efemerides) {
	            System.out.println(efemerides);
	        }
	    }
	}
	//MODIFICA LA EFEMERIDE
	public static void modEfemeride(List<Efemeride> efemeride) {
		System.out.print("Ingrese el código del efemerides a modificar: ");
		String codigo = scanner.nextLine();
	    Efemeride efemerideEncontrado = null;
	    for (Efemeride efemeride2 : efemerides ) {
	        if (efemeride2.getCodigo().equals(codigo)) {
	            efemerideEncontrado = efemeride2;
	            break;
	        }
	    }
	    if (efemerideEncontrado != null) {
	        System.out.print("Ingrese la nuevo codigo: ");
	        efemerideEncontrado.setCodigo(scanner.nextLine()); 
	        
	        System.out.println("---- Origen de fabricación ------");
	        for (Mes meses : Mes.values()) {
	            System.out.println((meses.ordinal() + 1) + " - " + meses);
	        }
	        System.out.print("Elija el nuevo mes: ");
	        int nuevaMeses = scanner.nextInt();
	        Mes nuevoMeses = Mes.values()[nuevaMeses - 1];
	        efemerideEncontrado.setMes(nuevoMeses);
	        
	        System.out.print("Ingrese el nuevo dia: ");
	        efemerideEncontrado.setDia(scanner.nextByte());
	        scanner.nextLine();
	        System.out.print("Ingrese la nuevo detalles: ");
	        efemerideEncontrado.setDetalle(scanner.nextLine());
	        System.out.println("Producto modificado exitosamente!");
	    } else {
	        System.out.println("Producto no encontrado.");
	    }
	}

	//ELIMINAR EFEMERIDE
	public static void elimiEfemeride(List<Efemeride> efemeride) {
        System.out.print("Ingrese el código de la efeméride a eliminar: ");
        String codigo = scanner.nextLine();
	    Efemeride efemerideAEliminar = null;
	    for (Efemeride efemeride2 : efemerides ) {
	        if (efemeride2.getCodigo().equals(codigo)) {
	        	efemerideAEliminar = efemeride2;
	            break;
	        }
	    }
        if (efemerideAEliminar != null) {
        	efemerides .remove(efemerideAEliminar);
            System.out.println("Efeméride eliminada con éxito.");
        } else {
            System.out.println("No se encontró una efeméride con ese código.");
        }
    }
	
	 
	}
	


