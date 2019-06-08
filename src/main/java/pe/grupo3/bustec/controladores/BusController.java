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

import pe.grupo3.bustec.modelos.Bus;
import pe.grupo3.bustec.repositories.BusRepository;
@CrossOrigin(origins = {"*"}, methods = {RequestMethod.GET,RequestMethod.POST,
		RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping(value = "/api/buses/")
public class BusController {
	
	@Autowired
	private BusRepository busRepository;
	
	@GetMapping(path = "/")
	public @ResponseBody List<Bus> imprimirBuses(){
		return busRepository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	public @ResponseBody Optional<Bus> buscarBusPorId(@PathVariable (name="id") Long bus_id){
		return busRepository.findById(bus_id);
	}
	
	@PostMapping(path = "/")
	public Bus crearBus(@RequestBody Bus bus) {
		return busRepository.save(bus);
	}
	
	@PutMapping(path = "/{id}")
	public Bus editarBus(@PathVariable(name = "id")Long bus_id,@RequestBody Bus bus ) {
		Optional<Bus> busEncontrado = busRepository.findById(bus_id);
		
		Bus busActualizado=busEncontrado.get();
		busActualizado.setImagen(bus.getImagen());
		busActualizado.setPlaca(bus.getPlaca());
		return busRepository.save(busActualizado);
	}
	
	@DeleteMapping(path = "/{id}")
	public void eliminarBus(@PathVariable(name="id")Long bus_id) {
		busRepository.deleteById(bus_id);
	}

}
