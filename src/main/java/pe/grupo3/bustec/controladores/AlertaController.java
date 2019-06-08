package pe.grupo3.bustec.controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pe.grupo3.bustec.modelos.Alerta;
import pe.grupo3.bustec.repositories.AlertaRepository;
@CrossOrigin(origins = {"*"}, methods = {RequestMethod.GET,RequestMethod.POST,
		RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping(value = "/api/alertas/")
public class AlertaController {
	@Autowired
	private AlertaRepository alertaRepository;
	
	@GetMapping(path = "/")
	public @ResponseBody List<Alerta> imprimirAlertas(){
		return alertaRepository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	public @ResponseBody Optional<Alerta> buscarAlertaPorId(@PathVariable(name="id") Long alerta_id){
		return alertaRepository.findById(alerta_id);
	}
    
	@PostMapping(path = "/")
	public Alerta crearAlerta(@RequestBody Alerta alerta) {
		return alertaRepository.save(alerta);
	}
	
	@PutMapping(path="/{id}")
	public Alerta editarAlerta(@PathVariable(name="id") Long alerta_id,@RequestBody Alerta alerta) {
		Optional<Alerta> alertaEncontrado = alertaRepository.findById(alerta_id);
		Alerta alertaActualizado = alertaEncontrado.get();
		alertaActualizado.setMensaje(alerta.getMensaje());
		alertaActualizado.setViaje(alerta.getViaje());
		return alertaRepository.save(alertaActualizado);
	}
	
	@DeleteMapping(path = "/{id}")
	public void eliminarAlerta(@PathVariable(name="id") Long alerta_id) {
		alertaRepository.deleteById(alerta_id);
	}
}

