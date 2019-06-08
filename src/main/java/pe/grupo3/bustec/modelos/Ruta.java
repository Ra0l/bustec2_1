package pe.grupo3.bustec.modelos;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "rutas")
public class Ruta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "paradero_inicio_id", referencedColumnName = "id")
	private Paradero paraderoInicio;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "paradero_fin_id", referencedColumnName = "id")
	private Paradero paraderoFin;
	
	@JsonIgnore
	@OneToOne(mappedBy = "ruta")
	private Viaje viaje;

	public Ruta() {
		
	}

	public Ruta(Paradero paraderoInicio, Paradero paraderoFin, Viaje viaje) {
		super();
		this.paraderoInicio = paraderoInicio;
		this.paraderoFin = paraderoFin;
		this.viaje = viaje;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Paradero getParaderoInicio() {
		return paraderoInicio;
	}

	public void setParaderoInicio(Paradero paraderoInicio) {
		this.paraderoInicio = paraderoInicio;
	}

	public Paradero getParaderoFin() {
		return paraderoFin;
	}

	public void setParaderoFin(Paradero paraderoFin) {
		this.paraderoFin = paraderoFin;
	}

	public Viaje getViaje() {
		return viaje;
	}

	public void setViaje(Viaje viaje) {
		this.viaje = viaje;
	}

	@Override
	public String toString() {
		return "Ruta [id=" + id + ", paraderoInicio=" + paraderoInicio + ", paraderoFin=" + paraderoFin + ", viaje="
				+ viaje + "]";
	}
		
}
