package pe.grupo3.bustec.controladores;

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

import pe.grupo3.bustec.modelos.Viaje;
import pe.grupo3.bustec.repositories.ViajeRepository;
@CrossOrigin(origins = {"*"}, methods = {RequestMethod.GET,RequestMethod.POST,
		RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping(value = "/api/viajes")
public class ViajeController {
		@Autowired
		private ViajeRepository viajeRepository;
		
		@GetMapping(path = "/{id}")
		public @ResponseBody Optional<Viaje> imprimirViajesPorId(@PathVariable(name="id") Long viaje_id){
			return viajeRepository.findById(viaje_id);
		}
		
		@PostMapping(path = "/")
		public Viaje crearViaje(@RequestBody Viaje viaje) {
			return viajeRepository.save(viaje);
		}
		
		@PutMapping(path = "/{id}")
		public Viaje editarViaje(@PathVariable(name = "id")Long viaje_id,@RequestBody Viaje viaje) {
			Optional<Viaje>viajeEncontrado=viajeRepository.findById(viaje_id);
			Viaje viajeActualizado = viajeEncontrado.get();
			viajeActualizado.setBus(viaje.getBus());
			viajeActualizado.setConductor(viaje.getConductor());
			viajeActualizado.setHorario(viaje.getHorario());
			viajeActualizado.setRuta(viaje.getRuta());
			
			return viajeRepository.save(viajeActualizado);
		}
		@DeleteMapping(path = "/{id}")
		public void eliminarViaje(@PathVariable(name = "id")Long viaje_id) {
			viajeRepository.deleteById(viaje_id);
		}
}