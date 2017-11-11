package br.levameuvo.Atendente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/atendente")
public class AtendenteController {
	
	@Autowired
	private AtendenteRepository repo;
	
	@GetMapping
	public ResponseEntity<List<Atendente>> obterTodos(){
		return ResponseEntity.ok().body(repo.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Atendente> obterPeloId(@PathVariable String id){
		Atendente novoAtendente = repo.findOne(id);
		
		if (novoAtendente == null){
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok().body(repo.findOne(id));
	}
	
	@PostMapping
	public ResponseEntity<String> incluir(@RequestBody Atendente novoAtendente){
		repo.save(novoAtendente);
		return ResponseEntity.ok().body(novoAtendente.getIdAtendente());
	}
	
	@PutMapping
	public ResponseEntity<String> alterar(@RequestBody Atendente novoAtendente){
		
		if(!repo.exists(novoAtendente.getIdAtendente())){
			return ResponseEntity.notFound().build();
		}
		
		repo.save(novoAtendente);
		return ResponseEntity.ok().body(novoAtendente.getIdAtendente());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable String id){
		repo.delete(id);
		return ResponseEntity.ok().build();
	}
	
}
