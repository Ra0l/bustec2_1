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

import pe.grupo3.bustec.modelos.Usuario;
import pe.grupo3.bustec.repositories.UsuarioRepository;
@CrossOrigin(origins = {"*"}, methods = {RequestMethod.GET,RequestMethod.POST,
		RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping(path = "/api/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping(path = "/")
	public @ResponseBody List<Usuario> imprimirUsuarios() {
		return usuarioRepository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	public @ResponseBody Optional<Usuario> buscarUsuarioPorId(@PathVariable(name = "id") Long usuario_id) {
		return usuarioRepository.findById(usuario_id);
	}
	
	@PostMapping(path = "/")
	public Usuario crearUsuario(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	@PutMapping(path = "/{id}")
	public Usuario editarUsuario(@PathVariable(name = "id") Long usuario_id, @RequestBody Usuario usuario) {
		Optional<Usuario> usuarioEncontrado = usuarioRepository.findById(usuario_id);
		
		Usuario usuarioActualizado = usuarioEncontrado.get();
		usuarioActualizado.setNombre(usuario.getNombre());
		usuarioActualizado.setApellido(usuario.getApellido());
		usuarioActualizado.setCorreo(usuario.getCorreo());
		usuarioActualizado.setToken(usuario.getToken());
		return usuarioRepository.save(usuarioActualizado);
	}
	@DeleteMapping(path = "/{id}")
	public void eliminarUsuario(@PathVariable(name = "id") Long usuario_id) {
		usuarioRepository.deleteById(usuario_id);
	}
}

