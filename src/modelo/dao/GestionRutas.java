package modelo.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelo.javabean.Camion;
import modelo.javabean.Furgoneta;
import modelo.javabean.Ruta;

public class GestionRutas implements IGestionRutas {
	
	// Atributo
	private List<Ruta> rutas;
	
	public GestionRutas() {
		this.rutas = new ArrayList<Ruta>();
	}
	

	// Metodos Interface 
	@Override
	public void addRuta(Ruta ruta) {
		if (!rutas.contains(ruta)) {
			rutas.add(ruta);
		}
	}

	@Override
	public void eliminarRuta(Ruta ruta) {
		rutas.remove(ruta);	
	}

	@Override
	public void eliminarRuta(int idRuta) {
		rutas.removeIf(ruta -> ruta.getIdRuta() == idRuta);		
	}

	@Override
	public List<Ruta> rutasPorEmpleado(String dni) {
		List<Ruta> rutasPorEmpleado = new ArrayList<Ruta>();
		for (Ruta ruta : rutas) {
			if (ruta.getEmpleado().getDni().equals(dni)) {
				rutasPorEmpleado.add(ruta);
			}
		}
		return rutasPorEmpleado;
	}

	@Override
	public List<Ruta> rutasPorVehiculo(String matricula) {
		List<Ruta> rutasPorVehiculo = new ArrayList <Ruta>();
		for (Ruta ruta : rutas) {
			if (ruta.getVehiculoUsado().getMatricula().equals(matricula)) {
				rutasPorVehiculo.add(ruta);
			}
		}
		return rutasPorVehiculo;
	}

	@Override
	public Map<String, Long> totalKmPorVehiculo() {
	    Map<String, Long> totalKmPorVehiculo = new HashMap<String, Long>();
	    for (Ruta ruta : rutas) {
	        String matricula = ruta.getVehiculoUsado().getMatricula();
	        long kmRuta = (long) ruta.getKmRecorridos();

	        if (totalKmPorVehiculo.containsKey(matricula)) {
	            totalKmPorVehiculo.put(matricula, totalKmPorVehiculo.get(matricula) + kmRuta);
	        } else {
	            totalKmPorVehiculo.put(matricula, kmRuta);
	        }
	    }
	    return totalKmPorVehiculo;
	}

	@Override
	public List<Ruta> rutasPorDestino(String destino) {
		List <Ruta> rutasPorDestino = new ArrayList<Ruta>();
		for (Ruta ruta : rutas) {
			if (ruta.getDestino().equalsIgnoreCase(destino)) {
				rutasPorDestino.add(ruta);
			}
		}
		return rutasPorDestino;
	}

	@Override
	public List<Ruta> rutasIntervaloFechas(LocalDate inicio, LocalDate fin) {
		List <Ruta> rutasIntervaloFechas = new ArrayList<Ruta>();
		for (Ruta ruta : rutas) {
			if (!ruta.getFecha().isBefore(inicio) && !ruta.getFecha().isAfter(fin)) {
			rutasIntervaloFechas.add(ruta);
			}
		}
		return rutasIntervaloFechas;
	}

	@Override
	public Map<String, Long> totalKmPorTipoVehiculo() {
	    Map<String, Long> totalKmPorTipoVehiculo = new HashMap<String, Long>();
	    for (Ruta ruta : rutas) {
	        String tipo = "";        
	        if (ruta.getVehiculoUsado() instanceof Camion) {
	            tipo = "CAMION";
	        } else if (ruta.getVehiculoUsado() instanceof Furgoneta) {
	            tipo = "FURGONETA";
	        }
	        
	        long kmRuta = (long) ruta.getKmRecorridos();
	        
	        if (totalKmPorTipoVehiculo.containsKey(tipo)) {
	            totalKmPorTipoVehiculo.put(tipo, totalKmPorTipoVehiculo.get(tipo) + kmRuta);
	        } else {
	            totalKmPorTipoVehiculo.put(tipo, kmRuta);
	        }
	    }
	    return totalKmPorTipoVehiculo;
	}
}
