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

import pe.grupo3.bustec.modelos.Ruta;
import pe.grupo3.bustec.repositories.RutaRepository;
@CrossOrigin(origins = {"*"}, methods = {RequestMethod.GET,RequestMethod.POST,
		RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping(path = "/api/rutas/")
public class RutaController {
	@Autowired
	private RutaRepository rutaRepository;
	
	@GetMapping(path = "/")
	public @ResponseBody List<Ruta> imprimirRutas(){
		return rutaRepository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	public @ResponseBody Optional<Ruta> buscarBusPorId(@PathVariable(name = "id") Long ruta_id){
		return rutaRepository.findById(ruta_id);
	}
	
	@PostMapping(path = "/")
	public Ruta crearRuta(@RequestBody Ruta ruta) {
		return rutaRepository.save(ruta);
	}
	
	@PutMapping(path = "/{id}")
	public Ruta editarRuta(@PathVariable(name = "id") Long ruta_id, @RequestBody Ruta ruta) {
		Optional<Ruta> rutaEncontrado = rutaRepository.findById(ruta_id);
		
		Ruta rutaActualizado = rutaEncontrado.get();
		rutaActualizado.setParaderoInicio(ruta.getParaderoInicio());
		rutaActualizado.setParaderoFin(ruta.getParaderoFin());
		return rutaRepository.save(rutaActualizado);
	}
	@DeleteMapping(path = "/{id}")
	public void eliminarRuta(@PathVariable(name = "id")Long ruta_id) {
		rutaRepository.deleteById(ruta_id);
	}
}
