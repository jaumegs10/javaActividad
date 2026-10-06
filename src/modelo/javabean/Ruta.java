package modelo.javabean;

import java.time.LocalDate;
import java.util.Objects;

public class Ruta {
	
	// Atributos
	private int idRuta;
	private LocalDate fecha;
	private String origen;
	private String destino;
	private Vehiculo vehiculoUsado;
	private Empleado empleado;
	private double kmRecorridos;
	private double cargaTransportada; // le quitamos los KG para poder cacular también las furgonetas
	
	
	// Metodos propios
	public boolean isCargaCorrecta() {
		 return this.cargaTransportada <= vehiculoUsado.cargaDisponible() ;
	}
	
	
	public void modificarKilometrosYConsumoVehiculo() { 
		vehiculoUsado.aumentarKilometraje(kmRecorridos); // Respecto al consumo del vehículo no entiendo qué hay que modificar
	}
	
	
	public String getOrigenDestino() {
		return "La ruta asignada es: " +origen + " - " +destino + " - " + kmRecorridos + "km";
	}
	
	
	public String tipoRuta() {
		if (this.kmRecorridos > 400) {
			return "Ruta Larga";
		}
		if (this.kmRecorridos > 100) {
			return "Ruta Media";
		}
		if (this.kmRecorridos > 0) {
			return "Ruta Corta";
		}
		else return "Ruta no válida";
	}
	
	
	public double calcularConsumoEstimado() {
		return this.kmRecorridos * vehiculoUsado.consumoLitros100km / 100;
	}


	
	// Metodos auxiliares
	public Ruta(int idRuta, LocalDate fecha, String origen, String destino, Vehiculo vehiculoUsado, Empleado empleado,
			double kmRecorridos, double cargaTransportada) {
		super();
		this.idRuta = idRuta;
		this.fecha = fecha;
		this.origen = origen;
		this.destino = destino;
		this.vehiculoUsado = vehiculoUsado;
		this.empleado = empleado;
		this.kmRecorridos = kmRecorridos;
		this.cargaTransportada = cargaTransportada;
	}


	public Ruta() {
		super();
	}


	public int getIdRuta() {
		return idRuta;
	}


	public void setIdRuta(int idRuta) {
		this.idRuta = idRuta;
	}


	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	public String getOrigen() {
		return origen;
	}


	public void setOrigen(String origen) {
		this.origen = origen;
	}


	public String getDestino() {
		return destino;
	}


	public void setDestino(String destino) {
		this.destino = destino;
	}


	public Vehiculo getVehiculoUsado() {
		return vehiculoUsado;
	}


	public void setVehiculoUsado(Vehiculo vehiculoUsado) {
		this.vehiculoUsado = vehiculoUsado;
	}


	public Empleado getEmpleado() {
		return empleado;
	}


	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}


	public double getKmRecorridos() {
		return kmRecorridos;
	}


	public void setKmRecorridos(double kmRecorridos) {
		this.kmRecorridos = kmRecorridos;
	}


	public double getCargaTransportada() {
		return cargaTransportada;
	}


	public void setCargaTransportada(double cargaTransportada) {
		this.cargaTransportada = cargaTransportada;
	}


	@Override
	public int hashCode() {
		return Objects.hash(idRuta);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Ruta))
			return false;
		Ruta other = (Ruta) obj;
		return idRuta == other.idRuta;
	}


	@Override
	public String toString() {
		return "Ruta [idRuta=" + idRuta + ", fecha=" + fecha + ", origen=" + origen + ", destino=" + destino
				+ ", vehiculoUsado=" + vehiculoUsado + ", empleado=" + empleado + ", kmRecorridos=" + kmRecorridos
				+ ", cargaTransportada=" + cargaTransportada + "]";
	}
	
	
	

}
