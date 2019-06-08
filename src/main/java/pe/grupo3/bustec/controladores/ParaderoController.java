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

import pe.grupo3.bustec.modelos.Paradero;
import pe.grupo3.bustec.repositories.ParaderoRepository;
@CrossOrigin(origins = {"*"}, methods = {RequestMethod.GET,RequestMethod.POST,
		RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping(path = "/api/paraderos")
public class ParaderoController {
	
	@Autowired
	private ParaderoRepository paraderoRepository;
	
	@GetMapping(path = "/")
	public @ResponseBody List<Paradero> imprimirParaderos() {
		return paraderoRepository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	public @ResponseBody Optional<Paradero> buscarParaderoPorId(@PathVariable(name = "id") Long paradero_id) {
		return paraderoRepository.findById(paradero_id);
	}
	
	@PostMapping(path = "/")
	public Paradero crearParadero(@RequestBody Paradero paradero) {
		return paraderoRepository.save(paradero);
	}
	
	@PutMapping(path = "/{id}")
	public Paradero editarParadero(@PathVariable(name = "id") Long paradero_id, @RequestBody Paradero paradero) {
		Optional<Paradero> paraderoEncontrado = paraderoRepository.findById(paradero_id);
		
		Paradero paraderoActualizado = paraderoEncontrado.get();
		paraderoActualizado.setNombre(paradero.getNombre());
		paraderoActualizado.setUbicacion(paradero.getUbicacion());
		return paraderoRepository.save(paraderoActualizado);
	}
	@DeleteMapping(path = "/{id}")
	public void eliminarParadero(@PathVariable(name = "id") Long paradero_id) {
		paraderoRepository.deleteById(paradero_id);
	}

}

