package br.levameuvo.Atendimento;

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
@RequestMapping("/atendimento")
public class AtendimentoController {
	
	@Autowired
	private AtendimentoRepository repo;
	
	@GetMapping
	public ResponseEntity<List<Atendimento>> obterTodos(){
		return ResponseEntity.ok().body(repo.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Atendimento> obterPeloId(@PathVariable String id){
		Atendimento novo = repo.findOne(id);
		if(novo == null){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(repo.findOne(id));
	}
	
	@PostMapping
	public ResponseEntity<String> incluir(@RequestBody Atendimento novoAtendimento){
		repo.save(novoAtendimento);
		return ResponseEntity.ok().body(novoAtendimento.getIdAtendimento());
	}
	
	@PutMapping
	public ResponseEntity<String> alterar(@RequestBody Atendimento novoAtendimento){
		
		if(!repo.exists(novoAtendimento.getIdAtendimento())){
			return ResponseEntity.notFound().build();
		}
		
		repo.save(novoAtendimento);
		return ResponseEntity.ok().body(novoAtendimento.getIdAtendimento());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable String id){
		repo.delete(id);
		return ResponseEntity.ok().build();
	}
	
}
