package pe.grupo3.bustec.modelos;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "horarios")
public class Horario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String hora;
	private String tiempo;
	
	@JsonIgnore
	@OneToOne(mappedBy = "horario")
	private Viaje viaje;
	
	public Horario() {
		
	}

	public Horario(String hora,String tiempo, Viaje viaje) {
		super();
		this.hora = hora;
		this.tiempo = tiempo;
		this.viaje = viaje;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTiempo() {
		return tiempo;
	}

	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}

	public Viaje getViaje() {
		return viaje;
	}

	public void setViaje(Viaje viaje) {
		this.viaje = viaje;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	@Override
	public String toString() {
		return "Horario [id=" + id + ", hora=" + hora + ", tiempo=" + tiempo + ", viaje=" + viaje + "]";
	}

	
	
}