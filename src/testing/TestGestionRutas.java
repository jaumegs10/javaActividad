package testing;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;


import modelo.dao.GestionRutas;
import modelo.javabean.Camion;
import modelo.javabean.Empleado;
import modelo.javabean.Furgoneta;
import modelo.javabean.Ruta;
import modelo.javabean.Vehiculo;

public class TestGestionRutas {
	

	public static void main(String[] args) {
		
		GestionRutas gestion = new GestionRutas();
		
		// Creamos las variables
		Empleado emp1 = new Empleado("44444444Y", "Jose", "García Jimenez", "jgj@gmail.com", "H");
		Empleado emp2 = new Empleado("55555555W", "Lucía", "Gonzalez Perez", "lgp@gmail.com", "M");	
				
		Camion camion1 = new Camion("0788KDI", "Mercedes", "Benz", 20_000, 5, 1000, 500, 2); 
		Vehiculo furgo1 = new Furgoneta("5216DSU", "Ford", "Transit", 10_000, 10, 100, 20);
				
		Ruta r1 = new Ruta(1, LocalDate.of(2026, 1, 1), "Barcelona", "Manresa", furgo1, emp1, 50, 60);
		Ruta r2 = new Ruta(2, LocalDate.of(2025, 6, 10), "Valencia", "Murcia", camion1, emp2, 350, 300);
		Ruta r3 = new Ruta(3, LocalDate.of(2025, 1, 1), "Barcelona", "Granada", camion1, emp1, 800, 200);

		
		// Añadimos las rutas
			System.out.println("AÑADIMOS RUTAS CREADAS");
			gestion.addRuta(r1);
			gestion.addRuta(r2);
			gestion.addRuta(r3);
			
			
		// Rutas por empleado
			System.out.println("\nRUTAS DEL EMPLEADO CON DNI: 44444444Y");
			List<Ruta> rutasEmp1 = gestion.rutasPorEmpleado("44444444Y");
			imprimirLista(rutasEmp1);
			
			System.out.println("\nRUTAS DEL EMPLEADO CON DNI: 55555555W");
			List<Ruta> rutasEmp2 = gestion.rutasPorEmpleado("55555555W");
			imprimirLista(rutasEmp2);
			
			
		// Rutas por Vehículo
			System.out.println("\nRUTAS DEL VEHÍCULO CON MATRÍCULA: 0788KDI");
			List<Ruta> rutasCam1 = gestion.rutasPorVehiculo("0788KDI");
			imprimirLista(rutasCam1);
			
			
		// Rutas por Destino
			System.out.println("\nRUTAS POR DESTINO: GRANADA");
			List<Ruta> rutasGrn = gestion.rutasPorDestino("Granada");
			imprimirLista(rutasGrn);
			
			
		// Rutas por fechas
			System.out.println("\nRUTAS POR FECHA: AÑO 2025");
			List<Ruta> rutas2025 = gestion.rutasIntervaloFechas(LocalDate.of(2025, 1, 1), LocalDate.of(2025, 12, 31));
			imprimirLista(rutas2025);
			
			
		// Total Km por Vehiculo
			System.out.println("\nTOTAL KM POR VEHÍCULO:");
			Map<String, Long> kmVehiculo = gestion.totalKmPorVehiculo();
			System.out.println(kmVehiculo);
			
			
		// Total Km por tipo vehiculo
			System.out.println("\nTOTAL KM POR TIPO DE VEHICULO");
			Map<String, Long> kmTipo = gestion.totalKmPorTipoVehiculo();
			System.out.println(kmTipo);
			
			
		// Eliminar rutas
			System.out.println("\nELIMINANDO RUTA 1 POR OBJETO");
			gestion.eliminarRuta(r1);
			
			System.out.println("\nELIMINANDO RUTA 2 POR ID");
			gestion.eliminarRuta(2);
			
			System.out.println("\nRUTAS RESTANTES:");
			imprimirLista(gestion.rutasPorEmpleado("44444444Y"));
			imprimirLista(gestion.rutasPorEmpleado("55555555W"));
			
			
		}
		
	// Método para imprimir los datos en consola
	public static void imprimirLista (List<Ruta> lista) {
		if (lista.isEmpty()) {
			System.out.println("La lista está vacía");
		}
		for (Ruta r: lista) {
			System.out.println(" - " +r);
	}
	
		
	}
	
	

}
	
