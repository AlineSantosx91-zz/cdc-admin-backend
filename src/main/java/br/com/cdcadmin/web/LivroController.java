package br.com.cdcadmin.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import br.com.cdcadmin.model.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.cdcadmin.model.Livro;
import br.com.cdcadmin.service.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroController {

	@Autowired
	private LivroService livroService;

	@PostMapping
	public ResponseEntity<Livro> criar(@RequestBody Livro livro) {
		return ResponseEntity.status(HttpStatus.CREATED).body(livroService.adicionaLivro(livro));
	}
	
	@GetMapping
	public ResponseEntity<List<Livro>> buscarTodos() {
		return new ResponseEntity<List<Livro>>(livroService.buscarTodos(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Livro> buscarPeloCodigo(@PathVariable Long id) {
		Optional<Livro> livro = livroService.buscaPorId(id);
		return livro.isPresent() ? ResponseEntity.ok(livro.get()) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Livro> alterarLivro(@RequestBody Livro livro, @PathVariable Long id) {
		return new ResponseEntity<Livro>(livroService.alterarLivro(livro, id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Livro> deletaLivro(@PathVariable Long id){
		return livroService.deletaLivro(id);
	}

}
