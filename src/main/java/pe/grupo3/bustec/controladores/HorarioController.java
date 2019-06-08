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

import pe.grupo3.bustec.modelos.Horario;
import pe.grupo3.bustec.repositories.HorarioRepository;
@CrossOrigin(origins = {"*"}, methods = {RequestMethod.GET,RequestMethod.POST,
		RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping(value = "/api/horarios/")
public class HorarioController {
	
	@Autowired
	 private HorarioRepository horarioRepository;

	@GetMapping(path = "/")
	public @ResponseBody List<Horario> imprimirHorarios() {
		return horarioRepository.findAll();
	}

	@GetMapping(path = "/{id}")
	public @ResponseBody Optional<Horario> buscarHorarioPorId(@PathVariable(name = "id") Long horario_id) {
		return horarioRepository.findById(horario_id);
	}
	
	@PostMapping(path = "/")
	public Horario crearHorario(@RequestBody Horario horario) {
		return horarioRepository.save(horario);
	}
	
	@PutMapping(path = "/{id}")
	public Horario editarHorario(@PathVariable(name = "id") Long horario_id, @RequestBody Horario horario) {
		Optional<Horario> horarioEncontrado = horarioRepository.findById(horario_id);
		
		Horario horarioActualizado = horarioEncontrado.get();
		horarioActualizado.setHora(horario.getHora());
		horarioActualizado.setTiempo(horario.getTiempo());
		return horarioRepository.save(horarioActualizado);
	}
	
	@DeleteMapping(path = "/{id}")
	public void eliminarHorario(@PathVariable(name = "id")Long horario_id) {
		horarioRepository.deleteById(horario_id);
	}
}

