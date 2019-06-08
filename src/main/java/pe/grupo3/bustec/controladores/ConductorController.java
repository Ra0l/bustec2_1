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

import pe.grupo3.bustec.modelos.Conductor;
import pe.grupo3.bustec.modelos.Usuario;
import pe.grupo3.bustec.repositories.ConductorRepository;
@CrossOrigin(origins = {"*"}, methods = {RequestMethod.GET,RequestMethod.POST,
		RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping(path = "/api/conductores")
public class ConductorController {
	
	@Autowired
	private ConductorRepository conductorRepository;
	
	@GetMapping(path = "/")
	public @ResponseBody List<Conductor> imprimirConductores() {
		return conductorRepository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	public @ResponseBody Optional<Conductor> buscarConductorPorId(@PathVariable(name = "id") Long conductor_id) {
		return conductorRepository.findById(conductor_id);
	}
	
	@PostMapping(path = "/")
	public Conductor crearConductor(@RequestBody Conductor conductor) {
		return conductorRepository.save(conductor);
	}
	
	@PutMapping(path = "/{id}")
	public Conductor editarConductor(@PathVariable(name = "id") Long conductor_id, @RequestBody Usuario conductor) {
		Optional<Conductor> conductorEncontrado = conductorRepository.findById(conductor_id);
		
		Conductor conductorActualizado = conductorEncontrado.get();
		conductorActualizado.setNombre(conductor.getNombre());
		conductorActualizado.setApellido(conductor.getApellido());
		conductorActualizado.setCorreo(conductor.getCorreo());
		conductorActualizado.setToken(conductor.getToken());
		return conductorRepository.save(conductorActualizado);
	}
	
	@DeleteMapping(path = "/{id}")
	public void eliminarUsuario(@PathVariable(name = "id") Long usuario_id) {
		conductorRepository.deleteById(usuario_id); 
	}
}

