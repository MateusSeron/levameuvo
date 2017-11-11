package br.levameuvo.EndPoint;

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
@RequestMapping("/endpoint")
public class EndPointController {
	
	@Autowired
	private EndPointRepository repo;
	
	@GetMapping
	public ResponseEntity<List<EndPoint>> obterTodos(){
		return ResponseEntity.ok().body(repo.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EndPoint> obterPeloId(@PathVariable String id){
		if(!repo.exists(id)){
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok().body(repo.findOne(id));
	}
	
	@PostMapping
	public ResponseEntity<String> incluir(@RequestBody EndPoint novoEndPoint){
		repo.save(novoEndPoint);
		return ResponseEntity.ok().body(novoEndPoint.getIdEndPoint());
	}
	
	@PutMapping
	public ResponseEntity<String> alterar(@RequestBody EndPoint novoEndPoint){
		if(!repo.exists(novoEndPoint.getIdEndPoint())){
			return ResponseEntity.notFound().build();
		}
		repo.save(novoEndPoint);
		return ResponseEntity.ok().body(novoEndPoint.getIdEndPoint());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable String id){
		repo.delete(id);
		return ResponseEntity.notFound().build();
	}
	
}
