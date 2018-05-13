package br.com.cdcadmin.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cdcadmin.model.Autor;
import br.com.cdcadmin.service.AutorService;

@RestController
@RequestMapping("/autores")
public class AutorController {

	@Autowired
	private AutorService livroService;

	@PostMapping
	public ResponseEntity<Autor> criar(@RequestBody @Valid Autor livro) {
		return ResponseEntity.status(HttpStatus.CREATED).body(livroService.adicionaAutor(livro));
	}
	
	@GetMapping("")
	public ResponseEntity<List<Autor>> buscarTodos() {
		return  new ResponseEntity<List<Autor>>(livroService.buscarTodos(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Autor> buscarPeloCodigo(@PathVariable Long id) {
		Optional<Autor> livro = livroService.buscaPorId(id);
		return livro.isPresent() ? ResponseEntity.ok(livro.get()) : ResponseEntity.notFound().build();
	}

}
