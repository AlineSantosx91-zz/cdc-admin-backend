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
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "false")
public class LivroController {

	@Autowired
	private LivroService livroService;

	@PostMapping
	public ResponseEntity<Livro> criar(@RequestBody @Valid Livro livro) {
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

	@GetMapping("/{id}/autor")
	public ResponseEntity<Autor> buscarAutorDoLivro(@PathVariable Long id) {
		return new ResponseEntity<Autor>( livroService.buscarAutorDoLivro(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Livro> alterarLivro(@RequestBody @Valid Livro livro, @PathVariable Long id) {
		return  new ResponseEntity<Livro>(livroService.alterarLivro(livro, id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Livro> deletaLivro(@PathVariable Long id){
		final Optional<Livro> livro = livroService.buscaPorId(id);
		if(livro == null){
			return new ResponseEntity<Livro>(HttpStatus.NOT_FOUND);
		}

		livroService.deletaLivro(id);
		return new ResponseEntity<Livro>(livro.get(), HttpStatus.NO_CONTENT);
	}

}
