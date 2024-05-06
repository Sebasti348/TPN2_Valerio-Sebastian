package ar.edu.unju.fi.ejercicio04.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio04.constantes.Posicion;
import ar.edu.unju.fi.ejercicio04.model.Jugador;

public class Main {
	public static void main(String[] args) {
        List<Jugador> jugadores = new ArrayList();
        Scanner scanner = new Scanner(System.in);
        int opcion=0;

        do {
            try {
                System.out.println("1 – Alta de jugador");
                System.out.println("2 – Mostrar todos los jugadores.");
                System.out.println("3 – Modificar la posición de un jugador");
                System.out.println("4 – Eliminar un jugador");
                System.out.println("5 – Salir.");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                    	altaJugador(jugadores,scanner);
                        break;
                    case 2:
                        mostrarJugadores(jugadores);
                        break;
                    case 3:
                        modJugador(jugadores, scanner);
                        break;
                    case 4:
                       eliminarJugador(jugadores, scanner);
                        break;
                }
            } catch (Exception e) {
                System.out.println("Ha ocurrido un error: " + e.getMessage());
            } finally {
                System.out.println("Fin de la operación.");
            }
        } while (opcion != 5);
    }
	public static void altaJugador(List<Jugador> jugadores, Scanner scanner) {
	    try {
	        System.out.println("Ingrese el nombre del jugador:");
	        String nombre = scanner.next();
	        System.out.println("Ingrese el apellido del jugador:");
	        String apellido = scanner.next();
	        System.out.println("Ingrese la fecha de nacimiento del jugador (formato: YYYY-MM-DD):");
	        String fechaNacimiento = scanner.next();
	        System.out.println("Ingrese la nacionalidad del jugador:");
	        String nacionalidad = scanner.next();
	        System.out.println("Ingrese la estatura del jugador:");
	        double estatura = scanner.nextDouble();
	        System.out.println("Ingrese el peso del jugador:");
	        double peso = scanner.nextDouble();
	        //Se debe colocar el Nombre de la posicion
	        System.out.println("Ingrese la posición del jugador (DELANTERO, MEDIO, DEFENSA, ARQUERO):");
	        String posicion = scanner.next();

	        Jugador jugador = new Jugador();
	        jugador.setNombre(nombre);
	        jugador.setApellido(apellido);
	        jugador.setFechaNacimiento(LocalDate.parse(fechaNacimiento));
	        jugador.setNacionalidad(nacionalidad);
	        jugador.setEstatura(estatura);
	        jugador.setPeso(peso);
	        jugador.setPosicion(Posicion.valueOf(posicion.toUpperCase()));

	        jugadores.add(jugador);

	        System.out.println("Jugador agregado exitosamente.");
	    } catch (Exception e) {
	        System.out.println("Ha ocurrido un error al agregar el jugador: " + e.getMessage());
	    }
	
	}

	public static void mostrarJugadores(List<Jugador> jugadores) {
	    try {
	        if (jugadores.isEmpty()) {
	            System.out.println("No hay jugadores para mostrar.");
	        } else {
	            for (Jugador jugador : jugadores) {
	                System.out.println("Nombre: " + jugador.getNombre());
	                System.out.println("Apellido: " + jugador.getApellido());
	                System.out.println("Fecha de Nacimiento: " + jugador.getFechaNacimiento());
	                System.out.println("Nacionalidad: " + jugador.getNacionalidad());
	                System.out.println("Estatura: " + jugador.getEstatura());
	                System.out.println("Peso: " + jugador.getPeso());
	                System.out.println("Posición: " + jugador.getPosicion());
	                System.out.println("-------------------------");
	            }
	        }
	    } catch (Exception e) {
	        System.out.println("Ha ocurrido un error al mostrar los jugadores: " + e.getMessage());
	    }
	}
	public static void modJugador(List<Jugador> jugadores, Scanner scanner) {
	    try {
	        System.out.println("Ingrese el nombre del jugador a modificar:");
	        String nombre = scanner.next();
	        System.out.println("Ingrese el apellido del jugador a modificar:");
	        String apellido = scanner.next();

	        Jugador jugadorModificado = null;
	        for (Jugador jugador : jugadores) {
	            if (jugador.getNombre().equals(nombre) && jugador.getApellido().equals(apellido)) {
	                jugadorModificado = jugador;
	                break;
	            }
	        }

	        if (jugadorModificado != null) {
	            System.out.println("Ingrese la nueva fecha de nacimiento del jugador (formato: YYYY-MM-DD):");
	            String fechaNacimiento = scanner.next();
	            jugadorModificado.setFechaNacimiento(LocalDate.parse(fechaNacimiento));

	            System.out.println("Ingrese la nueva nacionalidad del jugador:");
	            String nacionalidad = scanner.next();
	            jugadorModificado.setNacionalidad(nacionalidad);

	            System.out.println("Ingrese la nueva estatura del jugador:");
	            double estatura = scanner.nextDouble();
	            jugadorModificado.setEstatura(estatura);

	            System.out.println("Ingrese el nuevo peso del jugador:");
	            double peso = scanner.nextDouble();
	            jugadorModificado.setPeso(peso);

	            System.out.println("Ingrese el número de la nueva posición del jugador (1-DELANTERO, 2-MEDIO, 3-DEFENSA, 4-ARQUERO):");
	            int posicion = scanner.nextInt();
	            switch (posicion) {
	                case 1:
	                    jugadorModificado.setPosicion(Posicion.DELANTERO);
	                    break;
	                case 2:
	                    jugadorModificado.setPosicion(Posicion.MEDIO);
	                    break;
	                case 3:
	                    jugadorModificado.setPosicion(Posicion.DEFENSA);
	                    break;
	                case 4:
	                    jugadorModificado.setPosicion(Posicion.ARQUERO);
	                    break;
	                default:
	                    System.out.println("Número de posición no válido. Inténtalo de nuevo.");
	                    return;
	            }

	            System.out.println("Información del jugador modificada exitosamente.");
	        } else {
	            System.out.println("No se encontró al jugador con el nombre y apellido proporcionados.");
	        }
	    } catch (Exception e) {
	        System.out.println("Ha ocurrido un error al modificar el jugador: " + e.getMessage());
	    }
	}
	public static void eliminarJugador(List<Jugador> jugadores, Scanner scanner) {
	    try {
	        System.out.println("Ingrese el nombre del jugador a eliminar:");
	        String nombre = scanner.next();
	        System.out.println("Ingrese el apellido del jugador a eliminar:");
	        String apellido = scanner.next();

	        Jugador jugadorEliminado = null;
	        Iterator<Jugador> iterator = jugadores.iterator();
	        while (iterator.hasNext()) {
	            Jugador jugador = iterator.next();
	            if (jugador.getNombre().equals(nombre) && jugador.getApellido().equals(apellido)) {
	                jugadorEliminado = jugador;
	                iterator.remove();
	                break;
	            }
	        }

	        if (jugadorEliminado != null) {
	            System.out.println("Jugador eliminado exitosamente.");
	        } else {
	            System.out.println("No se encontró al jugador con el nombre y apellido proporcionados.");
	        }
	    } catch (Exception e) {
	        System.out.println("Ha ocurrido un error al eliminar el jugador: " + e.getMessage());
	    }
	}
}
	
