package testing;

import java.util.ArrayList;
import java.util.List;

import modelo.javabean.Camion;
import modelo.javabean.Furgoneta;
import modelo.javabean.Vehiculo;

public class TestHerencia {
	
	public static List<Vehiculo> vehiculos;

	public static void main(String[] args) {
		
		cargaDatos();
		listarTodos();
		mostrarCarga();
		
		

	}
	
	// Creamos los vehiculos
	public static void cargaDatos() {
		vehiculos = new ArrayList<Vehiculo>();
		Vehiculo camion1 = new Camion("0788KDI", "Mercedes", "Benz", 20_000, 5, 1000, 500, 2);
		Vehiculo camion2 = new Camion("4658OFP", "Volvo", "FH", 80_000, 10, 2000, 100, 4);
		Vehiculo camion3 = new Camion("65875SJE", "Scania", "R-Series", 150_000, 20, 1500, 1000, 6);
		Vehiculo furgo1 = new Furgoneta("5216DSU", "Ford", "Transit", 10_000, 10, 100, 20);
		Vehiculo furgo2 = new Furgoneta("15498OXL", "Mercedes", "Sprinter", 100_000, 8, 200, 50);
		Vehiculo furgo3 = new Furgoneta("36547P", "Volkswagen", "Transporter", 200_000, 20, 150, 120);
		
		vehiculos.add(camion1);
		vehiculos.add(camion2);
		vehiculos.add(camion3);
		vehiculos.add(furgo1);
		vehiculos.add(furgo2);
		vehiculos.add(furgo3);
	}
	
	
	// Imprimimos el listado de vehiculos creados
	public static void listarTodos() {
		System.out.println("LISTADO DE TODOS LOS VEHÍCULOS");
		for (Vehiculo ele : vehiculos) {
			System.out.println(ele);
		}
		}
	
	
	// Mostramos la carga y la carga disponible
	public static void mostrarCarga() {
		System.out.println("\nCAPACIDAD DE CARGA DE LOS VEHÍCULOS");
		for (Vehiculo ele : vehiculos) {
			if (ele instanceof Camion c) {
				System.out.println("\nLa capacidad de carga del camión con matrícula " +c.getMatricula() + " es " + c.getCapacidadCargaKg() + " KG");
				System.out.println("Los KG de carga disponible son " +c.cargaDisponible() + " KG");
				System.out.println("Y el % de carga ocupada es " +c.getPorcentajeCarga()+ " %");		
			}
			
			if (ele instanceof Furgoneta f) {
				System.out.println("\nLa capacidad de carga de la furgoneta con matrícula " +f.getMatricula() + " es " + f.getVolumenCargaM3() + " M3");
				System.out.println("Los M3 de carga disponible son " +f.cargaDisponible() + " M3");
				System.out.println("Y el % de carga ocupada es " +f.getPorcentajeCarga()+ " %");
			}
			}
		}
	}
	
	
	
	


