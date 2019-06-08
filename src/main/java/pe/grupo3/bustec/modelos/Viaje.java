package pe.grupo3.bustec.modelos;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "viajes")
public class Viaje {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bus_id", referencedColumnName = "id")
	private Bus bus;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "conductor_id", referencedColumnName = "id")
	private Conductor conductor;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "horario_id", referencedColumnName = "id")
	private Horario horario;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ruta_id", referencedColumnName = "id")
	private Ruta ruta;

	public Viaje() {
		
	}

	public Viaje(Bus bus, Conductor conductor, Horario horario, Ruta ruta) {
		super();
		this.bus = bus;
		this.conductor = conductor;
		this.horario = horario;
		this.ruta = ruta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public Conductor getConductor() {
		return conductor;
	}

	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public Ruta getRuta() {
		return ruta;
	}

	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}

	@Override
	public String toString() {
		return "Viaje [id=" + id + ", bus=" + bus + ", conductor=" + conductor + ", horario=" + horario + ", ruta="
				+ ruta + "]";
	}
	
}
