package br.levameuvo.Usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRespository repo;

	@GetMapping
	public ResponseEntity<List<Usuario>> getAll() {
		return ResponseEntity.ok().body(repo.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> findOne(@PathVariable("idUsuario") String id){
		if(repo.exists(id)){
			return ResponseEntity.ok().body(repo.findOne(id));
		} else{
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public ResponseEntity<String> save(@RequestBody Usuario u) {
		repo.save(u);
		return ResponseEntity.ok().body(u.getIdUsuario());
	}

	@PutMapping
	public ResponseEntity<String> update(@RequestBody Usuario u) {
		
		if (!repo.exists(u.getIdUsuario())) {
			return ResponseEntity.notFound().build();
		} else {
			repo.save(u);
			return ResponseEntity.ok().body(u.getIdUsuario());
		}

	}
}
