package br.levameuvo.Localizacao;

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

import br.levameuvo.Usuario.UsuarioRespository;

@RestController
@RequestMapping("/localizacao")
public class LocalizacaoController {
	
	@Autowired
	private LocalizacaoRepository repo;

	@GetMapping
	public ResponseEntity<List<Localizacao>> getAll() {
		return ResponseEntity.ok().body(repo.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Localizacao> findOne(@PathVariable("idUsuario") String id){
		if(repo.exists(id)){
			return ResponseEntity.ok().body(repo.findOne(id));
		} else{
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public ResponseEntity<String> save(@RequestBody Localizacao l) {
		repo.save(l);
		return ResponseEntity.ok().body(l.getIdLocalizacao());
	}

	@PutMapping
	public ResponseEntity<String> update(@RequestBody Localizacao u) {
		
		if (!repo.exists(u.getIdLocalizacao())) {
			return ResponseEntity.notFound().build();
		} else {
			repo.save(u);
			return ResponseEntity.ok().body(u.getIdLocalizacao());
		}

	}
	
}
